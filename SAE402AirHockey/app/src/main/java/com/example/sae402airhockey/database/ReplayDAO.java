package com.example.sae402airhockey.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ReplayDAO {
    @Insert
    public void insertReplay(Replay r);

    @Update
    public void updateReplay(Replay r);

    @Delete
    public void deleteReplay(Replay r);

    @Query("SELECT * FROM Replay")
    public Replay[] getAllReplay();

    @Query("SELECT * FROM Replay WHERE id=:id")
    public Replay getReplay(int id);
}
