package Chess;

import android.util.Pair;

import java.util.ArrayList;
public class Piece {

    Pair<Integer, Integer> position;
    Pair<Integer, Integer> kingPosition;
    ArrayList<Pair<Integer, Integer>> movesList;
    ArrayList<Pair<Integer,Integer>> PiecesListWhite;
    ArrayList<Pair<Integer,Integer>> PiecesListBlack;

    public Piece(Pair<Integer, Integer> position, boolean color, ArrayList<Pair<Integer,Integer>> movesList){}
    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    boolean color;
    public void getPiecesList(){}

    public void setPiecesList(){}

    public void possibleMoves() {
    }

    public boolean isMovable() {
        return false;
    }

    public void Position() {
        Square square = new Square(10, 10); // tu jakoś przekażesz dane z szachownicy
        square.getPosition();
    }

    public void KingCreate() {
        King king = new King(position, color, movesList);
        if(!color)//biały
            PiecesListWhite.add(position);

        if(color)//czarny
            PiecesListBlack.add(position);

        kingPosition = position;
    }
    public void BishopCreate() {
        Bishop bishop= new Bishop(position, color, movesList);
        if(!color)//biały
            PiecesListWhite.add(position);

        if(color)//czarny
            PiecesListBlack.add(position);
    }
    public void KnightCreate() {
        Knight knight = new Knight(position, color, movesList);
        if(!color)//biały
            PiecesListWhite.add(position);

        if(color)//czarny
            PiecesListBlack.add(position);
    }
    public void PawnCreate() {
        Pawn pawn= new Pawn(position, color, movesList);
        if(!color)//biały
            PiecesListWhite.add(position);

        if(color)//czarny
            PiecesListBlack.add(position);
    }
    public void RookCreate() {
        Rook rook= new Rook(position, color, movesList);
        if(!color)//biały
            PiecesListWhite.add(position);

        if(color)//czarny
            PiecesListBlack.add(position);
    }
    public void QueenCreate() {
        Queen queen= new Queen(position, color, movesList);
        if(!color)//biały
            PiecesListWhite.add(position);

        if(color)//czarny
            PiecesListBlack.add(position);
    }
}

