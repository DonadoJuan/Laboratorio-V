package com.example.juan.tplabv.login;

import android.content.Context;

public interface IMainModel {

    boolean tryAccess(String email,String password);
    void saveLogin(Context con);
}
