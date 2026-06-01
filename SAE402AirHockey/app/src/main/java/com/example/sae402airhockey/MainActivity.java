package com.example.sae402airhockey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Mode de jeu 1VS1 -> Sélection pseudo
        Button btn1vs1 = findViewById(R.id.btnPlaySolo);
        btn1vs1.setOnClickListener(v -> {
            Intent intent = new Intent(this, SelectionPseudo.class);
            intent.putExtra("NB_PLAYERS", 2); // 2 Joueurs
            startActivity(intent);
        });

        // Mode de jeu 2VS2 -> Sélection pseudo
        Button btn2vs2 = findViewById(R.id.btnPlayTeam);
        btn2vs2.setOnClickListener(v -> {
            Intent intent = new Intent(this, SelectionPseudo.class);
            intent.putExtra("NB_PLAYERS", 4); // 4 Joueurs
            startActivity(intent);
        });

        // Accueil -> Historique
        Button btnHistorique = findViewById(R.id.btnHistorique);
        btnHistorique.setOnClickListener(v -> {
            Intent intent = new Intent(this, Historique.class);
            startActivity(intent);
        });

        // Accueil -> Classement
        Button btnClassement = findViewById(R.id.btnClassement);
        btnClassement.setOnClickListener(v -> {
            Intent intent = new Intent(this, Classement.class);
            startActivity(intent);
        });
    }
}