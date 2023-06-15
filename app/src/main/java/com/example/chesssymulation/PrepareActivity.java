package com.example.chesssymulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

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
    ImageButton btn_wKing, btn_wQ, btn_wR, btn_wB, btn_wK, btn_wP, btn_delete;
    ImageButton btn_bKing, btn_bQ, btn_bR, btn_bB, btn_bK, btn_bP;

    ImageButton[][] buttons;
    ArrayList<ArrayList<ImageButton>> board;
    ArrayList<ImageButton> palette;

    ImageButton clicked;
    Boolean iswKing = true, isbKing = true;
    LinearLayout linearLayout;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare);

        //find view
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

            btn_wKing = findViewById(R.id.img_wKing);
            btn_bKing = findViewById(R.id.img_bKing);
            btn_wQ = findViewById(R.id.img_wQueen);
            btn_bQ = findViewById(R.id.img_bQueen);
            btn_wR = findViewById(R.id.img_wRook);
            btn_bR = findViewById(R.id.img_bRook);
            btn_wB = findViewById(R.id.img_wBishop);
            btn_bB = findViewById(R.id.img_bBishop);
            btn_wK = findViewById(R.id.img_wKnight);
            btn_bK = findViewById(R.id.img_bKnight);
            btn_wP = findViewById(R.id.img_wPawn);
            btn_bP = findViewById(R.id.img_bPawn);
            btn_delete = findViewById(R.id.btn_delete);
            linearLayout = findViewById(R.id.layout_Palette);
        }

        buttons = new ImageButton[][]{{btn_A1, btn_A2, btn_A3, btn_A4, btn_A5, btn_A6, btn_A7, btn_A8},
                {btn_B1, btn_B2, btn_B3, btn_B4, btn_B5, btn_B6, btn_B7, btn_B8},
                {btn_C1, btn_C2, btn_C3, btn_C4, btn_C5, btn_C6, btn_C7, btn_C8},
                {btn_D1, btn_D2, btn_D3, btn_D4, btn_D5, btn_D6, btn_D7, btn_D8},
                {btn_E1, btn_E2, btn_E3, btn_E4, btn_E5, btn_E6, btn_E7, btn_E8},
                {btn_F1, btn_F2, btn_F3, btn_F4, btn_F5, btn_F6, btn_F7, btn_F8},
                {btn_G1, btn_G2, btn_G3, btn_G4, btn_G5, btn_G6, btn_G7, btn_G8},
                {btn_H1, btn_H2, btn_H3, btn_H4, btn_H5, btn_H6, btn_H7, btn_H8}};

        palette = new ArrayList<>(Arrays.asList(btn_wKing, btn_wQ, btn_wR, btn_wB, btn_wK, btn_wP,
                btn_bKing, btn_bQ, btn_bR, btn_bB, btn_bK, btn_bP));

        //on click dla szachownicy
        clicked = null;
        board = new ArrayList<>();
        for(ImageButton[] row : buttons)
        {
            ArrayList<ImageButton> one_row = new ArrayList<>();
            for(ImageButton square : row)
            {
                one_row.add(square);
                square.setOnClickListener(v -> {
                    if(clicked != null)
                        changeColorBack();
                    else
                        linearLayout.setVisibility(View.VISIBLE);
                    clicked = square;
                    clicked.getBackground().setTint(getResources().getColor(R.color.chess_clicked));
                });
                square.setTag("");
            }
            board.add(one_row);
        }

        //rozpoczęcie symulacji
        btn_startSymulation.setOnClickListener(v -> {
            changeColorBack();
            if (isbKing && iswKing) {
                Intent intent = new Intent(PrepareActivity.this, SimulationActivity.class);
                DataHolder.setData(board);
                startActivity(intent);
            }
            else {
                Toast.makeText(PrepareActivity.this, "You should put both kings!", Toast.LENGTH_LONG).show();
            }
        });

        //ustawienie obrazów na planszy
        {
            btn_wQ.setOnClickListener(v -> {clicked.setImageResource(R.drawable.w_queen);
                clicked.setTag("wQueen");});
            btn_bQ.setOnClickListener(v -> {clicked.setImageResource(R.drawable.b_queen);
                clicked.setTag("bQueen");});
            btn_wR.setOnClickListener(v -> {clicked.setImageResource(R.drawable.w_rook);
                clicked.setTag("wRook");});
            btn_bR.setOnClickListener(v -> {clicked.setImageResource(R.drawable.b_rook);
                clicked.setTag("bRook");});
            btn_wB.setOnClickListener(v -> {clicked.setImageResource(R.drawable.w_bishop);
                clicked.setTag("wBishop");});
            btn_bB.setOnClickListener(v -> {clicked.setImageResource(R.drawable.b_bishop);
                clicked.setTag("bBishop");});
            btn_wK.setOnClickListener(v -> {clicked.setImageResource(R.drawable.w_knight);
                clicked.setTag("wKnight");});
            btn_bK.setOnClickListener(v -> {clicked.setImageResource(R.drawable.b_knight);
                clicked.setTag("bKnight");});
            btn_wP.setOnClickListener(v -> {clicked.setImageResource(R.drawable.w_pawn);
                clicked.setTag("wPawn");});
            btn_bP.setOnClickListener(v -> {clicked.setImageResource(R.drawable.b_pawn);
                clicked.setTag("bPawn");});
            btn_wKing.setOnClickListener(v ->
            {
                if(iswKing)
                {
                    Toast.makeText(this, "It can be only one king!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    clicked.setImageResource(R.drawable.w_king);
                    iswKing = true;
                    clicked.setTag("wKing");
                }
            });
            btn_bKing.setOnClickListener(v ->
            {
                if(isbKing)
                {
                    Toast.makeText(this, "It can be only one king!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    clicked.setImageResource(R.drawable.b_king);
                    isbKing = true;
                    clicked.setTag("bKing");
                }
            });
        }

        //usuwanie z planszy - btn_delete
        btn_delete.setOnClickListener(v -> {
            if(clicked.getTag() != null)
            {
                if(clicked.getTag().equals("wKing"))
                {
                    iswKing = false;
                }
                if(clicked.getTag().equals("bKing"))
                {
                    isbKing = false;
                }
            }
            clicked.setImageResource(0);
            clicked.setTag("");
        });

        defaultPosition();
    }

    //ustawienie standardowe początkowe
    private void defaultPosition()
    {
        board.get(0).get(0).setImageResource(R.drawable.w_rook);
        board.get(1).get(0).setImageResource(R.drawable.w_knight);
        board.get(2).get(0).setImageResource(R.drawable.w_bishop);
        board.get(3).get(0).setImageResource(R.drawable.w_queen);
        board.get(4).get(0).setImageResource(R.drawable.w_king);
        board.get(5).get(0).setImageResource(R.drawable.w_bishop);
        board.get(6).get(0).setImageResource(R.drawable.w_knight);
        board.get(7).get(0).setImageResource(R.drawable.w_rook);
        board.get(0).get(1).setImageResource(R.drawable.w_pawn);
        board.get(1).get(1).setImageResource(R.drawable.w_pawn);
        board.get(2).get(1).setImageResource(R.drawable.w_pawn);
        board.get(3).get(1).setImageResource(R.drawable.w_pawn);
        board.get(4).get(1).setImageResource(R.drawable.w_pawn);
        board.get(5).get(1).setImageResource(R.drawable.w_pawn);
        board.get(6).get(1).setImageResource(R.drawable.w_pawn);
        board.get(7).get(1).setImageResource(R.drawable.w_pawn);

        board.get(0).get(7).setImageResource(R.drawable.b_rook);
        board.get(1).get(7).setImageResource(R.drawable.b_knight);
        board.get(2).get(7).setImageResource(R.drawable.b_bishop);
        board.get(3).get(7).setImageResource(R.drawable.b_queen);
        board.get(4).get(7).setImageResource(R.drawable.b_king);
        board.get(5).get(7).setImageResource(R.drawable.b_bishop);
        board.get(6).get(7).setImageResource(R.drawable.b_knight);
        board.get(7).get(7).setImageResource(R.drawable.b_rook);
        board.get(0).get(6).setImageResource(R.drawable.b_pawn);
        board.get(1).get(6).setImageResource(R.drawable.b_pawn);
        board.get(2).get(6).setImageResource(R.drawable.b_pawn);
        board.get(3).get(6).setImageResource(R.drawable.b_pawn);
        board.get(4).get(6).setImageResource(R.drawable.b_pawn);
        board.get(5).get(6).setImageResource(R.drawable.b_pawn);
        board.get(6).get(6).setImageResource(R.drawable.b_pawn);
        board.get(7).get(6).setImageResource(R.drawable.b_pawn);

        board.get(0).get(0).setTag("wRook");
        board.get(1).get(0).setTag("wKnight");
        board.get(2).get(0).setTag("wBishop");
        board.get(3).get(0).setTag("wQueen");
        board.get(4).get(0).setTag("wKing");
        board.get(5).get(0).setTag("wBishop");
        board.get(6).get(0).setTag("wKnight");
        board.get(7).get(0).setTag("wRook");
        board.get(0).get(1).setTag("wPawn");
        board.get(1).get(1).setTag("wPawn");
        board.get(2).get(1).setTag("wPawn");
        board.get(3).get(1).setTag("wPawn");
        board.get(4).get(1).setTag("wPawn");
        board.get(5).get(1).setTag("wPawn");
        board.get(6).get(1).setTag("wPawn");
        board.get(7).get(1).setTag("wPawn");

        board.get(0).get(7).setTag("bRook");
        board.get(1).get(7).setTag("bKnight");
        board.get(2).get(7).setTag("bBishop");
        board.get(3).get(7).setTag("bQueen");
        board.get(4).get(7).setTag("bKing");
        board.get(5).get(7).setTag("bBishop");
        board.get(6).get(7).setTag("bKnight");
        board.get(7).get(7).setTag("bRook");
        board.get(0).get(6).setTag("bPawn");
        board.get(1).get(6).setTag("bPawn");
        board.get(2).get(6).setTag("bPawn");
        board.get(3).get(6).setTag("bPawn");
        board.get(4).get(6).setTag("bPawn");
        board.get(5).get(6).setTag("bPawn");
        board.get(6).get(6).setTag("bPawn");
        board.get(7).get(6).setTag("bPawn");
    }

    //funkcja do powrotu koloru po kliknięciu innego przycisku
    @SuppressWarnings("deprecation")
    private void changeColorBack()
    {
        if(clicked == null)
            return;
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

    @Override
    public void onBackPressed() {
        changeColorBack();
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        clicked = null;
        linearLayout.setVisibility(View.GONE);
        super.onResume();
    }
}