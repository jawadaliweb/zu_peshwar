package com.budiyev.android.codescanner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public final class CodeScannerView extends ViewGroup {
    private static final float BUTTON_SIZE_DP = 56.0f;
    private static final int DEFAULT_AUTO_FOCUS_BUTTON_COLOR = -1;
    private static final int DEFAULT_AUTO_FOCUS_BUTTON_VISIBILITY = 0;
    private static final boolean DEFAULT_AUTO_FOCUS_BUTTON_VISIBLE = true;
    private static final int DEFAULT_FLASH_BUTTON_COLOR = -1;
    private static final int DEFAULT_FLASH_BUTTON_VISIBILITY = 0;
    private static final boolean DEFAULT_FLASH_BUTTON_VISIBLE = true;
    private static final float DEFAULT_FRAME_ASPECT_RATIO_HEIGHT = 1.0f;
    private static final float DEFAULT_FRAME_ASPECT_RATIO_WIDTH = 1.0f;
    private static final int DEFAULT_FRAME_COLOR = -1;
    private static final float DEFAULT_FRAME_CORNERS_RADIUS_DP = 0.0f;
    private static final float DEFAULT_FRAME_CORNER_SIZE_DP = 50.0f;
    private static final float DEFAULT_FRAME_SIZE = 0.75f;
    private static final float DEFAULT_FRAME_THICKNESS_DP = 2.0f;
    private static final int DEFAULT_MASK_COLOR = 1996488704;
    private static final float FOCUS_AREA_SIZE_DP = 20.0f;
    private ImageView mAutoFocusButton;
    private int mAutoFocusButtonColor;
    private int mButtonSize;
    /* access modifiers changed from: private */
    public CodeScanner mCodeScanner;
    private ImageView mFlashButton;
    private int mFlashButtonColor;
    private int mFocusAreaSize;
    private Point mPreviewSize;
    private SurfaceView mPreviewView;
    private SizeListener mSizeListener;
    private ViewFinderView mViewFinderView;

    interface SizeListener {
        void onSizeChanged(int i, int i2);
    }

    public CodeScannerView(Context context) {
        super(context);
        initialize(context, (AttributeSet) null, 0, 0);
    }

    public CodeScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context, attributeSet, 0, 0);
    }

    public CodeScannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context, attributeSet, i, 0);
    }

    public CodeScannerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initialize(context, attributeSet, i, i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: android.content.res.TypedArray} */
    /* JADX WARNING: type inference failed for: r4v1, types: [com.budiyev.android.codescanner.CodeScannerView$1] */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initialize(android.content.Context r11, android.util.AttributeSet r12, int r13, int r14) {
        /*
            r10 = this;
            android.view.SurfaceView r0 = new android.view.SurfaceView
            r0.<init>(r11)
            r10.mPreviewView = r0
            android.view.ViewGroup$LayoutParams r1 = new android.view.ViewGroup$LayoutParams
            r2 = -1
            r1.<init>(r2, r2)
            r0.setLayoutParams(r1)
            com.budiyev.android.codescanner.ViewFinderView r0 = new com.budiyev.android.codescanner.ViewFinderView
            r0.<init>(r11)
            r10.mViewFinderView = r0
            android.view.ViewGroup$LayoutParams r1 = new android.view.ViewGroup$LayoutParams
            r1.<init>(r2, r2)
            r0.setLayoutParams(r1)
            android.content.res.Resources r0 = r11.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            r1 = 1113587712(0x42600000, float:56.0)
            float r1 = r1 * r0
            int r1 = java.lang.Math.round(r1)
            r10.mButtonSize = r1
            r1 = 1101004800(0x41a00000, float:20.0)
            float r1 = r1 * r0
            int r1 = java.lang.Math.round(r1)
            r10.mFocusAreaSize = r1
            android.widget.ImageView r1 = new android.widget.ImageView
            r1.<init>(r11)
            r10.mAutoFocusButton = r1
            android.view.ViewGroup$LayoutParams r3 = new android.view.ViewGroup$LayoutParams
            int r4 = r10.mButtonSize
            r3.<init>(r4, r4)
            r1.setLayoutParams(r3)
            android.widget.ImageView r1 = r10.mAutoFocusButton
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.CENTER
            r1.setScaleType(r3)
            android.widget.ImageView r1 = r10.mAutoFocusButton
            int r3 = com.budiyev.android.codescanner.R.drawable.ic_code_scanner_auto_focus_on
            r1.setImageResource(r3)
            android.widget.ImageView r1 = r10.mAutoFocusButton
            com.budiyev.android.codescanner.CodeScannerView$AutoFocusClickListener r3 = new com.budiyev.android.codescanner.CodeScannerView$AutoFocusClickListener
            r4 = 0
            r3.<init>()
            r1.setOnClickListener(r3)
            android.widget.ImageView r1 = new android.widget.ImageView
            r1.<init>(r11)
            r10.mFlashButton = r1
            android.view.ViewGroup$LayoutParams r3 = new android.view.ViewGroup$LayoutParams
            int r5 = r10.mButtonSize
            r3.<init>(r5, r5)
            r1.setLayoutParams(r3)
            android.widget.ImageView r1 = r10.mFlashButton
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.CENTER
            r1.setScaleType(r3)
            android.widget.ImageView r1 = r10.mFlashButton
            int r3 = com.budiyev.android.codescanner.R.drawable.ic_code_scanner_flash_on
            r1.setImageResource(r3)
            android.widget.ImageView r1 = r10.mFlashButton
            com.budiyev.android.codescanner.CodeScannerView$FlashClickListener r3 = new com.budiyev.android.codescanner.CodeScannerView$FlashClickListener
            r3.<init>()
            r1.setOnClickListener(r3)
            r1 = 1061158912(0x3f400000, float:0.75)
            r3 = 0
            r5 = 1112014848(0x42480000, float:50.0)
            r6 = 1073741824(0x40000000, float:2.0)
            r7 = 1996488704(0x77000000, float:2.5961484E33)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r12 != 0) goto L_0x00e9
            com.budiyev.android.codescanner.ViewFinderView r11 = r10.mViewFinderView
            r11.setFrameAspectRatio(r8, r8)
            com.budiyev.android.codescanner.ViewFinderView r11 = r10.mViewFinderView
            r11.setMaskColor(r7)
            com.budiyev.android.codescanner.ViewFinderView r11 = r10.mViewFinderView
            r11.setFrameColor(r2)
            com.budiyev.android.codescanner.ViewFinderView r11 = r10.mViewFinderView
            float r6 = r6 * r0
            int r12 = java.lang.Math.round(r6)
            r11.setFrameThickness(r12)
            com.budiyev.android.codescanner.ViewFinderView r11 = r10.mViewFinderView
            float r5 = r5 * r0
            int r12 = java.lang.Math.round(r5)
            r11.setFrameCornersSize(r12)
            com.budiyev.android.codescanner.ViewFinderView r11 = r10.mViewFinderView
            float r0 = r0 * r3
            int r12 = java.lang.Math.round(r0)
            r11.setFrameCornersRadius(r12)
            com.budiyev.android.codescanner.ViewFinderView r11 = r10.mViewFinderView
            r11.setFrameSize(r1)
            android.widget.ImageView r11 = r10.mAutoFocusButton
            r11.setColorFilter(r2)
            android.widget.ImageView r11 = r10.mFlashButton
            r11.setColorFilter(r2)
            android.widget.ImageView r11 = r10.mAutoFocusButton
            r12 = 0
            r11.setVisibility(r12)
            android.widget.ImageView r11 = r10.mFlashButton
            r11.setVisibility(r12)
            goto L_0x0174
        L_0x00e9:
            android.content.res.Resources$Theme r11 = r11.getTheme()     // Catch:{ all -> 0x0189 }
            int[] r9 = com.budiyev.android.codescanner.R.styleable.CodeScannerView     // Catch:{ all -> 0x0189 }
            android.content.res.TypedArray r4 = r11.obtainStyledAttributes(r12, r9, r13, r14)     // Catch:{ all -> 0x0189 }
            int r11 = com.budiyev.android.codescanner.R.styleable.CodeScannerView_maskColor     // Catch:{ all -> 0x0189 }
            int r11 = r4.getColor(r11, r7)     // Catch:{ all -> 0x0189 }
            r10.setMaskColor(r11)     // Catch:{ all -> 0x0189 }
            int r11 = com.budiyev.android.codescanner.R.styleable.CodeScannerView_frameColor     // Catch:{ all -> 0x0189 }
            int r11 = r4.getColor(r11, r2)     // Catch:{ all -> 0x0189 }
            r10.setFrameColor(r11)     // Catch:{ all -> 0x0189 }
            int r11 = com.budiyev.android.codescanner.R.styleable.CodeScannerView_frameThickness     // Catch:{ all -> 0x0189 }
            float r6 = r6 * r0
            int r12 = java.lang.Math.round(r6)     // Catch:{ all -> 0x0189 }
            int r11 = r4.getDimensionPixelOffset(r11, r12)     // Catch:{ all -> 0x0189 }
            r10.setFrameThickness(r11)     // Catch:{ all -> 0x0189 }
            int r11 = com.budiyev.android.codescanner.R.styleable.CodeScannerView_frameCornersSize     // Catch:{ all -> 0x0189 }
            float r5 = r5 * r0
            int r12 = java.lang.Math.round(r5)     // Catch:{ all -> 0x0189 }
            int r11 = r4.getDimensionPixelOffset(r11, r12)     // Catch:{ all -> 0x0189 }
            r10.setFrameCornersSize(r11)     // Catch:{ all -> 0x0189 }
            int r11 = com.budiyev.android.codescanner.R.styleable.CodeScannerView_frameCornersRadius     // Catch:{ all -> 0x0189 }
            float r0 = r0 * r3
            int r12 = java.lang.Math.round(r0)     // Catch:{ all -> 0x0189 }
            int r11 = r4.getDimensionPixelOffset(r11, r12)     // Catch:{ all -> 0x0189 }
            r10.setFrameCornersRadius(r11)     // Catch:{ all -> 0x0189 }
            int r11 = com.budiyev.android.codescanner.R.styleable.CodeScannerView_frameAspectRatioWidth     // Catch:{ all -> 0x0189 }
            float r11 = r4.getFloat(r11, r8)     // Catch:{ all -> 0x0189 }
            int r12 = com.budiyev.android.codescanner.R.styleable.CodeScannerView_frameAspectRatioHeight     // Catch:{ all -> 0x0189 }
            float r12 = r4.getFloat(r12, r8)     // Catch:{ all -> 0x0189 }
            r10.setFrameAspectRatio(r11, r12)     // Catch:{ all -> 0x0189 }
            int r11 = com.budiyev.android.codescanner.R.styleable.CodeScannerView_frameSize     // Catch:{ all -> 0x0189 }
            float r11 = r4.getFloat(r11, r1)     // Catch:{ all -> 0x0189 }
            r10.setFrameSize(r11)     // Catch:{ all -> 0x0189 }
            int r11 = com.budiyev.android.codescanner.R.styleable.CodeScannerView_autoFocusButtonVisible     // Catch:{ all -> 0x0189 }
            r12 = 1
            boolean r11 = r4.getBoolean(r11, r12)     // Catch:{ all -> 0x0189 }
            r10.setAutoFocusButtonVisible(r11)     // Catch:{ all -> 0x0189 }
            int r11 = com.budiyev.android.codescanner.R.styleable.CodeScannerView_flashButtonVisible     // Catch:{ all -> 0x0189 }
            boolean r11 = r4.getBoolean(r11, r12)     // Catch:{ all -> 0x0189 }
            r10.setFlashButtonVisible(r11)     // Catch:{ all -> 0x0189 }
            int r11 = com.budiyev.android.codescanner.R.styleable.CodeScannerView_autoFocusButtonColor     // Catch:{ all -> 0x0189 }
            int r11 = r4.getColor(r11, r2)     // Catch:{ all -> 0x0189 }
            r10.setAutoFocusButtonColor(r11)     // Catch:{ all -> 0x0189 }
            int r11 = com.budiyev.android.codescanner.R.styleable.CodeScannerView_flashButtonColor     // Catch:{ all -> 0x0189 }
            int r11 = r4.getColor(r11, r2)     // Catch:{ all -> 0x0189 }
            r10.setFlashButtonColor(r11)     // Catch:{ all -> 0x0189 }
            if (r4 == 0) goto L_0x0174
            r4.recycle()
        L_0x0174:
            android.view.SurfaceView r11 = r10.mPreviewView
            r10.addView(r11)
            com.budiyev.android.codescanner.ViewFinderView r11 = r10.mViewFinderView
            r10.addView(r11)
            android.widget.ImageView r11 = r10.mAutoFocusButton
            r10.addView(r11)
            android.widget.ImageView r11 = r10.mFlashButton
            r10.addView(r11)
            return
        L_0x0189:
            r11 = move-exception
            if (r4 == 0) goto L_0x018f
            r4.recycle()
        L_0x018f:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.budiyev.android.codescanner.CodeScannerView.initialize(android.content.Context, android.util.AttributeSet, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        performLayout(i3 - i, i4 - i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        performLayout(i, i2);
        SizeListener sizeListener = this.mSizeListener;
        if (sizeListener != null) {
            sizeListener.onSizeChanged(i, i2);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        CodeScanner codeScanner = this.mCodeScanner;
        Rect frameRect = getFrameRect();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (codeScanner != null && frameRect != null && codeScanner.isAutoFocusSupportedOrUnknown() && codeScanner.isTouchFocusEnabled() && motionEvent.getAction() == 0 && frameRect.isPointInside(x, y)) {
            int i = this.mFocusAreaSize;
            codeScanner.performTouchFocus(new Rect(x - i, y - i, x + i, y + i).fitIn(frameRect));
        }
        return super.onTouchEvent(motionEvent);
    }

    public int getMaskColor() {
        return this.mViewFinderView.getMaskColor();
    }

    public void setMaskColor(int i) {
        this.mViewFinderView.setMaskColor(i);
    }

    public int getFrameColor() {
        return this.mViewFinderView.getFrameColor();
    }

    public void setFrameColor(int i) {
        this.mViewFinderView.setFrameColor(i);
    }

    public int getFrameThickness() {
        return this.mViewFinderView.getFrameThickness();
    }

    public void setFrameThickness(int i) {
        if (i >= 0) {
            this.mViewFinderView.setFrameThickness(i);
            return;
        }
        throw new IllegalArgumentException("Frame thickness can't be negative");
    }

    public int getFrameCornersSize() {
        return this.mViewFinderView.getFrameCornersSize();
    }

    public void setFrameCornersSize(int i) {
        if (i >= 0) {
            this.mViewFinderView.setFrameCornersSize(i);
            return;
        }
        throw new IllegalArgumentException("Frame corners size can't be negative");
    }

    public int getFrameCornersRadius() {
        return this.mViewFinderView.getFrameCornersRadius();
    }

    public void setFrameCornersRadius(int i) {
        if (i >= 0) {
            this.mViewFinderView.setFrameCornersRadius(i);
            return;
        }
        throw new IllegalArgumentException("Frame corners radius can't be negative");
    }

    public float getFrameSize() {
        return this.mViewFinderView.getFrameSize();
    }

    public void setFrameSize(float f) {
        if (((double) f) < 0.1d || f > 1.0f) {
            throw new IllegalArgumentException("Max frame size value should be between 0.1 and 1, inclusive");
        }
        this.mViewFinderView.setFrameSize(f);
    }

    public float getFrameAspectRatioWidth() {
        return this.mViewFinderView.getFrameAspectRatioWidth();
    }

    public void setFrameAspectRatioWidth(float f) {
        if (f > 0.0f) {
            this.mViewFinderView.setFrameAspectRatioWidth(f);
            return;
        }
        throw new IllegalArgumentException("Frame aspect ratio values should be greater than zero");
    }

    public float getFrameAspectRatioHeight() {
        return this.mViewFinderView.getFrameAspectRatioHeight();
    }

    public void setFrameAspectRatioHeight(float f) {
        if (f > 0.0f) {
            this.mViewFinderView.setFrameAspectRatioHeight(f);
            return;
        }
        throw new IllegalArgumentException("Frame aspect ratio values should be greater than zero");
    }

    public void setFrameAspectRatio(float f, float f2) {
        if (f <= 0.0f || f2 <= 0.0f) {
            throw new IllegalArgumentException("Frame aspect ratio values should be greater than zero");
        }
        this.mViewFinderView.setFrameAspectRatio(f, f2);
    }

    public boolean isAutoFocusButtonVisible() {
        return this.mAutoFocusButton.getVisibility() == 0;
    }

    public void setAutoFocusButtonVisible(boolean z) {
        this.mAutoFocusButton.setVisibility(z ? 0 : 4);
    }

    public boolean isFlashButtonVisible() {
        return this.mFlashButton.getVisibility() == 0;
    }

    public void setFlashButtonVisible(boolean z) {
        this.mFlashButton.setVisibility(z ? 0 : 4);
    }

    public int getAutoFocusButtonColor() {
        return this.mAutoFocusButtonColor;
    }

    public void setAutoFocusButtonColor(int i) {
        this.mAutoFocusButtonColor = i;
        this.mAutoFocusButton.setColorFilter(i);
    }

    public int getFlashButtonColor() {
        return this.mFlashButtonColor;
    }

    public void setFlashButtonColor(int i) {
        this.mFlashButtonColor = i;
        this.mFlashButton.setColorFilter(i);
    }

    /* access modifiers changed from: package-private */
    public SurfaceView getPreviewView() {
        return this.mPreviewView;
    }

    /* access modifiers changed from: package-private */
    public ViewFinderView getViewFinderView() {
        return this.mViewFinderView;
    }

    /* access modifiers changed from: package-private */
    public Rect getFrameRect() {
        return this.mViewFinderView.getFrameRect();
    }

    /* access modifiers changed from: package-private */
    public void setPreviewSize(Point point) {
        this.mPreviewSize = point;
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void setSizeListener(SizeListener sizeListener) {
        this.mSizeListener = sizeListener;
    }

    /* access modifiers changed from: package-private */
    public void setCodeScanner(CodeScanner codeScanner) {
        if (this.mCodeScanner == null) {
            this.mCodeScanner = codeScanner;
            setAutoFocusEnabled(codeScanner.isAutoFocusEnabled());
            setFlashEnabled(codeScanner.isFlashEnabled());
            return;
        }
        throw new IllegalStateException("Code scanner has already been set");
    }

    /* access modifiers changed from: package-private */
    public void setAutoFocusEnabled(boolean z) {
        this.mAutoFocusButton.setImageResource(z ? R.drawable.ic_code_scanner_auto_focus_on : R.drawable.ic_code_scanner_auto_focus_off);
    }

    /* access modifiers changed from: package-private */
    public void setFlashEnabled(boolean z) {
        this.mFlashButton.setImageResource(z ? R.drawable.ic_code_scanner_flash_on : R.drawable.ic_code_scanner_flash_off);
    }

    private void performLayout(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        Point point = this.mPreviewSize;
        if (point == null) {
            this.mPreviewView.layout(0, 0, i, i2);
        } else {
            int x = point.getX();
            if (x > i) {
                int i7 = (x - i) / 2;
                i3 = 0 - i7;
                i4 = i7 + i;
            } else {
                i4 = i;
                i3 = 0;
            }
            int y = point.getY();
            if (y > i2) {
                int i8 = (y - i2) / 2;
                i5 = 0 - i8;
                i6 = i8 + i2;
            } else {
                i6 = i2;
                i5 = 0;
            }
            this.mPreviewView.layout(i3, i5, i4, i6);
        }
        this.mViewFinderView.layout(0, 0, i, i2);
        int i9 = this.mButtonSize;
        this.mAutoFocusButton.layout(0, 0, i9, i9);
        this.mFlashButton.layout(i - i9, 0, i, i9);
    }

    private final class AutoFocusClickListener implements View.OnClickListener {
        private AutoFocusClickListener() {
        }

        public void onClick(View view) {
            CodeScanner access$200 = CodeScannerView.this.mCodeScanner;
            if (access$200 != null && access$200.isAutoFocusSupportedOrUnknown()) {
                boolean z = !access$200.isAutoFocusEnabled();
                access$200.setAutoFocusEnabled(z);
                CodeScannerView.this.setAutoFocusEnabled(z);
            }
        }
    }

    private final class FlashClickListener implements View.OnClickListener {
        private FlashClickListener() {
        }

        public void onClick(View view) {
            CodeScanner access$200 = CodeScannerView.this.mCodeScanner;
            if (access$200 != null && access$200.isFlashSupportedOrUnknown()) {
                boolean z = !access$200.isFlashEnabled();
                access$200.setFlashEnabled(z);
                CodeScannerView.this.setFlashEnabled(z);
            }
        }
    }
}
