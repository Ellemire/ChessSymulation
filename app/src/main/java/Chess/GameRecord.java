package Chess;

import java.io.Serializable;
import java.util.ArrayList;

public class GameRecord implements Serializable {
    private final String time;
    private final ArrayList<String> moves;
    private final int numberOfMoves;
    private final String startingPosition;

    public GameRecord(String time, ArrayList<String> moves, String startingPosition) {
        this.time = time;
        this.moves = moves;
        numberOfMoves = moves.size() / 2;
        this.startingPosition = startingPosition;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public String getStartingPosition() {
        return startingPosition;
    }
}
