package e.vatsal.kesarwani.headlines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DeepNews extends AppCompatActivity {

    private TextView mtitle, mdescription, mcontent;
    private ImageView imgRes ;
    private String img;
    private TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_news);

        mtitle = findViewById(R.id.news_title);
        mdescription = findViewById(R.id.news_description);
        mcontent = findViewById(R.id.news_content);
        imgRes = findViewById(R.id.newsImage);
        name=findViewById(R.id.news_name);

        Intent intent = getIntent();
        mtitle.setText(intent.getStringExtra("title"));
        mdescription.setText(intent.getStringExtra("description"));
        mcontent.setText(intent.getStringExtra("content"));
        name.setText(intent.getStringExtra("name"));

        img= intent.getStringExtra("image");

        Glide.with(this)
                .load(img)
                .into(imgRes);

    }
}
