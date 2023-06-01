package Chess;

import android.util.Pair;

import java.util.ArrayList;
public class Pawn extends Piece {

    int direction;

    //konstruktor
    public Pawn(Pair<Integer, Integer> position, boolean color) {
        super(position, color);
        if(color)
            direction=1;
        if(!color)
            direction=-1;
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Pair<Integer, Integer> kingPosition) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.addAll(white);
        pieces.addAll(black);

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
        if (isValidSquare(position.first, forwardRow) && IsNotOccupied(position.first, forwardRow, white, black) && IsNotOccupied(position.first, forwardRow, black, white) && !isCheck(pieces, kingPosition)){
            possibleMoves.add(new Pair<>(position.first, forwardRow));
        }
        if (isValidSquare(position.first, doubleForwardRow) && IsNotOccupied(position.first, doubleForwardRow, white, black) && IsNotOccupied(position.first, doubleForwardRow, black, white) && !isCheck(pieces, kingPosition)) {
            possibleMoves.add(new Pair<>(position.first, doubleForwardRow));
        }
        if (isValidSquare(attackColumnLeft, forwardRow) && !IsNotOccupied(attackColumnLeft, forwardRow,black,white) && !isCheck(pieces, kingPosition)) {
            possibleMoves.add(new Pair<>(attackColumnLeft, forwardRow));
        }

        if (isValidSquare(attackColumnRight, forwardRow) && !IsNotOccupied(attackColumnRight, forwardRow,black,white) && !isCheck(pieces, kingPosition)) {
            possibleMoves.add(new Pair<>(attackColumnRight, forwardRow));
        }

        return possibleMoves;
    }

    @Override
    protected boolean isAttacking(Piece piece, Pair<Integer, Integer> kingPosition) {

        // Sprawdzamy, czy figura atakuje króla jako pionek
        return piece.position.second == kingPosition.second + direction && (piece.position.first == kingPosition.first + 1 || piece.position.first == kingPosition.first - 1);
    }
}
