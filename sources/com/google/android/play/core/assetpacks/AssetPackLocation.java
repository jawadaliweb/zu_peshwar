package com.google.android.play.core.assetpacks;

public abstract class AssetPackLocation {
    private static final AssetPackLocation a = new ay(1, (String) null, (String) null);

    static AssetPackLocation a() {
        return a;
    }

    static AssetPackLocation b(String str, String str2) {
        return new ay(0, str, str2);
    }

    public abstract String assetsPath();

    public abstract int packStorageMethod();

    public abstract String path();
}
