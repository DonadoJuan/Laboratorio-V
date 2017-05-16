package com.example.juan.tplabv.login;

import android.content.Context;

public interface IMainView {

    void setIMainController(IMainController imc);
    void setEmptyPasswordError(boolean bo);
    void setEmptyEmailError(boolean bo);
    void setInvalidEmailError(boolean bo);
    void showLoginMatchError();
    boolean isRemindMeChecked();
    Context getContext();

}
