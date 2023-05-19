package com.example.chesssymulation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class PrepareActivity extends AppCompatActivity {

    Button btn_startSymulation;
    ImageButton btn_A1, btn_A2, btn_A3, btn_A4, btn_A5, btn_A6, btn_A7, btn_A8;
    ImageButton btn_B1, btn_B2, btn_B3, btn_B4, btn_B5, btn_B6, btn_B7, btn_B8;
    ImageButton btn_C1, btn_C2, btn_C3, btn_C4, btn_C5, btn_C6, btn_C7, btn_C8;
    ImageButton btn_D1, btn_D2, btn_D3, btn_D4, btn_D5, btn_D6, btn_D7, btn_D8;
    ImageButton btn_E1, btn_E2, btn_E3, btn_E4, btn_E5, btn_E6, btn_E7, btn_E8;
    ImageButton btn_F1, btn_F2, btn_F3, btn_F4, btn_F5, btn_F6, btn_F7, btn_F8;
    ImageButton btn_G1, btn_G2, btn_G3, btn_G4, btn_G5, btn_G6, btn_G7, btn_G8;
    ImageButton btn_H1, btn_H2, btn_H3, btn_H4, btn_H5, btn_H6, btn_H7, btn_H8;

    ImageButton[][] buttons;
    ArrayList<ArrayList<ImageButton>> board;

    ImageButton clicked = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare);

        {
            btn_startSymulation = findViewById(R.id.btn_startSymulation);
            btn_A1 = findViewById(R.id.btn_a1);
            btn_B1 = findViewById(R.id.btn_b1);
            btn_C1 = findViewById(R.id.btn_c1);
            btn_D1 = findViewById(R.id.btn_d1);
            btn_E1 = findViewById(R.id.btn_e1);
            btn_F1 = findViewById(R.id.btn_f1);
            btn_G1 = findViewById(R.id.btn_g1);
            btn_H1 = findViewById(R.id.btn_h1);
            btn_A2 = findViewById(R.id.btn_a2);
            btn_B2 = findViewById(R.id.btn_b2);
            btn_C2 = findViewById(R.id.btn_c2);
            btn_D2 = findViewById(R.id.btn_d2);
            btn_E2 = findViewById(R.id.btn_e2);
            btn_F2 = findViewById(R.id.btn_f2);
            btn_G2 = findViewById(R.id.btn_g2);
            btn_H2 = findViewById(R.id.btn_h2);
            btn_A3 = findViewById(R.id.btn_a3);
            btn_B3 = findViewById(R.id.btn_b3);
            btn_C3 = findViewById(R.id.btn_c3);
            btn_D3 = findViewById(R.id.btn_d3);
            btn_E3 = findViewById(R.id.btn_e3);
            btn_F3 = findViewById(R.id.btn_f3);
            btn_G3 = findViewById(R.id.btn_g3);
            btn_H3 = findViewById(R.id.btn_h3);
            btn_A4 = findViewById(R.id.btn_a4);
            btn_B4 = findViewById(R.id.btn_b4);
            btn_C4 = findViewById(R.id.btn_c4);
            btn_D4 = findViewById(R.id.btn_d4);
            btn_E4 = findViewById(R.id.btn_e4);
            btn_F4 = findViewById(R.id.btn_f4);
            btn_G4 = findViewById(R.id.btn_g4);
            btn_H4 = findViewById(R.id.btn_h4);
            btn_A5 = findViewById(R.id.btn_a5);
            btn_B5 = findViewById(R.id.btn_b5);
            btn_C5 = findViewById(R.id.btn_c5);
            btn_D5 = findViewById(R.id.btn_d5);
            btn_E5 = findViewById(R.id.btn_e5);
            btn_F5 = findViewById(R.id.btn_f5);
            btn_G5 = findViewById(R.id.btn_g5);
            btn_H5 = findViewById(R.id.btn_h5);
            btn_A6 = findViewById(R.id.btn_a6);
            btn_B6 = findViewById(R.id.btn_b6);
            btn_C6 = findViewById(R.id.btn_c6);
            btn_D6 = findViewById(R.id.btn_d6);
            btn_E6 = findViewById(R.id.btn_e6);
            btn_F6 = findViewById(R.id.btn_f6);
            btn_G6 = findViewById(R.id.btn_g6);
            btn_H6 = findViewById(R.id.btn_h6);
            btn_A7 = findViewById(R.id.btn_a7);
            btn_B7 = findViewById(R.id.btn_b7);
            btn_C7 = findViewById(R.id.btn_c7);
            btn_D7 = findViewById(R.id.btn_d7);
            btn_E7 = findViewById(R.id.btn_e7);
            btn_F7 = findViewById(R.id.btn_f7);
            btn_G7 = findViewById(R.id.btn_g7);
            btn_H7 = findViewById(R.id.btn_h7);
            btn_A8 = findViewById(R.id.btn_a8);
            btn_B8 = findViewById(R.id.btn_b8);
            btn_C8 = findViewById(R.id.btn_c8);
            btn_D8 = findViewById(R.id.btn_d8);
            btn_E8 = findViewById(R.id.btn_e8);
            btn_F8 = findViewById(R.id.btn_f8);
            btn_G8 = findViewById(R.id.btn_g8);
            btn_H8 = findViewById(R.id.btn_h8);
        }

        buttons = new ImageButton[][]{{btn_A1, btn_A2, btn_A3, btn_A4, btn_A5, btn_A6, btn_A7, btn_A8},
                {btn_B1, btn_B2, btn_B3, btn_B4, btn_B5, btn_B6, btn_B7, btn_B8},
                {btn_C1, btn_C2, btn_C3, btn_C4, btn_C5, btn_C6, btn_C7, btn_C8},
                {btn_D1, btn_D2, btn_D3, btn_D4, btn_D5, btn_D6, btn_D7, btn_D8},
                {btn_E1, btn_E2, btn_E3, btn_E4, btn_E5, btn_E6, btn_E7, btn_E8},
                {btn_F1, btn_F2, btn_F3, btn_F4, btn_F5, btn_F6, btn_F7, btn_F8},
                {btn_G1, btn_G2, btn_G3, btn_G4, btn_G5, btn_G6, btn_G7, btn_G8},
                {btn_H1, btn_H2, btn_H3, btn_H4, btn_H5, btn_H6, btn_H7, btn_H8}};

        board = new ArrayList<ArrayList<ImageButton>>();
        for(ImageButton[] row : buttons)
        {
            ArrayList<ImageButton> one_row = new ArrayList<>();
            for(ImageButton square : row)
            {
                one_row.add(square);
                square.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(clicked != null)
                        {
                            int x = 0, y = 0;
                            for(ArrayList<ImageButton> row : board)
                            {
                                for(ImageButton square : row)
                                {
                                    if(clicked.equals(square))
                                    {
                                        y = row.indexOf(clicked);
                                        x = board.indexOf(row);
                                    }
                                }
                            }

                            if((x + y) % 2 == 0)
                                clicked.getBackground().setTint(getResources().getColor(R.color.chess_black));
                            else
                                clicked.getBackground().setTint(getResources().getColor(R.color.chess_white));
                        }
                        clicked = square;
                        clicked.getBackground().setTint(getResources().getColor(R.color.chess_clicked));
                    }
                });
            }
            board.add(one_row);
        }
        /*
        {
            btn_A1.setOnClickListener(onClickListener);
            btn_A2.setOnClickListener(onClickListener);
            btn_A3.setOnClickListener(onClickListener);
            btn_A4.setOnClickListener(onClickListener);
            btn_A5.setOnClickListener(onClickListener);
            btn_A6.setOnClickListener(onClickListener);
            btn_A7.setOnClickListener(onClickListener);
            btn_A8.setOnClickListener(onClickListener);
            btn_B1.setOnClickListener(onClickListener);
            btn_B2.setOnClickListener(onClickListener);
            btn_B3.setOnClickListener(onClickListener);
            btn_B4.setOnClickListener(onClickListener);
            btn_B5.setOnClickListener(onClickListener);
            btn_B6.setOnClickListener(onClickListener);
            btn_B7.setOnClickListener(onClickListener);
            btn_B8.setOnClickListener(onClickListener);
            btn_C1.setOnClickListener(onClickListener);
            btn_C2.setOnClickListener(onClickListener);
            btn_C3.setOnClickListener(onClickListener);
            btn_C4.setOnClickListener(onClickListener);
            btn_C5.setOnClickListener(onClickListener);
            btn_C6.setOnClickListener(onClickListener);
            btn_C7.setOnClickListener(onClickListener);
            btn_C8.setOnClickListener(onClickListener);
            btn_D1.setOnClickListener(onClickListener);
            btn_D2.setOnClickListener(onClickListener);
            btn_D3.setOnClickListener(onClickListener);
            btn_D4.setOnClickListener(onClickListener);
            btn_D5.setOnClickListener(onClickListener);
            btn_D6.setOnClickListener(onClickListener);
            btn_D7.setOnClickListener(onClickListener);
            btn_D8.setOnClickListener(onClickListener);
            btn_E1.setOnClickListener(onClickListener);
            btn_E2.setOnClickListener(onClickListener);
            btn_E3.setOnClickListener(onClickListener);
            btn_E4.setOnClickListener(onClickListener);
            btn_E5.setOnClickListener(onClickListener);
            btn_E6.setOnClickListener(onClickListener);
            btn_E7.setOnClickListener(onClickListener);
            btn_E8.setOnClickListener(onClickListener);
            btn_F1.setOnClickListener(onClickListener);
            btn_F2.setOnClickListener(onClickListener);
            btn_F3.setOnClickListener(onClickListener);
            btn_F4.setOnClickListener(onClickListener);
            btn_F5.setOnClickListener(onClickListener);
            btn_F6.setOnClickListener(onClickListener);
            btn_F7.setOnClickListener(onClickListener);
            btn_F8.setOnClickListener(onClickListener);
            btn_G1.setOnClickListener(onClickListener);
            btn_G2.setOnClickListener(onClickListener);
            btn_G3.setOnClickListener(onClickListener);
            btn_G4.setOnClickListener(onClickListener);
            btn_G5.setOnClickListener(onClickListener);
            btn_G6.setOnClickListener(onClickListener);
            btn_G7.setOnClickListener(onClickListener);
            btn_G8.setOnClickListener(onClickListener);
            btn_H1.setOnClickListener(onClickListener);
            btn_H2.setOnClickListener(onClickListener);
            btn_H3.setOnClickListener(onClickListener);
            btn_H4.setOnClickListener(onClickListener);
            btn_H5.setOnClickListener(onClickListener);
            btn_H6.setOnClickListener(onClickListener);
            btn_H7.setOnClickListener(onClickListener);
            btn_H8.setOnClickListener(onClickListener);
        }
        */
        btn_startSymulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrepareActivity.this, SymulationActivity.class);
                startActivity(intent);
            }
        });
    }
}