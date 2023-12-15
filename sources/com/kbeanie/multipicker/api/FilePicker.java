package com.kbeanie.multipicker.api;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.fragment.app.Fragment;
import com.kbeanie.multipicker.api.callbacks.FilePickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenFile;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import com.kbeanie.multipicker.core.PickerManager;
import com.kbeanie.multipicker.core.threads.FileProcessorThread;
import com.kbeanie.multipicker.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;

public class FilePicker extends PickerManager {
    private static final String TAG = "FilePicker";
    /* access modifiers changed from: private */
    public FilePickerCallback callback;
    private String mimeType = "*/*";

    public FilePicker(Activity activity) {
        super(activity, (int) Picker.PICK_FILE);
    }

    public FilePicker(Fragment fragment) {
        super(fragment, (int) Picker.PICK_FILE);
    }

    public FilePicker(android.app.Fragment fragment) {
        super(fragment, (int) Picker.PICK_FILE);
    }

    public void allowMultiple() {
        this.allowMultiple = true;
    }

    public void setFilePickerCallback(FilePickerCallback filePickerCallback) {
        this.callback = filePickerCallback;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void pickFile() {
        try {
            pick();
        } catch (PickerException e) {
            e.printStackTrace();
            if (this.callback != null) {
                this.callback.onError(e.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public String pick() throws PickerException {
        if (this.callback != null) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType(this.mimeType);
            if (this.extras != null) {
                intent.putExtras(this.extras);
            }
            intent.addFlags(1);
            intent.addCategory("android.intent.category.OPENABLE");
            pickInternal(intent, this.pickerType);
            return null;
        }
        throw new PickerException("FilePickerCallback is null!!! Please set one");
    }

    public void submit(Intent intent) {
        handleFileData(intent);
    }

    private void handleFileData(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (intent != null) {
            if (intent.getDataString() != null) {
                String dataString = intent.getDataString();
                String str = TAG;
                LogUtils.d(str, "handleFileData: " + dataString);
                arrayList.add(dataString);
            } else if (Build.VERSION.SDK_INT >= 16 && intent.getClipData() != null) {
                ClipData clipData = intent.getClipData();
                LogUtils.d(TAG, "handleFileData: Multiple files with ClipData");
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    ClipData.Item itemAt = clipData.getItemAt(i);
                    String str2 = TAG;
                    LogUtils.d(str2, "Item [" + i + "]: " + itemAt.getUri().toString());
                    arrayList.add(itemAt.getUri().toString());
                }
            }
            if (intent.hasExtra("uris")) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("uris");
                for (int i2 = 0; i2 < parcelableArrayListExtra.size(); i2++) {
                    arrayList.add(((Uri) parcelableArrayListExtra.get(i2)).toString());
                }
            }
            processFiles(arrayList);
        }
    }

    private void processFiles(List<String> list) {
        FileProcessorThread fileProcessorThread = new FileProcessorThread(getContext(), getFileObjects(list), this.cacheLocation);
        fileProcessorThread.setFilePickerCallback(this.callback);
        fileProcessorThread.setRequestId(this.requestId);
        fileProcessorThread.start();
    }

    private void onError(final String str) {
        try {
            if (this.callback != null) {
                ((Activity) getContext()).runOnUiThread(new Runnable() {
                    public void run() {
                        FilePicker.this.callback.onError(str);
                    }
                });
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private List<ChosenFile> getFileObjects(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String queryUri : list) {
            ChosenFile chosenFile = new ChosenFile();
            chosenFile.setQueryUri(queryUri);
            if (Build.VERSION.SDK_INT >= 19) {
                chosenFile.setDirectoryType(Environment.DIRECTORY_DOCUMENTS);
            } else {
                chosenFile.setDirectoryType(Environment.DIRECTORY_DOWNLOADS);
            }
            chosenFile.setType("file");
            arrayList.add(chosenFile);
        }
        return arrayList;
    }
}
