package com.example.myproduct.models;

import java.util.ArrayList;

public class Product {
    // 이미지 주소 변수
    // 타이틀
    // 판매자 위치
    // 가격
    // 댓글 카운트
    // 좋아요 카운트
    // 샘플 데이터 만들어 보기

    private String productImage;
    private String productName;
    private String sellInfo;
    private String productPrice;
    private String replyCount;
    private String goodCount;

    public Product(String productImage, String productName, String sellInfo, String productPrice, String replyCount, String goodCount) {
        this.productImage = productImage;
        this.productName = productName;
        this.sellInfo = sellInfo;
        this.productPrice = productPrice;
        this.replyCount = replyCount;
        this.goodCount = goodCount;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductName() {
        return productName;
    }

    public String getSellInfo() {
        return sellInfo;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getReplyCount() {
        return replyCount;
    }

    public String getGoodCount() {
        return goodCount;
    }

    public static ArrayList<Product> getData() {

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863__340.jpg","니트 조끼1","좌동 + 2시간전","35,000원","3","8"));
        products.add(new Product("https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863__340.jpg","니트 조끼2","좌동 + 2시간전","35,000원","3","8"));
        products.add(new Product("https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863__340.jpg","니트 조끼3","좌동 + 2시간전","35,000원","3","8"));
        products.add(new Product("https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863__340.jpg","니트 조끼4","좌동 + 2시간전","35,000원","3","8"));
        products.add(new Product("https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863__340.jpg","니트 조끼5","좌동 + 2시간전","35,000원","3","8"));
        products.add(new Product("https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863__340.jpg","니트 조끼6","좌동 + 2시간전","35,000원","3","8"));
        products.add(new Product("https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863__340.jpg","니트 조끼7","좌동 + 2시간전","35,000원","3","8"));
        products.add(new Product("https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863__340.jpg","니트 조끼8","좌동 + 2시간전","35,000원","3","8"));
        products.add(new Product("https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863__340.jpg","니트 조끼9","좌동 + 2시간전","35,000원","3","8"));
        products.add(new Product("https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863__340.jpg","니트 조끼a","좌동 + 2시간전","35,000원","3","8"));
        products.add(new Product("https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863__340.jpg","니트 조끼b","좌동 + 2시간전","35,000원","3","8"));
        products.add(new Product("https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863__340.jpg","니트 조끼c","좌동 + 2시간전","35,000원","3","8"));
        products.add(new Product("https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863__340.jpg","니트 조끼d","좌동 + 2시간전","35,000원","3","8"));
        products.add(new Product("https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863__340.jpg","니트 조끼e","좌동 + 2시간전","35,000원","3","8"));

        return products;
    }
}
