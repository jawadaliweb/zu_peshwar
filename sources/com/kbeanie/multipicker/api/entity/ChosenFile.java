package com.kbeanie.multipicker.api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.microsoft.appcenter.Constants;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ChosenFile implements Parcelable {
    public static final Parcelable.Creator<ChosenFile> CREATOR = new Parcelable.Creator<ChosenFile>() {
        public ChosenFile createFromParcel(Parcel parcel) {
            return new ChosenFile(parcel);
        }

        public ChosenFile[] newArray(int i) {
            return new ChosenFile[i];
        }
    };
    private static final String STRING_FORMAT = "Type: %s, QueryUri: %s, Original Path: %s, MimeType: %s, Size: %s";
    private Date createdAt;
    private String directoryType;
    private String displayName;
    private String extension;
    private long id;
    private String mimeType;
    private String originalPath;
    private String queryUri;
    private int requestId;
    private long size;
    private boolean success;
    private String tempFile = "";
    private String type;

    public int describeContents() {
        return 0;
    }

    public ChosenFile() {
    }

    protected ChosenFile(Parcel parcel) {
        this.id = parcel.readLong();
        this.queryUri = parcel.readString();
        this.originalPath = parcel.readString();
        this.mimeType = parcel.readString();
        this.size = parcel.readLong();
        this.extension = parcel.readString();
        this.createdAt = new Date(parcel.readLong());
        this.type = parcel.readString();
        this.displayName = parcel.readString();
        this.success = parcel.readByte() != 0;
        this.directoryType = parcel.readString();
        this.requestId = parcel.readInt();
        this.tempFile = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.queryUri);
        parcel.writeString(this.originalPath);
        parcel.writeString(this.mimeType);
        parcel.writeLong(this.size);
        parcel.writeString(this.extension);
        parcel.writeLong(this.createdAt.getTime());
        parcel.writeString(this.type);
        parcel.writeString(this.displayName);
        parcel.writeInt(this.success ? 1 : 0);
        parcel.writeString(this.directoryType);
        parcel.writeInt(this.requestId);
        parcel.writeString(this.tempFile);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public long getId() {
        return this.id;
    }

    public String getDirectoryType() {
        return this.directoryType;
    }

    public void setDirectoryType(String str) {
        this.directoryType = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getQueryUri() {
        return this.queryUri;
    }

    public void setQueryUri(String str) {
        this.queryUri = str;
    }

    public String getOriginalPath() {
        return this.originalPath;
    }

    public void setOriginalPath(String str) {
        this.originalPath = str;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String str) {
        this.extension = str;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getFileExtensionFromMimeType() {
        String str = this.mimeType;
        if (str != null) {
            String[] split = str.split("/");
            if (split.length >= 2 && !split[1].equals("*")) {
                return "." + split[1];
            }
        }
        return "";
    }

    public String getFileExtensionFromMimeTypeWithoutDot() {
        return getFileExtensionFromMimeType().replace(".", "");
    }

    public String toString() {
        return String.format(STRING_FORMAT, new Object[]{this.type, this.queryUri, this.originalPath, this.mimeType, getHumanReadableSize(false)});
    }

    public String getHumanReadableSize(boolean z) {
        int i = z ? 1000 : 1024;
        long j = this.size;
        if (j < ((long) i)) {
            return this.size + " B";
        }
        double d = (double) i;
        int log = (int) (Math.log((double) j) / Math.log(d));
        StringBuilder sb = new StringBuilder();
        sb.append((z ? "kMGTPE" : "KMGTPE").charAt(log - 1));
        sb.append("");
        return String.format(Locale.ENGLISH, "%.1f %sB", new Object[]{Double.valueOf(((double) this.size) / Math.pow(d, (double) log)), sb.toString()});
    }

    public String getHumanReadableDuration(long j) {
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(j))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))});
    }

    public int getRequestId() {
        return this.requestId;
    }

    public void setRequestId(int i) {
        this.requestId = i;
    }

    public String getTempFile() {
        return this.tempFile;
    }

    public void setTempFile(String str) {
        this.tempFile = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChosenFile)) {
            return false;
        }
        return ((ChosenFile) obj).getIdString().equals(getIdString());
    }

    public int hashCode() {
        return getIdString().hashCode();
    }

    private String getIdString() {
        return this.queryUri + Constants.COMMON_SCHEMA_PREFIX_SEPARATOR + this.originalPath + Constants.COMMON_SCHEMA_PREFIX_SEPARATOR + this.mimeType + Constants.COMMON_SCHEMA_PREFIX_SEPARATOR + this.size;
    }
}
