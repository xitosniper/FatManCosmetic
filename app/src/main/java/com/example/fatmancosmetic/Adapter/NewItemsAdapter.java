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

public class NewItemsAdapter extends RecyclerView.Adapter<NewItemsAdapter.NewItemsViewHolder> {

    ArrayList<ItemInfo> newitemsLocations;
    Context context;
    ItemModel itemModel;


    public NewItemsAdapter(ArrayList<ItemInfo> newitemsLocations, Context context) {
        this.newitemsLocations = newitemsLocations;
        this.context = context;
    }

    @NonNull
    @Override
    public NewItemsAdapter.NewItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newitems_card_design,parent,false);
        NewItemsAdapter.NewItemsViewHolder newItemsViewHolder = new NewItemsViewHolder(view);

        return newItemsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewItemsAdapter.NewItemsViewHolder holder, int position) {
        ItemInfo itemInfo = newitemsLocations.get(position);
        Bitmap bmp = BitmapFactory.decodeByteArray(itemInfo.getImage(), 0, itemInfo.getImage().length);
        holder.imageView.setImageBitmap(bmp);
        holder.title.setText(itemInfo.getName());
        holder.price.setText(itemInfo.getPrice()+"₫");
    }

    @Override
    public int getItemCount() {
        return newitemsLocations.size();
    }


    public static class NewItemsViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title, price;
        public NewItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.new_items_image);
            title =itemView.findViewById(R.id.new_items_title);
            price =itemView.findViewById(R.id.new_items_price);
        }
    }
}
