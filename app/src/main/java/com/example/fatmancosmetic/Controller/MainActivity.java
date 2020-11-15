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
import com.example.fatmancosmetic.Info.CustomerInfo;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Info.OrderDetailInfo;
import com.example.fatmancosmetic.Info.OrderInfo;
import com.example.fatmancosmetic.Model.BrandModel;
import com.example.fatmancosmetic.Model.CategoryModel;
import com.example.fatmancosmetic.Model.CustomerModel;
import com.example.fatmancosmetic.Model.ItemModel;
import com.example.fatmancosmetic.Model.OrderDetailsModel;
import com.example.fatmancosmetic.Model.OrderModel;
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
    private OrderModel orderModel;
    private OrderDetailsModel orderDetailsModel;
    private CustomerModel customerModel;
    private DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Function Add Data Into DB Call
        addDB();

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

    public void addDB(){
        dbManager = new DBManager(this);
        brandModel = new BrandModel(this);
        categoryModel = new CategoryModel(this);
        itemModel = new ItemModel(this);
        orderModel = new OrderModel(this);
        orderDetailsModel = new OrderDetailsModel(this);
        customerModel = new CustomerModel(this);

        brandModel.addBrand(new BrandInfo("000001","Louboutin",1));
        brandModel.addBrand(new BrandInfo("000002","TeBeaute",1));
        brandModel.addBrand(new BrandInfo("000003","Shiseido",1));

        categoryModel.addCategory(new CategoryInfo("000001", "Dưỡng Thể", 1));
        categoryModel.addCategory(new CategoryInfo("000002", "Trang Điểm", 1));
        categoryModel.addCategory(new CategoryInfo("000003", "Dưỡng Da", 1));

        orderModel.addOrder(new OrderInfo("000001","000001","2020/11/10","2020/11/11","2Q1 Bình Giã P.13","0903831374","","175000",1));
        orderDetailsModel.addOrderDetails(new OrderDetailInfo("000001","000001","000035",2,140000));
        orderDetailsModel.addOrderDetails(new OrderDetailInfo("000002","000001","000036",1,59000));

        customerModel.addCustomer(new CustomerInfo("000001","","123456","","","","","Nguyễn Thị Khương","","28",1,"0903831374","2Q1 Bình Giã P.13","khuongnt@gmail.com",1));


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

        ImageView imageView13 = new ImageView(this);
        ImageView imageView14 = new ImageView(this);
        ImageView imageView15 = new ImageView(this);
        ImageView imageView16 = new ImageView(this);
        ImageView imageView17 = new ImageView(this);
        ImageView imageView18 = new ImageView(this);
        ImageView imageView19 = new ImageView(this);
        ImageView imageView20 = new ImageView(this);
        ImageView imageView21 = new ImageView(this);
        ImageView imageView22 = new ImageView(this);
        ImageView imageView23 = new ImageView(this);
        ImageView imageView24 = new ImageView(this);

        ImageView imageView25 = new ImageView(this);
        ImageView imageView26 = new ImageView(this);
        ImageView imageView27 = new ImageView(this);
        ImageView imageView28 = new ImageView(this);
        ImageView imageView29 = new ImageView(this);
        ImageView imageView30 = new ImageView(this);
        ImageView imageView31 = new ImageView(this);
        ImageView imageView32 = new ImageView(this);
        ImageView imageView33 = new ImageView(this);
        ImageView imageView34 = new ImageView(this);
        ImageView imageView35 = new ImageView(this);
        ImageView imageView36 = new ImageView(this);




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

        imageView13.setImageDrawable(getResources().getDrawable(R.drawable.item_000013));
        imageView14.setImageDrawable(getResources().getDrawable(R.drawable.item_000014));
        imageView15.setImageDrawable(getResources().getDrawable(R.drawable.item_000015));
        imageView16.setImageDrawable(getResources().getDrawable(R.drawable.item_000016));
        imageView17.setImageDrawable(getResources().getDrawable(R.drawable.item_000017));
        imageView18.setImageDrawable(getResources().getDrawable(R.drawable.item_000018));
        imageView19.setImageDrawable(getResources().getDrawable(R.drawable.item_000019));
        imageView20.setImageDrawable(getResources().getDrawable(R.drawable.item_000020));
        imageView21.setImageDrawable(getResources().getDrawable(R.drawable.item_000021));
        imageView22.setImageDrawable(getResources().getDrawable(R.drawable.item_000022));
        imageView23.setImageDrawable(getResources().getDrawable(R.drawable.item_000023));
        imageView24.setImageDrawable(getResources().getDrawable(R.drawable.item_000024));

        imageView25.setImageDrawable(getResources().getDrawable(R.drawable.item_000025));
        imageView26.setImageDrawable(getResources().getDrawable(R.drawable.item_000026));
        imageView27.setImageDrawable(getResources().getDrawable(R.drawable.item_000027));
        imageView28.setImageDrawable(getResources().getDrawable(R.drawable.item_000028));
        imageView29.setImageDrawable(getResources().getDrawable(R.drawable.item_000029));
        imageView30.setImageDrawable(getResources().getDrawable(R.drawable.item_000030));
        imageView31.setImageDrawable(getResources().getDrawable(R.drawable.item_000031));
        imageView32.setImageDrawable(getResources().getDrawable(R.drawable.item_000032));
        imageView33.setImageDrawable(getResources().getDrawable(R.drawable.item_000033));
        imageView34.setImageDrawable(getResources().getDrawable(R.drawable.item_000034));
        imageView35.setImageDrawable(getResources().getDrawable(R.drawable.item_000035));
        imageView36.setImageDrawable(getResources().getDrawable(R.drawable.item_000036));



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


        Bitmap bitmap13 = ((BitmapDrawable) imageView13.getDrawable()).getBitmap();
        ByteArrayOutputStream baos13 = new ByteArrayOutputStream();
        bitmap13.compress(Bitmap.CompressFormat.JPEG, 100, baos13);
        byte[] imageInByte13 = baos13.toByteArray();

        Bitmap bitmap14 = ((BitmapDrawable) imageView14.getDrawable()).getBitmap();
        ByteArrayOutputStream baos14 = new ByteArrayOutputStream();
        bitmap14.compress(Bitmap.CompressFormat.JPEG, 100, baos14);
        byte[] imageInByte14 = baos14.toByteArray();

        Bitmap bitmap15 = ((BitmapDrawable) imageView15.getDrawable()).getBitmap();
        ByteArrayOutputStream baos15 = new ByteArrayOutputStream();
        bitmap15.compress(Bitmap.CompressFormat.JPEG, 100, baos15);
        byte[] imageInByte15 = baos15.toByteArray();

        Bitmap bitmap16 = ((BitmapDrawable) imageView16.getDrawable()).getBitmap();
        ByteArrayOutputStream baos16 = new ByteArrayOutputStream();
        bitmap16.compress(Bitmap.CompressFormat.JPEG, 100, baos16);
        byte[] imageInByte16 = baos16.toByteArray();

        Bitmap bitmap17 = ((BitmapDrawable) imageView17.getDrawable()).getBitmap();
        ByteArrayOutputStream baos17 = new ByteArrayOutputStream();
        bitmap17.compress(Bitmap.CompressFormat.JPEG, 100, baos17);
        byte[] imageInByte17 = baos17.toByteArray();

        Bitmap bitmap18 = ((BitmapDrawable) imageView18.getDrawable()).getBitmap();
        ByteArrayOutputStream baos18 = new ByteArrayOutputStream();
        bitmap18.compress(Bitmap.CompressFormat.JPEG, 100, baos18);
        byte[] imageInByte18 = baos18.toByteArray();

        Bitmap bitmap19 = ((BitmapDrawable) imageView19.getDrawable()).getBitmap();
        ByteArrayOutputStream baos19 = new ByteArrayOutputStream();
        bitmap19.compress(Bitmap.CompressFormat.JPEG, 100, baos19);
        byte[] imageInByte19 = baos19.toByteArray();

        Bitmap bitmap20 = ((BitmapDrawable) imageView20.getDrawable()).getBitmap();
        ByteArrayOutputStream baos20 = new ByteArrayOutputStream();
        bitmap20.compress(Bitmap.CompressFormat.JPEG, 100, baos20);
        byte[] imageInByte20 = baos20.toByteArray();

        Bitmap bitmap21 = ((BitmapDrawable) imageView21.getDrawable()).getBitmap();
        ByteArrayOutputStream baos21 = new ByteArrayOutputStream();
        bitmap21.compress(Bitmap.CompressFormat.JPEG, 100, baos21);
        byte[] imageInByte21 = baos21.toByteArray();

        Bitmap bitmap22 = ((BitmapDrawable) imageView22.getDrawable()).getBitmap();
        ByteArrayOutputStream baos22 = new ByteArrayOutputStream();
        bitmap22.compress(Bitmap.CompressFormat.JPEG, 100, baos22);
        byte[] imageInByte22 = baos22.toByteArray();

        Bitmap bitmap23 = ((BitmapDrawable) imageView23.getDrawable()).getBitmap();
        ByteArrayOutputStream baos23 = new ByteArrayOutputStream();
        bitmap23.compress(Bitmap.CompressFormat.JPEG, 100, baos23);
        byte[] imageInByte23 = baos23.toByteArray();

        Bitmap bitmap24 = ((BitmapDrawable) imageView24.getDrawable()).getBitmap();
        ByteArrayOutputStream baos24 = new ByteArrayOutputStream();
        bitmap24.compress(Bitmap.CompressFormat.JPEG, 100, baos24);
        byte[] imageInByte24 = baos24.toByteArray();


        Bitmap bitmap25 = ((BitmapDrawable) imageView25.getDrawable()).getBitmap();
        ByteArrayOutputStream baos25 = new ByteArrayOutputStream();
        bitmap25.compress(Bitmap.CompressFormat.JPEG, 100, baos25);
        byte[] imageInByte25 = baos25.toByteArray();

        Bitmap bitmap26 = ((BitmapDrawable) imageView26.getDrawable()).getBitmap();
        ByteArrayOutputStream baos26 = new ByteArrayOutputStream();
        bitmap26.compress(Bitmap.CompressFormat.JPEG, 100, baos26);
        byte[] imageInByte26 = baos26.toByteArray();

        Bitmap bitmap27 = ((BitmapDrawable) imageView27.getDrawable()).getBitmap();
        ByteArrayOutputStream baos27 = new ByteArrayOutputStream();
        bitmap27.compress(Bitmap.CompressFormat.JPEG, 100, baos27);
        byte[] imageInByte27 = baos27.toByteArray();

        Bitmap bitmap28 = ((BitmapDrawable) imageView28.getDrawable()).getBitmap();
        ByteArrayOutputStream baos28 = new ByteArrayOutputStream();
        bitmap28.compress(Bitmap.CompressFormat.JPEG, 100, baos28);
        byte[] imageInByte28 = baos28.toByteArray();

        Bitmap bitmap29 = ((BitmapDrawable) imageView29.getDrawable()).getBitmap();
        ByteArrayOutputStream baos29 = new ByteArrayOutputStream();
        bitmap29.compress(Bitmap.CompressFormat.JPEG, 100, baos29);
        byte[] imageInByte29 = baos29.toByteArray();

        Bitmap bitmap30 = ((BitmapDrawable) imageView30.getDrawable()).getBitmap();
        ByteArrayOutputStream baos30 = new ByteArrayOutputStream();
        bitmap30.compress(Bitmap.CompressFormat.JPEG, 100, baos30);
        byte[] imageInByte30 = baos30.toByteArray();

        Bitmap bitmap31 = ((BitmapDrawable) imageView31.getDrawable()).getBitmap();
        ByteArrayOutputStream baos31 = new ByteArrayOutputStream();
        bitmap31.compress(Bitmap.CompressFormat.JPEG, 100, baos31);
        byte[] imageInByte31 = baos31.toByteArray();

        Bitmap bitmap32 = ((BitmapDrawable) imageView32.getDrawable()).getBitmap();
        ByteArrayOutputStream baos32 = new ByteArrayOutputStream();
        bitmap32.compress(Bitmap.CompressFormat.JPEG, 100, baos32);
        byte[] imageInByte32 = baos32.toByteArray();

        Bitmap bitmap33 = ((BitmapDrawable) imageView33.getDrawable()).getBitmap();
        ByteArrayOutputStream baos33 = new ByteArrayOutputStream();
        bitmap33.compress(Bitmap.CompressFormat.JPEG, 100, baos33);
        byte[] imageInByte33 = baos33.toByteArray();

        Bitmap bitmap34 = ((BitmapDrawable) imageView34.getDrawable()).getBitmap();
        ByteArrayOutputStream baos34 = new ByteArrayOutputStream();
        bitmap34.compress(Bitmap.CompressFormat.JPEG, 100, baos34);
        byte[] imageInByte34 = baos34.toByteArray();

        Bitmap bitmap35 = ((BitmapDrawable) imageView35.getDrawable()).getBitmap();
        ByteArrayOutputStream baos35 = new ByteArrayOutputStream();
        bitmap35.compress(Bitmap.CompressFormat.JPEG, 100, baos35);
        byte[] imageInByte35 = baos35.toByteArray();

        Bitmap bitmap36 = ((BitmapDrawable) imageView36.getDrawable()).getBitmap();
        ByteArrayOutputStream baos36 = new ByteArrayOutputStream();
        bitmap36.compress(Bitmap.CompressFormat.JPEG, 100, baos36);
        byte[] imageInByte36 = baos36.toByteArray();




        itemModel.addItem(new ItemInfo("000001","000001","000002","Son Kem Lì Merzy Velvet Tint Season 3",imageInByte1,149000,"Son Kem Lì Merzy Velvet Tint Season 3 sớm nhất Việt Nam, với toàn những tông màu hot trend nhất hiện nay sẵn sàng đốn tim các tình yêu từ cái nhìn đầu tiên",1));
        itemModel.addItem(new ItemInfo("000002","000002","000002","Kem Lót Dưỡng Ẩm Nâng Tông Sixteen Brand 16 Guroom Cream",imageInByte2,159000,"Kem Lót Dưỡng Ẩm Nâng Tông Sixteen Brand 16 Guroom Cream có kết cấu mỏng nhẹ nhưng độ che phủ khá hoàn hảo giúp da bạn sẽ đạt được tông màu ưng ý. Việc dùng kem lót và kem nền khi trang điểm sẽ giúp việc trang điểm của bạn đạt hiệu quả cao hơn và bảo vệ da trước ánh nắng mặt trời cũng như các tác nhân gây hại khác.",2));
        itemModel.addItem(new ItemInfo("000003","000003","000002","Phấn Nước Che Phủ Chống Nắng Missha M Magic Cushion SPF 50+ PA+++",imageInByte3,129000,"Làn da không trắng sáng là lý do khiến bạn thiếu đi sự tự tin khi ra ngoài, do đó rất nhiều chị em lựa chọn giải pháp là sử dụng những loại phấn nước 2 công dụng che phủ khuyết điểm tự nhiên và chống nắng. Phấn nước che phủ chống nắng Missha M Magic Cushion SPF 50+ PA+++ chính là sản phẩm mà nhiều chị em phụ nữ đang tìm kiếm.",3));
        itemModel.addItem(new ItemInfo("000004","000001","000002","Phấn Phủ Che Phủ Lỗ Chân Lông Và Khuyết Điểm Eglips Blur Powder Pact",imageInByte4,145000,"Phấn phủ eglips đáp ứng được các tiêu chí: bền, lâu trôi, có khả năng che phủ lỗ chân lông và kiểm soát dầu tốt, không gây bí bức cho da",4));
        itemModel.addItem(new ItemInfo("000005","000002","000002","Bút Kẻ Sợi Mày Vacosi Realbrow Tattoo Pen",imageInByte5,90000,"Bút Kẻ Sợi Mày Vacosi Realbrow Tattoo Pen được đánh giá cao bằng việc sở hữu thiết kế đặc biệt ở phần đầu bút kẻ, giúp các chị em dễ dàng tạo các nét vẽ chân mày chính xác. Các đường chân mày sẽ trở nên thanh mảnh và tự nhiên hơn.",1));
        itemModel.addItem(new ItemInfo("000006","000003","000002","Bảng Phấn Mắt Nee Cara 9 Color Eyeshadow",imageInByte6,95000,"Dù là trang điểm hằng ngày hay đêm tiệc vẫn tỏa sáng lung linh với bảng phấn mắt Nee Cara 9 Color Eyeshadow - chỉ với một bảng phấn mắt đã bao gồm 3 kết cấu đặc trưng giúp cho bạn gái biến hóa Make Up Look tùy theo sở thích.",2));
        itemModel.addItem(new ItemInfo("000007","000001","000002","Kẻ Mắt Nước Chống Trôi Black Rouge All Day Power Proof Pen Liner",imageInByte7,139000,"Black Rouge đã tung ra bộ sưu tập mùa hè với chủ đề Pool Party mà bạn không thể bỏ lỡ - Kẻ Mắt Black Rouge All day Power Proof Pen Liner với tông màu chủ đạo living coral hot nhất hiện nay, chống trôi suốt ngày dài.",3));
        itemModel.addItem(new ItemInfo("000008","000002","000002","Phấn Nước Che Phủ Hoàn Hảo Chống Nắng Cả Ngày ABlack All Day Perfect Cover Cushion SPF 47 PA++",imageInByte8,345000,"Đối với những cô nàng da có nhiều thâm mụn, nám, tàn nhang, da không đều màu thì có thể sử dụng kem lót – kem che khuyết điểm – phấn nước để có được một làn da hoàn hảo và ở set Phấn Nước Che Phủ Hoàn Hảo Chống Nắng Cả Ngày ABlack All Day Perfect Cover Cushion SPF 47 PA++ này sẽ có đầy đủ cho một bước nền hoàn hảo, bao gồm: cushion, che khuyết điểm và kem lót với thiết kế \"sang xịn mịn\" giữa màu đen và màu vàng gold sẽ mang đến cho bạn sự tiện lợi nhất định khi sử dụng hoặc mang đi bên mình.",4));
        itemModel.addItem(new ItemInfo("000009","000003","000002","Mascara Làm Dày Và Dưỡng Mi Maybelline X Marvel The Colossal Instant Big Volume Mascara Waterproof",imageInByte9,159000,"Mascara Làm Dày Và Dưỡng Mi Maybelline X Marvel The Colossal Instant Big Volume Mascara Waterproof giúp dày mi ấn tượng, ngay lập tức để bạn tự tin và cuốn hút hơn, đặc biệt với phiên bản Marvel sẽ càng đặc biệt và hút mắt hơn nữa.",1));
        itemModel.addItem(new ItemInfo("000010","000001","000002","Phấn Phủ Bột Kiềm Dầu Không Màu Phiên Bản Giới Hạn Innisfree No-Sebum Mineral Powder Mentos",imageInByte10,130000,"Phấn Phủ Bột Kiềm Dầu Không Màu Phiên Bản Giới Hạn Innisfree No-Sebum Mineral Powder Mentos là phiên bản kỷ niệm 14 năm ra mắt sản phẩm No sebum. Lần này, phiên bản phấn phủ được lấy cảm hứng từ những viên kẹo Mentos với đặc trưng tươi mát - sẽ mang lại cảm giác tươi mới như sản phẩm No sebum mang lại trên làn da.",2));
        itemModel.addItem(new ItemInfo("000011","000002","000002","Má Hồng Peripera Pure Blushed Velvet Cheek",imageInByte11,155000,"Peripera Pure Blushed Velvet Cheek là phấn má hồng thuộc bộ sưu tập trang điểm cho mùa Thu Đông 2019 của Peripera. Với chất phấn mềm mịn và bảng màu đa dạng, Peripera Pure Blushed Velvet Cheek sẽ đem lại cho bạn 1 đôi gò má ửng hồng xinh xắn, rạng rỡ trong tiết trời se lạnh cuối năm.",3));
        itemModel.addItem(new ItemInfo("000012","000003","000002","Bảng Mắt Merzy Bite The Beat Shadow Palette Pop In Mood",imageInByte12,449000,"Merzy Bite The Beat Shadow Palette Pop In Mood là một sản phẩm đa dụng khi vừa là phấn mắt - má hồng - tạo khối.",4));

        itemModel.addItem(new ItemInfo("000013","000001","000001","Bộ 3 Dầu Gội, Xả và Sữa Tắm Dove Nhật",imageInByte13,320000,"Bộ 3 sản phẩm Dầu gội, Xả và Sữa tắm Dove là bộ sản phẩm đang được ưa chuộng tại Nhật Bản với hương thơm ngọt ngào đầy quyến rũ.",1));
        itemModel.addItem(new ItemInfo("000014","000002","000001","Tẩy Da Chết Toàn Thân Organic Shop Coffee Sugar Body Scrub",imageInByte14,140000,"Tẩy Da Chết Toàn Thân Organic Shop Coffee Sugar Body Scrub là sản phẩm hữu cơ không chất tẩy, không chất bảo quản và các hóa chất có hại cho da như: parabens, dầu khoáng, thuốc nhuộm tổng hợp, chất tạo mùi.",2));
        itemModel.addItem(new ItemInfo("000015","000003","000001","Kem Ủ Ngăn Gãy Rụng Tóc L'oréal Elseve Fall Resist 3X Deep Reinforcing Mask 200ml",imageInByte15,99000,"Kem Ủ Ngăn Rụng Tóc L'Oreal Elseve Fall Resist 3X 200ml không chỉ giúp bạn có một mái tóc cực kỳ suôn mượt và óng ả, mà còn ngăn ngừa các dấu hiệu rụng tóc, nuôi dưỡng mái tóc chắc khỏe một cách toàn diện.",3));
        itemModel.addItem(new ItemInfo("000016","000001","000001","Dầu Dưỡng Giúp Hồi Phục Tóc Hư Tổn Raip R3 Argan Hair Oil",imageInByte16,109000,"Được chiết xuất từ những thành phần giàu dưỡng chất như dầu Argan, vitamin E, dầu hoa cúc, dầu oliu, dầu hạt hướng dương... Dầu Dưỡng Tóc Raip R3 Argan Hair Oil mang lại hiệu quả chăm sóc tóc vượt trội, cho bạn mái tóc mềm mại, suôn mượt bất ngờ đồng thời ngăn ngừa tình trạng tóc xơ rối, chẻ ngọn và gãy rụng.",4));
        itemModel.addItem(new ItemInfo("000017","000002","000001","Dầu Dưỡng Giúp Suôn Mượt Tóc L'oréal Elseve Extraordinary Oil",imageInByte17,180000,"Dầu Dưỡng Tóc L'oréal Elseve Extraordinary Oil với thành phần chiết xuất từ 6 loại hoa tự nhiên: dầu argan, hoa hồng, hoa sen, hoa hướng dương, hoa cúc và đậu nành, có công dụng rất tốt trong việc phục hồi mái tóc khô xơ, hư tổn và nuôi dưỡng tóc từ sâu bên trong, đem lại cho bạn mái tóc chắc khỏe, mềm mại và bồng bềnh.",1));
        itemModel.addItem(new ItemInfo("000018","000003","000001","Tẩy Da Chết Dạng Bọt Se Khít Lỗ Chân Lông Neogen Pore Tight Peeling Mousse",imageInByte18,260000,"Tẩy da chết dạng bọt se khít lỗ chân lông Neogen Pore Tight Peeling Mousse có chứa quần thể tảo biển với khả năng làm sạch lỗ chân lông, trả lại thông thoáng cho làn da.",2));
        itemModel.addItem(new ItemInfo("000019","000001","000001","Kem Dưỡng Da Ban Đêm Simple Kind To Skin Vital Vitamin Cream ( Mẫu Mới 2020 )",imageInByte19,170000,"Sức khỏe cho làn da sẽ được cải thiện nhanh chóng khi bạn biết cách dưỡng da ban đêm - vì đây là phương pháp nhanh nhất để cứu lấy làn da của bạn nhanh nhất Nếu như những ai là tín đồ của mỹ phẩm Anh Quốc, chắc chắn sẽ không thể bỏ qua bộ sản phẩm kem dưỡng da ngày và đêm của Simple. Trong bài viết này, hãy cùng chúng tôi tìm hiểu rõ hơn về thành phần, công dụng của sản phẩm kem dưỡng ẩm ban đêm Simple Kind to Skin Vital Vitamin (Cream mẫu mới 2020).",3));
        itemModel.addItem(new ItemInfo("000020","000002","000001","Kem Chống Nắng The Saem Eco Earth Power SPF 50+ PA+++",imageInByte20,145000,"Trong tên gọi của sản phẩm The Saem Eco Earth Power Light Sun Cream SPF50+/PA++++ đã thể hiện được lý tưởng mà hãng The Saem hướng đến, sản phẩm giúp bảo vệ 100% dưới tác động của tia cực tím và làm dịu da trước ánh nắng mặt trời.",4));
        itemModel.addItem(new ItemInfo("000021","000003","000001","Tinh Chất Tràm Trà Đỏ Giúp Làm Dịu Cho Da Nhạy Cảm Some By Mi Red Teatree Cicassoside™ Serum",imageInByte21,280000,"Tinh chất tràm trà đỏ giúp làm dịu cho da nhạy cảm Some By Mi Red Teatree Cicassoside™ Serum là một trong những sản phẩm nổi tiếng có chiết xuất từ thiên nhiên, an toàn và lành tính; cung cấp các dưỡng chất cho da. Đặc biệt là giúp làm dịu da nhạy cảm.",1));
        itemModel.addItem(new ItemInfo("000022","000001","000001","Mặt Nạ Mediheal H.D.P",imageInByte22,25000,"Mặt nạ dưỡng da Foodaholic giúp làm trẻ hóa làn da, ngăn ngừa phát sinh nếp nhăn, chống lão hóa, tăng khả năng đàn hồi, xóa mờ tàn nhang, làm mềm mịn da, giúp da trắng hồng tự nhiên ... dùng thường xuyên sẽ giúp bạn tự tin hơn với làn da tươi trẻ, căng mịn và tràn đầy sức sống.",2));
        itemModel.addItem(new ItemInfo("000023","000002","000001","Mặt Nạ Dưỡng Da FoodAHolic Derma Ac Control Mask Vitamin K",imageInByte23,16000,"Mặt nạ dưỡng da Foodaholic giúp làm trẻ hóa làn da, ngăn ngừa phát sinh nếp nhăn, chống lão hóa, tăng khả năng đàn hồi, xóa mờ tàn nhang, làm mềm mịn da, giúp da trắng hồng tự nhiên ... dùng thường xuyên sẽ giúp bạn tự tin hơn với làn da tươi trẻ, căng mịn và tràn đầy sức sống.",3));
        itemModel.addItem(new ItemInfo("000024","000003","000001","Sữa Rửa Mặt Sủi Bọt Khí ''3 in 1'' Ngăn Ngừa Lão Hóa Byvibes Wonder Bath Super Vegitoks Cleanser Purple",imageInByte24,230000,"Sữa Rửa Mặt Sủi Bọt Khí 3 In 1 Wonder Bath Super Vegitoks Cleanser với các bảng thành phần chiết xuất khác nhau nhưng vẫn có chung công dụng chính là sự tích hợp giữa Tẩy Trang - Sữa Rửa Mặt - Thải Độc cho da. Sản phẩm thích hợp cho mọi loại da vì độ lành tính chiết xuất chủ yếu từ rau củ quả tự nhiên.",4));

        itemModel.addItem(new ItemInfo("000025","000001","000003","Dưỡng Trắng Da Toàn Thân Vaseline Healthy White Perfect Serum 10X",imageInByte25,190000,"Dưỡng Thể Trắng Da Vaseline Healthy White Perfect Serum 10X  giúp trắng nhanh gấp 10 lần so với bình thường, trắng hồng mịn màng bởi tác động 3X: SPF 30 bảo vệ da khỏi tia UVB, Vitamin B3 làm dưỡng trắng da và tinh chất serum cô đặc chứa những hạt dưỡng chất dễ dàng thấm sâu tận bên trong da, không gây nhờn dính.",1));
        itemModel.addItem(new ItemInfo("000026","000002","000003","Kem Dưỡng Da Tay Hatomugi Moisturizing & Conditioning The Hand Cream",imageInByte26,90000,"Với thành phần chiết xuất từ hạt ý dĩ giúp cung cấp dưỡng chất và độ ẩm cho da tay, giúp da tay mềm mịn và tươi sáng hơn - Kem Dưỡng Tay Hatomugi The Hand Cream nhất định là một sản phẩm không thể thiếu trong quá trình làm đẹp của chị em phụ nữ.",2));
        itemModel.addItem(new ItemInfo("000027","000003","000003","Xà Phòng Trị Mụn Lưng For Back Medicated Soap",imageInByte27,130000,"Xà Phòng Trị Mụn Lưng For Back Medicated Soap chiết xuất từ than núi lửa giúp làm sạch sâu bụi bẩn, điều trị và ngăn ngừa mụn trứng cá hình thành.",3));
        itemModel.addItem(new ItemInfo("000028","000004","000003","Son Dưỡng Có Màu YNM Candy Honey Lip Balm",imageInByte28,135000,"Son Dưỡng Có Màu YNM Candy Honey Lip Balm được đánh giá là một trong những dòng sản phẩm son dưỡng môi có chiết xuất từ tự nhiên với khả năng hỗ trợ cung cấp dưỡng chất cần thiết cho đôi môi và giúp các chị em sở hữu một đôi môi mềm mịn, căng bóng và sáng khỏe hơn",4));
        itemModel.addItem(new ItemInfo("000029","000001","000003","Kem Trắng Da Và Khử Mùi Vùng Dưới Cánh Tay A'Pieu Deo Armpit Brightener",imageInByte29,130000,"A'Pieu Deo Armpit Brightener là tẩy tế bào chết dạng kem giúp tẩy sạch bã nhờn tích tụ, giảm thâm, dưỡng trắng, khử mùi cho vùng da dưới cánh tay với công thức cực kì an toàn mang lại cảm giác dễ chịu và khô thoáng, giúp nàng thoải mái và tự tin hơn khi diện các trang phục ngắn tay hay hở vai.",1));
        itemModel.addItem(new ItemInfo("000030","000002","000003","Nước Hoa Because It's You Emporio Armani Eau De Parfum 15ml",imageInByte30,580000,"Because It's You Emporio Armani Eau De Parfum đem đến hình ảnh tâm hồn ngọt ngào đắm say của người phụ nữ đang yêu với những nốt hương vani và quả mâm xôi đỏ quấn quanh mùi hương hoa hồng, phút cuối đọng lại những dư vị khó quên từ xạ hương và nhựa hổ phách.",2));
        itemModel.addItem(new ItemInfo("000031","000003","000003","Xịt Khoá Nền 3CE Makeup Fixer Mist",imageInByte31,320000,"Có thể nói, xịt khóa nền là một trong những vật dụng không thể thiếu của các tín đồ làm đẹp. Ngoài việc tạo một lớp nền hoàn hảo cho da thì việc giữ cho lớp nền tươi sáng và bền lâu sẽ giúp các chị em thăng hạng nhan sắc phần nào. Trên thị trường hiện nay đã xuất hiện vô số sản phẩm xịt khóa nền. Tuy nhiên, các chị em sẽ không khỏi băn khoăn rằng sản phẩm nào mới thực sự mang lại hiệu quả cao? Thấu hiểu nỗi băn khoăn đó, thương hiệu 3CE đã cho ra đời dòng sản phẩm Xịt Khoá Nền 3CE Makeup Fixer Mist mang lại những lợi ích hiệu quả cũng như trải nghiệm mới mẻ trong hành trình chăm sóc sắc đẹp của các chị em phụ nữ.",3));
        itemModel.addItem(new ItemInfo("000032","000004","000003","Thuốc Tẩy Tóc Etude House Hot Style Cream Hair Bleach",imageInByte32,189000,"Thuốc Tẩy Tóc Etude House Hair Style Cream Hair Bleach dành cho các nàng tóc đen nhưng lại yêu thích trải nghiệm những tone màu tóc mới lạ. Không cần bạn phải tốn nhiều thời gian đi đến những tiệm salon làm tóc, chỉ cần từ 30-45 phút tại nhà bạn đã có thể tẩy đi màu tóc và sẵn sàng cho bước nhuộm tiếp theo.",4));
        itemModel.addItem(new ItemInfo("000033","000001","000003","Bộ Tẩy Trang Và Sữa Rữa Mặt Làm Sạch Sâu Loại Bỏ Lớp Trang Điểm Chống Trôi Banila Co Clean It Zero Cleansing Balm Gift Set The Starry Night Edition",imageInByte33,550000,"Set tẩy trang BANILACO Clean It Zero Cleaning Balm Gift Set The Starry Night Edition là sản phẩm tẩy trang dạng sáp của hãng Banila thuộc Hàn Quốc - đất nước nổi tiếng với nhiều sản phẩm làm đẹp, chắc chắn sẽ mang lại cho bạn làn da sạch bã nhờn, dầu thừa hay bụi bẩn trên mặt sau một ngày dài bất kể lớp trang điểm có dày đến đâu mà không gây khô da hay nhờn rít sau khi sử dụng.",1));
        itemModel.addItem(new ItemInfo("000034","000002","000003","Tinh Chất Cấp Nước Cho Da Tổn Thương The Ordinary Hyaluronic Acid 2% B5",imageInByte34,280000,"Nổi tiếng với những sản phẩm chăm sóc da có giá bình dân nhưng chất lượng không thua kém bất kì sản phẩm high-end nào, The Ordinary đã và đang chiếm được thiện cảm của chị em phụ nữ. Trong đó, không thể không kể đến tinh chất cấp nước cho da tổn thương The Ordinary Hyaluronic Acid 2% B5 - sản phẩm làm nên tên tuổi của hãng.",2));
        itemModel.addItem(new ItemInfo("000035","000003","000003","Dưỡng Mi Eveline 8 in 1 Total Action Lash Therapy Professional",imageInByte35,140000,"Một hàng mi dày, dài và cong luôn là niềm yêu thích của các chị em giúp đôi mắt quyến rũ và có hồn hơn. Thay vì phải nối mi làm nặng mi và không tự nhiên thì Lam Thảo Cosmetic mang đến cho bạn một giải pháp an toàn và hiệu quả hơn: Huyết thanh dưỡng mi Eveline 8 in 1 Total Action Lash Therapy Professional.",3));
        itemModel.addItem(new ItemInfo("000036","000004","000003","Miếng Dán Trị Mụn Some By Mi Clear Spot Patch (Set 18 miếng)",imageInByte36,59000,"Miếng Dán Trị Mụn Some By Mi Clear Spot Patch là bí quyết giữ gìn làn da khi bị tình trạng mụn, có công dụng kháng viêm giảm sưng và giúp làm lành vết thương do mụn mà không cần phải can thiệp bởi các cách cơ học như nặn mụn.",4));

    }
}
