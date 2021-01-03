package servlet;

import dao.ApplicantDAO;
import pojo.Applicant;
import javafx.collections.ObservableList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findblogs")
public class Findblogs extends HttpServlet {

    public Findblogs() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObservableList<Applicant> blog= new ApplicantDAO().ReturnBlogs();
        int now=2;
        req.setAttribute("pojo",blog);
        req.setAttribute("now",now);
        req.getRequestDispatcher("Administrator.jsp").forward(req, resp);
    }
}
