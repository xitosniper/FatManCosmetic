package com.example.fatmancosmetic.Controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fatmancosmetic.Adapter.AmazingFatManAdapter;
import com.example.fatmancosmetic.Adapter.FlashSafeAdapter;
import com.example.fatmancosmetic.Info.AmazingFatManInfo;
import com.example.fatmancosmetic.Info.FlashSaleInfo;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.R;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Variables
    static final float END_SCALE = 0.7f;
    private MainActivity mainActivity;
    ConstraintLayout contentView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    RecyclerView flashsafe_recyclerView, amazingFatman_recyclerView, bestsale_recyclerView;
    RecyclerView.Adapter flashsafe_adapter, amazingFatmat_adapter, bestsale_adapter;
    ImageView menuIcon;
    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //Animation banner Slider Image
        ImageView imageViewBanner = view.findViewById(R.id.imageViewBanner);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageViewBanner.getDrawable();
        animationDrawable.start();
        //Hooks
        flashsafe_recyclerView = view.findViewById(R.id.flashsafe_recyclerView);
        amazingFatman_recyclerView = view.findViewById(R.id.amazing_fatman_recyclerView);
        bestsale_recyclerView = view.findViewById(R.id.bestsale_fatman_recyclerView);
        contentView = view.findViewById(R.id.content);

        //Menu Hooks
        drawerLayout = view.findViewById(R.id.draw_layout);
        navigationView = view.findViewById(R.id.navigation_view);
        menuIcon = view.findViewById(R.id.menuIcon);

        //Navigation Drawer Functions Calls
        navigationDrawer();


        //Recycle View Function Calls
        amazingFatman_recyclerView();
        flashsafe_recyclerView();
        bestsafe_recyclerView();

        return view;
    }

    // Called when a fragment is first attached to its context.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof MainActivity) {
            this.mainActivity = (MainActivity) context;
        }
    }

    //Navigation Drawer Functions
    private void navigationDrawer() {
        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        //navigationView.setCheckedItem(R.id.nav_menu);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        animateNavigationDrawer();
    }

    public void animateNavigationDrawer() {
        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();

        drawerLayout.setScrimColor(getResources().getColor(R.color.colorMenuBottomNavigation));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    //Recycle Views Function
    private void flashsafe_recyclerView() {
        flashsafe_recyclerView.setHasFixedSize(true);
        flashsafe_recyclerView.setLayoutManager(new LinearLayoutManager(this.mainActivity, LinearLayoutManager.HORIZONTAL, false));
        //ArrayList<FlashSaleInfo> flashSaleLocation = new ArrayList<>();
        ItemModel itemModel = new ItemModel(this.mainActivity);
//        ImageView imageView = new ImageView(this.mainActivity);
//
//        imageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.but_ke_soi_mai));
//
//
//        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//        byte[] imageInByte = baos.toByteArray();
//
//
        ArrayList<ItemInfo> listItems = new ArrayList<>();
        listItems = itemModel.get4SalesItem();

//        for (int i = 0; i < listItems.size(); i++) {
//            listItems.get(i).setImage(imageInByte);
//        }
//        Log.e("Image Home: ",listItems.get(0).getImage()+"");
//        flashSaleLocation.add(new FlashSaleInfo(R.drawable.phan_nuoc, "Phấn Nước Che Phủ Chống Nắng M ...", "139,000đ"));
//        flashSaleLocation.add(new FlashSaleInfo(R.drawable.son_li, "Son Kem Lì Merzy Velvet Tint Season 3", "129,000đ"));
//        flashSaleLocation.add(new FlashSaleInfo(R.drawable.kem_lot_duong, "Kem Lót Dưỡng Ẩm Nâng Tông ...", "159,000đ"));
//        flashSaleLocation.add(new FlashSaleInfo(R.drawable.but_ke_soi_mai, "Bút Kẻ Sợi Mày Vacosi ...", "159,000đ"));

        flashsafe_adapter = new FlashSafeAdapter(listItems, this.mainActivity);
        flashsafe_recyclerView.setAdapter(flashsafe_adapter);
    }

    //Recycle Views Function Of bestsale_recyclerView
    private void bestsafe_recyclerView() {
        bestsale_recyclerView.setHasFixedSize(true);
//        bestsale_recyclerView.setLayoutManager(new LinearLayoutManager(this.mainActivity, LinearLayoutManager.HORIZONTAL, false));
        bestsale_recyclerView.setLayoutManager(new GridLayoutManager(this.mainActivity, 2, GridLayoutManager.VERTICAL,false));
        ArrayList<ItemInfo> bestSaleLocation = new ArrayList<>();
        ItemModel itemModel = new ItemModel(this.mainActivity);
        ImageView imageView = new ImageView(this.mainActivity);

        ArrayList<ItemInfo> listItems = new ArrayList<>();
        listItems = itemModel.get4SalesItem();

        bestsale_adapter = new FlashSafeAdapter(listItems, this.mainActivity);
        bestsale_recyclerView.setAdapter(bestsale_adapter);
    }

    private void amazingFatman_recyclerView() {
        amazingFatman_recyclerView.setHasFixedSize(true);
        amazingFatman_recyclerView.setLayoutManager(new LinearLayoutManager(this.mainActivity, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<AmazingFatManInfo> amazingFatLocation = new ArrayList<>();

        amazingFatLocation.add(new AmazingFatManInfo(R.drawable.dien_mao_moi, "Oanh tạc diện mạo mới của BBIA"));
        amazingFatLocation.add(new AmazingFatManInfo(R.drawable.warning, "Cảnh báo lừa đảo mạo danh Fat Man Cosmetic"));
        amazingFatLocation.add(new AmazingFatManInfo(R.drawable.bao_boi, "4 món bảo bối thần kì giúp các bạn nữ Dậy thì thành công"));
        amazingFatLocation.add(new AmazingFatManInfo(R.drawable.bi_quyet, "Mổ xẻ công cụ tuyệt vời đến từ yuja some by me"));

        amazingFatmat_adapter = new AmazingFatManAdapter(amazingFatLocation);
        amazingFatman_recyclerView.setAdapter(amazingFatmat_adapter);
    }


}
