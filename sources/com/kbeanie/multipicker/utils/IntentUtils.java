package com.kbeanie.multipicker.utils;

import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;

public class IntentUtils {
    @Deprecated
    public static Intent getIntentForMultipleSelection(Intent intent) {
        Intent intent2 = new Intent();
        String action = intent.getAction();
        if (action.equals("android.intent.action.SEND_MULTIPLE")) {
            intent2.putParcelableArrayListExtra("uris", (ArrayList) intent.getExtras().get("android.intent.extra.STREAM"));
        } else if (action.equals("android.intent.action.SEND")) {
            intent2.setData((Uri) intent.getExtras().get("android.intent.extra.STREAM"));
        }
        return intent2;
    }

    public static Intent getPickerIntentForSharing(Intent intent) {
        Intent intent2 = new Intent();
        String action = intent.getAction();
        if (action.equals("android.intent.action.SEND_MULTIPLE")) {
            intent2.putParcelableArrayListExtra("uris", (ArrayList) intent.getExtras().get("android.intent.extra.STREAM"));
        } else if (action.equals("android.intent.action.SEND")) {
            intent2.setData((Uri) intent.getExtras().get("android.intent.extra.STREAM"));
        }
        return intent2;
    }
}
