package com.example.zengchengjie.webviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mbutton1, mbutton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbutton1 = (Button) findViewById(R.id.systemweb_button);
        mbutton2 = (Button) findViewById(R.id.myweb_button);
        mbutton1.setOnClickListener(this);
        mbutton2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.systemweb_button:
                Intent intent = new Intent(MainActivity.this, SystemWeb.class);
                startActivity(intent);
                break;
             case R.id.myweb_button:
                Intent intent2 = new Intent(MainActivity.this, MyWeb.class);
                startActivity(intent2);
                break;
        }
    }
}
