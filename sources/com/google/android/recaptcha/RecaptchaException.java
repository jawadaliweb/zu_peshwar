package com.google.android.recaptcha;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/google/android/recaptcha/RecaptchaException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "Lcom/google/android/recaptcha/RecaptchaErrorCode;", "errorMessage", "", "(Lcom/google/android/recaptcha/RecaptchaErrorCode;Ljava/lang/String;)V", "getErrorCode", "()Lcom/google/android/recaptcha/RecaptchaErrorCode;", "getErrorMessage", "()Ljava/lang/String;", "java.com.google.android.libraries.abuse.recaptcha.enterprise.public_public"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
public final class RecaptchaException extends Exception {
    private final RecaptchaErrorCode errorCode;
    private final String errorMessage;

    public RecaptchaException(RecaptchaErrorCode recaptchaErrorCode, String str) {
        super(str);
        this.errorCode = recaptchaErrorCode;
        this.errorMessage = str;
    }

    public final RecaptchaErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecaptchaException(RecaptchaErrorCode recaptchaErrorCode, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recaptchaErrorCode, (i & 2) != 0 ? recaptchaErrorCode.getErrorMessage() : str);
    }
}
