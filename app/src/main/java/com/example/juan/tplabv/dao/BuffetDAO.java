package com.example.juan.tplabv.dao;

import android.os.AsyncTask;
import android.util.Log;

import com.example.juan.tplabv.util.BuffetUtil;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;

public class BuffetDAO{

    private static ArrayList<BuffetMenuItem> buffetMenuList = new ArrayList<>();
    private final static String API_BASE_ADRESS = "http://192.168.178.150:3000";

    public static boolean isBuffetUser(String email, String password){

        String[] taskParams = { API_BASE_ADRESS + "/usuarios/" + email + "/" + password, "GET"};
        try {
            JSONObject jo = (JSONObject) new APITask().execute(taskParams).get();
            if(jo.get("codigo").equals(200))
                return true;
            else
                return false;
        }catch(Exception e){
            Log.d("ERROR VALIDANDO USUARIO",e.getMessage());
            return false;
        }
    }

    public static boolean insertBuffetUser(BuffetUser newUser){

        try{
            String jsonData = BuffetUtil.BuffetUserToJson(newUser).toString();
            String[] taskParams = {API_BASE_ADRESS + "/usuarios/nuevo","POST",jsonData};
            JSONObject jo = (JSONObject) new APITask().execute(taskParams).get();

            if(jo.get("mensaje").equals("Se inserto correctamente"))
                return true;
            else
                throw new Exception("No hay mensaje positivo");

        }catch (Exception e) {
            Log.d("ERR INSERTANDO USUARIO", e.getMessage());
            return false;
        }
    }

    public static ArrayList<BuffetMenuItem> getBuffetMenuList(){
        if(!buffetMenuList.isEmpty())
            return buffetMenuList;

        try{
            String[] taskParams = {API_BASE_ADRESS + "/productos", "GET"};
            JSONArray ja = (JSONArray) new APITask().execute(taskParams).get();
            buffetMenuList = (ArrayList<BuffetMenuItem>)BuffetUtil.JSONArrayToBuffetMenuList(ja);
            return buffetMenuList;

        }catch(Exception e){
            Log.d("ERR PIDIENDO PRUDUCTOS", e.getMessage());
            return null;
        }
    }


    //Nested class

    public static class APITask extends AsyncTask<String, Void, Object>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(String... params){

            String urlStr = params[0];
            String reqMethod = params[1];
            String jsonData = null;
            HttpURLConnection urlConnection = null;
            URL url = null;
            Object obj = null;
            InputStream inStream = null;

            try{
                url = new URL(urlStr);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod(reqMethod);
                //urlConnection.connect();

                if(reqMethod.equals("POST")){
                    jsonData = params[2];
                    urlConnection.setDoOutput(true);
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setRequestProperty("Accept", "application/json");
                    Writer br = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
                    br.write(jsonData);
                    br.close();

                }

                inStream = urlConnection.getInputStream();
                BufferedReader bReader = new BufferedReader(new InputStreamReader(inStream));
                String temp, response = "";
                while ((temp = bReader.readLine()) != null)
                    response += temp;

                bReader.close();
                inStream.close();
                urlConnection.disconnect();

                obj = new JSONTokener(response).nextValue();
            }
            catch (Exception e){
                Log.d("ERROR",e.getMessage());
            }

            return obj;
        }

        @Override
        protected void onPostExecute(Object result){
            super.onPostExecute(result);
        }

    }

}
