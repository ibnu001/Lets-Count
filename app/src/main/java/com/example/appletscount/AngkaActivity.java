package com.example.appletscount;

import androidx.appcompat.app.AppCompatActivity;

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

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class AngkaActivity extends AppCompatActivity {

    private ImageView gambar1, gambar2, gambar3, gambar4, gambar5, gambar6, gambar7, gambar8, gambar9, gambar10,
            gambar11, gambar12, gambar13, gambar14, gambar15, gambar16, gambar17, gambar18, gambar19, gambar20;

    private SoundPool soundPool;
    private int angka1, angka2, angka3,  angka4, angka5, angka6, angka7, angka8, angka9, angka10,
            angka11, angka12, angka13, angka14, angka15, angka16, angka17, angka18, angka19, angka20;

    private Button buttonKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angka);

        VideoView videoView_angka = findViewById(R.id.video_view_angka);
        String videoPath_angka = "android.resource://" + getPackageName() + "/" + R.raw.video_mengenal_angka;
        Uri uri_angka = Uri.parse(videoPath_angka);
        videoView_angka.setVideoURI(uri_angka);

        MediaController mediaController_angka = new MediaController(this);
        videoView_angka.setMediaController(mediaController_angka);
        mediaController_angka.setAnchorView(videoView_angka);

        gambar1 = findViewById(R.id.image_view_gambar_1);
        gambar2 = findViewById(R.id.image_view_gambar_2);
        gambar3 = findViewById(R.id.image_view_gambar_3);
        gambar4 = findViewById(R.id.image_view_gambar_4);
        gambar5 = findViewById(R.id.image_view_gambar_5);
        gambar6 = findViewById(R.id.image_view_gambar_6);
        gambar7 = findViewById(R.id.image_view_gambar_7);
        gambar8 = findViewById(R.id.image_view_gambar_8);
        gambar9 = findViewById(R.id.image_view_gambar_9);
        gambar10 = findViewById(R.id.image_view_gambar_10);
        gambar11 = findViewById(R.id.image_view_gambar_11);
        gambar12 = findViewById(R.id.image_view_gambar_12);
        gambar13 = findViewById(R.id.image_view_gambar_13);
        gambar14 = findViewById(R.id.image_view_gambar_14);
        gambar15 = findViewById(R.id.image_view_gambar_15);
        gambar16 = findViewById(R.id.image_view_gambar_16);
        gambar17 = findViewById(R.id.image_view_gambar_17);
        gambar18 = findViewById(R.id.image_view_gambar_18);
        gambar19 = findViewById(R.id.image_view_gambar_19);
        gambar20 = findViewById(R.id.image_view_gambar_20);

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

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        // SoundPool angka 1 s/d 20
        angka1 = soundPool.load(this, R.raw.satu_sp, 1);
        angka2 = soundPool.load(this, R.raw.dua_sp, 1);
        angka3 = soundPool.load(this, R.raw.tiga_sp, 1);
        angka4 = soundPool.load(this, R.raw.empat_sp, 1);
        angka5 = soundPool.load(this, R.raw.lima_sp, 1);
        angka6 = soundPool.load(this, R.raw.enam_sp, 1);
        angka7 = soundPool.load(this, R.raw.tujuh_sp, 1);
        angka8 = soundPool.load(this, R.raw.delapan_sp, 1);
        angka9 = soundPool.load(this, R.raw.sembilan_sp, 1);
        angka10 = soundPool.load(this, R.raw.sepuluh_sp, 1);
        angka11 = soundPool.load(this, R.raw.sebelas_sp, 1);
        angka12 = soundPool.load(this, R.raw.duabelas_sp, 1);
        angka13 = soundPool.load(this, R.raw.tigabelas_sp, 1);
        angka14 = soundPool.load(this, R.raw.empatbelas_sp, 1);
        angka15 = soundPool.load(this, R.raw.limabelas_sp, 1);
        angka16 = soundPool.load(this, R.raw.enambelas_sp, 1);
        angka17 = soundPool.load(this, R.raw.tujuhbelas_sp, 1);
        angka18 = soundPool.load(this, R.raw.delapanbelas_sp, 1);
        angka19 = soundPool.load(this, R.raw.sembilanbelas_sp, 1);
        angka20 = soundPool.load(this, R.raw.duapuluh_sp, 1);
    }

    public void playAngka(View v) {
        switch (v.getId()) {
            case R.id.nomor1:
                soundPool.play(angka1, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar1);
                break;
            case R.id.nomor2:
                soundPool.play(angka2, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar2);
                break;
            case R.id.nomor3:
                soundPool.play(angka3, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar3);
                break;
            case R.id.nomor4:
                soundPool.play(angka4, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar4);
                break;
            case R.id.nomor5:
                soundPool.play(angka5, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar5);
                break;
            case R.id.nomor6:
                soundPool.play(angka6, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar6);
                break;
            case R.id.nomor7:
                soundPool.play(angka7, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar7);
                break;
            case R.id.nomor8:
                soundPool.play(angka8, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar8);
                break;
            case R.id.nomor9:
                soundPool.play(angka9, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar9);
                break;
            case R.id.nomor10:
                soundPool.play(angka10, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar10);
                break;
            case R.id.nomor11:
                soundPool.play(angka11, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar11);
                break;
            case R.id.nomor12:
                soundPool.play(angka12, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar12);
                break;
            case R.id.nomor13:
                soundPool.play(angka13, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar13);
                break;
            case R.id.nomor14:
                soundPool.play(angka14, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar14);
                break;
            case R.id.nomor15:
                soundPool.play(angka15, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar15);
                break;
            case R.id.nomor16:
                soundPool.play(angka16, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar16);
                break;
            case R.id.nomor17:
                soundPool.play(angka17, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar17);
                break;
            case R.id.nomor18:
                soundPool.play(angka18, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar18);
                break;
            case R.id.nomor19:
                soundPool.play(angka19, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar19);
                break;
            case R.id.nomor20:
                soundPool.play(angka20, 1,1,0,0,1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gambar20);
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
        Intent intent = new Intent(AngkaActivity.this, MainActivity.class);
        startActivity(intent);
    }
}