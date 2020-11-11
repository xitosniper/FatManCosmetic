package com.example.fatmancosmetic.Info;

public class BrowseOrderInfo {
    //BrowseOrders table 4 columns
    private int ID;
    private String browseOrderID;
    private String staffID;
    private String orderID;
    private String dateUpdate;

    public BrowseOrderInfo() {
    }

    public BrowseOrderInfo(int ID, String browseOrderID, String staffID, String orderID, String dateUpdate) {
        this.ID = ID;
        this.browseOrderID = browseOrderID;
        this.staffID = staffID;
        this.orderID = orderID;
        this.dateUpdate = dateUpdate;
    }

    public BrowseOrderInfo(String browseOrderID, String staffID, String orderID, String dateUpdate) {
        this.browseOrderID = browseOrderID;
        this.staffID = staffID;
        this.orderID = orderID;
        this.dateUpdate = dateUpdate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBrowseOrderID() {
        return browseOrderID;
    }

    public void setBrowseOrderID(String browseOrderID) {
        this.browseOrderID = browseOrderID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
