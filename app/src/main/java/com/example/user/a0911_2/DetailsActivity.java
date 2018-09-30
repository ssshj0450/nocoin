package com.example.user.a0911_2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {
    private WebView mWebView;
    WebSettings mWebSettings;
    public int count=0;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_fragment);


        Intent intent = getIntent();

        TextView titleTextView = (TextView)findViewById(R.id.title);
        titleTextView.setText(intent.getExtras().getString("title"));

        TextView time = (TextView)findViewById(R.id.date);
        time.setText(intent.getExtras().getString("date"));

        TextView place = (TextView)findViewById(R.id.place);
        place.setText(intent.getExtras().getString("place"));
        mWebView = (WebView)findViewById(R.id.webView);
        mWebView.setWebViewClient(new WebViewClient());
        mWebSettings=mWebView.getSettings();
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        mWebView.setInitialScale(100);
        if(Build.VERSION.SDK_INT >= 21) {
            mWebSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }




        String url = intent.getExtras().getString("image");
        mWebView.loadUrl(url);

        TextView origin = (TextView)findViewById(R.id.origin);
        origin.setText(intent.getExtras().getString("origin"));

    }






    public void onClick(View view) {
        //찜 클릭시 이벤트 발생

        ImageButton button = (ImageButton)findViewById(R.id.imageButton);



        if(count%2==0) {
            button.setPressed(true);
            button.setSelected(true);
            Toast.makeText(this,"찜목록에 추가되었습니다.",Toast.LENGTH_SHORT).show();
            count++;
        }

        else {
            button.setPressed(!button.isPressed());
            button.setSelected(!button.isSelected());
            Toast.makeText(this,"찜목록에서 삭제되었습니다.",Toast.LENGTH_SHORT).show();
            count++;
        }
    }

}