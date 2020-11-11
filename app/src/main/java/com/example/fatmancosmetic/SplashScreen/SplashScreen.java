package com.example.fatmancosmetic.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fatmancosmetic.Controller.MainActivity;
import com.example.fatmancosmetic.R;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 2000;
    //Variable
    Animation topAnimation, bottomAnimation;
    ImageView imageView;
    TextView logo, slogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //Animation
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.splashscreen_top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.splashscreen_bottom_animation);
        imageView = findViewById(R.id.imageViewLogo);
        //logo = findViewById(R.id.txtViewBigBug);
        slogan = findViewById(R.id.textViewSlogan);

        imageView.setAnimation(topAnimation);
        //logo.setAnimation(bottomAnimation);
        slogan.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}