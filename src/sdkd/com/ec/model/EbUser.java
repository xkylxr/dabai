package sdkd.com.ec.model;

import java.util.Date;

/**
 * 用户表
 * Created by SDUST-132 on 2016/7/5.
 */
public class EbUser {

    private int euID;
    private  String euName;
    private String euPassword;
    private String euSex;
    private Date euBirthday;
    private String euInD;
    private String euEmail;
    private  String euMoible;
    private String euAddress;

    private int euStatus;
    public EbUser(){}
            public EbUser( String euName, String euPassword, String euSex, Date euBirthday, String euInD, String euEmail,String euMoible, String euAddress, int euStatus) {
        this.euName = euName;
        this.euPassword = euPassword;
        this.euSex = euSex;
        this.euBirthday = euBirthday;
        this.euInD = euInD;
        this.euEmail = euEmail;
        this.euMoible=euMoible;
        this.euAddress = euAddress;
        this.euStatus = euStatus;
    }

    public String getEuMoible() {
        return euMoible;
    }

    public void setEuMoible(String euMoible) {
        this.euMoible = euMoible;
    }

    public int getEuID() {
        return euID;
    }

    public String getEuName() {
        return euName;
    }

    public String getEuPassword() {
        return euPassword;
    }

    public String getEuSex() {
        return euSex;
    }

    public Date getEuBirthday() {
        return euBirthday;
    }

    public String getEuInD() {
        return euInD;
    }

    public String getEuEmail() {
        return euEmail;
    }

    public String getEuAddress() {
        return euAddress;
    }

    public int getEuStatus() {
        return euStatus;
    }

    public void setEuID(int enID) {
        this.euID = enID;
    }

    public void setEuName(String euName) {
        this.euName = euName;
    }

    public void setEuPassword(String euPassword) {
        this.euPassword = euPassword;
    }

    public void setEuSex(String euSex) {
        this.euSex = euSex;
    }

    public void setEuBirthday(Date euBirthday) {
        this.euBirthday = euBirthday;
    }

    public void setEuInD(String euInD) {
        this.euInD = euInD;
    }

    public void setEuEmail(String euEmail) {
        this.euEmail = euEmail;
    }

    public void setEuAddress(String euAddress) {
        this.euAddress = euAddress;
    }

    public void setEuStatus(int euStatus) {
        this.euStatus = euStatus;
    }
}
