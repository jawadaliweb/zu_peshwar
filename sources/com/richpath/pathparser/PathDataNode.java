package com.richpath.pathparser;

import android.graphics.Path;
import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class PathDataNode {
    private static final String LOGTAG = "PathDataNode";
    float[] params;
    char type;

    PathDataNode(char c, float[] fArr) {
        this.type = c;
        this.params = fArr;
    }

    PathDataNode(PathDataNode pathDataNode) {
        this.type = pathDataNode.type;
        float[] fArr = pathDataNode.params;
        this.params = PathParserCompat.copyOfRange(fArr, 0, fArr.length);
    }

    public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
        float[] fArr = new float[6];
        char c = 'm';
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            addCommand(path, fArr, c, pathDataNodeArr[i].type, pathDataNodeArr[i].params);
            c = pathDataNodeArr[i].type;
        }
    }

    public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
        int i = 0;
        while (true) {
            float[] fArr = pathDataNode.params;
            if (i < fArr.length) {
                this.params[i] = (fArr[i] * (1.0f - f)) + (pathDataNode2.params[i] * f);
                i++;
            } else {
                return;
            }
        }
    }

    private static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
        int i;
        int i2;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        Path path2 = path;
        char c3 = c2;
        float[] fArr3 = fArr2;
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = fArr[2];
        float f14 = fArr[3];
        float f15 = fArr[4];
        float f16 = fArr[5];
        switch (c3) {
            case 'A':
            case 'a':
                i = 7;
                break;
            case 'C':
            case 'c':
                i = 6;
                break;
            case 'H':
            case 'V':
            case 'h':
            case 'v':
                i = 1;
                break;
            case 'Q':
            case 'S':
            case 'q':
            case 's':
                i = 4;
                break;
            case 'Z':
            case 'z':
                path.close();
                path2.moveTo(f15, f16);
                f11 = f15;
                f13 = f11;
                f12 = f16;
                f14 = f12;
                break;
        }
        i = 2;
        float f17 = f11;
        float f18 = f12;
        float f19 = f15;
        float f20 = f16;
        int i3 = 0;
        char c4 = c;
        while (i3 < fArr3.length) {
            if (c3 != 'A') {
                if (c3 == 'C') {
                    i2 = i3;
                    int i4 = i2 + 2;
                    int i5 = i2 + 3;
                    int i6 = i2 + 4;
                    int i7 = i2 + 5;
                    path.cubicTo(fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i4], fArr3[i5], fArr3[i6], fArr3[i7]);
                    f17 = fArr3[i6];
                    float f21 = fArr3[i7];
                    float f22 = fArr3[i4];
                    float f23 = fArr3[i5];
                    f18 = f21;
                    f14 = f23;
                    f13 = f22;
                } else if (c3 == 'H') {
                    i2 = i3;
                    int i8 = i2 + 0;
                    path2.lineTo(fArr3[i8], f18);
                    f17 = fArr3[i8];
                } else if (c3 == 'Q') {
                    i2 = i3;
                    int i9 = i2 + 0;
                    int i10 = i2 + 1;
                    int i11 = i2 + 2;
                    int i12 = i2 + 3;
                    path2.quadTo(fArr3[i9], fArr3[i10], fArr3[i11], fArr3[i12]);
                    float f24 = fArr3[i9];
                    float f25 = fArr3[i10];
                    f17 = fArr3[i11];
                    f18 = fArr3[i12];
                    f13 = f24;
                    f14 = f25;
                } else if (c3 == 'V') {
                    i2 = i3;
                    int i13 = i2 + 0;
                    path2.lineTo(f17, fArr3[i13]);
                    f18 = fArr3[i13];
                } else if (c3 != 'a') {
                    if (c3 == 'c') {
                        int i14 = i3 + 2;
                        int i15 = i3 + 3;
                        int i16 = i3 + 4;
                        int i17 = i3 + 5;
                        path.rCubicTo(fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i14], fArr3[i15], fArr3[i16], fArr3[i17]);
                        f4 = fArr3[i14] + f17;
                        f3 = fArr3[i15] + f18;
                        f17 += fArr3[i16];
                        f5 = fArr3[i17];
                        f18 += f5;
                        f13 = f4;
                        f14 = f3;
                    } else if (c3 != 'h') {
                        if (c3 != 'q') {
                            if (c3 == 'v') {
                                int i18 = i3 + 0;
                                path2.rLineTo(0.0f, fArr3[i18]);
                                f6 = fArr3[i18];
                            } else if (c3 != 'L') {
                                if (c3 == 'M') {
                                    int i19 = i3 + 0;
                                    f17 = fArr3[i19];
                                    int i20 = i3 + 1;
                                    f18 = fArr3[i20];
                                    if (i3 > 0) {
                                        path2.lineTo(fArr3[i19], fArr3[i20]);
                                    } else {
                                        path2.moveTo(fArr3[i19], fArr3[i20]);
                                    }
                                } else if (c3 == 'S') {
                                    if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                        f17 = (f17 * 2.0f) - f13;
                                        f18 = (f18 * 2.0f) - f14;
                                    }
                                    float f26 = f18;
                                    int i21 = i3 + 0;
                                    int i22 = i3 + 1;
                                    int i23 = i3 + 2;
                                    int i24 = i3 + 3;
                                    path.cubicTo(f17, f26, fArr3[i21], fArr3[i22], fArr3[i23], fArr3[i24]);
                                    f4 = fArr3[i21];
                                    f3 = fArr3[i22];
                                    f17 = fArr3[i23];
                                    f18 = fArr3[i24];
                                    f13 = f4;
                                    f14 = f3;
                                } else if (c3 == 'T') {
                                    if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                        f17 = (f17 * 2.0f) - f13;
                                        f18 = (f18 * 2.0f) - f14;
                                    }
                                    int i25 = i3 + 0;
                                    int i26 = i3 + 1;
                                    path2.quadTo(f17, f18, fArr3[i25], fArr3[i26]);
                                    float f27 = fArr3[i25];
                                    float f28 = fArr3[i26];
                                    i2 = i3;
                                    f14 = f18;
                                    f13 = f17;
                                    f17 = f27;
                                    f18 = f28;
                                } else if (c3 == 'l') {
                                    int i27 = i3 + 0;
                                    int i28 = i3 + 1;
                                    path2.rLineTo(fArr3[i27], fArr3[i28]);
                                    f17 += fArr3[i27];
                                    f6 = fArr3[i28];
                                } else if (c3 == 'm') {
                                    int i29 = i3 + 0;
                                    f17 += fArr3[i29];
                                    int i30 = i3 + 1;
                                    f18 += fArr3[i30];
                                    if (i3 > 0) {
                                        path2.rLineTo(fArr3[i29], fArr3[i30]);
                                    } else {
                                        path2.rMoveTo(fArr3[i29], fArr3[i30]);
                                    }
                                } else if (c3 == 's') {
                                    if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                        float f29 = f17 - f13;
                                        f7 = f18 - f14;
                                        f8 = f29;
                                    } else {
                                        f8 = 0.0f;
                                        f7 = 0.0f;
                                    }
                                    int i31 = i3 + 0;
                                    int i32 = i3 + 1;
                                    int i33 = i3 + 2;
                                    int i34 = i3 + 3;
                                    path.rCubicTo(f8, f7, fArr3[i31], fArr3[i32], fArr3[i33], fArr3[i34]);
                                    f4 = fArr3[i31] + f17;
                                    f3 = fArr3[i32] + f18;
                                    f17 += fArr3[i33];
                                    f5 = fArr3[i34];
                                } else if (c3 == 't') {
                                    if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                        f9 = f17 - f13;
                                        f10 = f18 - f14;
                                    } else {
                                        f10 = 0.0f;
                                        f9 = 0;
                                    }
                                    int i35 = i3 + 0;
                                    int i36 = i3 + 1;
                                    path2.rQuadTo(f9, f10, fArr3[i35], fArr3[i36]);
                                    float f30 = f9 + f17;
                                    float f31 = f10 + f18;
                                    f17 += fArr3[i35];
                                    f18 += fArr3[i36];
                                    f14 = f31;
                                    f13 = f30;
                                }
                                i2 = i3;
                                f20 = f18;
                                f19 = f17;
                            } else {
                                int i37 = i3 + 0;
                                int i38 = i3 + 1;
                                path2.lineTo(fArr3[i37], fArr3[i38]);
                                f17 = fArr3[i37];
                                f18 = fArr3[i38];
                            }
                            f18 += f6;
                        } else {
                            int i39 = i3 + 0;
                            int i40 = i3 + 1;
                            int i41 = i3 + 2;
                            int i42 = i3 + 3;
                            path2.rQuadTo(fArr3[i39], fArr3[i40], fArr3[i41], fArr3[i42]);
                            f4 = fArr3[i39] + f17;
                            f3 = fArr3[i40] + f18;
                            f17 += fArr3[i41];
                            f5 = fArr3[i42];
                        }
                        f18 += f5;
                        f13 = f4;
                        f14 = f3;
                    } else {
                        int i43 = i3 + 0;
                        path2.rLineTo(fArr3[i43], 0.0f);
                        f17 += fArr3[i43];
                    }
                    i2 = i3;
                } else {
                    int i44 = i3 + 5;
                    int i45 = i3 + 6;
                    i2 = i3;
                    drawArc(path, f17, f18, fArr3[i44] + f17, fArr3[i45] + f18, fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i3 + 2], fArr3[i3 + 3] != 0.0f, fArr3[i3 + 4] != 0.0f);
                    f = f17 + fArr3[i44];
                    f2 = f18 + fArr3[i45];
                }
                i3 = i2 + i;
                c4 = c2;
                c3 = c4;
            } else {
                i2 = i3;
                int i46 = i2 + 5;
                int i47 = i2 + 6;
                drawArc(path, f17, f18, fArr3[i46], fArr3[i47], fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i2 + 2], fArr3[i2 + 3] != 0.0f, fArr3[i2 + 4] != 0.0f);
                f = fArr3[i46];
                f2 = fArr3[i47];
            }
            f14 = f18;
            f13 = f17;
            i3 = i2 + i;
            c4 = c2;
            c3 = c4;
        }
        fArr[0] = f17;
        fArr[1] = f18;
        fArr[2] = f13;
        fArr[3] = f14;
        fArr[4] = f19;
        fArr[5] = f20;
    }

    public float[] getParams() {
        return this.params;
    }

    private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
        double d;
        double d2;
        float f8 = f;
        float f9 = f3;
        float f10 = f5;
        boolean z3 = z2;
        double radians = Math.toRadians((double) f7);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d3 = (double) f8;
        double d4 = d3 * cos;
        double d5 = d3;
        double d6 = (double) f2;
        double d7 = (double) f10;
        double d8 = (d4 + (d6 * sin)) / d7;
        double d9 = (((double) (-f8)) * sin) + (d6 * cos);
        double d10 = d6;
        double d11 = (double) f6;
        double d12 = d9 / d11;
        double d13 = (double) f4;
        double d14 = ((((double) f9) * cos) + (d13 * sin)) / d7;
        double d15 = d7;
        double d16 = ((((double) (-f9)) * sin) + (d13 * cos)) / d11;
        double d17 = d8 - d14;
        double d18 = d12 - d16;
        double d19 = (d8 + d14) / 2.0d;
        double d20 = (d12 + d16) / 2.0d;
        double d21 = sin;
        double d22 = (d17 * d17) + (d18 * d18);
        if (d22 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            Log.w(LOGTAG, " Points are coincident");
            return;
        }
        double d23 = (1.0d / d22) - 0.25d;
        if (d23 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            Log.w(LOGTAG, "Points are too far apart " + d22);
            float sqrt = (float) (Math.sqrt(d22) / 1.99999d);
            drawArc(path, f, f2, f3, f4, f10 * sqrt, f6 * sqrt, f7, z, z2);
            return;
        }
        double sqrt2 = Math.sqrt(d23);
        double d24 = d17 * sqrt2;
        double d25 = sqrt2 * d18;
        boolean z4 = z2;
        if (z == z4) {
            d2 = d19 - d25;
            d = d20 + d24;
        } else {
            d2 = d19 + d25;
            d = d20 - d24;
        }
        double atan2 = Math.atan2(d12 - d, d8 - d2);
        double atan22 = Math.atan2(d16 - d, d14 - d2) - atan2;
        int i = (atan22 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (atan22 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1));
        if (z4 != (i >= 0)) {
            atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        double d26 = d2 * d15;
        double d27 = d * d11;
        arcToBezier(path, (d26 * cos) - (d27 * d21), (d26 * d21) + (d27 * cos), d15, d11, d5, d10, radians, atan2, atan22);
    }

    private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d3;
        int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
        double cos = Math.cos(d7);
        double sin = Math.sin(d7);
        double cos2 = Math.cos(d8);
        double sin2 = Math.sin(d8);
        double d11 = -d10;
        double d12 = d11 * cos;
        double d13 = d4 * sin;
        double d14 = (d12 * sin2) - (d13 * cos2);
        double d15 = d11 * sin;
        double d16 = d4 * cos;
        double d17 = (sin2 * d15) + (cos2 * d16);
        double d18 = d9 / ((double) ceil);
        double d19 = d8;
        double d20 = d17;
        double d21 = d14;
        int i = 0;
        double d22 = d5;
        double d23 = d6;
        while (i < ceil) {
            double d24 = d19 + d18;
            double sin3 = Math.sin(d24);
            double cos3 = Math.cos(d24);
            double d25 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
            double d26 = d2 + (d10 * sin * cos3) + (d16 * sin3);
            double d27 = (d12 * sin3) - (d13 * cos3);
            double d28 = (sin3 * d15) + (cos3 * d16);
            double d29 = d24 - d19;
            double tan = Math.tan(d29 / 2.0d);
            double sin4 = (Math.sin(d29) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
            double d30 = d22 + (d21 * sin4);
            double d31 = cos;
            double d32 = sin;
            path.rLineTo(0.0f, 0.0f);
            float f = (float) (d25 - (sin4 * d27));
            float f2 = (float) (d26 - (sin4 * d28));
            path.cubicTo((float) d30, (float) (d23 + (d20 * sin4)), f, f2, (float) d25, (float) d26);
            i++;
            d18 = d18;
            sin = d32;
            d22 = d25;
            d15 = d15;
            cos = d31;
            d19 = d24;
            d20 = d28;
            d21 = d27;
            ceil = ceil;
            d23 = d26;
            d10 = d3;
        }
    }
}
