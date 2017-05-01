package com.example.juan.tplabv;

import android.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainController {

    private MainView mv;

    public MainController(MainView mainView){

        mv = mainView;
        mv.setLoginOnClickListener(loginOnClickListener);
        mv.setSignupOnClickListener(signupOnClickListener);

    }


    private OnClickListener loginOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if(ValidateForm.validateAll(mv.getEditTextList())){
                Toast.makeText(mv.getActualActivity(),"Exito",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(mv.getActualActivity(),"Error",Toast.LENGTH_SHORT).show();
            }

        }
    };

    private OnClickListener signupOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            // DO SIGN UP STUFF
        }
    };


}
