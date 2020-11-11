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

        brandModel.addBrand(new BrandInfo("000001","Louboutin",1));
        brandModel.addBrand(new BrandInfo("000002","TeBeaute",1));
        brandModel.addBrand(new BrandInfo("000003","Shiseido",1));

        categoryModel.addCategory(new CategoryInfo("000001", "Dưỡng Da", 1));
        categoryModel.addCategory(new CategoryInfo("000002", "Dưỡng Thể", 1));
        categoryModel.addCategory(new CategoryInfo("000003", "Trang Điểm", 1));

        ImageView imageView1 = new ImageView(this);
        ImageView imageView2 = new ImageView(this);
        ImageView imageView3 = new ImageView(this);
        ImageView imageView4 = new ImageView(this);
        ImageView imageView5 = new ImageView(this);
        ImageView imageView6 = new ImageView(this);
        ImageView imageView7 = new ImageView(this);
        ImageView imageView8 = new ImageView(this);
        ImageView imageView9 = new ImageView(this);
        ImageView imageView10 = new ImageView(this);
        ImageView imageView11 = new ImageView(this);
        ImageView imageView12 = new ImageView(this);

        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.item_000001));
        imageView2.setImageDrawable(getResources().getDrawable(R.drawable.item_000002));
        imageView3.setImageDrawable(getResources().getDrawable(R.drawable.item_000003));
        imageView4.setImageDrawable(getResources().getDrawable(R.drawable.item_000004));
        imageView5.setImageDrawable(getResources().getDrawable(R.drawable.item_000005));
        imageView6.setImageDrawable(getResources().getDrawable(R.drawable.item_000006));
        imageView7.setImageDrawable(getResources().getDrawable(R.drawable.item_000007));
        imageView8.setImageDrawable(getResources().getDrawable(R.drawable.item_000008));
        imageView9.setImageDrawable(getResources().getDrawable(R.drawable.item_000009));
        imageView10.setImageDrawable(getResources().getDrawable(R.drawable.item_000010));
        imageView11.setImageDrawable(getResources().getDrawable(R.drawable.item_000011));
        imageView12.setImageDrawable(getResources().getDrawable(R.drawable.item_000012));


        Bitmap bitmap1 = ((BitmapDrawable) imageView1.getDrawable()).getBitmap();
        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, baos1);
        byte[] imageInByte1 = baos1.toByteArray();

        Bitmap bitmap2 = ((BitmapDrawable) imageView2.getDrawable()).getBitmap();
        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, baos2);
        byte[] imageInByte2 = baos2.toByteArray();

        Bitmap bitmap3 = ((BitmapDrawable) imageView3.getDrawable()).getBitmap();
        ByteArrayOutputStream baos3 = new ByteArrayOutputStream();
        bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, baos3);
        byte[] imageInByte3 = baos3.toByteArray();

        Bitmap bitmap4 = ((BitmapDrawable) imageView4.getDrawable()).getBitmap();
        ByteArrayOutputStream baos4 = new ByteArrayOutputStream();
        bitmap4.compress(Bitmap.CompressFormat.JPEG, 100, baos4);
        byte[] imageInByte4 = baos4.toByteArray();

        Bitmap bitmap5 = ((BitmapDrawable) imageView5.getDrawable()).getBitmap();
        ByteArrayOutputStream baos5 = new ByteArrayOutputStream();
        bitmap5.compress(Bitmap.CompressFormat.JPEG, 100, baos5);
        byte[] imageInByte5 = baos5.toByteArray();

        Bitmap bitmap6 = ((BitmapDrawable) imageView6.getDrawable()).getBitmap();
        ByteArrayOutputStream baos6 = new ByteArrayOutputStream();
        bitmap6.compress(Bitmap.CompressFormat.JPEG, 100, baos6);
        byte[] imageInByte6 = baos6.toByteArray();

        Bitmap bitmap7 = ((BitmapDrawable) imageView7.getDrawable()).getBitmap();
        ByteArrayOutputStream baos7 = new ByteArrayOutputStream();
        bitmap7.compress(Bitmap.CompressFormat.JPEG, 100, baos7);
        byte[] imageInByte7 = baos7.toByteArray();

        Bitmap bitmap8 = ((BitmapDrawable) imageView8.getDrawable()).getBitmap();
        ByteArrayOutputStream baos8 = new ByteArrayOutputStream();
        bitmap8.compress(Bitmap.CompressFormat.JPEG, 100, baos8);
        byte[] imageInByte8 = baos8.toByteArray();

        Bitmap bitmap9 = ((BitmapDrawable) imageView9.getDrawable()).getBitmap();
        ByteArrayOutputStream baos9 = new ByteArrayOutputStream();
        bitmap9.compress(Bitmap.CompressFormat.JPEG, 100, baos9);
        byte[] imageInByte9 = baos9.toByteArray();

        Bitmap bitmap10 = ((BitmapDrawable) imageView10.getDrawable()).getBitmap();
        ByteArrayOutputStream baos10 = new ByteArrayOutputStream();
        bitmap10.compress(Bitmap.CompressFormat.JPEG, 100, baos10);
        byte[] imageInByte10 = baos10.toByteArray();

        Bitmap bitmap11 = ((BitmapDrawable) imageView11.getDrawable()).getBitmap();
        ByteArrayOutputStream baos11 = new ByteArrayOutputStream();
        bitmap11.compress(Bitmap.CompressFormat.JPEG, 100, baos11);
        byte[] imageInByte11 = baos11.toByteArray();

        Bitmap bitmap12 = ((BitmapDrawable) imageView12.getDrawable()).getBitmap();
        ByteArrayOutputStream baos12 = new ByteArrayOutputStream();
        bitmap12.compress(Bitmap.CompressFormat.JPEG, 100, baos12);
        byte[] imageInByte12 = baos12.toByteArray();


        itemModel.addItem(new ItemInfo("000001","000002","000003","Son Kem Lì Merzy Velvet Tint Season 3",imageInByte1,149000,"Son Kem Lì Merzy Velvet Tint Season 3 sớm nhất Việt Nam, với toàn những tông màu hot trend nhất hiện nay sẵn sàng đốn tim các tình yêu từ cái nhìn đầu tiên",1));
        itemModel.addItem(new ItemInfo("000002","000002","000003","Kem Lót Dưỡng Ẩm Nâng Tông Sixteen Brand 16 Guroom Cream",imageInByte2,159000,"Kem Lót Dưỡng Ẩm Nâng Tông Sixteen Brand 16 Guroom Cream có kết cấu mỏng nhẹ nhưng độ che phủ khá hoàn hảo giúp da bạn sẽ đạt được tông màu ưng ý. Việc dùng kem lót và kem nền khi trang điểm sẽ giúp việc trang điểm của bạn đạt hiệu quả cao hơn và bảo vệ da trước ánh nắng mặt trời cũng như các tác nhân gây hại khác.",1));
        itemModel.addItem(new ItemInfo("000003","000002","000003","Phấn Nước Che Phủ Chống Nắng Missha M Magic Cushion SPF 50+ PA+++",imageInByte3,149000,"Làn da không trắng sáng là lý do khiến bạn thiếu đi sự tự tin khi ra ngoài, do đó rất nhiều chị em lựa chọn giải pháp là sử dụng những loại phấn nước 2 công dụng che phủ khuyết điểm tự nhiên và chống nắng. Phấn nước che phủ chống nắng Missha M Magic Cushion SPF 50+ PA+++ chính là sản phẩm mà nhiều chị em phụ nữ đang tìm kiếm.",1));
        itemModel.addItem(new ItemInfo("000004","000002","000003","Phấn Phủ Che Phủ Lỗ Chân Lông Và Khuyết Điểm Eglips Blur Powder Pact",imageInByte4,159000,"Phấn phủ eglips đáp ứng được các tiêu chí: bền, lâu trôi, có khả năng che phủ lỗ chân lông và kiểm soát dầu tốt, không gây bí bức cho da",1));
        itemModel.addItem(new ItemInfo("000005","000002","000003","Bút Kẻ Sợi Mày Vacosi Realbrow Tattoo Pen",imageInByte5,159000,"Bút Kẻ Sợi Mày Vacosi Realbrow Tattoo Pen được đánh giá cao bằng việc sở hữu thiết kế đặc biệt ở phần đầu bút kẻ, giúp các chị em dễ dàng tạo các nét vẽ chân mày chính xác. Các đường chân mày sẽ trở nên thanh mảnh và tự nhiên hơn.",1));
        itemModel.addItem(new ItemInfo("000006","000002","000003","Bảng Phấn Mắt Nee Cara 9 Color Eyeshadow",imageInByte6,159000,"Dù là trang điểm hằng ngày hay đêm tiệc vẫn tỏa sáng lung linh với bảng phấn mắt Nee Cara 9 Color Eyeshadow - chỉ với một bảng phấn mắt đã bao gồm 3 kết cấu đặc trưng giúp cho bạn gái biến hóa Make Up Look tùy theo sở thích.",1));
        itemModel.addItem(new ItemInfo("000007","000002","000003","Kẻ Mắt Nước Chống Trôi Black Rouge All Day Power Proof Pen Liner",imageInByte7,159000,"Black Rouge đã tung ra bộ sưu tập mùa hè với chủ đề Pool Party mà bạn không thể bỏ lỡ - Kẻ Mắt Black Rouge All day Power Proof Pen Liner với tông màu chủ đạo living coral hot nhất hiện nay, chống trôi suốt ngày dài.",1));
        itemModel.addItem(new ItemInfo("000008","000002","000003","Phấn Nước Che Phủ Hoàn Hảo Chống Nắng Cả Ngày ABlack All Day Perfect Cover Cushion SPF 47 PA++",imageInByte8,159000,"Đối với những cô nàng da có nhiều thâm mụn, nám, tàn nhang, da không đều màu thì có thể sử dụng kem lót – kem che khuyết điểm – phấn nước để có được một làn da hoàn hảo và ở set Phấn Nước Che Phủ Hoàn Hảo Chống Nắng Cả Ngày ABlack All Day Perfect Cover Cushion SPF 47 PA++ này sẽ có đầy đủ cho một bước nền hoàn hảo, bao gồm: cushion, che khuyết điểm và kem lót với thiết kế \"sang xịn mịn\" giữa màu đen và màu vàng gold sẽ mang đến cho bạn sự tiện lợi nhất định khi sử dụng hoặc mang đi bên mình.",1));
        itemModel.addItem(new ItemInfo("000009","000002","000003","Mascara Làm Dày Và Dưỡng Mi Maybelline X Marvel The Colossal Instant Big Volume Mascara Waterproof",imageInByte9,159000,"Mascara Làm Dày Và Dưỡng Mi Maybelline X Marvel The Colossal Instant Big Volume Mascara Waterproof giúp dày mi ấn tượng, ngay lập tức để bạn tự tin và cuốn hút hơn, đặc biệt với phiên bản Marvel sẽ càng đặc biệt và hút mắt hơn nữa.",1));
        itemModel.addItem(new ItemInfo("000010","000002","000003","Phấn Phủ Bột Kiềm Dầu Không Màu Phiên Bản Giới Hạn Innisfree No-Sebum Mineral Powder Mentos",imageInByte10,159000,"Phấn Phủ Bột Kiềm Dầu Không Màu Phiên Bản Giới Hạn Innisfree No-Sebum Mineral Powder Mentos là phiên bản kỷ niệm 14 năm ra mắt sản phẩm No sebum. Lần này, phiên bản phấn phủ được lấy cảm hứng từ những viên kẹo Mentos với đặc trưng tươi mát - sẽ mang lại cảm giác tươi mới như sản phẩm No sebum mang lại trên làn da.",1));
        itemModel.addItem(new ItemInfo("000011","000002","000003","Má Hồng Peripera Pure Blushed Velvet Cheek",imageInByte11,159000,"Peripera Pure Blushed Velvet Cheek là phấn má hồng thuộc bộ sưu tập trang điểm cho mùa Thu Đông 2019 của Peripera. Với chất phấn mềm mịn và bảng màu đa dạng, Peripera Pure Blushed Velvet Cheek sẽ đem lại cho bạn 1 đôi gò má ửng hồng xinh xắn, rạng rỡ trong tiết trời se lạnh cuối năm.",1));
        itemModel.addItem(new ItemInfo("000012","000002","000003","Bảng Mắt Merzy Bite The Beat Shadow Palette Pop In Mood",imageInByte12,159000,"Merzy Bite The Beat Shadow Palette Pop In Mood là một sản phẩm đa dụng khi vừa là phấn mắt - má hồng - tạo khối.",1));


//        ArrayList<ItemInfo> listItems = new ArrayList<>();
//        listItems = itemModel.getAllItem();
//        listItems.get(1).setImage(imageInByte);

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