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
}
