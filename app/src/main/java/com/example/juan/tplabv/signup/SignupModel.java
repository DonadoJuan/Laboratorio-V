package com.example.juan.tplabv.signup;

import com.example.juan.tplabv.dao.BuffetDAO;
import com.example.juan.tplabv.dao.BuffetUser;

public class SignupModel implements ISignupModel{


    public SignupModel(){
    }

    @Override
    public boolean trySignup(BuffetUser newUser){

        return BuffetDAO.insertBuffetUser(newUser);
    }

}
