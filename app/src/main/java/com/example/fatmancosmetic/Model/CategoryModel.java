package com.example.fatmancosmetic.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.fatmancosmetic.DBManager.DBManager;
import com.example.fatmancosmetic.Info.CategoryInfo;

import java.util.ArrayList;

public class CategoryModel extends DBManager {
    ArrayList<CategoryInfo> listCategory;
    //Categories table 3 columns
    private static final String TABLE_CATEGORY_NAME = "Categories";
    private static final String ID = "ID";
    private static final String CATEGORY_ID = "categoryID";
    private static final String CATEGORY_NAME = "categoryName";
private static final String CATEGORY_STATUS = "Status";

    public CategoryModel(@Nullable Context context) {
        super(context);
    }

    public ArrayList<CategoryInfo> getAllCategory(){
        ArrayList<CategoryInfo> listCategory = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CATEGORY_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                CategoryInfo categoryInfo = new CategoryInfo();
                categoryInfo.setID(cursor.getInt(0));
                categoryInfo.setCategoryID(cursor.getString(1));
                categoryInfo.setCategoryName(cursor.getString(2));
                categoryInfo.setStatus(cursor.getInt(3));
                listCategory.add(categoryInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listCategory;
    }
    public void addCategory(CategoryInfo categoryInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CATEGORY_ID, categoryInfo.getCategoryID());
        contentValues.put(CATEGORY_NAME, categoryInfo.getCategoryName());
        contentValues.put(CATEGORY_STATUS, categoryInfo.getStatus());

        db.insert(TABLE_CATEGORY_NAME, null, contentValues);
        db.close();
    }
    public int updateCategory(CategoryInfo categoryInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CATEGORY_ID, categoryInfo.getCategoryID());
        contentValues.put(CATEGORY_NAME, categoryInfo.getCategoryName());
        contentValues.put(CATEGORY_STATUS, categoryInfo.getStatus());
        return db.update(TABLE_CATEGORY_NAME,contentValues,ID +"=?",new String[] { String.valueOf(categoryInfo.getID())});
    }
    public int deleteCategory(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_CATEGORY_NAME,ID+"=?", new String[]{String.valueOf(String.valueOf(id))});
    }
}
