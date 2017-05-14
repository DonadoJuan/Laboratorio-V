package com.example.juan.tplabv.signupActivity;

import android.widget.EditText;

import java.util.List;

public class SignupModel implements ISignupModel{

    private SignupForm sf;

    @Override
    public boolean trySignup(SignupForm et) {
        //try insert to DB
        return true;
    }

}
