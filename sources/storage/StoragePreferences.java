package storage;

import android.content.Context;
import android.content.SharedPreferences;

public class StoragePreferences {
    private static final String FILE = "com.kbeanie.multipicker.preferences";
    private static final String KEY_DEBUG = "key_debug";
    private static final String KEY_FOLDER_NAME = "folder_name";
    public SharedPreferences prefs;

    public StoragePreferences(Context context) {
        this.prefs = context.getSharedPreferences(FILE, 0);
    }

    public void setFolderName(String str) {
        this.prefs.edit().putString(KEY_FOLDER_NAME, str).apply();
    }

    public String getFolderName() {
        return this.prefs.getString(KEY_FOLDER_NAME, (String) null);
    }

    public void setDebuggable(boolean z) {
        this.prefs.edit().putBoolean(KEY_DEBUG, z).apply();
    }

    public boolean isDebuggable() {
        return this.prefs.getBoolean(KEY_DEBUG, false);
    }
}
