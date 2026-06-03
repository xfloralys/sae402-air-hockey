package com.example.sae402airhockey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Grid;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sae402airhockey.database.AppDataBase;
import com.example.sae402airhockey.database.Game;
import com.example.sae402airhockey.database.GameDAO;

public class Historique extends AppCompatActivity {
    private GameDAO daoQuery;
    private Activity a;
    private HistoriqueAdapter recyclerAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_historique);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.btnBackMain).setOnClickListener(v -> {
            Intent intent = new Intent(Historique.this, MainActivity.class);
            startActivity(intent);
        });

        a = this;
        new Thread(() -> {
            accessDataBase();
            Game[] gameList = daoQuery.getAllGame();

            // Game gameTest = new Game("John", 0, 3, "Jane");
            // Game gameTest2 = new Game("Bob", 7, 1, "Gabriel");

            runOnUiThread(
                () -> {
                    GridLayoutManager glm = new GridLayoutManager(this, 1);
                    recyclerView = findViewById(R.id.affichageHistorique);
                    recyclerView.setLayoutManager(glm);
                    recyclerAdapter = new HistoriqueAdapter(a, gameList);
                    recyclerView.setAdapter(recyclerAdapter);
                }
            );
        }).start();
    }

    public void accessDataBase() {
        AppDataBase dbAccess = AppDataBase.getAppDataBase(this);
        daoQuery = dbAccess.getGameDAO();
    }
}