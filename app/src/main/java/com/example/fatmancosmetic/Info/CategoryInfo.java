package com.example.fatmancosmetic.Info;

public class CategoryInfo {
    //Categories table 3 columns
    private int ID;
    private String categoryID;
    private String categoryName;
    private int Status;

    public CategoryInfo() {
    }

    public CategoryInfo(int ID, String categoryID, String categoryName, int status) {
        this.ID = ID;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        Status = status;
    }

    public CategoryInfo(String categoryID, String categoryName, int status) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        Status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
