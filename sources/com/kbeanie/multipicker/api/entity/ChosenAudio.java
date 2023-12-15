package com.kbeanie.multipicker.api.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class ChosenAudio extends ChosenFile {
    public static final Parcelable.Creator<ChosenAudio> CREATOR = new Parcelable.Creator<ChosenAudio>() {
        public ChosenAudio createFromParcel(Parcel parcel) {
            return new ChosenAudio(parcel);
        }

        public ChosenAudio[] newArray(int i) {
            return new ChosenAudio[i];
        }
    };
    private long duration;

    public ChosenAudio() {
    }

    protected ChosenAudio(Parcel parcel) {
        super(parcel);
        this.duration = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.duration);
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }
}
