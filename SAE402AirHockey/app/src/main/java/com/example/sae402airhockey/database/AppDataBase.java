package com.example.sae402airhockey.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Player.class, Game.class, GameHistory.class, Replay.class, ReplayList.class, ReplayFrame.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    // on crée une instance de la classe qui est statique : pattern singleton
    // qui garantie l'existence d'une seule instance
    private static AppDataBase bddInstance = null;

    // on crée un accès pour chaque DAO
    public abstract PlayerDAO getPlayerDAO();
    public abstract GameDAO getGameDAO();
    public abstract GameHistoryDAO getGameHistoryDAO();
    public abstract ReplayDAO getReplayDAO();
    public abstract ReplayListDAO getReplayListDAO();
    public abstract ReplayFrameDAO getReplayFrameDAO();

    public static AppDataBase getAppDataBase(Context context) {
        if (bddInstance == null) { // Si la base n'est pas déjà instanciée
            synchronized (AppDataBase.class) { // Garantie qu'aucun autre processus tente de faire le traitement en même temps
                if (bddInstance == null) {
                    bddInstance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class, "air_hockey_db").build();
                }
            }
        }
        return bddInstance;
    }
}
