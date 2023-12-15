package com.example.example;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/example/example/AdvtImages;", "", "imageUrl", "", "updateddate", "(Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "getUpdateddate", "setUpdateddate", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdvtImages.kt */
public final class AdvtImages {
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("updateddate")
    private String updateddate;

    public AdvtImages() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdvtImages copy$default(AdvtImages advtImages, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = advtImages.imageUrl;
        }
        if ((i & 2) != 0) {
            str2 = advtImages.updateddate;
        }
        return advtImages.copy(str, str2);
    }

    public final String component1() {
        return this.imageUrl;
    }

    public final String component2() {
        return this.updateddate;
    }

    public final AdvtImages copy(String str, String str2) {
        return new AdvtImages(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdvtImages)) {
            return false;
        }
        AdvtImages advtImages = (AdvtImages) obj;
        return Intrinsics.areEqual((Object) this.imageUrl, (Object) advtImages.imageUrl) && Intrinsics.areEqual((Object) this.updateddate, (Object) advtImages.updateddate);
    }

    public int hashCode() {
        String str = this.imageUrl;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.updateddate;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AdvtImages(imageUrl=" + this.imageUrl + ", updateddate=" + this.updateddate + ')';
    }

    public AdvtImages(String str, String str2) {
        this.imageUrl = str;
        this.updateddate = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvtImages(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final String getUpdateddate() {
        return this.updateddate;
    }

    public final void setUpdateddate(String str) {
        this.updateddate = str;
    }
}
