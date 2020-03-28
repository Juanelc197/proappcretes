package com.example.creecmovil;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.net.URL;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText txtemail, txtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtemail = (EditText) findViewById(R.id.txt_email);
        txtpass = (EditText) findViewById(R.id.txt_pass);

        btn = (Button) findViewById(R.id.btn_prueba);

      /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, UserActivity.class));

            }
        }); */

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email_cli = txtemail.getText().toString();
                final String pass_cli = txtpass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success) {
                                String nombres_cli = jsonResponse.getString("nombres_cli");
                                //int age = jsonResponse.getInt("age");
                                int id_cli = jsonResponse.getInt("id_cli");

                                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                                intent.putExtra("id_cli", id_cli);
                                intent.putExtra("nombres_cli", nombres_cli);
                                intent.putExtra("email_cli", email_cli);
                                //intent.putExtra("age", age);
                                intent.putExtra("pass_cli", pass_cli);

                                MainActivity.this.startActivity(intent);

                            }else {
                                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("error logiun")
                                        .setNegativeButton("Retry", null)
                                        .create().show(); */
                                Toast.makeText(MainActivity.this, "campos vacios no", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(email_cli, pass_cli,responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);
            }
        });
    }

}