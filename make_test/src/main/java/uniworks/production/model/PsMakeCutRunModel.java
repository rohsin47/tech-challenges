package uniworks.production.model;

/**
 * This class is used to model the vertical Cut Run 'slices' across the Make tree
 */
public class PsMakeCutRunModel {

    // The Cut Run Number to be displayed on the screen
    final private Integer cutRunNo;

    // Link back to the parent node, if required
    final private PsMakePrimalCutRowModel parentPrimalCutRowModel;

    /**
     *
     * @param cutRunNo
     * @param parentPrimalCutRowModel
     */
    public PsMakeCutRunModel(Integer cutRunNo, PsMakePrimalCutRowModel parentPrimalCutRowModel) {
        this.cutRunNo = cutRunNo;
        this.parentPrimalCutRowModel = parentPrimalCutRowModel;
    }
}
