package com.example.juan.tplabv.mainActivity;

public class MainModel implements IMainModel{

    public boolean tryAccess(String email, String password){

        //validate in BD
        if(email.equals("juan@juan.com") && password.equals("123"))
            return true;
        else
            return false;
    }
}
