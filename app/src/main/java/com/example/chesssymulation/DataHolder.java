package com.example.chesssymulation;

import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * enum odpowadający za przekzaywanie danych między PrepareActivity a SymulationActivity
 */
public enum DataHolder {
    INSTANCE;

    /**
     * lista przekazywanych obiektówobiektów
     */
    private ArrayList<ArrayList<ImageButton>> mObjectList;

    /** metoda zwracająca informacje czy DataHolder zawiera dane
     * @return czy zawiera dane
     */
    public static boolean hasData(){
        return INSTANCE.mObjectList != null;
    }

    /** Metoda pozwalająca na przypisanie danych
     * @param objectList lista przycisków
     */
    public static void setData(final ArrayList<ArrayList<ImageButton>> objectList) {
        INSTANCE.mObjectList = objectList;
    }

    /** Metoda zwracająca przypisane dane
     * @return lista przycisków odpowiadająca polom na szachownicy
     */
    public static ArrayList<ArrayList<ImageButton>> getData() {
        final ArrayList<ArrayList<ImageButton>> retList = INSTANCE.mObjectList;
        INSTANCE.mObjectList = null;
        return retList;
    }
}
