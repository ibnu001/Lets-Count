package com.example.appletscount;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appletscount.SoalContract.*;

import java.util.ArrayList;

public class SoalDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAMA = "LetsCountDB.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public SoalDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAMA, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_SOAL_TABLE = "CREATE TABLE " +
                SoalTable.TABLE_NAMA + " ( " +
                SoalTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SoalTable.COLUMN_SOAL + " TEXT, " +
                SoalTable.COLUMN_PILIHAN1 + " TEXT, " +
                SoalTable.COLUMN_PILIHAN2 + " TEXT, " +
                SoalTable.COLUMN_PILIHAN3 + " TEXT, " +
                SoalTable.COLUMN_JAWABAN_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_SOAL_TABLE);
        fillSoalTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SoalTable.TABLE_NAMA);
        onCreate(db);
    }

    private void fillSoalTable() {
        Soal s1 = new Soal("2 + 3 = ...", "5", "4", "6", 1);
        addSoal(s1);
        Soal s2 = new Soal("8 - 5 = ...", "4", "2", "3", 3);
        addSoal(s2);
        Soal s3 = new Soal("5 + 2 = ...", "6", "7", "8", 2);
        addSoal(s3);
        Soal s4 = new Soal("9 - 3 = ...", "6", "4", "3", 1);
        addSoal(s4);
        Soal s5 = new Soal("6 + 3 = ...", "7", "8", "9", 3);
        addSoal(s5);
        Soal s6 = new Soal("8 - 4 = ...", "3", "4", "5", 2);
        addSoal(s6);
        Soal s7 = new Soal("2 + 7 = ...", "9", "6", "8", 1);
        addSoal(s7);
        Soal s8 = new Soal("6 - 1 = ...", "4", "3", "5", 3);
        addSoal(s8);
        Soal s9 = new Soal("3 + 4 = ...", "5", "7", "6", 2);
        addSoal(s9);
        Soal s10 = new Soal("7 - 3 = ...", "4", "3", "5", 1);
        addSoal(s10);
        Soal s11 = new Soal("SATU", "4", "2", "1", 3);
        addSoal(s11);
        Soal s12 = new Soal("EMPAT", "3", "4", "5", 2);
        addSoal(s12);
        Soal s13 = new Soal("SEMBILAN", "9", "6", "8", 1);
        addSoal(s13);
        Soal s14 = new Soal("DUA BELAS", "10", "12", "11", 2);
        addSoal(s14);
        Soal s15 = new Soal("DELAPAN BELAS", "16", "17", "18", 3);
        addSoal(s15);
    }

    private void addSoal(Soal soal) {
        ContentValues cv = new ContentValues();
        cv.put(SoalTable.COLUMN_SOAL, soal.getSoal());
        cv.put(SoalTable.COLUMN_PILIHAN1, soal.getPilihan1());
        cv.put(SoalTable.COLUMN_PILIHAN2, soal.getPilihan2());
        cv.put(SoalTable.COLUMN_PILIHAN3, soal.getPilihan3());
        cv.put(SoalTable.COLUMN_JAWABAN_NR, soal.getJawabanNr());
        db.insert(SoalTable.TABLE_NAMA, null, cv);
    }

    public ArrayList<Soal> getAllSoal() {
        ArrayList<Soal> soalList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + SoalTable.TABLE_NAMA, null);

        if (c.moveToFirst()) {
            do {
                Soal soal = new Soal();
                soal.setSoal(c.getString(c.getColumnIndex(SoalTable.COLUMN_SOAL)));
                soal.setPilihan1(c.getString(c.getColumnIndex(SoalTable.COLUMN_PILIHAN1)));
                soal.setPilihan2(c.getString(c.getColumnIndex(SoalTable.COLUMN_PILIHAN2)));
                soal.setPilihan3(c.getString(c.getColumnIndex(SoalTable.COLUMN_PILIHAN3)));
                soal.setJawabanNr(c.getInt(c.getColumnIndex(SoalTable.COLUMN_JAWABAN_NR)));
                soalList.add(soal);
            } while (c.moveToNext());
        }

        c.close();
        return soalList;
    }
}
