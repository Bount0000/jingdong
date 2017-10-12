package com.example.lenovo.jingdong.bean;

/**
 * Created by lenovo on 2017/10/9.
 */

public class TuijianBean2 {
    private  double price;
    private  String detailUrl ;
    private  String images;
    private String title ;

    @Override
    public String toString() {
        return "TuijianBean2{" +
                "price=" + price +
                ", detailUrl='" + detailUrl + '\'' +
                ", images='" + images + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TuijianBean2() {

    }

    public TuijianBean2(double price, String detailUrl, String images, String title) {

        this.price = price;
        this.detailUrl = detailUrl;
        this.images = images;
        this.title = title;
    }
}
