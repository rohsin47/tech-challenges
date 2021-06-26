package uniworks.production.dto;

import java.util.ArrayList;
import java.util.List;

public class PrimalCutRun {

    private Integer uid;
    private Integer processingSpecNo;
    private String primalCutId;
    private Integer runNo;
    private Integer startTally;
    private Integer processTally;

    private final List<PrimalCutRunMake> primalCutRunMakeList;

    public PrimalCutRun(Integer uid, Integer processingSpecNo, String primalCutId, Integer runNo, Integer startTally, Integer processTally) {
        this.uid = uid;
        this.processingSpecNo = processingSpecNo;
        this.primalCutId = primalCutId;
        this.runNo = runNo;
        this.startTally = startTally;
        this.processTally = processTally;

        this.primalCutRunMakeList = new ArrayList<>();
    }

    public void addMake(PrimalCutRunMake primalCutRunMake) {
        this.primalCutRunMakeList.add(primalCutRunMake);
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPrimalCutId() {
        return primalCutId;
    }

    public void setPrimalCutId(String primalCutId) {
        this.primalCutId = primalCutId;
    }

    public Integer getProcessingSpecNo() {
        return processingSpecNo;
    }

    public void setProcessingSpecNo(Integer processingSpecNo) {
        this.processingSpecNo = processingSpecNo;
    }

    public Integer getStartTally() {
        return startTally;
    }

    public void setStartTally(Integer startTally) {
        this.startTally = startTally;
    }

    public Integer getProcessTally() {
        return processTally;
    }

    public void setProcessTally(Integer processTally) {
        this.processTally = processTally;
    }

    public Integer getRunNo() {
        return runNo;
    }

    public List<PrimalCutRunMake> getPrimalCutRunMakeList() {
        return primalCutRunMakeList;
    }

    public String toString() {
        return this.getClass().getSimpleName() + " {"
                + "Spec: " + processingSpecNo
                + ", Primal: " + primalCutId
                + ", RunNo: " + runNo;
    }
}
