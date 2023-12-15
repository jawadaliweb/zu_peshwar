package com.kbeanie.multipicker.api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class ChosenContact implements Parcelable {
    public static final Parcelable.Creator<ChosenContact> CREATOR = new Parcelable.Creator<ChosenContact>() {
        public ChosenContact createFromParcel(Parcel parcel) {
            return new ChosenContact(parcel);
        }

        public ChosenContact[] newArray(int i) {
            return new ChosenContact[i];
        }
    };
    private static final String FORMAT_CONTACT = "Name: %s, Photo: %s, Phones: %s, Emails: %s";
    private String displayName;
    private final List<String> emails;
    private final List<String> phones;
    private String photoUri;
    private int requestId;

    public int describeContents() {
        return 0;
    }

    protected ChosenContact(Parcel parcel) {
        this.displayName = parcel.readString();
        this.photoUri = parcel.readString();
        this.phones = parcel.createStringArrayList();
        this.emails = parcel.createStringArrayList();
        this.requestId = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.displayName);
        parcel.writeString(this.photoUri);
        parcel.writeStringList(this.phones);
        parcel.writeStringList(this.emails);
        parcel.writeInt(this.requestId);
    }

    public ChosenContact() {
        this.phones = new ArrayList();
        this.emails = new ArrayList();
    }

    public int getRequestId() {
        return this.requestId;
    }

    public void setRequestId(int i) {
        this.requestId = i;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getPhotoUri() {
        return this.photoUri;
    }

    public void setPhotoUri(String str) {
        this.photoUri = str;
    }

    public void addPhone(String str) {
        this.phones.add(str);
    }

    public List<String> getPhones() {
        return this.phones;
    }

    public List<String> getEmails() {
        return this.emails;
    }

    public void addEmail(String str) {
        this.emails.add(str);
    }

    public String toString() {
        return String.format(FORMAT_CONTACT, new Object[]{this.displayName, this.photoUri, getPhonesString(), getEmailsString()});
    }

    private String getEmailsString() {
        String str = "";
        for (String str2 : this.emails) {
            str = str + "[" + str2 + "]";
        }
        return str;
    }

    private String getPhonesString() {
        String str = "";
        for (String str2 : this.phones) {
            str = str + "[" + str2 + "]";
        }
        return str;
    }
}
