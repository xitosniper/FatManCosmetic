package com.example.fatmancosmetic.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fatmancosmetic.Controller.BillsDetail;
import com.example.fatmancosmetic.Controller.ItemDetails;
import com.example.fatmancosmetic.Controller.MyBill;
import com.example.fatmancosmetic.Info.OrderInfo;
import com.example.fatmancosmetic.R;

import java.util.ArrayList;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.BillViewHolder> {

    ArrayList<OrderInfo> listOrder;
    FragmentManager fragmentManager;
    Context context;

    public BillAdapter(ArrayList<OrderInfo> listorder, FragmentManager fragmentManager, Context context) {
        this.listOrder = listorder;
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    @NonNull
    @Override
    public BillAdapter.BillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_card_design, parent, false);
        BillViewHolder billViewHolder = new BillViewHolder(view);

        return billViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BillAdapter.BillViewHolder holder, int position) {
        OrderInfo orderInfo = listOrder.get(position);
        holder.bill_title.setText(orderInfo.getOrderID());
        holder.bill_date.setText(orderInfo.getOrderDate());

        holder.bill_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BillsDetail billsDetail = new BillsDetail();
                Bundle bundle = new Bundle();
                bundle.putString("customerID", "000001");
                //set Fragmentclass Arguments
                billsDetail.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.fragment, billsDetail, billsDetail.getTag()).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return listOrder.size();
    }

    public class BillViewHolder extends RecyclerView.ViewHolder{

        TextView bill_title, bill_date;
        public BillViewHolder(@NonNull View itemView) {
            super(itemView);

            bill_title = itemView.findViewById(R.id.bill_title);

            bill_date = itemView.findViewById(R.id.date_bill);


        }
    }
}
