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

import com.example.fatmancosmetic.Controller.BillsDetail;
import com.example.fatmancosmetic.Controller.ItemDetails;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Info.OrderInfo;
import com.example.fatmancosmetic.Model.CustomerModel;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.Model.OrderDetailsModel;
import com.example.fatmancosmetic.Model.OrderModel;
import com.example.fatmancosmetic.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class BillDetailAdapter extends RecyclerView.Adapter<BillDetailAdapter.BillDetailViewHolder> {

    ArrayList<OrderInfo> listOrder;
    ArrayList<ItemInfo> skinCareItemsLocations;
    Context context;
    ItemModel itemModel;
    OrderModel orderModel;
    OrderDetailsModel orderDetailsModel;
    CustomerModel customerModel;
    FragmentManager fragmentManager;
    String customerID = "000001";

    public BillDetailAdapter(ArrayList<ItemInfo> skinCareItemsLocations, Context context, FragmentManager fragmentManager) {
        this.skinCareItemsLocations = skinCareItemsLocations;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    public BillDetailAdapter(ArrayList<OrderInfo> listorder, FragmentManager fragmentManager, Context context) {
        this.listOrder = listorder;
        this.fragmentManager = fragmentManager;
        this.context = context;
    }


    @NonNull
    @Override
    public BillDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_item_detail_card_design, parent, false);
        BillDetailViewHolder billDetailViewHolder = new BillDetailViewHolder(view);

        return billDetailViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BillDetailViewHolder holder, int position) {
        ItemInfo itemInfo = skinCareItemsLocations.get(position);
        Bitmap bmp = BitmapFactory.decodeByteArray(itemInfo.getImage(), 0, itemInfo.getImage().length);
        holder.imageView.setImageBitmap(bmp);
        holder.bill_title.setText(itemInfo.getName());
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
                ItemDetails itemDetails = new ItemDetails("bill");
                Bundle bundle = new Bundle();
                bundle.putString("itemID", itemID);
                //set Fragmentclass Arguments
                itemDetails.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.fragment, itemDetails, itemDetails.getTag()).commit();

            }
        });
    }

    // loi not reference
    @Override
    public int getItemCount() {
        return skinCareItemsLocations.size();
    }

    public class BillDetailViewHolder extends RecyclerView.ViewHolder{

        TextView bill_title, bill_date, price;
        ImageView imageView;
        public BillDetailViewHolder(@NonNull View itemView) {
            super(itemView);

            bill_title = itemView.findViewById(R.id.cart_items_title);
            price = itemView.findViewById(R.id.cart_items_price);
            imageView = itemView.findViewById(R.id.cart_items_image);
        }
    }
}
