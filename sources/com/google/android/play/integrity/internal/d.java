package com.google.android.play.integrity.internal;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
final class d extends e {
    private final long a;

    d(int i, long j) {
        this.a = j;
    }

    public final int a() {
        return 3;
    }

    public final long b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            eVar.a();
            if (this.a == eVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.a;
        return -724379968 ^ ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        long j = this.a;
        return "EventRecord{eventType=3, eventTimestamp=" + j + "}";
    }
}
