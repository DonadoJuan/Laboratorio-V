package com.example.juan.tplabv.login;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.juan.tplabv.R;

public class MainView implements IMainView{

    private EditText email;
    private EditText password;
    private Button login;
    private Button signup;
    private CheckBox remindme;
    private IMainController IMainCon;
    private Activity con;

    public MainView(Activity act){
        con = act;
        email = (EditText) act.findViewById(R.id.main_etxt_email);
        password = (EditText) act.findViewById(R.id.main_etxt_password);
        login = (Button) act.findViewById(R.id.main_btn_login);
        signup = (Button) act.findViewById(R.id.main_btn_signup);
        remindme = (CheckBox) act.findViewById(R.id.main_cbox_remind);
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
    public void finishMainActivity(){
        con.finish();
    }

    @Override
    public void setIMainController(IMainController imc) {
        IMainCon = imc;
    }

    @Override
    public Activity getContext(){ return con;}

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
    public void showLoginMatchError(){
        Toast.makeText(con, con.getString(R.string.loginAccessError), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isRemindMeChecked(){
        return remindme.isChecked();
    }



}
