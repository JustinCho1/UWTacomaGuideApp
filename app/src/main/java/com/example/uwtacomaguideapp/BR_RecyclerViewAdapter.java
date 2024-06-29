package com.example.uwtacomaguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BR_RecyclerViewAdapter extends RecyclerView.Adapter<BR_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<BuildingNames>buildingNameModels;

    public BR_RecyclerViewAdapter(Context context, ArrayList<BuildingNames> buildingNameModels) {
        this.context = context;
        this.buildingNameModels = buildingNameModels;
    }

    @NonNull
    @Override
    public BR_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new BR_RecyclerViewAdapter.MyViewHolder(view);
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
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textView3);
        }
    }
}
