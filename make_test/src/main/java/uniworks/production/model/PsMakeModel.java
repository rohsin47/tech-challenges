package uniworks.production.model;

import uniworks.production.dto.PrimalCutRun;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is a model for the root node of the displayed Make tree.
 */
public class PsMakeModel {

    // This is the list of Processing Spec tree nodes that will be shown on the screen
    final private List<PsMakeProcessingSpecRowModel> psMakeProcessingSpecRowModels;

    /**
     * Creates the top 'node' of the UI tree
     *
     * @param primalCutRunList List of Primal Cut Runs for all Processing Specs and Primal Cuts
     */
    public PsMakeModel(List<PrimalCutRun> primalCutRunList) {

        this.psMakeProcessingSpecRowModels = new ArrayList<>();

        // group primal cuts by processing spec no && create spec row model for each spec
        primalCutRunList
        	.stream()
            .collect(Collectors.groupingBy(PrimalCutRun::getProcessingSpecNo))
            .entrySet()
            .forEach(spec -> {                
                this.psMakeProcessingSpecRowModels.add(new PsMakeProcessingSpecRowModel(spec.getKey(), spec.getValue(), this));
            });
    }

    /**
     * Method for returning the list of sub-nodes ion the JSON response.
     *
     * @return List of Processing Spec sub-nodes
     */
    public List<PsMakeProcessingSpecRowModel> getPsMakeProcessingSpecRowModels() {
        return psMakeProcessingSpecRowModels;
    }
}
