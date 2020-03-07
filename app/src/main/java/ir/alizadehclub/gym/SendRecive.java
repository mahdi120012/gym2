package ir.alizadehclub.gym;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

public class SendRecive {
    Context c;
    public void login(final Context c, final String mobile, final String password){
        this.c = c;

        final String url = "http://alizadehclub.ir/login/checkUserMobile?mobile="+mobile+"&password="+password;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.toString().matches("1")){

                            //// To Save a value
                            SharedPrefrencesClass sharedPrefrencesClass = new SharedPrefrencesClass(c);
                            sharedPrefrencesClass.setUserProfile("phone_number",mobile);
                            sharedPrefrencesClass.setUserProfile("password", password);

                            Intent intent = new Intent(c, MainUserProfile.class);
                            c.startActivity(intent);



                        }else {
                            Toast.makeText(c, "شماره همراه یا رمز عبور اشتباه است", Toast.LENGTH_SHORT).show();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(c, "دسترسی به اینترنت موجود نیست!", Toast.LENGTH_SHORT).show();
            }
        });

        MySingleton.getInstance(c).addToRequestQueue(stringRequest);

    }
}
