package com.example.sae402airhockey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sae402airhockey.database.Player;

public class ClassementAdapter extends RecyclerView.Adapter<ClassementAdapter.ViewHolder> {
    private Player[] players;

    public ClassementAdapter(Player[] players) {
        this.players = (players != null) ? players : new Player[0];
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.classement_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Player player = players[position];
        if (player != null) {
            holder.name.setText(player.name);
            holder.points.setText(player.nbTotalPoints + " pts");
            holder.games.setText(player.nbGamesPlayed + " parties");
        }
    }

    @Override
    public int getItemCount() {
        return players.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, points, games;
        public ViewHolder(View itemView) {
            super(itemView);
            // Textes du classement item
            name = itemView.findViewById(R.id.textNom);
            points = itemView.findViewById(R.id.textPoints);
            games = itemView.findViewById(R.id.textParties);
        }
    }
}