package com.example.juan.tplabv.signupActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.example.juan.tplabv.util.FormValidator;

import java.util.List;

public class SignupController implements ISignupController{

    private ISignupView sv;
    private ISignupModel sm;

    public SignupController(ISignupModel signupModel, ISignupView signupView){
        sm = signupModel;
        sv = signupView;
        sv.setISignupController(this);
    }

    @Override
    public void doSignup(List<EditText> signupEt){

        if(validateSignup(signupEt)){

            SignupForm sf = generateForm(signupEt);

            if(sm.trySignup(sf)){
                //mv.getContext().startActivity(new Intent(mv.getContext(), MenuActivity.class))
            }else{
                //error at model
            }

        }
    }

    private boolean validateSignup(List<EditText> signupEt){
        boolean success = true;
        sv.resetAllError();

        for (EditText input : signupEt ) {
            if(!FormValidator.validateEmpty(input)){
                sv.setEmptyInputError(input,true);
                success = false;
            }
        }

        if(FormValidator.validateEmpty(signupEt.get(2)) && !FormValidator.validateEmail(signupEt.get(2))){
            sv.setInvalidEmailError(true);
            success = false;
        }

        if(!FormValidator.validatePassword(signupEt.get(4),signupEt.get(5))){
            sv.setInvalidPasswordError(true);
            success = false;
        }

        return success;

    }

    private SignupForm generateForm(List<EditText> listEt){
        SignupForm sf = new SignupForm();
        sf.setNombre(listEt.get(0).getText().toString());
        sf.setApellido(listEt.get(1).getText().toString());
        sf.setDni(listEt.get(2).getText().toString());
        sf.setMail(listEt.get(3).getText().toString());
        sf.setPassword(listEt.get(4).getText().toString());
        return sf;
    }



}
