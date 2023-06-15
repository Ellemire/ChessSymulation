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

        // Ruchy na prawo-górę
        for(int column = position.first + 1; column < 8; column++)
        {
            int row = position.second + column - position.first;
            if (!isNotOccupied(column, row, white, black) || row > 7)
                break;
            if (isNotOccupied(column, row, white, black)) {
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
            if (isNotOccupied(column, row, white, black)) {
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
            if (isNotOccupied(column, row, white, black)) {
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
            if (isNotOccupied(column, row, white, black)) {
                possibleMoves.add(new Pair<>(column, row));
                if(!isNotOccupied(column, row, black, white))
                    break;
            }
        }

        movesList = possibleMoves;
        return possibleMoves;
    }
}