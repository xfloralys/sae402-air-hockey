package com.example.sae402airhockey;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sae402airhockey.database.Game;

import java.util.List;

public class HistoriqueAdapter extends ArrayAdapter<Game> {
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
    }
}
