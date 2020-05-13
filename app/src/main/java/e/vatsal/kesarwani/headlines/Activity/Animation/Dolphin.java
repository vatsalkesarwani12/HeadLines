package e.vatsal.kesarwani.headlines.Activity.Animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import e.vatsal.kesarwani.headlines.R;

public class Dolphin extends AppCompatActivity {

    private ImageView dolphin;
    private AnimationDrawable animationDrawable;
    private Button start,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dolphin);

        dolphin = findViewById(R.id.dolphin);
        if (dolphin == null) {
            throw new AssertionError();
        }
        dolphin.setVisibility(View.INVISIBLE);

        dolphin.setBackgroundResource(R.drawable.dolphin_animation);
        animationDrawable= (AnimationDrawable) dolphin.getBackground();
        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dolphin.setVisibility(View.VISIBLE);
                if (animationDrawable.isRunning()){
                    animationDrawable.stop();
                }
                animationDrawable.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.stop();
            }
        });
    }
}
