package com.rair.encrptdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String oldWord = "大家要注意身体，不要熬夜写代码";
        try {
            String encodeWord = Base64.encodeToString(oldWord.getBytes("utf-8"), Base64.NO_WRAP);
            Log.i("Rair", " encode wrods = " + encodeWord);
            String decodeWord = new String(Base64.decode(encodeWord, Base64.NO_WRAP), "utf-8");
            Log.i("Rair", "encode wrods = " + decodeWord);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
