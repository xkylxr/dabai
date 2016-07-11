package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbCart;
import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.model.ShoppingCartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xky on 2016/7/8.
 */
@WebServlet(name = "EbCartServlet")
public class EbCartServlet extends HttpServlet {
    EbProductDao ebProductDao=new EbProductDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       boolean issame=false;
        String paramId=request.getParameter("pid");
        int id=0;
        if(paramId!=null&&!"".equals(paramId)){
            id=Integer.valueOf(paramId);
        }
        EbProduct product=ebProductDao.getProductById(id);
        String action = request.getParameter("action");
        if("mod".equals(action)){
            modifyCart(request, response);
        }else if("remove".equals(action)){
            removeCart(request, response);
        }else {

            //2.存储至session
            //存session之前判断是否已经存在
            EbCart cart = (EbCart) request.getSession().getAttribute("cart");
            if (cart == null) {
                cart = new EbCart();
                cart.addItem(product, 1);
            } else {
                //如果存在，查找有无相同的商品，如果有则更新数量
                List<ShoppingCartItem> items = cart.getItems();
                if (items != null && items.size() > 0) {
                    for (ShoppingCartItem item : items) {
                        EbProduct itemPro = item.getProduct();
                        if (itemPro.getEpTd() == id) {
                            item.setQuantity(item.getQuantity() + 1);
                            issame = true;  //标识
                        }
                    }
                }
                //若不存在，则直接添加，数量默认为1
                if (!issame) {
                    cart.addItem(product, 1);
                }
            }
            request.getSession().setAttribute("cart", cart);
        }
        response.sendRedirect("/shopping.jsp");
       // request.getRequestDispatcher("").forward(request,response);
    }
       /*
        添加购物车*/
    public void addCart()
    {

    }
    /**
     * 购物车页面进行修改
     */
    public void modifyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EbCart cart = (EbCart) request.getSession().getAttribute("cart");
        long quantity = 0;
        int index = 0;
        String quantityParam = request.getParameter("quantity");
        String indexParam = request.getParameter("index");
        if(quantityParam!=null && !"".equals(quantityParam)){
            quantity = Long.valueOf(quantityParam);
        }
        if(indexParam!=null && !"".equals(indexParam)){
            index = Integer.valueOf(indexParam);
        }
        cart.modifyQuantity(index,quantity);
    }

    /**
     * 删除购物车
     */
    public void removeCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EbCart cart = (EbCart) request.getSession().getAttribute("cart");
        int index = 0;
        String indexParam = request.getParameter("index");
        if(indexParam!=null && !"".equals(indexParam)){
            index = Integer.valueOf(indexParam);
        }
        cart.removeItem(index);
    }
}
