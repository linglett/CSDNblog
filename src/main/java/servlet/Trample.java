package servlet;

import dao.ApplicantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/trample_comment")
public class Trample extends HttpServlet {
    public Trample() {
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
        int trample=Integer.parseInt(req.getParameter("trample"))+1;
        System.out.println("cai"+trample);
        String articleid=req.getParameter("article_id");
        new ApplicantDAO().addTrample(articleid,trample);
        PrintWriter writer=resp.getWriter();
        writer.print(true);
        writer.flush();
        writer.close();

    }
}
