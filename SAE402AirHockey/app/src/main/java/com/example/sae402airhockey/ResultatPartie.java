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

        // Déterminer le gagnant
        if (score1 > score2) {
            textWinner.setText("Victoire de " + pseudos.get(0));
        } else if (score2 > score1) {
            textWinner.setText("Victoire de " + pseudos.get(1));
        } else {
            textWinner.setText("Égalité !");
        }

        textScoreFinal.setText(score1 + " - " + score2);
        updateClassement(pseudos, score1, score2);
        findViewById(R.id.btnMenu).setOnClickListener(v -> finish());
    }

    private void updateClassement(ArrayList<String> pseudos, int score1, int score2) {
        Executors.newSingleThreadExecutor().execute(() -> {
            AppDataBase db = AppDataBase.getAppDataBase(getApplicationContext());
            PlayerDAO playerDAO = db.getPlayerDAO();

            // Joueur 1
            Player p1 = playerDAO.getPlayerByName(pseudos.get(0));
            if (p1 != null) {
                p1.nbTotalPoints += score1;
                p1.nbGamesPlayed++; // +1 partie jouée
                if (score1 > score2) p1.nbGamesWon++;
                playerDAO.updatePlayer(p1);
            }

            // Joueur 2
            Player p2 = playerDAO.getPlayerByName(pseudos.get(1));
            if (p2 != null) {
                p2.nbTotalPoints += score2;
                p2.nbGamesPlayed++; // +1 partie jouée
                if (score2 > score1) p2.nbGamesWon++;
                playerDAO.updatePlayer(p2);
            }
        });
    }
}
