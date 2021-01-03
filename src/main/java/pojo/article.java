package pojo;

import javafx.collections.ObservableList;

public class article {
    private String title;
    private String author;
    private String body;
    private int praise;
    private int trample;
    private int article_id;
    private ObservableList<Comment> comment;

    public article(String title, String author, String body, int praise, int trample, int article_id, ObservableList<Comment> comment) {
        this.title = title;
        this.author = author;
        this.body = body;
        this.praise = praise;
        this.trample = trample;
        this.article_id = article_id;
        this.comment = comment;
    }

    public article() {
    }

    public article(String title, String author, String body, int praise, int trample, int id) {
        this.title = title;
        this.author = author;
        this.body = body;
        this.praise = praise;
        this.trample = trample;
        this.article_id =id;
    }

    public ObservableList<Comment> getComment() {
        return comment;
    }

    public void test(){
        for (Comment c:comment
             ) {
            System.out.println("plun"+c.getBody());
        }
    }
    public String getTitle() {
        return title;
    }

    public int getArticle_id() {
        return article_id;
    }

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public int getPraise() {
        return praise;
    }

    public int getTrample() {
        return trample;
    }
}
