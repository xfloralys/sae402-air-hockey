package com.example.sae402airhockey.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Player {
    @PrimaryKey(autoGenerate = true)
    // @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "nbGamesWon")
    public int nbGamesWon;

    @ColumnInfo(name = "nbTotalPoints")
    public int nbTotalPoints;

    @ColumnInfo(name = "replayList")
    public ReplayList replayList;

    Player(String name) {
        this.name = name;
    }

    Player(String name, ReplayList replayList) {
        this.name = name;
        this.replayList = replayList;
    }
}
