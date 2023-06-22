package com.example.chesssymulation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Chess.GameRecord;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.MyViewHolder> {

    private final Context context;
    private final ArrayList<GameRecord> games;
    private  final GamesInterface gamesInterface;

    /** Konstruktor dla Adaptera odpowiedzialnego za wyświetlanie zagranych partii
     * @param context kontekst danych
     * @param games zagrane gry
     * @param gamesInterface interfejs GameInterface
     */
    public GamesAdapter(Context context, ArrayList<GameRecord> games, GamesInterface gamesInterface) {
        this.context = context;
        this.games = games;
        this.gamesInterface = gamesInterface;
    }

    @NonNull
    @Override
    public GamesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.games_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GamesAdapter.MyViewHolder holder, int position) {
        holder.txt_id.setText(String.valueOf(position + 1));
        holder.txt_numberOfMoves.setText(String.valueOf(games.get(position).getNumberOfMoves()));
        holder.txt_time.setText(games.get(position).getTime());
        holder.txt_result.setText(games.get(position).getMoves().get(games.get(position).getMoves().size() - 1).equals(" ") ? games.get(position).getMoves().get(games.get(position).getMoves().size() - 2) : games.get(position).getMoves().get(games.get(position).getMoves().size() - 1));
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

     /**
     * Klasa przechowująca dane, które są wyświetlane na games_row.xml
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_id, txt_numberOfMoves, txt_time, txt_result;
        ImageButton ibtn_delete, ibtn_startingPosition;

        /** Konstruktor klasy MyViewHolder
         * @param itemView wiersz zapisu partii
         */
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_id = itemView.findViewById(R.id.txt_id);
            txt_numberOfMoves = itemView.findViewById(R.id.txt_numberOfMoves);
            txt_time = itemView.findViewById(R.id.txt_time);
            txt_result = itemView.findViewById(R.id.txt_result);
            ibtn_delete = itemView.findViewById(R.id.ibtn_delete);
            ibtn_startingPosition = itemView.findViewById(R.id.ibtn_startingPosition);

            ibtn_delete.setOnClickListener(v -> {
                if(gamesInterface != null)
                {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION)
                        gamesInterface.onBtnDeleteClick(position);
                }
            });

            ibtn_startingPosition.setOnClickListener(v -> {
                if(gamesInterface != null)
                {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION)
                        gamesInterface.onBtnStartingPositionClick(position);
                }
            });

            itemView.setOnClickListener(v -> {
                if(gamesInterface != null)
                {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION)
                        gamesInterface.onItemClick(position);
                }
            });
        }
    }
}
