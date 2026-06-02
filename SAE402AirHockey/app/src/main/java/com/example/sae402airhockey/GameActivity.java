package com.example.sae402airhockey;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private LinearLayout canvasLayout = null;

    // Score des Joueurs
    private int scoreP1 = 0;
    private int scoreP2 = 0;
    GameView customGameView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        /*setContentView(R.layout.sample_game_view);
        canvasLayout = (LinearLayout)findViewById(R.id.drawGameView);
        customGameView = new GameView(this);
        canvasLayout.addView(customGameView);
        setContentView(canvasLayout); */
        setContentView(R.layout.activity_game);

        // PSEUDO
        // Récupérer la liste des pseudos
        ArrayList<String> pseudos = getIntent().getStringArrayListExtra("PLAYER_PSEUDOS");

        // En 2vs2
        // Joueur 2 devient Joueur 3 au niveau de l'affichage :
        // Équipe 1 = J1 et J3
        // Équipe 2 = J2 et J4

        if (pseudos != null) {
            // Récupérer les TextView
            TextView firstPlayerPseudo = findViewById(R.id.firstPlayerPseudo);
            TextView secondPlayerPseudo = findViewById(R.id.secondPlayerPseudo);
            TextView thirdPlayerPseudo = findViewById(R.id.thirdPlayerPseudo);
            TextView fourthPlayerPseudo = findViewById(R.id.fourthPlayerPseudo);

            // Afficher les pseudos selon le nombre de joueurs
            if (pseudos.size() >= 2) {
                firstPlayerPseudo.setText(pseudos.get(0));
                secondPlayerPseudo.setText(pseudos.get(1));
            }

            if (pseudos.size() == 4) {
                thirdPlayerPseudo.setText(pseudos.get(2));
                thirdPlayerPseudo.setVisibility(View.VISIBLE); // Affiche le J3

                fourthPlayerPseudo.setText(pseudos.get(3));
                fourthPlayerPseudo.setVisibility(View.VISIBLE); // Affiche le J4
            }
        }

        // SCORE
        // Récupérer les TextView
        TextView textScoreP1 = findViewById(R.id.firstPlayerScore);
        TextView textScoreP2 = findViewById(R.id.secondPlayerScore);

        // Bouton pour ajouter un point au Joueur 1 (ou Équipe 1)
        Button btnAddScoreP1 = findViewById(R.id.addScoreP1);
        btnAddScoreP1.setOnClickListener(v -> {
            scoreP1++;
            textScoreP1.setText(String.valueOf(scoreP1));
        });

        // Bouton pour ajouter un point au Joueur 2 (ou Équipe 2)
        Button btnAddScoreP2 = findViewById(R.id.addScoreP2);
        btnAddScoreP2.setOnClickListener(v -> {
            scoreP2++;
            textScoreP2.setText(String.valueOf(scoreP2));
        });
    }
}