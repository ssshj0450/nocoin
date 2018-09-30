package com.example.user.a0911_2;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class CommunityFragment extends Fragment {

    private ListView listView;
    ArrayList<CommuInfor> c_info_list;
    CommunityAdapter myadapter;
    CommuInfor cHuman1, cHuman2, cHuman3;

    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragmnet_commu, container, false);


        listView = (ListView) v.findViewById(R.id.listView);
        listView.setAdapter(myadapter);

        cHuman1 = new CommuInfor("서울사람", "안녕하세요! 이 행사 참여해보신 분 있나요? 아이와 같이 가려는데 괜찮을까 해서 여쭤봅니다.", BitmapFactory.decodeResource(getResources(), R.drawable.people1));
        cHuman2 = new CommuInfor("서울언니", "매일 집에만 있다가 밖에 나오니 좋네요. 밥도 먹고 가려고 하는데 여기 주변 맛집 추천해주세요~.", BitmapFactory.decodeResource(getResources(), R.drawable.people2));
        cHuman3 = new CommuInfor("서울친구", "친구랑 이번에 무료 공연 I SEOUL U를 보고 왔는데 너무 재미있었어요. 친구들이랑 보기 좋은 공연으로 추천해요!", BitmapFactory.decodeResource(getResources(), R.drawable.people3));
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
        myadapter = new CommunityAdapter(getActivity(), R.layout.commu_info, c_info_list);
        listView.setAdapter(myadapter);
        return v;
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