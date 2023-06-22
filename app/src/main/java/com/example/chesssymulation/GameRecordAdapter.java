package com.example.chesssymulation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GameRecordAdapter extends RecyclerView.Adapter<GameRecordAdapter.MyViewHolder> {

    private final Context context;
    private final ArrayList<String> moves;

    /** Konstruktor dla Adaptera odpowiedzialnego za wyświetlanie wykonanych ruchów
     * @param context kontekst danych
     * @param moves wykonane ruchy
     */
    public GameRecordAdapter(Context context, ArrayList<String> moves) {
        this.context = context;
        this.moves = moves;
    }

    @NonNull
    @Override
    public GameRecordAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.game_record_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameRecordAdapter.MyViewHolder holder, int position) {
        holder.txt_id.setText(String.valueOf(position + 1));
        holder.txt_whiteMove.setText(moves.get(2 * position));
        holder.txt_blackMove.setText(moves.get(2 * position + 1));
    }

    @Override
    public int getItemCount() {
        return moves.size() / 2;
    }

    /**
     * Klasa przechowująca dane, które są wyświetlane na game_record_row.xml
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_id, txt_whiteMove, txt_blackMove;

        /** Konstruktor klasy MyViewHolder
         * @param itemView wiersz zapisu partii
         */
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_id = itemView.findViewById(R.id.txt_idMove);
            txt_whiteMove = itemView.findViewById(R.id.txt_whiteMove);
            txt_blackMove = itemView.findViewById(R.id.txt_blackMove);
        }
    }
}
