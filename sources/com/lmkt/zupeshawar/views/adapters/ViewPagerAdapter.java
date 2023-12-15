package com.lmkt.zupeshawar.views.adapters;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import br.com.sapereaude.maskedEditText.MaskedEditText;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.views.fragments.Bicycle;
import com.lmkt.zupeshawar.views.fragments.MainMenu;
import com.lmkt.zupeshawar.views.fragments.Tickets;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private int TAB_COUNT = 3;
    Context context;

    public ViewPagerAdapter(FragmentManager fragmentManager, Context context2) {
        super(fragmentManager);
        this.context = context2;
    }

    public Fragment getItem(int i) {
        if (i == 0) {
            return new MainMenu();
        }
        if (i == 1) {
            return new Bicycle();
        }
        if (i != 2) {
            return null;
        }
        return new Tickets();
    }

    public int getCount() {
        return this.TAB_COUNT;
    }

    public CharSequence getPageTitle(int i) {
        if (i != 0) {
            if (i == 1) {
                int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen._16sdp);
                int dimensionPixelSize2 = this.context.getResources().getDimensionPixelSize(R.dimen._8sdp);
                if (SharedPrefrencesUtil.getBoolean("Is_Urdu_Lan", this.context)) {
                    String str = Bicycle.TITLE_UR;
                    SpannableString spannableString = new SpannableString(str);
                    spannableString.setSpan(new AbsoluteSizeSpan(dimensionPixelSize), 0, str.length(), 18);
                    SpannableString spannableString2 = new SpannableString("");
                    spannableString2.setSpan(new AbsoluteSizeSpan(dimensionPixelSize2), 0, 0, 18);
                    return TextUtils.concat(new CharSequence[]{spannableString, MaskedEditText.SPACE, spannableString2});
                }
                String str2 = Bicycle.TITLE;
                SpannableString spannableString3 = new SpannableString(str2);
                spannableString3.setSpan(new AbsoluteSizeSpan(dimensionPixelSize), 0, str2.length(), 18);
                SpannableString spannableString4 = new SpannableString("");
                spannableString4.setSpan(new AbsoluteSizeSpan(dimensionPixelSize2), 0, 0, 18);
                return TextUtils.concat(new CharSequence[]{spannableString3, MaskedEditText.SPACE, spannableString4});
            } else if (i != 2) {
                return super.getPageTitle(i);
            } else {
                if (SharedPrefrencesUtil.getBoolean("Is_Urdu_Lan", this.context)) {
                    return Tickets.TITLE_UR;
                }
                return Tickets.TITLE;
            }
        } else if (SharedPrefrencesUtil.getBoolean("Is_Urdu_Lan", this.context)) {
            return MainMenu.TITLE_UR;
        } else {
            return MainMenu.TITLE;
        }
    }
}
