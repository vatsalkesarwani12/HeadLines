package e.vatsal.kesarwani.headlines.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NewsDao {

    @Insert
    void insert(NewsEntity news);

    @Update
    void update(NewsEntity news);

    @Delete
    void delete(NewsEntity news);

    @Query("DELETE FROM news_fetched")
    void deleteAll();

    @Query("SELECT * FROM news_fetched")
    List<NewsEntity> getAllNews();
}
