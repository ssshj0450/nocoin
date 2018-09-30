package com.example.user.a0911_2;

import android.graphics.Bitmap;

public class CommuInfor {
    public String c_name;
    public String c_text;
    public Bitmap c_image;

    CommuInfor(String c_name, String c_text, Bitmap image){
        this.c_image = image;
        this.c_name =c_name;
        this.c_text = c_text;
    }


}
