package com.example.juan.tplabv.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.example.juan.tplabv.menu.BuffetMenuActivity;
import com.example.juan.tplabv.signup.SignupActivity;
import com.example.juan.tplabv.util.FormValidator;

public class MainController implements IMainController{

    private IMainView mv;
    private IMainModel mm;

    public MainController(IMainView mainView, IMainModel mainModel){
        mv = mainView;
        mv.setIMainController(this);
        mm = mainModel;
        checkAlreadyLogedUser();
    }

    public void checkAlreadyLogedUser(){
        Context con = mv.getContext();
        SharedPreferences  shpf = con.getSharedPreferences("User", Context.MODE_PRIVATE);
        if (shpf.contains("rememberme")){
            Intent intent = new Intent(con, BuffetMenuActivity.class);
            con.startActivity(intent);
            mv.finishMainActivity();
        }
    }

    @Override
    public void doLogin(EditText email, EditText password){

        if(validateLoginFormat(email,password)){
            if(mm.tryAccess(email.getText().toString(), password.getText().toString())){
                mm.saveCurrentUser(mv.getContext(),email.getText().toString());
                if(mv.isRemindMeChecked()){
                    mm.saveLogin(mv.getContext());
                }

                mv.getContext().startActivity(new Intent(mv.getContext(), BuffetMenuActivity.class));
                mv.finishMainActivity();
            }
            else{
                mv.showLoginMatchError();
            }
        }
    }

    @Override
    public void goSignup(){
            mv.getContext().startActivity(new Intent(mv.getContext(), SignupActivity.class));
    }

    private boolean validateLoginFormat(EditText email, EditText password){

        mv.setEmptyPasswordError(false);
        mv.setInvalidEmailError(false);
        mv.setEmptyEmailError(false);

        boolean success = true;

        if(!FormValidator.validateEmpty(email)){
            success = false;
            mv.setEmptyEmailError(true);
        }else{
            if(!FormValidator.validateEmail(email)){
                mv.setInvalidEmailError(true);
                success = false;
            }
        }
        if(!FormValidator.validateEmpty(password)){
            mv.setEmptyPasswordError(true);
            success = false;
        }

        return success;

    }

}
