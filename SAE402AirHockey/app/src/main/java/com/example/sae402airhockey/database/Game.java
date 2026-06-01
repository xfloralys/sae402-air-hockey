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

    @ColumnInfo(name = "playerScore")
    public int playerScore;

    @ColumnInfo(name = "opponentScore")
    public int opponentScore;

    @ColumnInfo(name = "opponentName")
    public String opponentName;

    @Ignore
    Game(String opponentName) {
        this.opponentName = opponentName;
    }

    Game(int playerScore, int opponentScore, String opponentName) {
        this.playerScore = playerScore;
        this.opponentScore = opponentScore;
        this.opponentName = opponentName;
    }
}
