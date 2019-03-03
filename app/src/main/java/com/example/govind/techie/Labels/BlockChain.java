package com.example.govind.techie.Labels;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.govind.techie.R;

public class BlockChain extends AppCompatActivity {

    WebView myWebView;
    String URL ="http://worldfordevs.blogspot.com/search/label/Blockchain";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_chain);

        myWebView = (WebView)findViewById(R.id.webviewBlockChain);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl(URL);
        myWebView.setWebViewClient(new WebViewClient());

    }
}
