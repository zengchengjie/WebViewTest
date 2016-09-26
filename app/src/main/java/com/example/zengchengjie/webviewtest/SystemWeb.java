package com.example.zengchengjie.webviewtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by zengchengjie on 2016/4/28.
 */
public class SystemWeb extends AppCompatActivity {

    private WebView mwebView;
    private ProgressBar mprogress;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.systemweb);
        mwebView = (WebView) findViewById(R.id.web_view);//获取到webview的实例
        mprogress = (ProgressBar) findViewById(R.id.progress);

        mwebView.getSettings().setJavaScriptEnabled(true);
        //使用getSettings去设置浏览器属性，这里设置让webview支持JavaScript脚本 (支持弹出窗等网页属性)

        mwebView.setWebViewClient(new WebViewClient() {//跳转到新的网页时，目标网页仍然留在当前webview中
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);//根据传入的参数再去加载新的网页
                return true;//表示当前WebView可以打开新网页请求，不用借助系统浏览器
            }
        });
        mwebView.loadUrl("http://www.baidu.com");//将网址传入


        //设置进度条，显示加载进度
        mwebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {//重写进度条的方法
                if (newProgress == 100) {
                    mprogress.setVisibility(View.GONE);//隐藏
                } else {
                    if (mprogress.getVisibility() == View.GONE) {
                        mprogress.setVisibility(View.VISIBLE);
                        mprogress.setProgress(newProgress);//设置加载进度
                    }
                    super.onProgressChanged(view, newProgress);
                }

            }
        });
    }

    public boolean onkeydown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == keyEvent.KEYCODE_BACK && mwebView.canGoBack()) {
            mwebView.canGoBack();
            return true;
        }
        return super.onKeyDown(keyCode, keyEvent);
    }
}
