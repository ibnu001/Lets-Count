package com.example.appletscount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TentangActivity extends AppCompatActivity {

    private Button buttonKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        buttonKembali = findViewById(R.id.button_kembali);

        final MediaPlayer playBubbleBlip = MediaPlayer.create(this, R.raw.bubble_blip);

        // button kembali
        buttonKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentButtonKembali();
                playBubbleBlip.start();
            }
        });
    }

    // intent button kembali
    private void intentButtonKembali() {
        Intent intent = new Intent(TentangActivity.this, MainActivity.class);
        startActivity(intent);
    }
}