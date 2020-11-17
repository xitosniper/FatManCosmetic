package com.example.fatmancosmetic.Controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fatmancosmetic.Adapter.BillAdapter;
import com.example.fatmancosmetic.Adapter.ItemsAdapter;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Info.OrderInfo;
import com.example.fatmancosmetic.Model.OrderModel;
import com.example.fatmancosmetic.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyBill#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyBill extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    RecyclerView recyclerView;
    TextView title;
    RecyclerView.Adapter adapter;
    ArrayList<OrderInfo> listOrder;

    public MyBill() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyBill.
     */
    // TODO: Rename and change types and number of parameters
    public static MyBill newInstance(String param1, String param2) {
        MyBill fragment = new MyBill();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_bill, container, false);
        try {
            recyclerView = view.findViewById(R.id.bill_recyclerView);
            recyclerView();
//
//        title  = view.findViewById(R.id.bill_title);
//
//        title.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View view = inflater.inflate(R.layout.fragment_bills_detail, container, false);
//            }
//        });


        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }

        return view;
    }

    private void recyclerView() {
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));

        String customerID = "000001";
        OrderModel orderModel = new OrderModel(getContext());
        listOrder = new ArrayList<>();
        listOrder = orderModel.getOrderByCustomerID(customerID);

        FragmentManager fragmentManager = getFragmentManager();
        adapter = new BillAdapter(listOrder, fragmentManager, getContext());
        recyclerView.setAdapter(adapter);

        Log.e("after ", "..........................");

    }
}