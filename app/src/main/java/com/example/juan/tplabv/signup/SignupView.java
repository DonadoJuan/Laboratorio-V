package com.example.juan.tplabv.signup;


import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.juan.tplabv.R;

import java.util.ArrayList;
import java.util.List;

public class SignupView implements ISignupView {

    private List<EditText> editTextList = new ArrayList<>();
    private Button signup;
    private ISignupController isc;
    private Context con;

    public SignupView(Activity act){
        con = act;
        editTextList.add((EditText)act.findViewById(R.id.signup_etxt_name));
        editTextList.add((EditText)act.findViewById(R.id.signup_etxt_Lastname));
        editTextList.add((EditText)act.findViewById(R.id.signup_etxt_email));
        editTextList.add((EditText)act.findViewById(R.id.signup_etxt_dni));
        editTextList.add((EditText)act.findViewById(R.id.signup_etxt_password));
        editTextList.add((EditText)act.findViewById(R.id.signup_etxt_rpassword));
        signup = (Button)act.findViewById(R.id.signup_btn_signup);
        signup.setOnClickListener(signupListener);

    }

    public List<EditText> getEditTextList(){
        return editTextList;
    }

    @Override
    public void setISignupController(ISignupController iSignupController) {
        isc = iSignupController;
    }

    private View.OnClickListener signupListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            isc.doSignup(editTextList);
        }
    };

    @Override
    public void setEmptyInputError(EditText et, boolean activate){
        if(activate)
            et.setError(con.getString(R.string.emptyFormError));
        else
            et.setError(null);
    }

    @Override
    public void setInvalidEmailError(boolean activate){
        if(activate)
            editTextList.get(2).setError(con.getString(R.string.emailFormError));
        else
            editTextList.get(2).setError(null);
    }

    @Override
    public void setInvalidPasswordError(boolean activate){
        if(activate)
            editTextList.get(4).setError(con.getString(R.string.passwordMatchFormError));
        else
            editTextList.get(4).setError(null);
    }

    @Override
    public void resetAllError(){
        for (EditText input : editTextList) {
            input.setError(null);
        }
    }

    @Override
    public void showUserAlreadyExistsError(){
        Toast.makeText(con, con.getString(R.string.userAlreadyExistsError), Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext(){
        return con;
    }

}
