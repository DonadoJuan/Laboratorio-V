package com.example.juan.tplabv.mainActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.example.juan.tplabv.signupActivity.SignupActivity;
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

        if(validateLogin(email,password)){
            if(mm.tryAccess(email.getText().toString(), password.getText().toString())){
                //mv.getContext().startActivity(new Intent(mv.getContext(), MenuActivity.class));
            }
            else{
               // mv.showErrorToast();
            }
        }
    }

    @Override
    public void goSignup(){
            mv.getContext().startActivity(new Intent(mv.getContext(), SignupActivity.class));
    }

    private boolean validateLogin(EditText email, EditText password){

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
