package com.example.fatmancosmetic.DBManager;

public class SQLElement {
    //Database set name
    private static final String DATABASE_NAME = "cosmetic_manager";
    private static final int VERSION = 1;
    //Roles table 4 columns
    private static final String TABLE_ROLE_NAME = "Roles";
    private static final String ROLE_ID = "roleID";
    private static final String ROLE_NAME = "roleName";
    private static final String ROLE_DESCRIPTION = "roleDescription";
    private static final String ROLE_STATUS = "Status";
    //Staffs table 12 columns
    private static final String TABLE_STAFF_NAME = "Staffs";
    private static final String STAFF_ID = "staffID";
    private static final String STAFF_ROLE_ID = "roleID";
    private static final String STAFF_USERNAME = "userName";
    private static final String STAFF_PASSWORD = "passWord";
    private static final String STAFF_NAME = "Name";
    private static final String STAFF_IMAGE = "Image";
    private static final String STAFF_AGE = "Age";
    private static final String STAFF_GENDER = "Gender";
    private static final String STAFF_PHONE = "Phone";
    private static final String STAFF_ADDRESS = "Address";
    private static final String STAFF_EMAIL = "Emails";
    private static final String STAFF_STATUS = "Status";
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
    private static final String CUSTOMER_EMAIL = "Emails";
    private static final String CUSTOMER_STATUS = "Status";
    //Comments table 6 columns
    private static final String TABLE_COMMENT_NAME = "Comments";
    private static final String COMMENT_ID = "commentID";
    private static final String COMMENT_CUSTOMER_ID = "customerID";
    private static final String COMMENT_ITEM_ID = "itemID";
    private static final String COMMENT_DATE = "commentDate";
    private static final String CONTENT = "Content";
    private static final String CONTENT_STATUS = "Status";
    //BrowseComments table 4 columns
    private static final String TABLE_BROWSECOMMENT_NAME = "BrowseComments";
    private static final String BROWSECOMMENT_ID = "browseCommentID";
    private static final String BROWSECOMMENT_STAFF_ID = "staffID";
    private static final String BROWSECOMMENT_COMMENT_ID = "commentID";
    private static final String BROWSECOMMENT_DATE_UPDATE = "dateUpdate";
    //Orders table 10 columns
    private static final String TABLE_ORDER_NAME = "Orders";
    private static final String ORDER_ID = "orderID";
    private static final String ORDER_CUSTOMER_ID = "customerID";
    private static final String ORDER_ORDERDATE = "orderDate";
    private static final String ORDER_SHIPDATE = "shipDate";
    private static final String ORDER_ADDRESS = "Address";
    private static final String ORDER_PHONE = "Phone";
    private static final String ORDER_NOTE = "Note";
    private static final String ORDER_AMOUNT = "Amount";
    private static final String ORDER_STATUS = "Status";
    //OrderDetails table 6 columns
    private static final String TABLE_ORDERDETAILS_NAME = "OrderDetails";
    private static final String ORDERDETAILS_ID = "orderDetailsID";
    private static final String ORDERDETAILS_ORDER_ID  = "orderID";
    private static final String ORDERDETAILS_ITEM_ID = "itemID";
    private static final String ORDERDETAILS_QUANTITY = "Quantity";
    private static final String ORDERDETAILS_PRICE = "Price";
    //BrowseOrders table 4 columns
    private static final String TABLE_BROWSEORDER_NAME = "BrowseOrders";
    private static final String BROWSEORDER_ID = "browseOrderID";
    private static final String BROWSEORDER_STAFF_ID = "staffID";
    private static final String BROWSEORDER_ORDER_ID = "orderID";
    private static final String BROWSEORDER_DATE_UPDATE = "dateUpdate";
    //Items table 8 columns
    private static final String TABLE_ITEM_NAME = "Items";
    private static final String ITEM_ID = "itemID";
    private static final String ITEM_BRAND_ID = "brandID";
    private static final String ITEM_CATEGORY_ID = "categoryID";
    private static final String ITEM_NAME = "Name";
    private static final String ITEM_IMAGE = "Image";
    private static final String ITEM_PRICE = "Price";
    private static final String ITEM_DESCRIPTION = "Description";
    private static final String ITEM_STATUS = "Status";
    //Brands table 3 columns
    private static final String TABLE_BRAND_NAME = "Brands";
    private static final String BRAND_ID = "brandID";
    private static final String BRAND_NAME = "brandName";
    private static final String BRAND_STATUS = "Status";
    //Categories table 3 columns
    private static final String TABLE_CATEGORY_NAME = "Categories";
    private static final String CATEGORY_ID = "categoryID";
    private static final String CATEGORY_NAME = "categoryName";
    private static final String CATEGORY_STATUS = "Status";

}
