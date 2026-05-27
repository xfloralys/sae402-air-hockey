package com.example.sae402airhockey;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {
    private LinearLayout canvasLayout = null;
    GameView customGameView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.sample_game_view);
        canvasLayout = (LinearLayout)findViewById(R.id.drawGameView);
        customGameView = new GameView(getApplicationContext());
        canvasLayout.addView(customGameView);
    }
}