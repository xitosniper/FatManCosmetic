package com.example.fatmancosmetic.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fatmancosmetic.Info.FlashSaleInfo;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.R;

import java.util.ArrayList;

public class FlashSafeAdapter extends RecyclerView.Adapter<FlashSafeAdapter.FlashSafeViewHolder> {
    ArrayList<ItemInfo> flashSafeLocations;
    Context context;
    ItemModel itemModel;


    public FlashSafeAdapter(ArrayList<ItemInfo> flashSafeLocations, Context context) {
        this.flashSafeLocations = flashSafeLocations;
        this.context = context;
    }

    @NonNull
    @Override
    public FlashSafeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flashsale_card_design,parent,false);
        FlashSafeViewHolder flashSafeViewHolder = new FlashSafeViewHolder(view);

        return flashSafeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FlashSafeViewHolder holder, int position) {

        ItemInfo itemInfo = flashSafeLocations.get(position);
        Bitmap bmp = BitmapFactory.decodeByteArray(itemInfo.getImage(), 0, itemInfo.getImage().length);
        holder.imageView.setImageBitmap(bmp);
        holder.title.setText(itemInfo.getName());
        holder.price.setText(itemInfo.getPrice()+"₫");
    }

    @Override
    public int getItemCount() {
        return flashSafeLocations.size();
    }

    public static class FlashSafeViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title, price;
        public FlashSafeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.flashsafe_image);
            title =itemView.findViewById(R.id.flashsafe_title);
            price =itemView.findViewById(R.id.flashsafe_price);

        }
    }
}
