package com.example.fatmancosmetic.Info;

public class ItemInfo {
    //Items table 8 columns
    private int ID;
    private String itemID;
    private String brandID;
    private String categoryID;
    private String Name;
    private byte[] Image;
    private int Price;
    private String Description;
    private int Status;

    public ItemInfo() {
    }

    public ItemInfo(int ID, String itemID, String brandID, String categoryID, String name, byte[] image, int price, String description, int status) {
        this.ID = ID;
        this.itemID = itemID;
        this.brandID = brandID;
        this.categoryID = categoryID;
        Name = name;
        Image = image;
        Price = price;
        Description = description;
        Status = status;
    }

    public ItemInfo(String itemID, String brandID, String categoryID, String name, byte[] image, int price, String description, int status) {
        this.itemID = itemID;
        this.brandID = brandID;
        this.categoryID = categoryID;
        Name = name;
        Image = image;
        Price = price;
        Description = description;
        Status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
