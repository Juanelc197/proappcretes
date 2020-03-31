package com.example.creecmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    ImageButton imgbuser, imgbsocial, imgbcontacto, imgbtransfer;

    Button btnsocial, btntransf, btncont, btnclouse;

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

        //img btn social
        /*imgbsocial = (ImageButton) findViewById(R.id.imgb_social);

        imgbsocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MenuActivity.this, SocialActivity.class));

            }
        }); */

        btnsocial = (Button) findViewById(R.id.btn_social);

        btnsocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MenuActivity.this, SocialActivity.class));

            }
        });
        // img btn contacto
        /*

        imgbcontacto = (ImageButton) findViewById(R.id.imgb_contacto);

        imgbcontacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MenuActivity.this, ActivityContacto.class));

            }
        }); */

        btncont = (Button) findViewById(R.id.btn_contacto);

        btncont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MenuActivity.this, ActivityContacto.class));

            }
        });

        //img btn transf
         /*

        imgbtransfer = (ImageButton) findViewById(R.id.imgb_transfer);



        imgbtransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MenuActivity.this, TransferActivity.class));

            }
        });

         */

        btntransf = (Button) findViewById(R.id.btn_transf);



        btntransf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MenuActivity.this, TransferActivity.class));

            }
        });

        btnclouse = (Button) findViewById(R.id.btn_cerrarapp);

        btnclouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();

                //finish();
                //System.exit(0);

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}
