package sdkd.com.ec.controller;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xky on 2016/7/9.
 */
@WebServlet(name = "EbInsertUserServlet")
public class EbInsertUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
         String euName=request.getParameter("userName");;
       String euPassword=request.getParameter("passWord");
        String euSex=request.getParameter("sex");
        String birth=request.getParameter("brithday");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        Date euBirthday = null;
        try {
             euBirthday = sdf.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        euBirthday = java.sql.Date.valueOf(birth);
        System.out.println(euBirthday);
        String euInD=request.getParameter("idcard");
        String euEmail=request.getParameter("email");
         String euAddress=request.getParameter("address");
        String euMobile=request.getParameter("mobile");

        EbUser u=new EbUser(euName,euPassword,euSex,euBirthday,euInD,euEmail,euMobile,euAddress,'1');
        u.setEuName(euName);
        u.setEuPassword(euPassword);
        u.setEuSex(euSex);
        u.setEuBirthday(euBirthday);
        u.setEuInD(euInD);
        u.setEuEmail(euEmail);
        u.setEuMoible(euMobile);
        u.setEuAddress(euAddress);
        //String sql="insert into easybuy_user(eu_user_name,eu_password) values(?,?)";
        String sql = "insert into easybuy_user(eu_user_name,eu_password,eu_sex,eu_birthday,eu_identity_code,eu_email,eu_mobile,eu_address) values(?,?,?,?,?,?,?,?)";
        List<String> params=new ArrayList<String>();
        // params.add(0,u.getEuID()+u.getEuName()+u.getEuPassword()+u.getEuSex()+u.getEuBirthday()+u.getEuEmail()+u.getEuMoible()+u.getEuAddress()+1);
        params.add(0,euName);
        params.add(1,euPassword);
        params.add(2,euSex);
        params.add(3,euBirthday+"");
        params.add(4,euInD);
        params.add(5,euEmail);
        params.add(6,euMobile);
        params.add(7,euAddress);
        new BaseDao().exeucteModify(sql,params);

        System.out.print(params);
//        if(count>0){
//            response.sendRedirect("manage-result.jsp");
//        }else{
//            out.write("<script>");
//            out.write("alert('添加失败');");
//            out.write("location.href='register.jsp'");
//            out.write("</script>");
//            out.close();
//        }
        request.getRequestDispatcher("/reg-result.jsp").forward(request,response);

    }
}
