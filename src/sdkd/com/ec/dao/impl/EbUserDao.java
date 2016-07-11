package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * 用户DAO
 * Created by SDUST-132 on 2016/7/5.
 */
public class EbUserDao extends BaseDao{
    public  boolean islogin=false;

    public boolean islogin() {
        return islogin;
    }
    public void setIslogin(boolean islogin) {
        this.islogin = islogin;
    }
    public List<EbUser> getUser(){
        List<EbUser> ebUsersList=new ArrayList<EbUser>();
        String sql="select * from easybuy_user";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EbUser user = new EbUser();
                user.setEuID(rs.getInt("eu_user_id"));
                user.setEuName(rs.getString("eu_user_name"));
                user.setEuPassword(rs.getString("eu_password"));
                user.setEuSex(rs.getString("eu_sex"));

                //添加到集合中
                ebUsersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ebUsersList;
    }

//    public static int insert(EbUser u){
//        String sql = "insert into easybuy_user values(?,?,?,to_date(?,'yyyy-MM-dd'),?,?,?,?,?)";
//        List<String> params=new ArrayList<String>();
//       // params.add(0,u.getEuID()+u.getEuName()+u.getEuPassword()+u.getEuSex()+u.getEuBirthday()+u.getEuEmail()+u.getEuMoible()+u.getEuAddress()+1);
//        params.add(0,u.getEuName());
//        params.add(1,u.getEuPassword());
//        params.add(2,u.getEuSex());
//        params.add(3,u.getEuBirthday()+"");
//        params.add(4,u.getEuEmail());
//        params.add(5,u.getEuMoible());
//        params.add(6,u.getEuAddress());
//        params.add(7,u.getEuStatus()+"");
//        int count=0;
//        try {
//            Connection con =getConnection();
//            PreparedStatement ps = con.prepareStatement(sql);
//            if(params!=null){
//                for (int i = 0; i < params.size(); i++) {
//                    ps.setObject(i+1, params.get(i));
//                }
//            }
//            count=ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return count;
//    }

}
