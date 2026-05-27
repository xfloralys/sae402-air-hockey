package com.example.sae402airhockey;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sae402airhockey.controller.MainActivityController;

public class MainActivity extends AppCompatActivity {
    private Activity a;

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

        findViewById(R.id.btnPlaySolo).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SelectionPseudo.class);
            startActivity(intent);
        });

        findViewById(R.id.btnPlayteam).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SelectionPseudo.class);
            startActivity(intent);
        });

        findViewById(R.id.btnHistorique).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Historique.class);
            startActivity(intent);
        });


        findViewById(R.id.btnClassement).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Classement.class);
            startActivity(intent);
        });
    }
}