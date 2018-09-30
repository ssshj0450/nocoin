package com.example.user.a0911_2;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class CustomDialog extends Dialog{
    Button gold,silver,dong;
    public static int WImg = 0;
    public static boolean select = false;
    ImageView profile;

    MainActivity_home main;

    public CustomDialog(Context context){
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.customdialog);
        gold = (Button) findViewById(R.id.gold);
        silver = (Button) findViewById(R.id.silver);
        dong = (Button) findViewById(R.id.dong);

        gold.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                WImg = 1;
                select = true;
                ForthLayout.changeImg();
                dismiss();
            }
        });
        silver.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                WImg = 2;
                select = true;
                ForthLayout.changeImg();
                dismiss();
            }
        });
        dong.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                WImg = 3;
                select = true;
                ForthLayout.changeImg();
                dismiss();
            }
        });
    }
}

