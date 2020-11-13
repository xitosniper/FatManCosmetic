package com.example.fatmancosmetic.DBManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {
    //Database set name
    private static final String DATABASE_NAME = "cosmetic_manager";
    private static final int VERSION = 1;

    //SQLQuery Create Table Roles
    String SQLQueryRoles = "CREATE TABLE  Roles(" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "roleID VARCHAR(15)," +
            "roleName VARCHAR(50)," +
            "roleDescription VARCHAR(255)," +
            "Status INTEGER);";

    //SQLQuery Create Table Staffs
    String SQLQueryStaffs = "CREATE TABLE  Staffs(" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "staffID VARCHAR(15)," +
            "roleID VARCHAR(15)," +
            "userName VARCHAR(50)," +
            "passWord VARCHAR(50)," +
            "Name VARCHAR(50)," +
            "Image BLOB," +
            "Age INTEGER," +
            "Gender BIT," +
            "Phone VARCHAR(15)," +
            "Address VARCHAR(255)," +
            "Email VARCHAR(255)," +
            "Status INTEGER);";

    //SQLQuery Create Table Customers
    String SQLQueryCustomers = "CREATE TABLE  Customers(" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "customerID VARCHAR(15)," +
            "userName VARCHAR(50)," +
            "passWord VARCHAR(50)," +
            "facebookID VARCHAR(50)," +
            "facebookLink VARCHAR(50)," +
            "gmailID VARCHAR(50)," +
            "gmailLink VARCHAR(50)," +
            "Name VARCHAR(50)," +
            "Image BLOB," +
            "Age INTEGER," +
            "Gender BIT," +
            "Phone VARCHAR(15)," +
            "Address VARCHAR(255)," +
            "Email VARCHAR(255)," +
            "Status INTEGER);";

    //SQLQuery Create Table Comments
    String SQLQueryComments = "CREATE TABLE  Comments(" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "commentID VARCHAR(15)," +
            "customerID VARCHAR(15)," +
            "itemID VARCHAR(15)," +
            "changeDate VARCHAR(50)," +
            "Content VARCHAR(255)," +
            "Status INTEGER);";

    //SQLQuery Create Table Comments
    String SQLQueryBrowseComments = "CREATE TABLE  BrowseComments(" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "browseCommentsID VARCHAR(15)," +
            "staffID VARCHAR(15)," +
            "commentID VARCHAR(15)," +
            "dateUpdate VARCHAR(50));";

    //SQLQuery Create Table Orders
    String SQLQueryOrders = "CREATE TABLE  Orders(" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "orderID VARCHAR(15)," +
            "customerID VARCHAR(15)," +
            "orderDate VARCHAR(50)," +
            "shipDate VARCHAR(50)," +
            "Address VARCHAR(255)," +
            "Phone VARCHAR(15)," +
            "Note VARCHAR(255)," +
            "Amount FLOAT," +
            "Status INTEGER);";

    //SQLQuery Create Table OrderDetails
    String SQLQueryOrderDetails = "CREATE TABLE  OrderDetails(" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "orderDetailsID VARCHAR(15)," +
            "orderID VARCHAR(15)," +
            "itemID VARCHAR(15)," +
            "Quantity INTEGER," +
            "Price INTEGER);";

    //SQLQuery Create Table Items
    String SQLQueryItems = "CREATE TABLE  Items(" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "itemID VARCHAR(15)," +
            "brandID VARCHAR(15)," +
            "categoryID VARCHAR(15)," +
            "Name VARCHAR(50)," +
            "Image BLOB," +
            "Price INTEGER," +
            "Description VARCHAR(255)," +
            "Status INTEGER);";

    //SQLQuery Create Table Brands
    String SQLQueryBrands = "CREATE TABLE  Brands(" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "brandID VARCHAR(15)," +
            "brandName VARCHAR(50)," +
            "Status INTEGER);";

    //SQLQuery Create Table Categories
    String SQLQueryCategories = "CREATE TABLE  Categories(" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "categoryID VARCHAR(15)," +
            "categoryName VARCHAR(50)," +
            "Status INTEGER);";



    public DBManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQueryItems);
        db.execSQL(SQLQueryBrands);
        db.execSQL(SQLQueryCategories);
        db.execSQL(SQLQueryRoles);
        db.execSQL(SQLQueryCustomers);
        db.execSQL(SQLQueryStaffs);
        db.execSQL(SQLQueryOrders);
        db.execSQL(SQLQueryOrderDetails);
        db.execSQL(SQLQueryComments);
        db.execSQL(SQLQueryBrowseComments);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
