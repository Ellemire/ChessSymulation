package Chess;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Objects;

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
        for (int row = position.second + 1; row < 8; row++) {
            if (!isNotOccupied(position.first, row, white, black))
                break;
            if (!isCheck(pieces, yourKing)) {
                possibleMoves.add(new Pair<>(position.first, row));
                if(!isNotOccupied(position.first, row, black, white))
                    break;
            }
        }
        for (int row = position.second - 1; row >= 0; row--) {
            if (!isNotOccupied(position.first, row, white, black))
                break;
            if (!isCheck(pieces, yourKing)) {
                possibleMoves.add(new Pair<>(position.first, row));
                if(!isNotOccupied(position.first, row, black, white))
                    break;
            }
        }

        // Ruchy w poziomie
        for (int column = position.first + 1; column < 8; column++) {
            if(!isNotOccupied(column, position.second, white, black))
                break;
            if (column != position.first && !isCheck(pieces, yourKing)) {
                possibleMoves.add(new Pair<>(column, position.second));
                if(!isNotOccupied(column, position.second, black, white))
                    break;
            }
        }
        for (int column = position.first - 1; column >= 0; column--) {
            if(!isNotOccupied(column, position.second, white, black))
                break;
            if (column != position.first && !isCheck(pieces, yourKing)) {
                possibleMoves.add(new Pair<>(column, position.second));
                if(!isNotOccupied(column, position.second, black, white))
                    break;
            }
        }

        // Ruchy na skosach

        // Ruchy na prawo-górę
        for(int column = position.first + 1; column < 8; column++)
        {
            int row = position.second + column - position.first;
            if (!isNotOccupied(column, row, white, black) || row > 7)
                break;
            if (!isCheck(pieces, yourKing)) {
                possibleMoves.add(new Pair<>(column, row));
                if(!isNotOccupied(column, row, black, white))
                    break;
            }
        }

        // Ruchy na lewo-górę
        for(int column = position.first - 1; column >= 0; column--)
        {
            int row = position.second + position.first - column;
            if (!isNotOccupied(column, row, white, black) || row > 7)
                break;
            if (!isCheck(pieces, yourKing)) {
                possibleMoves.add(new Pair<>(column, row));
                if(!isNotOccupied(column, row, black, white))
                    break;
            }
        }

        // Ruchy na prawo-dół
        for(int column = position.first + 1; column < 8; column++)
        {
            int row = position.second - (column - position.first);
            if (!isNotOccupied(column, row, white, black) || row < 0)
                break;
            if (!isCheck(pieces, yourKing)) {
                possibleMoves.add(new Pair<>(column, row));
                if(!isNotOccupied(column, row, black, white))
                    break;
            }
        }

        // Ruchy na lewo-dół
        for(int column = position.first - 1; column >= 0; column--)
        {
            int row = position.second - (position.first - column);
            if (!isNotOccupied(column, row, white, black) || row < 0)
                break;
            if (!isCheck(pieces, yourKing)) {
                possibleMoves.add(new Pair<>(column, row));
                if(!isNotOccupied(column, row, black, white))
                    break;
            }
        }

        movesList = possibleMoves;
        return possibleMoves;
    }

    @Override
    protected boolean isAttacking(Piece piece, Pair<Integer, Integer> kingPosition) {
        /// Sprawdzamy, czy figura atakuje króla na wprost (pionowo, poziomo lub na skos)
        return Objects.equals(piece.getPosition().first, kingPosition.first) || Objects.equals(piece.getPosition().second, kingPosition.second) || Math.abs(piece.getPosition().first - kingPosition.first) == Math.abs(piece.getPosition().second - kingPosition.second);
    }
}