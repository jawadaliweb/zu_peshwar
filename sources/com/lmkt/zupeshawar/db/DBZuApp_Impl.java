package com.lmkt.zupeshawar.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class DBZuApp_Impl extends DBZuApp {
    private volatile BicycleStationDao _bicycleStationDao;
    private volatile CategoryDao _categoryDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(2) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `BicycleStation` (`id` INTEGER NOT NULL, `lat` REAL NOT NULL, `lon` REAL NOT NULL, `name` TEXT, `rentCount` INTEGER NOT NULL, `restoreCount` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Category` (`id` INTEGER NOT NULL, `parentID` INTEGER NOT NULL, `name` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b381725cdaf0d3a024d789f74c5b4435')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `BicycleStation`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Category`");
                if (DBZuApp_Impl.this.mCallbacks != null) {
                    int size = DBZuApp_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) DBZuApp_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (DBZuApp_Impl.this.mCallbacks != null) {
                    int size = DBZuApp_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) DBZuApp_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = DBZuApp_Impl.this.mDatabase = supportSQLiteDatabase;
                DBZuApp_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (DBZuApp_Impl.this.mCallbacks != null) {
                    int size = DBZuApp_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) DBZuApp_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(6);
                hashMap.put(CommonProperties.ID, new TableInfo.Column(CommonProperties.ID, "INTEGER", true, 1, (String) null, 1));
                hashMap.put("lat", new TableInfo.Column("lat", "REAL", true, 0, (String) null, 1));
                hashMap.put("lon", new TableInfo.Column("lon", "REAL", true, 0, (String) null, 1));
                hashMap.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                hashMap.put("rentCount", new TableInfo.Column("rentCount", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("restoreCount", new TableInfo.Column("restoreCount", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("BicycleStation", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "BicycleStation");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "BicycleStation(com.lmkt.zupeshawar.db.BicyclesTB).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(3);
                hashMap2.put(CommonProperties.ID, new TableInfo.Column(CommonProperties.ID, "INTEGER", true, 1, (String) null, 1));
                hashMap2.put("parentID", new TableInfo.Column("parentID", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("Category", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "Category");
                if (tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "Category(com.lmkt.zupeshawar.db.CategoryTB).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
        }, "b381725cdaf0d3a024d789f74c5b4435", "86b587e580f91dbf89c66fd3cc2cf0fb")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "BicycleStation", "Category");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `BicycleStation`");
            writableDatabase.execSQL("DELETE FROM `Category`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    /* access modifiers changed from: protected */
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(BicycleStationDao.class, BicycleStationDao_Impl.getRequiredConverters());
        hashMap.put(CategoryDao.class, CategoryDao_Impl.getRequiredConverters());
        return hashMap;
    }

    public BicycleStationDao bicycleDao() {
        BicycleStationDao bicycleStationDao;
        if (this._bicycleStationDao != null) {
            return this._bicycleStationDao;
        }
        synchronized (this) {
            if (this._bicycleStationDao == null) {
                this._bicycleStationDao = new BicycleStationDao_Impl(this);
            }
            bicycleStationDao = this._bicycleStationDao;
        }
        return bicycleStationDao;
    }

    public CategoryDao categoryDao() {
        CategoryDao categoryDao;
        if (this._categoryDao != null) {
            return this._categoryDao;
        }
        synchronized (this) {
            if (this._categoryDao == null) {
                this._categoryDao = new CategoryDao_Impl(this);
            }
            categoryDao = this._categoryDao;
        }
        return categoryDao;
    }
}
