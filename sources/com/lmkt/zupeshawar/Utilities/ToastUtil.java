package com.lmkt.zupeshawar.Utilities;

import android.content.Context;
import es.dmoral.toasty.Toasty;

public class ToastUtil {
    private static Context context = null;
    private static ToastUtil mInstance = null;
    private static String msg = "";

    public enum ToastType {
        success,
        error,
        error_icon,
        success_icon,
        normal,
        normal_icon,
        warning,
        warning_icon
    }

    private ToastUtil(Context context2) {
        context = context2;
    }

    public static ToastUtil newInstance(Context context2) {
        Toasty.Config.getInstance().allowQueue(false).apply();
        return new ToastUtil(context2);
    }

    public static void showToast(ToastType toastType, String str) {
        msg = str;
        switch (AnonymousClass1.$SwitchMap$com$lmkt$zupeshawar$Utilities$ToastUtil$ToastType[toastType.ordinal()]) {
            case 1:
                Toasty.error(context, (CharSequence) msg, 0, true).show();
                return;
            case 2:
                Toasty.error(context, (CharSequence) msg, 0, false).show();
                return;
            case 3:
                Toasty.normal(context, (CharSequence) msg, 0).show();
                return;
            case 4:
                Toasty.normal(context, (CharSequence) msg, 0).show();
                return;
            case 5:
                Toasty.success(context, (CharSequence) msg, 0, true).show();
                return;
            case 6:
                Toasty.success(context, (CharSequence) msg, 0, false).show();
                return;
            case 7:
                Toasty.warning(context, (CharSequence) msg, 0, true).show();
                return;
            case 8:
                Toasty.warning(context, (CharSequence) msg, 0, false).show();
                return;
            default:
                return;
        }
    }

    /* renamed from: com.lmkt.zupeshawar.Utilities.ToastUtil$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$lmkt$zupeshawar$Utilities$ToastUtil$ToastType;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.lmkt.zupeshawar.Utilities.ToastUtil$ToastType[] r0 = com.lmkt.zupeshawar.Utilities.ToastUtil.ToastType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$lmkt$zupeshawar$Utilities$ToastUtil$ToastType = r0
                com.lmkt.zupeshawar.Utilities.ToastUtil$ToastType r1 = com.lmkt.zupeshawar.Utilities.ToastUtil.ToastType.error_icon     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$lmkt$zupeshawar$Utilities$ToastUtil$ToastType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.lmkt.zupeshawar.Utilities.ToastUtil$ToastType r1 = com.lmkt.zupeshawar.Utilities.ToastUtil.ToastType.error     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$lmkt$zupeshawar$Utilities$ToastUtil$ToastType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.lmkt.zupeshawar.Utilities.ToastUtil$ToastType r1 = com.lmkt.zupeshawar.Utilities.ToastUtil.ToastType.normal_icon     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$lmkt$zupeshawar$Utilities$ToastUtil$ToastType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.lmkt.zupeshawar.Utilities.ToastUtil$ToastType r1 = com.lmkt.zupeshawar.Utilities.ToastUtil.ToastType.normal     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$lmkt$zupeshawar$Utilities$ToastUtil$ToastType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.lmkt.zupeshawar.Utilities.ToastUtil$ToastType r1 = com.lmkt.zupeshawar.Utilities.ToastUtil.ToastType.success_icon     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$lmkt$zupeshawar$Utilities$ToastUtil$ToastType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.lmkt.zupeshawar.Utilities.ToastUtil$ToastType r1 = com.lmkt.zupeshawar.Utilities.ToastUtil.ToastType.success     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$lmkt$zupeshawar$Utilities$ToastUtil$ToastType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.lmkt.zupeshawar.Utilities.ToastUtil$ToastType r1 = com.lmkt.zupeshawar.Utilities.ToastUtil.ToastType.warning_icon     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$lmkt$zupeshawar$Utilities$ToastUtil$ToastType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.lmkt.zupeshawar.Utilities.ToastUtil$ToastType r1 = com.lmkt.zupeshawar.Utilities.ToastUtil.ToastType.warning     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lmkt.zupeshawar.Utilities.ToastUtil.AnonymousClass1.<clinit>():void");
        }
    }
}
