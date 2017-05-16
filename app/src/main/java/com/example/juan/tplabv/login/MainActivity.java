package com.example.juan.tplabv.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.juan.tplabv.R;
import com.example.juan.tplabv.menu.BuffetMenuActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences  shpf = getSharedPreferences("User", MODE_PRIVATE);
        if (shpf.contains("rememberme")){
            Intent intent = new Intent(this, BuffetMenuActivity.class);
            this.startActivity (intent);
            this.finish();
        }
        setContentView(R.layout.activity_main);
        MainModel mm = new MainModel();
        MainView mv = new MainView(this);
        MainController mc = new MainController(mv,mm);
    }
}
