package com.example.appletscount;

import android.provider.BaseColumns;

public class SoalContract {

    private SoalContract() {}

    public static class SoalTable implements BaseColumns {
        public static final String TABLE_NAMA = "kuis_soal";
        public static final String COLUMN_SOAL = "soal";
        public static final String COLUMN_PILIHAN1 = "pilihan1";
        public static final String COLUMN_PILIHAN2 = "pilihan2";
        public static final String COLUMN_PILIHAN3 = "pilihan3";
        public static final String COLUMN_JAWABAN_NR = "jawaban_nr";
    }
}
