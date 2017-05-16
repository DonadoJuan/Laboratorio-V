package com.example.juan.tplabv.login;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.juan.tplabv.dao.BuffetDAO;

public class MainModel implements IMainModel{

    private BuffetDAO buffetDAO;

    public MainModel(){
        buffetDAO = new BuffetDAO();
    }

    @Override
    public boolean tryAccess(String email, String password){
        if(buffetDAO.isBuffetUser(email,password) != null){
            return true;
        }
        return false;
    }

    @Override
    public void saveLogin(Context c){
        SharedPreferences mPreferences = c.getSharedPreferences("User", c.MODE_PRIVATE);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString("rememberme", "ok" );
        editor.apply();
    }
}
