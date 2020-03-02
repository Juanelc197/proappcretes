package com.example.creecmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class UserActivity extends AppCompatActivity {

    ImageButton imgbmenu;

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

    }
}
