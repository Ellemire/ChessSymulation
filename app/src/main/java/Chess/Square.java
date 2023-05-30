package Chess;

import static Chess.Piece.PiecesListBlack;
import static Chess.Piece.PiecesListWhite;

import android.util.Pair;

public class Square {
    private  Pair<Integer, Integer> position;

    public Square(int column, int row) {
        position = new Pair<>(column, row);
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    //sprawdza czy pole jest zajęte
    private boolean IsFree () {
        return !PiecesListWhite.contains(position) && !PiecesListBlack.contains(position);
    }
}