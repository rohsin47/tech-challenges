package uniworks.production.dto;

public class PrimalCutRunMake {

    private Integer uid;
    private Integer primalCutRunUid;
    private Integer makeSetNo;
    private String cutId;
    private String productId;
    private Integer orderNo;
    private Integer tally;

    public PrimalCutRunMake(Integer uid, Integer primalCutRunUid, Integer makeSetNo, String cutId, String productId, Integer orderNo, Integer tally) {
        this.uid = uid;
        this.primalCutRunUid = primalCutRunUid;
        this.makeSetNo = makeSetNo;
        this.cutId = cutId;
        this.productId = productId;
        this.orderNo = orderNo;
        this.tally = tally;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPrimalCutRunUid() {
        return primalCutRunUid;
    }

    public void setPrimalCutRunUid(Integer primalCutRunUid) {
        this.primalCutRunUid = primalCutRunUid;
    }

    public Integer getMakeSetNo() {
        return makeSetNo;
    }

    public void setMakeSetNo(Integer makeSetNo) {
        this.makeSetNo = makeSetNo;
    }

    public String getCutId() {
        return cutId;
    }

    public void setCutId(String cutId) {
        this.cutId = cutId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getTally() {
        return tally;
    }

    public void setTally(Integer tally) {
        this.tally = tally;
    }
}
