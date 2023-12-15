package io.github.luizgrp.sectionedrecyclerviewadapter;

import androidx.recyclerview.widget.ListUpdateCallback;

public class SectionAdapterListUpdateCallback implements ListUpdateCallback {
    private final SectionAdapter sectionAdapter;

    public SectionAdapterListUpdateCallback(SectionAdapter sectionAdapter2) {
        this.sectionAdapter = sectionAdapter2;
    }

    public void onInserted(int i, int i2) {
        this.sectionAdapter.notifyItemRangeInserted(i, i2);
    }

    public void onRemoved(int i, int i2) {
        this.sectionAdapter.notifyItemRangeRemoved(i, i2);
    }

    public void onMoved(int i, int i2) {
        this.sectionAdapter.notifyItemMoved(i, i2);
    }

    public void onChanged(int i, int i2, Object obj) {
        this.sectionAdapter.notifyItemRangeChanged(i, i2, obj);
    }
}
