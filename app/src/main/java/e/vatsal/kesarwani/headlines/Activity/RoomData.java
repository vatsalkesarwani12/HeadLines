package e.vatsal.kesarwani.headlines.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import e.vatsal.kesarwani.headlines.Adapter.RoomRecyclerAdapter;
import e.vatsal.kesarwani.headlines.R;
import e.vatsal.kesarwani.headlines.Repository.Repository;
import e.vatsal.kesarwani.headlines.Room.NewsEntity;

public class RoomData extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RoomRecyclerAdapter recyclerAdapter;
    //private ImageView delete;
    private Repository repository;
    private NewsEntity newsEntity;
    private Context context=this;
    private boolean isConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_data);
        /*delete=findViewById(R.id.deleteSavedNews);
        delete.setVisibility(View.VISIBLE);*/

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        final NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        newsEntity=new NewsEntity(null,null,null,null,null,null,null,null);

        repository = new Repository(getApplication());
        List<NewsEntity> newss=repository.getAllNews();

        recyclerView=findViewById(R.id.roomRecycle);

        recyclerAdapter=new RoomRecyclerAdapter(this,newss,getApplication());

        recyclerView.setAdapter(recyclerAdapter);

        /*delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repository.delete(newsEntity);
                Toast.makeText(RoomData.this, "All news deleted", Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (!isConnected){
            finishAffinity();
            finish();
        }
    }
}
