package com.example.chesssymulation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Chess.GameRecord;

public class GamesActivity extends AppCompatActivity implements GamesInterface {

    RecyclerView recyclerView;
    DatabaseHelper myDB;
    ArrayList<GameRecord> games;
    GamesAdapter gamesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        recyclerView = findViewById(R.id.rv_games);

        myDB = new DatabaseHelper(GamesActivity.this);
        games = new ArrayList<>();

        try {
            storeDataInArrays();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        gamesAdapter = new GamesAdapter(this, this, games, this);
        recyclerView.setAdapter(gamesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(GamesActivity.this));
    }

    public void storeDataInArrays() throws JSONException {
        Cursor cursor = myDB.readAllData();
        while(cursor.moveToNext())
        {
            JSONObject jsonObject = new JSONObject(cursor.getString(1));
            JSONArray jsonArray = jsonObject.optJSONArray("moves");
            ArrayList<String> moves = new ArrayList<>();
            for(int i = 0; i < jsonArray.length(); i++)
            {
                moves.add(jsonArray.get(i).toString());
            }
            games.add(new GameRecord(cursor.getString(2), moves));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, GameRecordActivity.class);
        intent.putExtra("moves", games.get(position).getMoves());
        startActivity(intent);
    }

    @Override
    public void onBtnDeleteClick(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Usunąć zapis " + (position + 1) + "?");
        builder.setMessage("Czy na pewno usunąć zapis partii nr " + (position + 1) + "?");
        builder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DatabaseHelper myDB = new DatabaseHelper(GamesActivity.this);
                myDB.deleteRecord(String.valueOf(position + 1));
                recreate();
            }
        });
        builder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
}