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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import e.vatsal.kesarwani.headlines.R;

public class splash extends AppCompatActivity {

    private ProgressBar progressBar;

    private Context context=this;
    private AdView mAdView;

    //font
    /*textView.setTypeface(ResourcesCompat.getFont(context, R.font.abc_font))*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        initviews();
        final AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);


        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        final boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        //Toast.makeText(context, ""+isConnected, Toast.LENGTH_SHORT).show();

        progressBar=findViewById(R.id.pp);
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {

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


        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                /*startActivity(new Intent(getApplicationContext(),homefinal.class));
                Toast.makeText(context, "add shown", Toast.LENGTH_SHORT).show();*/
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                /*startActivity(new Intent(getApplicationContext(),homefinal.class));
                Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();*/
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
    }

    private void initviews() {
        mAdView = findViewById(R.id.adView);
    }
}
