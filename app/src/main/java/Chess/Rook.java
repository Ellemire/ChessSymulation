package Chess;

import android.util.Pair;

import java.util.ArrayList;

public class Rook extends Piece {

    private boolean wasMoved;

    //gettery i settery
    public boolean isWasMoved() {
        return wasMoved;
    }
    public void setWasMoved(boolean wasMoved) {
        this.wasMoved = wasMoved;
    }

    //konstruktor
    public Rook(Pair<Integer, Integer> position, boolean color){
        super(position,color);
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Piece yourKing) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.addAll(white);
        pieces.addAll(black);

        // Ruchy wzdłuż kolumn
        for (int row = 0; row < 8; row++) {
            if (!IsNotOccupied(position.first, row, white, black))
                break;

            if (row != position.second && IsNotOccupied(position.first, row, white, black) && !isCheck(pieces, yourKing)) {
                possibleMoves.add(new Pair<>(position.first, row));
            }
        }

        // Ruchy wzdłuż wierszy
        for (int column = 0; column < 8; column++) {
            if(!IsNotOccupied(column, position.second, white, black))
                break;

            if (column != position.first && IsNotOccupied(column, position.second, white, black) && !isCheck(pieces, yourKing)) {
                possibleMoves.add(new Pair<>(column, position.second));
            }
        }
        movesList = possibleMoves;
        return possibleMoves;
    }

    @Override
    protected boolean isAttacking(Piece piece, Pair<Integer, Integer> kingPosition) {
        // Sprawdzamy, czy figura atakuje króla na wprost (pionowo, poziomo)
        if (piece.getPosition().first == kingPosition.first) {
            /*for(int i=piece.getPosition().second; i<kingPosition.second; i++)
            {
                if(!IsNotOccupied(piece.getPosition().first,i,))
            }*/
            return true;
        }
        if (piece.getPosition().second == kingPosition.second)
        {
            return true;
        }
        return false;
    }
}
