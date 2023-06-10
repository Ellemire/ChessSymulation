package Chess;


import android.util.Pair;

public class Square {
    private final Pair<Integer, Integer> position;

    public Square(int column, int row) {
        position = new Pair<>(column, row);
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

}