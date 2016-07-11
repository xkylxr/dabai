package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNote;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdust on 2016/7/7.
 */
public class EbNoteDao extends BaseDao{
    public List<EbNote> getNote(){
       List<EbNote> ebNoteList=new ArrayList<EbNote>();
        String sql="select * from easybuy_note order by eno_create_time DESC";
        ResultSet rs=this.executeSearch(sql,null);
        try {
            while (rs.next()){
                EbNote ebNote=new EbNote();
                ebNote.setEnoId(rs.getInt("eno_id"));
                ebNote.setEnoTitle(rs.getString("eno_title"));
                ebNote.setEnoName(rs.getString("eno_name"));
                ebNote.setEnoContent(rs.getString("eno_content"));
                ebNote.setEnoCreateTime(rs.getDate("eno_create_time"));
                ebNoteList.add(ebNote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ebNoteList;
    }
    public EbNote getNoteById(int id){
        EbNote note=new EbNote();
        String sql="select * from easybuy_note where eno_id=?";
        try {
            List<String> params=new ArrayList<String>();
            params.add(id+"");
            ResultSet rs=this.executeSearch(sql,params);
            while (rs.next()){
                note.setEnoId(rs.getInt("eno_id"));
                note.setEnoTitle(rs.getString("eno_title"));
                note.setEnoName(rs.getString("eno_name"));
                note.setEnoContent(rs.getString("eno_content"));
                note.setEnoCreateTime(rs.getDate("eno_create_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return note;
    }
}
