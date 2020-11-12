package com.example.fatmancosmetic.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.R;

import java.util.ArrayList;

public class SkinCareItemsAdapter extends RecyclerView.Adapter<SkinCareItemsAdapter.AllListItemsViewHolder> {

    ArrayList<ItemInfo> allListItemsLocations;
    Context context;
    ItemModel itemModel;


    public SkinCareItemsAdapter(ArrayList<ItemInfo> allListItemsLocations, Context context) {
        this.allListItemsLocations = allListItemsLocations;
        this.context = context;
    }

    @NonNull
    @Override
    public SkinCareItemsAdapter.AllListItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_card_design,parent,false);
        AllListItemsViewHolder allListItemsViewHolder = new AllListItemsViewHolder(view);

        return allListItemsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SkinCareItemsAdapter.AllListItemsViewHolder holder, int position) {
        ItemInfo itemInfo = allListItemsLocations.get(position);
        Bitmap bmp = BitmapFactory.decodeByteArray(itemInfo.getImage(), 0, itemInfo.getImage().length);
        holder.imageView.setImageBitmap(bmp);
        holder.title.setText(itemInfo.getName());
        holder.price.setText(itemInfo.getPrice()+"₫");


    }

    @Override
    public int getItemCount() {
        return allListItemsLocations.size();
    }

    public class AllListItemsViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title, price;
        public AllListItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.items_image);
            title = itemView.findViewById(R.id.items_title);
            price = itemView.findViewById(R.id.items_price);

        }
    }
}
