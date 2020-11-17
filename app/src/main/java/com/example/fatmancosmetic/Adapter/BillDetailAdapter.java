package com.example.fatmancosmetic.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
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
import com.example.fatmancosmetic.Info.OrderDetailInfo;
import com.example.fatmancosmetic.Info.OrderInfo;
import com.example.fatmancosmetic.Model.CustomerModel;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.Model.OrderDetailsModel;
import com.example.fatmancosmetic.Model.OrderModel;
import com.example.fatmancosmetic.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BillDetailAdapter extends RecyclerView.Adapter<BillDetailAdapter.BillDetailViewHolder> {

    ArrayList<OrderInfo> listOrder;
    ArrayList<ItemInfo> skinCareItemsLocations;
    ArrayList<OrderDetailInfo> orderDetailList;
    Context context;
    ItemModel itemModel;
    OrderModel orderModel;
    OrderDetailsModel orderDetailsModel;
    CustomerModel customerModel;
    FragmentManager fragmentManager;
    String customerID = "000001";
    String orderID = "";

    public BillDetailAdapter(ArrayList<ItemInfo> skinCareItemsLocations, Context context, FragmentManager fragmentManager, String orderID) {
        this.skinCareItemsLocations = skinCareItemsLocations;
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.orderID = orderID;
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
        try {
            orderDetailsModel = new OrderDetailsModel(context);

            ItemInfo itemInfo = skinCareItemsLocations.get(position);
            Bitmap bmp = BitmapFactory.decodeByteArray(itemInfo.getImage(), 0, itemInfo.getImage().length);
            holder.imageView.setImageBitmap(bmp);
            holder.bill_title.setText(itemInfo.getName());
            //Format price vnd
            NumberFormat formatter = new DecimalFormat("#,###");
            double myNumber = itemInfo.getPrice();
            String formattedNumber = formatter.format(myNumber);
            holder.price.setText(formattedNumber + "₫");
            String itemID = itemInfo.getItemID();
            orderDetailList = orderDetailsModel.getOrderDetailsBillByOrderID(orderID);

            String amount = "0";
            for (int i = 0; i < orderDetailList.size(); i++) {
                if (orderDetailList.get(i).getItemID().equals(itemID)) {
                    amount = orderDetailList.get(i).getQuantity() + "";
                    //Log.e("SoLuong", amount);
                }
            }

            holder.amount.setText(amount);
            //holder.bill_total.setText("0");
            //int sizeList = orderDetailList.size();
            //holder.size.setText(sizeList+"");
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
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
    }


    // loi not reference
    @Override
    public int getItemCount() {
        return skinCareItemsLocations.size();
    }

    public class BillDetailViewHolder extends RecyclerView.ViewHolder {

        TextView bill_title, bill_total, price, amount, size;
        ImageView imageView;

        public BillDetailViewHolder(@NonNull View itemView) {
            super(itemView);

            amount = itemView.findViewById(R.id.amount);
            bill_title = itemView.findViewById(R.id.cart_items_title);
            price = itemView.findViewById(R.id.cart_items_price);
//            size = itemView.findViewById(R.id.shoppingCart_numberOfItems);
//            bill_total = itemView.findViewById(R.id.bill_Amount);
            imageView = itemView.findViewById(R.id.cart_items_image);
        }
    }
}