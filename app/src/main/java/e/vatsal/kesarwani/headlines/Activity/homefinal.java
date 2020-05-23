package e.vatsal.kesarwani.headlines.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import e.vatsal.kesarwani.headlines.Adapter.HomeAdapter;
import e.vatsal.kesarwani.headlines.Model.HomeList;
import e.vatsal.kesarwani.headlines.R;

public class homefinal extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private ArrayList<HomeList> listCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activtiy);

        listCategory=new ArrayList<>();

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

        recyclerView.setAdapter(adapter);

    }
}
