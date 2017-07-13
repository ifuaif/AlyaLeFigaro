package com.example.miller.alyalefigaro;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by miller on 11.07.17.
 */

public class ALaUneRecyclerAdapter extends RecyclerView.Adapter<ALaUneRecyclerAdapter.MyHolder> {

    ArrayList<Subcategory> listSubcategory;
    ImageLoader imageLoader;

    public ALaUneRecyclerAdapter(ArrayList<Subcategory> list) {
        this.listSubcategory = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_a_la_une, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Subcategory subcategory = listSubcategory.get(position);

        holder.name.setText(subcategory.getName());
        holder.id.setText(subcategory.getId());
        holder.rank.setText(subcategory.getRanking());
    }

    @Override
    public int getItemCount() {
        return listSubcategory == null ? 0 : listSubcategory.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView name, rank, id;

        public MyHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            id = (TextView) itemView.findViewById(R.id.tv_id);
            rank = (TextView) itemView.findViewById(R.id.tv_rank);
        }
    }
}