package com.example.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    EditText edt1,edt2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    edt1=findViewById(R.id.e1);
    edt2=findViewById(R.id.e2);
    btn1=findViewById(R.id.b1);

    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            final String username=edt1.getText().toString();
            final String mail=edt2.getText().toString();


            StringRequest stringRequest= new StringRequest(Request.Method.POST, "https://ankitgoswami1818.000webhostapp.com/database/request.php?", new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {
                    if (response.trim().equals("0")) {


                        Toast.makeText(MainActivity.this, "no found", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {


                        Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {


                    Toast.makeText(MainActivity.this, "No Internet", Toast.LENGTH_SHORT).show();

                }
            })
           {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    HashMap map=new HashMap();
                    map.put("name",username);
                    map.put("email",mail);

                    return map;
                }
            };
            RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
            queue.add(stringRequest);

        }
    });



    }
}
