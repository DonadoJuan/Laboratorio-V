package com.example.juan.tplabv.mainActivity;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.juan.tplabv.R;
import com.example.juan.tplabv.util.FormValidator;

import java.util.ArrayList;
import java.util.List;

public class MainView implements IMainView{

    private EditText email;
    private EditText password;
    private Button login;
    private Button signup;
    private ImageView mainImg;
    private IMainController IMainCon;
    private Context con;

    public MainView(Activity act){
        con = act;
        email = (EditText) act.findViewById(R.id.main_etxt_email);
        password = (EditText) act.findViewById(R.id.main_etxt_password);
        login = (Button) act.findViewById(R.id.main_btn_login);
        signup = (Button) act.findViewById(R.id.main_btn_signup);
        login.setOnClickListener(loginListener);
        signup.setOnClickListener(signupListener);
    }


    private View.OnClickListener loginListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            IMainCon.doLogin(email,password);
        }
    };

    private View.OnClickListener signupListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            IMainCon.goSignup();
        }
    };

    @Override
    public void setIMainController(IMainController imc) {
        IMainCon = imc;
    }

    @Override
    public Context getContext(){ return con;}

    @Override
    public void setEmptyEmailError(boolean activate){
        if(activate)
            email.setError(con.getString(R.string.emptyFormError));
        else
            email.setError(null);
    }

    @Override
    public void setInvalidEmailError(boolean activate){
        if(activate)
            email.setError(con.getString(R.string.emailFormError));
        else
            email.setError(null);
    }

    @Override
    public void setEmptyPasswordError(boolean activate){
        if(activate)
            password.setError(con.getString(R.string.emptyFormError));
        else
            password.setError(null);
    }

    @Override
    public void showErrorToast(){
        Toast.makeText(con, con.getString(R.string.loginAccessError), Toast.LENGTH_SHORT).show();
    }



}
