package Chess;

import android.util.Pair;

import java.util.ArrayList;

public class Bishop extends Piece {

    //konstruktor
    public Bishop(Pair<Integer, Integer> position, boolean color) {
        super(position, color);
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Piece yourKing) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.addAll(white);
        pieces.addAll(black);

        // Ruchy na prawo-górę
        for(int column = position.first + 1; column < 8; column++)
        {
            for(int row = position.second + 1; row < 8; row++ )
            {
                if (!IsNotOccupied(column, row, white, black))
                    break;
                if (IsNotOccupied(column, row, white, black) && !isCheck(pieces, yourKing)) {
                    possibleMoves.add(new Pair<>(column, row));
                }
            }
        }

        // Ruchy na lewo-górę
        for(int column = position.first - 1; column >= 0; column--)
        {
            for(int row = position.second + 1; row < 8; row++ )
            {
                if (!IsNotOccupied(column, row, white, black))
                    break;
                if (IsNotOccupied(column, row, white, black) && !isCheck(pieces, yourKing)) {
                    possibleMoves.add(new Pair<>(column, row));
                }
            }
        }

        // Ruchy na prawo-dół
        for(int column = position.first + 1; column < 8; column++)
        {
            for(int row = position.second - 1; row >= 0; row--)
            {
                if (!IsNotOccupied(column, row, white, black))
                    break;
                if (IsNotOccupied(column, row, white, black) && !isCheck(pieces, yourKing)) {
                    possibleMoves.add(new Pair<>(column, row));
                }
            }
        }

        // Ruchy na lewo-dół
        for(int column = position.first - 1; column >= 0; column--)
        {
            for(int row = position.second - 1; row >= 0; row--)
            {
                if (!IsNotOccupied(column, row, white, black))
                    break;
                if (IsNotOccupied(column, row, white, black) && !isCheck(pieces, yourKing)) {
                    possibleMoves.add(new Pair<>(column, row));
                }
            }
        }

        movesList = possibleMoves;
        return possibleMoves;
    }

    //poprawić
    @Override
    protected boolean isAttacking(Piece piece, Pair<Integer, Integer> kingPosition) {
        // Sprawdzamy, czy figura atakuje króla na wprost (na skos)
        if (Math.abs(piece.getPosition().first - kingPosition.first) == Math.abs(piece.getPosition().second - kingPosition.second)) {
            return true;
        }
        return false;
    }

}