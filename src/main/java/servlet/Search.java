package servlet;

import dao.ApplicantDAO;
import pojo.article;
import javafx.collections.ObservableList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/Search")

public class Search extends HttpServlet {
    public Search() {
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
        PrintWriter out = resp.getWriter();
        String keyword = req.getParameter("search_content");
        ObservableList<article> likearticle =null;
        if(keyword!=null)
        {
            likearticle= new ApplicantDAO().SearchArticle(keyword);
        }
        PrintWriter writer = resp.getWriter();
        req.setAttribute("article_Searcher",likearticle);
        //重定向
        req.getRequestDispatcher("Search_result.jsp").forward(req, resp);
    }
}
