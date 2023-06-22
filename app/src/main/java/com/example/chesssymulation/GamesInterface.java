package com.example.chesssymulation;

/**
 * Obsługa wiersza games_row.xml
 */
public interface GamesInterface {

    /** Metoda określająca co ma zostać wykonane po naciśnięciu wiersza z zapisem partii
     * @param position pozycja adaptera - pozwala określić dla którego wiersza ma zostać wykonane działanie
     */
    void onItemClick(int position);

    /** Metoda usuwająca zapis partii po naciśnięciu przycisku X
     * @param position pozycja adaptera - pozwala określić dla którego wiersza ma zostać wykonane działanie
     */
    void onBtnDeleteClick(int position);

    /** Metoda wyświetlająca pozycje początkową po naciśnięciu przycisku z obrazem króla
     * @param position pozycja adaptera - pozwala określić dla którego wiersza ma zostać wykonane działanie
     */
    void onBtnStartingPositionClick(int position);
}
