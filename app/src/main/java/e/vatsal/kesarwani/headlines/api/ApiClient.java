package e.vatsal.kesarwani.headlines.api;

import e.vatsal.kesarwani.headlines.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("top-headlines?country=in")
    Call<News> getNews(@Query("category") String category,
                       @Query("apiKey") String apiKey
    );


    @GET("http://newsapi.org/v2/top-headlines?country=in&apiKey=2a75f3dbcae446c4868c3e50e889dab7")
    Call<News> getNews();
}
