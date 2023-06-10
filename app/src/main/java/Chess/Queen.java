package Chess;

import android.util.Pair;

import java.util.ArrayList;

public class Queen extends Piece {

    //konstruktor
    public Queen(Pair<Integer, Integer> position, boolean color) {
        super(position, color);
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Piece yourKing) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.addAll(white);
        pieces.addAll(black);
        // Ruchy w pionie
        for (int row = 0; row < 8; row++) {
            if (row != position.second && IsNotOccupied(position.first, row, white, black) && !isCheck(pieces, yourKing)) {
                possibleMoves.add(new Pair<>(position.first, row));
            }
        }

        // Ruchy w poziomie
        for (int column = 0; column < 8; column++) {
            if (column != position.first && IsNotOccupied(column, position.second, white, black) && !isCheck(pieces, yourKing)) {
                possibleMoves.add(new Pair<>(column, position.second));
            }
        }

        // Ruchy na skosach
        int column = position.first + 1;
        int row = position.second + 1;
        while (column < 8 && row < 8 && IsNotOccupied(column, row, white, black) && !isCheck(pieces, yourKing)) {
            possibleMoves.add(new Pair<>(column, row));
            column++;
            row++;
        }

        column = position.first - 1;
        row = position.second + 1;
        while (column >= 0 && row < 8 && IsNotOccupied(column, row, white, black) && !isCheck(pieces, yourKing)) {
            possibleMoves.add(new Pair<>(column, row));
            column--;
            row++;
        }

        column = position.first + 1;
        row = position.second - 1;
        while (column < 8 && row >= 0 && IsNotOccupied(column, row, white, black) && !isCheck(pieces, yourKing)) {
            possibleMoves.add(new Pair<>(column, row));
            column++;
            row--;
        }

        column = position.first - 1;
        row = position.second - 1;
        while (column >= 0 && row >= 0 && IsNotOccupied(column, row, white, black) && !isCheck(pieces, yourKing)) {
            possibleMoves.add(new Pair<>(column, row));
            column--;
            row--;
        }
        movesList = possibleMoves;
        return possibleMoves;
    }

    @Override
    protected boolean isAttacking(Piece piece, Pair<Integer, Integer> kingPosition) {
        /// Sprawdzamy, czy figura atakuje króla na wprost (pionowo, poziomo lub na skos)
        if (piece.getPosition().first == oppositeKingPosition.first || piece.getPosition().second == oppositeKingPosition.second || Math.abs(piece.getPosition().first- oppositeKingPosition.first) == Math.abs(piece.getPosition().second - oppositeKingPosition.second)) {
            return true;
        }
        return false;
    }
}