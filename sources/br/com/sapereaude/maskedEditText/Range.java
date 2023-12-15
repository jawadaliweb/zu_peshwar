package br.com.sapereaude.maskedEditText;

public class Range {
    private int end = -1;
    private int start = -1;

    Range() {
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int i) {
        this.start = i;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int i) {
        this.end = i;
    }
}
