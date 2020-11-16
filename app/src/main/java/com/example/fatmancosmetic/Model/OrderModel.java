package com.example.fatmancosmetic.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.fatmancosmetic.DBManager.DBManager;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Info.OrderDetailInfo;
import com.example.fatmancosmetic.Info.OrderInfo;

import java.util.ArrayList;

public class OrderModel extends DBManager {
    //Variables
    private static final String TABLE_ORDER_NAME = "Orders";
    private static final String ID = "ID";
    private static final String ORDER_ID = "orderID";
    private static final String ORDER_CUSTOMER_ID = "customerID";
    private static final String ORDER_ORDERDATE = "orderDate";
    private static final String ORDER_SHIPDATE = "shipDate";
    private static final String ORDER_ADDRESS = "Address";
    private static final String ORDER_PHONE = "Phone";
    private static final String ORDER_NOTE = "Note";
    private static final String ORDER_AMOUNT = "Amount";
    private static final String ORDER_STATUS = "Status";

    public OrderModel(@Nullable Context context) {
        super(context);
    }

    public ArrayList<OrderInfo> getAllOrders(){
        ArrayList<OrderInfo> listOrders = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ORDER_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                OrderInfo orderInfo = new OrderInfo();
                orderInfo.setID(cursor.getInt(0));
                orderInfo.setOrderID(cursor.getString(1));
                orderInfo.setCustomerID(cursor.getString(2));
                orderInfo.setOrderDate(cursor.getString(3));
                orderInfo.setShipDate(cursor.getString(4));
                orderInfo.setAddress(cursor.getString(5));
                orderInfo.setPhone(cursor.getString(6));
                orderInfo.setNote(cursor.getString(7));
                orderInfo.setAmount(cursor.getString(7));
                orderInfo.setStatus(cursor.getInt(8));
                listOrders.add(orderInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listOrders;
    }

    public ArrayList<OrderInfo> getOrderByOrderID(String orderID){
        ArrayList<OrderInfo> listOrders = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ORDER_NAME + " WHERE Orders.orderID = '" + orderID +"'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                OrderInfo orderInfo = new OrderInfo();
                orderInfo.setID(cursor.getInt(0));
                orderInfo.setOrderID(cursor.getString(1));
                orderInfo.setCustomerID(cursor.getString(2));
                orderInfo.setOrderDate(cursor.getString(3));
                orderInfo.setShipDate(cursor.getString(4));
                orderInfo.setAddress(cursor.getString(5));
                orderInfo.setPhone(cursor.getString(6));
                orderInfo.setNote(cursor.getString(7));
                orderInfo.setAmount(cursor.getString(7));
                orderInfo.setStatus(cursor.getInt(8));
                listOrders.add(orderInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listOrders;
    }

    public ArrayList<OrderInfo> getOrderByCustomerID(String customerID){
        ArrayList<OrderInfo> listOrders = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT Orders.* FROM Orders WHERE Orders.Status = 1 AND Orders.customerID = '" + customerID + "'" ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                OrderInfo orderInfo = new OrderInfo();
                orderInfo.setID(cursor.getInt(0));
                orderInfo.setOrderID(cursor.getString(1));
                orderInfo.setCustomerID(cursor.getString(2));
                orderInfo.setOrderDate(cursor.getString(3));
                orderInfo.setShipDate(cursor.getString(4));
                orderInfo.setAddress(cursor.getString(5));
                orderInfo.setPhone(cursor.getString(6));
                orderInfo.setNote(cursor.getString(7));
                orderInfo.setAmount(cursor.getString(7));
                orderInfo.setStatus(cursor.getInt(8));
                listOrders.add(orderInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listOrders;
    }


    public void addOrder(OrderInfo orderInfo){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ORDER_ID, orderInfo.getOrderID());
        contentValues.put(ORDER_CUSTOMER_ID, orderInfo.getCustomerID());
        contentValues.put(ORDER_ORDERDATE, orderInfo.getOrderDate());
        contentValues.put(ORDER_SHIPDATE, orderInfo.getOrderDate());
        contentValues.put(ORDER_ADDRESS, orderInfo.getAddress());
        contentValues.put(ORDER_PHONE, orderInfo.getPhone());
        contentValues.put(ORDER_NOTE, orderInfo.getNote());
        contentValues.put(ORDER_AMOUNT, orderInfo.getAmount());
        contentValues.put(ORDER_STATUS, orderInfo.getStatus());

        db.insert(TABLE_ORDER_NAME, null, contentValues);
        db.close();
    }

    public int updateOrder(OrderInfo orderInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ORDER_ID, orderInfo.getOrderID());
        contentValues.put(ORDER_CUSTOMER_ID, orderInfo.getCustomerID());
        contentValues.put(ORDER_ORDERDATE, orderInfo.getOrderDate());
        contentValues.put(ORDER_SHIPDATE, orderInfo.getOrderDate());
        contentValues.put(ORDER_ADDRESS, orderInfo.getAddress());
        contentValues.put(ORDER_PHONE, orderInfo.getPhone());
        contentValues.put(ORDER_NOTE, orderInfo.getNote());
        contentValues.put(ORDER_AMOUNT, orderInfo.getAmount());
        contentValues.put(ORDER_STATUS, orderInfo.getStatus());
        return db.update(TABLE_ORDER_NAME,contentValues,ID +"=?",new String[] { String.valueOf(orderInfo.getID())});
    }

}
