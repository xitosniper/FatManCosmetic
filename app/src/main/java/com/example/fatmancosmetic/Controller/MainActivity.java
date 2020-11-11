package com.example.fatmancosmetic.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;


import android.os.Bundle;
import android.view.WindowManager;

import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.fatmancosmetic.DBManager.DBManager;
import com.example.fatmancosmetic.Info.BrandInfo;
import com.example.fatmancosmetic.Info.CategoryInfo;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Model.BrandModel;
import com.example.fatmancosmetic.Model.CategoryModel;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private BrandModel brandModel;
    private CategoryModel categoryModel;
    private ItemModel itemModel;
    private DBManager dbManager;
//    private Fragment homeFragment = new Home();
//    private Fragment searchFragment = new Search();
//    private Fragment shoppingCartFragment = new ShoppingCart();
//    private Fragment accountFragment = new Account();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        dbManager = new DBManager(this);
        brandModel = new BrandModel(this);
        categoryModel = new CategoryModel(this);
        itemModel = new ItemModel(this);

//        brandModel.addBrand(new BrandInfo("000001","Louboutin",1));
//        brandModel.addBrand(new BrandInfo("000002","TeBeaute",1));
//        brandModel.addBrand(new BrandInfo("000003","Shiseido",1));
//
//        categoryModel.addCategory(new CategoryInfo("000001", "Dưỡng Da", 1));
//        categoryModel.addCategory(new CategoryInfo("000002", "Dưỡng Thể", 1));
//        categoryModel.addCategory(new CategoryInfo("000003", "Trang Điểm", 1));
//
//        itemModel.addItem(new ItemInfo("000001","000002","000003","Son Kem Lì Merzy Velvet Tint Season 3",null,149000,"Son Kem Lì Merzy Velvet Tint Season 3 sớm nhất Việt Nam, với toàn những tông màu hot trend nhất hiện nay sẵn sàng đốn tim các tình yêu từ cái nhìn đầu tiên",1));
//        itemModel.addItem(new ItemInfo("000002","000002","000003","Kem Lót Dưỡng Ẩm Nâng Tông Sixteen Brand 16 Guroom Cream",null,159000,"Kem Lót Dưỡng Ẩm Nâng Tông Sixteen Brand 16 Guroom Cream có kết cấu mỏng nhẹ nhưng độ che phủ khá hoàn hảo giúp da bạn sẽ đạt được tông màu ưng ý. Việc dùng kem lót và kem nền khi trang điểm sẽ giúp việc trang điểm của bạn đạt hiệu quả cao hơn và bảo vệ da trước ánh nắng mặt trời cũng như các tác nhân gây hại khác.",1));


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(MainActivity.this, R.id.fragment);
        NavigationUI.setupWithNavController((BottomNavigationView) findViewById(R.id.bottomNavigationView), Navigation.findNavController(MainActivity.this, R.id.fragment));

    }

    @Override
    public boolean onSupportNavigateUp() {
        Navigation.findNavController(MainActivity.this,R.id.fragment).navigateUp();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}