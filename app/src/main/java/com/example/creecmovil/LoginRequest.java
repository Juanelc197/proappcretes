package com.example.creecmovil;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    //private static final String LOGIN_REQUEST_URL="http://192.168.100.2/appcreec/Login.php";
    private static final String LOGIN_REQUEST_URL="https://c17ru5pr0y.000webhostapp.com/appcreec/Login.php";
    private Map<String,String> params;
    public LoginRequest (String email_cli, String pass_cli, Response.Listener<String> listener) {
        super(Request.Method.POST, LOGIN_REQUEST_URL,listener, null);
        params = new HashMap<>();
        params.put("email_cli", email_cli);
        params.put("pass_cli", pass_cli);
    }
    @Override
    public Map<String, String> getParams() {return params; }

}
