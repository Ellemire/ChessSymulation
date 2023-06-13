package com.example.chesssymulation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Pair;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

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

/**
 *  klasa odpowiedzialna za ekran symulacji
 */
public class SimulationActivity extends AppCompatActivity {

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
                if(tag.length() != 0 && tag.charAt(0) == 'w')
                {
                    switch (tag) {
                        case "wPawn":
                            pieces.add(new Pawn(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_pawn);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.w_pawn);
                            break;
                        case "wKing":
                            pieces.add(new King(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true, false));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_king);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.w_king);
                            break;
                        case "wBishop":
                            pieces.add(new Bishop(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_bishop);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.w_bishop);
                            break;
                        case "wRook":
                            pieces.add(new Rook(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_rook);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.w_rook);
                            break;
                        case "wKnight":
                            pieces.add(new Knight(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_knight);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.w_knight);
                            break;
                        case "wQueen":
                            pieces.add(new Queen(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_queen);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.w_queen);
                            break;
                    }
                    whitePieces.add(pieces.get(pieces.size() - 1));
                }
                else if(tag.length() != 0) {
                    switch (tag) {
                        case "bPawn":
                            pieces.add(new Pawn(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_pawn);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.b_pawn);
                            break;
                        case "bKing":
                            pieces.add(new King(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false, false));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_king);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.b_king);
                            break;
                        case "bBishop":
                            pieces.add(new Bishop(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_bishop);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.b_bishop);
                            break;
                        case "bRook":
                            pieces.add(new Rook(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_rook);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.b_rook);
                            break;
                        case "bKnight":
                            pieces.add(new Knight(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_knight);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.b_knight);
                            break;
                        case "bQueen":
                            pieces.add(new Queen(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_queen);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.b_queen);
                            break;
                    }
                    blackPieces.add(pieces.get(pieces.size() - 1));
                }
            }
        }
        whiteTurn = true;
        new Simulation().execute();
    }

    boolean whiteTurn;
    Pair<Integer,Integer> clicked = null;
    Pair<Integer,Integer> lastly_moved_square = null;
    Piece lastlyMovedPiece = null;

    /** metoda przesuwająca bierki na planszy
     * @param piece_movable bierka która ma zostać przesunięta
     * @return czy pomyślnie przesunięto bierkę
     */
    private boolean movePiece(Piece piece_movable) {
        Piece king = find_King(piece_movable.isColor());
        if(king.getPosition() != null){
            //znajduje dostępne ruchy
            ArrayList<Pair<Integer, Integer>> moves = piece_movable.calculatePossibleMoves(whitePieces, blackPieces, king);
            //sprawdza czy istnieją ruchy dla wybranej figury
            if(moves.size() == 0) {
                return false;
            }
            lastlyMovedPiece = piece_movable;
            //wybiera ruch który ma zostać wykonany przez wybraną figurę i przesuwa ją
            Random rand = new Random();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(clicked != null){
                        if((clicked.first + clicked.second) % 2 == 0)
                            board[clicked.first][clicked.second].getBackground().setTint(getResources().getColor(R.color.chess_black));
                        else
                            board[clicked.first][clicked.second].getBackground().setTint(getResources().getColor(R.color.chess_white));
                    }
                    if(lastly_moved_square != null){
                        if((lastly_moved_square.first + lastly_moved_square.second) % 2 == 0)
                            board[lastly_moved_square.first][lastly_moved_square.second].getBackground().setTint(getResources().getColor(R.color.chess_black));
                        else
                            board[lastly_moved_square.first][lastly_moved_square.second].getBackground().setTint(getResources().getColor(R.color.chess_white));
                    }
                    clicked = piece_movable.getPosition();
                    board[clicked.first][clicked.second].setImageResource(0);
                    board[clicked.first][clicked.second].getBackground().setTint(getResources().getColor(R.color.chess_clicked));
                    Pair<Integer, Integer> move = moves.get(rand.nextInt(moves.size()));
                    for(Piece piece : pieces)
                    {
                        //usuwa zbijaną figurę
                        if(piece.getPosition().equals(move))
                        {
                            if(piece.isColor())
                                whitePieces.remove(piece);
                            else
                                blackPieces.remove(piece);
                            pieces.remove(piece);
                            break;
                        }
                    }
                    piece_movable.setPosition(move);
                    lastly_moved_square = move;
                    board[piece_movable.getPosition().first][piece_movable.getPosition().second].setImageResource(piece_movable.getPicture());
                    board[piece_movable.getPosition().first][piece_movable.getPosition().second].getBackground().setTint(getResources().getColor(R.color.chess_clicked));
                }
            });
        }
        return true;
    }

    /** losuje bierkę do wykonania ruchu, wywołuje wykonanie ruchu
     * @param whiteTurn kolor bierek które mają się aktualnie ruszyć
     */
    private void makeMove(Boolean whiteTurn)
    {
        Random rand = new Random();
        if(whiteTurn)
            while(!movePiece(whitePieces.get(rand.nextInt(whitePieces.size()))));
        else
            while(!movePiece(blackPieces.get(rand.nextInt(blackPieces.size()))));
    }

    /** metoda znajdująca króla na liście figur
     * @param color kolor szukanego króla
     * @return szukany król
     */
    //znajduje króla
    private King find_King(boolean color){
        for (Piece piece : pieces) {
            if(piece instanceof King){
                if (color == piece.isColor())
                    return (King) piece;
            }
        }
        return null;
    }

    /** Metoda sprawdzająca czy jest szach
     * @param color kolor dla którego sprawdzamy szacha
     * @return czy król jest szachowany
     */
    private boolean isCheck(boolean color){
        King king = find_King(color);
        if (color) {
            for (Piece piece : blackPieces){
                if(piece.calculatePossibleMoves(whitePieces, blackPieces, king).contains(king.getPosition())){
                    Toast.makeText(this, "Check!", Toast.LENGTH_LONG).show();
                    return true;
                }
            }
        }
        else {
            for (Piece piece : whitePieces) {
                if(piece.calculatePossibleMoves(whitePieces, blackPieces, king).contains(king.getPosition())){
                    Toast.makeText(this, "Check!", Toast.LENGTH_LONG).show();
                    return true;
                }
            }
        }
        return false;
    }

    /** metoda sprawdza czy po ruchu przeciwnika nastąpił mat
     * @param color kolor figur, dla których sprawdzany jest mat
     * @param lastlyMoved ostatnio ruszona figura przeciwnego koloru
     * @param white lista białych bierek
     * @param black lista czarnych bierek
     * @return czy jest mat
     */
    private boolean isMate(boolean color, Piece lastlyMoved, ArrayList<Piece> white, ArrayList<Piece> black)
    {
        if (isCheck(color))
        {
            if (color)
            {
                for (Piece piece : blackPieces)
                {

                }
            }
            else
            {
                for (Piece piece : whitePieces)
                {

                }
            }
//            if(lastlyMoved.calculateDefenseMoves(find_King(!color),find_King(color),white,black).isEmpty()){
            Toast.makeText(this, "Check!", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    /**
     * klasa odpowiedzialna za symulowanie gry w szachy
     */
    private class Simulation extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            int licznik = 0;
//            while(!isMate(whiteTurn,lastlyMovedPiece,whitePieces,blackPieces))
            while(licznik < 50) //tu zamienić na isCheckMate - tymczasowo ilość ruchów
            {
                makeMove(whiteTurn);
                whiteTurn = !whiteTurn;
                try {
                    TimeUnit.SECONDS.sleep(1); //czas trwania ruchu
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                licznik++;
            }
            return null;
        }
    }
}