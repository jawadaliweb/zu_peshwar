package com.richpath.pathparser;

import android.graphics.Path;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class PathParserCompatApi21 {
    PathParserCompatApi21() {
    }

    static Path createPathFromPathData(String str) {
        try {
            Method createPathFromPathDataMethod = getCreatePathFromPathDataMethod();
            if (createPathFromPathDataMethod != null) {
                return (Path) createPathFromPathDataMethod.invoke((Object) null, new Object[]{str});
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private static Method getCreatePathFromPathDataMethod() {
        try {
            return Class.forName("android.util.PathParser").getDeclaredMethod("createPathFromPathData", new Class[]{String.class});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
