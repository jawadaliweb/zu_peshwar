package dev.shreyaspatil.MaterialDialog.model;

public class DialogTitle {
    private final String text;
    private final TextAlignment textAlignment;

    public DialogTitle(String str, TextAlignment textAlignment2) {
        this.text = str;
        this.textAlignment = textAlignment2;
    }

    public String getText() {
        return this.text;
    }

    public TextAlignment getTextAlignment() {
        return this.textAlignment;
    }
}
