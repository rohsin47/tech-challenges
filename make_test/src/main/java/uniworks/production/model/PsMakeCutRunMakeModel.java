package uniworks.production.model;

/**
 * Class used to model the Cut Run Makes which are displayed as bars across the screen, in each Product Cut row.
 */
public class PsMakeCutRunMakeModel {

    // Product Id for this Cut Run Make
    final private String productId;

    // Order No for this Cut Run Make
    final private Integer orderNo;

    // Link back to the parent node, if required
    final private PsMakeProductCutRowModel parentProductCutRowModel;

    public PsMakeCutRunMakeModel(String productId, Integer orderNo, PsMakeProductCutRowModel parentProductCutRowModel) {
        this.productId = productId;
        this.orderNo = orderNo;
        this.parentProductCutRowModel = parentProductCutRowModel;
    }

    /**
     * Method to return the Product Id in the JSON response.
     *
     * @return String ID of the Product
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Method to return the Order Number in the JSON response.
     *
     * @return Integer Order Number
     */
    public Integer getOrderNo() {
        return orderNo;
    }

}
