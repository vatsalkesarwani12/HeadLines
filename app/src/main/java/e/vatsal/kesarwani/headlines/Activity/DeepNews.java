package e.vatsal.kesarwani.headlines.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import e.vatsal.kesarwani.headlines.Database.DataSource;
import e.vatsal.kesarwani.headlines.Database.DatabaseItems;
import e.vatsal.kesarwani.headlines.Database.SQLiteDatabaseHelper;
import e.vatsal.kesarwani.headlines.R;

public class DeepNews extends AppCompatActivity {

    private static Intent intent;
    private TextView mtitle, mdescription, mcontent;
    private ImageView imgRes,home,like,dislike ;
    private String img;
    private TextView name;
    private DataSource mDataSource;
    private SQLiteDatabase db;
    private SQLiteDatabaseHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_news);

        initailzeViews();
        loadViews();

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                del();
            }
        });
    }

    private void save() {
        like.setVisibility(View.GONE);
        dislike.setVisibility(View.VISIBLE);
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        mDataSource = new DataSource(this);
        mDataSource.open();

        try {
            mDataSource.createItem();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ContentValues toValues() {
        ContentValues values = new ContentValues(7);
        values.put(DatabaseItems.COLUMN_NAME, intent.getStringExtra("name"));
        values.put(DatabaseItems.COLUMN_DESCRIPTION, intent.getStringExtra("description"));
        values.put(DatabaseItems.COLUMN_TITLE, intent.getStringExtra("title"));
        values.put(DatabaseItems.COLUMN_CONTENT, intent.getStringExtra("content"));
        values.put(DatabaseItems.COLUMN_URL, intent.getStringExtra("urlToNews"));
        values.put(DatabaseItems.COLUMN_URL_TO_IMAGE, intent.getStringExtra("image"));
        values.put(DatabaseItems.COLUMN_PUBLISHED_AT,intent.getStringExtra("publishAt"));
        return values;
    }

    private void del(){
        like.setVisibility(View.VISIBLE);
        dislike.setVisibility(View.GONE);
        Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
        //TODO remove error
        //deleteRow(DatabaseItems.TABLE_ITEMS,DatabaseItems.COLUMN_TITLE,new String[]{intent.getStringExtra("title")});
    }

//    public void deleteRow(String table_name,String column_name,String[] args){
//        int a=db.delete(table_name,column_name,args);
//    }


    private void loadViews() {
        intent = getIntent();
        mtitle.setText(intent.getStringExtra("title"));
        mdescription.setText(intent.getStringExtra("description"));
        mcontent.setText(intent.getStringExtra("content"));
        name.setText(intent.getStringExtra("name"));
        img= intent.getStringExtra("image");
        Glide.with(this)
                .load(img)
                .into(imgRes);
    }

    private void initailzeViews() {
        mtitle = findViewById(R.id.news_title);
        mdescription = findViewById(R.id.news_description);
        mcontent = findViewById(R.id.news_content);
        imgRes = findViewById(R.id.newsImage);
        name=findViewById(R.id.news_name);
        home=findViewById(R.id.home);
        like=findViewById(R.id.like);
        dislike=findViewById(R.id.dislike);
        mDbHelper = new SQLiteDatabaseHelper(this);
        db = mDbHelper.getReadableDatabase();
    }
}
