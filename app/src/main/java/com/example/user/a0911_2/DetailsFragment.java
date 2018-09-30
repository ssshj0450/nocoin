package com.example.user.a0911_2;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsFragment extends Fragment {
    public WebView mWebView;
    WebSettings mWebSettings;

    public int count=0;
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);
        super.onCreateView(inflater, container, savedInstanceState);


        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        Bundle args = getArguments() ;
        TextView titleTextView = (TextView) view.findViewById(R.id.title) ;
        titleTextView.setText(args.getString("title")) ;

        TextView time = (TextView) view.findViewById(R.id.date) ;
        time.setText(args.getString("date")) ;

        TextView place = (TextView) view.findViewById(R.id.place) ;
        place.setText(args.getString("place")) ;


        mWebView = (WebView)view.findViewById(R.id.webView);
        mWebView.setWebViewClient(new WebViewClient());
        String url = args.getString("image");

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

        mWebView.loadUrl(url);
        Log.v("test","그림 : "+url);


        TextView origin = (TextView) view.findViewById(R.id.origin) ;
        origin.setText(args.getString("origin")) ;
        mWebView.loadDataWithBaseURL(null,creHtmlBody(url),"text/html","urf-8",null);

        return view;
    }
    public  String creHtmlBody(String imagUrl){

        StringBuffer sb = new StringBuffer("<HTML>");

        sb.append("<HEAD>");

        sb.append("</HEAD>");

        sb.append("<BODY style='margin:0; padding:0; text-align:center;'>");    //중앙정렬

        sb.append("<img width='100%' height='100%' src=\"" + imagUrl+"\">"); //가득차게 나옴

        sb.append("</BODY>");

        sb.append("</HTML>");

        return sb.toString();

    }
    public void onClick(View view) {
        //찜 클릭시 이벤트 발생


        ImageButton button = (ImageButton)view.findViewById(R.id.imageButton);

        if(count%2==0) {
            button.setPressed(true);
            button.setSelected(true);
            Toast.makeText(getActivity(),"찜목록에 추가되었습니다.",Toast.LENGTH_SHORT).show();
            count++;
        }

        else {
            button.setPressed(!button.isPressed());
            button.setSelected(!button.isSelected());
            Toast.makeText(getActivity(),"찜목록에서 삭제되었습니다.",Toast.LENGTH_SHORT).show();
            count++;
        }
    }
}
