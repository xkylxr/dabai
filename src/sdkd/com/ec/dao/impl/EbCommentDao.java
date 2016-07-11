package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbComment;
import sdkd.com.ec.model.EbNews;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xky on 2016/7/6.
 */
public class EbCommentDao extends BaseDao {

    public List<EbComment> getComment() {
        List<EbComment> newsList = new ArrayList<EbComment>();
        String sql = "select * from easybuy_comment order by ec_create_time desc limit 0,7";
        try {
            ResultSet rs = this.executeSearch(sql, null);
            while (rs.next()) {
                EbComment comment = new EbComment();
                comment.setEcId(rs.getInt("ec_id"));
                comment.setEcReply(rs.getString("ec_reply"));
                comment.setEcContent(rs.getString("ec_content"));
                comment.setEcNickName(rs.getString("ec_nick_name"));
                comment.setEcReplyTime(rs.getTime("ec_reply_time"));
                comment.setEcCreateTime(rs.getTime("ec_create_time"));
                //添加到集合中
                newsList.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    public void Insert(String commentName, String commentContent, String commentTitle) {
        String sql = "insert into easybuy_comment(ec_nick_name,ec_content,ec_title) values(?,?,?)";
        List<String> params = new ArrayList<String>();
        params.add(0, commentName);
        params.add(1, commentContent);
        params.add(2, commentTitle);
        int s = this.exeucteModify(sql, params);
    }
}
