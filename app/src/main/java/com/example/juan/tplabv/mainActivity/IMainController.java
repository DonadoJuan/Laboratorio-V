package com.example.juan.tplabv.mainActivity;


import android.content.Context;
import android.widget.EditText;

public interface IMainController {

    void doLogin(EditText email, EditText login);

    void goSignup();
}
