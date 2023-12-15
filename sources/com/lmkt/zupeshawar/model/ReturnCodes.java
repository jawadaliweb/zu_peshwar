package com.lmkt.zupeshawar.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.messaging.ServiceStarter;
import com.kbeanie.multipicker.api.CacheLocation;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/lmkt/zupeshawar/model/ReturnCodes;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReturnCodes.kt */
public final class ReturnCodes {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final int OK() {
        return Companion.OK();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\u0004H\u0007J\u0006\u0010\r\u001a\u00020\u0004¨\u0006\u000e"}, d2 = {"Lcom/lmkt/zupeshawar/model/ReturnCodes$Companion;", "", "()V", "BAD_REQUEST", "", "DUPLICATE", "EMPTY_REPOSNSE", "FORBIDDEN", "INTERNAL_APP_ERROR", "INTERNAL_SERVER_ERROR", "INVALID_DEVICE", "NOT_FOUND", "OK", "UNAUTHORIZED", "app_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ReturnCodes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int BAD_REQUEST() {
            return CacheLocation.INTERNAL_APP_DIR;
        }

        public final int DUPLICATE() {
            return 201;
        }

        public final int EMPTY_REPOSNSE() {
            return 101;
        }

        public final int FORBIDDEN() {
            return TypedValues.Cycle.TYPE_ALPHA;
        }

        public final int INTERNAL_APP_ERROR() {
            return 100;
        }

        public final int INTERNAL_SERVER_ERROR() {
            return ServiceStarter.ERROR_UNKNOWN;
        }

        public final int INVALID_DEVICE() {
            return 451;
        }

        public final int NOT_FOUND() {
            return 404;
        }

        @JvmStatic
        public final int OK() {
            return 200;
        }

        public final int UNAUTHORIZED() {
            return TypedValues.Cycle.TYPE_CURVE_FIT;
        }

        private Companion() {
        }
    }
}
