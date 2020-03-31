package com.example.creecmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SocialActivity extends AppCompatActivity {

    ImageButton imgb_menu, imgbface, imgbtwit, imgblink, imgbwebc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        imgb_menu = (ImageButton) findViewById(R.id.imgb_inicio3);
        imgbface = (ImageButton) findViewById(R.id.imgb_face);
        imgbtwit = (ImageButton) findViewById(R.id.imgb_twit);
        imgblink = (ImageButton) findViewById(R.id.imgb_link);
        imgbwebc = (ImageButton) findViewById(R.id.imgb_webcrec);

        imgb_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SocialActivity.this, MenuActivity.class));

            }
        });

        imgbface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ConCreeC")));
            }
        });

        imgbtwit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ConCreeC")));
            }
        });

        imgblink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/creec-servicios-financieros/")));
            }
        });

        imgbwebc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.creectarjetaempresarial.com/")));
            }
        });
    }
}
