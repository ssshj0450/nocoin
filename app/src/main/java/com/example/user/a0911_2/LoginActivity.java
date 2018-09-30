package com.example.user.a0911_2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends Activity {
   /* public Button btn1; //로그인
    public Button btn2; //회원가입*/
    public Button btn_next; //홈화면으로 넘어가는 버튼
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        setContentView(R.layout.activity_login);

        /*btn1=(Button)findViewById(R.id.btnLogin);
        btn2=(Button)findViewById(R.id.btnRegist);*/
        btn_next=(Button)findViewById(R.id.btnNext);
        Animation anim = AnimationUtils.loadAnimation
                (getApplicationContext(), // 현재화면 제어권자
                        R.anim.alpha_anim);      // 에니메이션 설정한 파일
        btn_next.startAnimation(anim);

    }

  /*  public void ClickLogin(View v)
    {
        Toast.makeText(getApplicationContext(),"로그인 완료",Toast.LENGTH_LONG).show();
    }

    public void ClickRegist(View v)
    {
        Toast.makeText(getApplicationContext(),"회원가입",Toast.LENGTH_LONG).show();
    }*/

    public void ClickNext(View v)
    {
        Intent intent = new Intent(LoginActivity.this,MainActivity_home.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
