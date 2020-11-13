package com.example.fatmancosmetic.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fatmancosmetic.Controller.ItemDetails;
import com.example.fatmancosmetic.Info.BrandInfo;
import com.example.fatmancosmetic.Info.CategoryInfo;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.R;

import java.util.ArrayList;

public class ItemsDetailsAdapter extends RecyclerView.Adapter<ItemsDetailsAdapter.ItemsDetailsHolder> {
    ArrayList<ItemInfo> itemsDetailsLocations;
    Context context;
    ItemModel itemModel;
    FragmentManager fragmentManager;

    public ItemsDetailsAdapter(ArrayList<ItemInfo> itemsDetailsLocations, Context context, FragmentManager fragmentManager) {
        this.itemsDetailsLocations = itemsDetailsLocations;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public ItemsDetailsAdapter.ItemsDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_details_card_design,parent,false);
        ItemsDetailsHolder itemsDetailsHolder = new ItemsDetailsHolder(view);

        return itemsDetailsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsDetailsAdapter.ItemsDetailsHolder holder, int position) {
        ItemInfo itemInfo = itemsDetailsLocations.get(position);
        Bitmap bmp = BitmapFactory.decodeByteArray(itemInfo.getImage(), 0, itemInfo.getImage().length);
        holder.imageView.setImageBitmap(bmp);
        holder.title.setText(itemInfo.getName());
        holder.id.setText(itemInfo.getItemID());
        holder.price.setText(itemInfo.getPrice()+"₫");
        holder.description.setText(itemInfo.getDescription());
        int id = itemInfo.getID();
    }

    @Override
    public int getItemCount() {
        return itemsDetailsLocations.size();
    }

    public class ItemsDetailsHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView id, title, price, description;
        public ItemsDetailsHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.items_image);
            title = itemView.findViewById(R.id.items_title);
            id = itemView.findViewById(R.id.items_id);
            price = itemView.findViewById(R.id.items_price);
            description = itemView.findViewById(R.id.items_description);
        }
    }
}
