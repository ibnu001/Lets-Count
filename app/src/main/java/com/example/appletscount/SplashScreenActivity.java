package com.example.appletscount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    private Animation topAnim;
    private Animation bottomAnim;
    private Animation rightAnim;
    private Animation leftAnim;

    private ImageView icon;
    private ImageView kucing;
    private ImageView bebek;
    private ImageView ayam;
    private ImageView angka1;
    private ImageView angka2;
    private ImageView angka3;

    private TextView textViewSplashScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        rightAnim = AnimationUtils.loadAnimation(this, R.anim.right_animation);
        leftAnim = AnimationUtils.loadAnimation(this, R.anim.left_animation);

        icon = findViewById(R.id.icon_lets_count_splash_screen);
        textViewSplashScreen = findViewById(R.id.text_view_splash_screen);
        kucing = findViewById(R.id.image_view_kucing);
        ayam = findViewById(R.id.image_view_ayam);
        bebek = findViewById(R.id.image_view_bebek);
        angka1 = findViewById(R.id.image_view_angka_1);
        angka2 = findViewById(R.id.image_view_angka_2);
        angka3 = findViewById(R.id.image_view_angka_3);


        icon.setAnimation(bottomAnim);
        textViewSplashScreen.setAnimation(topAnim);
        kucing.setAnimation(topAnim);
        ayam.setAnimation(rightAnim);
        bebek.setAnimation(leftAnim);
        angka1.setAnimation(leftAnim);
        angka2.setAnimation(topAnim);
        angka3.setAnimation(rightAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2200);
    }
}