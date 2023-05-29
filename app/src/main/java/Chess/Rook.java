package Chess;

import android.util.Pair;

import java.util.ArrayList;

public class Rook extends Piece{

    public Rook(Pair<Integer, Integer> position, boolean color, ArrayList<Pair<Integer,Integer>> movesList){super(position,color,movesList);}

    public ArrayList<Pair<Integer, Integer>> calculatePossibleRookMoves(int currentColumn, int currentRow) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();

        // Ruchy wzdłuż kolumn
        for (int row = 0; row < 8; row++) {
            Check();
            if (row != currentRow && IsNotOccupied(currentColumn, row) && !isCheck) {
                possibleMoves.add(new Pair<>(currentColumn, row));
            }
        }

        // Ruchy wzdłuż wierszy
        for (int column = 0; column < 8; column++) {
            Check();
            if (column != currentColumn && IsNotOccupied(column, currentRow) && !isCheck) {
                possibleMoves.add(new Pair<>(column, currentRow));
            }
        }

        return possibleMoves;
    }
    private boolean IsNotOccupied (int column, int row) {
        Pair<Integer, Integer> pair = new Pair<>(column, row);
        if (!color && PiecesListWhite.contains(pair))
            return false;
        if (color && PiecesListBlack.contains(pair))
            return false;
        return true;
    }

    private boolean isCheck(ArrayList<Pair<Integer, Integer>> pieces, Pair<Integer, Integer> kingPosition) {
        for (Pair<Integer, Integer> piece : pieces) {
            if (isAttacking(piece, kingPosition)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAttacking(Pair<Integer, Integer> piece, Pair<Integer, Integer> kingPosition) {
        int pieceColumn = piece.first;
        int pieceRow = piece.second;
        int kingColumn = kingPosition.first;
        int kingRow = kingPosition.second;

        // Sprawdzamy, czy figura atakuje króla na wprost (pionowo, poziomo lub na skos)
        if (pieceColumn == kingColumn || pieceRow == kingRow || Math.abs(pieceColumn - kingColumn) == Math.abs(pieceRow - kingRow)) {
            return true;
        }

        // Sprawdzamy, czy figura atakuje króla jako skoczek
        int columnDiff = Math.abs(pieceColumn - kingColumn);
        int rowDiff = Math.abs(pieceRow - kingRow);
        if (columnDiff == 2 && rowDiff == 1 || columnDiff == 1 && rowDiff == 2) {
            return true;
        }

        // Sprawdzamy, czy figura atakuje króla jako pionek
        int direction = 1; // Kierunek ataku pionka (1 - w górę, -1 - w dół)
        if (pieceRow > kingRow) {
            direction = -1;
        }
        if (pieceColumn == kingColumn + 1 || pieceColumn == kingColumn - 1) {
            if (pieceRow == kingRow + direction) {
                return true;
            }
        }

        return false;
    }
    boolean isCheck;
    private void Check(){
        ArrayList<Pair<Integer, Integer>> pieces = new ArrayList<>();
        if(color)
            isCheck= isCheck(PiecesListBlack, kingPosition);
        if(!color)
            isCheck= isCheck(PiecesListWhite, kingPosition);
    }


    public void Generate_Rook() {
        int currentColumn = position.second;
        int currentRow = position.first;
        ArrayList<Pair<Integer, Integer>> possibleMoves = calculatePossibleRookMoves(currentColumn, currentRow);
        for(Pair<Integer, Integer> moves : possibleMoves) {
            movesList.add(moves);
        }
    }


    public boolean isWasMoved() {
        return wasMoved;
    }

    public void setWasMoved(boolean wasMoved) {
        this.wasMoved = wasMoved;
    }

    private boolean wasMoved;
}
