package sdkd.com.ec.model;

import java.util.Date;

/**
 * Created by xky on 2016/7/6.
 */
public class EbComment {
    private Integer ecId;
    private String ecReply;
    private String ecContent;
    private Date ecCreateTime;
    private Date ecReplyTime;
    private String ecNickName;

    public Integer getEcId() {
        return ecId;
    }

    public String getEcReply() {
        return ecReply;
    }

    public String getEcContent() {
        return ecContent;
    }

    public Date getEcCreateTime() {
        return ecCreateTime;
    }

    public Date getEcReplyTime() {
        return ecReplyTime;
    }

    public String getEcNickName() {
        return ecNickName;
    }

    public void setEcId(Integer ecId) {
        this.ecId = ecId;
    }

    public void setEcReply(String ecReply) {
        this.ecReply = ecReply;
    }

    public void setEcContent(String ecContent) {
        this.ecContent = ecContent;
    }

    public void setEcCreateTime(Date ecCreateTime) {
        this.ecCreateTime = ecCreateTime;
    }

    public void setEcReplyTime(Date ecReplyTime) {
        this.ecReplyTime = ecReplyTime;
    }

    public void setEcNickName(String ecNickName) {
        this.ecNickName = ecNickName;
    }
}
