package com.example.juan.tplabv.signup;

import com.example.juan.tplabv.dao.BuffetDAO;
import com.example.juan.tplabv.dao.BuffetUser;

public class SignupModel implements ISignupModel{

    private BuffetDAO buffetDAO ;

    public SignupModel(){
            buffetDAO = new BuffetDAO();
    }

    @Override
    public boolean trySignup(BuffetUser newUser){

        return buffetDAO.insertBuffetUser(newUser);
    }

}
