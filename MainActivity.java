package com.example.tops.jsoninsert;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextUsername;
    EditText editTextEmail;
    EditText editTextPassword;
    ProgressDialog pd;

    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextEmail= (EditText) findViewById(R.id.editTextEmail);
        pd = new ProgressDialog(this);
        pd.setMessage("please wait...");


        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonRegister){
            pd.show();

           final String username = editTextUsername.getText().toString().trim();
           final String password = editTextPassword.getText().toString().trim();
           final String email = editTextEmail.getText().toString().trim();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://prakrutivyas.000webhostapp.com/regserver/volleyRegister.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    pd.hide();
                    Toast.makeText(MainActivity.this,"registration done",Toast.LENGTH_LONG).show();

                    Intent i =new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(i);


                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            pd.hide();
                            Toast.makeText(MainActivity.this,"registration fail",Toast.LENGTH_LONG).show();
                        }
                    }){
                @Override
                protected Map<String,String> getParams(){
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("username",username);
                    params.put("password",password);
                    params.put("email", email);
                    return params;
                }



            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);



        }
    }
}