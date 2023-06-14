package com.example.chesssymulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        btn_database = findViewById(R.id.btn_database);

        btn_start.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PrepareActivity.class);
            startActivity(intent);
        });

        btn_database.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GamesActivity.class);
            startActivity(intent);
        });
    }
}