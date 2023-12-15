package com.richpath.pathparser;

import android.graphics.Path;
import android.os.Build;

public class PathParser {
    public static Path createPathFromPathData(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            return PathParserCompatApi21.createPathFromPathData(str);
        }
        return PathParserCompat.createPathFromPathData(str);
    }

    public static void createPathFromPathData(Path path, String str) {
        PathParserCompat.createPathFromPathData(path, str);
    }
}
