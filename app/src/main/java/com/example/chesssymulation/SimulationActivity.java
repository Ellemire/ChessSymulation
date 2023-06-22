package com.example.chesssymulation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import org.json.JSONException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
 *  Klasa odpowiedzialna za ekran symulacji.
 */
@SuppressWarnings("deprecation")
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
    ArrayList<String> gameRecord;
    DatabaseHelper myDB;
    Button btn_gameRecords;
    StringBuilder startingPosition;

    /** Metoda która wywołuje się po przejściu do ekranusymulacji, odpowiada za stworzenie obiektów bierek.
     * @param savedInstanceState pakiet danych
     */
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

        if(DataHolder.hasData())
            board_prepare = DataHolder.getData();
        pieces = new ArrayList<>();

        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        gameRecord = new ArrayList<>();
        myDB = new DatabaseHelper(this);

        btn_gameRecords = findViewById(R.id.btn_gameRecords);
        btn_gameRecords.setOnClickListener(v -> {
            Intent intent = new Intent(SimulationActivity.this, GamesActivity.class);
            intent.putExtra("moves", gameRecord);
            startActivity(intent);
        });

        startingPosition = new StringBuilder();

        //dodawanie figur do tablicy
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                String tag = board_prepare.get(j).get(i).getTag().toString();
                ArrayList<ImageButton> row = board_prepare.get(j);
                ImageButton button = row.get(i);
                if(tag.length() != 0 && tag.charAt(0) == 'w')
                {
                    switch (tag) {
                        case "wPawn":
                            pieces.add(new Pawn(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_pawn);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.w_pawn);
                            startingPosition.append("wP ");
                            break;
                        case "wKing":
                            pieces.add(new King(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_king);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.w_king);
                            startingPosition.append("wK ");
                            break;
                        case "wBishop":
                            pieces.add(new Bishop(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_bishop);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.w_bishop);
                            startingPosition.append("wB ");
                            break;
                        case "wRook":
                            pieces.add(new Rook(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_rook);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.w_rook);
                            startingPosition.append("wR ");
                            break;
                        case "wKnight":
                            pieces.add(new Knight(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_knight);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.w_knight);
                            startingPosition.append("wN ");
                            break;
                        case "wQueen":
                            pieces.add(new Queen(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), true));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.w_queen);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.w_queen);
                            startingPosition.append("wQ ");
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
                            startingPosition.append("bP  ");
                            break;
                        case "bKing":
                            pieces.add(new King(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_king);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.b_king);
                            startingPosition.append("bK  ");
                            break;
                        case "bBishop":
                            pieces.add(new Bishop(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_bishop);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.b_bishop);
                            startingPosition.append("bB  ");
                            break;
                        case "bRook":
                            pieces.add(new Rook(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_rook);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.b_rook);
                            startingPosition.append("bR  ");
                            break;
                        case "bKnight":
                            pieces.add(new Knight(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_knight);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.b_knight);
                            startingPosition.append("bN  ");
                            break;
                        case "bQueen":
                            pieces.add(new Queen(new Pair<>(board_prepare.indexOf(row), row.indexOf(button)), false));
                            board[board_prepare.indexOf(row)][row.indexOf(button)].setImageResource(R.drawable.b_queen);
                            pieces.get(pieces.size() - 1).setPicture(R.drawable.b_queen);
                            startingPosition.append("bQ ");
                            break;
                    }
                    blackPieces.add(pieces.get(pieces.size() - 1));
                }
                else
                    startingPosition.append("----  ");
            }
            startingPosition.append("\n");
        }

        //ustawianie kolorów pól
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
            {
                if((i + j) % 2 == 0)
                    board[i][j].setBackgroundColor(getResources().getColor(R.color.chess_black));
                else
                    board[i][j].setBackgroundColor(getResources().getColor(R.color.chess_white));
            }
        btn_gameRecords.setVisibility(View.INVISIBLE);
        whiteTurn = true;
        endGame = false;
        new Simulation().execute();
    }

    boolean whiteTurn;
    Pair<Integer,Integer> clicked = null;
    Pair<Integer,Integer> lastly_moved_square = null;
    Piece lastlyMovedPiece = null;
    boolean endGame;

    /** Metoda przesuwająca bierki na planszy.
     * @param piece_movable bierka która ma zostać przesunięta
     * @return czy pomyślnie przesunięto bierkę
     */
    @SuppressWarnings({"BooleanMethodIsAlwaysInverted", "deprecation"})
    private boolean movePiece(Piece piece_movable) {
        Piece king = find_King(piece_movable.isColor());
        if(king != null){
            //znajduje dostępne ruchy
            ArrayList<Pair<Integer, Integer>> moves;
            if(piece_movable instanceof King)
                moves = piece_movable.calculatePossibleMoves(whitePieces, blackPieces, find_King(!piece_movable.isColor()));
            else
                moves = piece_movable.calculatePossibleMoves(whitePieces, blackPieces, king);
            //sprawdza czy istnieją ruchy dla wybranej figury
            if(moves.size() == 0) {
                return false;
            }
            lastlyMovedPiece = piece_movable;
            //wybiera ruch który ma zostać wykonany przez wybraną figurę i przesuwa ją
            Random rand = new Random();
            runOnUiThread(() -> {
                if(clicked != null){
                    if((clicked.first + clicked.second) % 2 == 0)
                        board[clicked.first][clicked.second].setBackgroundColor(getResources().getColor(R.color.chess_black));
                    else
                        board[clicked.first][clicked.second].setBackgroundColor(getResources().getColor(R.color.chess_white));
                }
                if(lastly_moved_square != null){
                    if((lastly_moved_square.first + lastly_moved_square.second) % 2 == 0)
                        board[lastly_moved_square.first][lastly_moved_square.second].setBackgroundColor(getResources().getColor(R.color.chess_black));
                    else
                        board[lastly_moved_square.first][lastly_moved_square.second].setBackgroundColor(getResources().getColor(R.color.chess_white));
                }
                clicked = piece_movable.getPosition();
                board[clicked.first][clicked.second].setImageResource(0);
                board[clicked.first][clicked.second].setBackgroundColor(getResources().getColor(R.color.chess_clicked));
                Pair<Integer, Integer> move = moves.get(rand.nextInt(moves.size()));
                StringBuilder currentMove = new StringBuilder();
                if(piece_movable instanceof Knight)
                    currentMove.append("N");
                else if(piece_movable instanceof Bishop)
                    currentMove.append("B");
                else if(piece_movable instanceof Rook)
                    currentMove.append("R");
                else if(piece_movable instanceof Queen)
                    currentMove.append("Q");
                else if(piece_movable instanceof King)
                    currentMove.append("K");
                for(Piece piece : pieces)
                {
                    if(piece.getClass().equals(piece_movable.getClass()) && !piece.equals(piece_movable) && piece.isColor() == piece_movable.isColor())
                        if(piece.calculatePossibleMoves(whitePieces, blackPieces, find_King(piece.isColor())).contains(move))
                        {
                            if(!piece.getPosition().first.equals(piece_movable.getPosition().first))
                                currentMove.append((char) ((int) piece_movable.getPosition().first + 97));
                            if(!piece.getPosition().second.equals(piece_movable.getPosition().second))
                                currentMove.append(piece_movable.getPosition().second + 1);
                        }
                }
                for(Piece piece : pieces)
                {
                    //usuwa zbijaną figurę
                    if(piece.getPosition().equals(move))
                    {
                        if(piece.getClass().equals(King.class))
                        {
                            endGame = true;
                            btn_gameRecords.setVisibility(View.VISIBLE);
                        }
                        if(piece.isColor())
                            whitePieces.remove(piece);
                        else
                            blackPieces.remove(piece);
                        pieces.remove(piece);
                        if(piece_movable instanceof Pawn)
                            currentMove.append((char) ((int) piece_movable.getPosition().first + 97));
                        currentMove.append("x");
                        break;
                    }
                }
                piece_movable.setPosition(move);
                lastly_moved_square = move;
                currentMove.append((char) ((int) move.first + 97)).append(move.second + 1);
                if(piece_movable.getPosition().second == 7 && piece_movable.getPicture() == R.drawable.w_pawn)
                {
                    Random random = new Random();
                    switch (random.nextInt(4))
                    {
                        case 0:
                            board[piece_movable.getPosition().first][piece_movable.getPosition().second].setImageResource(R.drawable.w_knight);
                            Knight knight = new Knight(piece_movable.getPosition(), true);
                            knight.setPicture(R.drawable.w_knight);
                            whitePieces.add(knight);
                            pieces.add(knight);
                            currentMove.append("=N");
                            break;
                        case 1:
                            board[piece_movable.getPosition().first][piece_movable.getPosition().second].setImageResource(R.drawable.w_bishop);
                            Bishop bishop = new Bishop(piece_movable.getPosition(), true);
                            bishop.setPicture(R.drawable.w_bishop);
                            whitePieces.add(bishop);
                            pieces.add(bishop);
                            currentMove.append("=B");
                            break;
                        case 2:
                            board[piece_movable.getPosition().first][piece_movable.getPosition().second].setImageResource(R.drawable.w_rook);
                            Rook rook = new Rook(piece_movable.getPosition(), true);
                            rook.setPicture(R.drawable.w_rook);
                            whitePieces.add(rook);
                            pieces.add(rook);
                            currentMove.append("=R");
                            break;
                        case 3:
                            board[piece_movable.getPosition().first][piece_movable.getPosition().second].setImageResource(R.drawable.w_queen);
                            Queen queen = new Queen(piece_movable.getPosition(), true);
                            queen.setPicture(R.drawable.w_queen);
                            whitePieces.add(queen);
                            pieces.add(queen);
                            currentMove.append("=Q");
                            break;
                    }
                    whitePieces.remove(piece_movable);
                    pieces.remove(piece_movable);
                }
                else if(piece_movable.getPosition().second == 0 && piece_movable.getPicture() == R.drawable.b_pawn)
                {
                    Random random = new Random();
                    switch (random.nextInt(4))
                    {
                        case 0:
                            board[piece_movable.getPosition().first][piece_movable.getPosition().second].setImageResource(R.drawable.b_knight);
                            Piece knight = new Knight(piece_movable.getPosition(), false);
                            knight.setPicture(R.drawable.b_knight);
                            blackPieces.add(knight);
                            pieces.add(knight);
                            currentMove.append("=N");
                            break;
                        case 1:
                            board[piece_movable.getPosition().first][piece_movable.getPosition().second].setImageResource(R.drawable.b_bishop);
                            Piece bishop = new Bishop(piece_movable.getPosition(), false);
                            bishop.setPicture(R.drawable.b_bishop);
                            blackPieces.add(bishop);
                            pieces.add(bishop);
                            currentMove.append("=B");
                            break;
                        case 2:
                            board[piece_movable.getPosition().first][piece_movable.getPosition().second].setImageResource(R.drawable.b_rook);
                            Piece rook = new Rook(piece_movable.getPosition(), false);
                            rook.setPicture(R.drawable.b_rook);
                            blackPieces.add(rook);
                            pieces.add(rook);
                            currentMove.append("=R");
                            break;
                        case 3:
                            board[piece_movable.getPosition().first][piece_movable.getPosition().second].setImageResource(R.drawable.b_queen);
                            Piece queen = new Queen(piece_movable.getPosition(), false);
                            queen.setPicture(R.drawable.b_queen);
                            blackPieces.add(queen);
                            pieces.add(queen);
                            currentMove.append("=Q");
                            break;
                    }
                    blackPieces.remove(piece_movable);
                    pieces.remove(piece_movable);
                }
                else
                    board[piece_movable.getPosition().first][piece_movable.getPosition().second].setImageResource(piece_movable.getPicture());
                board[piece_movable.getPosition().first][piece_movable.getPosition().second].setBackgroundColor(getResources().getColor(R.color.chess_clicked));
                gameRecord.add(currentMove.toString());
                if(pieces.size() == 2)
                {
                    endGame = true;
                    btn_gameRecords.setVisibility(View.VISIBLE);
                }
            });
        }
        return true;
    }

    /** Losuje bierkę do wykonania ruchu, wywołuje wykonanie ruchu.
     * @param whiteTurn kolor bierek które mają się aktualnie ruszyć
     */
    @SuppressWarnings("StatementWithEmptyBody")
    private void makeMove(Boolean whiteTurn)
    {
        Random rand = new Random();
        if(whiteTurn)
            while(!movePiece(whitePieces.get(rand.nextInt(whitePieces.size()))));
        else
            while(!movePiece(blackPieces.get(rand.nextInt(blackPieces.size()))));
    }

    /** Metoda znajdująca króla na liście figur.
     * @param color kolor szukanego króla
     * @return szukany król
     */
    private King find_King(boolean color){
        for (Piece piece : pieces) {
            if(piece instanceof King){
                if (color == piece.isColor())
                    return (King) piece;
            }
        }
        return null;
    }

    /**
     * Klasa odpowiedzialna za symulowanie gry w szachy.
     */
    @SuppressWarnings("deprecation")
    @SuppressLint("StaticFieldLeak")
    private class Simulation extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            back = false;
            while(!endGame)
            {
                if(back)
                    return null;
                makeMove(whiteTurn);
                whiteTurn = !whiteTurn;
                try {
                    TimeUnit.SECONDS.sleep(1); //czas trwania ruchu
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(pieces.size() == 2)
                gameRecord.add("0.5 : 0.5");
            else if(!whiteTurn)
                gameRecord.add("1 : 0");
            else
                gameRecord.add("0 : 1");
            if(gameRecord.size() % 2 != 0)
                gameRecord.add(" ");
            try {
                myDB.addRecord(gameRecord, DateTimeFormatter.ofPattern("dd/MM/yyyy\nHH:mm:ss").format(LocalDateTime.now()), startingPosition.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    boolean back;

    /**
     * Powrót do poprzedniego ekranu.
     */
    @Override
    public void onBackPressed() {
        back = true;
        super.onBackPressed();
    }
}