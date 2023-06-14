package com.example.chesssymulation;

import android.app.Activity;
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

    private Context context;
    private Activity activity;
    private ArrayList<GameRecord> games;
    private  final GamesInterface gamesInterface;

    public GamesAdapter(Context context, Activity activity, ArrayList<GameRecord> games, GamesInterface gamesInterface) {
        this.context = context;
        this.activity = activity;
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
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_id, txt_numberOfMoves, txt_time;
        ImageButton ibtn_delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_id = itemView.findViewById(R.id.txt_id);
            txt_numberOfMoves = itemView.findViewById(R.id.txt_numberOfMoves);
            txt_time = itemView.findViewById(R.id.txt_time);
            ibtn_delete = itemView.findViewById(R.id.ibtn_delete);

            ibtn_delete.setOnClickListener(v -> {
                if(gamesInterface != null)
                {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION)
                        gamesInterface.onBtnDeleteClick(position);
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
