package androidx.constraintlayout.core.motion.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    public abstract double getPos(double d, int i);

    public abstract void getPos(double d, double[] dArr);

    public abstract void getPos(double d, float[] fArr);

    public abstract double getSlope(double d, int i);

    public abstract void getSlope(double d, double[] dArr);

    public abstract double[] getTimePoints();

    public static CurveFit get(int i, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i = 2;
        }
        if (i == 0) {
            return new MonotonicCurveFit(dArr, dArr2);
        }
        if (i != 2) {
            return new LinearCurveFit(dArr, dArr2);
        }
        return new Constant(dArr[0], dArr2[0]);
    }

    public static CurveFit getArc(int[] iArr, double[] dArr, double[][] dArr2) {
        return new ArcCurveFit(iArr, dArr, dArr2);
    }

    static class Constant extends CurveFit {
        double mTime;
        double[] mValue;

        public double getSlope(double d, int i) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        Constant(double d, double[] dArr) {
            this.mTime = d;
            this.mValue = dArr;
        }

        public void getPos(double d, double[] dArr) {
            double[] dArr2 = this.mValue;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        public void getPos(double d, float[] fArr) {
            int i = 0;
            while (true) {
                double[] dArr = this.mValue;
                if (i < dArr.length) {
                    fArr[i] = (float) dArr[i];
                    i++;
                } else {
                    return;
                }
            }
        }

        public double getPos(double d, int i) {
            return this.mValue[i];
        }

        public void getSlope(double d, double[] dArr) {
            for (int i = 0; i < this.mValue.length; i++) {
                dArr[i] = 0.0d;
            }
        }

        public double[] getTimePoints() {
            return new double[]{this.mTime};
        }
    }
}
