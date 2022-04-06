package com.example.myaddview;

import java.util.ArrayList;

// https://cdn.pixabay.com/photo/2017/05/11/19/44/fresh-fruits-2305192__340.jpg
// https://cdn.pixabay.com/photo/2018/04/29/11/54/strawberries-3359755__340.jpg
// https://cdn.pixabay.com/photo/2014/12/21/23/34/cherry-575547__340.png
// https://cdn.pixabay.com/photo/2016/07/22/09/59/fruits-1534494__340.jpg
// https://cdn.pixabay.com/photo/2017/01/20/15/12/oranges-1995079__340.jpg
// https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg
// https://cdn.pixabay.com/photo/2021/11/11/16/05/fruits-6786607__340.jpg
// https://cdn.pixabay.com/photo/2021/10/07/15/24/fruits-6688947__340.jpg

public class Fruit {

    String imageUrl;
    String name;
    String count;
    String price;

    public Fruit(String imageUrl, String name, String count, String price) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    // 샘플 데이터
    public static ArrayList<Fruit> getFruits() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2017/05/11/19/44/fresh-fruits-2305192__340.jpg",
                "레몬","10","5_000원"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2018/04/29/11/54/strawberries-3359755__340.jpg",
                "딸기","10","5_000원"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2014/12/21/23/34/cherry-575547__340.png",
                "체리","10","5_000원"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2016/07/22/09/59/fruits-1534494__340.jpg",
                "자몽","10","5_000원"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2017/01/20/15/12/oranges-1995079__340.jpg",
                "오렌지","10","5_000원"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2017/02/05/12/31/lemons-2039830__340.jpg",
                "메론","10","5_000원"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2021/11/11/16/05/fruits-6786607__340.jpg",
                "키위","10","5_000원"));
        fruits.add(new Fruit("https://cdn.pixabay.com/photo/2021/10/07/15/24/fruits-6688947__340.jpg",
                "코코넛","10","5_000원"));

        return fruits;
    }
}
