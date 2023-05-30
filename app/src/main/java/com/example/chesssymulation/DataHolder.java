package com.example.chesssymulation;

import android.widget.ImageButton;

import java.util.ArrayList;

public enum DataHolder {
    INSTANCE;

    private ArrayList<ArrayList<ImageButton>> mObjectList;

    public static boolean hasData(){
        return INSTANCE.mObjectList != null;
    }

    public static void setData(final ArrayList<ArrayList<ImageButton>> objectList) {
        INSTANCE.mObjectList = objectList;
    }

    public static ArrayList<ArrayList<ImageButton>> getData() {
        final ArrayList<ArrayList<ImageButton>> retList = INSTANCE.mObjectList;
        INSTANCE.mObjectList = null;
        return retList;
    }
}
