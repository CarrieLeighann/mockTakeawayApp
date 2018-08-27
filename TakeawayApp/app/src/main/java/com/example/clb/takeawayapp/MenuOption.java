package com.example.clb.takeawayapp;

public class MenuOption {

    private String name;
    private String price;
    private Boolean available = true;

    public MenuOption(String name, String price) {

        this.name = name; this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
