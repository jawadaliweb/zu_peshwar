package com.budiyev.android.codescanner;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Process;
import android.view.SurfaceHolder;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.Decoder;
import com.google.zxing.BarcodeFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlinx.coroutines.DebugKt;

public final class CodeScanner {
    public static final List<BarcodeFormat> ALL_FORMATS;
    public static final int CAMERA_BACK = -1;
    public static final int CAMERA_FRONT = -2;
    private static final boolean DEFAULT_AUTO_FOCUS_ENABLED = true;
    private static final AutoFocusMode DEFAULT_AUTO_FOCUS_MODE = AutoFocusMode.SAFE;
    private static final boolean DEFAULT_FLASH_ENABLED = false;
    private static final List<BarcodeFormat> DEFAULT_FORMATS;
    private static final long DEFAULT_SAFE_AUTO_FOCUS_INTERVAL = 2000;
    private static final ScanMode DEFAULT_SCAN_MODE = ScanMode.SINGLE;
    private static final boolean DEFAULT_TOUCH_FOCUS_ENABLED = true;
    public static final List<BarcodeFormat> ONE_DIMENSIONAL_FORMATS = Collections.unmodifiableList(Arrays.asList(new BarcodeFormat[]{BarcodeFormat.CODABAR, BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.EAN_8, BarcodeFormat.EAN_13, BarcodeFormat.ITF, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED, BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.UPC_EAN_EXTENSION}));
    private static final int SAFE_AUTO_FOCUS_ATTEMPTS_THRESHOLD = 2;
    public static final List<BarcodeFormat> TWO_DIMENSIONAL_FORMATS = Collections.unmodifiableList(Arrays.asList(new BarcodeFormat[]{BarcodeFormat.AZTEC, BarcodeFormat.DATA_MATRIX, BarcodeFormat.MAXICODE, BarcodeFormat.PDF_417, BarcodeFormat.QR_CODE}));
    /* access modifiers changed from: private */
    public volatile boolean mAutoFocusEnabled;
    /* access modifiers changed from: private */
    public volatile AutoFocusMode mAutoFocusMode;
    /* access modifiers changed from: private */
    public volatile int mCameraId;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public volatile DecodeCallback mDecodeCallback;
    /* access modifiers changed from: private */
    public final DecoderStateListener mDecoderStateListener;
    /* access modifiers changed from: private */
    public volatile DecoderWrapper mDecoderWrapper;
    /* access modifiers changed from: private */
    public volatile ErrorCallback mErrorCallback;
    /* access modifiers changed from: private */
    public volatile boolean mFlashEnabled;
    /* access modifiers changed from: private */
    public volatile List<BarcodeFormat> mFormats;
    /* access modifiers changed from: private */
    public volatile boolean mInitialization;
    /* access modifiers changed from: private */
    public boolean mInitializationRequested;
    /* access modifiers changed from: private */
    public final Object mInitializeLock;
    /* access modifiers changed from: private */
    public volatile boolean mInitialized;
    /* access modifiers changed from: private */
    public final Handler mMainThreadHandler;
    /* access modifiers changed from: private */
    public boolean mPreviewActive;
    private final Camera.PreviewCallback mPreviewCallback;
    private int mSafeAutoFocusAttemptsCount;
    private final Camera.AutoFocusCallback mSafeAutoFocusCallback;
    private volatile long mSafeAutoFocusInterval;
    private final Runnable mSafeAutoFocusTask;
    /* access modifiers changed from: private */
    public boolean mSafeAutoFocusTaskScheduled;
    /* access modifiers changed from: private */
    public boolean mSafeAutoFocusing;
    /* access modifiers changed from: private */
    public volatile ScanMode mScanMode;
    /* access modifiers changed from: private */
    public final CodeScannerView mScannerView;
    /* access modifiers changed from: private */
    public final Runnable mStopPreviewTask;
    /* access modifiers changed from: private */
    public volatile boolean mStoppingPreview;
    private final SurfaceHolder.Callback mSurfaceCallback;
    private final SurfaceHolder mSurfaceHolder;
    private final Camera.AutoFocusCallback mTouchFocusCallback;
    private boolean mTouchFocusEnabled;
    /* access modifiers changed from: private */
    public boolean mTouchFocusing;
    /* access modifiers changed from: private */
    public int mViewHeight;
    /* access modifiers changed from: private */
    public int mViewWidth;
    /* access modifiers changed from: private */
    public volatile int mZoom;

    static {
        List<BarcodeFormat> unmodifiableList = Collections.unmodifiableList(Arrays.asList(BarcodeFormat.values()));
        ALL_FORMATS = unmodifiableList;
        DEFAULT_FORMATS = unmodifiableList;
    }

    public CodeScanner(Context context, CodeScannerView codeScannerView) {
        this.mInitializeLock = new Object();
        this.mFormats = DEFAULT_FORMATS;
        this.mScanMode = DEFAULT_SCAN_MODE;
        this.mAutoFocusMode = DEFAULT_AUTO_FOCUS_MODE;
        this.mDecodeCallback = null;
        this.mErrorCallback = null;
        this.mDecoderWrapper = null;
        this.mInitialization = false;
        this.mInitialized = false;
        this.mStoppingPreview = false;
        this.mAutoFocusEnabled = true;
        this.mFlashEnabled = false;
        this.mSafeAutoFocusInterval = DEFAULT_SAFE_AUTO_FOCUS_INTERVAL;
        this.mCameraId = -1;
        this.mZoom = 0;
        this.mTouchFocusEnabled = true;
        this.mTouchFocusing = false;
        this.mPreviewActive = false;
        this.mSafeAutoFocusing = false;
        this.mSafeAutoFocusTaskScheduled = false;
        this.mInitializationRequested = false;
        this.mSafeAutoFocusAttemptsCount = 0;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mContext = context;
        this.mScannerView = codeScannerView;
        this.mSurfaceHolder = codeScannerView.getPreviewView().getHolder();
        this.mMainThreadHandler = new Handler();
        this.mSurfaceCallback = new SurfaceCallback();
        this.mPreviewCallback = new PreviewCallback();
        this.mTouchFocusCallback = new TouchFocusCallback();
        this.mSafeAutoFocusCallback = new SafeAutoFocusCallback();
        this.mSafeAutoFocusTask = new SafeAutoFocusTask();
        this.mStopPreviewTask = new StopPreviewTask();
        this.mDecoderStateListener = new DecoderStateListener();
        codeScannerView.setCodeScanner(this);
        codeScannerView.setSizeListener(new ScannerSizeListener());
    }

    public CodeScanner(Context context, CodeScannerView codeScannerView, int i) {
        this(context, codeScannerView);
        this.mCameraId = i;
    }

    public int getCamera() {
        return this.mCameraId;
    }

    public void setCamera(int i) {
        synchronized (this.mInitializeLock) {
            if (this.mCameraId != i) {
                this.mCameraId = i;
                if (this.mInitialized) {
                    boolean z = this.mPreviewActive;
                    releaseResources();
                    if (z) {
                        initialize();
                    }
                }
            }
        }
    }

    public List<BarcodeFormat> getFormats() {
        return this.mFormats;
    }

    public void setFormats(List<BarcodeFormat> list) {
        DecoderWrapper decoderWrapper;
        synchronized (this.mInitializeLock) {
            Objects.requireNonNull(list);
            this.mFormats = list;
            if (this.mInitialized && (decoderWrapper = this.mDecoderWrapper) != null) {
                decoderWrapper.getDecoder().setFormats(list);
            }
        }
    }

    public DecodeCallback getDecodeCallback() {
        return this.mDecodeCallback;
    }

    public void setDecodeCallback(DecodeCallback decodeCallback) {
        DecoderWrapper decoderWrapper;
        synchronized (this.mInitializeLock) {
            this.mDecodeCallback = decodeCallback;
            if (this.mInitialized && (decoderWrapper = this.mDecoderWrapper) != null) {
                decoderWrapper.getDecoder().setCallback(decodeCallback);
            }
        }
    }

    public ErrorCallback getErrorCallback() {
        return this.mErrorCallback;
    }

    public void setErrorCallback(ErrorCallback errorCallback) {
        this.mErrorCallback = errorCallback;
    }

    public ScanMode getScanMode() {
        return this.mScanMode;
    }

    public void setScanMode(ScanMode scanMode) {
        Objects.requireNonNull(scanMode);
        this.mScanMode = scanMode;
    }

    public int getZoom() {
        return this.mZoom;
    }

    public void setZoom(int i) {
        DecoderWrapper decoderWrapper;
        if (i >= 0) {
            synchronized (this.mInitializeLock) {
                if (i != this.mZoom) {
                    this.mZoom = i;
                    if (this.mInitialized && (decoderWrapper = this.mDecoderWrapper) != null) {
                        Camera camera = decoderWrapper.getCamera();
                        Camera.Parameters parameters = camera.getParameters();
                        Utils.setZoom(parameters, i);
                        camera.setParameters(parameters);
                    }
                }
            }
            this.mZoom = i;
            return;
        }
        throw new IllegalArgumentException("Zoom value must be greater than or equal to zero");
    }

    public boolean isTouchFocusEnabled() {
        return this.mTouchFocusEnabled;
    }

    public void setTouchFocusEnabled(boolean z) {
        this.mTouchFocusEnabled = z;
    }

    public boolean isAutoFocusEnabled() {
        return this.mAutoFocusEnabled;
    }

    public void setAutoFocusEnabled(boolean z) {
        synchronized (this.mInitializeLock) {
            boolean z2 = this.mAutoFocusEnabled != z;
            this.mAutoFocusEnabled = z;
            this.mScannerView.setAutoFocusEnabled(z);
            DecoderWrapper decoderWrapper = this.mDecoderWrapper;
            if (this.mInitialized && this.mPreviewActive && z2 && decoderWrapper != null && decoderWrapper.isAutoFocusSupported()) {
                setAutoFocusEnabledInternal(z);
            }
        }
    }

    public AutoFocusMode getAutoFocusMode() {
        return this.mAutoFocusMode;
    }

    public void setAutoFocusMode(AutoFocusMode autoFocusMode) {
        synchronized (this.mInitializeLock) {
            Objects.requireNonNull(autoFocusMode);
            this.mAutoFocusMode = autoFocusMode;
            if (this.mInitialized && this.mAutoFocusEnabled) {
                setAutoFocusEnabledInternal(true);
            }
        }
    }

    public void setAutoFocusInterval(long j) {
        this.mSafeAutoFocusInterval = j;
    }

    public boolean isFlashEnabled() {
        return this.mFlashEnabled;
    }

    public void setFlashEnabled(boolean z) {
        synchronized (this.mInitializeLock) {
            boolean z2 = this.mFlashEnabled != z;
            this.mFlashEnabled = z;
            this.mScannerView.setFlashEnabled(z);
            DecoderWrapper decoderWrapper = this.mDecoderWrapper;
            if (this.mInitialized && this.mPreviewActive && z2 && decoderWrapper != null && decoderWrapper.isFlashSupported()) {
                setFlashEnabledInternal(z);
            }
        }
    }

    public boolean isPreviewActive() {
        return this.mPreviewActive;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        if (r2.mPreviewActive != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
        r2.mSurfaceHolder.addCallback(r2.mSurfaceCallback);
        startPreviewInternal(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startPreview() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.mInitializeLock
            monitor-enter(r0)
            boolean r1 = r2.mInitialized     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x0010
            boolean r1 = r2.mInitialization     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x0010
            r2.initialize()     // Catch:{ all -> 0x0021 }
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return
        L_0x0010:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            boolean r0 = r2.mPreviewActive
            if (r0 != 0) goto L_0x0020
            android.view.SurfaceHolder r0 = r2.mSurfaceHolder
            android.view.SurfaceHolder$Callback r1 = r2.mSurfaceCallback
            r0.addCallback(r1)
            r0 = 0
            r2.startPreviewInternal(r0)
        L_0x0020:
            return
        L_0x0021:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.budiyev.android.codescanner.CodeScanner.startPreview():void");
    }

    public void stopPreview() {
        if (this.mInitialized && this.mPreviewActive) {
            this.mSurfaceHolder.removeCallback(this.mSurfaceCallback);
            stopPreviewInternal(false);
        }
    }

    public void releaseResources() {
        if (this.mInitialized) {
            if (this.mPreviewActive) {
                stopPreview();
            }
            releaseResourcesInternal();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(4:9|10|11|(3:16|(1:20)|21))|22|23) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0064 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void performTouchFocus(com.budiyev.android.codescanner.Rect r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.mInitializeLock
            monitor-enter(r0)
            boolean r1 = r8.mInitialized     // Catch:{ all -> 0x0066 }
            if (r1 == 0) goto L_0x0064
            boolean r1 = r8.mPreviewActive     // Catch:{ all -> 0x0066 }
            if (r1 == 0) goto L_0x0064
            boolean r1 = r8.mTouchFocusing     // Catch:{ all -> 0x0066 }
            if (r1 != 0) goto L_0x0064
            r1 = 0
            r8.setAutoFocusEnabled(r1)     // Catch:{ Exception -> 0x0064 }
            com.budiyev.android.codescanner.DecoderWrapper r1 = r8.mDecoderWrapper     // Catch:{ Exception -> 0x0064 }
            boolean r2 = r8.mPreviewActive     // Catch:{ Exception -> 0x0064 }
            if (r2 == 0) goto L_0x0064
            if (r1 == 0) goto L_0x0064
            boolean r2 = r1.isAutoFocusSupported()     // Catch:{ Exception -> 0x0064 }
            if (r2 == 0) goto L_0x0064
            com.budiyev.android.codescanner.Point r2 = r1.getImageSize()     // Catch:{ Exception -> 0x0064 }
            int r3 = r2.getX()     // Catch:{ Exception -> 0x0064 }
            int r2 = r2.getY()     // Catch:{ Exception -> 0x0064 }
            int r4 = r1.getDisplayOrientation()     // Catch:{ Exception -> 0x0064 }
            r5 = 90
            if (r4 == r5) goto L_0x0039
            r5 = 270(0x10e, float:3.78E-43)
            if (r4 != r5) goto L_0x003c
        L_0x0039:
            r7 = r3
            r3 = r2
            r2 = r7
        L_0x003c:
            com.budiyev.android.codescanner.Point r5 = r1.getPreviewSize()     // Catch:{ Exception -> 0x0064 }
            com.budiyev.android.codescanner.Point r6 = r1.getViewSize()     // Catch:{ Exception -> 0x0064 }
            com.budiyev.android.codescanner.Rect r9 = com.budiyev.android.codescanner.Utils.getImageFrameRect(r3, r2, r9, r5, r6)     // Catch:{ Exception -> 0x0064 }
            android.hardware.Camera r1 = r1.getCamera()     // Catch:{ Exception -> 0x0064 }
            r1.cancelAutoFocus()     // Catch:{ Exception -> 0x0064 }
            android.hardware.Camera$Parameters r5 = r1.getParameters()     // Catch:{ Exception -> 0x0064 }
            com.budiyev.android.codescanner.Utils.configureFocusArea(r5, r9, r3, r2, r4)     // Catch:{ Exception -> 0x0064 }
            com.budiyev.android.codescanner.Utils.configureFocusModeForTouch(r5)     // Catch:{ Exception -> 0x0064 }
            r1.setParameters(r5)     // Catch:{ Exception -> 0x0064 }
            android.hardware.Camera$AutoFocusCallback r9 = r8.mTouchFocusCallback     // Catch:{ Exception -> 0x0064 }
            r1.autoFocus(r9)     // Catch:{ Exception -> 0x0064 }
            r9 = 1
            r8.mTouchFocusing = r9     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            return
        L_0x0066:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.budiyev.android.codescanner.CodeScanner.performTouchFocus(com.budiyev.android.codescanner.Rect):void");
    }

    /* access modifiers changed from: package-private */
    public boolean isAutoFocusSupportedOrUnknown() {
        DecoderWrapper decoderWrapper = this.mDecoderWrapper;
        return decoderWrapper == null || decoderWrapper.isAutoFocusSupported();
    }

    /* access modifiers changed from: package-private */
    public boolean isFlashSupportedOrUnknown() {
        DecoderWrapper decoderWrapper = this.mDecoderWrapper;
        return decoderWrapper == null || decoderWrapper.isFlashSupported();
    }

    private void initialize() {
        initialize(this.mScannerView.getWidth(), this.mScannerView.getHeight());
    }

    /* access modifiers changed from: private */
    public void initialize(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        if (i <= 0 || i2 <= 0) {
            this.mInitializationRequested = true;
            return;
        }
        this.mInitialization = true;
        this.mInitializationRequested = false;
        new InitializationThread(i, i2).start();
    }

    private void startPreviewInternal(boolean z) {
        try {
            DecoderWrapper decoderWrapper = this.mDecoderWrapper;
            if (decoderWrapper != null) {
                Camera camera = decoderWrapper.getCamera();
                camera.setPreviewCallback(this.mPreviewCallback);
                camera.setPreviewDisplay(this.mSurfaceHolder);
                if (!z && decoderWrapper.isFlashSupported() && this.mFlashEnabled) {
                    setFlashEnabledInternal(true);
                }
                camera.startPreview();
                this.mStoppingPreview = false;
                this.mPreviewActive = true;
                this.mSafeAutoFocusing = false;
                this.mSafeAutoFocusAttemptsCount = 0;
                if (decoderWrapper.isAutoFocusSupported() && this.mAutoFocusEnabled) {
                    Rect frameRect = this.mScannerView.getFrameRect();
                    if (frameRect != null) {
                        Camera.Parameters parameters = camera.getParameters();
                        Utils.configureDefaultFocusArea(parameters, decoderWrapper, frameRect);
                        camera.setParameters(parameters);
                    }
                    if (this.mAutoFocusMode == AutoFocusMode.SAFE) {
                        scheduleSafeAutoFocusTask();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void startPreviewInternalSafe() {
        if (this.mInitialized && !this.mPreviewActive) {
            startPreviewInternal(true);
        }
    }

    private void stopPreviewInternal(boolean z) {
        try {
            DecoderWrapper decoderWrapper = this.mDecoderWrapper;
            if (decoderWrapper != null) {
                Camera camera = decoderWrapper.getCamera();
                camera.cancelAutoFocus();
                Camera.Parameters parameters = camera.getParameters();
                if (!z && decoderWrapper.isFlashSupported() && this.mFlashEnabled) {
                    Utils.setFlashMode(parameters, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                }
                camera.setParameters(parameters);
                camera.setPreviewCallback((Camera.PreviewCallback) null);
                camera.stopPreview();
            }
        } catch (Exception unused) {
        }
        this.mStoppingPreview = false;
        this.mPreviewActive = false;
        this.mSafeAutoFocusing = false;
        this.mSafeAutoFocusAttemptsCount = 0;
    }

    /* access modifiers changed from: private */
    public void stopPreviewInternalSafe() {
        if (this.mInitialized && this.mPreviewActive) {
            stopPreviewInternal(true);
        }
    }

    /* access modifiers changed from: private */
    public void releaseResourcesInternal() {
        this.mInitialized = false;
        this.mInitialization = false;
        this.mStoppingPreview = false;
        this.mPreviewActive = false;
        this.mSafeAutoFocusing = false;
        DecoderWrapper decoderWrapper = this.mDecoderWrapper;
        if (decoderWrapper != null) {
            this.mDecoderWrapper = null;
            decoderWrapper.release();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r0 = r0.getCamera();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setFlashEnabledInternal(boolean r3) {
        /*
            r2 = this;
            com.budiyev.android.codescanner.DecoderWrapper r0 = r2.mDecoderWrapper     // Catch:{ Exception -> 0x001f }
            if (r0 == 0) goto L_0x001f
            android.hardware.Camera r0 = r0.getCamera()     // Catch:{ Exception -> 0x001f }
            android.hardware.Camera$Parameters r1 = r0.getParameters()     // Catch:{ Exception -> 0x001f }
            if (r1 != 0) goto L_0x000f
            return
        L_0x000f:
            if (r3 == 0) goto L_0x0017
            java.lang.String r3 = "torch"
            com.budiyev.android.codescanner.Utils.setFlashMode(r1, r3)     // Catch:{ Exception -> 0x001f }
            goto L_0x001c
        L_0x0017:
            java.lang.String r3 = "off"
            com.budiyev.android.codescanner.Utils.setFlashMode(r1, r3)     // Catch:{ Exception -> 0x001f }
        L_0x001c:
            r0.setParameters(r1)     // Catch:{ Exception -> 0x001f }
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.budiyev.android.codescanner.CodeScanner.setFlashEnabledInternal(boolean):void");
    }

    private void setAutoFocusEnabledInternal(boolean z) {
        Rect frameRect;
        try {
            DecoderWrapper decoderWrapper = this.mDecoderWrapper;
            if (decoderWrapper != null) {
                Camera camera = decoderWrapper.getCamera();
                camera.cancelAutoFocus();
                this.mTouchFocusing = false;
                Camera.Parameters parameters = camera.getParameters();
                AutoFocusMode autoFocusMode = this.mAutoFocusMode;
                if (z) {
                    Utils.setAutoFocusMode(parameters, autoFocusMode);
                } else {
                    Utils.disableAutoFocus(parameters);
                }
                if (z && (frameRect = this.mScannerView.getFrameRect()) != null) {
                    Utils.configureDefaultFocusArea(parameters, decoderWrapper, frameRect);
                }
                camera.setParameters(parameters);
                if (z) {
                    this.mSafeAutoFocusAttemptsCount = 0;
                    this.mSafeAutoFocusing = false;
                    if (autoFocusMode == AutoFocusMode.SAFE) {
                        scheduleSafeAutoFocusTask();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void safeAutoFocusCamera() {
        DecoderWrapper decoderWrapper;
        int i;
        if (this.mInitialized && this.mPreviewActive && (decoderWrapper = this.mDecoderWrapper) != null && decoderWrapper.isAutoFocusSupported() && this.mAutoFocusEnabled) {
            if (!this.mSafeAutoFocusing || (i = this.mSafeAutoFocusAttemptsCount) >= 2) {
                try {
                    Camera camera = decoderWrapper.getCamera();
                    camera.cancelAutoFocus();
                    camera.autoFocus(this.mSafeAutoFocusCallback);
                    this.mSafeAutoFocusAttemptsCount = 0;
                    this.mSafeAutoFocusing = true;
                } catch (Exception unused) {
                    this.mSafeAutoFocusing = false;
                }
            } else {
                this.mSafeAutoFocusAttemptsCount = i + 1;
            }
            scheduleSafeAutoFocusTask();
        }
    }

    private void scheduleSafeAutoFocusTask() {
        if (!this.mSafeAutoFocusTaskScheduled) {
            this.mSafeAutoFocusTaskScheduled = true;
            this.mMainThreadHandler.postDelayed(this.mSafeAutoFocusTask, this.mSafeAutoFocusInterval);
        }
    }

    private final class ScannerSizeListener implements CodeScannerView.SizeListener {
        private ScannerSizeListener() {
        }

        public void onSizeChanged(int i, int i2) {
            synchronized (CodeScanner.this.mInitializeLock) {
                if (!(i == CodeScanner.this.mViewWidth && i2 == CodeScanner.this.mViewHeight)) {
                    boolean access$1100 = CodeScanner.this.mPreviewActive;
                    if (CodeScanner.this.mInitialized) {
                        CodeScanner.this.releaseResources();
                    }
                    if (access$1100 || CodeScanner.this.mInitializationRequested) {
                        CodeScanner.this.initialize(i, i2);
                    }
                }
            }
        }
    }

    private final class PreviewCallback implements Camera.PreviewCallback {
        private PreviewCallback() {
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            DecoderWrapper access$1700;
            Rect frameRect;
            if (CodeScanner.this.mInitialized && !CodeScanner.this.mStoppingPreview && CodeScanner.this.mScanMode != ScanMode.PREVIEW && bArr != null && (access$1700 = CodeScanner.this.mDecoderWrapper) != null) {
                Decoder decoder = access$1700.getDecoder();
                if (decoder.getState() == Decoder.State.IDLE && (frameRect = CodeScanner.this.mScannerView.getFrameRect()) != null && frameRect.getWidth() >= 1 && frameRect.getHeight() >= 1) {
                    decoder.decode(new DecodeTask(bArr, access$1700.getImageSize(), access$1700.getPreviewSize(), access$1700.getViewSize(), frameRect, access$1700.getDisplayOrientation(), access$1700.shouldReverseHorizontal()));
                }
            }
        }
    }

    private final class SurfaceCallback implements SurfaceHolder.Callback {
        private SurfaceCallback() {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            CodeScanner.this.startPreviewInternalSafe();
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (surfaceHolder.getSurface() == null) {
                boolean unused = CodeScanner.this.mPreviewActive = false;
                return;
            }
            CodeScanner.this.stopPreviewInternalSafe();
            CodeScanner.this.startPreviewInternalSafe();
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CodeScanner.this.stopPreviewInternalSafe();
        }
    }

    private final class DecoderStateListener implements Decoder.StateListener {
        private DecoderStateListener() {
        }

        public boolean onStateChanged(Decoder.State state) {
            if (state == Decoder.State.DECODED) {
                ScanMode access$1600 = CodeScanner.this.mScanMode;
                if (access$1600 == ScanMode.PREVIEW) {
                    return false;
                }
                if (access$1600 == ScanMode.SINGLE) {
                    boolean unused = CodeScanner.this.mStoppingPreview = true;
                    CodeScanner.this.mMainThreadHandler.post(CodeScanner.this.mStopPreviewTask);
                }
            }
            return true;
        }
    }

    private final class InitializationThread extends Thread {
        private final int mHeight;
        private final int mWidth;

        public InitializationThread(int i, int i2) {
            super("cs-init");
            this.mWidth = i;
            this.mHeight = i2;
        }

        public void run() {
            Process.setThreadPriority(10);
            try {
                initialize();
            } catch (Exception e) {
                CodeScanner.this.releaseResourcesInternal();
                ErrorCallback access$2400 = CodeScanner.this.mErrorCallback;
                if (access$2400 != null) {
                    access$2400.onError(e);
                    return;
                }
                throw e;
            }
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x00ee  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00f0  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00f3  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0100  */
        private void initialize() {
            /*
                r20 = this;
                r1 = r20
                android.hardware.Camera$CameraInfo r4 = new android.hardware.Camera$CameraInfo
                r4.<init>()
                com.budiyev.android.codescanner.CodeScanner r0 = com.budiyev.android.codescanner.CodeScanner.this
                int r0 = r0.mCameraId
                r2 = -1
                r14 = 0
                if (r0 == r2) goto L_0x001e
                r3 = -2
                if (r0 != r3) goto L_0x0015
                goto L_0x001e
            L_0x0015:
                android.hardware.Camera r2 = android.hardware.Camera.open(r0)
                android.hardware.Camera.getCameraInfo(r0, r4)
                r3 = r2
                goto L_0x0040
            L_0x001e:
                int r3 = android.hardware.Camera.getNumberOfCameras()
                if (r0 != r2) goto L_0x0026
                r0 = 0
                goto L_0x0027
            L_0x0026:
                r0 = 1
            L_0x0027:
                r2 = 0
            L_0x0028:
                if (r2 >= r3) goto L_0x003e
                android.hardware.Camera.getCameraInfo(r2, r4)
                int r5 = r4.facing
                if (r5 != r0) goto L_0x003b
                android.hardware.Camera r0 = android.hardware.Camera.open(r2)
                com.budiyev.android.codescanner.CodeScanner r3 = com.budiyev.android.codescanner.CodeScanner.this
                int unused = r3.mCameraId = r2
                goto L_0x003f
            L_0x003b:
                int r2 = r2 + 1
                goto L_0x0028
            L_0x003e:
                r0 = 0
            L_0x003f:
                r3 = r0
            L_0x0040:
                if (r3 == 0) goto L_0x0174
                android.hardware.Camera$Parameters r0 = r3.getParameters()
                if (r0 == 0) goto L_0x016c
                com.budiyev.android.codescanner.CodeScanner r2 = com.budiyev.android.codescanner.CodeScanner.this
                android.content.Context r2 = r2.mContext
                int r15 = com.budiyev.android.codescanner.Utils.getDisplayOrientation(r2, r4)
                boolean r2 = com.budiyev.android.codescanner.Utils.isPortrait(r15)
                if (r2 == 0) goto L_0x005b
                int r5 = r1.mHeight
                goto L_0x005d
            L_0x005b:
                int r5 = r1.mWidth
            L_0x005d:
                if (r2 == 0) goto L_0x0062
                int r6 = r1.mWidth
                goto L_0x0064
            L_0x0062:
                int r6 = r1.mHeight
            L_0x0064:
                com.budiyev.android.codescanner.Point r16 = com.budiyev.android.codescanner.Utils.findSuitableImageSize(r0, r5, r6)
                int r9 = r16.getX()
                int r10 = r16.getY()
                r0.setPreviewSize(r9, r10)
                r5 = 17
                r0.setPreviewFormat(r5)
                if (r2 == 0) goto L_0x007c
                r5 = r10
                goto L_0x007d
            L_0x007c:
                r5 = r9
            L_0x007d:
                if (r2 == 0) goto L_0x0081
                r2 = r9
                goto L_0x0082
            L_0x0081:
                r2 = r10
            L_0x0082:
                int r6 = r1.mWidth
                int r7 = r1.mHeight
                com.budiyev.android.codescanner.Point r2 = com.budiyev.android.codescanner.Utils.getPreviewSize(r5, r2, r6, r7)
                java.util.List r5 = r0.getSupportedFocusModes()
                if (r5 == 0) goto L_0x00a3
                java.lang.String r6 = "auto"
                boolean r6 = r5.contains(r6)
                if (r6 != 0) goto L_0x00a0
                java.lang.String r6 = "continuous-picture"
                boolean r5 = r5.contains(r6)
                if (r5 == 0) goto L_0x00a3
            L_0x00a0:
                r17 = 1
                goto L_0x00a5
            L_0x00a3:
                r17 = 0
            L_0x00a5:
                if (r17 != 0) goto L_0x00ac
                com.budiyev.android.codescanner.CodeScanner r5 = com.budiyev.android.codescanner.CodeScanner.this
                boolean unused = r5.mAutoFocusEnabled = r14
            L_0x00ac:
                com.budiyev.android.codescanner.Point r11 = new com.budiyev.android.codescanner.Point
                int r5 = r1.mWidth
                int r6 = r1.mHeight
                r11.<init>(r5, r6)
                if (r17 == 0) goto L_0x00de
                com.budiyev.android.codescanner.CodeScanner r5 = com.budiyev.android.codescanner.CodeScanner.this
                boolean r5 = r5.mAutoFocusEnabled
                if (r5 == 0) goto L_0x00de
                com.budiyev.android.codescanner.CodeScanner r5 = com.budiyev.android.codescanner.CodeScanner.this
                com.budiyev.android.codescanner.AutoFocusMode r5 = r5.mAutoFocusMode
                com.budiyev.android.codescanner.Utils.setAutoFocusMode(r0, r5)
                com.budiyev.android.codescanner.CodeScanner r5 = com.budiyev.android.codescanner.CodeScanner.this
                com.budiyev.android.codescanner.CodeScannerView r5 = r5.mScannerView
                com.budiyev.android.codescanner.Rect r6 = r5.getFrameRect()
                if (r6 == 0) goto L_0x00de
                r5 = r0
                r7 = r2
                r8 = r11
                r18 = r11
                r11 = r15
                com.budiyev.android.codescanner.Utils.configureDefaultFocusArea(r5, r6, r7, r8, r9, r10, r11)
                goto L_0x00e0
            L_0x00de:
                r18 = r11
            L_0x00e0:
                java.util.List r5 = r0.getSupportedFlashModes()
                if (r5 == 0) goto L_0x00f0
                java.lang.String r6 = "torch"
                boolean r5 = r5.contains(r6)
                if (r5 == 0) goto L_0x00f0
                r11 = 1
                goto L_0x00f1
            L_0x00f0:
                r11 = 0
            L_0x00f1:
                if (r11 != 0) goto L_0x00f8
                com.budiyev.android.codescanner.CodeScanner r5 = com.budiyev.android.codescanner.CodeScanner.this
                boolean unused = r5.mFlashEnabled = r14
            L_0x00f8:
                com.budiyev.android.codescanner.CodeScanner r5 = com.budiyev.android.codescanner.CodeScanner.this
                int r5 = r5.mZoom
                if (r5 == 0) goto L_0x0103
                com.budiyev.android.codescanner.Utils.setZoom(r0, r5)
            L_0x0103:
                com.budiyev.android.codescanner.Utils.configureFpsRange(r0)
                com.budiyev.android.codescanner.Utils.configureSceneMode(r0)
                com.budiyev.android.codescanner.Utils.configureVideoStabilization(r0)
                r3.setParameters(r0)
                r3.setDisplayOrientation(r15)
                com.budiyev.android.codescanner.CodeScanner r0 = com.budiyev.android.codescanner.CodeScanner.this
                java.lang.Object r19 = r0.mInitializeLock
                monitor-enter(r19)
                com.budiyev.android.codescanner.Decoder r0 = new com.budiyev.android.codescanner.Decoder     // Catch:{ all -> 0x0169 }
                com.budiyev.android.codescanner.CodeScanner r5 = com.budiyev.android.codescanner.CodeScanner.this     // Catch:{ all -> 0x0169 }
                com.budiyev.android.codescanner.CodeScanner$DecoderStateListener r5 = r5.mDecoderStateListener     // Catch:{ all -> 0x0169 }
                com.budiyev.android.codescanner.CodeScanner r6 = com.budiyev.android.codescanner.CodeScanner.this     // Catch:{ all -> 0x0169 }
                java.util.List r6 = r6.mFormats     // Catch:{ all -> 0x0169 }
                com.budiyev.android.codescanner.CodeScanner r7 = com.budiyev.android.codescanner.CodeScanner.this     // Catch:{ all -> 0x0169 }
                com.budiyev.android.codescanner.DecodeCallback r7 = r7.mDecodeCallback     // Catch:{ all -> 0x0169 }
                r0.<init>(r5, r6, r7)     // Catch:{ all -> 0x0169 }
                com.budiyev.android.codescanner.CodeScanner r10 = com.budiyev.android.codescanner.CodeScanner.this     // Catch:{ all -> 0x0169 }
                com.budiyev.android.codescanner.DecoderWrapper r9 = new com.budiyev.android.codescanner.DecoderWrapper     // Catch:{ all -> 0x0169 }
                r8 = r2
                r2 = r9
                r5 = r0
                r6 = r16
                r7 = r8
                r12 = r8
                r8 = r18
                r13 = r9
                r9 = r15
                r15 = r10
                r10 = r17
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0169 }
                com.budiyev.android.codescanner.DecoderWrapper unused = r15.mDecoderWrapper = r13     // Catch:{ all -> 0x0169 }
                r0.start()     // Catch:{ all -> 0x0169 }
                com.budiyev.android.codescanner.CodeScanner r0 = com.budiyev.android.codescanner.CodeScanner.this     // Catch:{ all -> 0x0169 }
                boolean unused = r0.mInitialization = r14     // Catch:{ all -> 0x0169 }
                com.budiyev.android.codescanner.CodeScanner r0 = com.budiyev.android.codescanner.CodeScanner.this     // Catch:{ all -> 0x0169 }
                r2 = 1
                boolean unused = r0.mInitialized = r2     // Catch:{ all -> 0x0169 }
                monitor-exit(r19)     // Catch:{ all -> 0x0169 }
                com.budiyev.android.codescanner.CodeScanner r0 = com.budiyev.android.codescanner.CodeScanner.this
                android.os.Handler r0 = r0.mMainThreadHandler
                com.budiyev.android.codescanner.CodeScanner$FinishInitializationTask r2 = new com.budiyev.android.codescanner.CodeScanner$FinishInitializationTask
                com.budiyev.android.codescanner.CodeScanner r3 = com.budiyev.android.codescanner.CodeScanner.this
                r4 = 0
                r2.<init>(r12)
                r0.post(r2)
                return
            L_0x0169:
                r0 = move-exception
                monitor-exit(r19)     // Catch:{ all -> 0x0169 }
                throw r0
            L_0x016c:
                com.budiyev.android.codescanner.CodeScannerException r0 = new com.budiyev.android.codescanner.CodeScannerException
                java.lang.String r2 = "Unable to configure camera"
                r0.<init>((java.lang.String) r2)
                throw r0
            L_0x0174:
                com.budiyev.android.codescanner.CodeScannerException r0 = new com.budiyev.android.codescanner.CodeScannerException
                java.lang.String r2 = "Unable to access camera"
                r0.<init>((java.lang.String) r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.budiyev.android.codescanner.CodeScanner.InitializationThread.initialize():void");
        }
    }

    private final class TouchFocusCallback implements Camera.AutoFocusCallback {
        private TouchFocusCallback() {
        }

        public void onAutoFocus(boolean z, Camera camera) {
            boolean unused = CodeScanner.this.mTouchFocusing = false;
        }
    }

    private final class SafeAutoFocusCallback implements Camera.AutoFocusCallback {
        private SafeAutoFocusCallback() {
        }

        public void onAutoFocus(boolean z, Camera camera) {
            boolean unused = CodeScanner.this.mSafeAutoFocusing = false;
        }
    }

    private final class SafeAutoFocusTask implements Runnable {
        private SafeAutoFocusTask() {
        }

        public void run() {
            boolean unused = CodeScanner.this.mSafeAutoFocusTaskScheduled = false;
            if (CodeScanner.this.mAutoFocusMode == AutoFocusMode.SAFE) {
                CodeScanner.this.safeAutoFocusCamera();
            }
        }
    }

    private final class StopPreviewTask implements Runnable {
        private StopPreviewTask() {
        }

        public void run() {
            CodeScanner.this.stopPreview();
        }
    }

    private final class FinishInitializationTask implements Runnable {
        private final Point mPreviewSize;

        private FinishInitializationTask(Point point) {
            this.mPreviewSize = point;
        }

        public void run() {
            if (CodeScanner.this.mInitialized) {
                CodeScanner.this.mScannerView.setPreviewSize(this.mPreviewSize);
                CodeScanner.this.mScannerView.setAutoFocusEnabled(CodeScanner.this.isAutoFocusEnabled());
                CodeScanner.this.mScannerView.setFlashEnabled(CodeScanner.this.isFlashEnabled());
                CodeScanner.this.startPreview();
            }
        }
    }
}
