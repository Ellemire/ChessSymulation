package com.example.chesssymulation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Pair;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import Chess.Bishop;
import Chess.King;
import Chess.Knight;
import Chess.Pawn;
import Chess.Piece;
import Chess.Queen;
import Chess.Rook;

public class SymulationActivity extends AppCompatActivity {

    ArrayList<ArrayList<ImageButton>> board_prepare;
    ArrayList<Piece> pieces;
    ImageView [][] board;

    ImageView img_A1, img_A2, img_A3, img_A4, img_A5, img_A6, img_A7, img_A8;
    ImageView img_B1, img_B2, img_B3, img_B4, img_B5, img_B6, img_B7, img_B8;
    ImageView img_C1, img_C2, img_C3, img_C4, img_C5, img_C6, img_C7, img_C8;
    ImageView img_D1, img_D2, img_D3, img_D4, img_D5, img_D6, img_D7, img_D8;
    ImageView img_E1, img_E2, img_E3, img_E4, img_E5, img_E6, img_E7, img_E8;
    ImageView img_F1, img_F2, img_F3, img_F4, img_F5, img_F6, img_F7, img_F8;
    ImageView img_G1, img_G2, img_G3, img_G4, img_G5, img_G6, img_G7, img_G8;
    ImageView img_H1, img_H2, img_H3, img_H4, img_H5, img_H6, img_H7, img_H8;
    
    ArrayList<Piece> whitePieces, blackPieces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symulation);

        //find VIew
        {
            img_A1 = findViewById(R.id.img_a1);
            img_B1 = findViewById(R.id.img_b1);
            img_C1 = findViewById(R.id.img_c1);
            img_D1 = findViewById(R.id.img_d1);
            img_E1 = findViewById(R.id.img_e1);
            img_F1 = findViewById(R.id.img_f1);
            img_G1 = findViewById(R.id.img_g1);
            img_H1 = findViewById(R.id.img_h1);
            img_A2 = findViewById(R.id.img_a2);
            img_B2 = findViewById(R.id.img_b2);
            img_C2 = findViewById(R.id.img_c2);
            img_D2 = findViewById(R.id.img_d2);
            img_E2 = findViewById(R.id.img_e2);
            img_F2 = findViewById(R.id.img_f2);
            img_G2 = findViewById(R.id.img_g2);
            img_H2 = findViewById(R.id.img_h2);
            img_A3 = findViewById(R.id.img_a3);
            img_B3 = findViewById(R.id.img_b3);
            img_C3 = findViewById(R.id.img_c3);
            img_D3 = findViewById(R.id.img_d3);
            img_E3 = findViewById(R.id.img_e3);
            img_F3 = findViewById(R.id.img_f3);
            img_G3 = findViewById(R.id.img_g3);
            img_H3 = findViewById(R.id.img_h3);
            img_A4 = findViewById(R.id.img_a4);
            img_B4 = findViewById(R.id.img_b4);
            img_C4 = findViewById(R.id.img_c4);
            img_D4 = findViewById(R.id.img_d4);
            img_E4 = findViewById(R.id.img_e4);
            img_F4 = findViewById(R.id.img_f4);
            img_G4 = findViewById(R.id.img_g4);
            img_H4 = findViewById(R.id.img_h4);
            img_A5 = findViewById(R.id.img_a5);
            img_B5 = findViewById(R.id.img_b5);
            img_C5 = findViewById(R.id.img_c5);
            img_D5 = findViewById(R.id.img_d5);
            img_E5 = findViewById(R.id.img_e5);
            img_F5 = findViewById(R.id.img_f5);
            img_G5 = findViewById(R.id.img_g5);
            img_H5 = findViewById(R.id.img_h5);
            img_A6 = findViewById(R.id.img_a6);
            img_B6 = findViewById(R.id.img_b6);
            img_C6 = findViewById(R.id.img_c6);
            img_D6 = findViewById(R.id.img_d6);
            img_E6 = findViewById(R.id.img_e6);
            img_F6 = findViewById(R.id.img_f6);
            img_G6 = findViewById(R.id.img_g6);
            img_H6 = findViewById(R.id.img_h6);
            img_A7 = findViewById(R.id.img_a7);
            img_B7 = findViewById(R.id.img_b7);
            img_C7 = findViewById(R.id.img_c7);
            img_D7 = findViewById(R.id.img_d7);
            img_E7 = findViewById(R.id.img_e7);
            img_F7 = findViewById(R.id.img_f7);
            img_G7 = findViewById(R.id.img_g7);
            img_H7 = findViewById(R.id.img_h7);
            img_A8 = findViewById(R.id.img_a8);
            img_B8 = findViewById(R.id.img_b8);
            img_C8 = findViewById(R.id.img_c8);
            img_D8 = findViewById(R.id.img_d8);
            img_E8 = findViewById(R.id.img_e8);
            img_F8 = findViewById(R.id.img_f8);
            img_G8 = findViewById(R.id.img_g8);
            img_H8 = findViewById(R.id.img_h8);
        }

        board = new ImageView[][]{{img_A1, img_A2, img_A3, img_A4, img_A5, img_A6, img_A7, img_A8},
                {img_B1, img_B2, img_B3, img_B4, img_B5, img_B6, img_B7, img_B8},
                {img_C1, img_C2, img_C3, img_C4, img_C5, img_C6, img_C7, img_C8},
                {img_D1, img_D2, img_D3, img_D4, img_D5, img_D6, img_D7, img_D8},
                {img_E1, img_E2, img_E3, img_E4, img_E5, img_E6, img_E7, img_E8},
                {img_F1, img_F2, img_F3, img_F4, img_F5, img_F6, img_F7, img_F8},
                {img_G1, img_G2, img_G3, img_G4, img_G5, img_G6, img_G7, img_G8},
                {img_H1, img_H2, img_H3, img_H4, img_H5, img_H6, img_H7, img_H8}};
        
        board_prepare = (ArrayList<ArrayList<ImageButton>>) getIntent().getSerializableExtra("board");
        if(DataHolder.hasData())
            board_prepare = DataHolder.getData();
        pieces = new ArrayList<>();

        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();

        //dodawanie figur do tablicy
        for (ArrayList<ImageButton> row : board_prepare) {
            for (ImageButton button : row) {
                String tag = button.getTag().toString();
                if(tag.equals("wPawn")){
                    pieces.add(new Pawn(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                    board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_pawn);
                    pieces.get(pieces.size() - 1).setPicture(R.drawable.w_pawn);
                }
                else if(tag.equals("wKing")){
                    pieces.add(new King(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true, false));
                    board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_king);
                    pieces.get(pieces.size() - 1).setPicture(R.drawable.w_king);
                }
                else if(tag.equals("wBishop")){
                    pieces.add(new Bishop(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                    board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_bishop);
                    pieces.get(pieces.size() - 1).setPicture(R.drawable.w_bishop);
                }
                else if(tag.equals("wRook")){
                    pieces.add(new Rook(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                    board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_rook);
                    pieces.get(pieces.size() - 1).setPicture(R.drawable.w_rook);
                }
                else if(tag.equals("wKnight")){
                    pieces.add(new Knight(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                    board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_knight);
                    pieces.get(pieces.size() - 1).setPicture(R.drawable.w_knight);
                }
                else if(tag.equals("wQueen")){
                    pieces.add(new Queen(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                    board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_queen);
                    pieces.get(pieces.size() - 1).setPicture(R.drawable.w_queen);
                }
                else if(tag.equals("bPawn")){
                    pieces.add(new Pawn(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                    board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_pawn);
                    pieces.get(pieces.size() - 1).setPicture(R.drawable.b_pawn);
                }
                else if(tag.equals("bKing")){
                    pieces.add(new King(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false, false));
                    board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_king);
                    pieces.get(pieces.size() - 1).setPicture(R.drawable.b_king);
                }
                else if(tag.equals("bBishop")){
                    pieces.add(new Bishop(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                    board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_bishop);
                    pieces.get(pieces.size() - 1).setPicture(R.drawable.b_bishop);
                }
                else if(tag.equals("bRook")){
                    pieces.add(new Rook(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                    board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_rook);
                    pieces.get(pieces.size() - 1).setPicture(R.drawable.b_rook);
                }
                else if(tag.equals("bKnight")){
                    pieces.add(new Knight(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                    board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_knight);
                    pieces.get(pieces.size() - 1).setPicture(R.drawable.b_knight);
                }
                else if(tag.equals("bQueen")){
                    pieces.add(new Queen(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                    board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_queen);
                    pieces.get(pieces.size() - 1).setPicture(R.drawable.b_queen);
                }
                if(tag.length() != 0 && tag.charAt(0) == 'w')
                    whitePieces.add(pieces.get(pieces.size() - 1));
                else if(tag.length() != 0)
                    blackPieces.add(pieces.get(pieces.size() - 1));
            }
        }

        whiteTurn = true;
        new Simulation().execute();
    }

    boolean whiteTurn;

    //przesuwanie figur na planszy
    private boolean movePiece(Piece piece_movable) {
        Pair<Integer,Integer> kingPosition = null;
        boolean color = piece_movable.isColor();
        for (Piece piece : pieces) {
            if(piece instanceof King){
                if (color != piece.isColor())
                kingPosition = piece.getPosition();
            }
        }
        if(kingPosition != null){
            ArrayList<Pair<Integer, Integer>> moves = piece_movable.calculatePossibleMoves(whitePieces, blackPieces, kingPosition);
            if(moves.size() == 0) {
                return false;
            }
            Random rand = new Random();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    board[piece_movable.getPosition().first][piece_movable.getPosition().second].setImageResource(0);
                    Pair<Integer, Integer> move = moves.get(rand.nextInt(moves.size()));
                    piece_movable.setPosition(move);
                    board[piece_movable.getPosition().first][piece_movable.getPosition().second].setImageResource(piece_movable.getPicture());
                }
            });

        }
        return true;
    }

    //Symulacja
    private void makeMove(Boolean whiteTurn)
    {
        Random rand = new Random();
        if(whiteTurn)
            while(!movePiece(whitePieces.get(rand.nextInt(whitePieces.size()))));
        else
            while(!movePiece(blackPieces.get(rand.nextInt(blackPieces.size()))));
    }

    private class Simulation extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            int licznik = 0;
            while(licznik < 30) //tu zamienić na isCheckMate - tymczasowo ilość ruchów
            {
                makeMove(whiteTurn);
                whiteTurn = !whiteTurn;
                try {
                    TimeUnit.SECONDS.sleep(2); //czas trwania ruchu
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                licznik++;
            }
            return null;
        }
    }
}