package sdkd.com.ec.model;

import java.util.Date;

/**
 * Created by sdust on 2016/7/7.
 */
public class EbNote {
    private Integer enoId;
    private String enoTitle;
    private String enoName;
    private String enoContent;
    private Date enoCreateTime;

    public Integer getEnoId() {
        return enoId;
    }

    public void setEnoId(Integer enoId) {
        this.enoId = enoId;
    }

    public String getEnoName() {
        return enoName;
    }

    public void setEnoName(String enoName) {
        this.enoName = enoName;
    }

    public String getEnoContent() {
        return enoContent;
    }

    public void setEnoContent(String enoContent) {
        this.enoContent = enoContent;
    }

    public Date getEnoCreateTime() {
        return enoCreateTime;
    }

    public void setEnoCreateTime(Date enoCreateTime) {
        this.enoCreateTime = enoCreateTime;
    }

    public String getEnoTitle() {
        return enoTitle;
    }

    public void setEnoTitle(String enoTitle) {
        this.enoTitle = enoTitle;
    }
}
