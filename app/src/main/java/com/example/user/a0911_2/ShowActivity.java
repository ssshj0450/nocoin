package com.example.user.a0911_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ShowActivity extends AppCompatActivity implements CustomListFragment.OnTitleSelectedListener {
    final String[][] contents = new String[20][5] ;
    final String[][] concert = new String[20][5] ;
    final String[][] experience = new String[20][5] ;
    final String[][] movie= new String[20][5] ;
    final String[][] culture = new String[20][5] ;

    @Override public void onTitleSelected(int position) {
        Intent intent = new Intent();

        switch (MainActivity_home.kindofview) {
            case 0:
                intent.setClass(this, DetailsActivity.class);
                intent.putExtra("title", contents[position][0]);
                intent.putExtra("date", contents[position][1]);
                intent.putExtra("place", contents[position][2]);
                intent.putExtra("image", contents[position][3]);
                intent.putExtra("origin", contents[position][4]);
                break;

            case 1 :
                intent.setClass(this, DetailsActivity.class);
                intent.putExtra("title", concert[position][0]);
                intent.putExtra("date", concert[position][1]);
                intent.putExtra("place", concert[position][2]);
                intent.putExtra("image", concert[position][3]);
                intent.putExtra("origin", concert[position][4]);

                break;

            case 6 :
                intent.setClass(this, DetailsActivity.class);
                intent.putExtra("title", experience[position][0]);
                intent.putExtra("date", experience[position][1]);
                intent.putExtra("place", experience[position][2]);
                intent.putExtra("image", experience[position][3]);
                intent.putExtra("origin", experience[position][4]);

                break;

            case 3 :
                intent.setClass(this, DetailsActivity.class);
                intent.putExtra("title", movie[position][0]);
                intent.putExtra("date", movie[position][1]);
                intent.putExtra("place", movie[position][2]);
                intent.putExtra("image", movie[position][3]);
                intent.putExtra("origin", movie[position][4]);

                break;

            case 4 :
                intent.setClass(this, DetailsActivity.class);
                intent.putExtra("title", culture[position][0]);
                intent.putExtra("date", culture[position][1]);
                intent.putExtra("place", culture[position][2]);
                intent.putExtra("image", culture[position][3]);
                intent.putExtra("origin", culture[position][4]);

                break;
        }

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Log.v("test","쇼로 들어옴");

        for(int i = 0; i < 20; i++) {
            contents[i][0] = ManageEventData.getInstance().getFreeEventArrayList().get(i).getTitle();
            contents[i][1] = ManageEventData.getInstance().getFreeEventArrayList().get(i).getDate();
            contents[i][2] = ManageEventData.getInstance().getFreeEventArrayList().get(i).getPlace();
            contents[i][3] = ManageEventData.getInstance().getFreeEventArrayList().get(i).getImage();
            contents[i][4] = ManageEventData.getInstance().getFreeEventArrayList().get(i).getOrigin();
        }
        for(int i =0;i<2;i++) {
            concert[i][0] = ManageEventData.getInstance().getConcertEventArrayList().get(i).getTitle();
            concert[i][1] = ManageEventData.getInstance().getConcertEventArrayList().get(i).getDate();
            concert[i][2] = ManageEventData.getInstance().getConcertEventArrayList().get(i).getPlace();
            concert[i][3] = ManageEventData.getInstance().getConcertEventArrayList().get(i).getImage();
            concert[i][4] = ManageEventData.getInstance().getConcertEventArrayList().get(i).getOrigin();
        }
        for(int i = 0;i<11;i++) {
            experience[i][0] = ManageEventData.getInstance().getExperienceEventArrayList().get(i).getTitle();
            experience[i][1] = ManageEventData.getInstance().getExperienceEventArrayList().get(i).getDate();
            experience[i][2] = ManageEventData.getInstance().getExperienceEventArrayList().get(i).getPlace();
            experience[i][3] = ManageEventData.getInstance().getExperienceEventArrayList().get(i).getImage();
            experience[i][4] = ManageEventData.getInstance().getExperienceEventArrayList().get(i).getOrigin();
        }
        for(int i = 0;i<4;i++) {
            movie[i][0] = ManageEventData.getInstance().getMovieEventArrayList().get(i).getTitle();
            movie[i][1] = ManageEventData.getInstance().getMovieEventArrayList().get(i).getDate();
            movie[i][2] = ManageEventData.getInstance().getMovieEventArrayList().get(i).getPlace();
            movie[i][3] = ManageEventData.getInstance().getMovieEventArrayList().get(i).getImage();
            movie[i][4] = ManageEventData.getInstance().getMovieEventArrayList().get(i).getOrigin();
        }
        for(int i = 0;i<3;i++) {
            culture[i][0] = ManageEventData.getInstance().getCultureEventArrayList().get(i).getTitle();
            culture[i][1] = ManageEventData.getInstance().getCultureEventArrayList().get(i).getDate();
            culture[i][2] = ManageEventData.getInstance().getCultureEventArrayList().get(i).getPlace();
            culture[i][3] = ManageEventData.getInstance().getCultureEventArrayList().get(i).getImage();
            culture[i][4] = ManageEventData.getInstance().getCultureEventArrayList().get(i).getOrigin();
        }



        CustomListFragment customListFrgmt = (CustomListFragment) getSupportFragmentManager().findFragmentById(R.id.customlistfragment);
        if (customListFrgmt != null) {
            switch (MainActivity_home.kindofview)
            {
                case 0:
                    for (int i = 0; i < 20; i++)
                    {
                        if(ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("클래식")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("콘서트")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("국악")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("뮤지컬/오페라")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("무용")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("독주/독창회")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("연극")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("전시/미술"))
                        {
                            customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.concert),
                                    ManageEventData.getInstance().getFreeEventArrayList().get(i).getTitle());
                        }

                        else if(ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("문화교양/강좌"))
                        {
                            customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.culture),
                                    ManageEventData.getInstance().getFreeEventArrayList().get(i).getTitle());
                        }

                        else if(ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("기타"))
                        {
                            customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.experience),
                                    ManageEventData.getInstance().getFreeEventArrayList().get(i).getTitle());
                        }

                        else if(ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("영화"))
                        {
                            customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.movie),
                                    ManageEventData.getInstance().getFreeEventArrayList().get(i).getTitle());
                        }
                    }
                    break;
                case 1:
                    Log.v("test","공연/전시가 나와야해");
                    for (int i = 0; i < 20; i++)
                    {
                        if(ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("클래식")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("콘서트")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("국악")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("뮤지컬/오페라")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("무용")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("독주/독창회")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("연극")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("전시/미술"))
                        {
                            customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.concert),
                                    ManageEventData.getInstance().getFreeEventArrayList().get(i).getTitle());
                        }
                    }
                    break;
                case 6:
                    Log.v("test","기타가 나와야해");
                    for (int i = 0; i < 20; i++)
                    {
                        if(ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("기타"))
                        {
                            customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.experience),
                                    ManageEventData.getInstance().getFreeEventArrayList().get(i).getTitle());
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 20; i++)
                    {
                        if(ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("영화"))
                        {
                            customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.movie),
                                    ManageEventData.getInstance().getFreeEventArrayList().get(i).getTitle());
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < 20; i++)
                    {
                        if(ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("문화교양/강좌"))
                        {
                            customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.culture),
                                    ManageEventData.getInstance().getFreeEventArrayList().get(i).getTitle());
                        }
                    }
                    break;

            }
            /*for (int i = 0; i < 20; i++)
            {
                if(ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("클래식")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("콘서트")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("국악")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("뮤지컬/오페라")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("무용")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("독주/독창회")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("연극")||ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("전시/미술"))
                {
                    customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.concert),
                            ManageEventData.getInstance().getFreeEventArrayList().get(i).getTitle());
                }

                else if(ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("문화교양/강좌"))
                {
                    customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.culture),
                            ManageEventData.getInstance().getFreeEventArrayList().get(i).getTitle());
                }

                else if(ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("기타"))
                {
                    customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.experience),
                            ManageEventData.getInstance().getFreeEventArrayList().get(i).getTitle());
                }

                else if(ManageEventData.getInstance().getFreeEventArrayList().get(i).getCodeName().equals("영화"))
                {
                    customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.movie),
                            ManageEventData.getInstance().getFreeEventArrayList().get(i).getTitle());
                }
            }*/
        }
    }
}