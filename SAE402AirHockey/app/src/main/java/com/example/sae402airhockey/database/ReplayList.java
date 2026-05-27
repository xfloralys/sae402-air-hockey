package com.example.sae402airhockey.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ReplayList {
    @PrimaryKey(autoGenerate = true)
    // @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "replays")
    public Replay[] replays;

    ReplayList(Replay[] replays) {
        this.replays = replays;
    }
}
