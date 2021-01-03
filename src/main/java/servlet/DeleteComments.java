package servlet;

import dao.ApplicantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete_comments")
public class DeleteComments extends HttpServlet {
    public DeleteComments() {
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
        int comment_id= Integer.parseInt(req.getParameter("comment_id"));
        new ApplicantDAO().deleteComment(comment_id);
        PrintWriter writer=resp.getWriter();
        writer.print(true);
        writer.flush();
        writer.close();

    }
}
