package com.lmkt.zupeshawar.views.fragments.ticketsFragments;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.databinding.FragmentZuCardRechargeBinding;
import com.lmkt.zupeshawar.views.activities.TicketsMenuItemActivity;
import com.lmkt.zupeshawar.views.activities.zuCardServices.ZuCardDetail;

public class ZuCardRecharge extends Fragment implements View.OnClickListener {
    TicketsMenuItemActivity activity;
    NfcAdapter adapter;
    FragmentZuCardRechargeBinding binding;

    public void foregroudDispatch() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = FragmentZuCardRechargeBinding.inflate(layoutInflater, viewGroup, false);
        initView();
        return this.binding.getRoot();
    }

    private void initView() {
        initToolbar();
        this.binding.Test.setOnClickListener(this);
        getAdapter();
    }

    private void getAdapter() {
        NfcAdapter defaultAdapter = ((NfcManager) this.activity.getSystemService("nfc")).getDefaultAdapter();
        this.adapter = defaultAdapter;
        if (defaultAdapter == null) {
            Toast.makeText(getContext(), "this feature is not available", 1).show();
        }
    }

    private void initToolbar() {
        TicketsMenuItemActivity ticketsMenuItemActivity = (TicketsMenuItemActivity) getActivity();
        this.activity = ticketsMenuItemActivity;
        ticketsMenuItemActivity.mToolbar_Title.setText(R.string.zu_card_recharge_title);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.Btn_Back) {
            this.activity.finish();
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        } else if (id == R.id.Test) {
            startActivity(new Intent(getActivity(), ZuCardDetail.class));
        }
    }

    public void onResume() {
        super.onResume();
    }
}
