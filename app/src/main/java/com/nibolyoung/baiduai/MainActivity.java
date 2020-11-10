package com.nibolyoung.baiduai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nibolyoung.baiduai.config.Config;

public class MainActivity extends AppCompatActivity implements Config {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
