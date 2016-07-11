package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sdust on 2016/7/7.
 */
@WebServlet(name = "EbProductServlet")
public class EbProductServlet extends HttpServlet {
    EbProductDao productDao= new EbProductDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EbProductDao discountproductDao= new EbProductDao();
        List<EbProduct> dpList=discountproductDao.getDiscountProduct();
        request.setAttribute("dpList",dpList);

        EbProductDao hotproductDao= new EbProductDao();
        List<EbProduct> hotpList=hotproductDao.getHotProduct();
        request.setAttribute("hotpList",hotpList);
        /*  product_List */
        EbProductDao pDao=new EbProductDao();
        String paramsId=request.getParameter("pid");

        int id=0;
        if(paramsId!=null&&!"".equals(paramsId)){
            id=Integer.valueOf(paramsId);
        }
        String action=request.getParameter("action");
        if("pdetail".equals(action))
        {
            EbProduct pList=pDao.getProductById(id);
            request.setAttribute("pr",pList);
            request.getRequestDispatcher("/product-view.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
//        String action=request.getParameter("action");
//        if("pdetail".equals(action)){
//            detail(request, response);
//        }
//        else{
//            list(request, response);
//        }
    }
//    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        List<EbProduct> dpList=productDao.getDiscountProduct();
//        request.setAttribute("dpList",dpList);
//
//        EbProductDao hotproductDao= new EbProductDao();
//        List<EbProduct> hotpList=productDao.getHotProduct();
//        request.setAttribute("hotpList",hotpList);
//        //跳转
//        request.getRequestDispatcher("/pca.do").forward(request,response);
//    }
//    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//
//        String paramsId=request.getParameter("pid");
//        int id=0;
//        if(paramsId!=null&&!"".equals(paramsId)){
//            id=Integer.valueOf(paramsId);
//        }
//        EbProduct product = productDao.getProductById(id);
//        request.setAttribute("pr",product);
//        //跳转
//        request.getRequestDispatcher("/product-view.jsp").forward(request,response);
//    }

}
