package com.lmkt.zupeshawar.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CategoryDao_Impl implements CategoryDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<CategoryTB> __deletionAdapterOfCategoryTB;
    private final EntityInsertionAdapter<CategoryTB> __insertionAdapterOfCategoryTB;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllCategory;
    private final EntityDeletionOrUpdateAdapter<CategoryTB> __updateAdapterOfCategoryTB;

    public CategoryDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfCategoryTB = new EntityInsertionAdapter<CategoryTB>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Category` (`id`,`parentID`,`name`) VALUES (?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, CategoryTB categoryTB) {
                supportSQLiteStatement.bindLong(1, (long) categoryTB.id);
                supportSQLiteStatement.bindLong(2, (long) categoryTB.parentID);
                if (categoryTB.name == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, categoryTB.name);
                }
            }
        };
        this.__deletionAdapterOfCategoryTB = new EntityDeletionOrUpdateAdapter<CategoryTB>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `Category` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, CategoryTB categoryTB) {
                supportSQLiteStatement.bindLong(1, (long) categoryTB.id);
            }
        };
        this.__updateAdapterOfCategoryTB = new EntityDeletionOrUpdateAdapter<CategoryTB>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `Category` SET `id` = ?,`parentID` = ?,`name` = ? WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, CategoryTB categoryTB) {
                supportSQLiteStatement.bindLong(1, (long) categoryTB.id);
                supportSQLiteStatement.bindLong(2, (long) categoryTB.parentID);
                if (categoryTB.name == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, categoryTB.name);
                }
                supportSQLiteStatement.bindLong(4, (long) categoryTB.id);
            }
        };
        this.__preparedStmtOfDeleteAllCategory = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "Delete from Category";
            }
        };
    }

    public void insertCategory(CategoryTB categoryTB) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfCategoryTB.insert(categoryTB);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteCategory(CategoryTB categoryTB) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfCategoryTB.handle(categoryTB);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void updateCategory(CategoryTB categoryTB) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfCategoryTB.handle(categoryTB);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteAllCategory() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllCategory.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllCategory.release(acquire);
        }
    }

    public List<CategoryTB> getCategories() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("Select * from category where parentID = '0' order by name ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, CommonProperties.ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "parentID");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "name");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                CategoryTB categoryTB = new CategoryTB();
                categoryTB.id = query.getInt(columnIndexOrThrow);
                categoryTB.parentID = query.getInt(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    categoryTB.name = null;
                } else {
                    categoryTB.name = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(categoryTB);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<CategoryTB> getSubCategories(int i) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("Select * from category where parentID =? order by name ASC", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, CommonProperties.ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "parentID");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "name");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                CategoryTB categoryTB = new CategoryTB();
                categoryTB.id = query.getInt(columnIndexOrThrow);
                categoryTB.parentID = query.getInt(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    categoryTB.name = null;
                } else {
                    categoryTB.name = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(categoryTB);
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
