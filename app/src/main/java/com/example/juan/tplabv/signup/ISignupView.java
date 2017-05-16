package com.example.juan.tplabv.signup;

import android.content.Context;
import android.widget.EditText;

/**
 * Created by Juan on 5/14/2017.
 */

public interface ISignupView{

    void setISignupController(ISignupController isc);
    Context getContext();
    void setEmptyInputError(EditText et, boolean activate);
    void resetAllError();
    void setInvalidPasswordError(boolean activate);
    void setInvalidEmailError(boolean activate);
    void showUserAlreadyExistsError();

}
