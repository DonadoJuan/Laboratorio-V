package com.example.juan.tplabv.signupActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.juan.tplabv.R;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        SignupModel sm = new SignupModel();
        SignupView sv = new SignupView(this);
        SignupController sc = new SignupController(sm, sv);

    }
}
