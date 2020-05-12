package e.vatsal.kesarwani.headlines.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "news_fetched")
public class NewsEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name ;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    @ColumnInfo(name = "publish_at")
    private String publishedAt;
    private String content;

    public NewsEntity(String name, String author, String title, String description, String url, String urlToImage, String publishedAt, String content) {
        this.name = name;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }
}
