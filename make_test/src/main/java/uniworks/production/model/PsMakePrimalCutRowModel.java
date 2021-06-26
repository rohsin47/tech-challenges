package uniworks.production.model;

import uniworks.production.dto.PrimalCutRun;
import uniworks.production.dto.PrimalCutRunMake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PsMakePrimalCutRowModel {

    // The Processing Spec Number which will be displayed in the tree
    final private String primalCutId;

    // The list of sub-nodes for all the Primal Cuts within this Process Spec
    final private List<PsMakeProductCutRowModel> psMakeProductCutRowModels;

    // The list of Cut Run models for this Primal Cut
    final private List<PsMakeCutRunModel> psMakeCutRunModels;

    // Link back to the parent node, if required
    final private PsMakeProcessingSpecRowModel parentProcessingSpecRowModel;

    /**
     * Creates a model for the Primal Cut tree node.
     *
     * @param primalCutRunList List containing only the PrimalCutRun's for a single Primal Cut
     */
    public PsMakePrimalCutRowModel(String primalCutId,
                                   List<PrimalCutRun> primalCutRunList,
                                   PsMakeProcessingSpecRowModel parentProcessingSpecRowModel)
    {
        this.primalCutId = primalCutId;
        this.parentProcessingSpecRowModel = parentProcessingSpecRowModel;
        this.psMakeProductCutRowModels = new ArrayList<>();
        this.psMakeCutRunModels = new ArrayList<>();

        // create map to store primalCutRunMake by cutId
        Map<String, List<PrimalCutRunMake>> byCutId = new HashMap<>();

        // iterate over primalCutRun and create makeCutRunModel by run no
        // for each primalCut and map primalCutRunMakes by cutId
        for(PrimalCutRun primalCutRun : primalCutRunList) {
           
            PsMakeCutRunModel psMakeCutRunModel = new PsMakeCutRunModel(primalCutRun.getRunNo(), this);
            this.psMakeCutRunModels.add(psMakeCutRunModel);
            
            List<PrimalCutRunMake> primalCutRunMakes = primalCutRun.getPrimalCutRunMakeList();

            // group by cutId for each primal cut
            Map<String, List<PrimalCutRunMake>> byCutIdLocal =
                primalCutRunMakes.stream().collect(Collectors.groupingBy(PrimalCutRunMake::getCutId));

            // merge to final map for all primal cuts
            for(Map.Entry<String, List<PrimalCutRunMake>> cutId : byCutIdLocal.entrySet()) {
                if(!byCutId.containsKey(cutId.getKey())) {
                    byCutId.put(cutId.getKey(), cutId.getValue());
                } else {
                    byCutId.get(cutId.getKey()).addAll(cutId.getValue());
                }
            }
        }

        byCutId.keySet().forEach(cutId -> {
            List<PrimalCutRunMake> primalCutMakes = byCutId.get(cutId);
            PsMakeProductCutRowModel psMakeProductCutRowModel =
                new PsMakeProductCutRowModel(cutId, primalCutMakes, this);
            this.psMakeProductCutRowModels.add(psMakeProductCutRowModel);
        });
    }

    /**
     * Method for returning the Primal Cut Id in the JSON response.
     *
     * @return String Primal Cut Id (E.g. "CHUCK")
     */
    public String getPrimalCutId() {
        return primalCutId;
    }

    /**
     * Method for returning the list of Cut Run models in the JSON response.
     *
     * @return List of Cut Run models
     */
    public List<PsMakeCutRunModel> getPsMakeCutRunModels() {
        return psMakeCutRunModels;
    }

    /**
     * Method for returning the list of Product Cut row models in the JSON response.
     *
     * @return List of Product Cut row models
     */
    public List<PsMakeProductCutRowModel> getPsMakeProductCutRowModels() {
        return psMakeProductCutRowModels;
    }
}
