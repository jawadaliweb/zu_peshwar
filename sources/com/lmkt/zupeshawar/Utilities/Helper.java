package com.lmkt.zupeshawar.Utilities;

import android.app.ActivityManager;
import android.content.Context;
import br.com.sapereaude.maskedEditText.MaskedEditText;
import com.lmkt.zupeshawar.model.RechargeHistory;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public boolean isAppRunning(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<RechargeHistory> get_TransactionHistory(ArrayList<RechargeHistory> arrayList) {
        ArrayList<RechargeHistory> arrayList2 = new ArrayList<>();
        String str = "";
        for (int i = 0; i < arrayList.size(); i++) {
            String[] split = arrayList.get(i).getTransactionDate().split(MaskedEditText.SPACE);
            if (!str.equals(split[0])) {
                RechargeHistory rechargeHistory = new RechargeHistory(split[0]);
                rechargeHistory.setSectionHeader(true);
                arrayList2.add(rechargeHistory);
                str = split[0];
            }
            arrayList2.add(arrayList.get(i));
        }
        return arrayList2;
    }
}
