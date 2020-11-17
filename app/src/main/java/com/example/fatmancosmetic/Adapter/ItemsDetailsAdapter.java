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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fatmancosmetic.Controller.ItemDetails;
import com.example.fatmancosmetic.Controller.ShoppingCart;
import com.example.fatmancosmetic.Info.BrandInfo;
import com.example.fatmancosmetic.Info.CategoryInfo;
import com.example.fatmancosmetic.Info.CustomerInfo;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ItemsDetailsAdapter extends RecyclerView.Adapter<ItemsDetailsAdapter.ItemsDetailsHolder> {
    ArrayList<ItemInfo> itemsDetailsLocations;
    Context context;
    ItemModel itemModel;
    OrderModel orderModel;
    OrderDetailsModel orderDetailsModel;
    CustomerModel customerModel;
    FragmentManager fragmentManager;
    String customerID = "000001";

    public ItemsDetailsAdapter(ArrayList<ItemInfo> itemsDetailsLocations, Context context, FragmentManager fragmentManager) {
        this.itemsDetailsLocations = itemsDetailsLocations;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public ItemsDetailsAdapter.ItemsDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_details_card_design, parent, false);
        ItemsDetailsHolder itemsDetailsHolder = new ItemsDetailsHolder(view);

        return itemsDetailsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsDetailsAdapter.ItemsDetailsHolder holder, int position) {
        try {
            ItemInfo itemInfo = itemsDetailsLocations.get(position);
            Bitmap bmp = BitmapFactory.decodeByteArray(itemInfo.getImage(), 0, itemInfo.getImage().length);
            holder.imageView.setImageBitmap(bmp);
            holder.title.setText(itemInfo.getName());
            holder.id.setText(itemInfo.getItemID());


            //Format price vnd
            NumberFormat formatter = new DecimalFormat("#,###");
            double myNumber = itemInfo.getPrice();
            String formattedNumber = formatter.format(myNumber);
            holder.price.setText(formattedNumber + "₫");
            holder.description.setText(itemInfo.getDescription());


            holder.button_AddToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    orderModel = new OrderModel(context);
                    orderDetailsModel = new OrderDetailsModel(context);
                    customerModel = new CustomerModel(context);

                    ArrayList<OrderInfo> orderInfos = orderModel.getOrderByCustomerID(customerID);
                    ArrayList<OrderDetailInfo> orderDetailInfos = orderDetailsModel.getOrderDetailsByCustomerID(customerID);

                    ArrayList<OrderDetailInfo> listAllOrderDetails = orderDetailsModel.getAllOrderDetails();
                    ArrayList<OrderInfo> listAllOrders = orderModel.getAllOrders();

                    String orderDetailsID;

                    int checkOrderDetailsID = 0;
                    if (listAllOrderDetails.size() > 0) {
                        checkOrderDetailsID = listAllOrderDetails.get(listAllOrderDetails.size() - 1).getID();
                    } else {
                        checkOrderDetailsID = 0;
                    }


                    if (checkOrderDetailsID < 9) {
                        orderDetailsID = "00000" + (checkOrderDetailsID + 1);
                    } else if (checkOrderDetailsID < 99) {
                        orderDetailsID = "0000" + (checkOrderDetailsID + 1);
                    } else if (checkOrderDetailsID < 999) {
                        orderDetailsID = "000" + (checkOrderDetailsID + 1);
                    } else if (checkOrderDetailsID < 9999) {
                        orderDetailsID = "00" + (checkOrderDetailsID + 1);
                    } else if (checkOrderDetailsID < 99999) {
                        orderDetailsID = "0" + (checkOrderDetailsID + 1);
                    } else {
                        orderDetailsID = "" + (checkOrderDetailsID + 1);
                    }


                    if (orderInfos.size() != 0) {
                        String orderID = orderInfos.get(0).getOrderID();
                        ArrayList<OrderDetailInfo> orderDetailInfos1 = orderDetailsModel.getOrderDetailsByCustomerIDAndItemID(customerID, itemInfo.getItemID());
                        if (orderDetailInfos1.size() != 0) {
                            orderDetailsModel.updateOrderDetails(new OrderDetailInfo(orderDetailInfos1.get(0).getID(), orderDetailsID, orderInfos.get(0).getOrderID(), itemInfo.getItemID(), (orderDetailInfos1.get(0).getQuantity() + 1), itemInfo.getPrice()));
                            //Log.e("Update quantity: ", (orderDetailInfos1.get(0).getQuantity()+1)+"");
                            Toast.makeText(context, "Thêm giỏ hàng thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            orderDetailsModel.addOrderDetails(new OrderDetailInfo(orderDetailsID, orderInfos.get(0).getOrderID(), itemInfo.getItemID(), 1, itemInfo.getPrice()));
                            Toast.makeText(context, "Thêm giỏ hàng thành công", Toast.LENGTH_SHORT).show();
                        }

                    } else {

                        String orderID;
                        int checkOrderID = 0;

                        if (listAllOrders.size() > 0) {
                            checkOrderID = listAllOrders.get(listAllOrders.size() - 1).getID();
                        } else {
                            checkOrderID = 0;
                        }

                        if (checkOrderID < 9) {
                            orderID = "00000" + (checkOrderID + 1);
                        } else if (checkOrderID < 99) {
                            orderID = "0000" + (checkOrderID + 1);
                        } else if (checkOrderID < 999) {
                            orderID = "000" + (checkOrderID + 1);
                        } else if (checkOrderID < 9999) {
                            orderID = "00" + (checkOrderID + 1);
                        } else if (checkOrderID < 99999) {
                            orderID = "0" + (checkOrderID + 1);
                        } else {
                            orderID = "" + (checkOrderID + 1);
                        }


                        Date currentTime = Calendar.getInstance().getTime();
                        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                        String currentDate = fmt.format(currentTime);
                        ArrayList<CustomerInfo> customerInfos = customerModel.getCustomerByCustomerID(customerID);

                        int amount = 0;
                        for (OrderDetailInfo orderDetailInfo : orderDetailInfos) {
                            amount += orderDetailInfo.getQuantity() * orderDetailInfo.getPrice();
                        }
                        orderModel.addOrder(new OrderInfo(orderID, customerID, currentDate, currentDate, customerInfos.get(0).getAddress(), customerInfos.get(0).getPhone(), "", amount + "", 1));

                        orderInfos = orderModel.getOrderByCustomerID(customerID);

                        orderDetailsModel.addOrderDetails(new OrderDetailInfo(orderDetailsID, orderInfos.get(0).getOrderID(), itemInfo.getItemID(), 1, itemInfo.getPrice()));

                        Toast.makeText(context, "Thêm giỏ hàng thành công", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return itemsDetailsLocations.size();
    }

    public class ItemsDetailsHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        LinearLayout button_AddToCart;
        TextView id, title, price, description;

        public ItemsDetailsHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.items_image);
            title = itemView.findViewById(R.id.items_title);
            id = itemView.findViewById(R.id.items_id);
            price = itemView.findViewById(R.id.items_price);
            description = itemView.findViewById(R.id.items_description);
            button_AddToCart = itemView.findViewById(R.id.button_AddToCart);
        }
    }
}
