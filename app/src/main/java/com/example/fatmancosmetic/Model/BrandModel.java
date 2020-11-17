package com.example.fatmancosmetic.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.fatmancosmetic.DBManager.DBManager;
import com.example.fatmancosmetic.Info.BrandInfo;

import java.util.ArrayList;

public class BrandModel extends DBManager {
    private static final String TABLE_BRAND_NAME = "Brands";
    private static final String ID = "ID";
    private static final String BRAND_ID = "brandID";
    private static final String BRAND_NAME = "brandName";
    private static final String BRAND_STATUS = "Status";

    public BrandModel(@Nullable Context context) {
        super(context);
    }

    public ArrayList<BrandInfo> getAllBrand() {

        ArrayList<BrandInfo> listBrand = new ArrayList<>();
        try {
            // Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_BRAND_NAME;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    BrandInfo brandInfo = new BrandInfo();
                    brandInfo.setID(cursor.getInt(0));
                    brandInfo.setBrandID(cursor.getString(1));
                    brandInfo.setBrandName(cursor.getString(2));
                    brandInfo.setStatus(cursor.getInt(3));
                    listBrand.add(brandInfo);
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
        return listBrand;
    }

    public void addBrand(BrandInfo brandInfo) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(BRAND_ID, brandInfo.getBrandID());
            contentValues.put(BRAND_NAME, brandInfo.getBrandName());
            contentValues.put(BRAND_STATUS, brandInfo.getStatus());

            db.insert(TABLE_BRAND_NAME, null, contentValues);
            db.close();
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
    }

    public int updateBrand(BrandInfo brandInfo) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put(BRAND_ID, brandInfo.getBrandID());
            contentValues.put(BRAND_NAME, brandInfo.getBrandName());
            contentValues.put(BRAND_STATUS, brandInfo.getStatus());
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
        return db.update(TABLE_BRAND_NAME, contentValues, ID + "=?", new String[]{String.valueOf(brandInfo.getID())});
    }

    public int deleteBrand(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_BRAND_NAME, ID + "=?", new String[]{String.valueOf(String.valueOf(id))});
    }
}
