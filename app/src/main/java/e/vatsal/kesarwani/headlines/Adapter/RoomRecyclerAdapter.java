package e.vatsal.kesarwani.headlines.Adapter;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import e.vatsal.kesarwani.headlines.Activity.DeepNews;
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
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.room001,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.textView.setText(news.get(position).getTitle());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Repository repository=new Repository(application);
                repository.delete(news.get(position));
                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });
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
        TextView textView;
        ImageView delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.roomtitile);
            delete=itemView.findViewById(R.id.deleteRoomList);
        }
    }
}
