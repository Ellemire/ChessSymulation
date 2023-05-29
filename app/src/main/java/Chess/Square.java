package Chess;

import android.util.Pair;

public class Square {
    private  Pair<Integer, Integer> position;

    public Square(int x, int y) {
        position = new Pair<>(x, y);
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }
}