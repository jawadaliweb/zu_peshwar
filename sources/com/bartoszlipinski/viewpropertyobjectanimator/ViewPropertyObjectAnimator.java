package com.bartoszlipinski.viewpropertyobjectanimator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ViewPropertyObjectAnimator {
    private DimensionChangeListener mDimensionListener;
    private long mDuration = -1;
    private Interpolator mInterpolator;
    private List<Animator.AnimatorListener> mListeners = new ArrayList();
    private MarginChangeListener mMarginListener;
    private PaddingChangeListener mPaddingListener;
    private List<Animator.AnimatorPauseListener> mPauseListeners = new ArrayList();
    private PercentChangeListener mPercentListener;
    private ArrayMap<Property<View, Float>, PropertyValuesHolder> mPropertyHoldersMap = new ArrayMap<>();
    private ScrollChangeListener mScrollListener;
    private long mStartDelay = -1;
    private List<ValueAnimator.AnimatorUpdateListener> mUpdateListeners = new ArrayList();
    /* access modifiers changed from: private */
    public final WeakReference<View> mView;
    private boolean mWithLayer = false;

    private ViewPropertyObjectAnimator(View view) {
        this.mView = new WeakReference<>(view);
    }

    public static ViewPropertyObjectAnimator animate(View view) {
        return new ViewPropertyObjectAnimator(view);
    }

    private void animateProperty(Property<View, Float> property, float f) {
        if (hasView()) {
            animatePropertyBetween(property, property.get(this.mView.get()).floatValue(), f);
        }
    }

    private void animatePropertyBy(Property<View, Float> property, float f) {
        if (hasView()) {
            float floatValue = property.get(this.mView.get()).floatValue();
            animatePropertyBetween(property, floatValue, f + floatValue);
        }
    }

    private void animatePropertyBetween(Property<View, Float> property, float f, float f2) {
        this.mPropertyHoldersMap.remove(property);
        this.mPropertyHoldersMap.put(property, PropertyValuesHolder.ofFloat(property, new float[]{f, f2}));
    }

    public ViewPropertyObjectAnimator scaleX(float f) {
        animateProperty(View.SCALE_X, f);
        return this;
    }

    public ViewPropertyObjectAnimator scaleXBy(float f) {
        animatePropertyBy(View.SCALE_X, f);
        return this;
    }

    public ViewPropertyObjectAnimator scaleY(float f) {
        animateProperty(View.SCALE_Y, f);
        return this;
    }

    public ViewPropertyObjectAnimator scaleYBy(float f) {
        animatePropertyBy(View.SCALE_Y, f);
        return this;
    }

    public ViewPropertyObjectAnimator scales(float f) {
        scaleY(f);
        scaleX(f);
        return this;
    }

    public ViewPropertyObjectAnimator scalesBy(float f) {
        scaleYBy(f);
        scaleXBy(f);
        return this;
    }

    public ViewPropertyObjectAnimator translationX(float f) {
        animateProperty(View.TRANSLATION_X, f);
        return this;
    }

    public ViewPropertyObjectAnimator translationXBy(float f) {
        animatePropertyBy(View.TRANSLATION_X, f);
        return this;
    }

    public ViewPropertyObjectAnimator translationY(float f) {
        animateProperty(View.TRANSLATION_Y, f);
        return this;
    }

    public ViewPropertyObjectAnimator translationYBy(float f) {
        animatePropertyBy(View.TRANSLATION_Y, f);
        return this;
    }

    public ViewPropertyObjectAnimator translationZ(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            animateProperty(View.TRANSLATION_Z, f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator translationZBy(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            animatePropertyBy(View.TRANSLATION_Z, f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator alpha(float f) {
        animateProperty(View.ALPHA, f);
        return this;
    }

    public ViewPropertyObjectAnimator alphaBy(float f) {
        animatePropertyBy(View.ALPHA, f);
        return this;
    }

    public ViewPropertyObjectAnimator rotation(float f) {
        animateProperty(View.ROTATION, f);
        return this;
    }

    public ViewPropertyObjectAnimator rotationBy(float f) {
        animatePropertyBy(View.ROTATION, f);
        return this;
    }

    public ViewPropertyObjectAnimator rotationX(float f) {
        animateProperty(View.ROTATION_X, f);
        return this;
    }

    public ViewPropertyObjectAnimator rotationXBy(float f) {
        animatePropertyBy(View.ROTATION_X, f);
        return this;
    }

    public ViewPropertyObjectAnimator rotationY(float f) {
        animateProperty(View.ROTATION_Y, f);
        return this;
    }

    public ViewPropertyObjectAnimator rotationYBy(float f) {
        animatePropertyBy(View.ROTATION_Y, f);
        return this;
    }

    public ViewPropertyObjectAnimator x(float f) {
        animateProperty(View.X, f);
        return this;
    }

    public ViewPropertyObjectAnimator xBy(float f) {
        animatePropertyBy(View.X, f);
        return this;
    }

    public ViewPropertyObjectAnimator y(float f) {
        animateProperty(View.Y, f);
        return this;
    }

    public ViewPropertyObjectAnimator yBy(float f) {
        animatePropertyBy(View.Y, f);
        return this;
    }

    public ViewPropertyObjectAnimator z(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            animateProperty(View.Z, f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator zBy(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            animatePropertyBy(View.Z, f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator leftMargin(int i) {
        if (initMarginListener()) {
            this.mMarginListener.leftMargin(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator leftMarginBy(int i) {
        if (initMarginListener()) {
            this.mMarginListener.leftMarginBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator topMargin(int i) {
        if (initMarginListener()) {
            this.mMarginListener.topMargin(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator topMarginBy(int i) {
        if (initMarginListener()) {
            this.mMarginListener.topMarginBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator rightMargin(int i) {
        if (initMarginListener()) {
            this.mMarginListener.rightMargin(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator rightMarginBy(int i) {
        if (initMarginListener()) {
            this.mMarginListener.rightMarginBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator bottomMargin(int i) {
        if (initMarginListener()) {
            this.mMarginListener.bottomMargin(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator bottomMarginBy(int i) {
        if (initMarginListener()) {
            this.mMarginListener.bottomMarginBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator horizontalMargin(int i) {
        if (initMarginListener()) {
            this.mMarginListener.horizontalMargin(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator horizontalMarginBy(int i) {
        if (initMarginListener()) {
            this.mMarginListener.horizontalMarginBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator verticalMargin(int i) {
        if (initMarginListener()) {
            this.mMarginListener.verticalMargin(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator verticalMarginBy(int i) {
        if (initMarginListener()) {
            this.mMarginListener.verticalMarginBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator margin(int i) {
        if (initMarginListener()) {
            this.mMarginListener.margin(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator marginBy(int i) {
        if (initMarginListener()) {
            this.mMarginListener.marginBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator width(int i) {
        if (initDimensionListener()) {
            this.mDimensionListener.width(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator widthBy(int i) {
        if (initDimensionListener()) {
            this.mDimensionListener.widthBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator height(int i) {
        if (initDimensionListener()) {
            this.mDimensionListener.height(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator heightBy(int i) {
        if (initDimensionListener()) {
            this.mDimensionListener.heightBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator size(int i) {
        if (initDimensionListener()) {
            this.mDimensionListener.size(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator sizeBy(int i) {
        if (initDimensionListener()) {
            this.mDimensionListener.sizeBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator leftPadding(int i) {
        if (initPaddingListener()) {
            this.mPaddingListener.leftPadding(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator leftPaddingBy(int i) {
        if (initPaddingListener()) {
            this.mPaddingListener.leftPaddingBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator topPadding(int i) {
        if (initPaddingListener()) {
            this.mPaddingListener.topPadding(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator topPaddingBy(int i) {
        if (initPaddingListener()) {
            this.mPaddingListener.topPaddingBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator rightPadding(int i) {
        if (initPaddingListener()) {
            this.mPaddingListener.rightPadding(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator rightPaddingBy(int i) {
        if (initPaddingListener()) {
            this.mPaddingListener.rightPaddingBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator bottomPadding(int i) {
        if (initPaddingListener()) {
            this.mPaddingListener.bottomPadding(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator bottomPaddingBy(int i) {
        if (initPaddingListener()) {
            this.mPaddingListener.bottomPaddingBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator horizontalPadding(int i) {
        if (initPaddingListener()) {
            this.mPaddingListener.horizontalPadding(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator horizontalPaddingBy(int i) {
        if (initPaddingListener()) {
            this.mPaddingListener.horizontalPaddingBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator verticalPadding(int i) {
        if (initPaddingListener()) {
            this.mPaddingListener.verticalPadding(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator verticalPaddingBy(int i) {
        if (initPaddingListener()) {
            this.mPaddingListener.verticalPaddingBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator padding(int i) {
        if (initPaddingListener()) {
            this.mPaddingListener.padding(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator paddingBy(int i) {
        if (initPaddingListener()) {
            this.mPaddingListener.paddingBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator scrollX(int i) {
        if (initScrollListener()) {
            this.mScrollListener.scrollX(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator scrollXBy(int i) {
        if (initScrollListener()) {
            this.mScrollListener.scrollXBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator scrollY(int i) {
        if (initScrollListener()) {
            this.mScrollListener.scrollY(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator scrollYBy(int i) {
        if (initScrollListener()) {
            this.mScrollListener.scrollYBy(i);
        }
        return this;
    }

    public ViewPropertyObjectAnimator widthPercent(float f) {
        if (initPercentListener()) {
            this.mPercentListener.widthPercent(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator widthPercentBy(float f) {
        if (initPercentListener()) {
            this.mPercentListener.widthPercentBy(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator heightPercent(float f) {
        if (initPercentListener()) {
            this.mPercentListener.heightPercent(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator heightPercentBy(float f) {
        if (initPercentListener()) {
            this.mPercentListener.heightPercentBy(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator sizePercent(float f) {
        if (initPercentListener()) {
            this.mPercentListener.sizePercent(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator sizePercentBy(float f) {
        if (initPercentListener()) {
            this.mPercentListener.sizePercentBy(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator leftMarginPercent(float f) {
        if (initPercentListener()) {
            this.mPercentListener.leftMarginPercent(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator leftMarginPercentBy(float f) {
        if (initPercentListener()) {
            this.mPercentListener.leftMarginPercentBy(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator topMarginPercent(float f) {
        if (initPercentListener()) {
            this.mPercentListener.topMarginPercent(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator topMarginPercentBy(float f) {
        if (initPercentListener()) {
            this.mPercentListener.topMarginPercentBy(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator bottomMarginPercent(float f) {
        if (initPercentListener()) {
            this.mPercentListener.bottomMarginPercent(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator bottomMarginPercentBy(float f) {
        if (initPercentListener()) {
            this.mPercentListener.bottomMarginPercentBy(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator rightMarginPercent(float f) {
        if (initPercentListener()) {
            this.mPercentListener.rightMarginPercent(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator rightMarginPercentBy(float f) {
        if (initPercentListener()) {
            this.mPercentListener.rightMarginPercentBy(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator horizontalMarginPercent(float f) {
        if (initPercentListener()) {
            this.mPercentListener.horizontalMarginPercent(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator horizontalMarginPercentBy(float f) {
        if (initPercentListener()) {
            this.mPercentListener.horizontalMarginPercentBy(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator verticalMarginPercent(float f) {
        if (initPercentListener()) {
            this.mPercentListener.verticalMarginPercent(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator verticalMarginPercentBy(float f) {
        if (initPercentListener()) {
            this.mPercentListener.verticalMarginPercentBy(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator marginPercent(float f) {
        if (initPercentListener()) {
            this.mPercentListener.marginPercent(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator marginPercentBy(float f) {
        if (initPercentListener()) {
            this.mPercentListener.marginPercentBy(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator aspectRatio(float f) {
        if (initPercentListener()) {
            this.mPercentListener.aspectRatio(f);
        }
        return this;
    }

    public ViewPropertyObjectAnimator aspectRatioBy(float f) {
        if (initPercentListener()) {
            this.mPercentListener.aspectRatioBy(f);
        }
        return this;
    }

    private boolean initMarginListener() {
        if (this.mMarginListener != null) {
            return true;
        }
        if (!hasView()) {
            return false;
        }
        this.mMarginListener = new MarginChangeListener((View) this.mView.get());
        return true;
    }

    private boolean initDimensionListener() {
        if (this.mDimensionListener != null) {
            return true;
        }
        if (!hasView()) {
            return false;
        }
        this.mDimensionListener = new DimensionChangeListener((View) this.mView.get());
        return true;
    }

    private boolean initPaddingListener() {
        if (this.mPaddingListener != null) {
            return true;
        }
        if (!hasView()) {
            return false;
        }
        this.mPaddingListener = new PaddingChangeListener((View) this.mView.get());
        return true;
    }

    private boolean initScrollListener() {
        if (this.mScrollListener != null) {
            return true;
        }
        if (!hasView()) {
            return false;
        }
        this.mScrollListener = new ScrollChangeListener((View) this.mView.get());
        return true;
    }

    private boolean initPercentListener() {
        if (this.mPercentListener != null) {
            return true;
        }
        if (!hasView()) {
            return false;
        }
        this.mPercentListener = new PercentChangeListener((View) this.mView.get());
        return true;
    }

    public ViewPropertyObjectAnimator withLayer() {
        this.mWithLayer = true;
        return this;
    }

    public ViewPropertyObjectAnimator setStartDelay(long j) {
        if (j >= 0) {
            this.mStartDelay = j;
            return this;
        }
        throw new IllegalArgumentException("startDelay cannot be < 0");
    }

    public ViewPropertyObjectAnimator setDuration(long j) {
        if (j >= 0) {
            this.mDuration = j;
            return this;
        }
        throw new IllegalArgumentException("duration cannot be < 0");
    }

    public ViewPropertyObjectAnimator setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
        return this;
    }

    public ViewPropertyObjectAnimator addListener(Animator.AnimatorListener animatorListener) {
        this.mListeners.add(animatorListener);
        return this;
    }

    public ViewPropertyObjectAnimator removeListener(Animator.AnimatorListener animatorListener) {
        this.mListeners.remove(animatorListener);
        return this;
    }

    public ViewPropertyObjectAnimator removeAllListeners() {
        this.mListeners.clear();
        return this;
    }

    public ViewPropertyObjectAnimator addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mUpdateListeners.add(animatorUpdateListener);
        return this;
    }

    public ViewPropertyObjectAnimator removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mUpdateListeners.remove(animatorUpdateListener);
        return this;
    }

    public ViewPropertyObjectAnimator removeAllUpdateListeners() {
        this.mUpdateListeners.clear();
        return this;
    }

    public ViewPropertyObjectAnimator addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.mPauseListeners.add(animatorPauseListener);
        }
        return this;
    }

    public ViewPropertyObjectAnimator removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.mPauseListeners.remove(animatorPauseListener);
        }
        return this;
    }

    public ViewPropertyObjectAnimator removeAllPauseListeners() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.mPauseListeners.clear();
        }
        return this;
    }

    public ViewPropertyObjectAnimator withStartAction(final Runnable runnable) {
        return addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                runnable.run();
                ViewPropertyObjectAnimator.this.removeListener(this);
            }
        });
    }

    public ViewPropertyObjectAnimator withEndAction(final Runnable runnable) {
        return addListener(new AnimatorListenerAdapter() {
            private boolean mIsCanceled;

            public void onAnimationCancel(Animator animator) {
                this.mIsCanceled = true;
            }

            public void onAnimationEnd(Animator animator) {
                if (!this.mIsCanceled) {
                    runnable.run();
                }
                ViewPropertyObjectAnimator.this.removeListener(this);
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean hasView() {
        return this.mView.get() != null;
    }

    public ObjectAnimator get() {
        if (!hasView()) {
            return ObjectAnimator.ofFloat((Object) null, View.ALPHA, new float[]{1.0f, 1.0f});
        }
        Collection<PropertyValuesHolder> values = this.mPropertyHoldersMap.values();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mView.get(), (PropertyValuesHolder[]) values.toArray(new PropertyValuesHolder[values.size()]));
        if (this.mWithLayer) {
            ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                int mCurrentLayerType = 0;

                public void onAnimationStart(Animator animator) {
                    if (ViewPropertyObjectAnimator.this.hasView()) {
                        View view = (View) ViewPropertyObjectAnimator.this.mView.get();
                        this.mCurrentLayerType = view.getLayerType();
                        view.setLayerType(2, (Paint) null);
                        if (ViewCompat.isAttachedToWindow(view)) {
                            view.buildLayer();
                        }
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (ViewPropertyObjectAnimator.this.hasView()) {
                        ((View) ViewPropertyObjectAnimator.this.mView.get()).setLayerType(this.mCurrentLayerType, (Paint) null);
                    }
                }
            });
        }
        long j = this.mStartDelay;
        if (j != -1) {
            ofPropertyValuesHolder.setStartDelay(j);
        }
        long j2 = this.mDuration;
        if (j2 != -1) {
            ofPropertyValuesHolder.setDuration(j2);
        }
        Interpolator interpolator = this.mInterpolator;
        if (interpolator != null) {
            ofPropertyValuesHolder.setInterpolator(interpolator);
        }
        for (Animator.AnimatorListener addListener : this.mListeners) {
            ofPropertyValuesHolder.addListener(addListener);
        }
        MarginChangeListener marginChangeListener = this.mMarginListener;
        if (marginChangeListener != null) {
            ofPropertyValuesHolder.addUpdateListener(marginChangeListener);
        }
        DimensionChangeListener dimensionChangeListener = this.mDimensionListener;
        if (dimensionChangeListener != null) {
            ofPropertyValuesHolder.addUpdateListener(dimensionChangeListener);
        }
        PaddingChangeListener paddingChangeListener = this.mPaddingListener;
        if (paddingChangeListener != null) {
            ofPropertyValuesHolder.addUpdateListener(paddingChangeListener);
        }
        ScrollChangeListener scrollChangeListener = this.mScrollListener;
        if (scrollChangeListener != null) {
            ofPropertyValuesHolder.addUpdateListener(scrollChangeListener);
        }
        PercentChangeListener percentChangeListener = this.mPercentListener;
        if (percentChangeListener != null) {
            ofPropertyValuesHolder.addUpdateListener(percentChangeListener);
        }
        for (ValueAnimator.AnimatorUpdateListener addUpdateListener : this.mUpdateListeners) {
            ofPropertyValuesHolder.addUpdateListener(addUpdateListener);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Animator.AnimatorPauseListener addPauseListener : this.mPauseListeners) {
                ofPropertyValuesHolder.addPauseListener(addPauseListener);
            }
        }
        return ofPropertyValuesHolder;
    }

    public void start() {
        get().start();
    }
}
