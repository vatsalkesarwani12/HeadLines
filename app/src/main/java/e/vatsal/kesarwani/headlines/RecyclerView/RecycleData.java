package e.vatsal.kesarwani.headlines.RecyclerView;

import android.widget.ImageView;
import android.widget.TextView;

public class RecycleData {

    private String newsimage;
    private String newstitle;
    private String newsdescription;
    private String newsname;

    public RecycleData(String newsimage, String newstitle, String newsdescription, String newsname) {
        this.newsimage = newsimage;
        this.newstitle = newstitle;
        this.newsdescription = newsdescription;
        this.newsname = newsname;
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
