package servlet;

import dao.ApplicantDAO;
import pojo.Applicant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;

@WebServlet("/blog_save")
public class Blogs_Save extends HttpServlet {
    public Blogs_Save() {
        super();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String article = req.getParameter("article");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String title = req.getParameter("title");
        String article_keyword=req.getParameter("article_keyword");
        PrintWriter writer = resp.getWriter();
        HttpSession session=req.getSession();
        Applicant user= (Applicant)session.getAttribute("SESSION_APPLICANT");
        System.out.println("文章zhu："+ article);
        writer.print(true);
        writer.flush();
        writer.close();
            try {
                Blob blob=new SerialBlob(article.getBytes("UTF-8"));
                new ApplicantDAO().Article_Save(user.getapplicantemail(),blob,title,article_keyword);

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
