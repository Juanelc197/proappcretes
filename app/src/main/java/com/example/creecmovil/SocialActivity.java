package com.example.creecmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SocialActivity extends AppCompatActivity {

    ImageButton imgb_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        imgb_menu = (ImageButton) findViewById(R.id.imgb_inicio3);

        imgb_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SocialActivity.this, MenuActivity.class));

            }
        });
    }
}
