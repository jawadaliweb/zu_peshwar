package com.richpath.util;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.core.content.ContextCompat;
import com.richpath.RichPath;
import com.richpath.model.Group;
import com.richpath.model.Vector;

public class XmlParser {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (r3.equals(com.richpath.RichPath.TAG_NAME) == false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void parseVector(com.richpath.model.Vector r7, android.content.res.XmlResourceParser r8, android.content.Context r9) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            int r1 = r8.getEventType()
        L_0x0009:
            r2 = 1
            if (r1 == r2) goto L_0x0092
            java.lang.String r3 = r8.getName()
            java.lang.String r4 = "group"
            r5 = 2
            if (r1 != r5) goto L_0x007a
            r3.hashCode()
            r1 = -1
            int r6 = r3.hashCode()
            switch(r6) {
                case -820387517: goto L_0x0034;
                case 3433509: goto L_0x002b;
                case 98629247: goto L_0x0022;
                default: goto L_0x0020;
            }
        L_0x0020:
            r2 = -1
            goto L_0x003e
        L_0x0022:
            boolean r2 = r3.equals(r4)
            if (r2 != 0) goto L_0x0029
            goto L_0x0020
        L_0x0029:
            r2 = 2
            goto L_0x003e
        L_0x002b:
            java.lang.String r4 = "path"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x003e
            goto L_0x0020
        L_0x0034:
            java.lang.String r2 = "vector"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x003d
            goto L_0x0020
        L_0x003d:
            r2 = 0
        L_0x003e:
            switch(r2) {
                case 0: goto L_0x0076;
                case 1: goto L_0x005d;
                case 2: goto L_0x0042;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x008c
        L_0x0042:
            com.richpath.model.Group r1 = parseGroupElement(r9, r8)
            boolean r2 = r0.empty()
            if (r2 != 0) goto L_0x0059
            java.lang.Object r2 = r0.peek()
            com.richpath.model.Group r2 = (com.richpath.model.Group) r2
            android.graphics.Matrix r2 = r2.matrix()
            r1.scale(r2)
        L_0x0059:
            r0.push(r1)
            goto L_0x008c
        L_0x005d:
            com.richpath.RichPath r1 = parsePathElement(r9, r8)
            boolean r2 = r0.empty()
            if (r2 != 0) goto L_0x0070
            java.lang.Object r2 = r0.peek()
            com.richpath.model.Group r2 = (com.richpath.model.Group) r2
            r1.applyGroup(r2)
        L_0x0070:
            java.util.List<com.richpath.RichPath> r2 = r7.paths
            r2.add(r1)
            goto L_0x008c
        L_0x0076:
            parseVectorElement(r7, r8, r9)
            goto L_0x008c
        L_0x007a:
            r2 = 3
            if (r1 != r2) goto L_0x008c
            boolean r1 = r4.equals(r3)
            if (r1 == 0) goto L_0x008c
            boolean r1 = r0.empty()
            if (r1 != 0) goto L_0x008c
            r0.pop()
        L_0x008c:
            int r1 = r8.next()
            goto L_0x0009
        L_0x0092:
            r8.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.richpath.util.XmlParser.parseVector(com.richpath.model.Vector, android.content.res.XmlResourceParser, android.content.Context):void");
    }

    private static void parseVectorElement(Vector vector, XmlResourceParser xmlResourceParser, Context context) {
        vector.inflate(xmlResourceParser, context);
    }

    private static Group parseGroupElement(Context context, XmlResourceParser xmlResourceParser) {
        return new Group(context, xmlResourceParser);
    }

    private static RichPath parsePathElement(Context context, XmlResourceParser xmlResourceParser) {
        RichPath richPath = new RichPath(getAttributeString(context, xmlResourceParser, "pathData", (String) null));
        richPath.inflate(context, xmlResourceParser);
        return richPath;
    }

    public static String getAttributeString(Context context, XmlResourceParser xmlResourceParser, String str, String str2) {
        String str3;
        int attributeResourceValue = getAttributeResourceValue(xmlResourceParser, str);
        if (attributeResourceValue != -1) {
            str3 = context.getString(attributeResourceValue);
        } else {
            str3 = getAttributeValue(xmlResourceParser, str);
        }
        return str3 != null ? str3 : str2;
    }

    public static float getAttributeFloat(XmlResourceParser xmlResourceParser, String str, float f) {
        String attributeValue = getAttributeValue(xmlResourceParser, str);
        return attributeValue != null ? Float.parseFloat(attributeValue) : f;
    }

    public static float getAttributeDimen(Context context, XmlResourceParser xmlResourceParser, String str, float f) {
        String attributeValue = getAttributeValue(xmlResourceParser, str);
        return attributeValue != null ? Utils.dpToPixel(context, Utils.getDimenFromString(attributeValue)) : f;
    }

    public static boolean getAttributeBoolean(XmlResourceParser xmlResourceParser, String str, boolean z) {
        String attributeValue = getAttributeValue(xmlResourceParser, str);
        return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z;
    }

    public static int getAttributeInt(XmlResourceParser xmlResourceParser, String str, int i) {
        String attributeValue = getAttributeValue(xmlResourceParser, str);
        return attributeValue != null ? Integer.parseInt(attributeValue) : i;
    }

    public static int getAttributeColor(Context context, XmlResourceParser xmlResourceParser, String str, int i) {
        int attributeResourceValue = getAttributeResourceValue(xmlResourceParser, str);
        if (attributeResourceValue != -1) {
            return ContextCompat.getColor(context, attributeResourceValue);
        }
        String attributeValue = getAttributeValue(xmlResourceParser, str);
        return attributeValue != null ? Utils.getColorFromString(attributeValue) : i;
    }

    public static Paint.Cap getAttributeStrokeLineCap(XmlResourceParser xmlResourceParser, String str, Paint.Cap cap) {
        String attributeValue = getAttributeValue(xmlResourceParser, str);
        return attributeValue != null ? getStrokeLineCap(Integer.parseInt(attributeValue), cap) : cap;
    }

    public static Paint.Join getAttributeStrokeLineJoin(XmlResourceParser xmlResourceParser, String str, Paint.Join join) {
        String attributeValue = getAttributeValue(xmlResourceParser, str);
        return attributeValue != null ? getStrokeLineJoin(Integer.parseInt(attributeValue), join) : join;
    }

    public static Path.FillType getAttributePathFillType(XmlResourceParser xmlResourceParser, String str, Path.FillType fillType) {
        String attributeValue = getAttributeValue(xmlResourceParser, str);
        return attributeValue != null ? getPathFillType(Integer.parseInt(attributeValue), fillType) : fillType;
    }

    private static String getAttributeValue(XmlResourceParser xmlResourceParser, String str) {
        return xmlResourceParser.getAttributeValue(NAMESPACE, str);
    }

    private static int getAttributeResourceValue(XmlResourceParser xmlResourceParser, String str) {
        return xmlResourceParser.getAttributeResourceValue(NAMESPACE, str, -1);
    }

    private static Paint.Cap getStrokeLineCap(int i, Paint.Cap cap) {
        if (i == 0) {
            return Paint.Cap.BUTT;
        }
        if (i != 1) {
            return i != 2 ? cap : Paint.Cap.SQUARE;
        }
        return Paint.Cap.ROUND;
    }

    private static Paint.Join getStrokeLineJoin(int i, Paint.Join join) {
        if (i == 0) {
            return Paint.Join.MITER;
        }
        if (i != 1) {
            return i != 2 ? join : Paint.Join.BEVEL;
        }
        return Paint.Join.ROUND;
    }

    private static Path.FillType getPathFillType(int i, Path.FillType fillType) {
        if (i == 0) {
            return Path.FillType.WINDING;
        }
        if (i == 1) {
            return Path.FillType.EVEN_ODD;
        }
        if (i != 2) {
            return i != 3 ? fillType : Path.FillType.INVERSE_EVEN_ODD;
        }
        return Path.FillType.INVERSE_WINDING;
    }
}
