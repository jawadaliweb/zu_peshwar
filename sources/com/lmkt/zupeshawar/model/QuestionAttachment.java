package com.lmkt.zupeshawar.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b,\b\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jl\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u00020\u0007HÖ\u0001R \u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00065"}, d2 = {"Lcom/lmkt/zupeshawar/model/QuestionAttachment;", "", "questionAttachmentId", "", "questionId", "commentId", "fileTagForIdentification", "", "isServerImage", "", "type", "attachmentUrl", "attachmentFile", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;ILjava/lang/String;Ljava/lang/String;)V", "getAttachmentFile", "()Ljava/lang/String;", "setAttachmentFile", "(Ljava/lang/String;)V", "getAttachmentUrl", "setAttachmentUrl", "getCommentId", "()Ljava/lang/Integer;", "setCommentId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFileTagForIdentification", "setFileTagForIdentification", "()Ljava/lang/Boolean;", "setServerImage", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getQuestionAttachmentId", "setQuestionAttachmentId", "getQuestionId", "setQuestionId", "getType", "()I", "setType", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;ILjava/lang/String;Ljava/lang/String;)Lcom/lmkt/zupeshawar/model/QuestionAttachment;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: QuestionAttachment.kt */
public final class QuestionAttachment {
    @SerializedName("attachmentFile")
    private String attachmentFile;
    @SerializedName("attachmentUrl")
    private String attachmentUrl;
    @SerializedName("commentId")
    private Integer commentId;
    private String fileTagForIdentification;
    private Boolean isServerImage;
    @SerializedName("questionAttachmentId")
    private Integer questionAttachmentId;
    @SerializedName("questionId")
    private Integer questionId;
    @SerializedName("type")
    private int type;

    public QuestionAttachment() {
        this((Integer) null, (Integer) null, (Integer) null, (String) null, (Boolean) null, 0, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ QuestionAttachment copy$default(QuestionAttachment questionAttachment, Integer num, Integer num2, Integer num3, String str, Boolean bool, int i, String str2, String str3, int i2, Object obj) {
        QuestionAttachment questionAttachment2 = questionAttachment;
        int i3 = i2;
        return questionAttachment.copy((i3 & 1) != 0 ? questionAttachment2.questionAttachmentId : num, (i3 & 2) != 0 ? questionAttachment2.questionId : num2, (i3 & 4) != 0 ? questionAttachment2.commentId : num3, (i3 & 8) != 0 ? questionAttachment2.fileTagForIdentification : str, (i3 & 16) != 0 ? questionAttachment2.isServerImage : bool, (i3 & 32) != 0 ? questionAttachment2.type : i, (i3 & 64) != 0 ? questionAttachment2.attachmentUrl : str2, (i3 & 128) != 0 ? questionAttachment2.attachmentFile : str3);
    }

    public final Integer component1() {
        return this.questionAttachmentId;
    }

    public final Integer component2() {
        return this.questionId;
    }

    public final Integer component3() {
        return this.commentId;
    }

    public final String component4() {
        return this.fileTagForIdentification;
    }

    public final Boolean component5() {
        return this.isServerImage;
    }

    public final int component6() {
        return this.type;
    }

    public final String component7() {
        return this.attachmentUrl;
    }

    public final String component8() {
        return this.attachmentFile;
    }

    public final QuestionAttachment copy(Integer num, Integer num2, Integer num3, String str, Boolean bool, int i, String str2, String str3) {
        return new QuestionAttachment(num, num2, num3, str, bool, i, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuestionAttachment)) {
            return false;
        }
        QuestionAttachment questionAttachment = (QuestionAttachment) obj;
        return Intrinsics.areEqual((Object) this.questionAttachmentId, (Object) questionAttachment.questionAttachmentId) && Intrinsics.areEqual((Object) this.questionId, (Object) questionAttachment.questionId) && Intrinsics.areEqual((Object) this.commentId, (Object) questionAttachment.commentId) && Intrinsics.areEqual((Object) this.fileTagForIdentification, (Object) questionAttachment.fileTagForIdentification) && Intrinsics.areEqual((Object) this.isServerImage, (Object) questionAttachment.isServerImage) && this.type == questionAttachment.type && Intrinsics.areEqual((Object) this.attachmentUrl, (Object) questionAttachment.attachmentUrl) && Intrinsics.areEqual((Object) this.attachmentFile, (Object) questionAttachment.attachmentFile);
    }

    public int hashCode() {
        Integer num = this.questionAttachmentId;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.questionId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.commentId;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.fileTagForIdentification;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.isServerImage;
        int hashCode5 = (((hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31) + this.type) * 31;
        String str2 = this.attachmentUrl;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.attachmentFile;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "QuestionAttachment(questionAttachmentId=" + this.questionAttachmentId + ", questionId=" + this.questionId + ", commentId=" + this.commentId + ", fileTagForIdentification=" + this.fileTagForIdentification + ", isServerImage=" + this.isServerImage + ", type=" + this.type + ", attachmentUrl=" + this.attachmentUrl + ", attachmentFile=" + this.attachmentFile + ')';
    }

    public QuestionAttachment(Integer num, Integer num2, Integer num3, String str, Boolean bool, int i, String str2, String str3) {
        this.questionAttachmentId = num;
        this.questionId = num2;
        this.commentId = num3;
        this.fileTagForIdentification = str;
        this.isServerImage = bool;
        this.type = i;
        this.attachmentUrl = str2;
        this.attachmentFile = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ QuestionAttachment(java.lang.Integer r10, java.lang.Integer r11, java.lang.Integer r12, java.lang.String r13, java.lang.Boolean r14, int r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            if (r1 == 0) goto L_0x000d
            r1 = r3
            goto L_0x000e
        L_0x000d:
            r1 = r10
        L_0x000e:
            r4 = r0 & 2
            if (r4 == 0) goto L_0x0014
            r4 = r3
            goto L_0x0015
        L_0x0014:
            r4 = r11
        L_0x0015:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r3 = r12
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = 0
            goto L_0x0022
        L_0x0021:
            r5 = r13
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002c
            r6 = 1
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            goto L_0x002d
        L_0x002c:
            r6 = r14
        L_0x002d:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0032
            goto L_0x0033
        L_0x0032:
            r2 = r15
        L_0x0033:
            r7 = r0 & 64
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x003b
            r7 = r8
            goto L_0x003d
        L_0x003b:
            r7 = r16
        L_0x003d:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r8 = r17
        L_0x0044:
            r10 = r9
            r11 = r1
            r12 = r4
            r13 = r3
            r14 = r5
            r15 = r6
            r16 = r2
            r17 = r7
            r18 = r8
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.model.QuestionAttachment.<init>(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Boolean, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getQuestionAttachmentId() {
        return this.questionAttachmentId;
    }

    public final void setQuestionAttachmentId(Integer num) {
        this.questionAttachmentId = num;
    }

    public final Integer getQuestionId() {
        return this.questionId;
    }

    public final void setQuestionId(Integer num) {
        this.questionId = num;
    }

    public final Integer getCommentId() {
        return this.commentId;
    }

    public final void setCommentId(Integer num) {
        this.commentId = num;
    }

    public final String getFileTagForIdentification() {
        return this.fileTagForIdentification;
    }

    public final void setFileTagForIdentification(String str) {
        this.fileTagForIdentification = str;
    }

    public final Boolean isServerImage() {
        return this.isServerImage;
    }

    public final void setServerImage(Boolean bool) {
        this.isServerImage = bool;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getAttachmentUrl() {
        return this.attachmentUrl;
    }

    public final void setAttachmentUrl(String str) {
        this.attachmentUrl = str;
    }

    public final String getAttachmentFile() {
        return this.attachmentFile;
    }

    public final void setAttachmentFile(String str) {
        this.attachmentFile = str;
    }
}
