package e.vatsal.kesarwani.headlines.RecyclerView;

import android.widget.ImageView;
import android.widget.TextView;

public class RecycleData {

    private String newsimage;
    private String newstitle;
    private String newsdescription;
    private String newsname;
    private String newsContent;
    private String imgId;

    public RecycleData(String newsimage, String newstitle, String newsdescription, String newsname, String newsContent, String imgId) {
        this.newsimage = newsimage;
        this.newstitle = newstitle;
        this.newsdescription = newsdescription;
        this.newsname = newsname;
        this.newsContent = newsContent;
        this.imgId = imgId;
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
}
