package com.example.sae402airhockey.database;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PlayerDAO {
    @Insert
    public void insertPlayer(Player p);

    @Update
    public void updatePlayer(Player p);

    @Delete
    public void deletePlayer(Player p);

    @Query("SELECT * FROM Player")
    public Player[] getAllPlayer();

    @Query("SELECT * FROM Player WHERE id=:id")
    public Player getPlayer(int id);

    @Query("SELECT * FROM Player WHERE name=:name")
    public Player getPlayerByName(String name);

    @Query("SELECT * FROM Player ORDER BY nbTotalPoints DESC")
    public Player[] getAllPlayersSortedByPoints();
}
