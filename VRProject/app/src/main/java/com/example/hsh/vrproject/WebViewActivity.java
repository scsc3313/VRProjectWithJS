package com.example.hsh.vrproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.lang.reflect.Method;

public class WebViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_web_view);

        WebView webView =(WebView) findViewById(R.id.webView);
        WebSettings webSet = webView.getSettings() ;
        webSet.setJavaScriptEnabled(true);
        webSet.setBuiltInZoomControls(true);
        webSet.setAllowUniversalAccessFromFileURLs(true);
        webSet.setUseWideViewPort(true);
        webSet.setDefaultTextEncodingName("UTF-8");
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        try {

            Object[] obj = {Boolean.TRUE};

            Class cls =   webSet.getClass();
            Method method =cls.getMethod("setWebGLEnabled" , new Class[] {Boolean.TYPE} );
            method.invoke(webSet,obj);


        } catch (Exception e) {
            // TODO: handle exception
            Log.d("error", "error");
        }

        webView.loadUrl("http://192.168.10.163:3000");
    }
}
