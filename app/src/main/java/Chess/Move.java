package Chess;

public class Move {

    private Square square;
    private Piece piece;

    public Piece getPiece() {
        return piece;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Square getSquare() {
        return square;
    }
    public void setSquare(Square square) {
        this.square = square;
    }
    }
