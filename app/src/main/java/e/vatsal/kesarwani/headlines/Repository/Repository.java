package e.vatsal.kesarwani.headlines.Repository;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import e.vatsal.kesarwani.headlines.Room.NewsDao;
import e.vatsal.kesarwani.headlines.Room.NewsDatabase;
import e.vatsal.kesarwani.headlines.Room.NewsEntity;

public class Repository {
    private NewsDao newsDao;
    private List<NewsEntity> allNews;

    public final static String TITLE="title";
    public final static String NAME="name";
    public final static String AUTHOR="author";
    public final static String DESCRIPTION="description";
    public final static String URL="url";
    public final static String URLTOIMAGE="urlToImage";
    public final static String PUBLISHED="published";
    public final static String CONTENT="content";

    public Repository(Application application) {
        NewsDatabase db=NewsDatabase.getInstance(application);
        newsDao=db.newDao();
        allNews=newsDao.getAllNews();
    }

    public void insert(NewsEntity newsEntity){
        new insertNewsTask(newsDao).execute(newsEntity);
    }
    public void update(NewsEntity newsEntity){
        new UpdateNewsTask(newsDao).execute(newsEntity);
    }
    public void delete(NewsEntity newsEntity){
        new DeleteNewsTask(newsDao).execute(newsEntity);
    }
    public void deleteAll(NewsEntity newsEntity){
        new DeleteAllNewsTask(newsDao).execute();
    }
    public List<NewsEntity> getAllNews(){
        return allNews;
    }

    public class insertNewsTask extends AsyncTask<NewsEntity,Void,Void>{
        private NewsDao newsDao;

        public insertNewsTask(NewsDao newsDao) {
            this.newsDao = newsDao;
        }

        @Override
        protected Void doInBackground(NewsEntity... newsEntities) {
            newsDao.insert(newsEntities[0]);
            return null;
        }
    }

    public class UpdateNewsTask extends AsyncTask<NewsEntity,Void,Void>{
        private NewsDao newsDao;

        public UpdateNewsTask(NewsDao newsDao) {
            this.newsDao = newsDao;
        }

        @Override
        protected Void doInBackground(NewsEntity... newsEntities) {
            newsDao.update(newsEntities[0]);
            return null;
        }
    }

    public class DeleteNewsTask extends AsyncTask<NewsEntity,Void,Void>{
        private NewsDao newsDao;

        public DeleteNewsTask(NewsDao newsDao) {
            this.newsDao = newsDao;
        }

        @Override
        protected Void doInBackground(NewsEntity... newsEntities) {
            newsDao.delete(newsEntities[0]);
            return null;
        }
    }

    public class DeleteAllNewsTask extends AsyncTask<Void,Void,Void>{
        private NewsDao newsDao;

        public DeleteAllNewsTask(NewsDao newsDao) {
            this.newsDao = newsDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            newsDao.deleteAll();
            return null;
        }
    }
}
