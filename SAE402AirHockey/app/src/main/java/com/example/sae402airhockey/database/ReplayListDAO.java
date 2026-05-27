package com.example.sae402airhockey.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ReplayListDAO {
    @Insert
    public void insertReplayList(ReplayList rl);

    @Update
    public void updateReplayList(ReplayList rl);

    @Delete
    public void deleteReplayList(ReplayList rl);

    @Query("SELECT * FROM ReplayList")
    public ReplayList[] getAllReplayList();

    @Query("SELECT * FROM ReplayList WHERE id=:id")
    public ReplayList getReplayList(int id);
}
