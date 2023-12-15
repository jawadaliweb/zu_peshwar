package me.relex.circleindicator;

public class Config {
    int animatorResId = R.animator.scale_with_alpha;
    int animatorReverseResId = 0;
    int backgroundResId = R.drawable.white_radius;
    int gravity = 17;
    int height = -1;
    int margin = -1;
    int orientation = 0;
    int unselectedBackgroundId;
    int width = -1;

    Config() {
    }

    public static class Builder {
        private final Config mConfig = new Config();

        public Builder width(int i) {
            this.mConfig.width = i;
            return this;
        }

        public Builder height(int i) {
            this.mConfig.height = i;
            return this;
        }

        public Builder margin(int i) {
            this.mConfig.margin = i;
            return this;
        }

        public Builder animator(int i) {
            this.mConfig.animatorResId = i;
            return this;
        }

        public Builder animatorReverse(int i) {
            this.mConfig.animatorReverseResId = i;
            return this;
        }

        public Builder drawable(int i) {
            this.mConfig.backgroundResId = i;
            return this;
        }

        public Builder drawableUnselected(int i) {
            this.mConfig.unselectedBackgroundId = i;
            return this;
        }

        public Builder orientation(int i) {
            this.mConfig.orientation = i;
            return this;
        }

        public Builder gravity(int i) {
            this.mConfig.gravity = i;
            return this;
        }

        public Config build() {
            return this.mConfig;
        }
    }
}
