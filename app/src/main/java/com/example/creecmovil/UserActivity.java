package com.example.creecmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserActivity extends AppCompatActivity {

    ImageButton imgbmenu, verbtn;

    TextView idtxt, nomtxt, saltxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        imgbmenu = (ImageButton) findViewById(R.id.imgb_menu);

        imgbmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(UserActivity.this, MenuActivity.class));

            }
        });

        idtxt = (TextView) findViewById(R.id.txt_id_cli);
        nomtxt = (TextView) findViewById(R.id.txt_nom_cli);

        saltxt = (TextView) findViewById(R.id.txt_sal);
        verbtn = (ImageButton) findViewById(R.id.btn_ver);

        verbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarproducto("https://c17ru5pr0y.000webhostapp.com/appcreec/bus/buscar_pro.php?cli_id="+idtxt.getText()+"");
            }
        });



        Intent intent = getIntent();
        int id_cli = intent.getIntExtra("id_cli", -1);
        String nombres_cli = intent.getStringExtra("nombres_cli");

        idtxt.setText(id_cli+"");
        nomtxt.setText(nombres_cli);

    }

    private void buscarproducto(String URL) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        saltxt.setText(jsonObject.getString("cli_saldo"));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }


}
