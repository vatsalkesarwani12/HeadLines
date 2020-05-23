package e.vatsal.kesarwani.headlines.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import e.vatsal.kesarwani.headlines.Model.HomeList;
import e.vatsal.kesarwani.headlines.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ExampleViewHolder> {

    private Context context;
    private ArrayList<HomeList> list;

    public HomeAdapter(Context context, ArrayList<HomeList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HomeAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.listhomepage,parent,false);
        ExampleViewHolder evh=new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ExampleViewHolder holder, int position) {
        holder.catname.setText(list.get(position).getCatName());
        holder.water.setImageResource(list.get(position).getResWatermark());
        holder.conView.setBackground(list.get(position).getColor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout conView;
        private TextView catname;
        private ImageView water;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            conView=itemView.findViewById(R.id.conView);
            catname=itemView.findViewById(R.id.catname);
            water=itemView.findViewById(R.id.water);
        }
    }
}
