package com.example.sae402airhockey;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private LinearLayout canvasLayout = null;
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


        // AJOUT
        // Récupérer la liste des pseudos
        ArrayList<String> pseudos = getIntent().getStringArrayListExtra("PLAYER_PSEUDOS");

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
    }
}