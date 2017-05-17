package com.example.juan.tplabv.login;

import android.app.Activity;
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
    }

    @Override
    public void doLogin(EditText email, EditText password){

        if(validateLoginFormat(email,password)){
            if(mm.tryAccess(email.getText().toString(), password.getText().toString())){

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
