package com.example.appletscount;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class PenjumlahanActivity extends AppCompatActivity {

    private ImageView gb_jumlah1, gb_jumlah2, gb_jumlah3, gb_jumlah4, gb_jumlah5, gb_jumlah6, gb_jumlah7, gb_jumlah8;

    private SoundPool soundPool;
    private int jumlah1, jumlah2, jumlah3, jumlah4, jumlah5, jumlah6, jumlah7, jumlah8;

    private Button buttonKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjumlahan);

        VideoView videoView_penjumlahan = findViewById(R.id.video_view_penjumlahan);
        String videoPath_penjumlahan = "android.resource://" + getPackageName() + "/" + R.raw.video_penjumlahan;
        Uri uri_penjumlahan = Uri.parse(videoPath_penjumlahan);
        videoView_penjumlahan.setVideoURI(uri_penjumlahan);

        MediaController mediaController_penjumlahan = new MediaController(this);
        videoView_penjumlahan.setMediaController(mediaController_penjumlahan);
        mediaController_penjumlahan.setAnchorView(videoView_penjumlahan);

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

        gb_jumlah1 = findViewById(R.id.image_view_semangka_tbh_1);
        gb_jumlah2 = findViewById(R.id.image_view_semangka_tbh_2);
        gb_jumlah3 = findViewById(R.id.image_view_semangka_tbh_3);
        gb_jumlah4 = findViewById(R.id.image_view_semangka_tbh_4);
        gb_jumlah5 = findViewById(R.id.image_view_es_krim_tbh_5);
        gb_jumlah6 = findViewById(R.id.image_view_es_krim_tbh_6);
        gb_jumlah7 = findViewById(R.id.image_view_es_krim_tbh_7);
        gb_jumlah8 = findViewById(R.id.image_view_es_krim_tbh_8);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        // SoundPool penjumlahan
        jumlah1 = soundPool.load(this, R.raw.satu_tbh_satu_sp,1);
        jumlah2 = soundPool.load(this, R.raw.satu_tbh_dua_sp,1);
        jumlah3 = soundPool.load(this, R.raw.satu_tbh_tiga_sp,1);
        jumlah4 = soundPool.load(this, R.raw.satu_tbh_empat_sp,1);
        jumlah5 = soundPool.load(this, R.raw.satu_tbh_lima_sp,1);
        jumlah6 = soundPool.load(this, R.raw.satu_tbh_enam_sp,1);
        jumlah7 = soundPool.load(this, R.raw.satu_tbh_tujuh_sp,1);
        jumlah8 = soundPool.load(this, R.raw.satu_tbh_delapan_sp,1);
    }

    public void playJumlah(View v) {
        switch (v.getId()) {
            case R.id.tambah2:
                soundPool.play(jumlah1, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_jumlah1);
                break;
            case R.id.tambah3:
                soundPool.play(jumlah2, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_jumlah2);
                break;
            case R.id.tambah4:
                soundPool.play(jumlah3, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_jumlah3);
                break;
            case R.id.tambah5:
                soundPool.play(jumlah4, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_jumlah4);
                break;
            case R.id.tambah6:
                soundPool.play(jumlah5, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_jumlah5);
                break;
            case R.id.tambah7:
                soundPool.play(jumlah6, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_jumlah6);
                break;
            case R.id.tambah8:
                soundPool.play(jumlah7, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_jumlah7);
                break;
            case R.id.tambah9:
                soundPool.play(jumlah8, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_jumlah8);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }

    // intent button kembali
    private void intentButtonKembali() {
        Intent intent = new Intent(PenjumlahanActivity.this, MainActivity.class);
        startActivity(intent);
    }
}