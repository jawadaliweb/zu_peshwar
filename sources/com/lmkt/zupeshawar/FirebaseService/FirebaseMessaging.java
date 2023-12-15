package com.lmkt.zupeshawar.FirebaseService;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.Constants;
import com.lmkt.zupeshawar.Utilities.Helper;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.views.activities.BaseActivity;
import com.lmkt.zupeshawar.views.activities.MainDashboard;
import com.lmkt.zupeshawar.views.activities.NotificationActivity;
import com.lmkt.zupeshawar.views.activities.SplashActivity;

public class FirebaseMessaging extends FirebaseMessagingService {
    private static final String TAG = "FCM :: ";
    String NOTIFICATION_CHANNEL_ID = "ZuPeshawarNotification";

    public void onNewToken(String str) {
        Log.e("NEW_TOKEN", str);
        BaseActivity.FCM_TOKEN = str;
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.e(TAG, "From: " + remoteMessage.getFrom());
        if (remoteMessage.getData().size() > 0) {
            Log.e(TAG, "Message data payload: " + remoteMessage.getData());
        }
        if (remoteMessage.getNotification() != null) {
            Log.e(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getBody());
        }
    }

    public void sendNotification(String str) {
        PendingIntent pendingIntent;
        if (new Helper().isAppRunning(this, getApplicationContext().getPackageName())) {
            Intent intent = new Intent(getApplicationContext(), NotificationActivity.class);
            intent.putExtra("isFromFirebase", true);
            pendingIntent = PendingIntent.getActivity(this, 0, intent, 1107296256);
            sendBroadcast(new Intent(MainDashboard.receiveTAG));
        } else {
            Intent intent2 = new Intent(getApplicationContext(), SplashActivity.class);
            intent2.putExtra("isFromFirebase", true);
            pendingIntent = PendingIntent.getActivity(this, 0, intent2, 1107296256);
            sendBroadcast(new Intent(MainDashboard.receiveTAG));
        }
        String str2 = this.NOTIFICATION_CHANNEL_ID;
        String string = getString(R.string.app_name);
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder((Context) this, str2).setContentTitle(string).setStyle(new NotificationCompat.BigTextStyle().bigText(str)).setContentText(str).setAutoCancel(true).setColor(getResources().getColor(R.color.primaryColor)).setSound(RingtoneManager.getDefaultUri(2)).setContentIntent(pendingIntent);
        if (Build.VERSION.SDK_INT >= 21) {
            contentIntent.setSmallIcon((int) R.drawable.ic_notification);
            contentIntent.setColor(getResources().getColor(R.color.material_blue_grey_80));
        } else {
            contentIntent.setSmallIcon((int) R.mipmap.ic_launcher);
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(str2, "Channel human readable title", 3));
        }
        SharedPrefrencesUtil.setInt(Constants.NOTIFICATION_COUNT, SharedPrefrencesUtil.getInt(Constants.NOTIFICATION_COUNT, this) + 1, this);
        notificationManager.notify(0, contentIntent.build());
    }
}
