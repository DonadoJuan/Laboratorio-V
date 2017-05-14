package com.example.juan.tplabv.mainActivity;

import android.content.Context;

public interface IMainView {

    void setIMainController(IMainController imc);
    void setEmptyPasswordError(boolean bo);
    void setEmptyEmailError(boolean bo);
    void setInvalidEmailError(boolean bo);
    void showErrorToast();
    Context getContext();

}
