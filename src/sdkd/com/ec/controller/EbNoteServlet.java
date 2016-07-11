package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbNoteDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbNote;

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
@WebServlet(name = "EbNoteServlet")
public class EbNoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EbNewsDao newsDao=new EbNewsDao();
        EbNoteDao ebNoteDao=new EbNoteDao();
        List<EbNews> list = newsDao.getNews();
        request.setAttribute("newList",list);

        List<EbNote> noteList=ebNoteDao.getNote();
        request.setAttribute("ebNoteList",noteList);
        String paramsId=request.getParameter("noid");

        int id=0;
        if(paramsId!=null&&!"".equals(paramsId)){
            id=Integer.valueOf(paramsId);
        }
        String action=request.getParameter("action");
        if("nodetail".equals(action)) {
            EbNote ebNote = ebNoteDao.getNoteById(id);
            request.setAttribute("note", ebNote);
            request.getRequestDispatcher("/note-view.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
