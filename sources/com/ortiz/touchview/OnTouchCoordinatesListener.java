package com.ortiz.touchview;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/ortiz/touchview/OnTouchCoordinatesListener;", "", "onTouchCoordinate", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "bitmapPoint", "Landroid/graphics/PointF;", "touchview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OnTouchCoordinatesListener.kt */
public interface OnTouchCoordinatesListener {
    void onTouchCoordinate(View view, MotionEvent motionEvent, PointF pointF);
}
