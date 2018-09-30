package com.example.user.a0911_2;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity_home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public int sep=0;
    public int cnt = 0;
    private static final int MY_PERMISSION_STORAGE = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("           DDANGJON");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.content_main_activity_home);

        setContentView(R.layout.activity_main_home);
        //checkPermission();


        final ImageButton r_bt = (ImageButton) findViewById(R.id.BTright);
        final ImageButton l_bt = (ImageButton) findViewById(R.id.BTleft);
        final Button choose_bt = (Button) findViewById(R.id.BTchoose);

        r_bt.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                if (cnt == 0) {
                    sep=1;
                    choose_bt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.h_couple, 0, 0, 0);
                    choose_bt.setText("연인과 함께");
                    cnt++;
                } else if (cnt == 1) {
                    sep=2;
                    choose_bt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.h_family, 0, 0, 0);
                    choose_bt.setText("가족과 함께");
                    cnt++;
                } else if (cnt == 2) {
                    sep=3;
                    choose_bt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.h_friend, 0, 0, 0);
                    choose_bt.setText("친구와 함께");
                }

            }
        });

        l_bt.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                if (cnt == 0) {
                    choose_bt.setText("아이와 함께");
                    choose_bt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.h_baby, 0, 0, 0);
                    sep=0;

                } else if (cnt == 1) {
                    choose_bt.setText("연인과 함께");
                    choose_bt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.h_couple, 0, 0, 0);
                    sep=1;
                    cnt--;
                } else if (cnt == 2) {
                    choose_bt.setText("가족과 함께");
                    choose_bt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.h_family, 0, 0, 0);
                    sep=2;
                    cnt--;
                }

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    FragmentManager manager_hbtn = getSupportFragmentManager();

    public void commu_click(View v) {
        /*
        Intent intent = new Intent(MainActivity_home.this, CommunityActivity.class);
        startActivity(intent);

        */

        manager_hbtn.beginTransaction().replace(R.id.content_main_home, new CommunityFragment()).addToBackStack(null).commit();
    }

    public void withclick(View v){
        //performance_click(v);
        if(sep==0)
            experience_click(v);
        else if(sep==1)
            performance_click(v);
        else if(sep==2)
            culture_click(v);
        else if(sep==3)
            movie_click(v);
    }

    public static int kindofview = 0;
    public void total_click(View v) {
        kindofview = 0;
        //manager_hbtn.beginTransaction().replace(R.id.content_main_home, new Frag1_Total()).addToBackStack(null).commit();
        Intent intent = new Intent(MainActivity_home.this, ShowActivity.class);
        startActivity(intent);

    }

    public void performance_click(View v) {
        kindofview = 1;
        Intent intent = new Intent(MainActivity_home.this, ShowActivity.class);
        startActivity(intent);
    }

    public void experience_click(View v) {
        kindofview = 6;
        Intent intent = new Intent(MainActivity_home.this, ShowActivity.class);
        startActivity(intent);
    }

    public void movie_click(View v) {
        kindofview = 3;
        Intent intent = new Intent(MainActivity_home.this, ShowActivity.class);
        startActivity(intent);
    }

    public void culture_click(View v) {
        kindofview = 4;
        Intent intent = new Intent(MainActivity_home.this, ShowActivity.class);
        startActivity(intent);}
/*
    public void volunteer_click(View v) {
        manager_hbtn.beginTransaction().replace(R.id.content_main_home, new Frag6_Volunteer()).addToBackStack(null).commit();
    }
*/


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_home, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager manager = getSupportFragmentManager();

        if (id == R.id.nav_first_layout) {
            manager.beginTransaction().replace(R.id.content_main_home, new FirstLayout()).addToBackStack(null).commit();
        } else if (id == R.id.nav_second_layout) {
            manager.beginTransaction().replace(R.id.content_main_home, new SecondLayout()).addToBackStack(null).commit();
        } else if (id == R.id.nav_third_layout) {
            manager.beginTransaction().replace(R.id.content_main_home, new ThirdLayout()).addToBackStack(null).commit();
        } else if (id == R.id.nav_forth_layout) {
            manager.beginTransaction().replace(R.id.content_main_home, new ForthLayout()).addToBackStack(null).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

   /* private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                new AlertDialog.Builder(this)
                        .setTitle("알림")
                        .setMessage("저장소 권한이 거부되었습니다. 사용을 원하시면 설정에서 해당 권한을 직접 허용하셔야 합니다.")
                        .setNeutralButton("설정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                intent.setData(Uri.parse("package:" + getPackageName()));
                                startActivity(intent);
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE
                        , Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_STORAGE);
            }

        }

    }*/

   /* @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_STORAGE:
                for (int i = 0; i < grantResults.length; i++) {
                    //허용된 권한 0, 거부한 권한 -1
                    if (grantResults[i] < 0) {
                        Toast.makeText(MainActivity_home.this, "해당 권한을 활성화 하셔야 합니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }
                //허용했다면 이부분에서?
                break;
        }

    }*/
}