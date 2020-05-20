package e.vatsal.kesarwani.headlines.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import e.vatsal.kesarwani.headlines.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private String business="business";
    private CardView buss,enter,health,science,sports,techno;
    private Button room;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeViews();

        ClickListener();

    }

    private void ClickListener() {
        buss.setOnClickListener(this);
        enter.setOnClickListener(this);
        health.setOnClickListener(this);
        science.setOnClickListener(this);
        sports.setOnClickListener(this);
        techno.setOnClickListener(this);
        /*sql.setOnClickListener(this);*/
        room.setOnClickListener(this);
    }

    private void initializeViews() {
        buss=findViewById(R.id.business);
        enter=findViewById(R.id.entertainment);
        health=findViewById(R.id.health);
        science=findViewById(R.id.science);
        sports=findViewById(R.id.sports);
        techno=findViewById(R.id.techno);
        /*sql=findViewById(R.id.sql);*/
        room=findViewById(R.id.roomButton);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        Intent intent=new Intent(HomeActivity.this, MainActivity.class);
        switch (id)
        {
            case (R.id.business):
                intent.putExtra("news",business);
                startActivity(intent);
                break;

            case R.id.entertainment:
                intent.putExtra("news","entertainment");
                startActivity(intent);
                break;

            case R.id.health:
                intent.putExtra("news","health");
                startActivity(intent);
                break;

            case R.id.science:
                intent.putExtra("news","science");
                startActivity(intent);
                break;

            case R.id.sports:
                intent.putExtra("news","sports");
                startActivity(intent);
                break;

            case R.id.techno:
                intent.putExtra("news","technology");
                startActivity(intent);
                break;

            /*case R.id.sql:
                //startActivity(new Intent(getApplicationContext(),SqlDatabase.class));
                break;*/

            case R.id.roomButton:
                startActivity(new Intent(getApplicationContext(),RoomData.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        finish();
    }
}
