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
import android.widget.ImageView;

import com.example.fatmancosmetic.Adapter.ItemsAdapter;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryMakeUp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryMakeUp extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView makeUpItems_recyclerView;
    private RecyclerView.Adapter makeUpItems_adapter;
    private ImageView backBtn;


    public CategoryMakeUp() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MakeUpItems.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryMakeUp newInstance(String param1, String param2) {
        CategoryMakeUp fragment = new CategoryMakeUp();
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
        View view = inflater.inflate(R.layout.fragment_category_make_up, container, false);
        try {
            //Hooks
            makeUpItems_recyclerView = view.findViewById(R.id.makeUpItems_recyclerView);
            backBtn = view.findViewById(R.id.back_pressed);


            //Recycle View Function Calls
            makeUpItems_recyclerView();

            //Set handle
            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Home home = new Home();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment, home, home.getTag()).commit();
                }
            });
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
        return view;
    }

    private void makeUpItems_recyclerView() {
        makeUpItems_recyclerView.setHasFixedSize(true);

        makeUpItems_recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        ItemModel itemModel = new ItemModel(getContext());

        ArrayList<ItemInfo> listItems = new ArrayList<>();
        listItems = itemModel.getMakeUpItems();

        FragmentManager fragmentManager = getFragmentManager();
        makeUpItems_adapter = new ItemsAdapter(listItems, getContext(), fragmentManager, "CategoryMakeUp");
        makeUpItems_recyclerView.setAdapter(makeUpItems_adapter);
    }
}