package com.example.sae402airhockey;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

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
        findViewById(R.id.btnMenu).setOnClickListener(v -> finish());
    }
}
