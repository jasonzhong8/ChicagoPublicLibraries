package com.jasonzhong.chicagopubliclibraries.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jasonzhong.chicagopubliclibraries.R;
import com.jasonzhong.chicagopubliclibraries.model.Library;

/**
 * Created by junzhong on 2017-08-20.
 */

public class LibraryDetailActivity extends Activity {

    private Library library;
    private TextView name_textview, address_textview, hours_textview, back_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_detail);

        Bundle b = getIntent().getExtras();
        library = b.getParcelable("Library");

        init();
        if (library != null) {
            setMapView(savedInstanceState);
        }
    }

    private void init() {
        back_textview = (TextView) findViewById(R.id.back_textview);
        back_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        name_textview = (TextView) findViewById(R.id.name_textview);
        address_textview = (TextView) findViewById(R.id.address_textview);
        hours_textview = (TextView) findViewById(R.id.hours_textview);

        if (library != null) {
            name_textview.setText(library.getName_());
            address_textview.setText(library.getAddress());
            hours_textview.setText(library.getHours_of_operation());
        }
    }

    private void setMapView(Bundle savedInstanceState) {
        final MapView mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {

            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng coordinates = new LatLng(Double.valueOf(library.getLatitude()), Double.valueOf(library.getLongitude()));
                googleMap.addMarker(new MarkerOptions().position(coordinates).title(library.getAddress()));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 15));
                mapView.onResume();
            }
        });
    }

}

