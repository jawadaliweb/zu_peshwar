package com.google.firebase.database.ktx;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/google/firebase/database/ktx/DatabaseKt$snapshots$1$listener$1", "Lcom/google/firebase/database/ValueEventListener;", "onCancelled", "", "error", "Lcom/google/firebase/database/DatabaseError;", "onDataChange", "snapshot", "Lcom/google/firebase/database/DataSnapshot;", "com.google.firebase-firebase-database-ktx"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Database.kt */
public final class DatabaseKt$snapshots$1$listener$1 implements ValueEventListener {
    final /* synthetic */ ProducerScope<DataSnapshot> $$this$callbackFlow;
    final /* synthetic */ Query $this_snapshots;

    DatabaseKt$snapshots$1$listener$1(Query query, ProducerScope<? super DataSnapshot> producerScope) {
        this.$this_snapshots = query;
        this.$$this$callbackFlow = producerScope;
    }

    public void onDataChange(DataSnapshot dataSnapshot) {
        Intrinsics.checkNotNullParameter(dataSnapshot, "snapshot");
        this.$this_snapshots.getRepo().scheduleNow(new Runnable(dataSnapshot) {
            public final /* synthetic */ DataSnapshot f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DatabaseKt$snapshots$1$listener$1.m16onDataChange$lambda0(ProducerScope.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onDataChange$lambda-0  reason: not valid java name */
    public static final void m16onDataChange$lambda0(ProducerScope producerScope, DataSnapshot dataSnapshot) {
        Intrinsics.checkNotNullParameter(producerScope, "$$this$callbackFlow");
        Intrinsics.checkNotNullParameter(dataSnapshot, "$snapshot");
        ChannelsKt.trySendBlocking(producerScope, dataSnapshot);
    }

    public void onCancelled(DatabaseError databaseError) {
        Intrinsics.checkNotNullParameter(databaseError, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        CoroutineScopeKt.cancel(this.$$this$callbackFlow, "Error getting Query snapshot", databaseError.toException());
    }
}
