package com.example.lenovo.jingdong.bean;

/**
 * Created by lenovo on 2017/10/9.
 */

public class MiaoShaBean2 {
   private double bargainPrice;
    private double price;
    private String images;

    public double getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(double bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    @Override
    public String toString() {
        return "MiaoShaBean2{" +
                "bargainPrice=" + bargainPrice +
                ", price=" + price +
                ", images='" + images + '\'' +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public MiaoShaBean2() {

    }

    public MiaoShaBean2(double bargainPrice, double price, String images) {

        this.bargainPrice = bargainPrice;
        this.price = price;
        this.images = images;
    }
}
