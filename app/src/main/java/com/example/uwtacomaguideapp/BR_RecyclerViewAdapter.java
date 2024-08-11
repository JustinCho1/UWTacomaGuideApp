package com.example.uwtacomaguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
// used to display building buttons
public class BR_RecyclerViewAdapter extends RecyclerView.Adapter<BR_RecyclerViewAdapter.MyViewHolder> {
    private final BuildingRecyclerInterface buildingRecyclerInterface;

    Context context;
    ArrayList<BuildingNames>buildingNameModels;

    public BR_RecyclerViewAdapter(Context context, ArrayList<BuildingNames> buildingNameModels,
                                  BuildingRecyclerInterface buildingRecyclerInterface) {
        this.context = context;
        this.buildingNameModels = buildingNameModels;
        this.buildingRecyclerInterface = buildingRecyclerInterface;
    }

    @NonNull
    @Override
    public BR_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new BR_RecyclerViewAdapter.MyViewHolder(view, buildingRecyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull BR_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.textViewName.setText(buildingNameModels.get(position).buildingName);
    }

    @Override
    public int getItemCount() {
        return buildingNameModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;

        public MyViewHolder(@NonNull View itemView, BuildingRecyclerInterface buildingRecyclerInterface) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (buildingRecyclerInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            buildingRecyclerInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
