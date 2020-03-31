package com.example.creecmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ActivityContacto extends AppCompatActivity {

    ImageButton imgb_menu, imgb_con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        imgb_menu = (ImageButton) findViewById(R.id.imgb_inicio2);

        imgb_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ActivityContacto.this, MenuActivity.class));

            }
        });

        imgb_con = (ImageButton) findViewById(R.id.con_imgb);

        imgb_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.creectarjetaempresarial.com/contacto")));
            }
        });
    }
}
