package androidx.constraintlayout.core.motion.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;

public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    public HyperSpline() {
    }

    public void setup(double[][] dArr) {
        int i;
        int length = dArr[0].length;
        this.mDimensionality = length;
        int length2 = dArr.length;
        this.mPoints = length2;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = length;
        this.mCtl = (double[][]) Array.newInstance(double.class, iArr);
        this.mCurve = new Cubic[this.mDimensionality][];
        for (int i2 = 0; i2 < this.mDimensionality; i2++) {
            for (int i3 = 0; i3 < this.mPoints; i3++) {
                this.mCtl[i2][i3] = dArr[i3][i2];
            }
        }
        int i4 = 0;
        while (true) {
            i = this.mDimensionality;
            if (i4 >= i) {
                break;
            }
            Cubic[][] cubicArr = this.mCurve;
            double[][] dArr2 = this.mCtl;
            cubicArr[i4] = calcNaturalCubic(dArr2[i4].length, dArr2[i4]);
            i4++;
        }
        this.mCurveLength = new double[(this.mPoints - 1)];
        this.mTotalLength = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        Cubic[] cubicArr2 = new Cubic[i];
        for (int i5 = 0; i5 < this.mCurveLength.length; i5++) {
            for (int i6 = 0; i6 < this.mDimensionality; i6++) {
                cubicArr2[i6] = this.mCurve[i6][i5];
            }
            double d = this.mTotalLength;
            double[] dArr3 = this.mCurveLength;
            double approxLength = approxLength(cubicArr2);
            dArr3[i5] = approxLength;
            this.mTotalLength = d + approxLength;
        }
    }

    public void getVelocity(double d, double[] dArr) {
        double d2 = d * this.mTotalLength;
        int i = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i < dArr2.length - 1 && dArr2[i] < d2) {
                d2 -= dArr2[i];
                i++;
            }
        }
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr[i2] = this.mCurve[i2][i].vel(d2 / this.mCurveLength[i]);
        }
    }

    public void getPos(double d, double[] dArr) {
        double d2 = d * this.mTotalLength;
        int i = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i < dArr2.length - 1 && dArr2[i] < d2) {
                d2 -= dArr2[i];
                i++;
            }
        }
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr[i2] = this.mCurve[i2][i].eval(d2 / this.mCurveLength[i]);
        }
    }

    public void getPos(double d, float[] fArr) {
        double d2 = d * this.mTotalLength;
        int i = 0;
        while (true) {
            double[] dArr = this.mCurveLength;
            if (i < dArr.length - 1 && dArr[i] < d2) {
                d2 -= dArr[i];
                i++;
            }
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = (float) this.mCurve[i2][i].eval(d2 / this.mCurveLength[i]);
        }
    }

    public double getPos(double d, int i) {
        double[] dArr;
        double d2 = d * this.mTotalLength;
        int i2 = 0;
        while (true) {
            dArr = this.mCurveLength;
            if (i2 < dArr.length - 1 && dArr[i2] < d2) {
                d2 -= dArr[i2];
                i2++;
            }
        }
        return this.mCurve[i][i2].eval(d2 / dArr[i2]);
    }

    public double approxLength(Cubic[] cubicArr) {
        int i;
        int length = cubicArr.length;
        double[] dArr = new double[cubicArr.length];
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d2 = 0.0d;
        double d3 = 0.0d;
        while (true) {
            i = 0;
            if (d2 >= 1.0d) {
                break;
            }
            double d4 = 0.0d;
            while (i < cubicArr.length) {
                double d5 = dArr[i];
                double eval = cubicArr[i].eval(d2);
                dArr[i] = eval;
                double d6 = d5 - eval;
                d4 += d6 * d6;
                i++;
            }
            if (d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d3 += Math.sqrt(d4);
            }
            d2 += 0.1d;
        }
        while (i < cubicArr.length) {
            double d7 = dArr[i];
            double eval2 = cubicArr[i].eval(1.0d);
            dArr[i] = eval2;
            double d8 = d7 - eval2;
            d += d8 * d8;
            i++;
        }
        return d3 + Math.sqrt(d);
    }

    static Cubic[] calcNaturalCubic(int i, double[] dArr) {
        int i2 = i;
        double[] dArr2 = new double[i2];
        double[] dArr3 = new double[i2];
        double[] dArr4 = new double[i2];
        int i3 = i2 - 1;
        int i4 = 0;
        dArr2[0] = 0.5d;
        int i5 = 1;
        for (int i6 = 1; i6 < i3; i6++) {
            dArr2[i6] = 1.0d / (4.0d - dArr2[i6 - 1]);
        }
        int i7 = i3 - 1;
        dArr2[i3] = 1.0d / (2.0d - dArr2[i7]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i5 < i3) {
            int i8 = i5 + 1;
            int i9 = i5 - 1;
            dArr3[i5] = (((dArr[i8] - dArr[i9]) * 3.0d) - dArr3[i9]) * dArr2[i5];
            i5 = i8;
        }
        dArr3[i3] = (((dArr[i3] - dArr[i7]) * 3.0d) - dArr3[i7]) * dArr2[i3];
        dArr4[i3] = dArr3[i3];
        while (i7 >= 0) {
            dArr4[i7] = dArr3[i7] - (dArr2[i7] * dArr4[i7 + 1]);
            i7--;
        }
        Cubic[] cubicArr = new Cubic[i3];
        while (i4 < i3) {
            int i10 = i4 + 1;
            cubicArr[i4] = new Cubic((double) ((float) dArr[i4]), dArr4[i4], (((dArr[i10] - dArr[i4]) * 3.0d) - (dArr4[i4] * 2.0d)) - dArr4[i10], ((dArr[i4] - dArr[i10]) * 2.0d) + dArr4[i4] + dArr4[i10]);
            i4 = i10;
        }
        return cubicArr;
    }

    public static class Cubic {
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double d, double d2, double d3, double d4) {
            this.mA = d;
            this.mB = d2;
            this.mC = d3;
            this.mD = d4;
        }

        public double eval(double d) {
            return (((((this.mD * d) + this.mC) * d) + this.mB) * d) + this.mA;
        }

        public double vel(double d) {
            return (((this.mD * 3.0d * d) + (this.mC * 2.0d)) * d) + this.mB;
        }
    }
}
