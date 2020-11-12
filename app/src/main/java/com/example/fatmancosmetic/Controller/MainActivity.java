package com.example.fatmancosmetic.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

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

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private NavController navController;
//    private BrandModel brandModel;
//    private CategoryModel categoryModel;
//    private ItemModel itemModel;
//    private DBManager dbManager;
//    private Fragment homeFragment = new Home();
//    private Fragment searchFragment = new Search();
//    private Fragment shoppingCartFragment = new ShoppingCart();
//    private Fragment accountFragment = new Account();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
//        dbManager = new DBManager(this);
//        brandModel = new BrandModel(this);
//        categoryModel = new CategoryModel(this);
//        itemModel = new ItemModel(this);

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

