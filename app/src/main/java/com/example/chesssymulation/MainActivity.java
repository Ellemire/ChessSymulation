package com.example.chesssymulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

/**
 * Activity obsługujące ekran początkowy.
 */
public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_database;

    /** Metoda która określa co ma być wykonywane po naciśnięciu przycisków na ekranie początkowym
     * @param savedInstanceState
     */
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