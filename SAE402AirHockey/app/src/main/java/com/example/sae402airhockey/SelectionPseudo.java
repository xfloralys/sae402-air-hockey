package com.example.sae402airhockey;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sae402airhockey.database.AppDataBase;
import com.example.sae402airhockey.database.Player;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectionPseudo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectionPseudo extends AppCompatActivity {

    // ajout ia
    TextView labelPseudoJoueur;
    EditText inputPseudo;
    Button btnValider;
    private int totalPlayers;
    private int currentPlayerIndex = 1;
    private ArrayList<String> playerPseudos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fragment_selection_pseudo); // On garde le même layout

        // Gestion des marges système (barre d'état, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.header), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // -------------------------------------------
        // Récupérer le nombre de joueurs
        totalPlayers = getIntent().getIntExtra("NB_PLAYERS", 2);

        labelPseudoJoueur = findViewById(R.id.labelPseudoJoueur);
        inputPseudo = findViewById(R.id.inputPseudo);
        btnValider = findViewById(R.id.btnValider);

        // Mettre à jour l'affichage du label
        updateLabel();

        btnValider.setOnClickListener(v -> {
            String pseudo = inputPseudo.getText().toString().trim();
            if (!pseudo.isEmpty()) {
                savePlayerAndNext(pseudo);
            } else {
                Toast.makeText(this, "Veuillez entrer un pseudo", Toast.LENGTH_SHORT).show();
            }
        });

    }

    // Mettre à jour l'affichage du label
    private void updateLabel() {
        labelPseudoJoueur.setText("Pseudo du joueur " + currentPlayerIndex + " :");
        inputPseudo.setText(""); // On vide le champ pour le joueur suivant
    }

    // Sauvegarder le pseudo et passer aux joueurs suivants
    private void savePlayerAndNext(java.lang.String pseudo) {
        // Room interdit les opérations sur le thread principal (UI)
        // On utilise donc un Executor pour sauvegarder en arrière-plan
        java.util.concurrent.Executors.newSingleThreadExecutor().execute(() -> {
            AppDataBase db = AppDataBase.getAppDataBase(getApplicationContext());
            Player player = new Player(pseudo);
            db.getPlayerDAO().insertPlayer(player);

            // Retour sur le thread principal pour mettre à jour l'interface
            runOnUiThread(() -> {
                playerPseudos.add(pseudo);
                if (currentPlayerIndex < totalPlayers) {
                    currentPlayerIndex++;
                    updateLabel();
                } else {
                    // Tous les joueurs ont été saisis, on lance le jeu
                    Intent intent = new Intent(SelectionPseudo.this, GameActivity.class);
                    intent.putStringArrayListExtra("PLAYER_PSEUDOS", playerPseudos);
                    startActivity(intent);
                    finish();
                }
            });
        });
    }
}