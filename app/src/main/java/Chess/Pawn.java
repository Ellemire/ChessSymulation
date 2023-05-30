package Chess;

import android.util.Pair;

import java.util.ArrayList;
public class Pawn extends Piece {

    boolean isCheck;

    //konstruktor
    public Pawn(Pair<Integer, Integer> position, boolean color) {
        super(position, color);

        if(!color)//biały
            PiecesListWhite.add(position);
        if(color)//czarny
            PiecesListBlack.add(position);
    }

    public ArrayList<Pair<Integer, Integer>> calculatePossiblePawnMoves() {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();

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
        Check();
        if (isValidSquare(position.first, forwardRow) && IsNotOccupied(position.first, forwardRow) && !isCheck){
            possibleMoves.add(new Pair<>(position.first, forwardRow));
        }
        Check();
        if (isValidSquare(position.first, doubleForwardRow) && IsNotOccupied(position.first, doubleForwardRow) && !isCheck) {
            possibleMoves.add(new Pair<>(position.first, doubleForwardRow));
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

    private void Check(){
        ArrayList<Pair<Integer, Integer>> pieces = new ArrayList<>();
        if(color)
            isCheck= isCheck(PiecesListBlack, kingPosition);
        if(!color)
            isCheck= isCheck(PiecesListWhite, kingPosition);
    }
}
