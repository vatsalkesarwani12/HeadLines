package e.vatsal.kesarwani.headlines.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import e.vatsal.kesarwani.headlines.R;

public class splash extends AppCompatActivity {

    private ProgressBar progressBar;

    private Context context=this;

    //font
    /*textView.setTypeface(ResourcesCompat.getFont(context, R.font.abc_font))*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);


        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        final boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        //Toast.makeText(context, ""+isConnected, Toast.LENGTH_SHORT).show();

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
                    if (isConnected) {
                        Intent intent = new Intent(splash.this, homefinal.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent = new Intent(splash.this, RoomData.class);
                        startActivity(intent);
                    }
                }
            }
        };
        thread.start();

    }
}
