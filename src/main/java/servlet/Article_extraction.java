package servlet;

import dao.ApplicantDAO;
import pojo.Applicant;
import pojo.article;

import javafx.collections.ObservableList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/article_extraction")
public class Article_extraction extends HttpServlet {
    public Article_extraction() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        Applicant user = (Applicant) session.getAttribute("SESSION_APPLICANT");
        ObservableList<article> article_Data = null;
        article_Data = new ApplicantDAO().getArticle(user.getApplicantEmail());
        for (article a : article_Data
        ) {
            System.out.println("ex文章id" + a.getArticle_id());
        }
        req.setAttribute("article_Data", article_Data);
        req.getRequestDispatcher("User_blog.jsp").forward(req, resp);
        PrintWriter writer = resp.getWriter();
        writer.print(true);
        writer.flush();
        writer.close();
    }
}