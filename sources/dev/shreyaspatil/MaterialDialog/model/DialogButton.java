package dev.shreyaspatil.MaterialDialog.model;

import dev.shreyaspatil.MaterialDialog.AbstractDialog;

public class DialogButton {
    private int icon;
    private AbstractDialog.OnClickListener onClickListener;
    private String title;

    public DialogButton(String str, int i, AbstractDialog.OnClickListener onClickListener2) {
        this.title = str;
        this.icon = i;
        this.onClickListener = onClickListener2;
    }

    public String getTitle() {
        return this.title;
    }

    public int getIcon() {
        return this.icon;
    }

    public AbstractDialog.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }
}
