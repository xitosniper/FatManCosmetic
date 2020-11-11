package com.example.fatmancosmetic.Info;

public class FlashSaleInfo {
    private byte[] image;
    private String title;
    private int price;

    public FlashSaleInfo() {
    }

    public FlashSaleInfo(byte[] image, String title, int price) {
        this.image = image;
        this.title = title;
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
