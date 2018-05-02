package com.example.katherine.lab_asynctask_recyclerview;

import android.graphics.Bitmap;

public class Person {
    String name;
    String age;
    Bitmap photoId;

    Person(String name, String age, Bitmap photoId) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
    }
}
