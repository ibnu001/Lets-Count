package com.example.appletscount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button angka;
    private Button penjumlahan;
    private Button pengurangan;
    private Button berlatih;
    private Button tentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angka = findViewById(R.id.button_tab_angka);
        penjumlahan = findViewById(R.id.button_tab_penjumlahan);
        pengurangan = findViewById(R.id.button_tab_pengurangan);
        berlatih = findViewById(R.id.tabBerlatih);
        tentang = findViewById(R.id.tabTentang);

        final MediaPlayer playBubbleBlip = MediaPlayer.create(this, R.raw.bubble_blip);

        // button tab angka
        angka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAngkaActivity();
                playBubbleBlip.start();
            }
        });

        // button tab penjumlahan
        penjumlahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPenjumlahanActivity();
                playBubbleBlip.start();
            }
        });

        // button tab pengurangan
        pengurangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPenguranganActivity();
                playBubbleBlip.start();
            }
        });

        // button tab berlatih
        berlatih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScreenSoalActivity();
                playBubbleBlip.start();
            }
        });

        // button tab tentang
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTentangActivity();
                playBubbleBlip.start();
            }
        });

    }

    // intent tab angka
    private void startAngkaActivity() {
        Intent intent = new Intent(MainActivity.this, AngkaActivity.class);
        startActivity(intent);
    }

    // intent tab penjumlahan
    private void startPenjumlahanActivity() {
        Intent intent = new Intent(MainActivity.this, PenjumlahanActivity.class);
        startActivity(intent);
    }

    // intent tab pengurangan
    private void startPenguranganActivity() {
        Intent intent = new Intent(MainActivity.this, PenguranganActivity.class);
        startActivity(intent);
    }

    // intent tab berlatih
    private void startScreenSoalActivity() {
        Intent intent = new Intent(MainActivity.this, BerlatihActivity.class);
        startActivity(intent);
    }

    // intent tab tentang
    private void startTentangActivity() {
        Intent intent = new Intent(MainActivity.this, TentangActivity.class);
        startActivity(intent);
    }
}