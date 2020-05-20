package e.vatsal.kesarwani.headlines.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import e.vatsal.kesarwani.headlines.R;
import e.vatsal.kesarwani.headlines.Repository.Repository;
import e.vatsal.kesarwani.headlines.Room.NewsEntity;

public class DeepNews extends AppCompatActivity {

    private static Intent intent;
    private TextView mtitle, mdescription, mcontent;
    private ImageView imgRes, home, like, dislike, share;
    private String img;
    private TextView name;
    /* private DataSource mDataSource;
     private SQLiteDatabase db;
     private SQLiteDatabaseHelper mDbHelper;*/
    //database
    private Repository repository;
    private List<NewsEntity> newss;
    private NewsEntity newsEntity;
    private int a = -1;
    private RelativeLayout layout;
    private String s = "";
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_news);

        initailzeViews();
        loadViews();

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);


        assert cm != null;
        final NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        final boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (!isConnected) {
            like.setVisibility(View.GONE);
            dislike.setVisibility(View.GONE);
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a == 1) {
                    save();
                }
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        });

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = 1;
                like.setVisibility(View.GONE);
                dislike.setVisibility(View.VISIBLE);
                Toast.makeText(DeepNews.this, "Saved", Toast.LENGTH_SHORT).show();
            }
        });

        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = 0;
                like.setVisibility(View.VISIBLE);
                dislike.setVisibility(View.GONE);
                Toast.makeText(DeepNews.this, "Delete", Toast.LENGTH_SHORT).show();
            }
        });

        imgRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected) {
                    Uri webpage = Uri.parse(s);
                    Intent i = new Intent(Intent.ACTION_VIEW, webpage);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(i);
                    }
                } else {
                    Snackbar snackbar = Snackbar
                            .make(imgRes, "Allow Internet Access", Snackbar.LENGTH_LONG)
                            .setAction("Allow", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    ConnectivityManager cm1 = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                                    assert cm1 != null;
                                    NetworkInfo activeNetwork = cm1.getActiveNetworkInfo();
                                    boolean isConnected1 = activeNetwork != null &&
                                            activeNetwork.isConnectedOrConnecting();
                                    if (isConnected1){
                                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                                    }
                                }
                            });
                    snackbar.show();
                }
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(Intent.ACTION_SEND);
                ii.setType("text/plain");
                ii.putExtra(Intent.EXTRA_TEXT, intent.getStringExtra(Repository.TITLE) + "\n\nDownload HeadLines App from the Playstore \n\n" + s);
                if (ii.resolveActivity(getPackageManager()) != null) {
                    startActivity(ii);
                }
            }
        });
    }

    private void save() {
        /*like.setVisibility(View.GONE);
        dislike.setVisibility(View.VISIBLE);
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();*/
        /*mDataSource = new DataSource(this);
        mDataSource.open();

        try {
            mDataSource.createItem();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        newsEntity = new NewsEntity(
                intent.getStringExtra(Repository.NAME),
                intent.getStringExtra(Repository.AUTHOR),
                intent.getStringExtra(Repository.TITLE),
                intent.getStringExtra(Repository.DESCRIPTION),
                intent.getStringExtra(Repository.URL),
                intent.getStringExtra(Repository.URLTOIMAGE),
                intent.getStringExtra(Repository.PUBLISHED),
                intent.getStringExtra(Repository.CONTENT));

        repository.insert(newsEntity);

    }

    /*public static ContentValues toValues() {
        ContentValues values = new ContentValues(7);
        values.put(DatabaseItems.COLUMN_NAME, intent.getStringExtra("name"));
        values.put(DatabaseItems.COLUMN_DESCRIPTION, intent.getStringExtra("description"));
        values.put(DatabaseItems.COLUMN_TITLE, intent.getStringExtra("title"));
        values.put(DatabaseItems.COLUMN_CONTENT, intent.getStringExtra("content"));
        values.put(DatabaseItems.COLUMN_URL, intent.getStringExtra("urlToNews"));
        values.put(DatabaseItems.COLUMN_URL_TO_IMAGE, intent.getStringExtra("image"));
        values.put(DatabaseItems.COLUMN_PUBLISHED_AT,intent.getStringExtra("publishAt"));
        return values;
    }*/

   /* private void del(){
        like.setVisibility(View.VISIBLE);
        dislike.setVisibility(View.GONE);
        Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
        *//*
        deleteRow(DatabaseItems.TABLE_ITEMS,DatabaseItems.COLUMN_TITLE,new String[]{intent.getStringExtra("title")});*//*
     *//*newsEntity = new NewsEntity(
                intent.getStringExtra(Repository.NAME),
                intent.getStringExtra(Repository.AUTHOR),
                intent.getStringExtra(Repository.TITLE),
                intent.getStringExtra(Repository.DESCRIPTION),
                intent.getStringExtra(Repository.URL),
                intent.getStringExtra(Repository.URLTOIMAGE),
                intent.getStringExtra(Repository.PUBLISHED),
                intent.getStringExtra(Repository.CONTENT));*//*

        //repository.delete(newsEntity);
    }*/

    /*public void deleteRow(String table_name,String column_name,String[] args){
        int a=db.delete(table_name,column_name+"=",args);
    }*/


    private void loadViews() {
        intent = getIntent();
        mtitle.setText(intent.getStringExtra(Repository.TITLE));
        mdescription.setText(intent.getStringExtra(Repository.DESCRIPTION));
        mcontent.setText(intent.getStringExtra(Repository.CONTENT));
        name.setText(intent.getStringExtra(Repository.NAME));
        img = intent.getStringExtra(Repository.URLTOIMAGE);
        s = intent.getStringExtra(Repository.URL);
        Glide.with(this)
                .load(img)
                .into(imgRes);
    }

    private void initailzeViews() {
        mtitle = findViewById(R.id.news_title);
        mdescription = findViewById(R.id.news_description);
        mcontent = findViewById(R.id.news_content);
        imgRes = findViewById(R.id.newsImage);
        name = findViewById(R.id.news_name);
        home = findViewById(R.id.home);
        like = findViewById(R.id.like);
        dislike = findViewById(R.id.dislike);
        /*mDbHelper = new SQLiteDatabaseHelper(this);
        db = mDbHelper.getReadableDatabase();*/
        repository = new Repository(getApplication());
        layout = findViewById(R.id.bar01);
        share = findViewById(R.id.news_share);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (a == 1)
            save();
    }
}
