package com.example.fatmancosmetic.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.fatmancosmetic.DBManager.DBManager;
import com.example.fatmancosmetic.Info.CustomerInfo;
import com.example.fatmancosmetic.Info.OrderDetailInfo;

import java.util.ArrayList;

public class CustomerModel extends DBManager {
    //Customers table 15 columns
    private static final String TABLE_CUSTOMER_NAME = "Customers";
    private static final String CUSTOMER_ID = "customerID";
    private static final String CUSTOMER_USERNAME = "userName";
    private static final String CUSTOMER_PASSWORD = "passWord";
    private static final String CUSTOMER_FACEBOOKID = "facebookID";
    private static final String CUSTOMER_FACEBOOKLINK = "facebookLink";
    private static final String CUSTOMER_GMAILID = "gmailID";
    private static final String CUSTOMER_GMAILLINK = "gmailLink";
    private static final String CUSTOMER_NAME = "Name";
    private static final String CUSTOMER_IMAGE = "Image";
    private static final String CUSTOMER_AGE = "Age";
    private static final String CUSTOMER_GENDER = "Gender";
    private static final String CUSTOMER_PHONE = "Phone";
    private static final String CUSTOMER_ADDRESS = "Address";
    private static final String CUSTOMER_EMAIL = "Email";
    private static final String CUSTOMER_STATUS = "Status";

    public CustomerModel(@Nullable Context context) {
        super(context);
    }

    public ArrayList<CustomerInfo> getAllCustomers() {
        ArrayList<CustomerInfo> listCustomers = new ArrayList<>();
        try {
            // Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_CUSTOMER_NAME;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    CustomerInfo customerInfo = new CustomerInfo();
                    customerInfo.setID(cursor.getInt(0));
                    customerInfo.setCustomerID(cursor.getString(1));
                    customerInfo.setUserName(cursor.getString(2));
                    customerInfo.setPassWord(cursor.getString(3));
                    customerInfo.setFacebookID(cursor.getString(4));
                    customerInfo.setFacebookLink(cursor.getString(5));
                    customerInfo.setGmailID(cursor.getString(6));
                    customerInfo.setGmailLink(cursor.getString(7));
                    customerInfo.setName(cursor.getString(8));
                    customerInfo.setImage(cursor.getBlob(9));
                    customerInfo.setAge(cursor.getString(10));
                    customerInfo.setGender(cursor.getInt(11));
                    customerInfo.setPhone(cursor.getString(12));
                    customerInfo.setAddress(cursor.getString(13));
                    customerInfo.setEmail(cursor.getString(14));
                    customerInfo.setStatus(cursor.getInt(15));
                    listCustomers.add(customerInfo);
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
        return listCustomers;
    }

    public ArrayList<CustomerInfo> getCustomerByCustomerID(String customerID) {
        ArrayList<CustomerInfo> listCustomers = new ArrayList<>();
        try {
            // Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_CUSTOMER_NAME + " WHERE Customers.customerID = '" + customerID + "'";

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    CustomerInfo customerInfo = new CustomerInfo();
                    customerInfo.setID(cursor.getInt(0));
                    customerInfo.setCustomerID(cursor.getString(1));
                    customerInfo.setUserName(cursor.getString(2));
                    customerInfo.setPassWord(cursor.getString(3));
                    customerInfo.setFacebookID(cursor.getString(4));
                    customerInfo.setFacebookLink(cursor.getString(5));
                    customerInfo.setGmailID(cursor.getString(6));
                    customerInfo.setGmailLink(cursor.getString(7));
                    customerInfo.setName(cursor.getString(8));
                    customerInfo.setImage(cursor.getBlob(9));
                    customerInfo.setAge(cursor.getString(10));
                    customerInfo.setGender(cursor.getInt(11));
                    customerInfo.setPhone(cursor.getString(12));
                    customerInfo.setAddress(cursor.getString(13));
                    customerInfo.setEmail(cursor.getString(14));
                    customerInfo.setStatus(cursor.getInt(15));
                    listCustomers.add(customerInfo);
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
        return listCustomers;
    }

    public void addCustomer(CustomerInfo customerInfo) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(CUSTOMER_ID, customerInfo.getCustomerID());
            contentValues.put(CUSTOMER_USERNAME, customerInfo.getUserName());
            contentValues.put(CUSTOMER_PASSWORD, customerInfo.getPassWord());
            contentValues.put(CUSTOMER_FACEBOOKID, customerInfo.getFacebookID());
            contentValues.put(CUSTOMER_FACEBOOKLINK, customerInfo.getFacebookLink());
            contentValues.put(CUSTOMER_GMAILID, customerInfo.getGmailID());
            contentValues.put(CUSTOMER_GMAILLINK, customerInfo.getGmailLink());
            contentValues.put(CUSTOMER_NAME, customerInfo.getName());
            contentValues.put(CUSTOMER_IMAGE, customerInfo.getImage());
            contentValues.put(CUSTOMER_AGE, customerInfo.getAge());
            contentValues.put(CUSTOMER_GENDER, customerInfo.getGender());
            contentValues.put(CUSTOMER_PHONE, customerInfo.getPhone());
            contentValues.put(CUSTOMER_ADDRESS, customerInfo.getAddress());
            contentValues.put(CUSTOMER_EMAIL, customerInfo.getEmail());
            contentValues.put(CUSTOMER_STATUS, customerInfo.getStatus());


            db.insert(TABLE_CUSTOMER_NAME, null, contentValues);
            db.close();
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
    }
}
