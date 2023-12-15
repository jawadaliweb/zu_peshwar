package com.google.firebase.database.ktx;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ktx.ChildEvent;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"com/google/firebase/database/ktx/DatabaseKt$childEvents$1$listener$1", "Lcom/google/firebase/database/ChildEventListener;", "onCancelled", "", "error", "Lcom/google/firebase/database/DatabaseError;", "onChildAdded", "snapshot", "Lcom/google/firebase/database/DataSnapshot;", "previousChildName", "", "onChildChanged", "onChildMoved", "onChildRemoved", "com.google.firebase-firebase-database-ktx"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Database.kt */
public final class DatabaseKt$childEvents$1$listener$1 implements ChildEventListener {
    final /* synthetic */ ProducerScope<ChildEvent> $$this$callbackFlow;
    final /* synthetic */ Query $this_childEvents;

    DatabaseKt$childEvents$1$listener$1(Query query, ProducerScope<? super ChildEvent> producerScope) {
        this.$this_childEvents = query;
        this.$$this$callbackFlow = producerScope;
    }

    public void onChildAdded(DataSnapshot dataSnapshot, String str) {
        Intrinsics.checkNotNullParameter(dataSnapshot, "snapshot");
        this.$this_childEvents.getRepo().scheduleNow(new Runnable(dataSnapshot, str) {
            public final /* synthetic */ DataSnapshot f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DatabaseKt$childEvents$1$listener$1.m12onChildAdded$lambda0(ProducerScope.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onChildAdded$lambda-0  reason: not valid java name */
    public static final void m12onChildAdded$lambda0(ProducerScope producerScope, DataSnapshot dataSnapshot, String str) {
        Intrinsics.checkNotNullParameter(producerScope, "$$this$callbackFlow");
        Intrinsics.checkNotNullParameter(dataSnapshot, "$snapshot");
        ChannelsKt.trySendBlocking(producerScope, new ChildEvent.Added(dataSnapshot, str));
    }

    public void onChildChanged(DataSnapshot dataSnapshot, String str) {
        Intrinsics.checkNotNullParameter(dataSnapshot, "snapshot");
        this.$this_childEvents.getRepo().scheduleNow(new Runnable(dataSnapshot, str) {
            public final /* synthetic */ DataSnapshot f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DatabaseKt$childEvents$1$listener$1.m13onChildChanged$lambda1(ProducerScope.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onChildChanged$lambda-1  reason: not valid java name */
    public static final void m13onChildChanged$lambda1(ProducerScope producerScope, DataSnapshot dataSnapshot, String str) {
        Intrinsics.checkNotNullParameter(producerScope, "$$this$callbackFlow");
        Intrinsics.checkNotNullParameter(dataSnapshot, "$snapshot");
        ChannelsKt.trySendBlocking(producerScope, new ChildEvent.Changed(dataSnapshot, str));
    }

    public void onChildRemoved(DataSnapshot dataSnapshot) {
        Intrinsics.checkNotNullParameter(dataSnapshot, "snapshot");
        this.$this_childEvents.getRepo().scheduleNow(new Runnable(dataSnapshot) {
            public final /* synthetic */ DataSnapshot f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DatabaseKt$childEvents$1$listener$1.m15onChildRemoved$lambda2(ProducerScope.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onChildRemoved$lambda-2  reason: not valid java name */
    public static final void m15onChildRemoved$lambda2(ProducerScope producerScope, DataSnapshot dataSnapshot) {
        Intrinsics.checkNotNullParameter(producerScope, "$$this$callbackFlow");
        Intrinsics.checkNotNullParameter(dataSnapshot, "$snapshot");
        ChannelsKt.trySendBlocking(producerScope, new ChildEvent.Removed(dataSnapshot));
    }

    public void onChildMoved(DataSnapshot dataSnapshot, String str) {
        Intrinsics.checkNotNullParameter(dataSnapshot, "snapshot");
        this.$this_childEvents.getRepo().scheduleNow(new Runnable(dataSnapshot, str) {
            public final /* synthetic */ DataSnapshot f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DatabaseKt$childEvents$1$listener$1.m14onChildMoved$lambda3(ProducerScope.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onChildMoved$lambda-3  reason: not valid java name */
    public static final void m14onChildMoved$lambda3(ProducerScope producerScope, DataSnapshot dataSnapshot, String str) {
        Intrinsics.checkNotNullParameter(producerScope, "$$this$callbackFlow");
        Intrinsics.checkNotNullParameter(dataSnapshot, "$snapshot");
        ChannelsKt.trySendBlocking(producerScope, new ChildEvent.Moved(dataSnapshot, str));
    }

    public void onCancelled(DatabaseError databaseError) {
        Intrinsics.checkNotNullParameter(databaseError, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        CoroutineScopeKt.cancel(this.$$this$callbackFlow, "Error getting Query childEvent", databaseError.toException());
    }
}
