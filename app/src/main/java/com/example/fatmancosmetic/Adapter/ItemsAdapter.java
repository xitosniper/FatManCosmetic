package com.example.fatmancosmetic.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fatmancosmetic.Controller.ItemDetails;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Info.OrderInfo;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.SkinCareItemsViewHolder> implements Filterable {

    ArrayList<ItemInfo> skinCareItemsLocations;
    ArrayList<ItemInfo> itemList;
    ItemFilter itemFilter;
    Context context;
    ItemModel itemModel;
    FragmentManager fragmentManager;
    String page;


    public ItemsAdapter(ArrayList<ItemInfo> skinCareItemsLocations, Context context, FragmentManager fragmentManager, String page) {
        this.skinCareItemsLocations = skinCareItemsLocations;
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.page = page;
    }

    @NonNull
    @Override
    public ItemsAdapter.SkinCareItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_card_design,parent,false);
        SkinCareItemsViewHolder skinCareItemsViewHolder = new SkinCareItemsViewHolder(view);

        return skinCareItemsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.SkinCareItemsViewHolder holder, int position) {
        ItemInfo itemInfo = skinCareItemsLocations.get(position);
        Bitmap bmp = BitmapFactory.decodeByteArray(itemInfo.getImage(), 0, itemInfo.getImage().length);
        holder.imageView.setImageBitmap(bmp);
        holder.title.setText(itemInfo.getName());
        //Format price vnd
        NumberFormat formatter = new DecimalFormat("#,###");
        double myNumber = itemInfo.getPrice();
        String formattedNumber = formatter.format(myNumber);
        holder.price.setText(formattedNumber+"₫");
        String itemID = itemInfo.getItemID();

        // event click to see detail
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemDetails itemDetails = new ItemDetails(page);
                Bundle bundle = new Bundle();
                bundle.putString("itemID", itemID);
                //set Fragmentclass Arguments
                itemDetails.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.fragment, itemDetails, itemDetails.getTag()).commit();

            }
        });


    }

    @Override
    public int getItemCount() {
        return skinCareItemsLocations.size();
    }

    @Override
    public Filter getFilter() {

        itemFilter = new ItemFilter();
        return itemFilter;
    }

    class ItemFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            if (charSequence.length() > 0) {
                charSequence = charSequence.toString().toLowerCase();
                ArrayList<ItemInfo> itemInfo = new ArrayList<>();

//                itemList = new ArrayList<>();

                for (int i = 0; i < skinCareItemsLocations.size(); i++) {
                    if (skinCareItemsLocations.get(i).getName().toLowerCase().contains(charSequence)) {
                        ItemInfo f = new ItemInfo(skinCareItemsLocations.get(i).getItemID(), skinCareItemsLocations.get(i).getBrandID(),
                                skinCareItemsLocations.get(i).getCategoryID(), skinCareItemsLocations.get(i).getName(),
                                skinCareItemsLocations.get(i).getImage(), skinCareItemsLocations.get(i).getPrice(),
                                skinCareItemsLocations.get(i).getDescription(), skinCareItemsLocations.get(i).getStatus());
                        itemInfo.add(f);
                    }
                }
                results.count = itemInfo.size();
                results.values = itemInfo;
            } else {
                results.count = skinCareItemsLocations.size();
                results.values = skinCareItemsLocations;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            skinCareItemsLocations = (ArrayList<ItemInfo>) results.values;
            notifyDataSetChanged();
        }
    }

    public class SkinCareItemsViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title, price;
        public SkinCareItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.items_image);
            title = itemView.findViewById(R.id.items_title);
            price = itemView.findViewById(R.id.items_price);

        }
    }
}
