package com.example.juan.tplabv.signupActivity;

import android.widget.EditText;

import com.example.juan.tplabv.mainActivity.IMainController;

/**
 * Created by Juan on 5/14/2017.
 */

public interface ISignupView{

    void setISignupController(ISignupController isc);
    void setEmptyInputError(EditText et, boolean activate);
    void resetAllError();
    void setInvalidPasswordError(boolean activate);
    void setInvalidEmailError(boolean activate);

}
