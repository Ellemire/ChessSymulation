package Chess;

import android.util.Pair;

import java.util.ArrayList;

public class Board {

    private ArrayList<Square> squares;

    //gettery i settery
    public ArrayList<Square> getSquares() {
        return squares;
    }
    public void setSquares(ArrayList<Square> squares) {
        this.squares = squares;
    }

    //konstruktor
    public Board(ArrayList<Square> squares) {
        this.squares = squares;
    }

    //sprawdza czy istnieje dane pole
    private boolean isValidSquare(Pair<Integer,Integer> pair) {
        for (Square square : squares) {
            if (pair.equals(square.getPosition()))
                return true;
        }
        return false;
//        return pair.first >= 0 && pair.first < 8 && pair.second >= 0 && pair.second < 8;
    }
}

