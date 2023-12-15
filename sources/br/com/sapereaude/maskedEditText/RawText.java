package br.com.sapereaude.maskedEditText;

public class RawText {
    private String text = "";

    public void subtractFromString(Range range) {
        String str = "";
        String substring = (range.getStart() <= 0 || range.getStart() > this.text.length()) ? str : this.text.substring(0, range.getStart());
        if (range.getEnd() >= 0 && range.getEnd() < this.text.length()) {
            str = this.text.substring(range.getEnd(), this.text.length());
        }
        this.text = substring.concat(str);
    }

    public int addToString(String str, int i, int i2) {
        if (str != null) {
            String str2 = "";
            if (!str.equals(str2)) {
                if (i < 0) {
                    throw new IllegalArgumentException("Start position must be non-negative");
                } else if (i <= this.text.length()) {
                    int length = str.length();
                    String substring = i > 0 ? this.text.substring(0, i) : str2;
                    if (i >= 0 && i < this.text.length()) {
                        String str3 = this.text;
                        str2 = str3.substring(i, str3.length());
                    }
                    if (this.text.length() + str.length() > i2) {
                        length = i2 - this.text.length();
                        str = str.substring(0, length);
                    }
                    this.text = substring.concat(str).concat(str2);
                    return length;
                } else {
                    throw new IllegalArgumentException("Start position must be less than the actual text length");
                }
            }
        }
        return 0;
    }

    public String getText() {
        return this.text;
    }

    public int length() {
        return this.text.length();
    }

    public char charAt(int i) {
        return this.text.charAt(i);
    }
}
