package com.example.creecmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    ImageButton imgbuser, imgbsocial, imgbcontacto, imgbtransfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imgbuser = (ImageButton) findViewById(R.id.imgb_inicio);

        imgbuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MenuActivity.this, UserActivity.class));

            }
        });

        imgbsocial = (ImageButton) findViewById(R.id.imgb_social);

        imgbsocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MenuActivity.this, SocialActivity.class));

            }
        });

        imgbcontacto = (ImageButton) findViewById(R.id.imgb_contacto);

        imgbcontacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MenuActivity.this, ActivityContacto.class));

            }
        });

        imgbtransfer = (ImageButton) findViewById(R.id.imgb_transfer);

        imgbtransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MenuActivity.this, TransferActivity.class));

            }
        });
    }
}
