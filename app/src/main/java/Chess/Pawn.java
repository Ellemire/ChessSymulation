package Chess;

import android.util.Pair;

import java.util.ArrayList;
public class Pawn extends Piece {

    public Pawn(Pair<Integer, Integer> position, boolean color, ArrayList<Pair<Integer,Integer>> movesList){super(position,color,movesList);}
    public ArrayList<Pair<Integer, Integer>> calculatePossiblePawnMoves(int currentColumn, int currentRow) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();

        int forwardRow;
        int doubleForwardRow;
        int attackColumnLeft;
        int attackColumnRight;

        if (currentRow == 1) {
            forwardRow = currentRow + 1;
            doubleForwardRow = currentRow + 2;
        } else if (currentRow == 6) {
            forwardRow = currentRow - 1;
            doubleForwardRow = currentRow - 2;
        } else {
            forwardRow = currentRow + 1;
            doubleForwardRow = currentRow - 1;
        }

        attackColumnLeft = currentColumn - 1;
        attackColumnRight = currentColumn + 1;
        Check();
        if (isValidSquare(currentColumn, forwardRow) && IsNotOccupied(currentColumn, forwardRow) && !isCheck){
            possibleMoves.add(new Pair<>(currentColumn, forwardRow));
        }
        Check();
        if (isValidSquare(currentColumn, doubleForwardRow) && IsNotOccupied(currentColumn, doubleForwardRow) && !isCheck) {
            possibleMoves.add(new Pair<>(currentColumn, doubleForwardRow));
        }
        Check();
        if (isValidSquare(attackColumnLeft, forwardRow) && IsNotOccupied(attackColumnLeft, forwardRow) && !isCheck) {
            possibleMoves.add(new Pair<>(attackColumnLeft, forwardRow));
        }

        Check();
        if (isValidSquare(attackColumnRight, forwardRow) && IsNotOccupied(attackColumnRight, forwardRow) && !isCheck) {
            possibleMoves.add(new Pair<>(attackColumnRight, forwardRow));
        }

        return possibleMoves;
    }

    private static boolean isValidSquare(int column, int row) {
        return column >= 0 && column < 8 && row >= 0 && row < 8;
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


    public void Generate_Pawn(){
        int currentColumn = position.second;
        int currentRow = position.first;

        ArrayList<Pair<Integer, Integer>> possibleMoves = calculatePossiblePawnMoves(currentColumn, currentRow);
        for(Pair<Integer, Integer> moves : possibleMoves) {
            movesList.add(moves);
        }
    }
}
