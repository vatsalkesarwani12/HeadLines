package e.vatsal.kesarwani.headlines.Model;

import android.graphics.drawable.Drawable;

public class HomeList {
    private String catName;
    private int resWatermark;
    private Drawable color;

    public HomeList(String catName, int resWatermark, Drawable color) {
        this.catName = catName;
        this.resWatermark = resWatermark;
        this.color = color;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getResWatermark() {
        return resWatermark;
    }

    public void setResWatermark(int resWatermark) {
        this.resWatermark = resWatermark;
    }

    public Drawable getColor() {
        return color;
    }

    public void setColor(Drawable color) {
        this.color = color;
    }
}
