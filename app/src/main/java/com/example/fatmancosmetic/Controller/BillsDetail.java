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
import com.example.fatmancosmetic.Adapter.BillDetailAdapter;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Info.OrderInfo;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.Model.OrderModel;
import com.example.fatmancosmetic.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BillsDetail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BillsDetail extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    RecyclerView recyclerView;
    TextView title_detail, name;
    RecyclerView.Adapter adapter;
    ArrayList<OrderInfo> listOrder;

    public BillsDetail() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BillsDetail.
     */
    // TODO: Rename and change types and number of parameters
    public static BillsDetail newInstance(String param1, String param2) {
        BillsDetail fragment = new BillsDetail();
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
        View view = inflater.inflate(R.layout.fragment_bills_detail, container, false);

        recyclerView = view.findViewById(R.id.billsDetail_Recyclerview);

        title_detail = view.findViewById(R.id.bill_code);
        name = view.findViewById(R.id.bill_customer);
        recyclerView();
        return view;
    }

    private void recyclerView() {
        Log.e("Testtttt", "Success");
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL,false));

        String customerID = "000001";

        OrderModel orderModel = new OrderModel(getContext());
        listOrder = new ArrayList<>();

        String orderId = getArguments().getString("codeBill");

        listOrder = orderModel.getOrderByCustomerIDBill(customerID, orderId);
        title_detail.setText(orderId);
        ItemModel itemModel = new ItemModel(getContext());
        ArrayList<ItemInfo> itemList = new ArrayList<>();
        itemList = itemModel.getItemsByCodeBill(orderId);

        FragmentManager fragmentManager = getFragmentManager();
        adapter = new BillDetailAdapter(itemList, getContext(), fragmentManager);
        //adapter = new BillDetailAdapter(listOrder, fragmentManager, getContext());
        recyclerView.setAdapter(adapter);

    }
}