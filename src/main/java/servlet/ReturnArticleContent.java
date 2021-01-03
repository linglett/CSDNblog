package servlet;

import dao.ApplicantDAO;
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

@WebServlet("/ReturnArticleContent")
public class ReturnArticleContent extends HttpServlet {
    public ReturnArticleContent() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String article_id=req.getParameter("article_id");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        ObservableList<pojo.article> article_Data = null;
        article_Data = new ApplicantDAO().getArticle_return(article_id);
        article C1=null;
        for (article a : article_Data
        ) {
            C1=a;
            System.out.println("文章标题" + a.getBody());
            a.test();
        }
        PrintWriter writer = resp.getWriter();
        req.getSession().setAttribute("ARTICLE",C1);
        req.setAttribute("article_Body",C1);
        req.setAttribute("article_comments",C1.getComment());
        req.getRequestDispatcher("Browse_blog.jsp").forward(req, resp);
        writer.print(true);
        writer.flush();
        writer.close();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
