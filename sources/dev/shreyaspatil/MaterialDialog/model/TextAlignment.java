package dev.shreyaspatil.MaterialDialog.model;

public enum TextAlignment {
    START(2),
    END(3),
    CENTER(4);
    
    private final int alignment;

    private TextAlignment(int i) {
        this.alignment = i;
    }

    public int getAlignment() {
        return this.alignment;
    }
}
