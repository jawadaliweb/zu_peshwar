package com.lmkt.zupeshawar.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BicycleStationDao_Impl implements BicycleStationDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<BicyclesTB> __deletionAdapterOfBicyclesTB;
    private final EntityInsertionAdapter<BicyclesTB> __insertionAdapterOfBicyclesTB;
    private final EntityDeletionOrUpdateAdapter<BicyclesTB> __updateAdapterOfBicyclesTB;

    public BicycleStationDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfBicyclesTB = new EntityInsertionAdapter<BicyclesTB>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `BicycleStation` (`id`,`lat`,`lon`,`name`,`rentCount`,`restoreCount`) VALUES (?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, BicyclesTB bicyclesTB) {
                supportSQLiteStatement.bindLong(1, (long) bicyclesTB.id);
                supportSQLiteStatement.bindDouble(2, bicyclesTB.lat);
                supportSQLiteStatement.bindDouble(3, bicyclesTB.lon);
                if (bicyclesTB.name == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, bicyclesTB.name);
                }
                supportSQLiteStatement.bindLong(5, (long) bicyclesTB.rentCount);
                supportSQLiteStatement.bindLong(6, (long) bicyclesTB.restoreCount);
            }
        };
        this.__deletionAdapterOfBicyclesTB = new EntityDeletionOrUpdateAdapter<BicyclesTB>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `BicycleStation` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, BicyclesTB bicyclesTB) {
                supportSQLiteStatement.bindLong(1, (long) bicyclesTB.id);
            }
        };
        this.__updateAdapterOfBicyclesTB = new EntityDeletionOrUpdateAdapter<BicyclesTB>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `BicycleStation` SET `id` = ?,`lat` = ?,`lon` = ?,`name` = ?,`rentCount` = ?,`restoreCount` = ? WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, BicyclesTB bicyclesTB) {
                supportSQLiteStatement.bindLong(1, (long) bicyclesTB.id);
                supportSQLiteStatement.bindDouble(2, bicyclesTB.lat);
                supportSQLiteStatement.bindDouble(3, bicyclesTB.lon);
                if (bicyclesTB.name == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, bicyclesTB.name);
                }
                supportSQLiteStatement.bindLong(5, (long) bicyclesTB.rentCount);
                supportSQLiteStatement.bindLong(6, (long) bicyclesTB.restoreCount);
                supportSQLiteStatement.bindLong(7, (long) bicyclesTB.id);
            }
        };
    }

    public void insertStation(BicyclesTB bicyclesTB) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfBicyclesTB.insert(bicyclesTB);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteStation(BicyclesTB bicyclesTB) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfBicyclesTB.handle(bicyclesTB);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void updateStation(BicyclesTB bicyclesTB) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfBicyclesTB.handle(bicyclesTB);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public List<BicyclesTB> getStations() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("Select * from BicycleStation", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, CommonProperties.ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "lat");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "lon");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "rentCount");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "restoreCount");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                BicyclesTB bicyclesTB = new BicyclesTB();
                bicyclesTB.id = query.getInt(columnIndexOrThrow);
                bicyclesTB.lat = query.getDouble(columnIndexOrThrow2);
                bicyclesTB.lon = query.getDouble(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow4)) {
                    bicyclesTB.name = null;
                } else {
                    bicyclesTB.name = query.getString(columnIndexOrThrow4);
                }
                bicyclesTB.rentCount = query.getInt(columnIndexOrThrow5);
                bicyclesTB.restoreCount = query.getInt(columnIndexOrThrow6);
                arrayList.add(bicyclesTB);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
