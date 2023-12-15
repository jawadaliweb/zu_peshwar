package in.myinnos.alphabetsindexfastscrollrecycler.utilities_fs;

public class StringMatcher {
    public static boolean match(String str, String str2) {
        if (str == null || str2 == null || str2.length() > str.length()) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        do {
            if (str2.charAt(i) == str.charAt(i2)) {
                i2++;
                i++;
            } else if (i > 0) {
                break;
            } else {
                i2++;
            }
            if (i2 >= str.length()) {
                break;
            }
        } while (i >= str2.length());
        if (i == str2.length()) {
            return true;
        }
        return false;
    }
}
