package com.example.appletscount;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class BerhitungActivity extends AppCompatActivity {
    public  static final String EXTRA_SKOR = "extraSkor";
    private static final long COUNTDOWN_IN_MILLIS = 60000;

    private static final String KEY_SKOR = "keySkor";
    private static final String KEY_SOAL_COUNT = "keySoalCount";
    private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
    private static final String KEY_JAWABAN = "keyJawaban";
    private static final String KEY_SOAL_LIST = "keySoalList";

    private TextView textViewSoal;
    private TextView textViewSkor;
    private TextView textViewSoalCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonPilihLanjut;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private ArrayList<Soal> soalList;
    private int soalCounter;
    private int soalCounterTotal;
    private Soal currentSoal;

    private int skor;
    private boolean jawaban;

    private long backPressedTime;

    private SoundPool soundPool;
    private int sound1, sound2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berhitung);

        textViewSoal = findViewById(R.id.text_view_soal);
        textViewSkor = findViewById(R.id.text_view_skor);
        textViewSoalCount = findViewById(R.id.text_view_soal_count);
        textViewCountDown = findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        buttonPilihLanjut = findViewById(R.id.button_pilih_lanjut);

        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        sound1 = soundPool.load(this, R.raw.billiard_balls_single_hit_dry, 1);
        sound2 = soundPool.load(this, R.raw.wooden_ball_against_wooden_window_shade, 1);

        if (savedInstanceState == null) {
            SoalDbHelper dbHelper = new SoalDbHelper(this);
            soalList = dbHelper.getAllSoal();
            soalCounterTotal = soalList.size();
            Collections.shuffle(soalList);

            showNextSoal();
        } else {
            soalList = savedInstanceState.getParcelableArrayList(KEY_SOAL_LIST);
            soalCounterTotal = soalList.size();
            soalCounter = savedInstanceState.getInt(KEY_SOAL_COUNT);
            currentSoal = soalList.get(soalCounter - 1);
            skor = savedInstanceState.getInt(KEY_SKOR);
            timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT);
            jawaban = savedInstanceState.getBoolean(KEY_JAWABAN);

            if (!jawaban) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolusi();
            }
        }

        buttonPilihLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound2, 1, 1, 0, 0, 1);

                if (!jawaban) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        checkJawaban();
                    } else {
                        Toast.makeText(BerhitungActivity.this, "Silakan pilih jawaban kamu", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextSoal();
                }
            }
        });
    }

    public void playRadioButton(View v) {
        switch (v.getId()) {
            case R.id.radio_button1:
                soundPool.play(sound1, 1, 1, 0, 0, 1);
                break;
            case R.id.radio_button2:
                soundPool.play(sound1, 1, 1, 0, 0, 1);
                break;
            case R.id.radio_button3:
                soundPool.play(sound1, 1, 1, 0, 0, 1);
                break;
        }
    }

    public void playPilih(View v) {
        switch (v.getId()) {
            case R.id.button_pilih_lanjut:
                soundPool.play(sound2, 1, 1, 0, 0, 1);
                break;
        }
    }

    private void showNextSoal() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (soalCounter < soalCounterTotal) {
            currentSoal = soalList.get(soalCounter);

            textViewSoal.setText(currentSoal.getSoal());
            rb1.setText(currentSoal.getPilihan1());
            rb2.setText(currentSoal.getPilihan2());
            rb3.setText(currentSoal.getPilihan3());

            soalCounter++;
            textViewSoalCount.setText("Soal: " + soalCounter +  "/" + soalCounterTotal);
            jawaban = false;
            buttonPilihLanjut.setText("Pilih");

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else {
            finishKuis();
        }
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkJawaban();
            }
        }.start();
    }

    private void updateCountDownText() {
        int menit = (int) (timeLeftInMillis / 1000) / 60;
        int detik = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", menit, detik);

        textViewCountDown.setText(timeFormatted);

        if (timeLeftInMillis < 1000) {
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }

    private void checkJawaban() {
        jawaban = true;

        countDownTimer.cancel();

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int jawabanNr = rbGroup.indexOfChild(rbSelected) + 1;

        if (jawabanNr == currentSoal.getJawabanNr()) {
            skor++;
            textViewSkor.setText("Skor: " + skor);
        }

        showSolusi();
    }

    private void showSolusi() {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);

        switch (currentSoal.getJawabanNr()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
        }

        if (soalCounter < soalCounterTotal) {
            buttonPilihLanjut.setText("Lanjut");
        } else {
            buttonPilihLanjut.setText("Selesai");
        }
    }

    private void finishKuis() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SKOR, skor);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishKuis();
        } else {
            Toast.makeText(this, "Tekan kembali untuk Selesai", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SKOR, skor);
        outState.putInt(KEY_SOAL_COUNT, soalCounter);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(KEY_JAWABAN, jawaban);
        outState.putParcelableArrayList(KEY_SOAL_LIST, soalList);
    }
}