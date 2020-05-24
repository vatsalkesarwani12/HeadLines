package e.vatsal.kesarwani.headlines.Adapter;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import e.vatsal.kesarwani.headlines.Activity.DeepNews;
import e.vatsal.kesarwani.headlines.Activity.RoomData;
import e.vatsal.kesarwani.headlines.R;
import e.vatsal.kesarwani.headlines.Repository.Repository;
import e.vatsal.kesarwani.headlines.Room.NewsEntity;

public class RoomRecyclerAdapter extends RecyclerView.Adapter<RoomRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<NewsEntity> news;
    private Application application;

    public RoomRecyclerAdapter(Context context, List<NewsEntity> news, Application application) {
        this.context = context;
        this.news = news;
        this.application = application;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.frame001,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.title.setText(news.get(position).getTitle());
        holder.name.setText(news.get(position).getName());
        Glide.with(context)
                .load(news.get(position).getUrlToImage())
                .into(holder.image);

        /*holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Repository repository=new Repository(application);
                repository.delete(news.get(position));
                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DeepNews.class);

                intent.putExtra(Repository.TITLE,news.get(position).getTitle());
                intent.putExtra(Repository.DESCRIPTION,news.get(position).getDescription());
                intent.putExtra(Repository.CONTENT,news.get(position).getContent());
                intent.putExtra(Repository.NAME,news.get(position).getName());
                intent.putExtra(Repository.URLTOIMAGE,news.get(position).getUrlToImage());
                intent.putExtra(Repository.URL,news.get(position).getUrl());
                intent.putExtra(Repository.PUBLISHED,news.get(position).getPublishedAt());

                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,name;
        ImageView image;
        //ImageView delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title001);
            name=itemView.findViewById(R.id.name001);
            image=itemView.findViewById(R.id.image001);
            /*delete=itemView.findViewById(R.id.deleteSavedNews);
            delete.setVisibility(View.VISIBLE);*/
        }
    }
}
