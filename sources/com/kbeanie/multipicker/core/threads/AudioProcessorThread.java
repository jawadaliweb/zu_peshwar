package com.kbeanie.multipicker.core.threads;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import com.kbeanie.multipicker.api.callbacks.AudioPickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenAudio;
import com.kbeanie.multipicker.api.entity.ChosenFile;
import java.util.List;

public final class AudioProcessorThread extends FileProcessorThread {
    /* access modifiers changed from: private */
    public AudioPickerCallback callback;

    public AudioProcessorThread(Context context, List<? extends ChosenFile> list, int i) {
        super(context, list, i);
    }

    public void run() {
        super.run();
        postProcessAudios();
        onDone();
    }

    private void postProcessAudios() {
        for (ChosenFile chosenFile : this.files) {
            postProcessAudio((ChosenAudio) chosenFile);
        }
    }

    private void postProcessAudio(ChosenAudio chosenAudio) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(chosenAudio.getOriginalPath());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (extractMetadata != null) {
                chosenAudio.setDuration(Long.parseLong(extractMetadata));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
        mediaMetadataRetriever.release();
    }

    private void onDone() {
        try {
            if (this.callback != null) {
                getActivityFromContext().runOnUiThread(new Runnable() {
                    public void run() {
                        AudioProcessorThread.this.callback.onAudiosChosen(AudioProcessorThread.this.files);
                    }
                });
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void setAudioPickerCallback(AudioPickerCallback audioPickerCallback) {
        this.callback = audioPickerCallback;
    }
}
