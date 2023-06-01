package Chess;

import android.util.Pair;

import java.util.ArrayList;

public class Bishop extends Piece {

    //konstruktor
    public Bishop(Pair<Integer, Integer> position, boolean color) {
        super(position, color);
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Pair<Integer, Integer> kingPosition) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.addAll(white);
        pieces.addAll(black);

        // Ruchy na prawo-górę
        int column = position.first + 1;
        int row = position.second + 1;
        while (column < 8 && row < 8 && IsNotOccupied(column, row, white, black) && !isCheck(pieces, kingPosition)) {
            possibleMoves.add(new Pair<>(column, row));
            column++;
            row++;
        }

        // Ruchy na lewo-górę
        column = position.first - 1;
        row = position.second + 1;
        while (column >= 0 && row < 8 && IsNotOccupied(column, row, white, black) && !isCheck(pieces, kingPosition)) {
            possibleMoves.add(new Pair<>(column, row));
            column--;
            row++;
        }

        // Ruchy na prawo-dół
        column = position.first + 1;
        row = position.second - 1;
        while (column < 8 && row >= 0 && IsNotOccupied(column, row, white, black) && !isCheck(pieces, kingPosition)) {
            possibleMoves.add(new Pair<>(column, row));
            column++;
            row--;
        }

        // Ruchy na lewo-dół
        column = position.first - 1;
        row = position.second - 1;
        while (column >= 0 && row >= 0 && IsNotOccupied(column, row, white, black) && !isCheck(pieces, kingPosition)) {
            possibleMoves.add(new Pair<>(column, row));
            column--;
            row--;
        }

        return possibleMoves;
    }


    @Override
    protected boolean isAttacking(Piece piece, Pair<Integer, Integer> kingPosition) {
        // Sprawdzamy, czy figura atakuje króla na wprost (na skos)
        if (Math.abs(piece.getPosition().first - kingPosition.first) == Math.abs(piece.getPosition().second - kingPosition.second)) {
            return true;
        }
        return false;
    }

}