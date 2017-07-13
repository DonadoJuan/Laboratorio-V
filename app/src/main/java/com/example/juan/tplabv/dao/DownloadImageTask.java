package com.example.juan.tplabv.dao;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import java.io.InputStream;
import java.net.URL;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    ImageView bmImage;
    BuffetMenuItem bfItem;

    public DownloadImageTask(BuffetMenuItem bfItem,ImageView bmImage) {
        this.bmImage = bmImage;
        this.bfItem = bfItem;
    }

    protected Bitmap doInBackground(String... urls) {
        String imgUrl = bfItem.getImgUrl();
        Bitmap imgBitmap = null;
        try {
            InputStream in = new URL(imgUrl).openStream();
            imgBitmap = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("ERROR LOADING IMG", e.getMessage());
        }
        return imgBitmap;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
        bfItem.setImgBitmap(result);
    }
}
