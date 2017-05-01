package com.example.juan.tplabv;

import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ValidateForm {

    private static boolean validateEmailAddress(String emailAddress){
        String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = emailAddress;
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }

    private static boolean isEmail(EditText et){

        if(et.getInputType() == 33){
            return true;
        }else{
            return false;
        }
    }

    public static boolean validateAll(List<EditText> etList){

        boolean success = true;

        for (EditText et: etList) {
            if(TextUtils.isEmpty(et.getText().toString())) {
                et.setError(et.getContext().getString(R.string.emptyFormError));
                success = false;
                continue;
            }
            if(isEmail(et) && !validateEmailAddress(et.getText().toString()) ){
                success = false;
                et.setError("Not a valid email");
                continue;
            }
        }

        return success;
    }
}
