package com.example.appletscount;

import android.content.Intent;
import android.media.AudioManager;
import android.media.Image;
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

public class PenguranganActivity extends AppCompatActivity {

    private ImageView gb_kurang1, gb_kurang2, gb_kurang3, gb_kurang4, gb_kurang5, gb_kurang6, gb_kurang7, gb_kurang8;

    private SoundPool soundPool;
    private int kurang1_sp, kurang2_sp, kurang3_sp, kurang4_sp, kurang5_sp, kurang6_sp, kurang7_sp, kurang8_sp;

    private Button buttonKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengurangan);

        VideoView videoView_pengurangan = findViewById(R.id.video_view_pengurangan);
        String videoPath_pengurangan = "android.resource://" + getPackageName() + "/" + R.raw.video_pengurangan;
        Uri uri_pengurangan = Uri.parse(videoPath_pengurangan);
        videoView_pengurangan.setVideoURI(uri_pengurangan);

        MediaController mediaController_pengurangan = new MediaController(this);
        videoView_pengurangan.setMediaController(mediaController_pengurangan);
        mediaController_pengurangan.setAnchorView(videoView_pengurangan);

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

        gb_kurang1 = findViewById(R.id.image_view_ayam_krg_1);
        gb_kurang2 = findViewById(R.id.image_view_bebek_krg_2);
        gb_kurang3 = findViewById(R.id.image_view_ayam_krg_3);
        gb_kurang4 = findViewById(R.id.image_view_bebek_krg_4);
        gb_kurang5 = findViewById(R.id.image_view_kucing_krg_5);
        gb_kurang6 = findViewById(R.id.image_view_kelinci_krg_6);
        gb_kurang7 = findViewById(R.id.image_view_kucing_krg_7);
        gb_kurang8 = findViewById(R.id.image_view_kelinci_krg_8);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        // SoundPool pengurangan
        kurang1_sp = soundPool.load(this, R.raw.dua_krg_satu_sp,1);
        kurang2_sp = soundPool.load(this, R.raw.tiga_krg_satu_sp,1);
        kurang3_sp = soundPool.load(this, R.raw.empat_krg_satu_sp,1);
        kurang4_sp = soundPool.load(this, R.raw.lima_krg_satu_sp,1);
        kurang5_sp = soundPool.load(this, R.raw.enam_krg_satu_sp,1);
        kurang6_sp = soundPool.load(this, R.raw.tujuh_krg_satu_sp,1);
        kurang7_sp = soundPool.load(this, R.raw.delapan_krg_satu_sp,1);
        kurang8_sp = soundPool.load(this, R.raw.sembilan_krg_satu_sp,1);
    }

    public void playKurang(View v) {
        switch (v.getId()) {
            case R.id.kurang1:
                soundPool.play(kurang1_sp, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_kurang1);
                break;
            case R.id.kurang2:
                soundPool.play(kurang2_sp, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_kurang2);
                break;
            case R.id.kurang3:
                soundPool.play(kurang3_sp, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_kurang3);
                break;
            case R.id.kurang4:
                soundPool.play(kurang4_sp, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_kurang4);
                break;
            case R.id.kurang5:
                soundPool.play(kurang5_sp, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_kurang5);
                break;
            case R.id.kurang6:
                soundPool.play(kurang6_sp, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_kurang6);
                break;
            case R.id.kurang7:
                soundPool.play(kurang7_sp, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_kurang7);
                break;
            case R.id.kurang8:
                soundPool.play(kurang8_sp, 1, 1, 0, 0, 1);
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(gb_kurang8);
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
        Intent intent = new Intent(PenguranganActivity.this, MainActivity.class);
        startActivity(intent);
    }
}