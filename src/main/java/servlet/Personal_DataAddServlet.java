package servlet;

import dao.ApplicantDAO;
import pojo.Applicant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/personal_dataAddServlet")
public class Personal_DataAddServlet extends HttpServlet {
    public Personal_DataAddServlet(){
        super();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out =resp.getWriter();
        String name=req.getParameter("change_name");
        String location=req.getParameter("change_location");
        String job=req.getParameter("change_job");
        String phoneNum=req.getParameter("change_phoneNum");
        String business=req.getParameter("change_business");
        String sex=req.getParameter("change_sex");
        HttpSession session=req.getSession();
        Applicant user= (Applicant)session.getAttribute("SESSION_APPLICANT");
            ApplicantDAO dao=new ApplicantDAO();
            try {
            dao.change(name,sex,location,business,job,phoneNum,user.getapplicantemail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        user.setApplicantId(name);
        user.setBusiness(business);
        user.setJob(job);
        user.setSex(sex);
        user.setPhonenum(phoneNum);


        user.setLocation(location);

        req.getSession().setAttribute("SESSION_APPLICANT",user);
        out.print("<script type ='text/javascript'>");
        out.print("alert('修改成功');");
        out.print("window.location='PersonalHomepage.jsp';");
        out.print("</script>");
        resp.sendRedirect("PersonalHomepage.jsp");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
