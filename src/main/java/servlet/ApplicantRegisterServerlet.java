package servlet;

import dao.ApplicantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/applicationRegisterServlet")
public class ApplicantRegisterServerlet extends HttpServlet {
    private static final long serialVersionUID =1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out =resp.getWriter();
        String name=req.getParameter("register_name");
        String email=req.getParameter("register_email");
        String password=req.getParameter("register_password");
        ApplicantDAO dao=new ApplicantDAO();
        boolean flag=dao.isExistEmail(email);
        if(flag){
            out.print("<script type ='text/javascript'>");
            out.print("alert('邮箱已经被注册，请重新输入');");
            out.print("window.location='Register.html';");
            out.print("</script>");
        }else {
            dao.save(name,email,password);
            out.print("<script type ='text/javascript'>");
            out.print("alert('恭喜你注册成功');");
            out.print("window.location='Register.html';");
            out.print("</script>");
            resp.sendRedirect("index.jsp");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
     }
}
