package com.example.nare.contacts;



public class Item_class {
    private String name;
    private int img, star_img;

    public void setStar_img(int star_img) {
        this.star_img = star_img;
    }

    public Item_class(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public Item_class(String name, int img, int star_img) {
        this.name = name;
        this.img = img;
        this.star_img = star_img;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public int getStar_img() {
        return star_img;
    }
}
