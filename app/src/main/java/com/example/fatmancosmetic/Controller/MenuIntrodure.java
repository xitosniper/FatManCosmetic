package com.example.fatmancosmetic.Controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fatmancosmetic.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuIntrodure#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuIntrodure extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Variables
    ImageView btnBack;

    public MenuIntrodure() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Introdure.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuIntrodure newInstance(String param1, String param2) {
        MenuIntrodure fragment = new MenuIntrodure();
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
        View view = inflater.inflate(R.layout.fragment_introdure, container, false);
        try {
            btnBack = view.findViewById(R.id.back_pressed);
            btnBack.setOnClickListener(new View.OnClickListener() {
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
}