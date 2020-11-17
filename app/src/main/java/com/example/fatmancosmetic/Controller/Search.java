package com.example.fatmancosmetic.Controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fatmancosmetic.Adapter.ItemsAdapter;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.R;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Search#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Search extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Declare
    TextView searchBar;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<ItemInfo> listItems;

    public Search() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Search.
     */
    // TODO: Rename and change types and number of parameters
    public static Search newInstance(String param1, String param2) {
        Search fragment = new Search();
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
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        try {
            recyclerView = view.findViewById(R.id.search_recyclerView);
            searchBar = view.findViewById(R.id.search_bar);
            searchBar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchBar.setFocusable(true);
                }
            });
            // show recycleview
            recyclerView();
            searchBar.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    try {
                        String searchName = s.toString();

                        if (searchName.equals("")) {
                            recyclerView();
                        } else {
                            recyclerView(searchName);
                        }
                    } catch (Exception e) {
                        Toast.makeText(getContext(), "No result", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
        return view;
    }

    private void recyclerView(String txt) {
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        ItemModel itemModel = new ItemModel(getContext());

        listItems = new ArrayList<>();
        listItems = itemModel.getItemsByItemName(txt);

        FragmentManager fragmentManager = getFragmentManager();
        adapter = new ItemsAdapter(listItems, getContext(), fragmentManager, "Search");
        recyclerView.setAdapter(adapter);
    }

    private void recyclerView() {
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        ItemModel itemModel = new ItemModel(getContext());

        listItems = new ArrayList<>();
        listItems = itemModel.get4NewItems();

        FragmentManager fragmentManager = getFragmentManager();
        adapter = new ItemsAdapter(listItems, getContext(), fragmentManager, "Search");
        recyclerView.setAdapter(adapter);
    }


}