package com.lmkt.zupeshawar.views.fragments.busFragments.tripplanner;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.messaging.Constants;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.Map.PinView;
import com.lmkt.zupeshawar.Utilities.Map.subscaleview.ImageSource;
import com.lmkt.zupeshawar.Utilities.Map.subscaleview.SubsamplingScaleImageView;
import com.lmkt.zupeshawar.model.EstimatedFare;
import com.lmkt.zupeshawar.model.routeModels.GetRoutesMainModel;
import com.lmkt.zupeshawar.model.routeModels.RoutesHeaderAppModel;
import com.lmkt.zupeshawar.recyclers.busroutes.SectionRoutesAdapter;
import com.lmkt.zupeshawar.views.activities.MainMenuItemActivity;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import java.util.ArrayList;

public class TripPlannerSheet extends Fragment implements SubsamplingScaleImageView.OnImageEventListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    EditText From_ET;
    EditText To_ET;
    MainMenuItemActivity activity;
    /* access modifiers changed from: private */
    public Context context;
    ArrayList<EstimatedFare> fares;
    private GestureDetector gestureDetector;
    /* access modifiers changed from: private */
    public PinView imageView;
    private ProgressBar mProgressBar;
    RecyclerView routesRecyclerView;

    public void onImageLoadError(Exception exc) {
    }

    public void onImageLoaded() {
    }

    public void onPreviewLoadError(Exception exc) {
    }

    public void onPreviewReleased() {
    }

    public void onTileLoadError(Exception exc) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_mainmenu_tripplanner_bottomsheet, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            MainMenuItemActivity mainMenuItemActivity = (MainMenuItemActivity) getActivity();
            this.activity = mainMenuItemActivity;
            this.context = mainMenuItemActivity.getBaseContext();
            initViews(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initViews(View view) throws Exception {
        initToolbar();
        Bundle arguments = getArguments();
        GetRoutesMainModel getRoutesMainModel = (GetRoutesMainModel) arguments.getSerializable(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        this.fares = (ArrayList) arguments.getSerializable("fare");
        this.From_ET = (EditText) view.findViewById(R.id.From_ET);
        this.To_ET = (EditText) view.findViewById(R.id.To_ET);
        this.From_ET.setText(arguments.getString("fromstation", ""));
        this.To_ET.setText(arguments.getString("tostation", ""));
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        this.mProgressBar = progressBar;
        progressBar.bringToFront();
        this.routesRecyclerView = (RecyclerView) view.findViewById(R.id.routesRecyclerView);
        PinView pinView = (PinView) view.findViewById(R.id.imageView);
        this.imageView = pinView;
        pinView.setMinimumScaleType(1);
        this.imageView.setZoomEnabled(true);
        this.imageView.setImage(ImageSource.resource(R.drawable.map));
        this.imageView.setOnImageEventListener(this);
        this.imageView.setVisibility(0);
        this.imageView.bringToFront();
        this.gestureDetector = new GestureDetector(this.context, new GestureDetector.SimpleOnGestureListener() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            static {
                Class<TripPlannerSheet> cls = TripPlannerSheet.class;
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (TripPlannerSheet.this.imageView.isReady()) {
                    TripPlannerSheet.this.imageView.viewToSourceCoord(motionEvent.getX(), motionEvent.getY());
                    if (!new Rect(TripPlannerSheet.this.imageView.getLeft(), TripPlannerSheet.this.imageView.getTop(), TripPlannerSheet.this.imageView.getRight(), TripPlannerSheet.this.imageView.getBottom()).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        Toast.makeText(TripPlannerSheet.this.context, "Please long click on image to add marker ", 0).show();
                    }
                } else {
                    Toast.makeText(TripPlannerSheet.this.context, "Image is not ready Please wait", 0).show();
                }
                return super.onSingleTapUp(motionEvent);
            }
        });
        this.imageView.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return TripPlannerSheet.this.lambda$initViews$0$TripPlannerSheet(view, motionEvent);
            }
        });
        RoutesHeaderAppModel routesHeaderAppModel = new RoutesHeaderAppModel(arguments.getString("fromstation", ""), arguments.getString("tostation", ""), arguments.getString("estTime", ""), "Rs. " + this.fares.get(0).getFare(), "" + getRoutesMainModel.getTotalBusChanges());
        ArrayList arrayList = new ArrayList();
        arrayList.add(getRoutesMainModel);
        SectionedRecyclerViewAdapter sectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();
        sectionedRecyclerViewAdapter.addSection(new SectionRoutesAdapter(routesHeaderAppModel, arrayList, this.context));
        this.routesRecyclerView.setAdapter(sectionedRecyclerViewAdapter);
    }

    public /* synthetic */ boolean lambda$initViews$0$TripPlannerSheet(View view, MotionEvent motionEvent) {
        return this.gestureDetector.onTouchEvent(motionEvent);
    }

    public void onReady() {
        this.mProgressBar.setVisibility(8);
        PointF viewToSourceCoord = this.imageView.viewToSourceCoord(this.imageView.getCenter());
        this.imageView.doubleTapZoom(viewToSourceCoord, viewToSourceCoord);
    }

    private void initToolbar() {
        MainMenuItemActivity mainMenuItemActivity = (MainMenuItemActivity) getActivity();
        this.activity = mainMenuItemActivity;
        mainMenuItemActivity.mToolbar_Title.setText(R.string.title_routedetail);
        this.activity.mToolbar_BackBtn.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TripPlannerSheet.this.lambda$initToolbar$1$TripPlannerSheet(view);
            }
        });
    }

    public /* synthetic */ void lambda$initToolbar$1$TripPlannerSheet(View view) {
        getActivity().getSupportFragmentManager().popBackStack("TripPlannerDetail", 1);
    }
}
