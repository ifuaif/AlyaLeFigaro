package com.example.miller.alyalefigaro;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Miller on 21-03-17.
 */

public class ALaUneAdapter extends RecyclerView.Adapter<ALaUneAdapter.ALaUneViewHolder> {

private List<Subcategory> subcategories;
private int rowLayout;
private Context context;


public static class ALaUneViewHolder extends RecyclerView.ViewHolder {
    LinearLayout subcategoryLayout;
  //  TextView subcategoryTitle;
    TextView subcategoryRating;
    TextView subcategoryName;
    TextView subcategoryID;


    public ALaUneViewHolder(View v) {
        super(v);
      //  subcategoryLayout = (LinearLayout) v.findViewById(R.id.subcategory_layout);
       // subcategoryTitle = (TextView) v.findViewById(R.id.subcategory_title);
        //subcategoryData = (TextView) v.findViewById(R.id.subcategory_subtitle);
        //subcategoryDescription = (TextView) v.findViewById(R.id.subcategory_description);
        subcategoryRating = (TextView) v.findViewById(R.id.tv_rank);
        subcategoryName = (TextView) v.findViewById(R.id.tv_name);
        subcategoryID = (TextView) v.findViewById(R.id.tv_id);
    }
}

    public ALaUneAdapter(List<Subcategory> subcategories, int rowLayout, Context context) {
        this.subcategories = subcategories;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ALaUneAdapter.ALaUneViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ALaUneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ALaUneAdapter.ALaUneViewHolder holder, int position) {

      holder.subcategoryName.setText(subcategories.get(position).getName());
      holder.subcategoryID.setText(subcategories.get(position).getId());
      //holder.subcategoryDescription.setText(subcategories.get(position).getId());
      holder.subcategoryRating.setText(subcategories.get(position).getRanking());

    }

    @Override
    public int getItemCount() {
        return subcategories.size();
    }
}