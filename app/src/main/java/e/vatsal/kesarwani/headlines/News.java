package e.vatsal.kesarwani.headlines;

import java.util.ArrayList;
import java.util.List;

public class News {

    private ArrayList<Article> article;

    public ArrayList<Article> getArticle() {
        return article;
    }

    public void setArticle(ArrayList<Article> article) {
        this.article = article;
    }

    public News(ArrayList<Article> article) {
        this.article = article;
    }


}
