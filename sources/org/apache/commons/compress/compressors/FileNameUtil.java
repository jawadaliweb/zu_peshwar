package org.apache.commons.compress.compressors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FileNameUtil {
    private final Map<String, String> compressSuffix = new HashMap();
    private final String defaultExtension;
    private final int longestCompressedSuffix;
    private final int longestUncompressedSuffix;
    private final int shortestCompressedSuffix;
    private final int shortestUncompressedSuffix;
    private final Map<String, String> uncompressSuffix;

    public FileNameUtil(Map<String, String> map, String str) {
        this.uncompressSuffix = Collections.unmodifiableMap(map);
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MIN_VALUE;
        for (Map.Entry next : map.entrySet()) {
            int length = ((String) next.getKey()).length();
            i3 = length > i3 ? length : i3;
            i = length < i ? length : i;
            String str2 = (String) next.getValue();
            int length2 = str2.length();
            if (length2 > 0) {
                if (!this.compressSuffix.containsKey(str2)) {
                    this.compressSuffix.put(str2, next.getKey());
                }
                i4 = length2 > i4 ? length2 : i4;
                if (length2 < i2) {
                    i2 = length2;
                }
            }
        }
        this.longestCompressedSuffix = i3;
        this.longestUncompressedSuffix = i4;
        this.shortestCompressedSuffix = i;
        this.shortestUncompressedSuffix = i2;
        this.defaultExtension = str;
    }

    public boolean isCompressedFilename(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        int length = lowerCase.length();
        int i = this.shortestCompressedSuffix;
        while (i <= this.longestCompressedSuffix && i < length) {
            if (this.uncompressSuffix.containsKey(lowerCase.substring(length - i))) {
                return true;
            }
            i++;
        }
        return false;
    }

    public String getUncompressedFilename(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        int length = lowerCase.length();
        int i = this.shortestCompressedSuffix;
        while (i <= this.longestCompressedSuffix && i < length) {
            int i2 = length - i;
            String str2 = this.uncompressSuffix.get(lowerCase.substring(i2));
            if (str2 != null) {
                return str.substring(0, i2) + str2;
            }
            i++;
        }
        return str;
    }

    public String getCompressedFilename(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        int length = lowerCase.length();
        int i = this.shortestUncompressedSuffix;
        while (i <= this.longestUncompressedSuffix && i < length) {
            int i2 = length - i;
            String str2 = this.compressSuffix.get(lowerCase.substring(i2));
            if (str2 != null) {
                return str.substring(0, i2) + str2;
            }
            i++;
        }
        return str + this.defaultExtension;
    }
}
