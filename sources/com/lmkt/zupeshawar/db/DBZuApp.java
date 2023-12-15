package com.lmkt.zupeshawar.db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class DBZuApp extends RoomDatabase {
    private static final String DB_Name = "ZU_Bb";
    private static DBZuApp db_Instance;

    public abstract BicycleStationDao bicycleDao();

    public abstract CategoryDao categoryDao();

    public static synchronized DBZuApp getInstance(Context context) {
        DBZuApp dBZuApp;
        Class<DBZuApp> cls = DBZuApp.class;
        synchronized (cls) {
            if (db_Instance == null) {
                db_Instance = Room.databaseBuilder(context.getApplicationContext(), cls, DB_Name).fallbackToDestructiveMigration().build();
            }
            dBZuApp = db_Instance;
        }
        return dBZuApp;
    }
}
