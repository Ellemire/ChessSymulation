package Chess;

import java.io.Serializable;
import java.util.ArrayList;

/** Klasa odpowiedzialna za zapis partii
 *
 */
public class GameRecord implements Serializable {
    private final String time;
    private final ArrayList<String> moves;
    private final int numberOfMoves;
    private final String startingPosition;

    /** Konstruktor obiektów klasy games record.
     * @param time czas zakończenia partii
     * @param moves lista wykonanych ruchów
     * @param startingPosition zapis pozycji startowej
     */
    public GameRecord(String time, ArrayList<String> moves, String startingPosition) {
        this.time = time;
        this.moves = moves;
        numberOfMoves = moves.size() / 2;
        this.startingPosition = startingPosition;
    }

    /** Getter dla czasu zakończenia symulacji.
     * @return czas zakończenia symulacji
     */
    public String getTime() {
        return time;
    }

    /** Getter dla wykonanych ruchów.
     * @return lista wykonanych ruchów
     */
    public ArrayList<String> getMoves() {
        return moves;
    }

    /** Getter dla liczby ruchów.
     * @return liczba wykonanych ruchów
     */
    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    /** Getter dla pozycji początkowej.
     * @return zapis pozycji początkowej
     */
    public String getStartingPosition() {
        return startingPosition;
    }
}
