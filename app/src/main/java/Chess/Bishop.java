package Chess;

import android.util.Pair;

import java.util.ArrayList;

public class Bishop extends Piece {

    boolean isCheck;

    //konstruktor
    public Bishop(Pair<Integer, Integer> position, boolean color){
        super(position, color);
        if(!color)//biały
            PiecesListWhite.add(position);
        if(color)//czarny
            PiecesListBlack.add(position);
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves() {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();

        // Ruchy na prawo-górę
        int column = position.first + 1;
        int row = position.second + 1;
        Check();
        while (column < 8 && row < 8 && IsNotOccupied(column, row) && !isCheck ) {
            possibleMoves.add(new Pair<>(column, row));
            column++;
            row++;
            Check();
        }

        // Ruchy na lewo-górę
        column = position.first - 1;
        row = position.second + 1;
        Check();
        while (column >= 0 && row < 8 && IsNotOccupied(column, row) && !isCheck) {
            possibleMoves.add(new Pair<>(column, row));
            column--;
            row++;
            Check();
        }

        // Ruchy na prawo-dół
        column = position.first + 1;
        row = position.second - 1;
        Check();
        while (column < 8 && row >= 0 && IsNotOccupied(column, row) && !isCheck) {
            possibleMoves.add(new Pair<>(column, row));
            column++;
            row--;
            Check();
        }

        // Ruchy na lewo-dół
        column = position.first - 1;
        row = position.second - 1;
        Check();
        while (column >= 0 && row >= 0 && IsNotOccupied(column, row) && !isCheck) {
            possibleMoves.add(new Pair<>(column, row));
            column--;
            row--;
            Check();
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

    private void Check() {
        ArrayList<Pair<Integer, Integer>> pieces = new ArrayList<>();
        if(color)
            isCheck= isCheck(PiecesListBlack, kingPosition);
        if(!color)
            isCheck= isCheck(PiecesListWhite, kingPosition);
    }
}