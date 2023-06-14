package com.example.chesssymulation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GameRecordActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> moves;
    GameRecordAdapter gameRecordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_record);

        recyclerView = findViewById(R.id.rv_gameRecord);
        moves = (ArrayList<String>) getIntent().getSerializableExtra("moves");

        gameRecordAdapter = new GameRecordAdapter(this, this, moves);
        recyclerView.setAdapter(gameRecordAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}