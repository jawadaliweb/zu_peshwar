package com.kbeanie.multipicker.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MimeUtils {
    static String[] IMAGE_EXTENSIONS = {"jpg", "jpeg", "bmp", "png", "gif", "tiff", "webp", "ico"};
    private static Set<String> SET_IMAGE_EXTENSIONS = new HashSet(Arrays.asList(IMAGE_EXTENSIONS));
    private static Set<String> SET_VIDEO_EXTENSIONS = new HashSet(Arrays.asList(VIDEO_EXTENSIONS));
    static String[] VIDEO_EXTENSIONS = {"avi", "asf", "mov", "flv", "swf", "mpg", "mpeg", "mp4", "wmv"};

    public static String guessMimeTypeFromExtension(String str) {
        if (SET_IMAGE_EXTENSIONS.contains(str.toLowerCase())) {
            return "image";
        }
        return SET_VIDEO_EXTENSIONS.contains(str.toLowerCase()) ? "video" : "file";
    }
}
