package com.example.sae402airhockey.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity
public class ReplayFrame {
    @PrimaryKey(autoGenerate = true)
    // @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "posX")
    public int posX;

    @ColumnInfo(name = "posY")
    public int posY;

    @ColumnInfo(name = "timestamp")
    public Date timestamp;

    ReplayFrame(int posX, int posY, Date timestamp) {
        this.posX = posX;
        this.posY = posY;
        this.timestamp = timestamp;
    }
}
