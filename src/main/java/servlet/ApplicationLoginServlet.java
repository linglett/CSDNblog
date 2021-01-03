package servlet;

import dao.ApplicantDAO;
import pojo.Applicant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/applicationLoginServlet")
public class ApplicationLoginServlet extends HttpServlet {
    private static final long serivalVersionUID = 1L;

    public ApplicationLoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("login_email");
        String password = request.getParameter("login_password");
        ApplicantDAO dao = new ApplicantDAO();
        String applicantID = dao.login(email, password,"id");
        String applicantSex = dao.login(email, password,"sex");
        String applicantLocation = dao.login(email, password,"address");
        String applicantBusiness = dao.login(email, password,"business");
        String applicantPhonenum = dao.login(email, password,"phonenumber");
        String applicantJob = dao.login(email, password,"job");
        if (applicantID != null)//登陆成功
        {
            Applicant applicant =new Applicant(applicantID,email,password,applicantSex,applicantLocation,applicantBusiness,applicantPhonenum,applicantJob);
            request.getSession().setAttribute("SESSION_APPLICANT",applicant);
            response.sendRedirect("index.jsp");
            response.getWriter().print("Servlet TEST Success!");
        } else {
            out.print("<script type ='text/javascript'>");
            out.print("alert('用户名或密码错误，请重新输入！');");
            out.print("window.location='Login.html';");
            out.print("</script>");
        }

    }
}
