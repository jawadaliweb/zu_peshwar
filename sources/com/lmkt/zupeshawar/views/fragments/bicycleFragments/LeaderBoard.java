package com.lmkt.zupeshawar.views.fragments.bicycleFragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.model.LeaderBoardModel;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.presenter.IOnBackPressed;
import com.lmkt.zupeshawar.views.activities.BicycleMenuItem;
import com.lmkt.zupeshawar.views.adapters.RecyclerViewLeaderBoardAdapter;
import com.lmkt.zupeshawar.views.adapters.ViewPagerAdapter;
import com.lmkt.zupeshawar.views.fragments.bicycleFragments.LeaderBoard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeaderBoard extends Fragment implements View.OnClickListener, IOnBackPressed {
    static int Title = 2131886217;
    BicycleMenuItem activity;
    /* access modifiers changed from: private */
    public RecyclerViewLeaderBoardAdapter adapter = null;
    /* access modifiers changed from: private */
    public TabLayout mTabLayout;
    private ViewPagerAdapter mViewPagerAdapter;
    /* access modifiers changed from: private */
    public List<LeaderBoardModel> monthsList = new ArrayList();
    private TextView name;
    private TextView number;
    /* access modifiers changed from: private */
    public RecyclerView rv;
    private TextView usage;
    /* access modifiers changed from: private */
    public List<LeaderBoardModel> weeksList = new ArrayList();
    /* access modifiers changed from: private */
    public List<LeaderBoardModel> yearsList = new ArrayList();

    public boolean onBackPressed() {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_leader_board, viewGroup, false);
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
        initViewPager(view);
        getLeaderBoard();
    }

    private void initViewPager(View view) {
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        this.mTabLayout = tabLayout;
        tabLayout.addTab(tabLayout.newTab().setText((int) R.string.this_week));
        TabLayout tabLayout2 = this.mTabLayout;
        tabLayout2.addTab(tabLayout2.newTab().setText((int) R.string.this_month));
        TabLayout tabLayout3 = this.mTabLayout;
        tabLayout3.addTab(tabLayout3.newTab().setText((int) R.string.this_year));
        this.mTabLayout.setTabMode(1);
        this.mTabLayout.setTabTextColors(getResources().getColor(R.color.txt_color_Lightgrey), getResources().getColor(R.color.colorBlack));
        this.mTabLayout.setScrollPosition(0, 0.0f, true);
        this.mTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
        this.mTabLayout.setSelectedTabIndicatorHeight((int) (getResources().getDisplayMetrics().density * 5.0f));
        this.mTabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        this.mTabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void onTabReselected(TabLayout.Tab tab) {
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }

            public void onTabSelected(TabLayout.Tab tab) {
                LeaderBoard leaderBoard = LeaderBoard.this;
                leaderBoard.setData(leaderBoard.mTabLayout.getSelectedTabPosition());
            }
        });
        this.name = (TextView) view.findViewById(R.id.name);
        this.number = (TextView) view.findViewById(R.id.number);
        this.usage = (TextView) view.findViewById(R.id.time);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        this.rv = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.activity));
        RecyclerView recyclerView2 = this.rv;
        recyclerView2.addItemDecoration(new DividerItemDecoration(recyclerView2.getContext(), 0));
    }

    private void initToolbar() {
        BicycleMenuItem bicycleMenuItem = (BicycleMenuItem) getActivity();
        this.activity = bicycleMenuItem;
        bicycleMenuItem.mToolbar_Title.setText(Title);
        this.activity.mToolbar_BackBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.Btn_Back) {
            this.activity.finish();
            this.activity.overridePendingTransition(R.anim.stay, R.anim.exit_to_right);
        }
    }

    public void getLeaderBoard() {
        APIManager.getInstance().getLeaderBoard(new APIManager.Callback() {
            public void onSuccess(int i, ApiResponse apiResponse) {
                LeaderBoard.this.activity.appAlerts.dismiss();
                if (i == ReturnCodes.Companion.OK()) {
                    if (LeaderBoard.this.adapter == null) {
                        LeaderBoard leaderBoard = LeaderBoard.this;
                        RecyclerViewLeaderBoardAdapter unused = leaderBoard.adapter = new RecyclerViewLeaderBoardAdapter(leaderBoard.getContext());
                        LeaderBoard.this.rv.setAdapter(LeaderBoard.this.adapter);
                    }
                    LeaderBoard.this.weeksList.clear();
                    LeaderBoard.this.monthsList.clear();
                    LeaderBoard.this.yearsList.clear();
                    ArrayList<LeaderBoardModel> leaderBoards = apiResponse.getData().getLeaderBoards();
                    if (leaderBoards != null && leaderBoards.size() > 0) {
                        for (LeaderBoardModel next : leaderBoards) {
                            if (next.getPeriod().trim().equalsIgnoreCase("week")) {
                                LeaderBoard.this.weeksList.add(next);
                            } else if (next.getPeriod().trim().equalsIgnoreCase("month")) {
                                new LeaderBoardModel();
                                LeaderBoard.this.monthsList.add(next);
                            } else if (next.getPeriod().trim().equalsIgnoreCase("year")) {
                                LeaderBoard.this.yearsList.add(next);
                            }
                        }
                    }
                    LeaderBoard.this.sortData();
                    LeaderBoard leaderBoard2 = LeaderBoard.this;
                    leaderBoard2.setData(leaderBoard2.mTabLayout.getSelectedTabPosition());
                    return;
                }
                LeaderBoard.this.activity.appAlerts.showErrorDialog(LeaderBoard.this.activity, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                    public final void onClicked() {
                        LeaderBoard.AnonymousClass2.this.lambda$onSuccess$0$LeaderBoard$2();
                    }
                });
            }

            public /* synthetic */ void lambda$onSuccess$0$LeaderBoard$2() {
                LeaderBoard.this.activity.appAlerts.dismiss();
            }

            public void onFailure(int i, String str) {
                LeaderBoard.this.activity.appAlerts.dismiss();
            }
        }, getContext());
    }

    /* access modifiers changed from: private */
    public void sortData() {
        Collections.sort(this.weeksList, new Comparator<LeaderBoardModel>() {
            public int compare(LeaderBoardModel leaderBoardModel, LeaderBoardModel leaderBoardModel2) {
                return leaderBoardModel2.getUsage() - leaderBoardModel.getUsage();
            }
        });
        Collections.sort(this.monthsList, new Comparator<LeaderBoardModel>() {
            public int compare(LeaderBoardModel leaderBoardModel, LeaderBoardModel leaderBoardModel2) {
                return leaderBoardModel2.getUsage() - leaderBoardModel.getUsage();
            }
        });
        Collections.sort(this.yearsList, new Comparator<LeaderBoardModel>() {
            public int compare(LeaderBoardModel leaderBoardModel, LeaderBoardModel leaderBoardModel2) {
                return leaderBoardModel2.getUsage() - leaderBoardModel.getUsage();
            }
        });
    }

    /* access modifiers changed from: private */
    public void setData(int i) {
        if (i == 0) {
            setFirstPosition(this.weeksList);
            this.adapter.updateList(this.weeksList);
        } else if (i == 1) {
            setFirstPosition(this.monthsList);
            this.adapter.updateList(this.monthsList);
        } else if (i == 2) {
            setFirstPosition(this.yearsList);
            this.adapter.updateList(this.yearsList);
        }
    }

    private void setFirstPosition(List<LeaderBoardModel> list) {
        if (list != null && list.size() > 0) {
            this.name.setText(list.get(0).getName());
            this.number.setText(list.get(0).getMobileNumber());
            TextView textView = this.usage;
            textView.setText(list.get(0).getUsage() + "");
        }
    }
}
