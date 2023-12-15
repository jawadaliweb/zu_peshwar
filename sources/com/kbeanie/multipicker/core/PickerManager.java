package com.kbeanie.multipicker.core;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import com.kbeanie.multipicker.utils.FileUtils;
import com.kbeanie.multipicker.utils.LogUtils;
import java.io.File;
import java.util.UUID;
import storage.StoragePreferences;

public abstract class PickerManager {
    private static final String TAG = "PickerManager";
    public static boolean debugglable;
    protected Activity activity;
    protected boolean allowMultiple;
    protected Fragment appFragment;
    protected int cacheLocation = 100;
    protected Bundle extras;
    protected androidx.fragment.app.Fragment fragment;
    protected final int pickerType;
    protected int requestId;

    /* access modifiers changed from: protected */
    public abstract String pick() throws PickerException;

    public abstract void submit(Intent intent);

    public PickerManager(Activity activity2, int i) {
        this.activity = activity2;
        this.pickerType = i;
        initProperties();
    }

    public PickerManager(androidx.fragment.app.Fragment fragment2, int i) {
        this.fragment = fragment2;
        this.pickerType = i;
        initProperties();
    }

    public PickerManager(Fragment fragment2, int i) {
        this.appFragment = fragment2;
        this.pickerType = i;
        initProperties();
    }

    private void initProperties() {
        debugglable = new StoragePreferences(getContext()).isDebuggable();
    }

    public void setExtras(Bundle bundle) {
        this.extras = bundle;
    }

    public void setCacheLocation(int i) {
        this.cacheLocation = i;
        if (i == 100) {
            checkIfPermissionsAvailable();
        }
    }

    @Deprecated
    public void setFolderName(String str) {
        new StoragePreferences(getContext()).setFolderName(str);
    }

    /* access modifiers changed from: protected */
    public String buildFilePath(String str, String str2) throws PickerException {
        String directory = getDirectory(str2);
        return directory + File.separator + UUID.randomUUID().toString() + "." + str;
    }

    /* access modifiers changed from: protected */
    public String getDirectory(String str) throws PickerException {
        int i = this.cacheLocation;
        if (i == 100) {
            return FileUtils.getExternalFilesDirectory(str, getContext());
        }
        if (i == 200) {
            return FileUtils.getExternalFilesDir(str, getContext());
        }
        if (i == 300) {
            return FileUtils.getExternalCacheDir(getContext());
        }
        if (i != 400) {
            return null;
        }
        return FileUtils.getInternalFileDirectory(getContext());
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            return activity2;
        }
        androidx.fragment.app.Fragment fragment2 = this.fragment;
        if (fragment2 != null) {
            return fragment2.getActivity();
        }
        Fragment fragment3 = this.appFragment;
        if (fragment3 != null) {
            return fragment3.getActivity();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void pickInternal(Intent intent, int i) {
        if (this.allowMultiple && Build.VERSION.SDK_INT >= 18) {
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.startActivityForResult(intent, i);
            return;
        }
        androidx.fragment.app.Fragment fragment2 = this.fragment;
        if (fragment2 != null) {
            fragment2.startActivityForResult(intent, i);
            return;
        }
        Fragment fragment3 = this.appFragment;
        if (fragment3 != null) {
            fragment3.startActivityForResult(intent, i);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isClipDataApi() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public void setRequestId(int i) {
        this.requestId = i;
    }

    private void checkIfPermissionsAvailable() {
        boolean z = true;
        boolean z2 = getContext().checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        String str = TAG;
        LogUtils.d(str, "checkIfPermissionsAvailable: In Manifest(WRITE_EXTERNAL_STORAGE): " + z2);
        if (getContext().checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            z = false;
        }
        LogUtils.d(str, "checkIfPermissionsAvailable: In Manifest(READ_EXTERNAL_STORAGE): " + z);
        if (!z2 || !z) {
            if (!z2) {
                LogUtils.e(str, "android.permission.WRITE_EXTERNAL_STORAGE permission is missing in manifest file");
            }
            if (!z) {
                LogUtils.e(str, "android.permission.READ_EXTERNAL_STORAGE permission is missing in manifest file");
            }
            throw new RuntimeException("Permissions required in Manifest");
        }
    }

    public static long querySizeOfFile(Uri uri, Context context) {
        if (uri.toString().startsWith("file")) {
            return new File(uri.getPath()).length();
        }
        if (uri.toString().startsWith(FirebaseAnalytics.Param.CONTENT)) {
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
                if (cursor != null && cursor.moveToFirst()) {
                    return cursor.getLong(cursor.getColumnIndex("_size"));
                }
                cursor.close();
                return 0;
            } catch (Exception unused) {
            } finally {
                cursor.close();
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public String getNewFileLocation(String str, String str2) throws PickerException {
        String str3;
        if (str2.equals(Environment.DIRECTORY_MOVIES)) {
            str3 = "movies";
        } else {
            str3 = str2.equals(Environment.DIRECTORY_PICTURES) ? "pictures" : "";
        }
        File file = new File(getContext().getFilesDir(), str3);
        file.mkdirs();
        return new File(file.getAbsolutePath() + File.separator + UUID.randomUUID().toString() + "." + str).getAbsolutePath();
    }

    /* access modifiers changed from: protected */
    public String getFileProviderAuthority() {
        return getContext().getPackageName() + ".multipicker.fileprovider";
    }

    public void setDebugglable(boolean z) {
        new StoragePreferences(getContext()).setDebuggable(z);
    }
}
