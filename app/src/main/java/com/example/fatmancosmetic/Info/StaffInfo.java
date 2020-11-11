package com.example.fatmancosmetic.Info;


public class StaffInfo {
    //Staffs table 12 columns
    private int ID;
    private String staffID;
    private String roleID;
    private String userName;
    private String passWord;
    private String Name;
    private String Image;
    private String Age;
    private int Gender;
    private String Phone;
    private String Address;
    private String Emails;
    private int Status;

    public StaffInfo() {
    }

    public StaffInfo(int ID, String staffID, String roleID, String userName, String passWord, String name, String image, String age, int gender, String phone, String address, String emails, int status) {
        this.ID = ID;
        this.staffID = staffID;
        this.roleID = roleID;
        this.userName = userName;
        this.passWord = passWord;
        Name = name;
        Image = image;
        Age = age;
        Gender = gender;
        Phone = phone;
        Address = address;
        Emails = emails;
        Status = status;
    }

    public StaffInfo(String staffID, String roleID, String userName, String passWord, String name, String image, String age, int gender, String phone, String address, String emails, int status) {
        this.staffID = staffID;
        this.roleID = roleID;
        this.userName = userName;
        this.passWord = passWord;
        Name = name;
        Image = image;
        Age = age;
        Gender = gender;
        Phone = phone;
        Address = address;
        Emails = emails;
        Status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmails() {
        return Emails;
    }

    public void setEmails(String emails) {
        Emails = emails;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
