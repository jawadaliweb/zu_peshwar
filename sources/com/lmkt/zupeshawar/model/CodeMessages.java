package com.lmkt.zupeshawar.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/lmkt/zupeshawar/model/CodeMessages;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReturnCodes.kt */
public final class CodeMessages {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final String OK() {
        return Companion.OK();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\u0004H\u0007J\u0006\u0010\r\u001a\u00020\u0004¨\u0006\u000e"}, d2 = {"Lcom/lmkt/zupeshawar/model/CodeMessages$Companion;", "", "()V", "BAD_REQUEST", "", "DUPLICATE", "EMPTY_REPOSNSE", "FORBIDDEN", "INTERNAL_APP_ERROR", "INTERNAL_SERVER_ERROR", "INVALID_DEVICE", "NOT_FOUND", "OK", "UNAUTHORIZED", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ReturnCodes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String BAD_REQUEST() {
            return "Bad Request";
        }

        public final String DUPLICATE() {
            return "Duplicate Entry in Database.";
        }

        public final String EMPTY_REPOSNSE() {
            return "Response is Empty";
        }

        public final String FORBIDDEN() {
            return "ForBidden";
        }

        public final String INTERNAL_APP_ERROR() {
            return "Oops something went wrong.";
        }

        public final String INTERNAL_SERVER_ERROR() {
            return "Internal Server Error";
        }

        public final String INVALID_DEVICE() {
            return "Invalid Device";
        }

        public final String NOT_FOUND() {
            return "Not Found.";
        }

        @JvmStatic
        public final String OK() {
            return "Operation Successful";
        }

        public final String UNAUTHORIZED() {
            return "Unauthorized Token Request";
        }

        private Companion() {
        }
    }
}
