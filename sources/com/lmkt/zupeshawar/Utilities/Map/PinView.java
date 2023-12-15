package com.lmkt.zupeshawar.Utilities.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.Map.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;

public class PinView extends SubsamplingScaleImageView {
    private ArrayList<PointF> mPins;
    private Bitmap pin;
    private PointF sPin;

    public PinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialise();
    }

    public void setPins(ArrayList<PointF> arrayList) {
        this.mPins = arrayList;
        initialise();
        invalidate();
    }

    public void setPin(PointF pointF) {
        this.sPin = pointF;
        initialise();
        invalidate();
    }

    public PointF getPin() {
        return this.sPin;
    }

    private void initialise() {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.pin_icon);
        this.pin = decodeResource;
        float f = ((float) getResources().getDisplayMetrics().densityDpi) / 150.0f;
        this.pin = Bitmap.createScaledBitmap(this.pin, (int) (((float) (decodeResource.getWidth() / 3)) * f), (int) (f * ((float) (this.pin.getHeight() / 3))), true);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isReady()) {
            Log.e("PinView", "Image is not ready");
            return;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        PointF pointF = this.sPin;
        if (pointF != null && this.pin != null) {
            PointF sourceToViewCoord = sourceToViewCoord(pointF);
            canvas.drawBitmap(this.pin, sourceToViewCoord.x - ((float) (this.pin.getWidth() / 2)), sourceToViewCoord.y - ((float) this.pin.getHeight()), paint);
        }
    }
}
