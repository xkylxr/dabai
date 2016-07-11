package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbNoteDao;
import sdkd.com.ec.dao.impl.EbPCategoryDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbCProduct;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbNote;
import sdkd.com.ec.model.EbProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sdust on 2016/7/8.
 */
@WebServlet(name = "IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EbPCategoryDao ebProductDao=new EbPCategoryDao();
        EbProductDao ProductDao=new EbProductDao();
        EbNewsDao newsDao=new EbNewsDao();
        EbNoteDao ebNoteDao=new EbNoteDao();
        //
        List<EbCProduct> ebCProductList=ebProductDao.getPCategory();
        request.setAttribute("ebCProductList",ebCProductList);

        List<EbProduct> dpList=ProductDao.getDiscountProduct();
        request.setAttribute("dpList",dpList);


        List<EbProduct> hotpList=ProductDao.getHotProduct();
        request.setAttribute("hotpList",hotpList);

        List<EbNews> list = newsDao.getNews();
        request.setAttribute("newList",list);

        List<EbNote> noteList=ebNoteDao.getNote();
        request.setAttribute("ebNoteList",noteList);

        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
