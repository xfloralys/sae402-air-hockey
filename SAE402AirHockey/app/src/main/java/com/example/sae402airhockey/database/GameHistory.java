package com.example.sae402airhockey.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class GameHistory {
    @PrimaryKey(autoGenerate = true)
    // @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "games")
    public Game[] games;

    GameHistory(Game[] games) {
        this.games = games;
    }
}
