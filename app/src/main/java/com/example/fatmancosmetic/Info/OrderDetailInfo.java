package com.example.fatmancosmetic.Info;

public class OrderDetailInfo {
    //OrderDetails table 6 columns
    private String ID;
    private String orderDetailsID;
    private String orderID;
    private String itemID;
    private int Quantity;
    private Float Price;
    private int Status;

    public OrderDetailInfo() {
    }

    public OrderDetailInfo(String ID, String orderDetailsID, String orderID, String itemID, int quantity, Float price, int status) {
        this.ID = ID;
        this.orderDetailsID = orderDetailsID;
        this.orderID = orderID;
        this.itemID = itemID;
        Quantity = quantity;
        Price = price;
        Status = status;
    }

    public OrderDetailInfo(String orderDetailsID, String orderID, String itemID, int quantity, Float price, int status) {
        this.orderDetailsID = orderDetailsID;
        this.orderID = orderID;
        this.itemID = itemID;
        Quantity = quantity;
        Price = price;
        Status = status;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
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

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
