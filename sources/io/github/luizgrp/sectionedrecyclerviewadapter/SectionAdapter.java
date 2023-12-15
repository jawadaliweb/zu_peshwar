package io.github.luizgrp.sectionedrecyclerviewadapter;

import io.github.luizgrp.sectionedrecyclerviewadapter.Section;
import java.util.Map;

public class SectionAdapter implements SectionPositionIdentifier, SectionNotifier {
    private final transient Section section;
    private final transient SectionedRecyclerViewAdapter sectionedAdapter;

    SectionAdapter(SectionedRecyclerViewAdapter sectionedRecyclerViewAdapter, Section section2) {
        this.sectionedAdapter = sectionedRecyclerViewAdapter;
        this.section = section2;
    }

    /* access modifiers changed from: package-private */
    public Section getSection() {
        return this.section;
    }

    public int getHeaderPosition() {
        if (this.section.hasHeader()) {
            return getSectionPosition();
        }
        throw new IllegalStateException("Section doesn't have a header");
    }

    public int getFooterPosition() {
        if (this.section.hasFooter()) {
            return (getSectionPosition() + this.section.getSectionItemsTotal()) - 1;
        }
        throw new IllegalStateException("Section doesn't have a footer");
    }

    public int getSectionPosition() {
        int i = 0;
        for (Map.Entry<String, Section> value : this.sectionedAdapter.getSections().entrySet()) {
            Section section2 = (Section) value.getValue();
            if (section2.isVisible()) {
                if (section2 == this.section) {
                    return i;
                }
                i += section2.getSectionItemsTotal();
            }
        }
        throw new IllegalArgumentException("Section is not in the adapter.");
    }

    public int getPositionInAdapter(int i) {
        return getSectionPosition() + (this.section.hasHeader() ? 1 : 0) + i;
    }

    public int getPositionInSection(int i) {
        return this.sectionedAdapter.getPositionInSection(i);
    }

    public void notifyItemInserted(int i) {
        this.sectionedAdapter.notifyItemInserted(getPositionInAdapter(i));
    }

    public void notifyAllItemsInserted() {
        this.sectionedAdapter.notifyItemRangeInserted(getPositionInAdapter(0), this.section.getContentItemsTotal());
    }

    public void notifyItemRangeInserted(int i, int i2) {
        this.sectionedAdapter.notifyItemRangeInserted(getPositionInAdapter(i), i2);
    }

    public void notifyItemRemoved(int i) {
        this.sectionedAdapter.notifyItemRemoved(getPositionInAdapter(i));
    }

    public void notifyItemRangeRemoved(int i, int i2) {
        this.sectionedAdapter.notifyItemRangeRemoved(getPositionInAdapter(i), i2);
    }

    public void notifyHeaderChanged() {
        this.sectionedAdapter.notifyItemChanged(getHeaderPosition());
    }

    public void notifyHeaderChanged(Object obj) {
        this.sectionedAdapter.notifyItemChanged(getHeaderPosition(), obj);
    }

    public void notifyFooterChanged() {
        this.sectionedAdapter.notifyItemChanged(getFooterPosition());
    }

    public void notifyFooterChanged(Object obj) {
        this.sectionedAdapter.notifyItemChanged(getFooterPosition(), obj);
    }

    public void notifyItemChanged(int i) {
        this.sectionedAdapter.notifyItemChanged(getPositionInAdapter(i));
    }

    public void notifyItemChanged(int i, Object obj) {
        this.sectionedAdapter.notifyItemChanged(getPositionInAdapter(i), obj);
    }

    public void notifyAllItemsChanged() {
        this.sectionedAdapter.notifyItemRangeChanged(getPositionInAdapter(0), this.section.getContentItemsTotal());
    }

    public void notifyAllItemsChanged(Object obj) {
        this.sectionedAdapter.notifyItemRangeChanged(getPositionInAdapter(0), this.section.getContentItemsTotal(), obj);
    }

    public void notifyItemRangeChanged(int i, int i2) {
        this.sectionedAdapter.notifyItemRangeChanged(getPositionInAdapter(i), i2);
    }

    public void notifyItemRangeChanged(int i, int i2, Object obj) {
        this.sectionedAdapter.notifyItemRangeChanged(getPositionInAdapter(i), i2, obj);
    }

    public void notifyItemMoved(int i, int i2) {
        this.sectionedAdapter.notifyItemMoved(getPositionInAdapter(i), getPositionInAdapter(i2));
    }

    public void notifyNotLoadedStateChanged(Section.State state) {
        Section.State state2 = this.section.getState();
        if (state2 == state) {
            throw new IllegalStateException("No state changed");
        } else if (state == Section.State.LOADED) {
            throw new IllegalStateException("Use notifyStateChangedFromLoaded");
        } else if (state2 != Section.State.LOADED) {
            notifyItemChanged(0);
        } else {
            throw new IllegalStateException("Use notifyStateChangedToLoaded");
        }
    }

    public void notifyStateChangedToLoaded(Section.State state) {
        Section.State state2 = this.section.getState();
        if (state2 == state) {
            throw new IllegalStateException("No state changed");
        } else if (state2 == Section.State.LOADED) {
            int contentItemsTotal = this.section.getContentItemsTotal();
            if (contentItemsTotal == 0) {
                notifyItemRemoved(0);
                return;
            }
            notifyItemChanged(0);
            if (contentItemsTotal > 1) {
                notifyItemRangeInserted(1, contentItemsTotal - 1);
            }
        } else if (state == Section.State.LOADED) {
            throw new IllegalStateException("Use notifyStateChangedFromLoaded");
        } else {
            throw new IllegalStateException("Use notifyNotLoadedStateChanged");
        }
    }

    public void notifyStateChangedFromLoaded(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("previousContentItemsCount cannot have a negative value");
        } else if (this.section.getState() == Section.State.LOADED) {
            throw new IllegalStateException("Use notifyStateChangedToLoaded");
        } else if (i == 0) {
            notifyItemInserted(0);
        } else {
            if (i > 1) {
                notifyItemRangeRemoved(1, i - 1);
            }
            notifyItemChanged(0);
        }
    }

    public void notifyHeaderInserted() {
        this.sectionedAdapter.notifyItemInserted(getHeaderPosition());
    }

    public void notifyFooterInserted() {
        this.sectionedAdapter.notifyItemInserted(getFooterPosition());
    }

    public void notifyHeaderRemoved() {
        this.sectionedAdapter.notifyItemRemoved(getSectionPosition());
    }

    public void notifyFooterRemoved() {
        this.sectionedAdapter.notifyItemRemoved(getSectionPosition() + this.section.getSectionItemsTotal());
    }

    public void notifySectionChangedToVisible() {
        if (this.section.isVisible()) {
            this.sectionedAdapter.notifyItemRangeInserted(getSectionPosition(), this.section.getSectionItemsTotal());
            return;
        }
        throw new IllegalStateException("This section is not visible.");
    }

    public void notifySectionChangedToInvisible(int i) {
        if (!this.section.isVisible()) {
            this.sectionedAdapter.notifyItemRangeRemoved(i, this.section.getSectionItemsTotal());
            return;
        }
        throw new IllegalStateException("This section is not invisible.");
    }
}
