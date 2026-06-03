package com.example.sae402airhockey;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements View.OnTouchListener {
    private int compteur = 10;

    // Score des Joueurs
    private int scoreP1 = 0;
    private int scoreP2 = 0;

    private ArrayList<String> pseudos;

    // Gestion des poignées et du palet
    private LinearLayout canvasLayout = null;
    GameView customGameView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.sample_game_view);

        canvasLayout = (LinearLayout)findViewById(R.id.drawGameView);
        customGameView = new GameView(getApplicationContext());
        customGameView.setOnTouchListener(this);
        canvasLayout.addView(customGameView);
        setContentView(canvasLayout);

        setContentView(R.layout.activity_game);

        // Récupérer la liste des pseudos

        pseudos = getIntent().getStringArrayListExtra("PLAYER_PSEUDOS");

        // En 2vs2
        // Joueur 2 devient Joueur 3 au niveau de l'affichage :
        // Équipe 1 = J1 et J3
        // Équipe 2 = J2 et J4

        // PSEUDO
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

        // TEST POUR LES SCORES
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

        // END GAME
        findViewById(R.id.addScoreP1).setOnClickListener(v -> {
            scoreP1++;
            textScoreP1.setText(String.valueOf(scoreP1));
            checkEndOfGame();
        });

        findViewById(R.id.addScoreP2).setOnClickListener(v -> {
            scoreP2++;
            textScoreP2.setText(String.valueOf(scoreP2));
            checkEndOfGame();
        });
    }

    // Méthode pour vérifier la fin
    private void checkEndOfGame() {
        compteur--;
        if (compteur <= 0) {
            Intent intent = new Intent(this, ResultatPartie.class);
            intent.putExtra("SCORE_P1", scoreP1);
            intent.putExtra("SCORE_P2", scoreP2);
            intent.putStringArrayListExtra("PLAYER_PSEUDOS", this.pseudos);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view instanceof SurfaceView) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            customGameView.setCircleX(x);
            customGameView.setCircleY(y);
            customGameView.drawPlayer();
            return true;
        } else {
            return false;
        }
    }
}