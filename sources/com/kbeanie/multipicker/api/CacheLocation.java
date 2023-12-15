package com.kbeanie.multipicker.api;

public interface CacheLocation {
    public static final int EXTERNAL_CACHE_DIR = 300;
    public static final int EXTERNAL_STORAGE_APP_DIR = 200;
    @Deprecated
    public static final int EXTERNAL_STORAGE_PUBLIC_DIR = 100;
    public static final int INTERNAL_APP_DIR = 400;
}
