package e.vatsal.kesarwani.headlines.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import e.vatsal.kesarwani.headlines.Adapter.RoomRecyclerAdapter;
import e.vatsal.kesarwani.headlines.R;
import e.vatsal.kesarwani.headlines.Repository.Repository;
import e.vatsal.kesarwani.headlines.Room.NewsEntity;

public class RoomData extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RoomRecyclerAdapter recyclerAdapter;
    private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_data);
        delete=findViewById(R.id.roomDeleteAll);

        final NewsEntity newsEntity=new NewsEntity(null,null,null,null,null,null,null,null);

        final Repository repository=new Repository(getApplication());
        List<NewsEntity> newss=repository.getAllNews();

        recyclerView=findViewById(R.id.roomRecycle);

        recyclerAdapter=new RoomRecyclerAdapter(this,newss,getApplication());

        recyclerView.setAdapter(recyclerAdapter);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repository.deleteAll(newsEntity);
                Toast.makeText(RoomData.this, "All news deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
