package com.lmkt.zupeshawar.Utilities;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.irozon.alertview.AlertActionStyle;
import com.irozon.alertview.AlertStyle;
import com.irozon.alertview.AlertView;
import com.irozon.alertview.interfaces.AlertActionListener;
import com.irozon.alertview.objects.AlertAction;
import com.kbeanie.multipicker.api.CacheLocation;
import com.kbeanie.multipicker.api.CameraImagePicker;
import com.kbeanie.multipicker.api.FilePicker;
import com.kbeanie.multipicker.api.ImagePicker;
import com.kbeanie.multipicker.api.MediaPicker;
import com.kbeanie.multipicker.api.callbacks.FilePickerCallback;
import com.kbeanie.multipicker.api.callbacks.ImagePickerCallback;
import com.kbeanie.multipicker.api.callbacks.MediaPickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenFile;
import com.kbeanie.multipicker.api.entity.ChosenImage;
import com.kbeanie.multipicker.api.entity.ChosenVideo;
import com.lmkt.zupeshawar.model.QuestionAttachment;
import com.lmkt.zupeshawar.presenter.PickDocumentCallBack;
import java.util.List;

public class DocumentPicker implements ImagePickerCallback, FilePickerCallback, MediaPickerCallback {
    private Activity activity;
    private CameraImagePicker cameraPicker;
    private final PickDocumentCallBack documentPickedCallBack;
    private FilePicker filePicker;
    private String fileTag;
    private Fragment fragment;
    private ImagePicker imagePicker;
    private MediaPicker mediaPicker;
    private String profilePicPath;

    public void onError(String str) {
    }

    public DocumentPicker(Activity activity2, PickDocumentCallBack pickDocumentCallBack) {
        this.activity = activity2;
        this.documentPickedCallBack = pickDocumentCallBack;
    }

    public DocumentPicker(Fragment fragment2, PickDocumentCallBack pickDocumentCallBack) {
        this.fragment = fragment2;
        this.documentPickedCallBack = pickDocumentCallBack;
    }

    public void openDocumentPicker(boolean z, boolean z2, String str) {
        this.fileTag = str;
        AlertView alertView = new AlertView("Choose your action", "", AlertStyle.IOS);
        alertView.addAction(new AlertAction("Take Picture", AlertActionStyle.DEFAULT, (AlertActionListener) new AlertActionListener() {
            public void onActionClick(AlertAction alertAction) {
                DocumentPicker.this.takePicture();
            }
        }));
        if (z2) {
            alertView.addAction(new AlertAction("Pick Video/Image", AlertActionStyle.DEFAULT, (AlertActionListener) new AlertActionListener() {
                public void onActionClick(AlertAction alertAction) {
                    DocumentPicker.this.pickMedia();
                }
            }));
        } else {
            alertView.addAction(new AlertAction("Pick Image", AlertActionStyle.DEFAULT, (AlertActionListener) new AlertActionListener() {
                public void onActionClick(AlertAction alertAction) {
                    DocumentPicker.this.pickImage();
                }
            }));
        }
        if (z) {
            alertView.addAction(new AlertAction("Pick Document", AlertActionStyle.DEFAULT, (AlertActionListener) new AlertActionListener() {
                public final void onActionClick(AlertAction alertAction) {
                    DocumentPicker.this.lambda$openDocumentPicker$0$DocumentPicker(alertAction);
                }
            }));
        }
        alertView.show((AppCompatActivity) this.fragment.requireActivity());
    }

    public /* synthetic */ void lambda$openDocumentPicker$0$DocumentPicker(AlertAction alertAction) {
        pickDocument();
    }

    public void pickMedia() {
        Activity activity2 = this.activity;
        if (activity2 == null) {
            this.mediaPicker = new MediaPicker(this.fragment);
        } else {
            this.mediaPicker = new MediaPicker(activity2);
        }
        this.mediaPicker.shouldGenerateMetadata(false);
        this.mediaPicker.shouldGenerateThumbnails(false);
        this.mediaPicker.setMediaPickerCallback(this);
        this.mediaPicker.setCacheLocation(CacheLocation.INTERNAL_APP_DIR);
        this.mediaPicker.pickMedia();
    }

    public void pickImage() {
        Activity activity2 = this.activity;
        if (activity2 == null) {
            this.imagePicker = new ImagePicker(this.fragment);
        } else {
            this.imagePicker = new ImagePicker(activity2);
        }
    }

    public void takePicture() {
        Activity activity2 = this.activity;
        if (activity2 == null) {
            this.cameraPicker = new CameraImagePicker(this.fragment);
        } else {
            this.cameraPicker = new CameraImagePicker(activity2);
        }
        this.cameraPicker.setDebugglable(true);
        this.cameraPicker.setImagePickerCallback(this);
        this.cameraPicker.shouldGenerateMetadata(true);
        this.cameraPicker.shouldGenerateThumbnails(true);
        this.profilePicPath = this.cameraPicker.pickImage();
    }

    public void pickDocument() {
        Activity activity2 = this.activity;
        if (activity2 == null) {
            this.filePicker = new FilePicker(this.fragment);
        } else {
            this.filePicker = new FilePicker(activity2);
        }
        this.filePicker.setDebugglable(true);
        this.filePicker.setMimeType("application/pdf");
        this.filePicker.setFilePickerCallback(this);
        this.filePicker.pickFile();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            return;
        }
        if (i == 10888) {
            if (this.mediaPicker == null) {
                Activity activity2 = this.activity;
                if (activity2 == null) {
                    this.mediaPicker = new MediaPicker(this.fragment);
                } else {
                    this.mediaPicker = new MediaPicker(activity2);
                }
                this.mediaPicker.setMediaPickerCallback(this);
            }
            this.mediaPicker.submit(intent);
        } else if (i == 3111) {
            if (this.mediaPicker == null) {
                Activity activity3 = this.activity;
                if (activity3 == null) {
                    this.imagePicker = new ImagePicker(this.fragment);
                } else {
                    this.imagePicker = new ImagePicker(activity3);
                }
                this.imagePicker.setImagePickerCallback(this);
            }
            this.imagePicker.submit(intent);
        } else if (i == 4222) {
            if (this.cameraPicker == null) {
                Activity activity4 = this.activity;
                if (activity4 == null) {
                    this.cameraPicker = new CameraImagePicker(this.fragment);
                } else {
                    this.cameraPicker = new CameraImagePicker(activity4);
                }
                this.cameraPicker.setImagePickerCallback(this);
                this.cameraPicker.reinitialize(this.profilePicPath);
            }
            this.cameraPicker.submit(intent);
        } else if (i == 7555) {
            if (this.filePicker == null) {
                Activity activity5 = this.activity;
                if (activity5 == null) {
                    this.filePicker = new FilePicker(this.fragment);
                } else {
                    this.filePicker = new FilePicker(activity5);
                }
                this.filePicker.setFilePickerCallback(this);
            }
            this.filePicker.submit(intent);
        }
    }

    public void onFilesChosen(List<ChosenFile> list) {
        for (ChosenFile next : list) {
            PickDocumentCallBack pickDocumentCallBack = this.documentPickedCallBack;
            if (pickDocumentCallBack != null) {
                pickDocumentCallBack.onDocumentPicked(getAttachment(next.getOriginalPath(), 3));
            }
        }
    }

    public void onImagesChosen(List<ChosenImage> list) {
        for (ChosenImage next : list) {
            PickDocumentCallBack pickDocumentCallBack = this.documentPickedCallBack;
            if (pickDocumentCallBack != null) {
                pickDocumentCallBack.onDocumentPicked(getAttachment(next.getOriginalPath(), 1));
            }
        }
    }

    public void onMediaChosen(List<ChosenImage> list, List<ChosenVideo> list2) {
        if (list != null) {
            for (ChosenImage next : list) {
                PickDocumentCallBack pickDocumentCallBack = this.documentPickedCallBack;
                if (pickDocumentCallBack != null) {
                    pickDocumentCallBack.onDocumentPicked(getAttachment(next.getOriginalPath(), 1));
                }
            }
        }
        if (list2 != null) {
            for (ChosenVideo next2 : list2) {
                PickDocumentCallBack pickDocumentCallBack2 = this.documentPickedCallBack;
                if (pickDocumentCallBack2 != null) {
                    pickDocumentCallBack2.onDocumentPicked(getAttachment(next2.getOriginalPath(), 2));
                }
            }
        }
    }

    private QuestionAttachment getAttachment(String str, int i) {
        QuestionAttachment questionAttachment = new QuestionAttachment();
        questionAttachment.setFileTagForIdentification(this.fileTag);
        questionAttachment.setAttachmentUrl(str);
        questionAttachment.setType(i);
        questionAttachment.setServerImage(false);
        return questionAttachment;
    }
}
