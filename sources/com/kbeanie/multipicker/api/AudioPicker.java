package com.kbeanie.multipicker.api;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.fragment.app.Fragment;
import com.kbeanie.multipicker.api.callbacks.AudioPickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenAudio;
import com.kbeanie.multipicker.api.entity.ChosenFile;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import com.kbeanie.multipicker.core.PickerManager;
import com.kbeanie.multipicker.core.threads.AudioProcessorThread;
import com.kbeanie.multipicker.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;

public class AudioPicker extends PickerManager {
    private static final String TAG = "AudioPicker";
    /* access modifiers changed from: private */
    public AudioPickerCallback callback;
    private String mimeType = "audio/*";

    public AudioPicker(Activity activity) {
        super(activity, (int) Picker.PICK_AUDIO);
    }

    public AudioPicker(Fragment fragment) {
        super(fragment, (int) Picker.PICK_AUDIO);
    }

    public AudioPicker(android.app.Fragment fragment) {
        super(fragment, (int) Picker.PICK_AUDIO);
    }

    public void setAudioPickerCallback(AudioPickerCallback audioPickerCallback) {
        this.callback = audioPickerCallback;
    }

    public void allowMultiple() {
        this.allowMultiple = true;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void pickAudio() {
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
        throw new PickerException("AudioPickerCallback is null!!! Please set one");
    }

    public void submit(Intent intent) {
        handleAudioData(intent);
    }

    private void handleAudioData(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (intent != null) {
            if (intent.getDataString() != null) {
                String dataString = intent.getDataString();
                String str = TAG;
                LogUtils.d(str, "handleAudioData: " + dataString);
                arrayList.add(dataString);
            } else if (Build.VERSION.SDK_INT >= 16 && intent.getClipData() != null) {
                ClipData clipData = intent.getClipData();
                LogUtils.d(TAG, "handleAudioData: Multiple audios with ClipData");
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
        AudioProcessorThread audioProcessorThread = new AudioProcessorThread(getContext(), getFileObjects(list), this.cacheLocation);
        audioProcessorThread.setRequestId(this.requestId);
        audioProcessorThread.setAudioPickerCallback(this.callback);
        audioProcessorThread.start();
    }

    private void onError(final String str) {
        try {
            if (this.callback != null) {
                ((Activity) getContext()).runOnUiThread(new Runnable() {
                    public void run() {
                        AudioPicker.this.callback.onError(str);
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
            ChosenAudio chosenAudio = new ChosenAudio();
            chosenAudio.setQueryUri(queryUri);
            chosenAudio.setDirectoryType(Environment.DIRECTORY_MUSIC);
            chosenAudio.setType("audio");
            arrayList.add(chosenAudio);
        }
        return arrayList;
    }
}
