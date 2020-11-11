package com.example.fatmancosmetic.Info;

public class BrowseCommentInfo {
    //BrowseComments table 4 columns
    private int ID;
    private String browseCommentID;
    private String staffID;
    private String commentID;
    private String dateUpdate;

    public BrowseCommentInfo() {
    }

    public BrowseCommentInfo(int ID, String browseCommentID, String staffID, String commentID, String dateUpdate) {
        this.ID = ID;
        this.browseCommentID = browseCommentID;
        this.staffID = staffID;
        this.commentID = commentID;
        this.dateUpdate = dateUpdate;
    }

    public BrowseCommentInfo(String browseCommentID, String staffID, String commentID, String dateUpdate) {
        this.browseCommentID = browseCommentID;
        this.staffID = staffID;
        this.commentID = commentID;
        this.dateUpdate = dateUpdate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBrowseCommentID() {
        return browseCommentID;
    }

    public void setBrowseCommentID(String browseCommentID) {
        this.browseCommentID = browseCommentID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
