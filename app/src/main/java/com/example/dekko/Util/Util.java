package com.example.dekko.Util;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;

import com.example.dekko.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

public class Util {
    public static JSONObject filetoJson(int file, Fragment fragment) {
        try {
            Resources res = fragment.getResources();
            InputStream in_s = res.openRawResource(file);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String strData = new String(b);
            return  new JSONObject(strData);
        } catch (Exception e) {
            return null;
        }
    }
}
