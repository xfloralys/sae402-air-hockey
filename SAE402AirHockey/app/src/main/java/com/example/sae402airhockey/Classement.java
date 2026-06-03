package com.example.sae402airhockey;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sae402airhockey.database.AppDataBase;
import com.example.sae402airhockey.database.Player;

import java.util.concurrent.Executors;

public class Classement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_classement);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.btnBackMain).setOnClickListener(v -> {
            Intent intent = new Intent(Classement.this, MainActivity.class);
            startActivity(intent);
        });

        // Dans onCreate de Classement.java
        RecyclerView recyclerView = findViewById(R.id.affichageClassement);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

// Charger les données en arrière-plan
        Executors.newSingleThreadExecutor().execute(() -> {
            AppDataBase db = AppDataBase.getAppDataBase(getApplicationContext());
            Player[] sortedPlayers = db.getPlayerDAO().getAllPlayersSortedByPoints();

            runOnUiThread(() -> {
                ClassementAdapter adapter = new ClassementAdapter(sortedPlayers);
                recyclerView.setAdapter(adapter);
            });
        });
    }
}