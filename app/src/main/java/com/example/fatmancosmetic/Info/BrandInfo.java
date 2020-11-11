package com.example.fatmancosmetic.Info;

public class BrandInfo {

    //Brands table 3 columns
    private int ID;
    private String brandID;
    private String brandName;
    private int Status;

    public BrandInfo() {
    }

    public BrandInfo(int ID, String brandID, String brandName, int status) {
        this.ID = ID;
        this.brandID = brandID;
        this.brandName = brandName;
        Status = status;
    }

    public BrandInfo(String brandID, String brandName, int status) {
        this.brandID = brandID;
        this.brandName = brandName;
        Status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
