package com.richpathanimator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.animation.Interpolator;
import com.richpath.RichPath;
import java.util.ArrayList;
import java.util.List;

public class RichPathAnimator {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private List<AnimationBuilder> animationBuilders = new ArrayList();
    /* access modifiers changed from: private */
    public AnimationListener animationListener;
    private AnimatorSet animatorSet;
    private long duration = -1;
    private Interpolator interpolator;
    /* access modifiers changed from: private */
    public RichPathAnimator next;
    /* access modifiers changed from: private */
    public RichPathAnimator prev;
    private int repeatCount = -2;
    private int repeatMode = -2;
    private long startDelay = -1;

    public @interface RepeatMode {
    }

    private RichPathAnimator() {
    }

    /* access modifiers changed from: package-private */
    public AnimationBuilder addAnimationBuilder(RichPath... richPathArr) {
        AnimationBuilder animationBuilder = new AnimationBuilder(this, richPathArr);
        this.animationBuilders.add(animationBuilder);
        return animationBuilder;
    }

    public static AnimationBuilder animate(RichPath... richPathArr) {
        return new RichPathAnimator().addAnimationBuilder(richPathArr);
    }

    /* access modifiers changed from: package-private */
    public AnimationBuilder thenAnimate(RichPath... richPathArr) {
        RichPathAnimator richPathAnimator = new RichPathAnimator();
        this.next = richPathAnimator;
        richPathAnimator.prev = this;
        return richPathAnimator.addAnimationBuilder(richPathArr);
    }

    private AnimatorSet createAnimatorSet() {
        ArrayList arrayList = new ArrayList();
        for (AnimationBuilder next2 : this.animationBuilders) {
            arrayList.addAll(next2.getAnimators());
            int i = this.repeatMode;
            if (i != -2) {
                next2.repeatMode(i);
            }
            int i2 = this.repeatCount;
            if (i2 != -2) {
                next2.repeatCount(i2);
            }
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(arrayList);
        long j = this.duration;
        if (j != -1) {
            animatorSet2.setDuration(j);
        }
        long j2 = this.startDelay;
        if (j2 != -1) {
            animatorSet2.setStartDelay(j2);
        }
        Interpolator interpolator2 = this.interpolator;
        if (interpolator2 != null) {
            animatorSet2.setInterpolator(interpolator2);
        }
        animatorSet2.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                if (RichPathAnimator.this.animationListener != null) {
                    RichPathAnimator.this.animationListener.onStart();
                }
            }

            public void onAnimationEnd(Animator animator) {
                if (RichPathAnimator.this.animationListener != null) {
                    RichPathAnimator.this.animationListener.onStop();
                }
                if (RichPathAnimator.this.next != null) {
                    RichPathAnimator unused = RichPathAnimator.this.next.prev = null;
                    RichPathAnimator.this.next.start();
                }
            }
        });
        return animatorSet2;
    }

    /* access modifiers changed from: package-private */
    public RichPathAnimator start() {
        RichPathAnimator richPathAnimator = this.prev;
        if (richPathAnimator != null) {
            richPathAnimator.start();
        } else {
            AnimatorSet createAnimatorSet = createAnimatorSet();
            this.animatorSet = createAnimatorSet;
            createAnimatorSet.start();
        }
        return this;
    }

    public void cancel() {
        AnimatorSet animatorSet2 = this.animatorSet;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        RichPathAnimator richPathAnimator = this.next;
        if (richPathAnimator != null) {
            richPathAnimator.cancel();
            this.next = null;
        }
    }

    /* access modifiers changed from: package-private */
    public RichPathAnimator duration(long j) {
        this.duration = j;
        return this;
    }

    /* access modifiers changed from: package-private */
    public RichPathAnimator startDelay(long j) {
        this.startDelay = j;
        return this;
    }

    /* access modifiers changed from: package-private */
    public RichPathAnimator interpolator(Interpolator interpolator2) {
        this.interpolator = interpolator2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public RichPathAnimator repeatMode(int i) {
        this.repeatMode = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    public RichPathAnimator repeatCount(int i) {
        this.repeatCount = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void setAnimationListener(AnimationListener animationListener2) {
        this.animationListener = animationListener2;
    }
}
