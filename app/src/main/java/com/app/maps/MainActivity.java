package com.app.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.adedom.library.Dru;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_simple_maps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Simple2mapActivity.class));
            }
        });

        findViewById(R.id.bt_orther_maps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),BasicMapActivity.class));
            }
        });

        findViewById(R.id.bt_location_maps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),LocationActivity.class));
            }
        });

        findViewById(R.id.bt_map_db).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),MapDBActivity.class));
            }
        });

        if (ConnectDB.getConnection() == null) {
            Dru.failed(getBaseContext());
        } else {
            Dru.completed(getBaseContext());
        }
    }
}