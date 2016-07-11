package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbCommentDao;
import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbPCategoryDao;
import sdkd.com.ec.model.EbCProduct;
import sdkd.com.ec.model.EbComment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xky on 2016/7/6.
 */
@WebServlet(name = "EbCommentServlet")
public class EbCommentServlet extends HttpServlet {
    EbCommentDao ebcommentDao=new EbCommentDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        List<EbComment> ebcommentlist = ebcommentDao.getComment();
        request.setAttribute("commentList",ebcommentlist);

        String action=request.getParameter("action");
        if("insert".equals(action)){
            String commentName=request.getParameter("guestName");
            String commentContent=request.getParameter("guestContent");
            String commentTitle=request.getParameter("guestTitle");
            ebcommentDao.Insert(commentName,commentContent,commentTitle);
        }

        //跳转
        request.getRequestDispatcher("/guestbook.jsp").forward(request,response);
    }
}
