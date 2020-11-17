package com.example.fatmancosmetic.Controller;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fatmancosmetic.Adapter.AmazingFatManAdapter;
import com.example.fatmancosmetic.Adapter.ItemsAdapter;
import com.example.fatmancosmetic.Info.AmazingFatManInfo;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.R;
import com.google.android.material.navigation.NavigationView;

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
    private ConstraintLayout contentView;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView flashsafe_recyclerView, amazingFatman_recyclerView, bestsale_recyclerView, newitems_recyclerView;
    private RecyclerView.Adapter flashsafe_adapter, amazingFatmat_adapter, bestsale_adapter, newitems_adapter;
    private ImageView menuIcon, skinCareBtn, bodyCareBtn, makeUpBtn;
    private TextView lbSeeMoreFlashSale, lbSeeMoreNewItems, lbSeeMoreBestSeller;
    private EditText btnSearch;

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
        try {
            //Animation banner Slider Image
            ImageView imageViewBanner = view.findViewById(R.id.imageViewBanner);
            AnimationDrawable animationDrawable = (AnimationDrawable) imageViewBanner.getDrawable();
            animationDrawable.start();
            //Hooks
            flashsafe_recyclerView = view.findViewById(R.id.flashsafe_recyclerView);
            amazingFatman_recyclerView = view.findViewById(R.id.amazing_fatman_recyclerView);
            newitems_recyclerView = view.findViewById(R.id.newitems_recyclerView);
            bestsale_recyclerView = view.findViewById(R.id.bestsale_fatman_recyclerView);
            contentView = view.findViewById(R.id.content);
            skinCareBtn = view.findViewById(R.id.nav_all_skincare);
            bodyCareBtn = view.findViewById(R.id.nav_all_bodyCare);
            makeUpBtn = view.findViewById(R.id.nav_all_makeUp);
            btnSearch = view.findViewById(R.id.search_bar);
            //Menu Hooks
            drawerLayout = view.findViewById(R.id.draw_layout);
            navigationView = view.findViewById(R.id.navigation_view);
            menuIcon = view.findViewById(R.id.menuIcon);
            lbSeeMoreFlashSale = view.findViewById(R.id.lbSeeMoreFlashSale);
            lbSeeMoreNewItems = view.findViewById(R.id.lbSeeMoreNewItems);
            lbSeeMoreBestSeller = view.findViewById(R.id.lbSeeMoreBestSeller);

            //Navigation Drawer Functions Calls
            navigationDrawer();


            //Recycle View Function Calls
            amazingFatman_recyclerView();

            newitems_recyclerView();
            flashsafe_recyclerView();
            bestsale_recyclerView();


            //Set Handel
            btnSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Search search = new Search();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment, search, search.getTag()).commit();
                }
            });


            skinCareBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CategorySkinCare categorySkinCare = new CategorySkinCare();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment, categorySkinCare, categorySkinCare.getTag()).commit();
                }
            });

            bodyCareBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CategoryBodyCare categoryBodyCare = new CategoryBodyCare();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment, categoryBodyCare, categoryBodyCare.getTag()).commit();
                }
            });

            makeUpBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CategoryMakeUp categoryMakeUp = new CategoryMakeUp();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment, categoryMakeUp, categoryMakeUp.getTag()).commit();
                }
            });

            lbSeeMoreFlashSale.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FlashSaleItems flashSaleItems = new FlashSaleItems();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment, flashSaleItems, flashSaleItems.getTag()).commit();
                }
            });

            lbSeeMoreNewItems.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NewItems newItems = new NewItems();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment, newItems, newItems.getTag()).commit();
                }
            });

            lbSeeMoreBestSeller.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BestSellerItems bestSellerItems = new BestSellerItems();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment, bestSellerItems, bestSellerItems.getTag()).commit();
                }
            });

        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
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

        drawerLayout.setScrimColor(getResources().getColor(R.color.colorMenuNavigation));
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
        FragmentManager manager = getFragmentManager();
        switch (item.getItemId()) {
            case R.id.introduce:
                MenuIntrodure menuIntrodure = new MenuIntrodure();
                manager.beginTransaction().replace(R.id.fragment, menuIntrodure, menuIntrodure.getTag()).commit();
                break;
            case R.id.facial_skin_care:
                CategorySkinCare categorySkinCare = new CategorySkinCare();
                manager.beginTransaction().replace(R.id.fragment, categorySkinCare, categorySkinCare.getTag()).commit();
                break;
            case R.id.body_care:
                CategoryBodyCare categoryBodyCare = new CategoryBodyCare();
                manager.beginTransaction().replace(R.id.fragment, categoryBodyCare, categoryBodyCare.getTag()).commit();
                break;
            case R.id.make_up:
                CategoryMakeUp categoryMakeUp = new CategoryMakeUp();
                manager.beginTransaction().replace(R.id.fragment, categoryMakeUp, categoryMakeUp.getTag()).commit();
                break;
            case R.id.new_items:
                NewItems newItems = new NewItems();
                manager.beginTransaction().replace(R.id.fragment, newItems, newItems.getTag()).commit();
                break;
            case R.id.sale_off:
                FlashSaleItems flashSaleItems = new FlashSaleItems();
                manager.beginTransaction().replace(R.id.fragment, flashSaleItems, flashSaleItems.getTag()).commit();
                break;
            case R.id.transport:

                break;
            case R.id.return_policy:

                break;

        }
        return true;
    }

    //Recycle Views Function
    private void flashsafe_recyclerView() {
        flashsafe_recyclerView.setHasFixedSize(true);
        flashsafe_recyclerView.setLayoutManager(new LinearLayoutManager(this.mainActivity, LinearLayoutManager.HORIZONTAL, false));
        ItemModel itemModel = new ItemModel(this.mainActivity);

        ArrayList<ItemInfo> listItems = new ArrayList<>();
        listItems = itemModel.get4SaleItems();

        FragmentManager fragmentManager = getFragmentManager();
        flashsafe_adapter = new ItemsAdapter(listItems, this.mainActivity, fragmentManager, "Home");
        flashsafe_recyclerView.setAdapter(flashsafe_adapter);
    }

    private void newitems_recyclerView() {
        newitems_recyclerView.setHasFixedSize(true);

        newitems_recyclerView.setLayoutManager(new GridLayoutManager(this.mainActivity, 2, GridLayoutManager.VERTICAL, false));
        ArrayList<ItemInfo> bestSaleLocation = new ArrayList<>();
        ItemModel itemModel = new ItemModel(this.mainActivity);

        ArrayList<ItemInfo> listItems = new ArrayList<>();
        listItems = itemModel.get4NewItems();

        FragmentManager fragmentManager = getFragmentManager();
        newitems_adapter = new ItemsAdapter(listItems, this.mainActivity, fragmentManager, "Home");
        newitems_recyclerView.setAdapter(newitems_adapter);
    }

    private void bestsale_recyclerView() {
        bestsale_recyclerView.setHasFixedSize(true);

        bestsale_recyclerView.setLayoutManager(new GridLayoutManager(this.mainActivity, 2, GridLayoutManager.VERTICAL, false));
        ItemModel itemModel = new ItemModel(this.mainActivity);

        ArrayList<ItemInfo> listItems = new ArrayList<>();
        listItems = itemModel.get4BestSaleItems();

        FragmentManager fragmentManager = getFragmentManager();
        bestsale_adapter = new ItemsAdapter(listItems, this.mainActivity, fragmentManager, "Home");
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
//        for (int i = 0; i < listItems.size(); i++) {
//            listItems.get(i).setImage(imageInByte);
//        }
//        Log.e("Image Home: ",listItems.get(0).getImage()+"");
//        flashSaleLocation.add(new FlashSaleInfo(R.drawable.phan_nuoc, "Phấn Nước Che Phủ Chống Nắng M ...", "139,000đ"));
//        flashSaleLocation.add(new FlashSaleInfo(R.drawable.son_li, "Son Kem Lì Merzy Velvet Tint Season 3", "129,000đ"));
//        flashSaleLocation.add(new FlashSaleInfo(R.drawable.kem_lot_duong, "Kem Lót Dưỡng Ẩm Nâng Tông ...", "159,000đ"));
//        flashSaleLocation.add(new FlashSaleInfo(R.drawable.but_ke_soi_mai, "Bút Kẻ Sợi Mày Vacosi ...", "159,000đ"));
