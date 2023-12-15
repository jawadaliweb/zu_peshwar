package com.richpathanimator;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.Key;
import com.richpath.RichPath;
import com.richpath.pathparser.PathDataNode;
import com.richpath.pathparser.PathParserCompat;
import java.util.ArrayList;
import java.util.List;

public class AnimationBuilder {
    private static final long DEFAULT_DURATION = 300;
    private static final long DEFAULT_START_DELAY = 0;
    private final List<ValueAnimator> animators = new ArrayList();
    private long duration = DEFAULT_DURATION;
    private Interpolator interpolator;
    private final RichPath[] paths;
    private int repeatCount = 0;
    private int repeatMode = 1;
    private final RichPathAnimator richPathAnimator;
    private long startDelay = 0;

    public AnimationBuilder(RichPathAnimator richPathAnimator2, RichPath... richPathArr) {
        this.richPathAnimator = richPathAnimator2;
        this.paths = richPathArr;
    }

    private void property(String str, float... fArr) {
        for (RichPath richPath : this.paths) {
            applyAnimatorProperties(ObjectAnimator.ofFloat(richPath, str, fArr), richPath);
        }
    }

    public AnimationBuilder andAnimate(RichPath... richPathArr) {
        return this.richPathAnimator.addAnimationBuilder(richPathArr);
    }

    public AnimationBuilder thenAnimate(RichPath... richPathArr) {
        return this.richPathAnimator.thenAnimate(richPathArr);
    }

    public AnimationBuilder custom(final AnimationUpdateListener animationUpdateListener, float... fArr) {
        for (final RichPath richPath : this.paths) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RichPath richPath = richPath;
                    if (richPath != null) {
                        AnimationUpdateListener animationUpdateListener = animationUpdateListener;
                        if (animationUpdateListener != null) {
                            animationUpdateListener.update(richPath, ((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                        if (richPath.getOnRichPathUpdatedListener() != null) {
                            richPath.getOnRichPathUpdatedListener().onPathUpdated();
                        }
                    }
                }
            });
            applyAnimatorProperties(ofFloat, richPath);
        }
        return this;
    }

    public RichPathAnimator start() {
        this.richPathAnimator.start();
        return this.richPathAnimator;
    }

    /* access modifiers changed from: package-private */
    public List<ValueAnimator> getAnimators() {
        return this.animators;
    }

    public AnimationBuilder duration(long j) {
        this.duration = j;
        for (ValueAnimator duration2 : this.animators) {
            duration2.setDuration(j);
        }
        return this;
    }

    public AnimationBuilder durationSet(long j) {
        this.richPathAnimator.duration(j);
        return this;
    }

    public AnimationBuilder startDelay(long j) {
        this.startDelay = j;
        for (ValueAnimator startDelay2 : this.animators) {
            startDelay2.setStartDelay(j);
        }
        return this;
    }

    public AnimationBuilder startDelaySet(long j) {
        this.richPathAnimator.startDelay(j);
        return this;
    }

    public AnimationBuilder interpolator(Interpolator interpolator2) {
        this.interpolator = interpolator2;
        for (ValueAnimator interpolator3 : this.animators) {
            interpolator3.setInterpolator(interpolator2);
        }
        return this;
    }

    public AnimationBuilder interpolatorSet(Interpolator interpolator2) {
        this.richPathAnimator.interpolator(interpolator2);
        return this;
    }

    public AnimationBuilder repeatMode(int i) {
        this.repeatMode = i;
        for (ValueAnimator repeatMode2 : this.animators) {
            repeatMode2.setRepeatMode(i);
        }
        return this;
    }

    public AnimationBuilder repeatModeSet(int i) {
        this.richPathAnimator.repeatMode(i);
        return this;
    }

    public AnimationBuilder repeatCount(int i) {
        this.repeatCount = i;
        for (ValueAnimator repeatCount2 : this.animators) {
            repeatCount2.setRepeatCount(i);
        }
        return this;
    }

    public AnimationBuilder repeatCountSet(int i) {
        this.richPathAnimator.repeatCount(i);
        return this;
    }

    public AnimationBuilder fillColor(int... iArr) {
        color("fillColor", iArr);
        return this;
    }

    public AnimationBuilder strokeColor(int... iArr) {
        color("strokeColor", iArr);
        return this;
    }

    private AnimationBuilder color(String str, int... iArr) {
        for (RichPath richPath : this.paths) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(richPath, str, iArr);
            ofInt.setEvaluator(new ArgbEvaluator());
            applyAnimatorProperties(ofInt, richPath);
        }
        return this;
    }

    public AnimationBuilder pathData(String... strArr) {
        PathDataNode[][] pathDataNodeArr = new PathDataNode[strArr.length][];
        for (int i = 0; i < strArr.length; i++) {
            pathDataNodeArr[i] = PathParserCompat.createNodesFromPathData(strArr[i]);
        }
        if (!PathParserCompat.canMorph(pathDataNodeArr)) {
            Log.w("RichPathAnimator", "the paths aren't compatible for morphing. The paths should have exact same length of commands, and exact same length of parameters for each command");
            return this;
        }
        for (RichPath richPath : this.paths) {
            applyAnimatorProperties(ObjectAnimator.ofObject(richPath, "pathDataNodes", new PathEvaluator(), pathDataNodeArr), richPath);
        }
        return this;
    }

    private void applyAnimatorProperties(ValueAnimator valueAnimator, RichPath richPath) {
        if (richPath != null) {
            valueAnimator.setDuration(this.duration);
            valueAnimator.setStartDelay(this.startDelay);
            valueAnimator.setRepeatMode(this.repeatMode);
            valueAnimator.setRepeatCount(this.repeatCount);
            Interpolator interpolator2 = this.interpolator;
            if (interpolator2 != null) {
                valueAnimator.setInterpolator(interpolator2);
            }
            this.animators.add(valueAnimator);
        }
    }

    public AnimationBuilder strokeAlpha(float... fArr) {
        property("strokeAlpha", fArr);
        return this;
    }

    public AnimationBuilder fillAlpha(float... fArr) {
        property("fillAlpha", fArr);
        return this;
    }

    public AnimationBuilder size(float f, float f2) {
        property("width", f);
        property("height", f2);
        return this;
    }

    public AnimationBuilder scaleX(float... fArr) {
        property("scaleX", fArr);
        return this;
    }

    public AnimationBuilder scaleY(float... fArr) {
        property("scaleY", fArr);
        return this;
    }

    public AnimationBuilder scale(float... fArr) {
        scaleX(fArr);
        scaleY(fArr);
        return this;
    }

    public AnimationBuilder width(float... fArr) {
        property("width", fArr);
        return this;
    }

    public AnimationBuilder height(float... fArr) {
        property("height", fArr);
        return this;
    }

    public AnimationBuilder rotation(float... fArr) {
        property(Key.ROTATION, fArr);
        return this;
    }

    public AnimationBuilder translationY(float... fArr) {
        property("translationY", fArr);
        return this;
    }

    public AnimationBuilder translationX(float... fArr) {
        property("translationX", fArr);
        return this;
    }

    public AnimationBuilder trimPathStart(float... fArr) {
        property("trimPathStart", fArr);
        return this;
    }

    public AnimationBuilder trimPathEnd(float... fArr) {
        property("trimPathEnd", fArr);
        return this;
    }

    public AnimationBuilder trimPathOffset(float... fArr) {
        property("trimPathOffset", fArr);
        return this;
    }

    public AnimationBuilder animationListener(AnimationListener animationListener) {
        this.richPathAnimator.setAnimationListener(animationListener);
        return this;
    }
}
