package com.example.fatmancosmetic.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.fatmancosmetic.DBManager.DBManager;
import com.example.fatmancosmetic.Info.ItemInfo;
import com.example.fatmancosmetic.Info.OrderDetailInfo;
import com.example.fatmancosmetic.Info.OrderInfo;

import java.util.ArrayList;

public class OrderDetailsModel extends DBManager {
    //Variables
    private static final String ID = "ID";
    private static final String TABLE_ORDERDETAILS_NAME = "OrderDetails";
    private static final String ORDERDETAILS_ID = "orderDetailsID";
    private static final String ORDERDETAILS_ORDER_ID  = "orderID";
    private static final String ORDERDETAILS_ITEM_ID = "itemID";
    private static final String ORDERDETAILS_QUANTITY = "Quantity";
    private static final String ORDERDETAILS_PRICE = "Price";
    private static final String ORDERDETAILS_STATUS = "Status";

    public OrderDetailsModel(@Nullable Context context) {
        super(context);
    }

    public ArrayList<OrderDetailInfo> getAllOrderDetails(){
        ArrayList<OrderDetailInfo> listOrderDetails = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ORDERDETAILS_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
                orderDetailInfo.setID(cursor.getInt(0));
                orderDetailInfo.setOrderDetailsID(cursor.getString(1));
                orderDetailInfo.setOrderID(cursor.getString(2));
                orderDetailInfo.setItemID(cursor.getString(3));
                orderDetailInfo.setQuantity(cursor.getInt(4));
                orderDetailInfo.setPrice(cursor.getInt(5));
                listOrderDetails.add(orderDetailInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listOrderDetails;
    }
    public ArrayList<OrderDetailInfo> getOrderDetailsByCustomerID(String customerID){
        ArrayList<OrderDetailInfo> listOrderDetails = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT OrderDetails.* FROM Items, Orders, OrderDetails WHERE Orders.Status = 1 AND Orders.customerID = '"+customerID+"' AND Orders.orderID = OrderDetails.orderID AND OrderDetails.itemID = Items.itemID";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
                orderDetailInfo.setID(cursor.getInt(0));
                orderDetailInfo.setOrderDetailsID(cursor.getString(1));
                orderDetailInfo.setOrderID(cursor.getString(2));
                orderDetailInfo.setItemID(cursor.getString(3));
                orderDetailInfo.setQuantity(cursor.getInt(4));
                orderDetailInfo.setPrice(cursor.getInt(5));

                listOrderDetails.add(orderDetailInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listOrderDetails;
    }

    public ArrayList<OrderDetailInfo> getOrderDetailsByCustomerIDAndItemID(String customerID, String itemID){
        ArrayList<OrderDetailInfo> listOrderDetails = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT OrderDetails.* FROM Items, Orders, OrderDetails WHERE Orders.Status = 1 AND Orders.customerID = '"+customerID+"' AND Orders.orderID = OrderDetails.orderID AND OrderDetails.itemID = Items.itemID AND OrderDetails.itemID = '" +itemID +"'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
                orderDetailInfo.setID(cursor.getInt(0));
                orderDetailInfo.setOrderDetailsID(cursor.getString(1));
                orderDetailInfo.setOrderID(cursor.getString(2));
                orderDetailInfo.setItemID(cursor.getString(3));
                orderDetailInfo.setQuantity(cursor.getInt(4));
                orderDetailInfo.setPrice(cursor.getInt(5));

                listOrderDetails.add(orderDetailInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listOrderDetails;
    }

    public void addOrderDetails(OrderDetailInfo orderDetailInfo){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ORDERDETAILS_ID, orderDetailInfo.getOrderDetailsID());
        contentValues.put(ORDERDETAILS_ORDER_ID, orderDetailInfo.getOrderID());
        contentValues.put(ORDERDETAILS_ITEM_ID, orderDetailInfo.getItemID());
        contentValues.put(ORDERDETAILS_QUANTITY, orderDetailInfo.getQuantity());
        contentValues.put(ORDERDETAILS_PRICE, orderDetailInfo.getPrice());

        db.insert(TABLE_ORDERDETAILS_NAME, null, contentValues);
        db.close();
    }

    public int updateOrderDetails(OrderDetailInfo orderDetailInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ORDERDETAILS_ID, orderDetailInfo.getOrderDetailsID());
        contentValues.put(ORDERDETAILS_ORDER_ID, orderDetailInfo.getOrderID());
        contentValues.put(ORDERDETAILS_ITEM_ID, orderDetailInfo.getItemID());
        contentValues.put(ORDERDETAILS_QUANTITY, orderDetailInfo.getQuantity());
        contentValues.put(ORDERDETAILS_PRICE, orderDetailInfo.getPrice());
        return db.update(TABLE_ORDERDETAILS_NAME,contentValues,ID +"=?",new String[] { String.valueOf(orderDetailInfo.getID())});
    }
    public int deleteOrderDetails(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_ORDERDETAILS_NAME,ID+"=?", new String[]{String.valueOf(String.valueOf(id))});
    }
}
