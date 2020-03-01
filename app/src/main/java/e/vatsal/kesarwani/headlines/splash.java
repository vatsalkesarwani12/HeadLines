package e.vatsal.kesarwani.headlines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class splash extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        progressBar=(ProgressBar)findViewById(R.id.pp);
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    /*sleep(500);
                    for(int i=0;i<=25;i++)
                    progressBar.setProgress(i);
                    sleep(500);
                    for(int i=26;i<=50;i++)
                    progressBar.setProgress(i);
                    sleep(500);
                    for(int i=51;i<=75;i++)
                    progressBar.setProgress(i);
                    sleep(500);
                    for(int i=76;i<=100;i++)
                    progressBar.setProgress(i);*/
                    for(int i=0;i<=100;i++)
                    {
                        progressBar.setProgress(i);
                        sleep(20);
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(splash.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();

    }
}
