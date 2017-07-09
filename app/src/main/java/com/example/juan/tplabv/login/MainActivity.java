package com.example.juan.tplabv.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.juan.tplabv.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainModel mm = new MainModel();
        MainView mv = new MainView(this);
        MainController mc = new MainController(mv,mm);
    }
}
