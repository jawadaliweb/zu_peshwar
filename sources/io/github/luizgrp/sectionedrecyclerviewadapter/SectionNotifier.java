package io.github.luizgrp.sectionedrecyclerviewadapter;

import io.github.luizgrp.sectionedrecyclerviewadapter.Section;

interface SectionNotifier {
    void notifyAllItemsChanged();

    void notifyAllItemsChanged(Object obj);

    void notifyAllItemsInserted();

    void notifyFooterChanged();

    void notifyFooterChanged(Object obj);

    void notifyFooterInserted();

    void notifyFooterRemoved();

    void notifyHeaderChanged();

    void notifyHeaderChanged(Object obj);

    void notifyHeaderInserted();

    void notifyHeaderRemoved();

    void notifyItemChanged(int i);

    void notifyItemChanged(int i, Object obj);

    void notifyItemInserted(int i);

    void notifyItemMoved(int i, int i2);

    void notifyItemRangeChanged(int i, int i2);

    void notifyItemRangeChanged(int i, int i2, Object obj);

    void notifyItemRangeInserted(int i, int i2);

    void notifyItemRangeRemoved(int i, int i2);

    void notifyItemRemoved(int i);

    void notifyNotLoadedStateChanged(Section.State state);

    void notifySectionChangedToInvisible(int i);

    void notifySectionChangedToVisible();

    void notifyStateChangedFromLoaded(int i);

    void notifyStateChangedToLoaded(Section.State state);
}
