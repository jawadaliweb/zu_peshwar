package com.ortiz.touchview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 Ç\u00012\u00020\u0001:\u0010Æ\u0001Ç\u0001È\u0001É\u0001Ê\u0001Ë\u0001Ì\u0001Í\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010b\u001a\u00020!2\u0006\u0010c\u001a\u00020\u0007H\u0016J\u0010\u0010d\u001a\u00020!2\u0006\u0010c\u001a\u00020\u0007H\u0007J\u0010\u0010e\u001a\u00020!2\u0006\u0010c\u001a\u00020\u0007H\u0016J\u0010\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020iH\u0002J\b\u0010j\u001a\u00020gH\u0002J\b\u0010k\u001a\u00020gH\u0002J\b\u0010l\u001a\u00020gH\u0002J\u0012\u0010m\u001a\u00020\u00072\b\u0010n\u001a\u0004\u0018\u00010oH\u0002J\u0012\u0010p\u001a\u00020\u00072\b\u0010n\u001a\u0004\u0018\u00010oH\u0002J \u0010q\u001a\u00020\n2\u0006\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\nH\u0002J(\u0010u\u001a\u00020\n2\u0006\u0010v\u001a\u00020\n2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\n2\u0006\u0010w\u001a\u00020\nH\u0002J\b\u0010x\u001a\u00020UH\u0016JB\u0010y\u001a\u00020\n2\u0006\u0010v\u001a\u00020\n2\u0006\u0010z\u001a\u00020\n2\u0006\u0010{\u001a\u00020\n2\u0006\u0010|\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u00072\u0006\u0010}\u001a\u00020\u00072\b\u0010~\u001a\u0004\u0018\u00010;H\u0002J\u0012\u0010\u001a\u00020g2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020g2\b\u0010\u0001\u001a\u00030\u0001H\u0014J\u001b\u0010\u0001\u001a\u00020g2\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0014J\u0013\u0010\u0001\u001a\u00020g2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J-\u0010\u0001\u001a\u00020g2\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0014J\u0013\u0010\u0001\u001a\u00020!2\b\u0010n\u001a\u0004\u0018\u00010oH\u0002J\u0007\u0010\u0001\u001a\u00020gJ\u0007\u0010\u0001\u001a\u00020gJ\u0007\u0010\u0001\u001a\u00020gJ.\u0010\u0001\u001a\u00020g2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020!H\u0002J\u0015\u0010\u0001\u001a\u00020g2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020g2\b\u0010n\u001a\u0004\u0018\u00010oH\u0016J\u0012\u0010\u0001\u001a\u00020g2\u0007\u0010 \u0001\u001a\u00020\u0007H\u0016J\u0015\u0010¡\u0001\u001a\u00020g2\n\u0010¢\u0001\u001a\u0005\u0018\u00010£\u0001H\u0016J\u000f\u0010¤\u0001\u001a\u00020g2\u0006\u0010/\u001a\u00020\nJ\u0010\u0010¥\u0001\u001a\u00020g2\u0007\u0010¦\u0001\u001a\u00020\u0011J\u0010\u0010§\u0001\u001a\u00020g2\u0007\u0010¨\u0001\u001a\u00020PJ\u0010\u0010©\u0001\u001a\u00020g2\u0007\u0010ª\u0001\u001a\u00020RJ\u0014\u0010«\u0001\u001a\u00020g2\t\u0010¬\u0001\u001a\u0004\u0018\u00010XH\u0016J\u0010\u0010­\u0001\u001a\u00020g2\u0007\u0010®\u0001\u001a\u00020!J\u0012\u0010¯\u0001\u001a\u00020g2\u0007\u0010°\u0001\u001a\u00020UH\u0016J\u0019\u0010±\u0001\u001a\u00020g2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nJ\u0011\u0010²\u0001\u001a\u00020g2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J$\u0010³\u0001\u001a\u00020\u00072\u0007\u0010´\u0001\u001a\u00020\u00072\u0007\u0010µ\u0001\u001a\u00020\u00072\u0007\u0010¶\u0001\u001a\u00020\u0007H\u0002J\u0010\u0010·\u0001\u001a\u00020g2\u0007\u0010¸\u0001\u001a\u00020\u0000J\u0010\u0010·\u0001\u001a\u00020g2\u0007\u0010¹\u0001\u001a\u00020\nJ\"\u0010·\u0001\u001a\u00020g2\u0007\u0010¹\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nJ-\u0010·\u0001\u001a\u00020g2\u0007\u0010¹\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\t\u0010º\u0001\u001a\u0004\u0018\u00010UJ\"\u0010»\u0001\u001a\u00020g2\u0007\u0010¹\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nJ.\u0010»\u0001\u001a\u00020g2\u0007\u0010¹\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001J+\u0010»\u0001\u001a\u00020g2\u0007\u0010¹\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010¾\u0001\u001a\u00020\u0007J7\u0010»\u0001\u001a\u00020g2\u0007\u0010¹\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010¾\u0001\u001a\u00020\u00072\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001J\u001b\u0010¿\u0001\u001a\u00020J2\u0007\u0010À\u0001\u001a\u00020\n2\u0007\u0010Á\u0001\u001a\u00020\nH\u0004J$\u0010Â\u0001\u001a\u00020J2\u0007\u0010Ã\u0001\u001a\u00020\n2\u0007\u0010Ä\u0001\u001a\u00020\n2\u0007\u0010Å\u0001\u001a\u00020!H\u0004R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0018\u00010\u0017R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\rR\u000e\u0010$\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b)\u0010&R\u000e\u0010*\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R$\u00100\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u0015R\u000e\u00103\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R$\u00105\u001a\u00020\n2\u0006\u00104\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u0015R\u000e\u00108\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010I\u001a\u00020J8F¢\u0006\u0006\u001a\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020DX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010Z\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010=\"\u0004\b\\\u0010?R\u000e\u0010]\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010^\u001a\u00020_8F¢\u0006\u0006\u001a\u0004\b`\u0010a¨\u0006Î\u0001"}, d2 = {"Lcom/ortiz/touchview/TouchImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "currentZoom", "getCurrentZoom", "()F", "delayedZoomVariables", "Lcom/ortiz/touchview/ZoomVariables;", "doubleTapListener", "Landroid/view/GestureDetector$OnDoubleTapListener;", "doubleTapScale", "getDoubleTapScale", "setDoubleTapScale", "(F)V", "fling", "Lcom/ortiz/touchview/TouchImageView$Fling;", "floatMatrix", "", "gestureDetector", "Landroid/view/GestureDetector;", "imageActionState", "Lcom/ortiz/touchview/ImageActionState;", "imageHeight", "getImageHeight", "imageRenderedAtLeastOnce", "", "imageWidth", "getImageWidth", "isRotateImageToFitScreen", "isZoomEnabled", "()Z", "setZoomEnabled", "(Z)V", "isZoomed", "matchViewHeight", "matchViewWidth", "maxScale", "maxScaleIsSetByMultiplier", "maxScaleMultiplier", "max", "maxZoom", "getMaxZoom", "setMaxZoom", "minScale", "min", "minZoom", "getMinZoom", "setMinZoom", "onDrawReady", "orientation", "orientationChangeFixedPixel", "Lcom/ortiz/touchview/FixedPixel;", "getOrientationChangeFixedPixel", "()Lcom/ortiz/touchview/FixedPixel;", "setOrientationChangeFixedPixel", "(Lcom/ortiz/touchview/FixedPixel;)V", "orientationJustChanged", "prevMatchViewHeight", "prevMatchViewWidth", "prevMatrix", "Landroid/graphics/Matrix;", "prevViewHeight", "prevViewWidth", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "scrollPosition", "Landroid/graphics/PointF;", "getScrollPosition", "()Landroid/graphics/PointF;", "superMaxScale", "superMinScale", "touchCoordinatesListener", "Lcom/ortiz/touchview/OnTouchCoordinatesListener;", "touchImageViewListener", "Lcom/ortiz/touchview/OnTouchImageViewListener;", "touchMatrix", "touchScaleType", "Landroid/widget/ImageView$ScaleType;", "userSpecifiedMinScale", "userTouchListener", "Landroid/view/View$OnTouchListener;", "viewHeight", "viewSizeChangeFixedPixel", "getViewSizeChangeFixedPixel", "setViewSizeChangeFixedPixel", "viewWidth", "zoomedRect", "Landroid/graphics/RectF;", "getZoomedRect", "()Landroid/graphics/RectF;", "canScrollHorizontally", "direction", "canScrollHorizontallyFroyo", "canScrollVertically", "compatPostOnAnimation", "", "runnable", "Ljava/lang/Runnable;", "fitImageToView", "fixScaleTrans", "fixTrans", "getDrawableHeight", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawableWidth", "getFixDragTrans", "delta", "viewSize", "contentSize", "getFixTrans", "trans", "offset", "getScaleType", "newTranslationAfterChange", "prevImageSize", "imageSize", "prevViewSize", "drawableSize", "sizeChangeFixedPixel", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "onSizeChanged", "w", "h", "oldw", "oldh", "orientationMismatch", "resetZoom", "resetZoomAnimated", "savePreviousImageValues", "scaleImage", "deltaScale", "", "focusX", "focusY", "stretchImageToSuper", "setImageBitmap", "bm", "Landroid/graphics/Bitmap;", "setImageDrawable", "setImageResource", "resId", "setImageURI", "uri", "Landroid/net/Uri;", "setMaxZoomRatio", "setOnDoubleTapListener", "onDoubleTapListener", "setOnTouchCoordinatesListener", "onTouchCoordinatesListener", "setOnTouchImageViewListener", "onTouchImageViewListener", "setOnTouchListener", "onTouchListener", "setRotateImageToFitScreen", "rotateImageToFitScreen", "setScaleType", "type", "setScrollPosition", "setState", "setViewSize", "mode", "size", "drawableWidth", "setZoom", "imageSource", "scale", "scaleType", "setZoomAnimated", "listener", "Lcom/ortiz/touchview/OnZoomFinishedListener;", "zoomTimeMs", "transformCoordBitmapToTouch", "bx", "by", "transformCoordTouchToBitmap", "x", "y", "clipToBitmap", "AnimatedZoom", "Companion", "CompatScroller", "DoubleTapZoom", "Fling", "GestureListener", "PrivateOnTouchListener", "ScaleListener", "touchview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TouchImageView.kt */
public class TouchImageView extends AppCompatImageView {
    public static final float AUTOMATIC_MIN_ZOOM = -1.0f;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_ZOOM_TIME = 500;
    private static final float SUPER_MAX_MULTIPLIER = 1.25f;
    private static final float SUPER_MIN_MULTIPLIER = 0.75f;
    private float currentZoom;
    private ZoomVariables delayedZoomVariables;
    /* access modifiers changed from: private */
    public GestureDetector.OnDoubleTapListener doubleTapListener;
    private float doubleTapScale;
    /* access modifiers changed from: private */
    public Fling fling;
    /* access modifiers changed from: private */
    public float[] floatMatrix;
    /* access modifiers changed from: private */
    public GestureDetector gestureDetector;
    /* access modifiers changed from: private */
    public ImageActionState imageActionState;
    private boolean imageRenderedAtLeastOnce;
    /* access modifiers changed from: private */
    public boolean isRotateImageToFitScreen;
    private boolean isZoomEnabled;
    private float matchViewHeight;
    private float matchViewWidth;
    /* access modifiers changed from: private */
    public float maxScale;
    private boolean maxScaleIsSetByMultiplier;
    private float maxScaleMultiplier;
    /* access modifiers changed from: private */
    public float minScale;
    private boolean onDrawReady;
    private int orientation;
    private FixedPixel orientationChangeFixedPixel;
    private boolean orientationJustChanged;
    private float prevMatchViewHeight;
    private float prevMatchViewWidth;
    private Matrix prevMatrix;
    private int prevViewHeight;
    private int prevViewWidth;
    /* access modifiers changed from: private */
    public ScaleGestureDetector scaleDetector;
    private float superMaxScale;
    private float superMinScale;
    /* access modifiers changed from: private */
    public OnTouchCoordinatesListener touchCoordinatesListener;
    /* access modifiers changed from: private */
    public OnTouchImageViewListener touchImageViewListener;
    /* access modifiers changed from: private */
    public Matrix touchMatrix;
    private ImageView.ScaleType touchScaleType;
    private float userSpecifiedMinScale;
    /* access modifiers changed from: private */
    public View.OnTouchListener userTouchListener;
    /* access modifiers changed from: private */
    public int viewHeight;
    private FixedPixel viewSizeChangeFixedPixel;
    /* access modifiers changed from: private */
    public int viewWidth;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TouchImageView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            iArr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            iArr[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            iArr[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TouchImageView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    public final float getFixDragTrans(float f, float f2, float f3) {
        if (f3 <= f2) {
            return 0.0f;
        }
        return f;
    }

    private final float getFixTrans(float f, float f2, float f3, float f4) {
        float f5;
        if (f3 <= f2) {
            f5 = (f2 + f4) - f3;
        } else {
            float f6 = f4;
            f4 = (f2 + f4) - f3;
            f5 = f6;
        }
        if (f < f4) {
            return (-f) + f4;
        }
        if (f > f5) {
            return (-f) + f5;
        }
        return 0.0f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TouchImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.orientationChangeFixedPixel = FixedPixel.CENTER;
        this.viewSizeChangeFixedPixel = FixedPixel.CENTER;
        super.setClickable(true);
        this.orientation = getResources().getConfiguration().orientation;
        this.scaleDetector = new ScaleGestureDetector(context, new ScaleListener());
        this.gestureDetector = new GestureDetector(context, new GestureListener());
        this.touchMatrix = new Matrix();
        this.prevMatrix = new Matrix();
        this.floatMatrix = new float[9];
        this.currentZoom = 1.0f;
        if (this.touchScaleType == null) {
            this.touchScaleType = ImageView.ScaleType.FIT_CENTER;
        }
        this.minScale = 1.0f;
        this.maxScale = 3.0f;
        this.superMinScale = 1.0f * 0.75f;
        this.superMaxScale = 3.0f * SUPER_MAX_MULTIPLIER;
        setImageMatrix(this.touchMatrix);
        setScaleType(ImageView.ScaleType.MATRIX);
        setState(ImageActionState.NONE);
        this.onDrawReady = false;
        super.setOnTouchListener(new PrivateOnTouchListener());
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TouchImageView, i, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl…chImageView, defStyle, 0)");
        try {
            if (!isInEditMode()) {
                this.isZoomEnabled = obtainStyledAttributes.getBoolean(R.styleable.TouchImageView_zoom_enabled, true);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final float getCurrentZoom() {
        return this.currentZoom;
    }

    public final boolean isZoomEnabled() {
        return this.isZoomEnabled;
    }

    public final void setZoomEnabled(boolean z) {
        this.isZoomEnabled = z;
    }

    public final FixedPixel getOrientationChangeFixedPixel() {
        return this.orientationChangeFixedPixel;
    }

    public final void setOrientationChangeFixedPixel(FixedPixel fixedPixel) {
        this.orientationChangeFixedPixel = fixedPixel;
    }

    public final FixedPixel getViewSizeChangeFixedPixel() {
        return this.viewSizeChangeFixedPixel;
    }

    public final void setViewSizeChangeFixedPixel(FixedPixel fixedPixel) {
        this.viewSizeChangeFixedPixel = fixedPixel;
    }

    public final float getDoubleTapScale() {
        return this.doubleTapScale;
    }

    public final void setDoubleTapScale(float f) {
        this.doubleTapScale = f;
    }

    public final void setRotateImageToFitScreen(boolean z) {
        this.isRotateImageToFitScreen = z;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.userTouchListener = onTouchListener;
    }

    public final void setOnTouchImageViewListener(OnTouchImageViewListener onTouchImageViewListener) {
        Intrinsics.checkNotNullParameter(onTouchImageViewListener, "onTouchImageViewListener");
        this.touchImageViewListener = onTouchImageViewListener;
    }

    public final void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        Intrinsics.checkNotNullParameter(onDoubleTapListener, "onDoubleTapListener");
        this.doubleTapListener = onDoubleTapListener;
    }

    public final void setOnTouchCoordinatesListener(OnTouchCoordinatesListener onTouchCoordinatesListener) {
        Intrinsics.checkNotNullParameter(onTouchCoordinatesListener, "onTouchCoordinatesListener");
        this.touchCoordinatesListener = onTouchCoordinatesListener;
    }

    public void setImageResource(int i) {
        this.imageRenderedAtLeastOnce = false;
        super.setImageResource(i);
        savePreviousImageValues();
        fitImageToView();
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.imageRenderedAtLeastOnce = false;
        super.setImageBitmap(bitmap);
        savePreviousImageValues();
        fitImageToView();
    }

    public void setImageDrawable(Drawable drawable) {
        this.imageRenderedAtLeastOnce = false;
        super.setImageDrawable(drawable);
        savePreviousImageValues();
        fitImageToView();
    }

    public void setImageURI(Uri uri) {
        this.imageRenderedAtLeastOnce = false;
        super.setImageURI(uri);
        savePreviousImageValues();
        fitImageToView();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, CommonProperties.TYPE);
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(ImageView.ScaleType.MATRIX);
            return;
        }
        this.touchScaleType = scaleType;
        if (this.onDrawReady) {
            setZoom(this);
        }
    }

    public ImageView.ScaleType getScaleType() {
        ImageView.ScaleType scaleType = this.touchScaleType;
        Intrinsics.checkNotNull(scaleType);
        return scaleType;
    }

    public final boolean isZoomed() {
        return !(this.currentZoom == 1.0f);
    }

    public final RectF getZoomedRect() {
        if (this.touchScaleType != ImageView.ScaleType.FIT_XY) {
            PointF transformCoordTouchToBitmap = transformCoordTouchToBitmap(0.0f, 0.0f, true);
            PointF transformCoordTouchToBitmap2 = transformCoordTouchToBitmap((float) this.viewWidth, (float) this.viewHeight, true);
            float drawableWidth = (float) getDrawableWidth(getDrawable());
            float drawableHeight = (float) getDrawableHeight(getDrawable());
            return new RectF(transformCoordTouchToBitmap.x / drawableWidth, transformCoordTouchToBitmap.y / drawableHeight, transformCoordTouchToBitmap2.x / drawableWidth, transformCoordTouchToBitmap2.y / drawableHeight);
        }
        throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
    }

    public final void savePreviousImageValues() {
        if (this.viewHeight != 0 && this.viewWidth != 0) {
            this.touchMatrix.getValues(this.floatMatrix);
            this.prevMatrix.setValues(this.floatMatrix);
            this.prevMatchViewHeight = this.matchViewHeight;
            this.prevMatchViewWidth = this.matchViewWidth;
            this.prevViewHeight = this.viewHeight;
            this.prevViewWidth = this.viewWidth;
        }
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("orientation", this.orientation);
        bundle.putFloat("saveScale", this.currentZoom);
        bundle.putFloat("matchViewHeight", this.matchViewHeight);
        bundle.putFloat("matchViewWidth", this.matchViewWidth);
        bundle.putInt("viewWidth", this.viewWidth);
        bundle.putInt("viewHeight", this.viewHeight);
        this.touchMatrix.getValues(this.floatMatrix);
        bundle.putFloatArray("matrix", this.floatMatrix);
        bundle.putBoolean("imageRendered", this.imageRenderedAtLeastOnce);
        bundle.putSerializable("viewSizeChangeFixedPixel", this.viewSizeChangeFixedPixel);
        bundle.putSerializable("orientationChangeFixedPixel", this.orientationChangeFixedPixel);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, RemoteConfigConstants.ResponseFieldKey.STATE);
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.currentZoom = bundle.getFloat("saveScale");
            float[] floatArray = bundle.getFloatArray("matrix");
            Intrinsics.checkNotNull(floatArray);
            this.floatMatrix = floatArray;
            this.prevMatrix.setValues(floatArray);
            this.prevMatchViewHeight = bundle.getFloat("matchViewHeight");
            this.prevMatchViewWidth = bundle.getFloat("matchViewWidth");
            this.prevViewHeight = bundle.getInt("viewHeight");
            this.prevViewWidth = bundle.getInt("viewWidth");
            this.imageRenderedAtLeastOnce = bundle.getBoolean("imageRendered");
            this.viewSizeChangeFixedPixel = (FixedPixel) bundle.getSerializable("viewSizeChangeFixedPixel");
            this.orientationChangeFixedPixel = (FixedPixel) bundle.getSerializable("orientationChangeFixedPixel");
            if (this.orientation != bundle.getInt("orientation")) {
                this.orientationJustChanged = true;
            }
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.onDrawReady = true;
        this.imageRenderedAtLeastOnce = true;
        ZoomVariables zoomVariables = this.delayedZoomVariables;
        if (zoomVariables != null) {
            Intrinsics.checkNotNull(zoomVariables);
            float scale = zoomVariables.getScale();
            ZoomVariables zoomVariables2 = this.delayedZoomVariables;
            Intrinsics.checkNotNull(zoomVariables2);
            float focusX = zoomVariables2.getFocusX();
            ZoomVariables zoomVariables3 = this.delayedZoomVariables;
            Intrinsics.checkNotNull(zoomVariables3);
            float focusY = zoomVariables3.getFocusY();
            ZoomVariables zoomVariables4 = this.delayedZoomVariables;
            Intrinsics.checkNotNull(zoomVariables4);
            setZoom(scale, focusX, focusY, zoomVariables4.getScaleType());
            this.delayedZoomVariables = null;
        }
        super.onDraw(canvas);
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        int i = getResources().getConfiguration().orientation;
        if (i != this.orientation) {
            this.orientationJustChanged = true;
            this.orientation = i;
        }
        savePreviousImageValues();
    }

    public final float getMaxZoom() {
        return this.maxScale;
    }

    public final void setMaxZoom(float f) {
        this.maxScale = f;
        this.superMaxScale = f * SUPER_MAX_MULTIPLIER;
        this.maxScaleIsSetByMultiplier = false;
    }

    public final void setMaxZoomRatio(float f) {
        this.maxScaleMultiplier = f;
        float f2 = this.minScale * f;
        this.maxScale = f2;
        this.superMaxScale = f2 * SUPER_MAX_MULTIPLIER;
        this.maxScaleIsSetByMultiplier = true;
    }

    public final float getMinZoom() {
        return this.minScale;
    }

    public final void setMinZoom(float f) {
        float f2;
        this.userSpecifiedMinScale = f;
        if (!(f == -1.0f)) {
            this.minScale = f;
        } else if (this.touchScaleType == ImageView.ScaleType.CENTER || this.touchScaleType == ImageView.ScaleType.CENTER_CROP) {
            Drawable drawable = getDrawable();
            int drawableWidth = getDrawableWidth(drawable);
            int drawableHeight = getDrawableHeight(drawable);
            if (drawable != null && drawableWidth > 0 && drawableHeight > 0) {
                float f3 = ((float) this.viewWidth) / ((float) drawableWidth);
                float f4 = ((float) this.viewHeight) / ((float) drawableHeight);
                if (this.touchScaleType == ImageView.ScaleType.CENTER) {
                    f2 = Math.min(f3, f4);
                } else {
                    f2 = Math.min(f3, f4) / Math.max(f3, f4);
                }
                this.minScale = f2;
            }
        } else {
            this.minScale = 1.0f;
        }
        if (this.maxScaleIsSetByMultiplier) {
            setMaxZoomRatio(this.maxScaleMultiplier);
        }
        this.superMinScale = this.minScale * 0.75f;
    }

    public final void resetZoom() {
        this.currentZoom = 1.0f;
        fitImageToView();
    }

    public final void resetZoomAnimated() {
        setZoomAnimated(1.0f, 0.5f, 0.5f);
    }

    public final void setZoom(float f) {
        setZoom(f, 0.5f, 0.5f);
    }

    public final void setZoom(float f, float f2, float f3) {
        setZoom(f, f2, f3, this.touchScaleType);
    }

    public final void setZoom(float f, float f2, float f3, ImageView.ScaleType scaleType) {
        if (!this.onDrawReady) {
            this.delayedZoomVariables = new ZoomVariables(f, f2, f3, scaleType);
            return;
        }
        if (this.userSpecifiedMinScale == -1.0f) {
            setMinZoom(-1.0f);
            float f4 = this.currentZoom;
            float f5 = this.minScale;
            if (f4 < f5) {
                this.currentZoom = f5;
            }
        }
        if (scaleType != this.touchScaleType) {
            Intrinsics.checkNotNull(scaleType);
            setScaleType(scaleType);
        }
        resetZoom();
        scaleImage((double) f, ((float) this.viewWidth) / 2.0f, ((float) this.viewHeight) / 2.0f, true);
        this.touchMatrix.getValues(this.floatMatrix);
        float[] fArr = this.floatMatrix;
        float f6 = this.matchViewWidth;
        float f7 = (float) 2;
        float f8 = f - ((float) 1);
        fArr[2] = ((((float) this.viewWidth) - f6) / f7) - ((f2 * f8) * f6);
        float f9 = this.matchViewHeight;
        fArr[5] = ((((float) this.viewHeight) - f9) / f7) - ((f3 * f8) * f9);
        this.touchMatrix.setValues(fArr);
        fixTrans();
        savePreviousImageValues();
        setImageMatrix(this.touchMatrix);
    }

    public final void setZoom(TouchImageView touchImageView) {
        Intrinsics.checkNotNullParameter(touchImageView, "imageSource");
        PointF scrollPosition = touchImageView.getScrollPosition();
        setZoom(touchImageView.currentZoom, scrollPosition.x, scrollPosition.y, touchImageView.getScaleType());
    }

    public final PointF getScrollPosition() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return new PointF(0.5f, 0.5f);
        }
        int drawableWidth = getDrawableWidth(drawable);
        int drawableHeight = getDrawableHeight(drawable);
        PointF transformCoordTouchToBitmap = transformCoordTouchToBitmap(((float) this.viewWidth) / 2.0f, ((float) this.viewHeight) / 2.0f, true);
        transformCoordTouchToBitmap.x /= (float) drawableWidth;
        transformCoordTouchToBitmap.y /= (float) drawableHeight;
        return transformCoordTouchToBitmap;
    }

    /* access modifiers changed from: private */
    public final boolean orientationMismatch(Drawable drawable) {
        boolean z = this.viewWidth > this.viewHeight;
        Intrinsics.checkNotNull(drawable);
        return z != (drawable.getIntrinsicWidth() > drawable.getIntrinsicHeight());
    }

    private final int getDrawableWidth(Drawable drawable) {
        if (!orientationMismatch(drawable) || !this.isRotateImageToFitScreen) {
            Intrinsics.checkNotNull(drawable);
            return drawable.getIntrinsicWidth();
        }
        Intrinsics.checkNotNull(drawable);
        return drawable.getIntrinsicHeight();
    }

    private final int getDrawableHeight(Drawable drawable) {
        if (!orientationMismatch(drawable) || !this.isRotateImageToFitScreen) {
            Intrinsics.checkNotNull(drawable);
            return drawable.getIntrinsicHeight();
        }
        Intrinsics.checkNotNull(drawable);
        return drawable.getIntrinsicWidth();
    }

    public final void setScrollPosition(float f, float f2) {
        setZoom(this.currentZoom, f, f2);
    }

    /* access modifiers changed from: private */
    public final void fixTrans() {
        this.touchMatrix.getValues(this.floatMatrix);
        float[] fArr = this.floatMatrix;
        this.touchMatrix.postTranslate(getFixTrans(fArr[2], (float) this.viewWidth, getImageWidth(), (!this.isRotateImageToFitScreen || !orientationMismatch(getDrawable())) ? 0.0f : getImageWidth()), getFixTrans(fArr[5], (float) this.viewHeight, getImageHeight(), 0.0f));
    }

    /* access modifiers changed from: private */
    public final void fixScaleTrans() {
        fixTrans();
        this.touchMatrix.getValues(this.floatMatrix);
        float imageWidth = getImageWidth();
        int i = this.viewWidth;
        if (imageWidth < ((float) i)) {
            float imageWidth2 = (((float) i) - getImageWidth()) / ((float) 2);
            if (this.isRotateImageToFitScreen && orientationMismatch(getDrawable())) {
                imageWidth2 += getImageWidth();
            }
            this.floatMatrix[2] = imageWidth2;
        }
        float imageHeight = getImageHeight();
        int i2 = this.viewHeight;
        if (imageHeight < ((float) i2)) {
            this.floatMatrix[5] = (((float) i2) - getImageHeight()) / ((float) 2);
        }
        this.touchMatrix.setValues(this.floatMatrix);
    }

    /* access modifiers changed from: private */
    public final float getImageWidth() {
        return this.matchViewWidth * this.currentZoom;
    }

    /* access modifiers changed from: private */
    public final float getImageHeight() {
        return this.matchViewHeight * this.currentZoom;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int drawableWidth = getDrawableWidth(drawable);
        int drawableHeight = getDrawableHeight(drawable);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int viewSize = setViewSize(mode, size, drawableWidth);
        int viewSize2 = setViewSize(mode2, size2, drawableHeight);
        if (!this.orientationJustChanged) {
            savePreviousImageValues();
        }
        setMeasuredDimension((viewSize - getPaddingLeft()) - getPaddingRight(), (viewSize2 - getPaddingTop()) - getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.viewWidth = i;
        this.viewHeight = i2;
        fitImageToView();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010e, code lost:
        if ((r8.prevMatchViewHeight == 0.0f) != false) goto L_0x0110;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void fitImageToView() {
        /*
            r17 = this;
            r8 = r17
            boolean r0 = r8.orientationJustChanged
            if (r0 == 0) goto L_0x0009
            com.ortiz.touchview.FixedPixel r0 = r8.orientationChangeFixedPixel
            goto L_0x000b
        L_0x0009:
            com.ortiz.touchview.FixedPixel r0 = r8.viewSizeChangeFixedPixel
        L_0x000b:
            r9 = r0
            r0 = 0
            r8.orientationJustChanged = r0
            android.graphics.drawable.Drawable r1 = r17.getDrawable()
            if (r1 == 0) goto L_0x0172
            int r2 = r1.getIntrinsicWidth()
            if (r2 == 0) goto L_0x0172
            int r2 = r1.getIntrinsicHeight()
            if (r2 != 0) goto L_0x0023
            goto L_0x0172
        L_0x0023:
            android.graphics.Matrix r2 = r8.touchMatrix
            if (r2 == 0) goto L_0x0172
            android.graphics.Matrix r2 = r8.prevMatrix
            if (r2 != 0) goto L_0x002d
            goto L_0x0172
        L_0x002d:
            float r2 = r8.userSpecifiedMinScale
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0037
            r2 = 1
            goto L_0x0038
        L_0x0037:
            r2 = 0
        L_0x0038:
            if (r2 == 0) goto L_0x0047
            r8.setMinZoom(r3)
            float r2 = r8.currentZoom
            float r3 = r8.minScale
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0047
            r8.currentZoom = r3
        L_0x0047:
            int r6 = r8.getDrawableWidth(r1)
            int r10 = r8.getDrawableHeight(r1)
            int r2 = r8.viewWidth
            float r2 = (float) r2
            float r3 = (float) r6
            float r2 = r2 / r3
            int r5 = r8.viewHeight
            float r5 = (float) r5
            float r7 = (float) r10
            float r5 = r5 / r7
            android.widget.ImageView$ScaleType r11 = r8.touchScaleType
            if (r11 != 0) goto L_0x005f
            r11 = -1
            goto L_0x0067
        L_0x005f:
            int[] r13 = com.ortiz.touchview.TouchImageView.WhenMappings.$EnumSwitchMapping$0
            int r11 = r11.ordinal()
            r11 = r13[r11]
        L_0x0067:
            r13 = 1065353216(0x3f800000, float:1.0)
            switch(r11) {
                case 1: goto L_0x0088;
                case 2: goto L_0x0082;
                case 3: goto L_0x0072;
                case 4: goto L_0x006d;
                case 5: goto L_0x006d;
                case 6: goto L_0x006d;
                default: goto L_0x006c;
            }
        L_0x006c:
            goto L_0x008c
        L_0x006d:
            float r2 = java.lang.Math.min(r2, r5)
            goto L_0x0086
        L_0x0072:
            r11 = r8
            com.ortiz.touchview.TouchImageView r11 = (com.ortiz.touchview.TouchImageView) r11
            float r2 = java.lang.Math.min(r2, r5)
            float r2 = java.lang.Math.min(r13, r2)
            float r2 = java.lang.Math.min(r2, r2)
            goto L_0x0086
        L_0x0082:
            float r2 = java.lang.Math.max(r2, r5)
        L_0x0086:
            r5 = r2
            goto L_0x008c
        L_0x0088:
            r2 = 1065353216(0x3f800000, float:1.0)
            r5 = 1065353216(0x3f800000, float:1.0)
        L_0x008c:
            int r11 = r8.viewWidth
            float r14 = (float) r11
            float r15 = r2 * r3
            float r14 = r14 - r15
            int r15 = r8.viewHeight
            float r4 = (float) r15
            float r16 = r5 * r7
            float r4 = r4 - r16
            float r11 = (float) r11
            float r11 = r11 - r14
            r8.matchViewWidth = r11
            float r11 = (float) r15
            float r11 = r11 - r4
            r8.matchViewHeight = r11
            boolean r11 = r17.isZoomed()
            r15 = 5
            r12 = 2
            r0 = 0
            if (r11 != 0) goto L_0x00fa
            boolean r11 = r8.imageRenderedAtLeastOnce
            if (r11 != 0) goto L_0x00fa
            boolean r6 = r8.isRotateImageToFitScreen
            if (r6 == 0) goto L_0x00ca
            boolean r1 = r8.orientationMismatch(r1)
            if (r1 == 0) goto L_0x00ca
            android.graphics.Matrix r1 = r8.touchMatrix
            r6 = 1119092736(0x42b40000, float:90.0)
            r1.setRotate(r6)
            android.graphics.Matrix r1 = r8.touchMatrix
            r1.postTranslate(r3, r0)
            android.graphics.Matrix r1 = r8.touchMatrix
            r1.postScale(r2, r5)
            goto L_0x00cf
        L_0x00ca:
            android.graphics.Matrix r1 = r8.touchMatrix
            r1.setScale(r2, r5)
        L_0x00cf:
            android.widget.ImageView$ScaleType r1 = r8.touchScaleType
            if (r1 != 0) goto L_0x00d5
            r1 = -1
            goto L_0x00dd
        L_0x00d5:
            int[] r2 = com.ortiz.touchview.TouchImageView.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
        L_0x00dd:
            if (r1 == r15) goto L_0x00f1
            r0 = 6
            if (r1 == r0) goto L_0x00eb
            android.graphics.Matrix r0 = r8.touchMatrix
            float r1 = (float) r12
            float r14 = r14 / r1
            float r4 = r4 / r1
            r0.postTranslate(r14, r4)
            goto L_0x00f6
        L_0x00eb:
            android.graphics.Matrix r0 = r8.touchMatrix
            r0.postTranslate(r14, r4)
            goto L_0x00f6
        L_0x00f1:
            android.graphics.Matrix r1 = r8.touchMatrix
            r1.postTranslate(r0, r0)
        L_0x00f6:
            r8.currentZoom = r13
            goto L_0x016a
        L_0x00fa:
            float r1 = r8.prevMatchViewWidth
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L_0x0102
            r1 = 1
            goto L_0x0103
        L_0x0102:
            r1 = 0
        L_0x0103:
            if (r1 != 0) goto L_0x0110
            float r1 = r8.prevMatchViewHeight
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x010d
            r4 = 1
            goto L_0x010e
        L_0x010d:
            r4 = 0
        L_0x010e:
            if (r4 == 0) goto L_0x0113
        L_0x0110:
            r17.savePreviousImageValues()
        L_0x0113:
            android.graphics.Matrix r0 = r8.prevMatrix
            float[] r1 = r8.floatMatrix
            r0.getValues(r1)
            float[] r0 = r8.floatMatrix
            float r1 = r8.matchViewWidth
            float r1 = r1 / r3
            float r2 = r8.currentZoom
            float r1 = r1 * r2
            r3 = 0
            r0[r3] = r1
            r1 = 4
            float r3 = r8.matchViewHeight
            float r3 = r3 / r7
            float r3 = r3 * r2
            r0[r1] = r3
            r1 = r0[r12]
            r11 = r0[r15]
            float r0 = r8.prevMatchViewWidth
            float r2 = r2 * r0
            float r3 = r17.getImageWidth()
            float[] r13 = r8.floatMatrix
            int r4 = r8.prevViewWidth
            int r5 = r8.viewWidth
            r0 = r17
            r7 = r9
            float r0 = r0.newTranslationAfterChange(r1, r2, r3, r4, r5, r6, r7)
            r13[r12] = r0
            float r0 = r8.prevMatchViewHeight
            float r1 = r8.currentZoom
            float r2 = r0 * r1
            float r3 = r17.getImageHeight()
            float[] r12 = r8.floatMatrix
            int r4 = r8.prevViewHeight
            int r5 = r8.viewHeight
            r0 = r17
            r1 = r11
            r6 = r10
            float r0 = r0.newTranslationAfterChange(r1, r2, r3, r4, r5, r6, r7)
            r12[r15] = r0
            android.graphics.Matrix r0 = r8.touchMatrix
            float[] r1 = r8.floatMatrix
            r0.setValues(r1)
        L_0x016a:
            r17.fixTrans()
            android.graphics.Matrix r0 = r8.touchMatrix
            r8.setImageMatrix(r0)
        L_0x0172:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ortiz.touchview.TouchImageView.fitImageToView():void");
    }

    private final int setViewSize(int i, int i2, int i3) {
        if (i != Integer.MIN_VALUE) {
            return i != 0 ? i2 : i3;
        }
        return Math.min(i3, i2);
    }

    private final float newTranslationAfterChange(float f, float f2, float f3, int i, int i2, int i3, FixedPixel fixedPixel) {
        float f4 = (float) i2;
        float f5 = 0.5f;
        if (f3 < f4) {
            return (f4 - (((float) i3) * this.floatMatrix[0])) * 0.5f;
        }
        if (f > 0.0f) {
            return -((f3 - f4) * 0.5f);
        }
        if (fixedPixel == FixedPixel.BOTTOM_RIGHT) {
            f5 = 1.0f;
        } else if (fixedPixel == FixedPixel.TOP_LEFT) {
            f5 = 0.0f;
        }
        return -(((((-f) + (((float) i) * f5)) / f2) * f3) - (f4 * f5));
    }

    /* access modifiers changed from: private */
    public final void setState(ImageActionState imageActionState2) {
        this.imageActionState = imageActionState2;
    }

    @Deprecated(message = "")
    public final boolean canScrollHorizontallyFroyo(int i) {
        return canScrollHorizontally(i);
    }

    public boolean canScrollHorizontally(int i) {
        this.touchMatrix.getValues(this.floatMatrix);
        float f = this.floatMatrix[2];
        return getImageWidth() >= ((float) this.viewWidth) && (f < -1.0f || i >= 0) && ((Math.abs(f) + ((float) this.viewWidth)) + ((float) 1) < getImageWidth() || i <= 0);
    }

    public boolean canScrollVertically(int i) {
        this.touchMatrix.getValues(this.floatMatrix);
        float f = this.floatMatrix[5];
        return getImageHeight() >= ((float) this.viewHeight) && (f < -1.0f || i >= 0) && ((Math.abs(f) + ((float) this.viewHeight)) + ((float) 1) < getImageHeight() || i <= 0);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J,\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/ortiz/touchview/TouchImageView$GestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lcom/ortiz/touchview/TouchImageView;)V", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onSingleTapConfirmed", "touchview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TouchImageView.kt */
    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            GestureDetector.OnDoubleTapListener access$getDoubleTapListener$p = TouchImageView.this.doubleTapListener;
            return access$getDoubleTapListener$p != null ? access$getDoubleTapListener$p.onSingleTapConfirmed(motionEvent) : TouchImageView.this.performClick();
        }

        public void onLongPress(MotionEvent motionEvent) {
            TouchImageView.this.performLongClick();
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Fling access$getFling$p = TouchImageView.this.fling;
            if (access$getFling$p != null) {
                access$getFling$p.cancelFling();
            }
            TouchImageView touchImageView = TouchImageView.this;
            Fling fling = new Fling((int) f, (int) f2);
            TouchImageView.this.compatPostOnAnimation(fling);
            touchImageView.fling = fling;
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean z = false;
            if (motionEvent == null || !TouchImageView.this.isZoomEnabled()) {
                return false;
            }
            GestureDetector.OnDoubleTapListener access$getDoubleTapListener$p = TouchImageView.this.doubleTapListener;
            boolean onDoubleTap = access$getDoubleTapListener$p != null ? access$getDoubleTapListener$p.onDoubleTap(motionEvent) : false;
            if (TouchImageView.this.imageActionState != ImageActionState.NONE) {
                return onDoubleTap;
            }
            float access$getMaxScale$p = (TouchImageView.this.getDoubleTapScale() > 0.0f ? 1 : (TouchImageView.this.getDoubleTapScale() == 0.0f ? 0 : -1)) == 0 ? TouchImageView.this.maxScale : TouchImageView.this.getDoubleTapScale();
            if (TouchImageView.this.getCurrentZoom() == TouchImageView.this.minScale) {
                z = true;
            }
            if (!z) {
                access$getMaxScale$p = TouchImageView.this.minScale;
            }
            TouchImageView.this.compatPostOnAnimation(new DoubleTapZoom(access$getMaxScale$p, motionEvent.getX(), motionEvent.getY(), false));
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            GestureDetector.OnDoubleTapListener access$getDoubleTapListener$p = TouchImageView.this.doubleTapListener;
            if (access$getDoubleTapListener$p != null) {
                return access$getDoubleTapListener$p.onDoubleTapEvent(motionEvent);
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ortiz/touchview/TouchImageView$PrivateOnTouchListener;", "Landroid/view/View$OnTouchListener;", "(Lcom/ortiz/touchview/TouchImageView;)V", "last", "Landroid/graphics/PointF;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "touchview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TouchImageView.kt */
    private final class PrivateOnTouchListener implements View.OnTouchListener {
        private final PointF last = new PointF();

        public PrivateOnTouchListener() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x006d, code lost:
            if (r1 != 6) goto L_0x00e1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                r7 = this;
                java.lang.String r0 = "v"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                java.lang.String r0 = "event"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                com.ortiz.touchview.TouchImageView r0 = com.ortiz.touchview.TouchImageView.this
                android.graphics.drawable.Drawable r0 = r0.getDrawable()
                if (r0 != 0) goto L_0x001b
                com.ortiz.touchview.TouchImageView r8 = com.ortiz.touchview.TouchImageView.this
                com.ortiz.touchview.ImageActionState r9 = com.ortiz.touchview.ImageActionState.NONE
                r8.setState(r9)
                r8 = 0
                return r8
            L_0x001b:
                com.ortiz.touchview.TouchImageView r0 = com.ortiz.touchview.TouchImageView.this
                boolean r0 = r0.isZoomEnabled()
                if (r0 == 0) goto L_0x002c
                com.ortiz.touchview.TouchImageView r0 = com.ortiz.touchview.TouchImageView.this
                android.view.ScaleGestureDetector r0 = r0.scaleDetector
                r0.onTouchEvent(r9)
            L_0x002c:
                com.ortiz.touchview.TouchImageView r0 = com.ortiz.touchview.TouchImageView.this
                android.view.GestureDetector r0 = r0.gestureDetector
                r0.onTouchEvent(r9)
                android.graphics.PointF r0 = new android.graphics.PointF
                float r1 = r9.getX()
                float r2 = r9.getY()
                r0.<init>(r1, r2)
                com.ortiz.touchview.TouchImageView r1 = com.ortiz.touchview.TouchImageView.this
                com.ortiz.touchview.ImageActionState r1 = r1.imageActionState
                com.ortiz.touchview.ImageActionState r2 = com.ortiz.touchview.ImageActionState.NONE
                r3 = 1
                if (r1 == r2) goto L_0x0061
                com.ortiz.touchview.TouchImageView r1 = com.ortiz.touchview.TouchImageView.this
                com.ortiz.touchview.ImageActionState r1 = r1.imageActionState
                com.ortiz.touchview.ImageActionState r2 = com.ortiz.touchview.ImageActionState.DRAG
                if (r1 == r2) goto L_0x0061
                com.ortiz.touchview.TouchImageView r1 = com.ortiz.touchview.TouchImageView.this
                com.ortiz.touchview.ImageActionState r1 = r1.imageActionState
                com.ortiz.touchview.ImageActionState r2 = com.ortiz.touchview.ImageActionState.FLING
                if (r1 != r2) goto L_0x00e1
            L_0x0061:
                int r1 = r9.getAction()
                if (r1 == 0) goto L_0x00ca
                if (r1 == r3) goto L_0x00c2
                r2 = 2
                if (r1 == r2) goto L_0x0070
                r0 = 6
                if (r1 == r0) goto L_0x00c2
                goto L_0x00e1
            L_0x0070:
                com.ortiz.touchview.TouchImageView r1 = com.ortiz.touchview.TouchImageView.this
                com.ortiz.touchview.ImageActionState r1 = r1.imageActionState
                com.ortiz.touchview.ImageActionState r2 = com.ortiz.touchview.ImageActionState.DRAG
                if (r1 != r2) goto L_0x00e1
                float r1 = r0.x
                android.graphics.PointF r2 = r7.last
                float r2 = r2.x
                float r1 = r1 - r2
                float r2 = r0.y
                android.graphics.PointF r4 = r7.last
                float r4 = r4.y
                float r2 = r2 - r4
                com.ortiz.touchview.TouchImageView r4 = com.ortiz.touchview.TouchImageView.this
                int r5 = r4.viewWidth
                float r5 = (float) r5
                com.ortiz.touchview.TouchImageView r6 = com.ortiz.touchview.TouchImageView.this
                float r6 = r6.getImageWidth()
                float r1 = r4.getFixDragTrans(r1, r5, r6)
                com.ortiz.touchview.TouchImageView r4 = com.ortiz.touchview.TouchImageView.this
                int r5 = r4.viewHeight
                float r5 = (float) r5
                com.ortiz.touchview.TouchImageView r6 = com.ortiz.touchview.TouchImageView.this
                float r6 = r6.getImageHeight()
                float r2 = r4.getFixDragTrans(r2, r5, r6)
                com.ortiz.touchview.TouchImageView r4 = com.ortiz.touchview.TouchImageView.this
                android.graphics.Matrix r4 = r4.touchMatrix
                r4.postTranslate(r1, r2)
                com.ortiz.touchview.TouchImageView r1 = com.ortiz.touchview.TouchImageView.this
                r1.fixTrans()
                android.graphics.PointF r1 = r7.last
                float r2 = r0.x
                float r0 = r0.y
                r1.set(r2, r0)
                goto L_0x00e1
            L_0x00c2:
                com.ortiz.touchview.TouchImageView r0 = com.ortiz.touchview.TouchImageView.this
                com.ortiz.touchview.ImageActionState r1 = com.ortiz.touchview.ImageActionState.NONE
                r0.setState(r1)
                goto L_0x00e1
            L_0x00ca:
                android.graphics.PointF r1 = r7.last
                r1.set(r0)
                com.ortiz.touchview.TouchImageView r0 = com.ortiz.touchview.TouchImageView.this
                com.ortiz.touchview.TouchImageView$Fling r0 = r0.fling
                if (r0 == 0) goto L_0x00da
                r0.cancelFling()
            L_0x00da:
                com.ortiz.touchview.TouchImageView r0 = com.ortiz.touchview.TouchImageView.this
                com.ortiz.touchview.ImageActionState r1 = com.ortiz.touchview.ImageActionState.DRAG
                r0.setState(r1)
            L_0x00e1:
                com.ortiz.touchview.TouchImageView r0 = com.ortiz.touchview.TouchImageView.this
                com.ortiz.touchview.OnTouchCoordinatesListener r0 = r0.touchCoordinatesListener
                if (r0 == 0) goto L_0x00fa
                com.ortiz.touchview.TouchImageView r1 = com.ortiz.touchview.TouchImageView.this
                float r2 = r9.getX()
                float r4 = r9.getY()
                android.graphics.PointF r1 = r1.transformCoordTouchToBitmap(r2, r4, r3)
                r0.onTouchCoordinate(r8, r9, r1)
            L_0x00fa:
                com.ortiz.touchview.TouchImageView r0 = com.ortiz.touchview.TouchImageView.this
                android.graphics.Matrix r1 = r0.touchMatrix
                r0.setImageMatrix(r1)
                com.ortiz.touchview.TouchImageView r0 = com.ortiz.touchview.TouchImageView.this
                android.view.View$OnTouchListener r0 = r0.userTouchListener
                if (r0 == 0) goto L_0x010e
                r0.onTouch(r8, r9)
            L_0x010e:
                com.ortiz.touchview.TouchImageView r8 = com.ortiz.touchview.TouchImageView.this
                com.ortiz.touchview.OnTouchImageViewListener r8 = r8.touchImageViewListener
                if (r8 == 0) goto L_0x0119
                r8.onMove()
            L_0x0119:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ortiz.touchview.TouchImageView.PrivateOnTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/ortiz/touchview/TouchImageView$ScaleListener;", "Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;", "(Lcom/ortiz/touchview/TouchImageView;)V", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "touchview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TouchImageView.kt */
    private final class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public ScaleListener() {
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            Intrinsics.checkNotNullParameter(scaleGestureDetector, "detector");
            TouchImageView.this.setState(ImageActionState.ZOOM);
            return true;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            Intrinsics.checkNotNullParameter(scaleGestureDetector, "detector");
            TouchImageView.this.scaleImage((double) scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), true);
            OnTouchImageViewListener access$getTouchImageViewListener$p = TouchImageView.this.touchImageViewListener;
            if (access$getTouchImageViewListener$p == null) {
                return true;
            }
            access$getTouchImageViewListener$p.onMove();
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            Intrinsics.checkNotNullParameter(scaleGestureDetector, "detector");
            super.onScaleEnd(scaleGestureDetector);
            TouchImageView.this.setState(ImageActionState.NONE);
            float currentZoom = TouchImageView.this.getCurrentZoom();
            boolean z = true;
            if (TouchImageView.this.getCurrentZoom() > TouchImageView.this.maxScale) {
                currentZoom = TouchImageView.this.maxScale;
            } else if (TouchImageView.this.getCurrentZoom() < TouchImageView.this.minScale) {
                currentZoom = TouchImageView.this.minScale;
            } else {
                z = false;
            }
            float f = currentZoom;
            if (z) {
                TouchImageView touchImageView = TouchImageView.this;
                TouchImageView.this.compatPostOnAnimation(new DoubleTapZoom(f, (float) (touchImageView.viewWidth / 2), (float) (TouchImageView.this.viewHeight / 2), true));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void scaleImage(double d, float f, float f2, boolean z) {
        float f3;
        float f4;
        double d2;
        if (z) {
            f3 = this.superMinScale;
            f4 = this.superMaxScale;
        } else {
            f3 = this.minScale;
            f4 = this.maxScale;
        }
        float f5 = this.currentZoom;
        float f6 = ((float) d) * f5;
        this.currentZoom = f6;
        if (f6 > f4) {
            this.currentZoom = f4;
            d2 = (double) f4;
        } else {
            if (f6 < f3) {
                this.currentZoom = f3;
                d2 = (double) f3;
            }
            float f7 = (float) d;
            this.touchMatrix.postScale(f7, f7, f, f2);
            fixScaleTrans();
        }
        d = d2 / ((double) f5);
        float f72 = (float) d;
        this.touchMatrix.postScale(f72, f72, f, f2);
        fixScaleTrans();
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0003H\u0002R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ortiz/touchview/TouchImageView$DoubleTapZoom;", "Ljava/lang/Runnable;", "targetZoom", "", "focusX", "focusY", "stretchImageToSuper", "", "(Lcom/ortiz/touchview/TouchImageView;FFFZ)V", "bitmapX", "bitmapY", "endTouch", "Landroid/graphics/PointF;", "interpolator", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "startTime", "", "startTouch", "startZoom", "calculateDeltaScale", "", "t", "interpolate", "run", "", "translateImageToCenterTouchPosition", "touchview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TouchImageView.kt */
    private final class DoubleTapZoom implements Runnable {
        private final float bitmapX;
        private final float bitmapY;
        private final PointF endTouch;
        private final AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
        private final long startTime;
        private final PointF startTouch;
        private final float startZoom;
        private final boolean stretchImageToSuper;
        private final float targetZoom;

        public DoubleTapZoom(float f, float f2, float f3, boolean z) {
            TouchImageView.this.setState(ImageActionState.ANIMATE_ZOOM);
            this.startTime = System.currentTimeMillis();
            this.startZoom = TouchImageView.this.getCurrentZoom();
            this.targetZoom = f;
            this.stretchImageToSuper = z;
            PointF transformCoordTouchToBitmap = TouchImageView.this.transformCoordTouchToBitmap(f2, f3, false);
            float f4 = transformCoordTouchToBitmap.x;
            this.bitmapX = f4;
            float f5 = transformCoordTouchToBitmap.y;
            this.bitmapY = f5;
            this.startTouch = TouchImageView.this.transformCoordBitmapToTouch(f4, f5);
            this.endTouch = new PointF((float) (TouchImageView.this.viewWidth / 2), (float) (TouchImageView.this.viewHeight / 2));
        }

        public void run() {
            if (TouchImageView.this.getDrawable() == null) {
                TouchImageView.this.setState(ImageActionState.NONE);
                return;
            }
            float interpolate = interpolate();
            TouchImageView.this.scaleImage(calculateDeltaScale(interpolate), this.bitmapX, this.bitmapY, this.stretchImageToSuper);
            translateImageToCenterTouchPosition(interpolate);
            TouchImageView.this.fixScaleTrans();
            TouchImageView touchImageView = TouchImageView.this;
            touchImageView.setImageMatrix(touchImageView.touchMatrix);
            OnTouchImageViewListener access$getTouchImageViewListener$p = TouchImageView.this.touchImageViewListener;
            if (access$getTouchImageViewListener$p != null) {
                access$getTouchImageViewListener$p.onMove();
            }
            if (interpolate < 1.0f) {
                TouchImageView.this.compatPostOnAnimation(this);
            } else {
                TouchImageView.this.setState(ImageActionState.NONE);
            }
        }

        private final void translateImageToCenterTouchPosition(float f) {
            float f2 = this.startTouch.x + ((this.endTouch.x - this.startTouch.x) * f);
            float f3 = this.startTouch.y + (f * (this.endTouch.y - this.startTouch.y));
            PointF transformCoordBitmapToTouch = TouchImageView.this.transformCoordBitmapToTouch(this.bitmapX, this.bitmapY);
            TouchImageView.this.touchMatrix.postTranslate(f2 - transformCoordBitmapToTouch.x, f3 - transformCoordBitmapToTouch.y);
        }

        private final float interpolate() {
            return this.interpolator.getInterpolation(Math.min(1.0f, ((float) (System.currentTimeMillis() - this.startTime)) / 500.0f));
        }

        private final double calculateDeltaScale(float f) {
            float f2 = this.startZoom;
            return (((double) f2) + (((double) f) * ((double) (this.targetZoom - f2)))) / ((double) TouchImageView.this.getCurrentZoom());
        }
    }

    /* access modifiers changed from: protected */
    public final PointF transformCoordTouchToBitmap(float f, float f2, boolean z) {
        this.touchMatrix.getValues(this.floatMatrix);
        float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
        float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
        float[] fArr = this.floatMatrix;
        float f3 = fArr[2];
        float f4 = fArr[5];
        float imageWidth = ((f - f3) * intrinsicWidth) / getImageWidth();
        float imageHeight = ((f2 - f4) * intrinsicHeight) / getImageHeight();
        if (z) {
            imageWidth = Math.min(Math.max(imageWidth, 0.0f), intrinsicWidth);
            imageHeight = Math.min(Math.max(imageHeight, 0.0f), intrinsicHeight);
        }
        return new PointF(imageWidth, imageHeight);
    }

    /* access modifiers changed from: protected */
    public final PointF transformCoordBitmapToTouch(float f, float f2) {
        this.touchMatrix.getValues(this.floatMatrix);
        return new PointF(this.floatMatrix[2] + (getImageWidth() * (f / ((float) getDrawable().getIntrinsicWidth()))), this.floatMatrix[5] + (getImageHeight() * (f2 / ((float) getDrawable().getIntrinsicHeight()))));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001e\u0010\u000e\u001a\u00060\u000fR\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/ortiz/touchview/TouchImageView$Fling;", "Ljava/lang/Runnable;", "velocityX", "", "velocityY", "(Lcom/ortiz/touchview/TouchImageView;II)V", "currX", "getCurrX", "()I", "setCurrX", "(I)V", "currY", "getCurrY", "setCurrY", "scroller", "Lcom/ortiz/touchview/TouchImageView$CompatScroller;", "Lcom/ortiz/touchview/TouchImageView;", "getScroller", "()Lcom/ortiz/touchview/TouchImageView$CompatScroller;", "setScroller", "(Lcom/ortiz/touchview/TouchImageView$CompatScroller;)V", "cancelFling", "", "run", "touchview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TouchImageView.kt */
    private final class Fling implements Runnable {
        private int currX;
        private int currY;
        private CompatScroller scroller;

        public Fling(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            TouchImageView.this.setState(ImageActionState.FLING);
            this.scroller = new CompatScroller(TouchImageView.this.getContext());
            TouchImageView.this.touchMatrix.getValues(TouchImageView.this.floatMatrix);
            int i7 = (int) TouchImageView.this.floatMatrix[2];
            int i8 = (int) TouchImageView.this.floatMatrix[5];
            if (TouchImageView.this.isRotateImageToFitScreen && TouchImageView.this.orientationMismatch(TouchImageView.this.getDrawable())) {
                i7 -= (int) TouchImageView.this.getImageWidth();
            }
            if (TouchImageView.this.getImageWidth() > ((float) TouchImageView.this.viewWidth)) {
                i4 = TouchImageView.this.viewWidth - ((int) TouchImageView.this.getImageWidth());
                i3 = 0;
            } else {
                i4 = i7;
                i3 = i4;
            }
            if (TouchImageView.this.getImageHeight() > ((float) TouchImageView.this.viewHeight)) {
                i6 = TouchImageView.this.viewHeight - ((int) TouchImageView.this.getImageHeight());
                i5 = 0;
            } else {
                i6 = i8;
                i5 = i6;
            }
            this.scroller.fling(i7, i8, i, i2, i4, i3, i6, i5);
            this.currX = i7;
            this.currY = i8;
        }

        public final CompatScroller getScroller() {
            return this.scroller;
        }

        public final void setScroller(CompatScroller compatScroller) {
            Intrinsics.checkNotNullParameter(compatScroller, "<set-?>");
            this.scroller = compatScroller;
        }

        public final int getCurrX() {
            return this.currX;
        }

        public final void setCurrX(int i) {
            this.currX = i;
        }

        public final int getCurrY() {
            return this.currY;
        }

        public final void setCurrY(int i) {
            this.currY = i;
        }

        public final void cancelFling() {
            TouchImageView.this.setState(ImageActionState.NONE);
            this.scroller.forceFinished(true);
        }

        public void run() {
            OnTouchImageViewListener access$getTouchImageViewListener$p = TouchImageView.this.touchImageViewListener;
            if (access$getTouchImageViewListener$p != null) {
                access$getTouchImageViewListener$p.onMove();
            }
            if (!this.scroller.isFinished() && this.scroller.computeScrollOffset()) {
                int currX2 = this.scroller.getCurrX();
                int currY2 = this.scroller.getCurrY();
                int i = currX2 - this.currX;
                int i2 = currY2 - this.currY;
                this.currX = currX2;
                this.currY = currY2;
                TouchImageView.this.touchMatrix.postTranslate((float) i, (float) i2);
                TouchImageView.this.fixTrans();
                TouchImageView touchImageView = TouchImageView.this;
                touchImageView.setImageMatrix(touchImageView.touchMatrix);
                TouchImageView.this.compatPostOnAnimation(this);
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\fJF\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\fR\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/ortiz/touchview/TouchImageView$CompatScroller;", "", "context", "Landroid/content/Context;", "(Lcom/ortiz/touchview/TouchImageView;Landroid/content/Context;)V", "currX", "", "getCurrX", "()I", "currY", "getCurrY", "isFinished", "", "()Z", "overScroller", "Landroid/widget/OverScroller;", "getOverScroller", "()Landroid/widget/OverScroller;", "setOverScroller", "(Landroid/widget/OverScroller;)V", "computeScrollOffset", "fling", "", "startX", "startY", "velocityX", "velocityY", "minX", "maxX", "minY", "maxY", "forceFinished", "finished", "touchview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TouchImageView.kt */
    private final class CompatScroller {
        private OverScroller overScroller;

        public CompatScroller(Context context) {
            this.overScroller = new OverScroller(context);
        }

        public final OverScroller getOverScroller() {
            return this.overScroller;
        }

        public final void setOverScroller(OverScroller overScroller2) {
            Intrinsics.checkNotNullParameter(overScroller2, "<set-?>");
            this.overScroller = overScroller2;
        }

        public final void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.overScroller.fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public final void forceFinished(boolean z) {
            this.overScroller.forceFinished(z);
        }

        public final boolean isFinished() {
            return this.overScroller.isFinished();
        }

        public final boolean computeScrollOffset() {
            this.overScroller.computeScrollOffset();
            return this.overScroller.computeScrollOffset();
        }

        public final int getCurrX() {
            return this.overScroller.getCurrX();
        }

        public final int getCurrY() {
            return this.overScroller.getCurrY();
        }
    }

    /* access modifiers changed from: private */
    public final void compatPostOnAnimation(Runnable runnable) {
        postOnAnimation(runnable);
    }

    public final void setZoomAnimated(float f, float f2, float f3) {
        setZoomAnimated(f, f2, f3, 500);
    }

    public final void setZoomAnimated(float f, float f2, float f3, int i) {
        compatPostOnAnimation(new AnimatedZoom(this, f, new PointF(f2, f3), i));
    }

    public final void setZoomAnimated(float f, float f2, float f3, int i, OnZoomFinishedListener onZoomFinishedListener) {
        AnimatedZoom animatedZoom = new AnimatedZoom(this, f, new PointF(f2, f3), i);
        animatedZoom.setListener(onZoomFinishedListener);
        compatPostOnAnimation(animatedZoom);
    }

    public final void setZoomAnimated(float f, float f2, float f3, OnZoomFinishedListener onZoomFinishedListener) {
        AnimatedZoom animatedZoom = new AnimatedZoom(this, f, new PointF(f2, f3), 500);
        animatedZoom.setListener(onZoomFinishedListener);
        compatPostOnAnimation(animatedZoom);
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ortiz/touchview/TouchImageView$AnimatedZoom;", "Ljava/lang/Runnable;", "targetZoom", "", "focus", "Landroid/graphics/PointF;", "zoomTimeMillis", "", "(Lcom/ortiz/touchview/TouchImageView;FLandroid/graphics/PointF;I)V", "interpolator", "Landroid/view/animation/LinearInterpolator;", "startFocus", "startTime", "", "startZoom", "targetFocus", "zoomFinishedListener", "Lcom/ortiz/touchview/OnZoomFinishedListener;", "interpolate", "run", "", "setListener", "listener", "touchview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TouchImageView.kt */
    private final class AnimatedZoom implements Runnable {
        private final LinearInterpolator interpolator = new LinearInterpolator();
        private final PointF startFocus;
        private final long startTime;
        private final float startZoom;
        private final PointF targetFocus;
        private final float targetZoom;
        final /* synthetic */ TouchImageView this$0;
        private OnZoomFinishedListener zoomFinishedListener;
        private final int zoomTimeMillis;

        public AnimatedZoom(TouchImageView touchImageView, float f, PointF pointF, int i) {
            Intrinsics.checkNotNullParameter(pointF, "focus");
            this.this$0 = touchImageView;
            touchImageView.setState(ImageActionState.ANIMATE_ZOOM);
            this.startTime = System.currentTimeMillis();
            this.startZoom = touchImageView.getCurrentZoom();
            this.targetZoom = f;
            this.zoomTimeMillis = i;
            this.startFocus = touchImageView.getScrollPosition();
            this.targetFocus = pointF;
        }

        public void run() {
            float interpolate = interpolate();
            float f = this.startZoom;
            this.this$0.setZoom(f + ((this.targetZoom - f) * interpolate), this.startFocus.x + ((this.targetFocus.x - this.startFocus.x) * interpolate), this.startFocus.y + ((this.targetFocus.y - this.startFocus.y) * interpolate));
            if (interpolate < 1.0f) {
                this.this$0.compatPostOnAnimation(this);
                return;
            }
            this.this$0.setState(ImageActionState.NONE);
            OnZoomFinishedListener onZoomFinishedListener = this.zoomFinishedListener;
            if (onZoomFinishedListener != null) {
                onZoomFinishedListener.onZoomFinished();
            }
        }

        private final float interpolate() {
            return this.interpolator.getInterpolation(Math.min(1.0f, ((float) (System.currentTimeMillis() - this.startTime)) / ((float) this.zoomTimeMillis)));
        }

        public final void setListener(OnZoomFinishedListener onZoomFinishedListener) {
            this.zoomFinishedListener = onZoomFinishedListener;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ortiz/touchview/TouchImageView$Companion;", "", "()V", "AUTOMATIC_MIN_ZOOM", "", "DEFAULT_ZOOM_TIME", "", "SUPER_MAX_MULTIPLIER", "SUPER_MIN_MULTIPLIER", "touchview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TouchImageView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
