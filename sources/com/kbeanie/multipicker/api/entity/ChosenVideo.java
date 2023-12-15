package com.kbeanie.multipicker.api.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class ChosenVideo extends ChosenFile {
    public static final Parcelable.Creator<ChosenVideo> CREATOR = new Parcelable.Creator<ChosenVideo>() {
        public ChosenVideo createFromParcel(Parcel parcel) {
            return new ChosenVideo(parcel);
        }

        public ChosenVideo[] newArray(int i) {
            return new ChosenVideo[i];
        }
    };
    private long duration;
    private int height;
    private int orientation;
    private String previewImage;
    private String previewThumbnail;
    private String previewThumbnailSmall;
    private int width;

    public ChosenVideo() {
    }

    protected ChosenVideo(Parcel parcel) {
        super(parcel);
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.duration = parcel.readLong();
        this.previewImage = parcel.readString();
        this.previewThumbnail = parcel.readString();
        this.previewThumbnailSmall = parcel.readString();
        this.orientation = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeLong(this.duration);
        parcel.writeString(this.previewImage);
        parcel.writeString(this.previewThumbnail);
        parcel.writeString(this.previewThumbnailSmall);
        parcel.writeInt(this.orientation);
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public String getPreviewImage() {
        return this.previewImage;
    }

    public void setPreviewImage(String str) {
        this.previewImage = str;
    }

    public String getPreviewThumbnail() {
        return this.previewThumbnail;
    }

    public void setPreviewThumbnail(String str) {
        this.previewThumbnail = str;
    }

    public String getPreviewThumbnailSmall() {
        return this.previewThumbnailSmall;
    }

    public void setPreviewThumbnailSmall(String str) {
        this.previewThumbnailSmall = str;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }

    public String getOrientationName() {
        return this.orientation + " Deg";
    }
}
