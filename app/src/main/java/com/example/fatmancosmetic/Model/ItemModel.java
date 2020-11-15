package com.example.fatmancosmetic.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.fatmancosmetic.DBManager.DBManager;
import com.example.fatmancosmetic.Info.BrandInfo;
import com.example.fatmancosmetic.Info.ItemInfo;

import java.util.ArrayList;

public class ItemModel extends DBManager {
    //Items table 8 columns
    private static final String TABLE_ORDER_NAME = "Orders";
    private static final String TABLE_ORDERDETAILS_NAME = "OrderDetails";
    private static final String TABLE_ITEM_NAME = "Items";
    private static final String ID = "ID";
    private static final String ITEM_ID = "itemID";
    private static final String ITEM_BRAND_ID = "brandID";
    private static final String ITEM_CATEGORY_ID = "categoryID";
    private static final String ITEM_NAME = "Name";
    private static final String ITEM_IMAGE = "Image";
    private static final String ITEM_PRICE = "Price";
    private static final String ITEM_DESCRIPTION = "Description";
    private static final String ITEM_STATUS = "Status";

    public ItemModel(@Nullable Context context) {
        super(context);
    }

    public ArrayList<ItemInfo> getAllItems(){
        ArrayList<ItemInfo> listItems = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemInfo itemInfo = new ItemInfo();
                itemInfo.setID(cursor.getInt(0));
                itemInfo.setItemID(cursor.getString(1));
                itemInfo.setBrandID(cursor.getString(2));
                itemInfo.setCategoryID(cursor.getString(3));
                itemInfo.setName(cursor.getString(4));
                itemInfo.setImage(cursor.getBlob(5));
                itemInfo.setPrice(cursor.getInt(6));
                itemInfo.setDescription(cursor.getString(7));
                itemInfo.setStatus(cursor.getInt(8));
                listItems.add(itemInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listItems;
    }

    public ArrayList<ItemInfo> getItemsByCustomerID(String customerID){
        ArrayList<ItemInfo> listItems = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT Items.itemID FROM Items, Orders, OrderDetails WHERE Orders.Status = 1 AND Orders.customerID = '"+customerID+"' AND Orders.orderID = OrderDetails.orderID AND OrderDetails.itemID = Items.itemID";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ArrayList<ItemInfo> listItemsTemple = new ArrayList<>();
                String itemID = cursor.getString(0);
                listItemsTemple = getItemsByItemID(itemID);



                ItemInfo itemInfo = new ItemInfo();
                itemInfo = listItemsTemple.get(0);

//                itemInfo.setID(listItemsTemple.get(0).getID());
//                itemInfo.setItemID(listItemsTemple.get(0).getItemID());
//                itemInfo.setBrandID(listItemsTemple.get(0).getBrandID());
//                itemInfo.setCategoryID(listItemsTemple.get(0).getCategoryID());
//                itemInfo.setName(listItemsTemple.get(0).getName());
//                itemInfo.setImage(listItemsTemple.get(0).getImage());
//                itemInfo.setPrice(listItemsTemple.get(0).getPrice());
//                itemInfo.setDescription(listItemsTemple.get(0).getDescription());
//                itemInfo.setStatus(listItemsTemple.get(0).getStatus());


                listItems.add(itemInfo);


            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listItems;
    }

    public ArrayList<ItemInfo> getItemsByItemID(String itemID){
        ArrayList<ItemInfo> listItems = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM_NAME + " WHERE itemID = '" + itemID + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemInfo itemInfo = new ItemInfo();
                itemInfo.setID(cursor.getInt(0));
                itemInfo.setItemID(cursor.getString(1));
                itemInfo.setBrandID(cursor.getString(2));
                itemInfo.setCategoryID(cursor.getString(3));
                itemInfo.setName(cursor.getString(4));
                itemInfo.setImage(cursor.getBlob(5));
                itemInfo.setPrice(cursor.getInt(6));
                itemInfo.setDescription(cursor.getString(7));
                itemInfo.setStatus(cursor.getInt(8));
                listItems.add(itemInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listItems;
    }

    public ArrayList<ItemInfo> getBodyCareItems(){
        ArrayList<ItemInfo> listItems = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM_NAME + " WHERE categoryID = '000001'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemInfo itemInfo = new ItemInfo();
                itemInfo.setID(cursor.getInt(0));
                itemInfo.setItemID(cursor.getString(1));
                itemInfo.setBrandID(cursor.getString(2));
                itemInfo.setCategoryID(cursor.getString(3));
                itemInfo.setName(cursor.getString(4));
                itemInfo.setImage(cursor.getBlob(5));
                itemInfo.setPrice(cursor.getInt(6));
                itemInfo.setDescription(cursor.getString(7));
                itemInfo.setStatus(cursor.getInt(8));
                listItems.add(itemInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listItems;
    }
    public ArrayList<ItemInfo> getSkinCareItems(){
        ArrayList<ItemInfo> listItems = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM_NAME + " WHERE categoryID = '000003'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemInfo itemInfo = new ItemInfo();
                itemInfo.setID(cursor.getInt(0));
                itemInfo.setItemID(cursor.getString(1));
                itemInfo.setBrandID(cursor.getString(2));
                itemInfo.setCategoryID(cursor.getString(3));
                itemInfo.setName(cursor.getString(4));
                itemInfo.setImage(cursor.getBlob(5));
                itemInfo.setPrice(cursor.getInt(6));
                itemInfo.setDescription(cursor.getString(7));
                itemInfo.setStatus(cursor.getInt(8));
                listItems.add(itemInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listItems;
    }

    public ArrayList<ItemInfo> getMakeUpItems(){
        ArrayList<ItemInfo> listItems = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM_NAME + " WHERE categoryID = '000002'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemInfo itemInfo = new ItemInfo();
                itemInfo.setID(cursor.getInt(0));
                itemInfo.setItemID(cursor.getString(1));
                itemInfo.setBrandID(cursor.getString(2));
                itemInfo.setCategoryID(cursor.getString(3));
                itemInfo.setName(cursor.getString(4));
                itemInfo.setImage(cursor.getBlob(5));
                itemInfo.setPrice(cursor.getInt(6));
                itemInfo.setDescription(cursor.getString(7));
                itemInfo.setStatus(cursor.getInt(8));
                listItems.add(itemInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listItems;
    }

    public ArrayList<ItemInfo> get4SaleItems(){
        ArrayList<ItemInfo> listItems = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM_NAME + " WHERE Status = 2 LIMIT 4";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemInfo itemInfo = new ItemInfo();
                itemInfo.setID(cursor.getInt(0));
                itemInfo.setItemID(cursor.getString(1));
                itemInfo.setBrandID(cursor.getString(2));
                itemInfo.setCategoryID(cursor.getString(3));
                itemInfo.setName(cursor.getString(4));
                itemInfo.setImage(cursor.getBlob(5));
                itemInfo.setPrice(cursor.getInt(6));
                itemInfo.setDescription(cursor.getString(7));
                itemInfo.setStatus(cursor.getInt(8));
                listItems.add(itemInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listItems;
    }

    public ArrayList<ItemInfo> get4NewItems(){
        ArrayList<ItemInfo> listItems = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM_NAME + " WHERE Status = 3  LIMIT 4";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemInfo itemInfo = new ItemInfo();
                itemInfo.setID(cursor.getInt(0));
                itemInfo.setItemID(cursor.getString(1));
                itemInfo.setBrandID(cursor.getString(2));
                itemInfo.setCategoryID(cursor.getString(3));
                itemInfo.setName(cursor.getString(4));
                itemInfo.setImage(cursor.getBlob(5));
                itemInfo.setPrice(cursor.getInt(6));
                itemInfo.setDescription(cursor.getString(7));
                itemInfo.setStatus(cursor.getInt(8));
                listItems.add(itemInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listItems;
    }

    public ArrayList<ItemInfo> get4BestSaleItems(){
        ArrayList<ItemInfo> listItems = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM_NAME + " WHERE Status = 4  LIMIT 4";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemInfo itemInfo = new ItemInfo();
                itemInfo.setID(cursor.getInt(0));
                itemInfo.setItemID(cursor.getString(1));
                itemInfo.setBrandID(cursor.getString(2));
                itemInfo.setCategoryID(cursor.getString(3));
                itemInfo.setName(cursor.getString(4));
                itemInfo.setImage(cursor.getBlob(5));
                itemInfo.setPrice(cursor.getInt(6));
                itemInfo.setDescription(cursor.getString(7));
                itemInfo.setStatus(cursor.getInt(8));
                listItems.add(itemInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listItems;
    }
    public ArrayList<ItemInfo> getAllSaleItems(){
        ArrayList<ItemInfo> listItems = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM_NAME + " WHERE Status = 2";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemInfo itemInfo = new ItemInfo();
                itemInfo.setID(cursor.getInt(0));
                itemInfo.setItemID(cursor.getString(1));
                itemInfo.setBrandID(cursor.getString(2));
                itemInfo.setCategoryID(cursor.getString(3));
                itemInfo.setName(cursor.getString(4));
                itemInfo.setImage(cursor.getBlob(5));
                itemInfo.setPrice(cursor.getInt(6));
                itemInfo.setDescription(cursor.getString(7));
                itemInfo.setStatus(cursor.getInt(8));
                listItems.add(itemInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listItems;
    }

    public ArrayList<ItemInfo> getAllNewItems(){
        ArrayList<ItemInfo> listItems = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM_NAME + " WHERE Status = 3";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemInfo itemInfo = new ItemInfo();
                itemInfo.setID(cursor.getInt(0));
                itemInfo.setItemID(cursor.getString(1));
                itemInfo.setBrandID(cursor.getString(2));
                itemInfo.setCategoryID(cursor.getString(3));
                itemInfo.setName(cursor.getString(4));
                itemInfo.setImage(cursor.getBlob(5));
                itemInfo.setPrice(cursor.getInt(6));
                itemInfo.setDescription(cursor.getString(7));
                itemInfo.setStatus(cursor.getInt(8));
                listItems.add(itemInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listItems;
    }

    public ArrayList<ItemInfo> getAllBestSaleItems(){
        ArrayList<ItemInfo> listItems = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM_NAME + " WHERE Status = 4";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemInfo itemInfo = new ItemInfo();
                itemInfo.setID(cursor.getInt(0));
                itemInfo.setItemID(cursor.getString(1));
                itemInfo.setBrandID(cursor.getString(2));
                itemInfo.setCategoryID(cursor.getString(3));
                itemInfo.setName(cursor.getString(4));
                itemInfo.setImage(cursor.getBlob(5));
                itemInfo.setPrice(cursor.getInt(6));
                itemInfo.setDescription(cursor.getString(7));
                itemInfo.setStatus(cursor.getInt(8));
                listItems.add(itemInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listItems;
    }

    public void addItem(ItemInfo itemInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEM_ID, itemInfo.getItemID());
        contentValues.put(ITEM_BRAND_ID, itemInfo.getBrandID());
        contentValues.put(ITEM_CATEGORY_ID, itemInfo.getCategoryID());
        contentValues.put(ITEM_NAME, itemInfo.getName());
        contentValues.put(ITEM_IMAGE, itemInfo.getImage());
        contentValues.put(ITEM_PRICE, itemInfo.getPrice());
        contentValues.put(ITEM_DESCRIPTION, itemInfo.getDescription());
        contentValues.put(ITEM_STATUS, itemInfo.getStatus());

        db.insert(TABLE_ITEM_NAME, null, contentValues);
        db.close();
    }
    public int updateItem(ItemInfo itemInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEM_ID, itemInfo.getItemID());
        contentValues.put(ITEM_BRAND_ID, itemInfo.getBrandID());
        contentValues.put(ITEM_CATEGORY_ID, itemInfo.getCategoryID());
        contentValues.put(ITEM_NAME, itemInfo.getName());
        contentValues.put(ITEM_IMAGE, itemInfo.getImage());
        contentValues.put(ITEM_PRICE, itemInfo.getPrice());
        contentValues.put(ITEM_DESCRIPTION, itemInfo.getDescription());
        contentValues.put(ITEM_STATUS, itemInfo.getStatus());
        return db.update(TABLE_ITEM_NAME,contentValues,ID +"=?",new String[] { String.valueOf(itemInfo.getID())});
    }
    public int deleteBrand(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_ITEM_NAME, ID + "=?", new String[]{String.valueOf(String.valueOf(id))});
    }

}
