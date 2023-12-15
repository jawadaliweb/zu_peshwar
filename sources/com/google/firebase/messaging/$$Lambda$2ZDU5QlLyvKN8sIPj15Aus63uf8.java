package com.google.firebase.messaging;

import com.google.android.datatransport.Transformer;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

/* renamed from: com.google.firebase.messaging.-$$Lambda$2ZDU5QlLyvKN8sIPj15Aus63uf8  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$2ZDU5QlLyvKN8sIPj15Aus63uf8 implements Transformer {
    public static final /* synthetic */ $$Lambda$2ZDU5QlLyvKN8sIPj15Aus63uf8 INSTANCE = new $$Lambda$2ZDU5QlLyvKN8sIPj15Aus63uf8();

    private /* synthetic */ $$Lambda$2ZDU5QlLyvKN8sIPj15Aus63uf8() {
    }

    public final Object apply(Object obj) {
        return ((MessagingClientEventExtension) obj).toByteArray();
    }
}
