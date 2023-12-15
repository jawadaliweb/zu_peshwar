package com.budiyev.android.codescanner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

final class Decoder {
    /* access modifiers changed from: private */
    public volatile DecodeCallback mCallback;
    private final DecoderThread mDecoderThread;
    private final Map<DecodeHintType, Object> mHints;
    /* access modifiers changed from: private */
    public final MultiFormatReader mReader;
    private volatile State mState;
    private final StateListener mStateListener;
    /* access modifiers changed from: private */
    public volatile DecodeTask mTask;
    /* access modifiers changed from: private */
    public final Object mTaskLock = new Object();

    public enum State {
        INITIALIZED,
        IDLE,
        DECODING,
        DECODED,
        STOPPED
    }

    public interface StateListener {
        boolean onStateChanged(State state);
    }

    public Decoder(StateListener stateListener, List<BarcodeFormat> list, DecodeCallback decodeCallback) {
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.mReader = multiFormatReader;
        this.mDecoderThread = new DecoderThread();
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        this.mHints = enumMap;
        enumMap.put(DecodeHintType.POSSIBLE_FORMATS, list);
        multiFormatReader.setHints(enumMap);
        this.mCallback = decodeCallback;
        this.mStateListener = stateListener;
        this.mState = State.INITIALIZED;
    }

    public void setFormats(List<BarcodeFormat> list) {
        this.mHints.put(DecodeHintType.POSSIBLE_FORMATS, list);
        this.mReader.setHints(this.mHints);
    }

    public void setCallback(DecodeCallback decodeCallback) {
        this.mCallback = decodeCallback;
    }

    public void decode(DecodeTask decodeTask) {
        synchronized (this.mTaskLock) {
            if (this.mState != State.STOPPED) {
                this.mTask = decodeTask;
                this.mTaskLock.notify();
            }
        }
    }

    public void start() {
        if (this.mState == State.INITIALIZED) {
            this.mDecoderThread.start();
            return;
        }
        throw new IllegalStateException("Illegal decoder state");
    }

    public void shutdown() {
        this.mDecoderThread.interrupt();
        this.mTask = null;
    }

    public State getState() {
        return this.mState;
    }

    /* access modifiers changed from: private */
    public boolean setState(State state) {
        this.mState = state;
        return this.mStateListener.onStateChanged(state);
    }

    private final class DecoderThread extends Thread {
        public DecoderThread() {
            super("cs-decoder");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            com.budiyev.android.codescanner.Decoder.access$000(r4.this$0, com.budiyev.android.codescanner.Decoder.State.DECODING);
            r0 = r1.decode(com.budiyev.android.codescanner.Decoder.access$300(r4.this$0));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
            if (r0 == null) goto L_0x0005;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
            com.budiyev.android.codescanner.Decoder.access$202(r4.this$0, (com.budiyev.android.codescanner.DecodeTask) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
            if (com.budiyev.android.codescanner.Decoder.access$000(r4.this$0, com.budiyev.android.codescanner.Decoder.State.DECODED) == false) goto L_0x0005;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
            r1 = com.budiyev.android.codescanner.Decoder.access$400(r4.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
            if (r1 == null) goto L_0x0005;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
            r1.onDecoded(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
            com.budiyev.android.codescanner.Decoder.access$202(r4.this$0, (com.budiyev.android.codescanner.DecodeTask) null);
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                r0 = 10
                android.os.Process.setThreadPriority(r0)
            L_0x0005:
                com.budiyev.android.codescanner.Decoder r0 = com.budiyev.android.codescanner.Decoder.this
                com.budiyev.android.codescanner.Decoder$State r1 = com.budiyev.android.codescanner.Decoder.State.IDLE
                boolean unused = r0.setState(r1)
            L_0x000c:
                com.budiyev.android.codescanner.Decoder r0 = com.budiyev.android.codescanner.Decoder.this     // Catch:{ ReaderException -> 0x0005, all -> 0x0067 }
                java.lang.Object r0 = r0.mTaskLock     // Catch:{ ReaderException -> 0x0005, all -> 0x0067 }
                monitor-enter(r0)     // Catch:{ ReaderException -> 0x0005, all -> 0x0067 }
                com.budiyev.android.codescanner.Decoder r1 = com.budiyev.android.codescanner.Decoder.this     // Catch:{ all -> 0x0064 }
                com.budiyev.android.codescanner.DecodeTask r1 = r1.mTask     // Catch:{ all -> 0x0064 }
                if (r1 == 0) goto L_0x0050
                com.budiyev.android.codescanner.Decoder r2 = com.budiyev.android.codescanner.Decoder.this     // Catch:{ all -> 0x0064 }
                r3 = 0
                com.budiyev.android.codescanner.DecodeTask unused = r2.mTask = r3     // Catch:{ all -> 0x0064 }
                monitor-exit(r0)     // Catch:{ all -> 0x0064 }
                com.budiyev.android.codescanner.Decoder r0 = com.budiyev.android.codescanner.Decoder.this     // Catch:{ ReaderException -> 0x0005, all -> 0x0067 }
                com.budiyev.android.codescanner.Decoder$State r2 = com.budiyev.android.codescanner.Decoder.State.DECODING     // Catch:{ ReaderException -> 0x0005, all -> 0x0067 }
                boolean unused = r0.setState(r2)     // Catch:{ ReaderException -> 0x0005, all -> 0x0067 }
                com.budiyev.android.codescanner.Decoder r0 = com.budiyev.android.codescanner.Decoder.this     // Catch:{ ReaderException -> 0x0005, all -> 0x0067 }
                com.google.zxing.MultiFormatReader r0 = r0.mReader     // Catch:{ ReaderException -> 0x0005, all -> 0x0067 }
                com.google.zxing.Result r0 = r1.decode(r0)     // Catch:{ ReaderException -> 0x0005, all -> 0x0067 }
                if (r0 == 0) goto L_0x0005
                com.budiyev.android.codescanner.Decoder r1 = com.budiyev.android.codescanner.Decoder.this
                com.budiyev.android.codescanner.DecodeTask unused = r1.mTask = r3
                com.budiyev.android.codescanner.Decoder r1 = com.budiyev.android.codescanner.Decoder.this
                com.budiyev.android.codescanner.Decoder$State r2 = com.budiyev.android.codescanner.Decoder.State.DECODED
                boolean r1 = r1.setState(r2)
                if (r1 == 0) goto L_0x0005
                com.budiyev.android.codescanner.Decoder r1 = com.budiyev.android.codescanner.Decoder.this
                com.budiyev.android.codescanner.DecodeCallback r1 = r1.mCallback
                if (r1 == 0) goto L_0x0005
                r1.onDecoded(r0)
                goto L_0x0005
            L_0x0050:
                com.budiyev.android.codescanner.Decoder r1 = com.budiyev.android.codescanner.Decoder.this     // Catch:{ InterruptedException -> 0x005b }
                java.lang.Object r1 = r1.mTaskLock     // Catch:{ InterruptedException -> 0x005b }
                r1.wait()     // Catch:{ InterruptedException -> 0x005b }
                monitor-exit(r0)     // Catch:{ all -> 0x0064 }
                goto L_0x000c
            L_0x005b:
                com.budiyev.android.codescanner.Decoder r1 = com.budiyev.android.codescanner.Decoder.this     // Catch:{ all -> 0x0064 }
                com.budiyev.android.codescanner.Decoder$State r2 = com.budiyev.android.codescanner.Decoder.State.STOPPED     // Catch:{ all -> 0x0064 }
                boolean unused = r1.setState(r2)     // Catch:{ all -> 0x0064 }
                monitor-exit(r0)     // Catch:{ all -> 0x0064 }
                return
            L_0x0064:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0064 }
                throw r1     // Catch:{ ReaderException -> 0x0005, all -> 0x0067 }
            L_0x0067:
                r0 = move-exception
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.budiyev.android.codescanner.Decoder.DecoderThread.run():void");
        }
    }
}
