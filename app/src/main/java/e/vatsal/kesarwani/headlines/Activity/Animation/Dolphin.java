package e.vatsal.kesarwani.headlines.Activity.Animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import e.vatsal.kesarwani.headlines.Activity.MainActivity;
import e.vatsal.kesarwani.headlines.R;

public class Dolphin extends AppCompatActivity {

    private ImageView dolphin;
    private AnimationDrawable animationDrawable;
    //private Button start,stop;
    private Intent intent,i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dolphin);

        i=getIntent();

        dolphin = findViewById(R.id.dolphin);
        if (dolphin == null) {
            throw new AssertionError();
        }
        /*dolphin.setVisibility(View.INVISIBLE);*/



        Handler h=new Handler();
        h.post(new Runnable() {
            @Override
            public void run() {
                dolphin.setBackgroundResource(R.drawable.dolphin_animation);
                animationDrawable= (AnimationDrawable) dolphin.getBackground();
                animationDrawable.isOneShot();
                animationDrawable.start();
            }
        });
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                intent= new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("news",i.getStringExtra("news"));
                startActivity(intent);
            }
        },2000);


       /* try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            intent= new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("news",intent.getStringExtra("news"));
            startActivity(intent);
        }*/

        /*start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);*/


        /*start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dolphin.setVisibility(View.VISIBLE);
                if (animationDrawable.isRunning()){
                    animationDrawable.stop();
                }
                animationDrawable.start();
            }
        });*/

        /*stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.stop();
            }
        });*/
    }
}
