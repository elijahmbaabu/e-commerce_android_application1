package com.example.assignment1;

public class Ebuy_store {
    private String item_name;
    private  String item_price;
    private int item_image;

    public Ebuy_store(String item_name, String item_price, int item_image) {
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_image = item_image;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public int getItem_image() {
        return item_image;
    }

    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }
}
