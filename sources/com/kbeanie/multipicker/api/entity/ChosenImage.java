package com.kbeanie.multipicker.api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import br.com.sapereaude.maskedEditText.MaskedEditText;

public class ChosenImage extends ChosenFile {
    public static final Parcelable.Creator<ChosenImage> CREATOR = new Parcelable.Creator<ChosenImage>() {
        public ChosenImage createFromParcel(Parcel parcel) {
            return new ChosenImage(parcel);
        }

        public ChosenImage[] newArray(int i) {
            return new ChosenImage[i];
        }
    };
    private static final String STRING_FORMAT = "Height: %s, Width: %s, Orientation: %s";
    private int height;
    private int orientation;
    private String thumbnailPath;
    private String thumbnailSmallPath;
    private int width;

    public ChosenImage() {
    }

    protected ChosenImage(Parcel parcel) {
        super(parcel);
        this.orientation = parcel.readInt();
        this.thumbnailPath = parcel.readString();
        this.thumbnailSmallPath = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }

    public String getThumbnailPath() {
        return this.thumbnailPath;
    }

    public void setThumbnailPath(String str) {
        this.thumbnailPath = str;
    }

    public String getThumbnailSmallPath() {
        return this.thumbnailSmallPath;
    }

    public void setThumbnailSmallPath(String str) {
        this.thumbnailSmallPath = str;
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

    public String toString() {
        return super.toString() + MaskedEditText.SPACE + String.format(STRING_FORMAT, new Object[]{Integer.valueOf(this.height), Integer.valueOf(this.width), getOrientationName()});
    }

    public String getOrientationName() {
        int i = this.orientation;
        if (i == 0) {
            return "UNDEFINED";
        }
        switch (i) {
            case 2:
                return "FLIP_HORIZONTAL";
            case 3:
                return "ROTATE_180";
            case 4:
                return "FLIP_VERTICAL";
            case 5:
                return "TRANSPOSE";
            case 6:
                return "ROTATE_90";
            case 7:
                return "TRANSVERSE";
            case 8:
                return "ROTATE_270";
            default:
                return "NORMAL";
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.orientation);
        parcel.writeString(this.thumbnailPath);
        parcel.writeString(this.thumbnailSmallPath);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }
}
