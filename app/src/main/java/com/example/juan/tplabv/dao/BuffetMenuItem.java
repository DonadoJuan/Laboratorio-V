package com.example.juan.tplabv.dao;

import android.graphics.Bitmap;

import java.io.Serializable;

public class BuffetMenuItem implements Serializable{

    private String name;
    private Double price;
    private BuffetMenuItemType bfiType;
    private String imgUrl;
    private Bitmap imgBitmap;

    public BuffetMenuItem(String name, Double price, BuffetMenuItemType bfiType, String imgUrl) {
        this.name = name;
        this.price = price;
        this.bfiType = bfiType;
        this.imgUrl = imgUrl;
        this.imgBitmap = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBfiType(BuffetMenuItemType bfiType){
        this.bfiType = bfiType;
    }

    public BuffetMenuItemType getBfiType(){
        return bfiType;
    }

    public void setImgUrl(String imgUrl){ this.imgUrl = imgUrl;}

    public String getImgUrl(){ return imgUrl;}

    public void setImgBitmap(Bitmap imgBitmap){ this.imgBitmap = imgBitmap; }

    public Bitmap getImgBitmap(){ return imgBitmap;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuffetMenuItem that = (BuffetMenuItem) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return bfiType == that.bfiType;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (bfiType != null ? bfiType.hashCode() : 0);
        return result;
    }
}
