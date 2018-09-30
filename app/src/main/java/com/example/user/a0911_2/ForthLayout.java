package com.example.user.a0911_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.user.a0911_2.R.*;

public class ForthLayout extends Fragment {
    View view;
    CustomDialog cd;
    private Button select_pic;
    private Button set_fin;

    static ImageView user_image;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(layout.forth_layout, container, false);

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        select_pic =(Button)view.findViewById(id.select_pic);
        set_fin = (Button)view.findViewById(id.set_fin);
        user_image=(ImageView)view.findViewById(id.user_image);

        changeImg();
        DisplayMetrics dm = getActivity().getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        cd = new CustomDialog(this.getActivity());
        WindowManager.LayoutParams wm = cd.getWindow().getAttributes();
        wm.copyFrom(cd.getWindow().getAttributes());
        wm.width = width/2;
        wm.height = height/2;
        select_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cd.show();
            }
        });
        set_fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"정보수정이 완료되었습니다.",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), MainActivity_home.class);
                startActivity(intent);
            }
        });

        return view;
    }
    public static void changeImg()
    {
        switch (CustomDialog.WImg) {
            case 0:
                break;
            case 1:
                user_image.setImageResource(drawable.coin_gold);
                CustomDialog.select = false;
                break;
            case 2:
                user_image.setImageResource(drawable.coin_silver);
                CustomDialog.select = false;
                break;
            case 3:
                user_image.setImageResource(drawable.coin_dong);
                CustomDialog.select = false;
                break;
        }

    }
}
