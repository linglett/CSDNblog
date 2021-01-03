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

@WebServlet("/Recommend")
public class Recommend extends HttpServlet {
    public Recommend() {
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
        String classity=req.getParameter("classify");
        ObservableList<article> article_Data = null;
        if(classity!=null){
            if(classity.equals("推荐"))
                article_Data = new ApplicantDAO().Recommend_article();
            else {
                article_Data = new ApplicantDAO().Recommend_article(classity);
            }
        }
        else{
            article_Data = new ApplicantDAO().Recommend_article();
        }
        req.setAttribute("article_Recommend", article_Data);
        req.getRequestDispatcher("Head.jsp").forward(req, resp);
}
}
