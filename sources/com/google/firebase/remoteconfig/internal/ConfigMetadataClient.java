package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.Date;

public class ConfigMetadataClient {
    private static final String BACKOFF_END_TIME_IN_MILLIS_KEY = "backoff_end_time_in_millis";
    private static final String FETCH_TIMEOUT_IN_SECONDS_KEY = "fetch_timeout_in_seconds";
    private static final String LAST_FETCH_ETAG_KEY = "last_fetch_etag";
    private static final String LAST_FETCH_STATUS_KEY = "last_fetch_status";
    public static final long LAST_FETCH_TIME_IN_MILLIS_NO_FETCH_YET = -1;
    static final Date LAST_FETCH_TIME_NO_FETCH_YET = new Date(-1);
    private static final String LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY = "last_fetch_time_in_millis";
    private static final String LAST_TEMPLATE_VERSION = "last_template_version";
    private static final String MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY = "minimum_fetch_interval_in_seconds";
    static final Date NO_BACKOFF_TIME = new Date(-1);
    private static final long NO_BACKOFF_TIME_IN_MILLIS = -1;
    static final int NO_FAILED_FETCHES = 0;
    static final int NO_FAILED_REALTIME_STREAMS = 0;
    private static final String NUM_FAILED_FETCHES_KEY = "num_failed_fetches";
    private static final String NUM_FAILED_REALTIME_STREAMS_KEY = "num_failed_realtime_streams";
    private static final String REALTIME_BACKOFF_END_TIME_IN_MILLIS_KEY = "realtime_backoff_end_time_in_millis";
    private final Object backoffMetadataLock = new Object();
    private final Object frcInfoLock = new Object();
    private final SharedPreferences frcMetadata;
    private final Object realtimeBackoffMetadataLock = new Object();

    public ConfigMetadataClient(SharedPreferences sharedPreferences) {
        this.frcMetadata = sharedPreferences;
    }

    public long getFetchTimeoutInSeconds() {
        return this.frcMetadata.getLong(FETCH_TIMEOUT_IN_SECONDS_KEY, 60);
    }

    public long getMinimumFetchIntervalInSeconds() {
        return this.frcMetadata.getLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS);
    }

    /* access modifiers changed from: package-private */
    public int getLastFetchStatus() {
        return this.frcMetadata.getInt(LAST_FETCH_STATUS_KEY, 0);
    }

    /* access modifiers changed from: package-private */
    public Date getLastSuccessfulFetchTime() {
        return new Date(this.frcMetadata.getLong(LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY, -1));
    }

    /* access modifiers changed from: package-private */
    public String getLastFetchETag() {
        return this.frcMetadata.getString(LAST_FETCH_ETAG_KEY, (String) null);
    }

    /* access modifiers changed from: package-private */
    public long getLastTemplateVersion() {
        return this.frcMetadata.getLong(LAST_TEMPLATE_VERSION, 0);
    }

    public FirebaseRemoteConfigInfo getInfo() {
        FirebaseRemoteConfigInfoImpl build;
        synchronized (this.frcInfoLock) {
            long j = this.frcMetadata.getLong(LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY, -1);
            int i = this.frcMetadata.getInt(LAST_FETCH_STATUS_KEY, 0);
            build = FirebaseRemoteConfigInfoImpl.newBuilder().withLastFetchStatus(i).withLastSuccessfulFetchTimeInMillis(j).withConfigSettings(new FirebaseRemoteConfigSettings.Builder().setFetchTimeoutInSeconds(this.frcMetadata.getLong(FETCH_TIMEOUT_IN_SECONDS_KEY, 60)).setMinimumFetchIntervalInSeconds(this.frcMetadata.getLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS)).build()).build();
        }
        return build;
    }

    public void clear() {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().clear().commit();
        }
    }

    public void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putLong(FETCH_TIMEOUT_IN_SECONDS_KEY, firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).commit();
        }
    }

    public void setConfigSettingsWithoutWaitingOnDiskWrite(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putLong(FETCH_TIMEOUT_IN_SECONDS_KEY, firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).apply();
        }
    }

    /* access modifiers changed from: package-private */
    public void updateLastFetchAsSuccessfulAt(Date date) {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putInt(LAST_FETCH_STATUS_KEY, -1).putLong(LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY, date.getTime()).apply();
        }
    }

    /* access modifiers changed from: package-private */
    public void updateLastFetchAsFailed() {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putInt(LAST_FETCH_STATUS_KEY, 1).apply();
        }
    }

    /* access modifiers changed from: package-private */
    public void updateLastFetchAsThrottled() {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putInt(LAST_FETCH_STATUS_KEY, 2).apply();
        }
    }

    /* access modifiers changed from: package-private */
    public void setLastFetchETag(String str) {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putString(LAST_FETCH_ETAG_KEY, str).apply();
        }
    }

    /* access modifiers changed from: package-private */
    public void setLastTemplateVersion(long j) {
        synchronized (this.frcInfoLock) {
            this.frcMetadata.edit().putLong(LAST_TEMPLATE_VERSION, j).apply();
        }
    }

    /* access modifiers changed from: package-private */
    public BackoffMetadata getBackoffMetadata() {
        BackoffMetadata backoffMetadata;
        synchronized (this.backoffMetadataLock) {
            backoffMetadata = new BackoffMetadata(this.frcMetadata.getInt(NUM_FAILED_FETCHES_KEY, 0), new Date(this.frcMetadata.getLong(BACKOFF_END_TIME_IN_MILLIS_KEY, -1)));
        }
        return backoffMetadata;
    }

    /* access modifiers changed from: package-private */
    public void setBackoffMetadata(int i, Date date) {
        synchronized (this.backoffMetadataLock) {
            this.frcMetadata.edit().putInt(NUM_FAILED_FETCHES_KEY, i).putLong(BACKOFF_END_TIME_IN_MILLIS_KEY, date.getTime()).apply();
        }
    }

    /* access modifiers changed from: package-private */
    public void resetBackoff() {
        setBackoffMetadata(0, NO_BACKOFF_TIME);
    }

    static class BackoffMetadata {
        private Date backoffEndTime;
        private int numFailedFetches;

        BackoffMetadata(int i, Date date) {
            this.numFailedFetches = i;
            this.backoffEndTime = date;
        }

        /* access modifiers changed from: package-private */
        public int getNumFailedFetches() {
            return this.numFailedFetches;
        }

        /* access modifiers changed from: package-private */
        public Date getBackoffEndTime() {
            return this.backoffEndTime;
        }
    }

    /* access modifiers changed from: package-private */
    public RealtimeBackoffMetadata getRealtimeBackoffMetadata() {
        RealtimeBackoffMetadata realtimeBackoffMetadata;
        synchronized (this.realtimeBackoffMetadataLock) {
            realtimeBackoffMetadata = new RealtimeBackoffMetadata(this.frcMetadata.getInt(NUM_FAILED_REALTIME_STREAMS_KEY, 0), new Date(this.frcMetadata.getLong(REALTIME_BACKOFF_END_TIME_IN_MILLIS_KEY, -1)));
        }
        return realtimeBackoffMetadata;
    }

    /* access modifiers changed from: package-private */
    public void setRealtimeBackoffMetadata(int i, Date date) {
        synchronized (this.realtimeBackoffMetadataLock) {
            this.frcMetadata.edit().putInt(NUM_FAILED_REALTIME_STREAMS_KEY, i).putLong(REALTIME_BACKOFF_END_TIME_IN_MILLIS_KEY, date.getTime()).apply();
        }
    }

    /* access modifiers changed from: package-private */
    public void resetRealtimeBackoff() {
        setRealtimeBackoffMetadata(0, NO_BACKOFF_TIME);
    }

    static class RealtimeBackoffMetadata {
        private Date backoffEndTime;
        private int numFailedStreams;

        RealtimeBackoffMetadata(int i, Date date) {
            this.numFailedStreams = i;
            this.backoffEndTime = date;
        }

        /* access modifiers changed from: package-private */
        public int getNumFailedStreams() {
            return this.numFailedStreams;
        }

        /* access modifiers changed from: package-private */
        public Date getBackoffEndTime() {
            return this.backoffEndTime;
        }
    }
}
