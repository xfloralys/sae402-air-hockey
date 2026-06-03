package com.example.sae402airhockey;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sae402airhockey.database.AppDataBase;
import com.example.sae402airhockey.database.Player;
import com.example.sae402airhockey.database.PlayerDAO;

import java.util.ArrayList;
import java.util.concurrent.Executors;

public class ResultatPartie extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_partie);

        ArrayList<String> pseudos = getIntent().getStringArrayListExtra("PLAYER_PSEUDOS");
        int score1 = getIntent().getIntExtra("SCORE_P1", 0);
        int score2 = getIntent().getIntExtra("SCORE_P2", 0);

        TextView textWinner = findViewById(R.id.textWinner);
        TextView textScoreFinal = findViewById(R.id.textScoreFinal);

        textScoreFinal.setText(score1 + " - " + score2);

        boolean isModeEquipe = pseudos.size() > 2;

        if (score1 > score2) {
            if (isModeEquipe) {
                textWinner.setText("Victoire de l'Équipe 1 !");
            } else {
                textWinner.setText("Victoire de " + pseudos.get(0));
            }
        } else if (score2 > score1) {
            if (isModeEquipe) {
                textWinner.setText("Victoire de l'Équipe 2 !");
            } else {
                textWinner.setText("Victoire de " + pseudos.get(1));
            }
        } else {
            textWinner.setText("Égalité !");
        }

        findViewById(R.id.btnMenu).setOnClickListener(v -> finish());
    }

    private void updateClassement(ArrayList<String> pseudos, int score1, int score2) {
        Executors.newSingleThreadExecutor().execute(() -> {
            AppDataBase db = AppDataBase.getAppDataBase(getApplicationContext());
            PlayerDAO playerDAO = db.getPlayerDAO();

            // Équipe 1 : Joueur 1 et Joueur 3
            updatePlayerStats(playerDAO, pseudos.get(0), score1, score1 > score2);
            if (pseudos.size() >= 3) {
                updatePlayerStats(playerDAO, pseudos.get(2), score1, score1 > score2);
            }

            // Équipe 2 : Joueur 2 et Joueur 4
            updatePlayerStats(playerDAO, pseudos.get(1), score2, score2 > score1);
            if (pseudos.size() >= 4) {
                updatePlayerStats(playerDAO, pseudos.get(3), score2, score2 > score1);
            }
        });
    }

    private void updatePlayerStats(PlayerDAO dao, String name, int pointsPartie, boolean aGagne) {
        Player p = dao.getPlayerByName(name);
        if (p != null) {
            p.nbTotalPoints += pointsPartie; // Points au total
            p.nbGamesPlayed++;               // Nombre de parties totales
            if (aGagne) p.nbGamesWon++;      // Victoires gagnées
            dao.updatePlayer(p);
        }
    }
}
