package com.example.fatmancosmetic.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.R;

import java.util.ArrayList;

public class BestSellerAdapter extends RecyclerView.Adapter<BestSellerAdapter.BestSaleViewHolder> {

    ArrayList<ItemInfo> bestSaleLocations;
    Context context;
    ItemModel itemModel;


    public BestSellerAdapter(ArrayList<ItemInfo> bestSaleLocations, Context context) {
        this.bestSaleLocations = bestSaleLocations;
        this.context = context;
    }

    @NonNull
    @Override
    public BestSellerAdapter.BestSaleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bestsale_card_design,parent,false);
        BestSaleViewHolder bestSaleViewHolder = new BestSaleViewHolder(view);

        return bestSaleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BestSellerAdapter.BestSaleViewHolder holder, int position) {
        ItemInfo itemInfo = bestSaleLocations.get(position);
        Bitmap bmp = BitmapFactory.decodeByteArray(itemInfo.getImage(), 0, itemInfo.getImage().length);
        holder.imageView.setImageBitmap(bmp);
        holder.title.setText(itemInfo.getName());
        holder.price.setText(itemInfo.getPrice()+"₫");
    }

    @Override
    public int getItemCount() {
        return bestSaleLocations.size();
    }

    public static class BestSaleViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title, price;
        public BestSaleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.bestsale_image);
            title =itemView.findViewById(R.id.bestsale_title);
            price =itemView.findViewById(R.id.bestsale_price);

        }
    }
}
