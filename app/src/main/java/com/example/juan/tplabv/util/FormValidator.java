package com.example.juan.tplabv.util;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.example.juan.tplabv.R;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FormValidator {

    static public boolean validateEmail(EditText emailAddress){

        String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = emailAddress.getText();
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        return matcher.matches();
    }

    static public boolean validateEmpty(EditText et) {

        boolean success = true;
        if (TextUtils.isEmpty(et.getText().toString())) {
            success = false;

        }
        return success;
    }

    static public boolean validatePassword(EditText pass, EditText rPass) {
        if (pass.getText().toString().equals(rPass.getText().toString())) {
            return true;
        } else {
            return false;
        }
    }
}

