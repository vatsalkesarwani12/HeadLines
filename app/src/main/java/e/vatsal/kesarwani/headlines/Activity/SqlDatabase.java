/*
package e.vatsal.kesarwani.headlines.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import e.vatsal.kesarwani.headlines.Adapter.DataItemAdapter;
import e.vatsal.kesarwani.headlines.Model.DataItem;
import e.vatsal.kesarwani.headlines.R;

public class SqlDatabase extends AppCompatActivity {

    //DataSource mDataSource;
    List<DataItem> listFromDB;
    RecyclerView mRecyclerView;
    DataItemAdapter mItemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_database);

        mRecyclerView=findViewById(R.id.recyclerDatabase);


        mDataSource = new DataSource(this);
        mDataSource.open();

        displayDataItems();
    }

    private void displayDataItems() {
        listFromDB = mDataSource.getAllItems();
        mItemAdapter = new DataItemAdapter(this, listFromDB);
        mRecyclerView.setAdapter(mItemAdapter);
    }

}
*/
