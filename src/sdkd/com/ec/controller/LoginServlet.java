package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.EbUser;

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
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        EbUserDao userDao=new EbUserDao();
        List<EbUser> user=userDao.getUser();
        String name=request.getParameter("userName");
        String password=request.getParameter("passWord");
        System.out.print(user.size());
        System.out.print(name+password);
        for(int i=0;i<user.size();i++)
        {
            if(name.equals(user.get(i).getEuName())&&password.equals(user.get(i).getEuPassword())) {
                request.setAttribute("name",name);
                request.getRequestDispatcher("/news.do").forward(request, response);
                return;
            }
        }
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
