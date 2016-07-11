package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbCProduct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdust on 2016/7/7.
 */
public class EbPCategoryDao extends BaseDao{
    public List<EbCProduct> getPCategory() {
        List<EbCProduct> cproductlist = new ArrayList<EbCProduct>();
        String sql = "select * from easybuy_product_category";
        try {
            ResultSet rs = this.executeSearch(sql, null);
            while (rs.next()) {
                EbCProduct dp = new EbCProduct();
                dp.setEpcId(rs.getInt("epc_id"));
                dp.setEpcName(rs.getString("epc_name"));
                dp.setEcpParentId(rs.getInt("epc_parent_id"));
                cproductlist.add(dp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cproductlist;
    }
}
