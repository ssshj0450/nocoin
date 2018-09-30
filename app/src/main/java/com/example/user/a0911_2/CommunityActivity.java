package com.example.user.a0911_2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public class CommunityActivity extends AppCompatActivity {
    private ListView listView;
    ArrayList<CommuInfor> c_info_list;
    CommunityAdapter myadapter;
    CommuInfor cHuman1,cHuman2,cHuman3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        listView = (ListView)findViewById(R.id.listView);
        cHuman1 = new CommuInfor("서울사람", "안녕하세요! 이 행사 참여해보신 분 있나요? 아이와 같이 가려는데 괜찮을까 해서 여쭤봅니다." ,BitmapFactory.decodeResource(getResources(), R.drawable.people1));
        cHuman2 = new CommuInfor("서울언니", "매일 집에만 있다가 밖에 나오니 좋네요. 밥도 먹고 가려고 하는데 여기 주변 맛집 추천해주세요~.",  BitmapFactory.decodeResource(getResources(), R.drawable.people2));
        cHuman3 = new CommuInfor("서울친구", "친구랑 이번에 무료 공연 I SOUL U를 보고 왔는데 너무 재미있었어요. 친구들이랑 보기 좋은 공연으로 추천해요!",  BitmapFactory.decodeResource(getResources(), R.drawable.people3));
        c_info_list = new ArrayList<CommuInfor>();
        c_info_list.add(cHuman1);
        c_info_list.add(cHuman2);
        c_info_list.add(cHuman3);
        /*
        c_info_list.add(cHuman1);
        c_info_list.add(cHuman2);
        c_info_list.add(cHuman3);
        c_info_list.add(cHuman1);
        c_info_list.add(cHuman2);
        c_info_list.add(cHuman3);
        */
        myadapter = new CommunityAdapter(getApplicationContext(),R.layout.commu_info, c_info_list);
        listView.setAdapter(myadapter);
/*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class); // 다음넘어갈 화면
                Bitmap sendBitmap = c_info_list.get(position).c_image;

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                intent.putExtra("image",byteArray);
                startActivity(intent);

            }
        });
        */
    }

}

