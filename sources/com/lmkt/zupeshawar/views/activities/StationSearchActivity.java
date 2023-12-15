package com.lmkt.zupeshawar.views.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.Utilities.Constants;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.model.dataModels.Stations;
import com.lmkt.zupeshawar.model.dataModels._Models;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.views.activities.StationSearchActivity;
import in.myinnos.alphabetsindexfastscrollrecycler.IndexFastScrollRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StationSearchActivity extends BaseActivity {
    FrameLayout Btn_Back;
    IndexFastScrollRecyclerView mainSearch_RV;
    RecyclerViewAdapter mainSearch_RVAdapter;
    LinearLayout recentSearchLayout;
    IndexFastScrollRecyclerView recentSearch_RV;
    RecyclerViewAdapter recentSearch_RVAdapter;
    EditText search_ET;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_search_stations);
        try {
            initView();
            setListeners();
            initialiseMainSearch_RV();
            if (_Models.recentSearch.size() > 0) {
                initialiseRecentSearch_RV();
                this.recentSearchLayout.setVisibility(0);
                return;
            }
            this.recentSearchLayout.setVisibility(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        _Models.recentSearch = (ArrayList) new Gson().fromJson(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("favStop", ""), new TypeToken<List<Stations>>() {
        }.getType());
        if (_Models.recentSearch == null) {
            _Models.recentSearch = new ArrayList<>();
        }
        this.search_ET = (EditText) findViewById(R.id.search_ET);
        this.Btn_Back = (FrameLayout) findViewById(R.id.Btn_Back);
        this.recentSearchLayout = (LinearLayout) findViewById(R.id.recentSearchLayout);
    }

    public /* synthetic */ void lambda$setListeners$0$StationSearchActivity(View view) {
        finish();
    }

    /* access modifiers changed from: protected */
    public void setListeners() {
        this.Btn_Back.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                StationSearchActivity.this.lambda$setListeners$0$StationSearchActivity(view);
            }
        });
        this.search_ET.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                StationSearchActivity.this.mainSearch_RVAdapter.getFilter().filter(StationSearchActivity.this.search_ET.getText().toString());
                if (!StationSearchActivity.this.search_ET.getText().toString().equals("")) {
                    StationSearchActivity.this.recentSearchLayout.setVisibility(8);
                } else if (_Models.recentSearch.size() == 0) {
                    StationSearchActivity.this.recentSearchLayout.setVisibility(8);
                } else {
                    StationSearchActivity.this.recentSearchLayout.setVisibility(0);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initialiseRecentSearch_RV() throws Exception {
        if (_Models.recentSearch.size() > 5) {
            _Models.recentSearch.remove(0);
        }
        IndexFastScrollRecyclerView indexFastScrollRecyclerView = (IndexFastScrollRecyclerView) findViewById(R.id.recentSearch_RV);
        this.recentSearch_RV = indexFastScrollRecyclerView;
        indexFastScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(_Models.recentSearch);
        this.recentSearch_RVAdapter = recyclerViewAdapter;
        this.recentSearch_RV.setAdapter(recyclerViewAdapter);
        this.recentSearch_RV.setIndexBarVisibility(false);
        this.recentSearch_RVAdapter.setClickListener(new RecyclerViewAdapter.ItemClickListener() {
            public final void onItemClick(View view, int i, Stations stations) {
                StationSearchActivity.this.lambda$initialiseRecentSearch_RV$1$StationSearchActivity(view, i, stations);
            }
        });
    }

    public /* synthetic */ void lambda$initialiseRecentSearch_RV$1$StationSearchActivity(View view, int i, Stations stations) {
        this.search_ET.setText(stations.name);
        EditText editText = this.search_ET;
        editText.setSelection(editText.getText().length());
        Intent intent = new Intent();
        intent.putExtra("stationName", stations.name);
        intent.putExtra("stationId", stations.stationID);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void initialiseMainSearch_RV() {
        this.mainSearch_RV = (IndexFastScrollRecyclerView) findViewById(R.id.mainSearch_RV);
        if (SharedPrefrencesUtil.getString(Constants.STATIONS_LOV, this).isEmpty()) {
            this.appAlerts.showPleaseWait(this);
            APIManager.getInstance().getStops(new APIManager.Callback() {
                public void onSuccess(int i, ApiResponse apiResponse) {
                    StationSearchActivity.this.appAlerts.dismiss();
                    if (i == ReturnCodes.Companion.OK()) {
                        try {
                            SharedPrefrencesUtil.saveString(Constants.STATIONS_LOV, new Gson().toJson((Object) apiResponse.getData().getStations()), StationSearchActivity.this.getApplicationContext());
                            StationSearchActivity.this.fillStations(apiResponse.getData().getStations());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                        StationSearchActivity.this.appAlerts.showErrorAndLogout(StationSearchActivity.this.getParent(), apiResponse.getRespMessage());
                    } else if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                        StationSearchActivity.this.appAlerts.showErrorAndLogout(StationSearchActivity.this.getParent(), apiResponse.getRespMessage());
                    } else {
                        StationSearchActivity.this.appAlerts.showErrorDialog(StationSearchActivity.this.getApplicationContext(), apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                            public final void onClicked() {
                                StationSearchActivity.AnonymousClass3.this.lambda$onSuccess$0$StationSearchActivity$3();
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onSuccess$0$StationSearchActivity$3() {
                    StationSearchActivity.this.appAlerts.dismiss();
                }

                public void onFailure(int i, String str) {
                    StationSearchActivity.this.appAlerts.dismiss();
                    if (i == ReturnCodes.Companion.INVALID_DEVICE()) {
                        StationSearchActivity.this.appAlerts.showErrorAndLogout(StationSearchActivity.this.getParent(), str);
                    } else {
                        StationSearchActivity.this.appAlerts.showErrorDialog(StationSearchActivity.this.getApplicationContext(), str, new AppAlertDialog.AlertDialogListener() {
                            public final void onClicked() {
                                StationSearchActivity.AnonymousClass3.this.lambda$onFailure$1$StationSearchActivity$3();
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onFailure$1$StationSearchActivity$3() {
                    StationSearchActivity.this.appAlerts.dismiss();
                }
            }, this);
            return;
        }
        fillStations((ArrayList) new Gson().fromJson(SharedPrefrencesUtil.getString(Constants.STATIONS_LOV, getApplicationContext()), new TypeToken<List<Stations>>() {
        }.getType()));
    }

    /* access modifiers changed from: package-private */
    public void fillStations(ArrayList<Stations> arrayList) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(arrayList);
        this.mainSearch_RVAdapter = recyclerViewAdapter;
        this.mainSearch_RV.setAdapter(recyclerViewAdapter);
        this.mainSearch_RV.setIndexTextSize(12);
        this.mainSearch_RV.setIndexBarColor("#33334c");
        this.mainSearch_RV.setIndexBarCornerRadius(0);
        this.mainSearch_RV.setIndexBarTransparentValue(0.4f);
        this.mainSearch_RV.setIndexbarMargin(20.0f);
        this.mainSearch_RV.setIndexbarWidth(40.0f);
        this.mainSearch_RV.setPreviewPadding(0);
        this.mainSearch_RV.setIndexBarTextColor("#FFFFFF");
        this.mainSearch_RV.setIndexBarVisibility(false);
        this.mainSearch_RV.setIndexbarHighLateTextColor("#33334c");
        this.mainSearch_RV.setIndexBarHighLateTextVisibility(true);
        this.mainSearch_RV.setLayoutManager(new LinearLayoutManager(this));
        this.mainSearch_RVAdapter.setClickListener(new RecyclerViewAdapter.ItemClickListener() {
            public final void onItemClick(View view, int i, Stations stations) {
                StationSearchActivity.this.lambda$fillStations$2$StationSearchActivity(view, i, stations);
            }
        });
    }

    public /* synthetic */ void lambda$fillStations$2$StationSearchActivity(View view, int i, Stations stations) {
        this.search_ET.setText(stations.name);
        EditText editText = this.search_ET;
        editText.setSelection(editText.getText().length());
        addRecentSearchItem(stations);
        Intent intent = new Intent();
        intent.putExtra("stationName", stations.name);
        intent.putExtra("stationId", stations.stationID);
        setResult(-1, intent);
        finish();
    }

    private void addRecentSearchItem(Stations stations) {
        if (_Models.recentSearch != null) {
            int i = 0;
            while (i < _Models.recentSearch.size()) {
                if (!stations.name.equals(_Models.recentSearch.get(i).name)) {
                    i++;
                } else {
                    return;
                }
            }
            _Models.recentSearch.add(stations);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Gson gson = new Gson();
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
        edit.putString("favStop", gson.toJson((Object) _Models.recentSearch));
        edit.apply();
        finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public static class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> implements SectionIndexer, Filterable {
        /* access modifiers changed from: private */
        public ArrayList<Stations> list;
        /* access modifiers changed from: private */
        public ItemClickListener mClickListener;
        /* access modifiers changed from: private */
        public ArrayList<Stations> mDataArray;
        private ArrayList<Integer> mSectionPositions;

        public interface ItemClickListener {
            void onItemClick(View view, int i, Stations stations);
        }

        public int getSectionForPosition(int i) {
            return 0;
        }

        public RecyclerViewAdapter(ArrayList<Stations> arrayList) {
            this.mDataArray = arrayList;
            this.list = arrayList;
        }

        public int getItemCount() {
            ArrayList<Stations> arrayList = this.mDataArray;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_view_layout, viewGroup, false));
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.mTextView.setText(this.mDataArray.get(i).name);
        }

        public Object[] getSections() {
            ArrayList arrayList = new ArrayList(26);
            this.mSectionPositions = new ArrayList<>(26);
            try {
                int size = this.mDataArray.size();
                for (int i = 0; i < size; i++) {
                    String upperCase = String.valueOf(this.mDataArray.get(i).name.charAt(0)).toUpperCase();
                    if (!arrayList.contains(upperCase)) {
                        arrayList.add(upperCase);
                        this.mSectionPositions.add(Integer.valueOf(i));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList.toArray(new String[0]);
        }

        public int getPositionForSection(int i) {
            return this.mSectionPositions.get(i).intValue();
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.mClickListener = itemClickListener;
        }

        public Filter getFilter() {
            return new Filter() {
                /* access modifiers changed from: protected */
                public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    ArrayList unused = RecyclerViewAdapter.this.mDataArray = (ArrayList) filterResults.values;
                    RecyclerViewAdapter.this.notifyDataSetChanged();
                }

                /* access modifiers changed from: protected */
                public Filter.FilterResults performFiltering(CharSequence charSequence) {
                    Object obj;
                    if (charSequence.length() == 0) {
                        obj = RecyclerViewAdapter.this.list;
                    } else {
                        obj = RecyclerViewAdapter.this.getFilteredResults(charSequence.toString().toLowerCase());
                    }
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    filterResults.values = obj;
                    return filterResults;
                }
            };
        }

        /* access modifiers changed from: protected */
        public List<Stations> getFilteredResults(String str) {
            ArrayList arrayList = new ArrayList();
            Iterator<Stations> it = this.mDataArray.iterator();
            while (it.hasNext()) {
                Stations next = it.next();
                if (next.getName().toLowerCase().contains(str)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView mTextView;

            ViewHolder(View view) {
                super(view);
                this.mTextView = (TextView) view.findViewById(R.id.tv_alphabet);
                view.setOnClickListener(this);
            }

            public void onClick(View view) {
                if (RecyclerViewAdapter.this.mClickListener != null) {
                    RecyclerViewAdapter.this.mClickListener.onItemClick(view, getAdapterPosition(), (Stations) RecyclerViewAdapter.this.mDataArray.get(getAdapterPosition()));
                }
            }
        }
    }
}
