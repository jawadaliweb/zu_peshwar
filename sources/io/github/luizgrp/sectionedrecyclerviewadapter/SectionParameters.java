package io.github.luizgrp.sectionedrecyclerviewadapter;

public final class SectionParameters {
    public final transient Integer emptyResourceId;
    public final transient boolean emptyViewWillBeProvided;
    public final transient Integer failedResourceId;
    public final transient boolean failedViewWillBeProvided;
    public final transient Integer footerResourceId;
    public final transient boolean footerViewWillBeProvided;
    public final transient Integer headerResourceId;
    public final transient boolean headerViewWillBeProvided;
    public final transient Integer itemResourceId;
    public final transient boolean itemViewWillBeProvided;
    public final transient Integer loadingResourceId;
    public final transient boolean loadingViewWillBeProvided;

    private SectionParameters(Builder builder) {
        Integer access$000 = builder.itemResourceId;
        this.itemResourceId = access$000;
        Integer access$100 = builder.headerResourceId;
        this.headerResourceId = access$100;
        Integer access$200 = builder.footerResourceId;
        this.footerResourceId = access$200;
        Integer access$300 = builder.loadingResourceId;
        this.loadingResourceId = access$300;
        Integer access$400 = builder.failedResourceId;
        this.failedResourceId = access$400;
        Integer access$500 = builder.emptyResourceId;
        this.emptyResourceId = access$500;
        boolean access$600 = builder.itemViewWillBeProvided;
        this.itemViewWillBeProvided = access$600;
        boolean access$700 = builder.headerViewWillBeProvided;
        this.headerViewWillBeProvided = access$700;
        boolean access$800 = builder.footerViewWillBeProvided;
        this.footerViewWillBeProvided = access$800;
        boolean access$900 = builder.loadingViewWillBeProvided;
        this.loadingViewWillBeProvided = access$900;
        boolean access$1000 = builder.failedViewWillBeProvided;
        this.failedViewWillBeProvided = access$1000;
        boolean access$1100 = builder.emptyViewWillBeProvided;
        this.emptyViewWillBeProvided = access$1100;
        if (access$000 != null && access$600) {
            throw new IllegalArgumentException("itemResourceId and itemViewWillBeProvided cannot both be set");
        } else if (access$000 == null && !access$600) {
            throw new IllegalArgumentException("Either itemResourceId or itemViewWillBeProvided must be set");
        } else if (access$100 != null && access$700) {
            throw new IllegalArgumentException("headerResourceId and headerViewWillBeProvided cannot both be set");
        } else if (access$200 != null && access$800) {
            throw new IllegalArgumentException("footerResourceId and footerViewWillBeProvided cannot both be set");
        } else if (access$300 != null && access$900) {
            throw new IllegalArgumentException("loadingResourceId and loadingViewWillBeProvided cannot both be set");
        } else if (access$400 != null && access$1000) {
            throw new IllegalArgumentException("failedResourceId and failedViewWillBeProvided cannot both be set");
        } else if (access$500 != null && access$1100) {
            throw new IllegalArgumentException("emptyResourceId and emptyViewWillBeProvided cannot both be set");
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public transient Integer emptyResourceId;
        /* access modifiers changed from: private */
        public transient boolean emptyViewWillBeProvided;
        /* access modifiers changed from: private */
        public transient Integer failedResourceId;
        /* access modifiers changed from: private */
        public transient boolean failedViewWillBeProvided;
        /* access modifiers changed from: private */
        public transient Integer footerResourceId;
        /* access modifiers changed from: private */
        public transient boolean footerViewWillBeProvided;
        /* access modifiers changed from: private */
        public transient Integer headerResourceId;
        /* access modifiers changed from: private */
        public transient boolean headerViewWillBeProvided;
        /* access modifiers changed from: private */
        public transient Integer itemResourceId;
        /* access modifiers changed from: private */
        public transient boolean itemViewWillBeProvided;
        /* access modifiers changed from: private */
        public transient Integer loadingResourceId;
        /* access modifiers changed from: private */
        public transient boolean loadingViewWillBeProvided;

        private Builder() {
        }

        public Builder itemResourceId(int i) {
            this.itemResourceId = Integer.valueOf(i);
            return this;
        }

        public Builder itemViewWillBeProvided() {
            this.itemViewWillBeProvided = true;
            return this;
        }

        public Builder headerResourceId(int i) {
            this.headerResourceId = Integer.valueOf(i);
            return this;
        }

        public Builder headerViewWillBeProvided() {
            this.headerViewWillBeProvided = true;
            return this;
        }

        public Builder footerResourceId(int i) {
            this.footerResourceId = Integer.valueOf(i);
            return this;
        }

        public Builder footerViewWillBeProvided() {
            this.footerViewWillBeProvided = true;
            return this;
        }

        public Builder loadingResourceId(int i) {
            this.loadingResourceId = Integer.valueOf(i);
            return this;
        }

        public Builder loadingViewWillBeProvided() {
            this.loadingViewWillBeProvided = true;
            return this;
        }

        public Builder failedResourceId(int i) {
            this.failedResourceId = Integer.valueOf(i);
            return this;
        }

        public Builder failedViewWillBeProvided() {
            this.failedViewWillBeProvided = true;
            return this;
        }

        public Builder emptyResourceId(int i) {
            this.emptyResourceId = Integer.valueOf(i);
            return this;
        }

        public Builder emptyViewWillBeProvided() {
            this.emptyViewWillBeProvided = true;
            return this;
        }

        public SectionParameters build() {
            return new SectionParameters(this);
        }
    }
}
