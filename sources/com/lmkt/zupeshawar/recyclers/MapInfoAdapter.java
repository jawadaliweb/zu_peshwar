package com.lmkt.zupeshawar.recyclers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.lmkt.zupeshawar.R;

public class MapInfoAdapter implements GoogleMap.InfoWindowAdapter {
    private final View myContentsView;

    public View getInfoContents(Marker marker) {
        return null;
    }

    public MapInfoAdapter(Context context) {
        this.myContentsView = LayoutInflater.from(context).inflate(R.layout.map_info_window, (ViewGroup) null);
    }

    public View getInfoWindow(Marker marker) {
        ((TextView) this.myContentsView.findViewById(R.id.stationName)).setText(marker.getTitle());
        ((TextView) this.myContentsView.findViewById(R.id.address_location)).setText(marker.getSnippet());
        return this.myContentsView;
    }
}
