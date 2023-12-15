package com.lmkt.zupeshawar.networkManager;

import com.lmkt.zupeshawar.BuildConfig;

public class Urls {
    public static String BASE_URL = "";
    public static boolean isTestEnv = false;

    public enum Environment {
        Live,
        Test,
        Live_PWR
    }

    /* renamed from: com.lmkt.zupeshawar.networkManager.Urls$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$lmkt$zupeshawar$networkManager$Urls$Environment;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.lmkt.zupeshawar.networkManager.Urls$Environment[] r0 = com.lmkt.zupeshawar.networkManager.Urls.Environment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$lmkt$zupeshawar$networkManager$Urls$Environment = r0
                com.lmkt.zupeshawar.networkManager.Urls$Environment r1 = com.lmkt.zupeshawar.networkManager.Urls.Environment.Live     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$lmkt$zupeshawar$networkManager$Urls$Environment     // Catch:{ NoSuchFieldError -> 0x001d }
                com.lmkt.zupeshawar.networkManager.Urls$Environment r1 = com.lmkt.zupeshawar.networkManager.Urls.Environment.Live_PWR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$lmkt$zupeshawar$networkManager$Urls$Environment     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.lmkt.zupeshawar.networkManager.Urls$Environment r1 = com.lmkt.zupeshawar.networkManager.Urls.Environment.Test     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.networkManager.Urls.AnonymousClass1.<clinit>():void");
        }
    }

    public static void SetURL(Environment environment) {
        int i = AnonymousClass1.$SwitchMap$com$lmkt$zupeshawar$networkManager$Urls$Environment[environment.ordinal()];
        if (i == 1) {
            BASE_URL = BuildConfig.baseURLLive;
            isTestEnv = true;
        } else if (i == 2) {
            BASE_URL = BuildConfig.baseURLLivePWR;
            isTestEnv = true;
        } else if (i == 3) {
            BASE_URL = "https://brtapp.lmkr.net:5000/api/";
            isTestEnv = true;
        }
    }
}
