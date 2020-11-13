package com.example.fatmancosmetic.Info;

public class CustomerInfo {
    //Customers table 15 columns
    private int ID;
    private String customerID;
    private String userName;
    private String passWord;
    private String facebookID;
    private String facebookLink;
    private String gmailID;
    private String gmailLink;
    private String Name;
    private String Image;
    private String Age;
    private int Gender;
    private String Phone;
    private String Address;
    private String Email;
    private int Status;

    public CustomerInfo() {
    }

    public CustomerInfo(int ID, String customerID, String userName, String passWord, String facebookID, String facebookLink, String gmailID, String gmailLink, String name, String image, String age, int gender, String phone, String address, String email, int status) {
        this.ID = ID;
        this.customerID = customerID;
        this.userName = userName;
        this.passWord = passWord;
        this.facebookID = facebookID;
        this.facebookLink = facebookLink;
        this.gmailID = gmailID;
        this.gmailLink = gmailLink;
        this.Name = name;
        this.Image = image;
        this.Age = age;
        this.Gender = gender;
        this.Phone = phone;
        this.Address = address;
        this.Email = email;
        this.Status = status;
    }

    public CustomerInfo(String customerID, String userName, String passWord, String facebookID, String facebookLink, String gmailID, String gmailLink, String name, String image, String age, int gender, String phone, String address, String email, int status) {
        this.customerID = customerID;
        this.userName = userName;
        this.passWord = passWord;
        this.facebookID = facebookID;
        this.facebookLink = facebookLink;
        this.gmailID = gmailID;
        this.gmailLink = gmailLink;
        this.Name = name;
        this.Image = image;
        this.Age = age;
        this.Gender = gender;
        this.Phone = phone;
        this.Address = address;
        this.Email = email;
        this.Status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
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

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getGmailID() {
        return gmailID;
    }

    public void setGmailID(String gmailID) {
        this.gmailID = gmailID;
    }

    public String getGmailLink() {
        return gmailLink;
    }

    public void setGmailLink(String gmailLink) {
        this.gmailLink = gmailLink;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
