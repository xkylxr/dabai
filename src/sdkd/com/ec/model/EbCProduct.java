package sdkd.com.ec.model;

/**
 * Created by sdust on 2016/7/7.
 */
public class EbCProduct {
    private  Integer epcId;
    private String epcName;
    private Integer ecpParentId;

    public Integer getEpcId() {
        return epcId;
    }

    public void setEpcId(Integer epcId) {
        this.epcId = epcId;
    }

    public String getEpcName() {
        return epcName;
    }

    public void setEpcName(String epcName) {
        this.epcName = epcName;
    }

    public Integer getEcpParentId() {
        return ecpParentId;
    }

    public void setEcpParentId(Integer ecpParentId) {
        this.ecpParentId = ecpParentId;
    }
}
