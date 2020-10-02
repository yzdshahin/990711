
package Controller;
//https://www.onlyxcodes.com/2018/02/java-mvc-login-and-register-script.html
//https://www.javawebtutor.com/articles/maven/maven_simple_login_application.php
import Model.Dao.LoginDao;
import Model.Entity.LoginBean;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginController extends HttpServlet {
    
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
       if( request.getParameter("btn_login")!= null){
        
           try {
               String username = request.getParameter("txt_username");
               String password = request.getParameter("txt_password");
               
               LoginBean loginBean =new LoginBean();
               loginBean.setUsername(username);
               loginBean.setPassword(password);
               LoginDao loginDao= new LoginDao();
               String AuthorizeLogin = loginDao.AuthorizeLogin(loginBean);
               if(AuthorizeLogin.equals("Success")){
                   HttpSession session= request.getSession();
                   session.setAttribute("login", loginBean.getUsername());
                   RequestDispatcher rd= request.getRequestDispatcher("welcome.jsp");
                   rd.forward(request, response);
               }
               else
               {
                   request.setAttribute("WrongLoginMsg", AuthorizeLogin);
                   RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
                   rd.include(request, response);
               }
           } catch (SQLException ex) {
               Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
}
