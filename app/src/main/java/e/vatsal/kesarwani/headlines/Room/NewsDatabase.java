package e.vatsal.kesarwani.headlines.Room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {NewsEntity.class},version = 1)
public abstract class NewsDatabase extends RoomDatabase {

    private static NewsDatabase instance;
    public abstract NewsDao newDao();

    public static synchronized NewsDatabase getInstance(Context context){

        if (instance == null){
            instance= Room.databaseBuilder(context.getApplicationContext(),NewsDatabase.class,"news_local_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsyncTask(instance).execute();
        }
    };

    private static class PopulateAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private NewsDao newsDao;
        PopulateAsyncTask(NewsDatabase db){
            newsDao=db.newDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            //TODO data store
            //newsDao.insert();
            return null;
        }
    }
}

