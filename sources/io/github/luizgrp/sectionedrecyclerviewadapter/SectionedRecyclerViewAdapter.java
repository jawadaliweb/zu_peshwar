package io.github.luizgrp.sectionedrecyclerviewadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.apache.commons.collections4.map.ListOrderedMap;

public class SectionedRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_TYPE_EMPTY = 5;
    public static final int VIEW_TYPE_FAILED = 4;
    public static final int VIEW_TYPE_FOOTER = 1;
    public static final int VIEW_TYPE_HEADER = 0;
    public static final int VIEW_TYPE_ITEM_LOADED = 2;
    public static final int VIEW_TYPE_LOADING = 3;
    private static final int VIEW_TYPE_QTY = 6;
    private final transient Map<Section, SectionAdapter> sectionAdapters = new HashMap();
    private final transient Map<String, Integer> sectionViewTypeNumbers = new LinkedHashMap();
    private final transient ListOrderedMap<String, Section> sections = new ListOrderedMap<>();
    private transient int viewTypeCount;

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        for (Map.Entry next : this.sectionViewTypeNumbers.entrySet()) {
            if (i >= ((Integer) next.getValue()).intValue() && i < ((Integer) next.getValue()).intValue() + 6) {
                Section section = this.sections.get(next.getKey());
                int intValue = i - ((Integer) next.getValue()).intValue();
                if (intValue == 0) {
                    viewHolder = getHeaderViewHolder(viewGroup, section);
                } else if (intValue == 1) {
                    viewHolder = getFooterViewHolder(viewGroup, section);
                } else if (intValue == 2) {
                    viewHolder = getItemViewHolder(viewGroup, section);
                } else if (intValue == 3) {
                    viewHolder = getLoadingViewHolder(viewGroup, section);
                } else if (intValue == 4) {
                    viewHolder = getFailedViewHolder(viewGroup, section);
                } else if (intValue == 5) {
                    viewHolder = getEmptyViewHolder(viewGroup, section);
                } else {
                    throw new IllegalArgumentException("Invalid viewType");
                }
            }
        }
        return viewHolder;
    }

    private RecyclerView.ViewHolder getItemViewHolder(ViewGroup viewGroup, Section section) {
        View view;
        if (section.isItemViewWillBeProvided()) {
            view = section.getItemView(viewGroup);
            Objects.requireNonNull(view, "Section.getItemView() returned null");
        } else {
            Integer itemResourceId = section.getItemResourceId();
            Objects.requireNonNull(itemResourceId, "Missing 'item' resource id");
            view = inflate(itemResourceId.intValue(), viewGroup);
        }
        return section.getItemViewHolder(view);
    }

    private RecyclerView.ViewHolder getHeaderViewHolder(ViewGroup viewGroup, Section section) {
        View view;
        if (section.isHeaderViewWillBeProvided()) {
            view = section.getHeaderView(viewGroup);
            Objects.requireNonNull(view, "Section.getHeaderView() returned null");
        } else {
            Integer headerResourceId = section.getHeaderResourceId();
            Objects.requireNonNull(headerResourceId, "Missing 'header' resource id");
            view = inflate(headerResourceId.intValue(), viewGroup);
        }
        return section.getHeaderViewHolder(view);
    }

    private RecyclerView.ViewHolder getFooterViewHolder(ViewGroup viewGroup, Section section) {
        View view;
        if (section.isFooterViewWillBeProvided()) {
            view = section.getFooterView(viewGroup);
            Objects.requireNonNull(view, "Section.getFooterView() returned null");
        } else {
            Integer footerResourceId = section.getFooterResourceId();
            Objects.requireNonNull(footerResourceId, "Missing 'footer' resource id");
            view = inflate(footerResourceId.intValue(), viewGroup);
        }
        return section.getFooterViewHolder(view);
    }

    private RecyclerView.ViewHolder getLoadingViewHolder(ViewGroup viewGroup, Section section) {
        View view;
        if (section.isLoadingViewWillBeProvided()) {
            view = section.getLoadingView(viewGroup);
            Objects.requireNonNull(view, "Section.getLoadingView() returned null");
        } else {
            Integer loadingResourceId = section.getLoadingResourceId();
            Objects.requireNonNull(loadingResourceId, "Missing 'loading' resource id");
            view = inflate(loadingResourceId.intValue(), viewGroup);
        }
        return section.getLoadingViewHolder(view);
    }

    private RecyclerView.ViewHolder getFailedViewHolder(ViewGroup viewGroup, Section section) {
        View view;
        if (section.isFailedViewWillBeProvided()) {
            view = section.getFailedView(viewGroup);
            Objects.requireNonNull(view, "Section.getFailedView() returned null");
        } else {
            Integer failedResourceId = section.getFailedResourceId();
            Objects.requireNonNull(failedResourceId, "Missing 'failed' resource id");
            view = inflate(failedResourceId.intValue(), viewGroup);
        }
        return section.getFailedViewHolder(view);
    }

    private RecyclerView.ViewHolder getEmptyViewHolder(ViewGroup viewGroup, Section section) {
        View view;
        if (section.isEmptyViewWillBeProvided()) {
            view = section.getEmptyView(viewGroup);
            Objects.requireNonNull(view, "Section.getEmptyView() returned null");
        } else {
            Integer emptyResourceId = section.getEmptyResourceId();
            Objects.requireNonNull(emptyResourceId, "Missing 'empty' resource id");
            view = inflate(emptyResourceId.intValue(), viewGroup);
        }
        return section.getEmptyViewHolder(view);
    }

    public String addSection(Section section) {
        String generateSectionTag = generateSectionTag();
        addSection(generateSectionTag, section);
        return generateSectionTag;
    }

    public void addSection(String str, Section section) {
        addSection(this.sections.size(), str, section);
    }

    public void addSection(int i, String str, Section section) {
        this.sections.put(i, str, section);
        addSectionViewTypeNumbers(str);
        if (this.sectionAdapters.put(section, new SectionAdapter(this, section)) != null) {
            throw new IllegalArgumentException("This adapter already contains this Section");
        }
    }

    public String addSection(int i, Section section) {
        String generateSectionTag = generateSectionTag();
        addSection(i, generateSectionTag, section);
        return generateSectionTag;
    }

    private String generateSectionTag() {
        return UUID.randomUUID().toString();
    }

    private void addSectionViewTypeNumbers(String str) {
        this.sectionViewTypeNumbers.put(str, Integer.valueOf(this.viewTypeCount));
        this.viewTypeCount += 6;
    }

    public Section getSection(String str) {
        return this.sections.get(str);
    }

    public void removeSection(Section section) {
        String str = null;
        for (Map.Entry next : this.sections.entrySet()) {
            if (next.getValue() == section) {
                str = (String) next.getKey();
            }
        }
        if (str != null) {
            removeSection(str);
        }
    }

    public void removeSection(String str) {
        this.sectionViewTypeNumbers.remove(str);
        this.sectionAdapters.remove(this.sections.remove((Object) str));
    }

    public void removeAllSections() {
        this.sections.clear();
        this.sectionViewTypeNumbers.clear();
        this.sectionAdapters.clear();
        this.viewTypeCount = 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        internalOnBindViewHolder(viewHolder, i, (List<Object>) null);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        if (list.isEmpty()) {
            super.onBindViewHolder(viewHolder, i, list);
        } else {
            internalOnBindViewHolder(viewHolder, i, list);
        }
    }

    private void internalOnBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int i2;
        int i3 = 0;
        for (Map.Entry<String, Section> value : this.sections.entrySet()) {
            Section section = (Section) value.getValue();
            if (section.isVisible()) {
                int sectionItemsTotal = section.getSectionItemsTotal();
                if (i < i3 || i > (i3 + sectionItemsTotal) - 1) {
                    i3 += sectionItemsTotal;
                } else if (!section.hasHeader() || i != i3) {
                    if (!section.hasFooter() || i != i2) {
                        onBindContentViewHolder(getSectionForPosition(i), viewHolder, i, list);
                        return;
                    } else if (list == null) {
                        getSectionForPosition(i).onBindFooterViewHolder(viewHolder);
                        return;
                    } else {
                        getSectionForPosition(i).onBindFooterViewHolder(viewHolder, list);
                        return;
                    }
                } else if (list == null) {
                    getSectionForPosition(i).onBindHeaderViewHolder(viewHolder);
                    return;
                } else {
                    getSectionForPosition(i).onBindHeaderViewHolder(viewHolder, list);
                    return;
                }
            }
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    /* renamed from: io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$github$luizgrp$sectionedrecyclerviewadapter$Section$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.github.luizgrp.sectionedrecyclerviewadapter.Section$State[] r0 = io.github.luizgrp.sectionedrecyclerviewadapter.Section.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$github$luizgrp$sectionedrecyclerviewadapter$Section$State = r0
                io.github.luizgrp.sectionedrecyclerviewadapter.Section$State r1 = io.github.luizgrp.sectionedrecyclerviewadapter.Section.State.LOADING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$github$luizgrp$sectionedrecyclerviewadapter$Section$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.github.luizgrp.sectionedrecyclerviewadapter.Section$State r1 = io.github.luizgrp.sectionedrecyclerviewadapter.Section.State.LOADED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$github$luizgrp$sectionedrecyclerviewadapter$Section$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.github.luizgrp.sectionedrecyclerviewadapter.Section$State r1 = io.github.luizgrp.sectionedrecyclerviewadapter.Section.State.FAILED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$github$luizgrp$sectionedrecyclerviewadapter$Section$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.github.luizgrp.sectionedrecyclerviewadapter.Section$State r1 = io.github.luizgrp.sectionedrecyclerviewadapter.Section.State.EMPTY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter.AnonymousClass1.<clinit>():void");
        }
    }

    private void onBindContentViewHolder(Section section, RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int i2 = AnonymousClass1.$SwitchMap$io$github$luizgrp$sectionedrecyclerviewadapter$Section$State[section.getState().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        throw new IllegalStateException("Invalid state");
                    } else if (list == null) {
                        section.onBindEmptyViewHolder(viewHolder);
                    } else {
                        section.onBindEmptyViewHolder(viewHolder, list);
                    }
                } else if (list == null) {
                    section.onBindFailedViewHolder(viewHolder);
                } else {
                    section.onBindFailedViewHolder(viewHolder, list);
                }
            } else if (list == null) {
                section.onBindItemViewHolder(viewHolder, getPositionInSection(i));
            } else {
                section.onBindItemViewHolder(viewHolder, getPositionInSection(i), list);
            }
        } else if (list == null) {
            section.onBindLoadingViewHolder(viewHolder);
        } else {
            section.onBindLoadingViewHolder(viewHolder, list);
        }
    }

    public int getItemCount() {
        int i = 0;
        for (Map.Entry<String, Section> value : this.sections.entrySet()) {
            Section section = (Section) value.getValue();
            if (section.isVisible()) {
                i += section.getSectionItemsTotal();
            }
        }
        return i;
    }

    public int getItemViewType(int i) {
        int i2;
        int i3 = 0;
        for (Map.Entry next : this.sections.entrySet()) {
            Section section = (Section) next.getValue();
            if (section.isVisible()) {
                int sectionItemsTotal = section.getSectionItemsTotal();
                if (i < i3 || i > (i2 = (i3 + sectionItemsTotal) - 1)) {
                    i3 += sectionItemsTotal;
                } else {
                    int intValue = this.sectionViewTypeNumbers.get(next.getKey()).intValue();
                    if (section.hasHeader() && i == i3) {
                        return intValue;
                    }
                    if (section.hasFooter() && i == i2) {
                        return intValue + 1;
                    }
                    int i4 = AnonymousClass1.$SwitchMap$io$github$luizgrp$sectionedrecyclerviewadapter$Section$State[section.getState().ordinal()];
                    if (i4 == 1) {
                        return intValue + 3;
                    }
                    if (i4 == 2) {
                        return intValue + 2;
                    }
                    if (i4 == 3) {
                        return intValue + 4;
                    }
                    if (i4 == 4) {
                        return intValue + 5;
                    }
                    throw new IllegalStateException("Invalid state");
                }
            }
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    public static int getSectionItemViewTypeForAdapterViewType(int i) {
        return i % 6;
    }

    public int getSectionItemViewType(int i) {
        return getSectionItemViewTypeForAdapterViewType(getItemViewType(i));
    }

    public Section getSectionForPosition(int i) {
        int i2 = 0;
        for (Map.Entry<String, Section> value : this.sections.entrySet()) {
            Section section = (Section) value.getValue();
            if (section.isVisible()) {
                int sectionItemsTotal = section.getSectionItemsTotal();
                if (i >= i2 && i <= (i2 + sectionItemsTotal) - 1) {
                    return section;
                }
                i2 += sectionItemsTotal;
            }
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    public int getPositionInSection(int i) {
        int i2 = 0;
        for (Map.Entry<String, Section> value : this.sections.entrySet()) {
            Section section = (Section) value.getValue();
            if (section.isVisible()) {
                int sectionItemsTotal = section.getSectionItemsTotal();
                if (i < i2 || i > (i2 + sectionItemsTotal) - 1) {
                    i2 += sectionItemsTotal;
                } else {
                    int i3 = (i - i2) - (section.hasHeader() ? 1 : 0);
                    if (i3 != -1 && i3 != section.getContentItemsTotal()) {
                        return i3;
                    }
                    throw new IllegalArgumentException("This method is not applicable for header or footer position");
                }
            }
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    /* access modifiers changed from: package-private */
    public ListOrderedMap<String, Section> getSections() {
        return this.sections;
    }

    public Map<String, Section> getCopyOfSectionsMap() {
        return ListOrderedMap.listOrderedMap(this.sections);
    }

    public int getSectionCount() {
        return this.sections.size();
    }

    public Section getSection(int i) {
        return this.sections.getValue(i);
    }

    public int getSectionIndex(Section section) {
        int i = 0;
        for (Map.Entry<String, Section> value : this.sections.entrySet()) {
            if (value.getValue() == section) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public SectionAdapter getAdapterForSection(String str) {
        return getAdapterForSection(getValidSectionOrThrowException(str));
    }

    public SectionAdapter getAdapterForSection(Section section) {
        SectionAdapter sectionAdapter = this.sectionAdapters.get(section);
        if (sectionAdapter != null) {
            return sectionAdapter;
        }
        throw new IllegalArgumentException("Invalid section");
    }

    public View inflate(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
    }

    private Section getValidSectionOrThrowException(String str) {
        Section section = getSection(str);
        if (section != null) {
            return section;
        }
        throw new IllegalArgumentException("Invalid tag: " + str);
    }
}
