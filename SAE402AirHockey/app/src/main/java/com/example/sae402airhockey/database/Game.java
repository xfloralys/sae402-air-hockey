package com.example.sae402airhockey.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Game {
    @PrimaryKey(autoGenerate = true)
    // @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "playerName")
    public String playerName;

    @ColumnInfo(name = "playerScore")
    public int playerScore;

    @ColumnInfo(name = "opponentScore")
    public int opponentScore;

    @ColumnInfo(name = "opponentName")
    public String opponentName;

    @Ignore
    public Game(String playerName, String opponentName) {
        this.playerName = playerName;
        this.opponentName = opponentName;
    }

    public Game(String playerName, int playerScore, int opponentScore, String opponentName) {
        this.playerName = playerName;
        this.playerScore = playerScore;
        this.opponentScore = opponentScore;
        this.opponentName = opponentName;
    }
}
