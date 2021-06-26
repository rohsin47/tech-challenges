package uniworks.production.model;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import uniworks.production.dto.PrimalCutRun;
import uniworks.production.dto.PrimalCutRunMake;
import uniworks.production.model.PsMakeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PsMakeTest {

    private List<PrimalCutRun> primalCutRuns;

    @Before
    public void setUp() {
        primalCutRuns = new ArrayList<>();

        // Spec 1056, Primal CHUCK

        PrimalCutRun pcr = new PrimalCutRun(101, 1056, "CHUCK", 1, 0, 55);

        pcr.addMake(new PrimalCutRunMake(1011, 101, 1, "Whole Chuck", "3755", 11111, 55));

        primalCutRuns.add(pcr);

        pcr = new PrimalCutRun(102, 1056, "CHUCK", 2, 5, 40);

        pcr.addMake(new PrimalCutRunMake(1021, 102, 1, "Chuck Square Cut", "8223", 11112, 40));
        pcr.addMake(new PrimalCutRunMake(1022, 102, 1, "Chuck Roll End", "3890", 11113, 40));

        primalCutRuns.add(pcr);

        pcr = new PrimalCutRun(103, 1056, "CHUCK", 3, 95, 35);

        pcr.addMake(new PrimalCutRunMake(1031, 103, 1, "Chuck Roll", "5410", 11111, 35));
        pcr.addMake(new PrimalCutRunMake(1032, 103, 1, "Chuck Eye Roll", "8253", 11111, 35));

        primalCutRuns.add(pcr);

        pcr = new PrimalCutRun(104, 1056, "CHUCK", 4, 130, 60);

        pcr.addMake(new PrimalCutRunMake(1041, 104, 1, "Chuck Roll", "5410", 11112, 60));
        pcr.addMake(new PrimalCutRunMake(1042, 104, 1, "Chuck 3 Rib", "8384", 11113, 60));

        primalCutRuns.add(pcr);


        // Spec 1056, Primal RUMP

        pcr = new PrimalCutRun(105, 1056, "RUMP", 1, 0, 25);

        primalCutRuns.add(pcr);

        pcr = new PrimalCutRun(106, 1056, "RUMP", 2, 25, 80);

        primalCutRuns.add(pcr);

        pcr = new PrimalCutRun(107, 1056, "RUMP", 3, 105, 115);

        primalCutRuns.add(pcr);


        // Spec 1057, Primal CHUCK

        pcr = new PrimalCutRun(111, 1057, "CHUCK", 1, 0, 45);

        primalCutRuns.add(pcr);

        pcr = new PrimalCutRun(112, 1057, "CHUCK", 2, 45, 70);

        primalCutRuns.add(pcr);

        pcr = new PrimalCutRun(113, 1057, "CHUCK", 3, 115, 5);

        primalCutRuns.add(pcr);

        pcr = new PrimalCutRun(114, 1057, "CHUCK", 4, 120, 20);

        primalCutRuns.add(pcr);

        pcr = new PrimalCutRun(115, 1057, "CHUCK", 5, 140, 55);

        primalCutRuns.add(pcr);


        // Spec 1056, Primal RUMP

        pcr = new PrimalCutRun(115, 1057, "RUMP", 1, 0, 75);

        primalCutRuns.add(pcr);

        pcr = new PrimalCutRun(116, 1057, "RUMP", 2, 75, 50);

        primalCutRuns.add(pcr);

        pcr = new PrimalCutRun(117, 1057, "RUMP", 3, 125, 15);

        primalCutRuns.add(pcr);

        pcr = new PrimalCutRun(118, 1057, "RUMP", 4, 140, 65);

        primalCutRuns.add(pcr);

    }

    @Test
    public void _01_psMakeModelConstruction_shouldCreateModelWithTwoSpecs() {
        getModelSpecs(primalCutRuns);
    }

    @Test
    public void _02_psMakeModelConstruction_shouldCreateModelWithSpec1056() {
        getModelSpec1056(primalCutRuns);
    }

    @Test
    public void _03_psMakeModelConstruction_shouldCreateModelWithSpec1056withTwoPrimals() {
        getModelSpec1056Primals(primalCutRuns);
    }

    @Test
    public void _04_psMakeModelConstruction_shouldCreateModelWithSpec1056PrimalRUMP() {
        getModelSpec1056PrimalRump(primalCutRuns);
    }

    @Test
    public void _05_psMakeModelConstruction_shouldCreateModelWithSpec1056PrimalRUMPwith3CutRuns() {
        getModelSpec1056PrimalRumpCutRuns(primalCutRuns);
    }

    @Test
    public void _06_psMakeModelConstruction_shouldCreateModelWithSpec1056PrimalCHUCK() {
        getModelSpec1056PrimalChuck(primalCutRuns);
    }

    @Test
    public void _07_psMakeModelConstruction_shouldCreateModelWithSpec1056PrimalCHUCKwith6ProductCuts() {
        getModelSpec1056PrimalChuckProductCuts(primalCutRuns);
    }

    @Test
    public void _08_psMakeModelConstruction_shouldCreateModelWithSpec1056PrimalCHUCKwithProductCutChuckRoll() {
        getModelSpec1056PrimalChuckProductCutChuckRoll(primalCutRuns);
    }

    @Test
    public void _09_psMakeModelConstruction_shouldCreateModelWithSpec1056PrimalCHUCKProductCutChuckRollwith2Makes() {
        getModelSpec1056PrimalChuckProductCutChuckRollMakes(primalCutRuns);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private List<PsMakeProcessingSpecRowModel> getModelSpecs(List<PrimalCutRun> primalCutRuns) {
        PsMakeModel testPsMakeModel = new PsMakeModel(primalCutRuns);

        assertNotNull("Model should not have an empty list of Spec Row models",
                testPsMakeModel.getPsMakeProcessingSpecRowModels());

        assertFalse("Model should not have an empty list of Spec Row models",
                testPsMakeModel.getPsMakeProcessingSpecRowModels().isEmpty());

        assertEquals("Model should have two Processing Specs",
                testPsMakeModel.getPsMakeProcessingSpecRowModels().size(), 2);

        return testPsMakeModel.getPsMakeProcessingSpecRowModels();
    }

    private PsMakeProcessingSpecRowModel getModelSpec1056(List<PrimalCutRun> primalCutRuns) {
        List<PsMakeProcessingSpecRowModel> modelSpecs = getModelSpecs(primalCutRuns);

        Optional<PsMakeProcessingSpecRowModel> spec1056 = modelSpecs
                .stream()
                .filter(spec -> spec.getProcessingSpecNo().equals(1056))
                .findFirst();

        assertTrue("Spec 1056 should be present in the list", spec1056.isPresent());

        return spec1056.get();
    }

    private List<PsMakePrimalCutRowModel> getModelSpec1056Primals(List<PrimalCutRun> primalCutRuns) {
        PsMakeProcessingSpecRowModel spec1056 = getModelSpec1056(primalCutRuns);

        final List<PsMakePrimalCutRowModel> primals = spec1056.getPsMakePrimalCutRowModels();

        assertNotNull("Spec 1056 list of Primals should not be null", primals);

        assertFalse("Spec 1056 list of Primals should not be empty", primals.isEmpty());

        assertEquals("Spec 1056 should have 2 Primals", primals.size(), 2);

        return primals;
    }

    private PsMakePrimalCutRowModel getModelSpec1056PrimalRump(List<PrimalCutRun> primalCutRuns) {
        List<PsMakePrimalCutRowModel> primals = getModelSpec1056Primals(primalCutRuns);

        Optional<PsMakePrimalCutRowModel> primalRump = primals.stream()
                .filter(primal -> primal.getPrimalCutId().equals("RUMP"))
                .findFirst();

        assertTrue("Spec 1056 should have Primal RUMP", primalRump.isPresent());

        return primalRump.get();
    }

    private List<PsMakeCutRunModel> getModelSpec1056PrimalRumpCutRuns(List<PrimalCutRun> primalCutRuns) {
        PsMakePrimalCutRowModel primalRump = getModelSpec1056PrimalRump(primalCutRuns) ;

        assertNotNull("Spec 1056, Primal RUMP should have Cut Runs", primalRump.getPsMakeCutRunModels());

        assertEquals("Spec 1056, Primal RUMP should have 3 Cut Runs", primalRump.getPsMakeCutRunModels().size(), 3);

        return primalRump.getPsMakeCutRunModels();
    }

    private PsMakePrimalCutRowModel getModelSpec1056PrimalChuck(List<PrimalCutRun> primalCutRuns) {
        List<PsMakePrimalCutRowModel> primals = getModelSpec1056Primals(primalCutRuns);

        Optional<PsMakePrimalCutRowModel> primalRump = primals.stream()
                .filter(primal -> primal.getPrimalCutId().equals("CHUCK"))
                .findFirst();

        assertTrue("Spec 1056 should have Primal CHUCK", primalRump.isPresent());

        return primalRump.get();
    }

    private List<PsMakeProductCutRowModel> getModelSpec1056PrimalChuckProductCuts(List<PrimalCutRun> primalCutRuns) {
        PsMakePrimalCutRowModel primalChuck = getModelSpec1056PrimalChuck(primalCutRuns);

        List<PsMakeProductCutRowModel> chuckProductCuts = primalChuck.getPsMakeProductCutRowModels();

        assertNotNull("Spec 1056 Primal Chuck should have Product Cuts", chuckProductCuts);

        assertEquals("Spec 1056 Primal Chuck should have 6 Product Cuts", chuckProductCuts.size(), 6);

        return chuckProductCuts;
    }

    private PsMakeProductCutRowModel getModelSpec1056PrimalChuckProductCutChuckRoll(List<PrimalCutRun> primalCutRuns) {
        List<PsMakeProductCutRowModel> chuckProductCuts = getModelSpec1056PrimalChuckProductCuts(primalCutRuns);

        Optional<PsMakeProductCutRowModel> chuckRollProductCut = chuckProductCuts.stream()
                .filter(pc -> pc.getProductCutId().equals("Chuck Roll"))
                .findFirst();

        assertTrue("Spec 1056 Primal Chuck should have Product Cut Chuck Roll", chuckRollProductCut.isPresent());

        return chuckRollProductCut.get();
    }

    private List<PsMakeCutRunMakeModel> getModelSpec1056PrimalChuckProductCutChuckRollMakes(List<PrimalCutRun> primalCutRuns) {
        PsMakeProductCutRowModel chuckRollProductCut = getModelSpec1056PrimalChuckProductCutChuckRoll(primalCutRuns);

        List<PsMakeCutRunMakeModel> chuckRollMakes = chuckRollProductCut.getPsMakeCutRunMakeModels();

        assertNotNull("Spec 1056, Primal Chuck, Product Cut Chuck Roll should have Makes", chuckRollMakes);

        assertFalse("Spec 1056, Primal Chuck, Product Cut Chuck Roll should not have empty Make list", chuckRollMakes.isEmpty());

        assertEquals("Spec 1056, Primal Chuck, Product Cut Chuck Roll should not have 2 Makes", chuckRollMakes.size(), 2);

        return chuckRollMakes;
    }
}
