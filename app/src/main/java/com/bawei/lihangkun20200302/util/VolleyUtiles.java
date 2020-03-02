package com.bawei.lihangkun20200302.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.lihangkun20200302.base.App;

import java.io.UnsupportedEncodingException;

public class VolleyUtiles {
    RequestQueue mRequestQueue;
    public VolleyUtiles(){
        mRequestQueue= Volley.newRequestQueue(App.getContext());
    }
    public static class SingleInstance{
        public static VolleyUtiles INSTANCE=new VolleyUtiles();
    }
    public static VolleyUtiles getInstance(){
        return SingleInstance.INSTANCE;
    }
    public interface CallBackJson{
        void succ(String json);
        void faiuld(String json);
    }
    public boolean getNetWork(Context context){
       ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if(activeNetworkInfo!=null){
             return true;
        }else{
            return false;
        }
    }
    public void getDoGet(String url, final CallBackJson callBackJson){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBackJson.succ(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBackJson.faiuld(error.getMessage());
            }
        }){
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String a;
                try {
                    a=new String(response.data,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    a=new String(response.data);
                }
                return Response.success(a,HttpHeaderParser.parseCacheHeaders(response));
            }
        };
        mRequestQueue.add(stringRequest);
    }
}
