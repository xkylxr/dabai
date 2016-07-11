package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.*;
import sdkd.com.ec.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class EbNewsController extends HttpServlet {
    EbNewsDao newsDao = new EbNewsDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        EbCommentDao commentDao=new EbCommentDao();
        List<EbComment> commentlist = commentDao.getComment();
        request.setAttribute("commentList",commentlist);
        List<EbNews> list = newsDao.getNews();
        request.setAttribute("newList",list);
        EbNoteDao ebNoteDao=new EbNoteDao();
        List<EbNote> ebNoteList=ebNoteDao.getNote();
        request.setAttribute("ebNoteList",ebNoteList);
        String action=request.getParameter("action");
        if("list".equals(action)){
            list(request, response);
        }else if("detail".equals(action)){
            detail(request, response);
        }
        else{
            list(request, response);
        }
    }
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<EbNews> list = newsDao.getNews();
        request.setAttribute("newList",list);
        //跳转
        request.getRequestDispatcher("/pca.do").forward(request,response);
    }
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String paramsId=request.getParameter("id");
        int id=0;
        if(paramsId!=null&&!"".equals(paramsId)){
            id=Integer.valueOf(paramsId);
        }
        EbNews ebNews = newsDao.getNewsById(id);
        request.setAttribute("news",ebNews);
        //跳转
        request.getRequestDispatcher("/news-view.jsp").forward(request,response);
    }
}
