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
import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Info.OrderDetailInfo;
import com.example.fatmancosmetic.Info.OrderInfo;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.Model.OrderDetailsModel;
import com.example.fatmancosmetic.Model.OrderModel;
import com.example.fatmancosmetic.R;

import java.util.ArrayList;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartHolder> {

    ArrayList<ItemInfo> itemsCartLocations;
    ArrayList<OrderDetailInfo> orderDetailInfoArrayList;
    Context context;
    ItemModel itemModel;
    OrderDetailsModel orderDetailsModel;
    FragmentManager fragmentManager;
    String customerID = "000001";

    public ShoppingCartAdapter(ArrayList<ItemInfo> itemsCartLocations, Context context, FragmentManager fragmentManager) {
        this.itemsCartLocations = itemsCartLocations;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public ShoppingCartAdapter.ShoppingCartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_card_design,parent,false);
        ShoppingCartHolder shoppingCartHolder = new ShoppingCartHolder(view);
        return shoppingCartHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingCartAdapter.ShoppingCartHolder holder, int position) {

        ItemInfo itemInfo = itemsCartLocations.get(position);
        ArrayList<OrderDetailInfo> orderDetailInfoArrayList = new ArrayList<>();
        orderDetailsModel = new OrderDetailsModel(context);
        orderDetailInfoArrayList = orderDetailsModel.getOrderDetailsByCustomerIDAndItemID(customerID, itemInfo.getItemID());
        //OrderDetailInfo orderDetailInfo = orderDetailInfoArrayList.get(position);
        Bitmap bmp = BitmapFactory.decodeByteArray(itemInfo.getImage(), 0, itemInfo.getImage().length);
        holder.imageView.setImageBitmap(bmp);
        holder.title.setText(itemInfo.getName());
        holder.price.setText(itemInfo.getPrice()+"");
        holder.quanlity.setText(orderDetailInfoArrayList.get(0).getQuantity()+"");
    }

    @Override
    public int getItemCount() {
        return itemsCartLocations.size();
    }

    public class ShoppingCartHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, price, quanlity, numOfItems;
        public ShoppingCartHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cart_items_image);
            title = itemView.findViewById(R.id.cart_items_title);
            price = itemView.findViewById(R.id.cart_items_price);
            quanlity = itemView.findViewById(R.id.cart_items_quantity);

        }
    }
}
