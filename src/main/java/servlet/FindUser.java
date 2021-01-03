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

@WebServlet("/finduser")
public class FindUser extends HttpServlet {
    public FindUser() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObservableList<Applicant> user= new ApplicantDAO().ReturnUser();
        int now=1;
        req.setAttribute("pojo",user);
        req.setAttribute("now",now);
        req.getRequestDispatcher("Administrator.jsp").forward(req, resp);
    }
}
