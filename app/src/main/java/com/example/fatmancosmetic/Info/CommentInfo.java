package com.example.fatmancosmetic.Info;

public class CommentInfo {
    //Comments table 6 columns
    private int ID;
    private String commentID;
    private String customerID;
    private String itemID;
    private String commentDate;
    private String Content;
    private int Status;

    public CommentInfo() {
    }

    public CommentInfo(int ID, String commentID, String customerID, String itemID, String commentDate, String content, int status) {
        this.ID = ID;
        this.commentID = commentID;
        this.customerID = customerID;
        this.itemID = itemID;
        this.commentDate = commentDate;
        Content = content;
        Status = status;
    }

    public CommentInfo(String commentID, String customerID, String itemID, String commentDate, String content, int status) {
        this.commentID = commentID;
        this.customerID = customerID;
        this.itemID = itemID;
        this.commentDate = commentDate;
        Content = content;
        Status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
