package Chess;

import android.util.Pair;

import java.util.ArrayList;
public class Pawn extends Piece {

    private int direction;

    //konstruktor
    public Pawn(Pair<Integer, Integer> position, boolean color) {
        super(position, color);
        if(color)
            direction=1;
        if(!color)
            direction=-1;
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Piece yourKing) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();

        int forwardRow;
        int doubleForwardRow=-1 ;
        int attackColumnLeft;
        int attackColumnRight;

        if ((position.second == 1 && direction > 0) || (position.second == 6 && direction < 0)) {
            forwardRow = position.second + direction;
            doubleForwardRow = position.second + 2*direction;
        } else {
            forwardRow = position.second + direction;
        }

        attackColumnLeft = position.first - 1;
        attackColumnRight = position.first + 1;
        if (isValidSquare(position.first, forwardRow) && isNotOccupied(position.first, forwardRow, white, black) && isNotOccupied(position.first, forwardRow, black, white)){
            possibleMoves.add(new Pair<>(position.first, forwardRow));
        }
        if (isValidSquare(position.first, doubleForwardRow) && isNotOccupied(position.first, doubleForwardRow, white, black) && isNotOccupied(position.first, doubleForwardRow, black, white) && isNotOccupied(position.first, forwardRow, white, black) && isNotOccupied(position.first, forwardRow, black, white)) {
            possibleMoves.add(new Pair<>(position.first, doubleForwardRow));
        }
        if (isValidSquare(attackColumnLeft, forwardRow) && !isNotOccupied(attackColumnLeft, forwardRow,black,white)) {
            possibleMoves.add(new Pair<>(attackColumnLeft, forwardRow));
        }

        if (isValidSquare(attackColumnRight, forwardRow) && !isNotOccupied(attackColumnRight, forwardRow,black,white)) {
            possibleMoves.add(new Pair<>(attackColumnRight, forwardRow));
        }
        movesList = possibleMoves;
        return possibleMoves;
    }
}
