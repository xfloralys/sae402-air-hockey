package com.example.sae402airhockey.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;

import android.os.Bundle;

import androidx.activity.ActivityFlags;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sae402airhockey.GameActivity;
import com.example.sae402airhockey.MainActivity;
import com.example.sae402airhockey.R;

public class MainActivityController extends AppCompatActivity {
    private final Activity a;

    public MainActivityController(Activity a) {
        this.a = a;
    }

    public void initActivity() {
        initBtn1vs1();
    }

    private void initBtn1vs1() {
        Button btn1vs1 = a.findViewById(R.id.btnPlaySolo);
        btn1vs1.setOnClickListener(v -> {
            Intent intent = new Intent(a, GameActivity.class);
            startActivity(intent);
        });
    }
}
