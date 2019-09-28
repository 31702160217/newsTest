package com.example.jrz.newstest;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private String[] href;
    private Handler handler;
    private String hrefTop = "https://www.mmvtc.cn";
    private String p;
    private String p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv_content = findViewById(R.id.tv_content);
        new Thread(text).start();
        handler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:

                       // tv_content.setText(p);
//                        String text1 =Jsoup.clean(p1, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
//                        String text = text1.replace("&nbsp"," ");
//                        tv_content.setText(text);
//                        Log.e(TAG, "handleMessage: "+p1 );
                        break;
                }
            }
        };

    }
    Runnable text = new Runnable() {
        @Override
        public void run() {
            try {
                Document document = Jsoup.connect("https://www.mmvtc.cn/templet/default/ShowArticle.jsp?id=50547").get();
                p = document.select("p").text();
                p1 = document.select("p")+"";
                Message message = Message.obtain();
                message.what = 1;
                handler.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}
