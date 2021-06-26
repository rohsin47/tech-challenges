package uniworks.production.model;

import uniworks.production.dto.PrimalCutRun;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class models the top tree nodes for each Processing Spec in the Make.
 */
public class PsMakeProcessingSpecRowModel {

    // The Processing Spec Number which will be displayed in the tree
    final private Integer processingSpecNo;

    // The list of sub-nodes for all the Primal Cuts within this Process Spec
    final private List<PsMakePrimalCutRowModel> psMakePrimalCutRowModels;

    // Link back to the parent node, if required
    final private PsMakeModel parentMakeModel;

    /**
     * Creats a model for a Processing Spec tree node.
     *
     * @param primalCutRunList List containing only the PrimalCutRun's for a single Processing Spec
     */
    public PsMakeProcessingSpecRowModel(Integer processingSpecNo, List<PrimalCutRun> primalCutRunList, PsMakeModel parentMakeModel) {

        this.parentMakeModel = parentMakeModel;
        this.processingSpecNo = processingSpecNo;
        this.psMakePrimalCutRowModels = new ArrayList<>();

        // group primal cuts by cutId
        Map<String, List<PrimalCutRun>> byPrimalCut = 
            primalCutRunList.stream().collect(Collectors.groupingBy(PrimalCutRun::getPrimalCutId));

        // create cut row model for each cutId
        byPrimalCut.keySet().forEach(cutId -> {
            List<PrimalCutRun> primalCutsByCutId = byPrimalCut.get(cutId);
            PsMakePrimalCutRowModel psMakePrimalCutRowModel = 
                    new PsMakePrimalCutRowModel(cutId, 
                                        primalCutsByCutId, 
                                        this);
            this.psMakePrimalCutRowModels.add(psMakePrimalCutRowModel);
        });
        // TODO: Create the list of Primal Cuts under this Processing Spec
        // this.psMakePrimalCutRowModels = null; // <-- Do not leave this as null

    }

    /**
     * Method for returning the Processing Spec No in the JSON response.
     *
     * @return Integer Processing Spec Number
     */
    public Integer getProcessingSpecNo() {
        return processingSpecNo;
    }

    /**
     * Method for returning the list of sub-nodes in the JSON response.
     *
     * @return List of Primal Cut sub-nodes
     */
    public List<PsMakePrimalCutRowModel> getPsMakePrimalCutRowModels() {
        return psMakePrimalCutRowModels;
    }
}
