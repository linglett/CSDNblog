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

@WebServlet("/save_comments")
public class Comments extends HttpServlet {
    public Comments() {
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
        String time = new ApplicantDAO().getStringDate();
        String body=req.getParameter("body");
        System.out.println("评论"+body+"id"+req.getParameter("article_id"));
        int article_id;
        if(body!=null&&req.getParameter("article_id")!=null) {
            article_id=Integer.parseInt(req.getParameter("article_id"));
            HttpSession session = req.getSession();
            Applicant user = (Applicant) session.getAttribute("SESSION_APPLICANT");
            new ApplicantDAO().Save_Comments(user, body, time, article_id);

        }
        PrintWriter writer = resp.getWriter();
        writer.print(true);
        writer.close();
    }

}
