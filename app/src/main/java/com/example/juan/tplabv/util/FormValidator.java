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

        String expression = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
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

