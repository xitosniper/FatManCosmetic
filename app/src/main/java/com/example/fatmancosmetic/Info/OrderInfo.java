package com.example.fatmancosmetic.Info;

public class OrderInfo {
    //Orders table 10 columns
    private int ID;
    private String orderID;
    private String customerID;
    private String orderDetailsID;
    private String orderDate;
    private String shipDate;
    private String Address;
    private String Phone;
    private String Note;
    private String Amount;
    private int Status;

    public OrderInfo() {
    }

    public OrderInfo(int ID, String orderID, String customerID, String orderDetailsID, String orderDate, String shipDate, String address, String phone, String note, String amount, int status) {
        this.ID = ID;
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDetailsID = orderDetailsID;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        Address = address;
        Phone = phone;
        Note = note;
        Amount = amount;
        Status = status;
    }

    public OrderInfo(String orderID, String customerID, String orderDetailsID, String orderDate, String shipDate, String address, String phone, String note, String amount, int status) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDetailsID = orderDetailsID;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        Address = address;
        Phone = phone;
        Note = note;
        Amount = amount;
        Status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOrderDetailsID() {
        return orderDetailsID;
    }

    public void setOrderDetailsID(String orderDetailsID) {
        this.orderDetailsID = orderDetailsID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
