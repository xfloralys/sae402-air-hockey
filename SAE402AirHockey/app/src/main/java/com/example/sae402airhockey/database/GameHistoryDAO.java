package com.example.sae402airhockey.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface GameHistoryDAO {
    @Insert
    public void insertGameHistory(GameHistory gh);

    @Update
    public void updateGameHistory(GameHistory gh);

    @Delete
    public void deleteGameHistory(GameHistory gh);

    @Query("SELECT * FROM GameHistory")
    public GameHistory[] getAllGameHistory();

    @Query("SELECT * FROM GameHistory WHERE id=:id")
    public GameHistory getGameHistory(int id);
}
