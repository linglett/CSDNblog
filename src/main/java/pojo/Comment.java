package pojo;

public class Comment {

    private String time;
    private String body;
    private String source;
    private String article_id;
    private int comment_id;
     public Comment(){

     }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public Comment(String time, String body, String source, String article_id, int comment_id) {
        this.time = time;
        this.body = body;
        this.source = source;
        this.article_id = article_id;
        this.comment_id = comment_id;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getTime() {
        return time;
    }

    public String getBody() {
        return body;
    }

    public String getSource() {
        return source;
    }

    public String getArticle_id() {
        return article_id;
    }
}
