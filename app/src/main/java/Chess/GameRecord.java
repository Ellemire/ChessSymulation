package Chess;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GameRecord implements Serializable {
    private final String time;
    private ArrayList<String> moves;
    private final int numberOfMoves;

    public GameRecord(String time, ArrayList<String> moves) {
        this.time = time;
        this.moves = moves;
        numberOfMoves = moves.size() / 2;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<String> moves) {
        this.moves = moves;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }
}
