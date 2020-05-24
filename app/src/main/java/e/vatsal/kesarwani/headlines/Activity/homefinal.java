package e.vatsal.kesarwani.headlines.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import e.vatsal.kesarwani.headlines.Activity.Animation.Dolphin;
import e.vatsal.kesarwani.headlines.Adapter.HomeAdapter;
import e.vatsal.kesarwani.headlines.Model.HomeList;
import e.vatsal.kesarwani.headlines.R;

public class homefinal extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private ArrayList<HomeList> listCategory;
    private ImageView fab;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activtiy);

        fab=findViewById(R.id.fab);

        listCategory=new ArrayList<>();

        intent = new Intent(homefinal.this, Dolphin.class);

        listCategory.add(new HomeList("Technology",R.drawable.ic_tech,getDrawable(R.drawable.ic_darkpurplelist)));
        listCategory.add(new HomeList("Entertainment",R.drawable.ic_enter,getDrawable(R.drawable.ic_purplelist)));
        listCategory.add(new HomeList("Sports",R.drawable.ic_spo,getDrawable(R.drawable.ic_lightbluelist)));
        listCategory.add(new HomeList("Health",R.drawable.ic_hos,getDrawable(R.drawable.ic_pinklistt)));
        listCategory.add(new HomeList("Science",R.drawable.ic_sci,getDrawable(R.drawable.ic_orangelist)));
        listCategory.add(new HomeList("Business",R.drawable.ic_buss,getDrawable(R.drawable.ic_listblue)));
        listCategory.add(new HomeList("null",R.drawable.ic_tech,getDrawable(R.drawable.ic_white)));
        //listCategory.add(new HomeList("null",R.drawable.ic_listblue,getDrawable(R.drawable.ic_listblue)));

        recyclerView=findViewById(R.id.homeRecycle);
        adapter=new HomeAdapter(this,listCategory);
        recyclerView.setHasFixedSize(true);

        new ItemTouchHelper(itemTouchHelper).attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RoomData.class));
            }
        });

    }

    ItemTouchHelper.SimpleCallback itemTouchHelper=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            //Toast.makeText(homefinal.this, ""+listCategory.get(viewHolder.getAdapterPosition()).getCatName(), Toast.LENGTH_SHORT).show();
            if ("null".equals(listCategory.get(viewHolder.getAdapterPosition()).getCatName())) {
                adapter.notifyDataSetChanged();
            }
            else {
                intent.putExtra("news", listCategory.get(viewHolder.getAdapterPosition()).getCatName());
                adapter.notifyDataSetChanged();
                startActivity(intent);
            }
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        finish();
    }

}
