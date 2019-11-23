package com.example.tops.jsoninsert;

/**
 * Created by Tops on 27-07-2017.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//it is Login Screen
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username, password;
    Button loginbtn;


    String Uname;
    String Pword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = (EditText) findViewById(R.id.uname);
        password = (EditText) findViewById(R.id.pass);
        loginbtn = (Button) findViewById(R.id.login);






        //click on Login Button
        loginbtn.setOnClickListener(this);
      //  changeDomain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {

        //Login Button IF()
        if (v==loginbtn)
        {

            //String Domain = sp.getString("Domain","");


            StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://prakrutivyas.000webhostapp.com/regserver/login.php?uname="+username.getText().toString()+"&pass=" + password.getText().toString(), new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {
                    if(response.trim().equals("0")){

                        Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_LONG).show();

                    }

                    else{

                        Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();

                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(LoginActivity.this, "No Internet", Toast.LENGTH_SHORT).show();
                }
            });
            RequestQueue rq = Volley.newRequestQueue(this);
            rq.add(stringRequest);
        }
        /*else
        {
            SharedPreferences sp = getSharedPreferences("Myfile", MODE_APPEND);
            SharedPreferences.Editor editor = sp.edit();
            editor.remove("IsFirst");
            editor.commit();

            Intent i2=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i2);
        }*/
        //finish();
    }
}