package com.example.juan.tplabv;

import android.app.Activity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainView{

    private List<EditText> editTextList = new ArrayList<>();
    private Button login;
    private Button signup;
    private ImageView mainImg;
    private Activity actualActivity;

    public MainView(Activity act){

        actualActivity = act;
        editTextList.add((EditText) act.findViewById(R.id.etxtEmail));
        editTextList.add((EditText) act.findViewById(R.id.etxtPassword));
        login = (Button) act.findViewById(R.id.btnLogin);
        signup = (Button) act.findViewById(R.id.btnSignup);
        mainImg = (ImageView) act.findViewById(R.id.mainImgView);
    }

    public void setLoginOnClickListener(View.OnClickListener ocl){
        login.setOnClickListener(ocl);
    }

    public void setSignupOnClickListener(View.OnClickListener ocl){
        signup.setOnClickListener(ocl);
    }


    public void setTextEditError(EditText editText){
        editText.setError(actualActivity.getString(R.string.emptyFormError));
    }

    public List<EditText> getEditTextList() {
            return editTextList;
    }


    public Button getLogin() {
        return login;
    }

    public Button getSignup() {
        return signup;
    }

    public ImageView getMainImg() {
        return mainImg;
    }

    public Activity getActualActivity(){
        return actualActivity;
    }


}
