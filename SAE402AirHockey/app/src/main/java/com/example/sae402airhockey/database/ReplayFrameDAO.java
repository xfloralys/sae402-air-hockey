package com.example.sae402airhockey.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ReplayFrameDAO {
    @Insert
    public void insertReplayFrame(ReplayFrame rf);

    @Update
    public void updateReplayFrame(ReplayFrame rf);

    @Delete
    public void deleteReplayFrame(ReplayFrame rf);

    @Query("SELECT * FROM ReplayFrame")
    public ReplayFrame[] getAllReplayFrame();

    @Query("SELECT * FROM ReplayFrame WHERE id=:id")
    public ReplayFrame getReplayFrame(int id);
}
