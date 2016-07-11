package sdkd.com.ec.model;

/**
 * Created by sdust on 2016/7/7.
 */
public class EbProduct {
    private  Integer epTd;
    private  String epName;
    private String epDescription;
    private double epPrice;
    private  int epStock;
    private int epcId;
    private int epcChildId;
    private String epFileName;

    public Integer getEpTd() {
        return epTd;
    }

    public String getEpName() {
        return epName;
    }

    public String getEpDescription() {
        return epDescription;
    }

    public double getEpPrice() {
        return epPrice;
    }

    public int getEpStock() {
        return epStock;
    }

    public int getEpcId() {
        return epcId;
    }

    public int getEpcChildId() {
        return epcChildId;
    }

    public String getEpFileName() {
        return epFileName;
    }

    public void setEpTd(Integer epTd) {
        this.epTd = epTd;
    }

    public void setEpName(String ep_Name) {
        this.epName = ep_Name;
    }

    public void setEpDescription(String epDescription) {
        this.epDescription = epDescription;
    }

    public void setEpPrice(double epPrice) {
        this.epPrice = epPrice;
    }

    public void setEpStock(int epStock) {
        this.epStock = epStock;
    }

    public void setEpcId(int epcId) {
        this.epcId = epcId;
    }

    public void setEpcChildId(int epcChildId) {
        this.epcChildId = epcChildId;
    }

    public void setEpFileName(String epFileName) {
        this.epFileName = epFileName;
    }
}
