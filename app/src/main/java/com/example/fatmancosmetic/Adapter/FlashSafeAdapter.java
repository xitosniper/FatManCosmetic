package com.example.fatmancosmetic.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fatmancosmetic.Info.FlashSaleInfo;
import com.example.fatmancosmetic.R;

import java.util.ArrayList;

public class FlashSafeAdapter extends RecyclerView.Adapter<FlashSafeAdapter.FlashSafeViewHolder> {
    ArrayList<FlashSaleInfo> flashSafeLocations;

    public FlashSafeAdapter(ArrayList<FlashSaleInfo> flashSafeLocations) {
        this.flashSafeLocations = flashSafeLocations;
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

        FlashSaleInfo flashSaleInfo = flashSafeLocations.get(position);

        Bitmap bitmap = BitmapFactory.decodeByteArray(flashSaleInfo.getImage(),0, flashSaleInfo.getImage().length);
        holder.imageView.setImageBitmap(bitmap);
        holder.title.setText(flashSaleInfo.getTitle());
        holder.price.setText(flashSaleInfo.getPrice());
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
