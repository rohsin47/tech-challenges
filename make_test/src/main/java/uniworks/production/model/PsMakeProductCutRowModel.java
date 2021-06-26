package uniworks.production.model;

import uniworks.production.dto.PrimalCutRunMake;

import java.util.ArrayList;
import java.util.List;


public class PsMakeProductCutRowModel {

    // The Product Cut Id to be shown on the tree node
    final private String productCutId;

    // The list of 'Makes' within this Product Cut
    final private List<PsMakeCutRunMakeModel> psMakeCutRunMakeModels;

    // Link back to the parent node, if required
    final private PsMakePrimalCutRowModel parentPrimalCutRowModel;

    /**
     * Creates a model for a Product Cut node in the tree.
     *
     * @param productCutId            String Id of the Product Cut
     * @param primalCutRunMakes       List of PrimalCutRunMake's within this Product Cut
     * @param parentPrimalCutRowModel Link back to the parent Primal Cut node model
     */
    public PsMakeProductCutRowModel(String productCutId, List<PrimalCutRunMake> primalCutRunMakes, PsMakePrimalCutRowModel parentPrimalCutRowModel) {
        this.productCutId = productCutId;
        this.parentPrimalCutRowModel = parentPrimalCutRowModel;
        this.psMakeCutRunMakeModels = new ArrayList<>();

        for(PrimalCutRunMake primalCutRunMake : primalCutRunMakes) {
            PsMakeCutRunMakeModel psMakeCutRunMakeModel = 
                new PsMakeCutRunMakeModel(primalCutRunMake.getProductId(), 
                                            primalCutRunMake.getOrderNo(), 
                                            this);
            this.psMakeCutRunMakeModels.add(psMakeCutRunMakeModel);
        }
        // TODO: Create the list of Makes under this Product Cut
        //this.psMakeCutRunMakeModels = null; // <-- Do not leave this as null
    }

    /**
     * Method to return the Product Cut Id in the JSON response.
     *
     * @return String Product Cut Id
     */
    public String getProductCutId() {
        return productCutId;
    }

    /**
     * Method to return the list of Cut Run Makes in the JSON response.
     *
     * @return List of Cut Run Makes
     */
    public List<PsMakeCutRunMakeModel> getPsMakeCutRunMakeModels() {
        return psMakeCutRunMakeModels;
    }
}
