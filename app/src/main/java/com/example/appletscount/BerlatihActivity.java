package com.example.appletscount;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BerlatihActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_KUIS = 1;

    public static final String SHARED_PREFS = "SharedPrefs";
    public static final String KEY_HIGHSCORE = "KeyHighscore";

    private TextView textViewHighscore;

    private int highscore;

    private Button buttonMulaiKuis;
    private Button buttonKembali;

    private SoundPool soundPool;
    private int sound1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berlatih);

        buttonKembali = findViewById(R.id.button_kembali);
        buttonMulaiKuis = findViewById(R.id.button_mulai_berhitung);
        textViewHighscore = findViewById(R.id.text_view_highscore);
        loadHighscore();

        final MediaPlayer playBubbleBlip = MediaPlayer.create(this, R.raw.bubble_blip);

        // button kembali
        buttonKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentButtonKembali();
                playBubbleBlip.start();
            }
        });

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        sound1 = soundPool.load(this, R.raw.bubble_blip, 1);

        buttonMulaiKuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mulaiKuiz();
                soundPool.play(sound1, 1,1,0,0,1);
            }
        });
    }

    private void mulaiKuiz() {
        Intent intent = new Intent(BerlatihActivity.this, BerhitungActivity.class);
        startActivityForResult(intent, REQUEST_CODE_KUIS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_KUIS) {
            if (resultCode == RESULT_OK) {
                int skor = data.getIntExtra(BerhitungActivity.EXTRA_SKOR, 0);
                if (skor > highscore) {
                    updateHighscore(skor);
                }
            }
        }
    }

    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Highscore: " + highscore);
    }

    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("Highscore: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }

    // intent button kembali
    private void intentButtonKembali() {
        Intent intent = new Intent(BerlatihActivity.this, MainActivity.class);
        startActivity(intent);
    }
}