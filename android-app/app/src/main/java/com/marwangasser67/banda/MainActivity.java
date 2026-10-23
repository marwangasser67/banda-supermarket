package com.marwangasser67.banda;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
    private WebView webView;
    private static final String HOME = "https://marwangasser67.github.io/banda-supermarket/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(android.graphics.Color.rgb(14, 75, 52));
        getWindow().setNavigationBarColor(android.graphics.Color.rgb(8, 62, 43));
        getWindow().getDecorView().setSystemUiVisibility(0);
        FrameLayout frame = new FrameLayout(this);
        webView = new WebView(this);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_NEVER_ALLOW);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        frame.addView(webView, new FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        setContentView(frame);
        if (savedInstanceState != null) webView.restoreState(savedInstanceState);
        else webView.loadUrl(HOME);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        webView.saveState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) webView.goBack();
        else super.onBackPressed();
    }
}
