package Chess;

import android.util.Pair;

import java.util.ArrayList;

public class Rook extends Piece {

    //konstruktor
    public Rook(Pair<Integer, Integer> position, boolean color){
        super(position,color);
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Piece yourKing) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();

        // Ruchy wzdłuż kolumn
        for (int row = position.second - 1; row >= 0; row--) {
            if (!isNotOccupied(position.first, row, white, black))
                break;
            possibleMoves.add(new Pair<>(position.first, row));
            if(!isNotOccupied(position.first, row, black, white))
                break;
        }
        for (int row = position.second + 1; row < 8; row++) {
            if (!isNotOccupied(position.first, row, white, black))
                break;
            possibleMoves.add(new Pair<>(position.first, row));
            if(!isNotOccupied(position.first, row, black, white))
                break;
        }

        // Ruchy wzdłuż wierszy
        for (int column = position.first + 1; column < 8; column++) {
            if(!isNotOccupied(column, position.second, white, black))
                break;
            possibleMoves.add(new Pair<>(column, position.second));
            if(!isNotOccupied(column, position.second, black, white))
                break;
        }
        for (int column = position.first - 1; column >= 0; column--) {
            if(!isNotOccupied(column, position.second, white, black))
                break;
            possibleMoves.add(new Pair<>(column, position.second));
            if(!isNotOccupied(column, position.second, black, white))
                break;
        }

        movesList = possibleMoves;
        return possibleMoves;
    }
}
