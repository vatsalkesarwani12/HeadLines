package e.vatsal.kesarwani.headlines.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import e.vatsal.kesarwani.headlines.Model.Article;
import e.vatsal.kesarwani.headlines.Model.News;
import e.vatsal.kesarwani.headlines.R;
import e.vatsal.kesarwani.headlines.Model.RecycleData;
import e.vatsal.kesarwani.headlines.Adapter.RecyclerAdapter;
import e.vatsal.kesarwani.headlines.Repository.Repository;
import e.vatsal.kesarwani.headlines.api.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public final String base_url="https://newsapi.org/v2/";
    public final String apiKey="2a75f3dbcae446c4868c3e50e889dab7";
    public final String country="in";
    public  String category;
    private Context context=this;
    private Intent intent;

    private RecyclerView mrecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerAdapter mrecycleAdapter;
    private SwipeRefreshLayout mSwipe;

    final ArrayList<RecycleData> mdata=new ArrayList<>();

    public ApiClient api;

    private TextView text;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=(TextView)findViewById(R.id.tee);
        mSwipe=findViewById(R.id.refresh);

        mSwipe.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        mSwipe.setRefreshing(true);
                    }
                }
        );

        Gson gson= new GsonBuilder().serializeNulls().create();

        intent=getIntent();
        category=intent.getStringExtra("news");


       /*HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient= new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();*/

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                //.client(okHttpClient)
                .build();
        api = retrofit.create(ApiClient.class);

        Call<News> call = api.getNews(category,apiKey);
       // Call<News> call = api.getNews();

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if(!response.isSuccessful())
                {
                    //titletxt.setText("Code: "+response.body().getArticle().get(1).getAuthor());
                    return;
                }

                ArrayList<Article> art = response.body().getArticle();
                Log.v("Tag", "" + art.get(1).getAuthor());

                try {

                    for (int i = 0; i < art.size(); i++) {
                        String content = "";
                        content += "Name: " + art.get(i).getSource().getName() + "\n";
                        content +="Author: "+art.get(i).getAuthor()+"\n";
                        content += "Title: " + art.get(i).getTitle() + "\n";
                        content += "Description: " + art.get(i).getDescription() + "\n";
                        content += "Published At: " + art.get(i).getPublishedAt() + "\n";
                        content += "Content: " + art.get(i).getContent() + "\n\n";


                       // titletxt.append(content);
                        mdata.add(new RecycleData(
                                art.get(i).getUrlToImage(),
                                art.get(i).getTitle(),
                                art.get(i).getDescription(),
                                art.get(i).getSource().getName(),
                                art.get(i).getContent(),
                                art.get(i).getUrlToImage(),
                                art.get(i).getUrl(),
                                art.get(i).getPublishedAt()
                                )
                        );

                        Intent data = new Intent();
                        data.putExtra(Repository.TITLE, art.get(i).getTitle());
                        data.putExtra(Repository.NAME, art.get(i).getSource().getName());
                        data.putExtra(Repository.AUTHOR, art.get(i).getAuthor());
                        data.putExtra(Repository.URL, art.get(i).getUrl());
                        data.putExtra(Repository.DESCRIPTION, art.get(i).getDescription());
                        data.putExtra(Repository.URLTOIMAGE, art.get(i).getUrlToImage());
                        data.putExtra(Repository.PUBLISHED, art.get(i).getPublishedAt());
                        data.putExtra(Repository.CONTENT, art.get(i).getContent());

                        setResult(RESULT_OK, data);

                    }
                }
                catch(Exception e)
                {
                    text.setText(""+e);
                }

                //recycler view setup
                mrecyclerView=findViewById(R.id.recycle);
                mrecyclerView.setHasFixedSize(true);

                mLayoutManager=new LinearLayoutManager(context);

                mrecycleAdapter=new RecyclerAdapter(mdata,MainActivity.this);

                mrecyclerView.setLayoutManager(mLayoutManager);
                mrecyclerView.setAdapter(mrecycleAdapter);

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });

    }

}
