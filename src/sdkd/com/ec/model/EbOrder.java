package sdkd.com.ec.model;

/**
 * Created by xky on 2016/7/10.
 */
public class EbOrder {
    private int EO_ID;
    private int EO_USER_ID;
    private String EO_USER_NAME;
    private String EO_USER_ADDRESS;
    private String EO_CREATE_TIME;
    private double EO_COST;
    private int EO_STATUS;
    private int EO_TYPE;

    public String getOrderStatusStr(){
        if(this.EO_STATUS==1){
            return "待审核";
        }else if(this.EO_STATUS==2){
            return "审核通过";
        }else if(this.EO_STATUS==3){
            return "配货";
        }else if(this.EO_STATUS==4){
            return "发货";
        }else{
            return "确认收货";
        }
    }

    public EbOrder(int EO_ID, int EO_USER_ID, String EO_USER_ADDRESS, double EO_COST, int EO_STATUS, int EO_TYPE, String EO_CREATE_TIME, String EO_USER_NAME) {
        this.EO_ID = EO_ID;
        this.EO_USER_ID = EO_USER_ID;
        this.EO_USER_ADDRESS = EO_USER_ADDRESS;
        this.EO_COST = EO_COST;
        this.EO_STATUS = EO_STATUS;
        this.EO_TYPE = EO_TYPE;
        this.EO_CREATE_TIME = EO_CREATE_TIME;
        this.EO_USER_NAME = EO_USER_NAME;
    }

    public int getEO_ID() {
        return EO_ID;
    }

    public void setEO_ID(int EO_ID) {
        this.EO_ID = EO_ID;
    }

    public int getEO_USER_ID() {
        return EO_USER_ID;
    }

    public void setEO_USER_ID(int EO_USER_ID) {
        this.EO_USER_ID = EO_USER_ID;
    }

    public String getEO_USER_NAME() {
        return EO_USER_NAME;
    }

    public void setEO_USER_NAME(String EO_USER_NAME) {
        this.EO_USER_NAME = EO_USER_NAME;
    }

    public String getEO_USER_ADDRESS() {
        return EO_USER_ADDRESS;
    }

    public void setEO_USER_ADDRESS(String EO_USER_ADDRESS) {
        this.EO_USER_ADDRESS = EO_USER_ADDRESS;
    }

    public double getEO_COST() {
        return EO_COST;
    }

    public void setEO_COST(double EO_COST) {
        this.EO_COST = EO_COST;
    }

    public String getEO_CREATE_TIME() {
        return EO_CREATE_TIME;
    }

    public void setEO_CREATE_TIME(String EO_CREATE_TIME) {
        this.EO_CREATE_TIME = EO_CREATE_TIME;
    }

    public int getEO_STATUS() {
        return EO_STATUS;
    }

    public void setEO_STATUS(int EO_STATUS) {
        this.EO_STATUS = EO_STATUS;
    }

    public int getEO_TYPE() {
        return EO_TYPE;
    }

    public void setEO_TYPE(int EO_TYPE) {
        this.EO_TYPE = EO_TYPE;
    }
}
