package e.vatsal.kesarwani.headlines.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import e.vatsal.kesarwani.headlines.DeepNews;
import e.vatsal.kesarwani.headlines.MainActivity;
import e.vatsal.kesarwani.headlines.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ExampleViewHolder> {

    private ArrayList<RecycleData> mRecycleData;
    private Context context;
    private OnItemClickListner mListner;

    public void setOnItemClickListner(OnItemClickListner listner){
        mListner = listner;
    }

    public interface OnItemClickListner{
        void onItemClick(int position);
    }


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
        holder.content.setText(currentdata.getNewsContent());
        holder.imgg.setText(currentdata.getImgId());
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
        private TextView content;
        private TextView imgg;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            titletxt=itemView.findViewById(R.id.title);
            nametxt=itemView.findViewById(R.id.name);
            destxt=itemView.findViewById(R.id.description);
            img=itemView.findViewById(R.id.image);
            content=itemView.findViewById(R.id.content);
            imgg=itemView.findViewById(R.id.imm);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Toast.makeText(context,"Loading",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context, DeepNews.class);
                    intent.putExtra("title",titletxt.getText());
                    intent.putExtra("description",destxt.getText());
                    intent.putExtra("content",content.getText());
                    intent.putExtra("name",nametxt.getText());
                    intent.putExtra("image",imgg.getText());

                    view.getContext().startActivity(intent);

                    if (mListner != null) {

                        if (position != RecyclerView.NO_POSITION) {
                            mListner.onItemClick(position);
                        }
                    }
                }

            });

        }
    }
}
