package edu.ranken.jpscott.bluesrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BluesRecyclerViewAdapter extends RecyclerView.Adapter<BluesRecyclerViewAdapter.MyViewHolder>{
    Context context;
    ArrayList<BluesModel> bluesModel;
    private final RecyclerViewInterface recyclerViewInterface;

    public BluesRecyclerViewAdapter(Context context,
                                    ArrayList<BluesModel> bluesModel,
                                    RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.bluesModel = bluesModel;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    //  This is where we inflate the layout, i.e. give the look to each row.
    @NonNull
    @Override
    public BluesRecyclerViewAdapter.MyViewHolder onCreateViewHolder(
                            @NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_layout, parent, false);
        return new BluesRecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    //  Assign values to the views created in the row_layout file,
    //  based on their position in the recyclerView.
    @Override
    public void onBindViewHolder(
                            @NonNull BluesRecyclerViewAdapter.MyViewHolder holder,
                            int position) {
        holder.tvPlayerName.setText(bluesModel.get(position).getBluesName());
        holder.tvPlayerNumber.setText(bluesModel.get(position).getBluesNumber());
        holder.tvPlayerPosition.setText(bluesModel.get(position).getBluesPosition());
        holder.ivPlayerImage.setImageResource(bluesModel.get(position).getBluesImage());
    }

    //  Count of the number of total items the RecyclerView is to display
    @Override
    public int getItemCount() {
        return bluesModel.size();
    }

    //  This method "grabs" the views from the row_layout file.
    //  In a way, it is sort of like the onCreate() method.
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvPlayerName;
        TextView tvPlayerNumber;
        TextView tvPlayerPosition;
        ImageView ivPlayerImage;

        public MyViewHolder(View itemView,
                            RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            tvPlayerName        = itemView.findViewById(R.id.tvPlayerName);
            tvPlayerNumber      = itemView.findViewById(R.id.tvPlayerNumber);
            tvPlayerPosition    = itemView.findViewById(R.id.tvPlayerPosition);
            ivPlayerImage       = itemView.findViewById(R.id.ivPlayerImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }

        public void onClick(View view) {
            if (recyclerViewInterface != null) {
                int pos = getAdapterPosition();

                if (pos != RecyclerView.NO_POSITION) {
                    recyclerViewInterface.onItemClick(pos);
                }
            }
        }
    }
}
