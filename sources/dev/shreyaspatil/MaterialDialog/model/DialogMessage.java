package dev.shreyaspatil.MaterialDialog.model;

import android.text.Spanned;
import java.lang.CharSequence;

public abstract class DialogMessage<T extends CharSequence> {
    private final TextAlignment textAlignment;

    public abstract T getText();

    private DialogMessage(TextAlignment textAlignment2) {
        this.textAlignment = textAlignment2;
    }

    public static SpannedMessage spanned(Spanned spanned, TextAlignment textAlignment2) {
        return new SpannedMessage(spanned, textAlignment2);
    }

    public static TextMessage text(String str, TextAlignment textAlignment2) {
        return new TextMessage(str, textAlignment2);
    }

    public TextAlignment getTextAlignment() {
        return this.textAlignment;
    }

    public static class SpannedMessage extends DialogMessage<Spanned> {
        private final Spanned text;

        SpannedMessage(Spanned spanned, TextAlignment textAlignment) {
            super(textAlignment);
            this.text = spanned;
        }

        public Spanned getText() {
            return this.text;
        }
    }

    public static class TextMessage extends DialogMessage<String> {
        private final String text;

        TextMessage(String str, TextAlignment textAlignment) {
            super(textAlignment);
            this.text = str;
        }

        public String getText() {
            return this.text;
        }
    }
}
