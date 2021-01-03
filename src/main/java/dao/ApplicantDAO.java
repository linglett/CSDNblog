package dao;

import pojo.Applicant;
import pojo.Comment;
import pojo.article;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApplicantDAO {
    public String login(String email, String password, String data_kind) {
        String applicationdata = null;
        Connection conn = DBUtil.DriverAndConnect();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tb_user WHERE email = ? and password=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (data_kind.equals("id"))
                    applicationdata = rs.getString(1);
                if(data_kind.equals("sex"))
                    applicationdata = rs.getString(4);
                if(data_kind.equals("address"))
                    applicationdata = rs.getString(5);
                if(data_kind.equals("business"))
                    applicationdata = rs.getString(6);
                if(data_kind.equals("phonenumber"))
                    applicationdata = rs.getString(7);
                if(data_kind.equals("job"))
                    applicationdata = rs.getString(8);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pstmt, conn);
        }
        return applicationdata;
    }

    public boolean isExistEmail(String email) {
        Connection conn = DBUtil.DriverAndConnect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tb_user WHERE email =? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pst, conn);
        }
        return false;
    }
    public void save(String name, String email, String password) {
        Connection conn = DBUtil.DriverAndConnect();
        PreparedStatement pst = null;
        String sql = "insert into tb_user(id,email,password) values(?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pst, conn);
        }
    }
    public void change(String name, String Sex, String location, String business, String job, String phonenum, String email) throws SQLException {
        Connection conn = DBUtil.DriverAndConnect();
        PreparedStatement ChangeUser1 = conn.prepareStatement("update tb_user set id=?,sex=?,address=?,business=?,phonenumber=?,job=? where email= ?");
        ChangeUser1.setString(1, name);
        ChangeUser1.setString(2, Sex);
        ChangeUser1.setString(3, location);
        ChangeUser1.setString(4, business);
        ChangeUser1.setString(5, job);
        ChangeUser1.setString(6, phonenum);
        ChangeUser1.setString(7, email);
        ChangeUser1.executeUpdate();
        /*try{
            PreparedStatement ChangeUser1=conn.prepareStatement("update tb_user set id = ? where account= ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
    public void Article_Save(String user,Blob article,String title,String article_keyword)  {
        Connection conn = DBUtil.DriverAndConnect();
        try {
            PreparedStatement Save_article = conn.prepareStatement(" insert into blogs(author,article,praise,trample,title,keyword) values(?,?,?,?,?,?)");
            Save_article.setString(1,user);
            Save_article.setBlob(2,article);
            Save_article.setInt(3,0);
            Save_article.setInt(4,0);
            Save_article.setString(5,title);
            Save_article.setString(6,article_keyword);
            Save_article.executeUpdate();
            Save_article.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ObservableList getArticle(String email){
        Connection conn = DBUtil.DriverAndConnect();
        ResultSet rs=null;
        ObservableList<article> article_datas=null;
        try {
            PreparedStatement Save_article=conn.prepareStatement("SELECT * FROM blogs WHERE author=?");
            Save_article.setString(1,email);
            rs=Save_article.executeQuery();
            article_datas = FXCollections.observableArrayList();
                while(rs.next())
                {
                   Blob a=rs.getBlob(2);
                    article C1=new article(rs.getString(5),rs.getString(1),
                            this.BlobToString(rs.getBlob(2)),rs.getInt(3),rs.getInt(4),rs.getInt(6));
                    article_datas.add(C1);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article_datas;
    }

    public ObservableList getArticle_return(String id){
        Connection conn = DBUtil.DriverAndConnect();
        ResultSet rs=null;
        ObservableList<article> article_datas=null;
        ObservableList<Comment> article_comments=getComment(id);
        try {
            PreparedStatement Save_article=conn.prepareStatement("SELECT * FROM blogs WHERE id=?");
            Save_article.setInt(1,Integer.parseInt(id));
            rs=Save_article.executeQuery();
            article_datas = FXCollections.observableArrayList();
            while(rs.next())
            {
                Blob a=rs.getBlob(2);
                article C1=new article(rs.getString(5),rs.getString(1),
                        this.BlobToString(rs.getBlob(2)),rs.getInt(3),rs.getInt(4),rs.getInt(6),article_comments);
                article_datas.add(C1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article_datas;
    }
    //blob转化为String
    public String BlobToString(Blob blob) {
        byte[] bdata = new byte[0];
        try {
            bdata = blob.getBytes(1, (int) blob.length());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String s = null;
        try {
            s = new String(bdata,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }
    public ObservableList SearchArticle(String keyword)
    {
        Connection conn = DBUtil.DriverAndConnect();
        ResultSet rs=null;
        ObservableList<article> likearticle =null;
        String sql = "SELECT * FROM blogs WHERE title like '%" + keyword + "%' OR author like '%" + keyword + "%' OR keyword like '%" + keyword + "%' ";
        try {
            PreparedStatement article=conn.prepareStatement(sql);
            rs=article.executeQuery();
            likearticle = FXCollections.observableArrayList();
            while (rs.next()) {
                article C1=new article(rs.getString(5),rs.getString(1),
                        this.BlobToString(rs.getBlob(2)),rs.getInt(3),rs.getInt(4),rs.getInt(6));
                likearticle.add(C1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (article a:
             likearticle) {
            System.out.println(a.getTitle());
        }
        return likearticle;
    }
    public ObservableList Recommend_article()
    {
        Connection conn = DBUtil.DriverAndConnect();
        ResultSet rs=null;
        ObservableList<article> likearticle =null;
        String sql = "select * from blogs order by praise desc";
        try {
            PreparedStatement article=conn.prepareStatement(sql);
            rs=article.executeQuery();
            likearticle = FXCollections.observableArrayList();
            while (rs.next()) {
                article C1=new article(rs.getString(5),rs.getString(1),
                        this.BlobToString(rs.getBlob(2)),rs.getInt(3),rs.getInt(4),rs.getInt(6));
                likearticle.add(C1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likearticle;
    }
    public ObservableList Recommend_article(String keyword)
    {
        Connection conn = DBUtil.DriverAndConnect();
        ResultSet rs=null;
        ObservableList<article> likearticle =null;
        String sql = "SELECT * FROM blogs WHERE title like '%" + keyword + "%' OR author like '%" + keyword + "%' OR keyword like '%" + keyword + "%' ";

        try {
            PreparedStatement article=conn.prepareStatement(sql);
            rs=article.executeQuery();
            likearticle = FXCollections.observableArrayList();
            while (rs.next()) {
                article C1=new article(rs.getString(5),rs.getString(1),
                        this.BlobToString(rs.getBlob(2)),rs.getInt(3),rs.getInt(4),rs.getInt(6));
                likearticle.add(C1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (article a:
                likearticle) {
            System.out.println(a.getTitle());
        }
        for (article c1:
                likearticle) {
            System.out.println("fenlei"+c1.getTitle());
        }
        return likearticle;
    }

    public void Save_Comments(Applicant source, String body,String time,int article_id)
    {
        Connection conn = DBUtil.DriverAndConnect();
        try {
            PreparedStatement Save_article = conn.prepareStatement(" insert into comments(source,body,time,articleid) values(?,?,?,?)");
            if(source!=null)
                Save_article.setString(1,source.getapplicantemail());
            else Save_article.setString(1,"游客");
            Save_article.setString(2,body);
            Save_article.setString(3,time);
            Save_article.setInt(4,article_id);
            Save_article.executeUpdate();
            Save_article.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ObservableList getComment(String article_id){
        Connection conn = DBUtil.DriverAndConnect();
        ResultSet rs=null;
        ObservableList<Comment> article_comments=null;
        try {
            PreparedStatement Save_article=conn.prepareStatement("SELECT * FROM comments WHERE articleid=?");
            Save_article.setString(1,article_id);
            rs=Save_article.executeQuery();
            article_comments = FXCollections.observableArrayList();
            while(rs.next())
            {
                Comment C1=new Comment(rs.getString(3),rs.getString(2),
                        this.BlobToString(rs.getBlob(1)),rs.getString(4),rs.getInt(5));
                article_comments.add(C1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article_comments;
    }
    public void addPraise(String article_id,int praise){
        Connection conn = DBUtil.DriverAndConnect();
        PreparedStatement ChangePraise = null;
        try {
            ChangePraise = conn.prepareStatement("update blogs set praise = ? where id= ?");
            ChangePraise.setInt(1,praise);
            ChangePraise.setString(2, article_id);
            ChangePraise.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void addTrample(String article_id,int trample){
        Connection conn = DBUtil.DriverAndConnect();
        PreparedStatement Changetrample = null;
        try {
            Changetrample = conn.prepareStatement("update blogs set trample =? where id= ?");
            Changetrample.setInt(1, trample);
            Changetrample.setString(2, article_id);
            Changetrample.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteComment(int comment_id){
        Connection conn = DBUtil.DriverAndConnect();
        PreparedStatement Changetrample = null;
        try {
            Changetrample = conn.prepareStatement("delete from comments where comment_id=?");
            Changetrample.setInt(1, comment_id);
            Changetrample.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ObservableList ReturnUser(){
        Connection conn = DBUtil.DriverAndConnect();
        ResultSet rs=null;
        ObservableList<Applicant> likeuser =null;
        String sql = "select * from tb_user";
        try {
            PreparedStatement article=conn.prepareStatement(sql);
            rs=article.executeQuery();
            likeuser = FXCollections.observableArrayList();
            while (rs.next()) {
                Applicant applicant =new Applicant(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getString(8));
                likeuser.add(applicant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likeuser;
    }
    public ObservableList ReturnBlogs(){
        Connection conn = DBUtil.DriverAndConnect();
        ResultSet rs=null;
        ObservableList<article> likeuser =null;
        String sql = "select * from blogs";
        try {
            PreparedStatement article=conn.prepareStatement(sql);
            rs=article.executeQuery();
            likeuser = FXCollections.observableArrayList();
            while (rs.next()) {
                Blob a=rs.getBlob(2);
                ObservableList<Comment> article_comments=getComment(String.valueOf(rs.getInt(6)));
                article C1=new article(rs.getString(5),rs.getString(1),
                        this.BlobToString(rs.getBlob(2)),rs.getInt(3),rs.getInt(4),rs.getInt(6),article_comments);
                likeuser.add(C1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likeuser;
    }
    public void deleteuser(String email){
        Connection conn = DBUtil.DriverAndConnect();
        PreparedStatement Changetrample = null;
        try {
            Changetrample = conn.prepareStatement("delete from tb_user where email =?");
            Changetrample.setString(1, email);
            Changetrample.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteblogs(String blogs_id){
        Connection conn = DBUtil.DriverAndConnect();
        PreparedStatement Changetrample = null;
        try {
            Changetrample = conn.prepareStatement("delete from blogs where id =?");
            Changetrample.setString(1, blogs_id);
            Changetrample.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //获取系统时间
    public static String getStringDate()
    {
        java.util.Date TimeOfNow = new Date();
        SimpleDateFormat tostring = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time;
        time = tostring.format(TimeOfNow);
        return time;
    }
}