package com.example.fatmancosmetic.Controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.fatmancosmetic.Adapter.ItemsAdapter;
import com.example.fatmancosmetic.Adapter.ItemsDetailsAdapter;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemDetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemDetails extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView backBtn, cartBtn;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    private String page;

    public ItemDetails(String page) {
        // Required empty public constructor
        this.page = page;
    }
    public ItemDetails() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ItemDetails.
     */
    // TODO: Rename and change types and number of parameters
    public static ItemDetails newInstance(String param1, String param2) {
        ItemDetails fragment = new ItemDetails();
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
        View view = inflater.inflate(R.layout.fragment_item_details, container, false);
        //Hooks
        recyclerView = view.findViewById(R.id.itemDetails_recyclerView);
        backBtn = view.findViewById(R.id.back_pressed);
        //cartBtn = view.findViewById(R.id.cart_pressed);

        //Recycle View Function Calls
        recyclerView();

        //Set handle
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                switch (page){
                    case "BestSellerItems":
                        BestSellerItems bestSellerItems = new BestSellerItems();
                        manager.beginTransaction().replace(R.id.fragment, bestSellerItems, bestSellerItems.getTag()).commit();
                        break;
                    case "CategoryBodyCare":
                        CategoryBodyCare categoryBodyCare = new CategoryBodyCare();
                        manager.beginTransaction().replace(R.id.fragment, categoryBodyCare, categoryBodyCare.getTag()).commit();
                        break;
                    case "CategorySkinCare":
                        CategorySkinCare categorySkinCare = new CategorySkinCare();
                        manager.beginTransaction().replace(R.id.fragment, categorySkinCare, categorySkinCare.getTag()).commit();
                        break;
                    case "CategoryMakeUp":
                        CategoryMakeUp categoryMakeUp = new CategoryMakeUp();
                        manager.beginTransaction().replace(R.id.fragment, categoryMakeUp, categoryMakeUp.getTag()).commit();
                        break;
                    case "FlashSaleItems":
                        FlashSaleItems flashSaleItems = new FlashSaleItems();
                        manager.beginTransaction().replace(R.id.fragment, flashSaleItems, flashSaleItems.getTag()).commit();
                        break;
                    case "Home":
                        Home home = new Home();
                        manager.beginTransaction().replace(R.id.fragment, home, home.getTag()).commit();
                        break;
                    case "NewItems":
                        NewItems newItems = new NewItems();
                        manager.beginTransaction().replace(R.id.fragment, newItems, newItems.getTag()).commit();
                        break;
                    case "ShoppingCart":
                        ShoppingCart shoppingCart = new ShoppingCart();
                        manager.beginTransaction().replace(R.id.fragment, shoppingCart, shoppingCart.getTag()).commit();
                        break;
                    default:
                        Home home1 = new Home();
                        manager.beginTransaction().replace(R.id.fragment, home1, home1.getTag()).commit();
                }
            }
        });
//        cartBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ShoppingCart shoppingCart = new ShoppingCart(page);
//                FragmentManager fragmentManager = getFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.fragment, shoppingCart, shoppingCart.getTag()).commit();
//            }
//        });
        return view;
    }
    private void recyclerView() {
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        ItemModel itemModel = new ItemModel(getContext());

        ArrayList<ItemInfo> listItems = new ArrayList<>();
        String itemID = getArguments().getString("itemID");

        listItems = itemModel.getItemsByItemID(itemID);

        FragmentManager fragmentManager = getFragmentManager();
        adapter = new ItemsDetailsAdapter(listItems, getContext(), fragmentManager);
        recyclerView.setAdapter(adapter);
    }
}