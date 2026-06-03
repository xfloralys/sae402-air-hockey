package com.example.sae402airhockey;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sae402airhockey.database.Game;

import java.util.List;

public class HistoriqueAdapter extends RecyclerView.Adapter<HistoViewHolder> {

    private Context c;
    private Game[] gameList;

    public HistoriqueAdapter(Context c, Game[] gameList) {
        this.c = c;
        this.gameList = gameList;
    }

    @NonNull
    @Override
    public HistoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.historique_item, parent, false);
        return new HistoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoViewHolder holder, int position) {
        holder.teamOne.setText(gameList[position].playerName);
        String scoreText = gameList[position].playerScore + " VS " + gameList[position].opponentScore;
        holder.score.setText(scoreText);
        holder.teamTwo.setText(gameList[position].opponentName);
    }

    @Override
    public int getItemCount() {
        return gameList.length;
    }

    /*
    public HistoriqueAdapter(Activity context, Game[] games) {
        super(context, 0, games);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View histoItemView = convertView;
        if (histoItemView == null) {
            // Peu importe ce que j'essaie il veut pas reconnaître le listView
            histoItemView = LayoutInflater.from(getContext()).inflate( R.layout.historique_item, parent, false);
        }

        // getItem est implémenté par la classe dont on hérite (ArrayAdapter)
        Game game = getItem(position);

        TextView playerOne = histoItemView.findViewById(R.id.histoPlayerOne);
        TextView score = histoItemView.findViewById(R.id.histoGameScore);
        TextView playerTwo = histoItemView.findViewById(R.id.histoPlayerTwo);
        // playerOne.setText(game.playerName);
        score.setText(game.playerScore + "VS" + game.opponentScore);
        playerTwo.setText(game.opponentName);

        return histoItemView;
    } */
}

class HistoViewHolder extends RecyclerView.ViewHolder {

    TextView teamOne, score, teamTwo;
    public HistoViewHolder(@NonNull View itemView) {
        super(itemView);

        teamOne = itemView.findViewById(R.id.histoPlayerOne);
        score = itemView.findViewById(R.id.histoGameScore);
        teamTwo = itemView.findViewById(R.id.histoPlayerTwo);
    }
}
