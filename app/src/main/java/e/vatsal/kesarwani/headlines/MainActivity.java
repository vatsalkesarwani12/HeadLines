package e.vatsal.kesarwani.headlines;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.*;

import e.vatsal.kesarwani.headlines.api.ApiClient;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public final String base_url="https://newsapi.org/v2/";
    public final String apiKey="2a75f3dbcae446c4868c3e50e889dab7";
    public final String country="in";
    public final String category="technology";


    private TextView txt;
    public ApiClient api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=(TextView)findViewById(R.id.text);

        Gson gson= new GsonBuilder().serializeNulls().create();

        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient= new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        api=retrofit.create(ApiClient.class);

        getNew();

    }
    public void getNew()
    {
        Call<News> call;
        call =api.getNews();

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if(!response.isSuccessful())
                {
                    txt.setText("Code: "+response.code());
                    return;
                }

                List<Article> art = response.body().getArticle();

                try {

                    for (int i = 0; i < art.size(); i++) {
                        String content = "";
                        Log.v("Tag", "" + art.get(i).getAuthor());
                        content += "Author: " + art.get(i).getAuthor() + "\n ";
                        content += "Title: " + art.get(i).getTitle() + "\n";
                        content += "Description: " + art.get(i).getDescription() + "\n";
                        content += "Published At: " + art.get(i).getPublishedAt() + "\n";
                        content += "Content: " + art.get(i).getContent() + "\n\n";

                        txt.append(content);
                    }
                }
                catch(Exception e)
                {
                    txt.setText(""+e);
                }

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                txt.setText(t.getMessage());
            }
        });
    }
}
