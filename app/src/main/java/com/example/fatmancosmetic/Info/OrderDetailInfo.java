package com.example.fatmancosmetic.Info;

public class OrderDetailInfo {
    //OrderDetails table 6 columns
    private int ID;
    private String orderDetailsID;
    private String orderID;
    private String itemID;
    private int Quantity;
    private int Price;

    public OrderDetailInfo() {
    }

    public OrderDetailInfo(int ID, String orderDetailsID, String orderID, String itemID, int quantity, int price) {
        this.ID = ID;
        this.orderDetailsID = orderDetailsID;
        this.orderID = orderID;
        this.itemID = itemID;
        this.Quantity = quantity;
        this.Price = price;
    }

    public OrderDetailInfo(String orderDetailsID, String orderID, String itemID, int quantity, int price) {
        this.orderDetailsID = orderDetailsID;
        this.orderID = orderID;
        this.itemID = itemID;
        this.Quantity = quantity;
        this.Price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOrderDetailsID() {
        return orderDetailsID;
    }

    public void setOrderDetailsID(String orderDetailsID) {
        this.orderDetailsID = orderDetailsID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

}
