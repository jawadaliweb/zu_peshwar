package com.developer.kalert;

import android.content.Context;
import android.util.Xml;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class AnimationLoader {
    AnimationLoader() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        if (r0 != null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001f, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.view.animation.Animation loadAnimation(android.content.Context r3, int r4) throws android.content.res.Resources.NotFoundException {
        /*
            android.content.res.Resources r0 = r3.getResources()     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            android.content.res.XmlResourceParser r0 = r0.getAnimation(r4)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            android.view.animation.Animation r3 = createAnimationFromXml(r3, r0)     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0011
            r0.close()     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
        L_0x0011:
            return r3
        L_0x0012:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r1 = move-exception
            if (r0 == 0) goto L_0x001f
            r0.close()     // Catch:{ all -> 0x001b }
            goto L_0x001f
        L_0x001b:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
        L_0x001f:
            throw r1     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
        L_0x0020:
            r3 = move-exception
            goto L_0x0023
        L_0x0022:
            r3 = move-exception
        L_0x0023:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 >= r1) goto L_0x002b
            r3 = 0
            return r3
        L_0x002b:
            android.content.res.Resources$NotFoundException r0 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Can't load animation resource ID #0x"
            r1.append(r2)
            java.lang.String r4 = java.lang.Integer.toHexString(r4)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.developer.kalert.AnimationLoader.loadAnimation(android.content.Context, int):android.view.animation.Animation");
    }

    private static Animation createAnimationFromXml(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return createAnimationFromXml(context, xmlPullParser, (AnimationSet) null, Xml.asAttributeSet(xmlPullParser));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        if (r1.equals("scale") == false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.view.animation.Animation createAnimationFromXml(android.content.Context r8, org.xmlpull.v1.XmlPullParser r9, android.view.animation.AnimationSet r10, android.util.AttributeSet r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r9.getDepth()
            r1 = 0
        L_0x0005:
            int r2 = r9.next()
            r3 = 3
            if (r2 != r3) goto L_0x0012
            int r4 = r9.getDepth()
            if (r4 <= r0) goto L_0x00d3
        L_0x0012:
            r4 = 1
            if (r2 == r4) goto L_0x00d3
            r5 = 2
            if (r2 == r5) goto L_0x0019
            goto L_0x0005
        L_0x0019:
            java.lang.String r1 = r9.getName()
            r1.hashCode()
            r2 = -1
            int r6 = r1.hashCode()
            r7 = 0
            switch(r6) {
                case -925180581: goto L_0x0055;
                case 113762: goto L_0x004a;
                case 92909918: goto L_0x003f;
                case 109250890: goto L_0x0036;
                case 1052832078: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            r3 = -1
            goto L_0x005f
        L_0x002b:
            java.lang.String r3 = "translate"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            r3 = 4
            goto L_0x005f
        L_0x0036:
            java.lang.String r6 = "scale"
            boolean r6 = r1.equals(r6)
            if (r6 != 0) goto L_0x005f
            goto L_0x0029
        L_0x003f:
            java.lang.String r3 = "alpha"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0048
            goto L_0x0029
        L_0x0048:
            r3 = 2
            goto L_0x005f
        L_0x004a:
            java.lang.String r3 = "set"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0053
            goto L_0x0029
        L_0x0053:
            r3 = 1
            goto L_0x005f
        L_0x0055:
            java.lang.String r3 = "rotate"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x005e
            goto L_0x0029
        L_0x005e:
            r3 = 0
        L_0x005f:
            switch(r3) {
                case 0: goto L_0x00c7;
                case 1: goto L_0x00bb;
                case 2: goto L_0x00b5;
                case 3: goto L_0x00af;
                case 4: goto L_0x00a9;
                default: goto L_0x0062;
            }
        L_0x0062:
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x0081 }
            java.lang.Class[] r2 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0081 }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r7] = r3     // Catch:{ Exception -> 0x0081 }
            java.lang.Class<android.util.AttributeSet> r3 = android.util.AttributeSet.class
            r2[r4] = r3     // Catch:{ Exception -> 0x0081 }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r2)     // Catch:{ Exception -> 0x0081 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0081 }
            r2[r7] = r8     // Catch:{ Exception -> 0x0081 }
            r2[r4] = r11     // Catch:{ Exception -> 0x0081 }
            java.lang.Object r1 = r1.newInstance(r2)     // Catch:{ Exception -> 0x0081 }
            android.view.animation.Animation r1 = (android.view.animation.Animation) r1     // Catch:{ Exception -> 0x0081 }
            goto L_0x00cc
        L_0x0081:
            r8 = move-exception
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Unknown animation name: "
            r11.append(r0)
            java.lang.String r9 = r9.getName()
            r11.append(r9)
            java.lang.String r9 = " error:"
            r11.append(r9)
            java.lang.String r8 = r8.getMessage()
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r10.<init>(r8)
            throw r10
        L_0x00a9:
            android.view.animation.TranslateAnimation r1 = new android.view.animation.TranslateAnimation
            r1.<init>(r8, r11)
            goto L_0x00cc
        L_0x00af:
            android.view.animation.ScaleAnimation r1 = new android.view.animation.ScaleAnimation
            r1.<init>(r8, r11)
            goto L_0x00cc
        L_0x00b5:
            android.view.animation.AlphaAnimation r1 = new android.view.animation.AlphaAnimation
            r1.<init>(r8, r11)
            goto L_0x00cc
        L_0x00bb:
            android.view.animation.AnimationSet r1 = new android.view.animation.AnimationSet
            r1.<init>(r8, r11)
            r2 = r1
            android.view.animation.AnimationSet r2 = (android.view.animation.AnimationSet) r2
            createAnimationFromXml(r8, r9, r2, r11)
            goto L_0x00cc
        L_0x00c7:
            android.view.animation.RotateAnimation r1 = new android.view.animation.RotateAnimation
            r1.<init>(r8, r11)
        L_0x00cc:
            if (r10 == 0) goto L_0x0005
            r10.addAnimation(r1)
            goto L_0x0005
        L_0x00d3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.developer.kalert.AnimationLoader.createAnimationFromXml(android.content.Context, org.xmlpull.v1.XmlPullParser, android.view.animation.AnimationSet, android.util.AttributeSet):android.view.animation.Animation");
    }
}
