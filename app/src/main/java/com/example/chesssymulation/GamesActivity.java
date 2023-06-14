package com.example.chesssymulation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class GamesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GamesAdapter gamesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        recyclerView.findViewById(R.id.rv_games);
    }
}