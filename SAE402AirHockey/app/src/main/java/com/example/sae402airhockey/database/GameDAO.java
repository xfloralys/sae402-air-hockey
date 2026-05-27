package com.example.sae402airhockey.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface GameDAO {
    @Insert
    public void insertGame(Game g);

    @Update
    public void updateGame(Game g);

    @Delete
    public void deleteGame(Game g);

    @Query("SELECT * FROM Game")
    public Game[] getAllGame();

    @Query("SELECT * FROM Game WHERE id=:id")
    public Game getGame(int id);
}
