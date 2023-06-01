package Chess;

import android.util.Pair;

import java.util.ArrayList;
public class Pawn extends Piece {

    //konstruktor
    public Pawn(Pair<Integer, Integer> position, boolean color) {
        super(position, color);
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Pair<Integer, Integer> kingPosition) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.addAll(white);
        pieces.addAll(black);

        int forwardRow;
        int doubleForwardRow;
        int attackColumnLeft;
        int attackColumnRight;

        if (position.second == 1) {
            forwardRow = position.second + 1;
            doubleForwardRow = position.second + 2;
        } else if (position.second == 6) {
            forwardRow = position.second - 1;
            doubleForwardRow = position.second - 2;
        } else {
            forwardRow = position.second + 1;
            doubleForwardRow = position.second - 1;
        }

        attackColumnLeft = position.first - 1;
        attackColumnRight = position.first + 1;
        if (isValidSquare(position.first, forwardRow) && IsNotOccupied(position.first, forwardRow,white,black) && !isCheck(pieces, kingPosition)){
            possibleMoves.add(new Pair<>(position.first, forwardRow));
        }
        if (isValidSquare(position.first, doubleForwardRow) && IsNotOccupied(position.first, doubleForwardRow,white,black) && !isCheck(pieces, kingPosition)) {
            possibleMoves.add(new Pair<>(position.first, doubleForwardRow));
        }
        if (isValidSquare(attackColumnLeft, forwardRow) && IsNotOccupied(attackColumnLeft, forwardRow,white,black) && !isCheck(pieces, kingPosition)) {
            possibleMoves.add(new Pair<>(attackColumnLeft, forwardRow));
        }

        if (isValidSquare(attackColumnRight, forwardRow) && IsNotOccupied(attackColumnRight, forwardRow,white,black) && !isCheck(pieces, kingPosition)) {
            possibleMoves.add(new Pair<>(attackColumnRight, forwardRow));
        }

        return possibleMoves;
    }

    @Override
    protected boolean isAttacking(Piece piece, Pair<Integer, Integer> kingPosition) {

        // Sprawdzamy, czy figura atakuje króla jako pionek
        int direction = 1; // Kierunek ataku pionka (1 - w górę, -1 - w dół)
        if (piece.getPosition().second > kingPosition.second) {
            direction = -1;
        }
        if (piece.getPosition().first == kingPosition.first + 1 || piece.getPosition().first == kingPosition.first - 1) {
            if (piece.getPosition().second == kingPosition.second + direction) {
                return true;
            }
        }

        return false;
    }
}
