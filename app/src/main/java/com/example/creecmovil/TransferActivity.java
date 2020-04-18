package com.example.creecmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TransferActivity extends AppCompatActivity {

    ImageButton imgb_menu, imgb_bus1, img_udp1, img_bus2, img_udp2;

    EditText edbus, edmisal, edbus2, edmisal2;

    TextView mitarj, misal, resmisaldo, mitarj2, misal2, resmisaldo2, tvfecha, tvemail, tvsubj;

    Button busbd, autbtn, btnupd, busbd2, autbtn2, btnupd2, btnacept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        //fecha
        Calendar calendar = Calendar.getInstance();
        //simple
        //String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        //corta
        String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());
        //larga
        //String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        tvfecha = (TextView) findViewById(R.id.tv_fecha);
        tvfecha.setText(currentDate);

        imgb_menu = (ImageButton) findViewById(R.id.imgb_inicio4);

        imgb_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(TransferActivity.this, MenuActivity.class));

            }
        });
        //selec info de mi cuenta
        edbus = (EditText) findViewById(R.id.txt_buscar);
        mitarj = (TextView) findViewById(R.id.tv_mi_num_tar);
        misal = (TextView) findViewById(R.id.tv_mi_saldo);
        //busbd = (Button) findViewById(R.id.btn_buscar);

        imgb_bus1 = (ImageButton) findViewById(R.id.imgBus1);

        edmisal = (EditText) findViewById(R.id.txt_resaldo);
        resmisaldo = (TextView) findViewById(R.id.tv_restar_sal);
        //autbtn = (Button) findViewById(R.id.btn_restar);
        //btnupd = (Button) findViewById(R.id.btn_upd);

        //select
        edbus2 = (EditText) findViewById(R.id.txt_bus4);
        mitarj2 = (TextView) findViewById(R.id.tv_mi_num_tar4);
        misal2 = (TextView) findViewById(R.id.tv_mi_saldo4);
        //busbd2 = (Button) findViewById(R.id.btn_bus4);
        img_bus2 = (ImageButton) findViewById(R.id.imgBus2);

        //update
        //edmisal2 = (EditText) findViewById(R.id.txt_resaldo4);
        resmisaldo2 = (TextView) findViewById(R.id.tv_restar_sal4);
        //autbtn2 = (Button) findViewById(R.id.btn_restar4);
        //btnupd2 = (Button) findViewById(R.id.btn_upd4);
        btnacept = (Button) findViewById(R.id.btn_aceptrans);
        img_udp2 = (ImageButton) findViewById(R.id.imgb_upd2);

        img_udp1 = (ImageButton) findViewById(R.id.imgb_upd1);

        //correo
        tvemail = (TextView) findViewById(R.id.tv_correo);
        tvsubj = (TextView) findViewById(R.id.tv_subject);

        /*busbd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarmiinfodos("http://192.168.100.2/appcreec/cuedos/buscar_pro.php?no_tarinc="+edbus2.getText()+"");
            }
        }); */

        img_bus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buscarmiinfodos("http://192.168.100.2/appcreec/cuedos/buscar_pro.php?no_tarinc="+edbus2.getText()+"");
                buscarmiinfodos("https://c17ru5pr0y.000webhostapp.com/appcreec/cuedos/buscar_pro.php?no_tarinc="+edbus2.getText()+"");
            }
        });

       /* busbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buscarmiinfo("https://c17ru5pr0y.000webhostapp.com/appcreec/cuedos/buscar_pro.php?no_tarinc="+edbus.getText()+"");

                buscarmiinfo("http://192.168.100.2/appcreec/cuedos/buscar_pro.php?no_tarinc="+edbus.getText()+"");
            }
        }); */

        imgb_bus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarmiinfo("https://c17ru5pr0y.000webhostapp.com/appcreec/cuedos/buscar_pro.php?no_tarinc="+edbus.getText()+"");

                //buscarmiinfo("http://192.168.100.2/appcreec/cuedos/buscar_pro.php?no_tarinc="+edbus.getText()+"");
            }
        });


        /*autbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sal1 = Integer.valueOf(misal.getText().toString());
                int sal2 = Integer.valueOf(edmisal.getText().toString());
                int resultado = sal1 - sal2;
                resmisaldo.setText(""+resultado);
            }
        }); */

        edmisal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int sal1 = Integer.valueOf(misal.getText().toString());
                int sal2 = Integer.valueOf(edmisal.getText().toString());
                int resultado = sal1 - sal2;
                resmisaldo.setText(""+resultado);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

       /* autbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sal1 = Integer.valueOf(misal2.getText().toString());
                int sal2 = Integer.valueOf(edmisal2.getText().toString());
                int resultado = sal1 + sal2;
                resmisaldo2.setText(""+resultado);
            }
        }); */

       /* edmisal2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int sal1 = Integer.valueOf(misal2.getText().toString());
                int sal2 = Integer.valueOf(edmisal2.getText().toString());
                int resultado = sal1 + sal2;
                resmisaldo2.setText(""+resultado);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        }); */

        misal2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int sal1 = Integer.valueOf(misal2.getText().toString());
                int sal2 = Integer.valueOf(edmisal.getText().toString());
                int resultado = sal1 + sal2;
                resmisaldo2.setText(""+resultado);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        img_udp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ejecutarServiciodos("http://192.168.100.2/appcreec/updacre.php");
                ejecutarServiciodos("https://c17ru5pr0y.000webhostapp.com/appcreec/updacre.php");
            }
        });

        /*btnupd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("http://192.168.100.2/appcreec/updacre.php");
                //ejecutarServicio("http://192.168.100.2/appcreec/Register.php");
            }
        }); */

        img_udp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ejecutarServicio("http://192.168.100.2/appcreec/updacre.php");
                ejecutarServicio("https://c17ru5pr0y.000webhostapp.com/appcreec/updacre.php");
            }
        });

        btnacept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //transserv("http://192.168.100.2/appcreec/Register.php");
                sendMail();
                transserv("https://c17ru5pr0y.000webhostapp.com/appcreec/inserapp.php");
                startActivity(new Intent(TransferActivity.this, MenuActivity.class));

            }
        });



    }

    private void buscarmiinfo(String URL) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        mitarj.setText(jsonObject.getString("id_no_cuenta"));
                        mitarj.setText(jsonObject.getString("no_tarje"));
                        misal.setText(jsonObject.getString("cli_saldo"));
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

    private void buscarmiinfodos(String URL) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        mitarj2.setText(jsonObject.getString("id_no_cuenta"));
                        mitarj2.setText(jsonObject.getString("no_tarje"));
                        misal2.setText(jsonObject.getString("cli_saldo"));
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

    private void ejecutarServicio(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "CAPTURADO", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext(), "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<>();
                parametros.put("no_tarinc", edbus.getText().toString());
                parametros.put("cli_saldo", resmisaldo.getText().toString());

                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void ejecutarServiciodos(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "CAPTURADO", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext(), "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<>();
                parametros.put("no_tarinc", edbus2.getText().toString());
                parametros.put("cli_saldo", resmisaldo2.getText().toString());

                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void transserv(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERACION EXITOSA", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext(), "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<>();
                parametros.put("no_tarje", mitarj.getText().toString());
                parametros.put("monto_enviar", edmisal.getText().toString());
                parametros.put("tarj_enviar", mitarj2.getText().toString());
                parametros.put("fecha_trans", tvfecha.getText().toString());

                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void sendMail() {

        String mail = tvemail.getText().toString().trim();
        String message = edbus.getText().toString();
        String subject = tvsubj.getText().toString().trim();

        //Send Mail
        JavaMailAPI javaMailAPI = new JavaMailAPI(this,mail,subject,message);

        javaMailAPI.execute();

    }
}
