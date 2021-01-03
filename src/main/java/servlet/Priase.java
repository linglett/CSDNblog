package servlet;

import dao.ApplicantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/praise_comment")
public class Priase extends HttpServlet {
    public Priase() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        int praise=Integer.parseInt(req.getParameter("praise"))+1;
        System.out.println("赞"+praise);
        String articleid=req.getParameter("article_id");
        new ApplicantDAO().addPraise(articleid,praise);
        PrintWriter writer=resp.getWriter();
        writer.print(true);
        writer.close();
    }
}
