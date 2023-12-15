package com.lmkt.zupeshawar.views.fragments.navDrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.model.User;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.views.activities.NavigationDrawerItemsActivity;

public class MyProfile extends Fragment implements View.OnClickListener {
    TextView DOB_TV;
    TextView Email_TV;
    TextView MemberSince_TV;
    TextView Name_TV;
    TextView PackageExpiry_TV;
    TextView RefundableSecurity_TV;
    TextView TotalBalance_TV;
    TextView ZuBicycle_TV;
    NavigationDrawerItemsActivity activity;
    TextView cardNo_TV;
    TextView mobileNo;
    User user = new User();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_navi_myprofile, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            initViews(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        this.Name_TV = (TextView) view.findViewById(R.id.Name_TV);
        this.Email_TV = (TextView) view.findViewById(R.id.Email_TV);
        this.DOB_TV = (TextView) view.findViewById(R.id.DOB_TV);
        this.cardNo_TV = (TextView) view.findViewById(R.id.cardNo_TV);
        this.TotalBalance_TV = (TextView) view.findViewById(R.id.TotalBalance_TV);
        this.ZuBicycle_TV = (TextView) view.findViewById(R.id.ZuBicycle_TV);
        this.MemberSince_TV = (TextView) view.findViewById(R.id.MemberSince_TV);
        this.mobileNo = (TextView) view.findViewById(R.id.mobileNo);
        this.PackageExpiry_TV = (TextView) view.findViewById(R.id.PackageExpiry_TV);
        this.RefundableSecurity_TV = (TextView) view.findViewById(R.id.RefundableSecurity_TV);
        this.user = SharedPrefrencesUtil.getUserObject_Prefrences(getActivity());
        this.activity.appAlerts.showPleaseWait(this.activity);
        makeApiCall();
    }

    private void makeApiCall() throws Exception {
        APIManager.getInstance().getUser(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                MyProfile.this.activity.appAlerts.dismiss();
                if (i == ReturnCodes.Companion.OK()) {
                    apiResponse.getData().getUserStatus();
                    MyProfile.this.user = apiResponse.getData().getUser();
                    if (MyProfile.this.user != null) {
                        MyProfile.this.Name_TV.setText(MyProfile.this.user.getName());
                        MyProfile.this.Email_TV.setText(MyProfile.this.user.getEmail());
                        MyProfile.this.DOB_TV.setText(MyProfile.this.user.getDob());
                        MyProfile.this.cardNo_TV.setText(MyProfile.this.user.getMobileNumber());
                        MyProfile.this.mobileNo.setText(MyProfile.this.user.getMobileNumber());
                        TextView textView = MyProfile.this.TotalBalance_TV;
                        textView.setText("Rs. " + MyProfile.this.user.getAccountBalance());
                        if (MyProfile.this.user.getZuBicylce()) {
                            MyProfile.this.ZuBicycle_TV.setText("Zu Bicycle Enabled");
                        } else {
                            MyProfile.this.ZuBicycle_TV.setText("Zu Bicycle Disabled");
                        }
                        MyProfile.this.MemberSince_TV.setText(MyProfile.this.user.getMemberSince());
                        if (MyProfile.this.user.getPackageExpiry().equals("")) {
                            MyProfile.this.PackageExpiry_TV.setText("Not Available");
                        } else {
                            MyProfile.this.PackageExpiry_TV.setText(MyProfile.this.user.getPackageExpiry());
                        }
                        TextView textView2 = MyProfile.this.RefundableSecurity_TV;
                        textView2.setText("Rs. " + MyProfile.this.user.getRefundableSecurity());
                    }
                }
            }

            public void onFailure(int i, String str) {
                MyProfile.this.activity.appAlerts.dismiss();
            }
        }, this.user.getMobileNumber());
    }

    private void initToolbar() {
        NavigationDrawerItemsActivity navigationDrawerItemsActivity = (NavigationDrawerItemsActivity) getActivity();
        this.activity = navigationDrawerItemsActivity;
        navigationDrawerItemsActivity.mToolbar_Title.setText(R.string.title_profile);
        this.activity.mToolbar_LeftBtn.setVisibility(8);
    }

    public void onClick(View view) {
        view.getId();
    }
}
