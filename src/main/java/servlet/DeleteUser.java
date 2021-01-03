package servlet;

import dao.ApplicantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUserOrBlog")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user=req.getParameter("user_email");
        String blogs_is=req.getParameter("blogs_id");
        if(user!=null){
            new ApplicantDAO().deleteuser(user);
        }else if(blogs_is!=null){
            new ApplicantDAO().deleteblogs(blogs_is);
        }
        req.getRequestDispatcher("Administrator.jsp").forward(req, resp);
    }
}
