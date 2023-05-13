package com.yiriba.recyclerapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yiriba.recyclerapp.R;
import com.yiriba.recyclerapp.model.Vaccine;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    // 4- Handling the click events
    public ItemClickListener clickListener;

    // 1- Data Source
    private Vaccine[] listData;

    public Adapter(Vaccine[] listData) {
        this.listData = listData;
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    // 2- View Holder
    // Describes and item view and metadata about it's place within the recyclerView
    // Adapter implementations should subclass viewHolder and add fields for caching potential, expensive findViewById results
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_vaccineTitle;
        ImageView iv_VaccineImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_vaccineTitle = itemView.findViewById(R.id.textView);
            iv_VaccineImage = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onClick(v, getAdapterPosition());
            }
        }
    }

    // 3- Implement methods
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // Called when you need a new view - initialize viewHolder here
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.recyclerview_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { // provides and bind with the new data
            final Vaccine myListData = listData[position];
            holder.tv_vaccineTitle.setText(myListData.getTitle());
            holder.iv_VaccineImage.setImageResource(myListData.getImage());
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }
}
