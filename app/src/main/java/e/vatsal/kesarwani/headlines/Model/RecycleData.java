package e.vatsal.kesarwani.headlines.Model;

import android.widget.ImageView;
import android.widget.TextView;

public class RecycleData {

    private String newsimage;
    private String newstitle;
    private String newsdescription;
    private String newsname;
    private String newsContent;
    private String imgId;
    private String urlToNews;
    private String publishAt;

    public RecycleData(String newsimage, String newstitle, String newsdescription, String newsname, String newsContent, String imgId, String urlToNews, String publishAt) {
        this.newsimage = newsimage;
        this.newstitle = newstitle;
        this.newsdescription = newsdescription;
        this.newsname = newsname;
        this.newsContent = newsContent;
        this.imgId = imgId;
        this.urlToNews=urlToNews;
        this.publishAt=publishAt;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public String getImgId() {
        return imgId;
    }

    public String getNewsimage() {
        return newsimage;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public String getNewsdescription() {
        return newsdescription;
    }

    public String getNewsname() {
        return newsname;
    }

    public String getUrlToNews() {
        return urlToNews;
    }

    public String getPublishAt() {
        return publishAt;
    }
}
