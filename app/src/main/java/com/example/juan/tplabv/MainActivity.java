package com.example.juan.tplabv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MainModel mm = new MainModel();

        MainView mv = new MainView(this);
        MainController mc = new MainController(mv);
    }
}
