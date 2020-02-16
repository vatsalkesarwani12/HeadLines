package e.vatsal.kesarwani.headlines.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import e.vatsal.kesarwani.headlines.MainActivity;
import e.vatsal.kesarwani.headlines.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ExampleViewHolder> {

    private ArrayList<RecycleData> mRecycleData;
    private Context context;

    public RecyclerAdapter(ArrayList<RecycleData> mRecycleData, Context context) {
        this.mRecycleData = mRecycleData;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.frame,parent,false);
        ExampleViewHolder evh=new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ExampleViewHolder holder, int position) {
        RecycleData currentdata=mRecycleData.get(position);

        holder.titletxt.setText(currentdata.getNewstitle());
        holder.destxt.setText(currentdata.getNewsdescription());
        holder.nametxt.setText(currentdata.getNewsname());
        Glide.with(context)
                .load(currentdata.getNewsimage())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mRecycleData.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView titletxt;
        private TextView destxt;
        private TextView nametxt;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            titletxt=itemView.findViewById(R.id.title);
            nametxt=itemView.findViewById(R.id.name);
            destxt=itemView.findViewById(R.id.description);
            img=itemView.findViewById(R.id.image);

        }
    }
}
