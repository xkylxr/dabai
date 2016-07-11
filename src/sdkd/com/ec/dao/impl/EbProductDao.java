package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdust on 2016/7/7.
 */
public class EbProductDao extends BaseDao {
    public List<EbProduct> getHotProduct() {
        List<EbProduct> hproductlist = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product order by ep_stock asc limit 0,14";
        try {
           ResultSet rs1 = this.executeSearch(sql, null);
            while (rs1.next()) {
                EbProduct dp = new EbProduct();
                dp.setEpTd(rs1.getInt("ep_id"));
                dp.setEpName(rs1.getString("ep_name"));
                dp.setEpPrice(rs1.getDouble("ep_price"));
                dp.setEpStock(rs1.getInt("ep_stock"));
                dp.setEpFileName(rs1.getString("ep_file_name"));
                hproductlist.add(dp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hproductlist;
    }
    public List<EbProduct> getDiscountProduct() {
        List<EbProduct> discountproductlist = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product where ep_discount=1 ORDER BY ep_stock desc limit 0,8";
        try {
            ResultSet rs = this.executeSearch(sql, null);
            while (rs.next()) {
                EbProduct dp1 = new EbProduct();
                dp1.setEpTd(rs.getInt("ep_id"));
                dp1.setEpName(rs.getString("ep_name"));
                dp1.setEpFileName(rs.getString("ep_file_name"));
                dp1.setEpStock(rs.getInt("ep_stock"));
                dp1.setEpPrice(rs.getDouble("ep_price"));
                discountproductlist.add(dp1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discountproductlist;
    }
    public List<EbProduct> getProduct(){
        List<EbProduct> plist = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product";
        try {
            ResultSet rs = this.executeSearch(sql, null);
            while (rs.next()) {
                EbProduct ebp = new EbProduct();
                ebp.setEpTd(rs.getInt("ep_id"));
                ebp.setEpName(rs.getString("ep_name"));
                ebp.setEpStock(rs.getInt("ep_stock"));
                ebp.setEpFileName(rs.getString("ep_file_name"));
                ebp.setEpPrice(rs.getDouble("ep_price"));

                plist.add(ebp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plist;
    }
    public EbProduct getProductById(int id){
        EbProduct ebp=new EbProduct();
        String sql = "select * from easybuy_product where ep_id=?";
        try {
            List<String> params=new ArrayList<String>();
            params.add(id+"");
            ResultSet rs = this.executeSearch(sql, params);
            while (rs.next()) {
                ebp.setEpTd(rs.getInt("ep_id"));
                ebp.setEpName(rs.getString("ep_name"));
                ebp.setEpStock(rs.getInt("ep_stock"));
                ebp.setEpFileName(rs.getString("ep_file_name"));
                ebp.setEpDescription(rs.getString("ep_description"));
                ebp.setEpPrice(rs.getDouble("ep_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ebp;
    }
}
