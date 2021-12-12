package com.example.fastmilk.Fragment;

import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.fastmilk.R;
import com.example.fastmilk.activities.AddNewInformation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapsFragment extends Fragment implements PermissionsListener, OnMapReadyCallback {
    private MapView mapView;
    private MapboxMap mapboxMap;
    private List<LatLng> xy = new ArrayList<>();
    private LocationComponent locationComponent;
    private PermissionsManager permissionsManager;
    private FloatingActionButton centerLocation;
    private Button reportNewLocation;

    public static MapsFragment newInstance() {
        return new MapsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Mapbox.getInstance(getContext(), getString(R.string.mapbox_access_token));
        View view = inflater.inflate(R.layout.maps_fragment, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        Mapbox.getInstance(view.getContext(), getString(R.string.mapbox_access_token));

        centerLocation = (FloatingActionButton) view.findViewById(R.id.centerLocation1);

        reportNewLocation =  view.findViewById(R.id.reportNewLocation);
        // Initiation of the MapView
        mapView = (MapView) view.findViewById(R.id.mapView1);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {

                xy.add(new LatLng(10.8929561,106.620667));
                xy.add(new LatLng(10.8985278,106.624634));
                xy.add(new LatLng(10.8918288,106.6308057));
                xy.add(new LatLng(10.9001503,106.6267798));

                MarkerOptions option = new MarkerOptions();

                for (int i = 0; i < xy.size(); i++) {

                    option.position( new LatLng(xy.get(i).getLatitude(),xy.get(i).getLongitude()));
                    option.title("asd");
                    mapboxMap.addMarker(option);
                }


/*
                // nhap latitude va longitude vao duoi
                MarkerOptions option1 = new MarkerOptions();
                MarkerOptions option2 = new MarkerOptions();
                MarkerOptions option3 = new MarkerOptions();
                MarkerOptions option4 = new MarkerOptions();
                option1.position( new LatLng(10.8929561,106.620667));
                mapboxMap.addMarker(option1);
                option2.position( new LatLng(10.8985278,106.624634));
                mapboxMap.addMarker(option2);
                option3.position( new LatLng(10.8918288,106.6308057));
                mapboxMap.addMarker(option3);
                option4.position( new LatLng(10.9001503,106.6267798));
                mapboxMap.addMarker(option4);
*/

            }
        });

        centerLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(new LatLng(locationComponent.getLastKnownLocation().getLatitude() , locationComponent.getLastKnownLocation().getLongitude()))
                        .zoom(12)
                        .build();
                mapboxMap.setCameraPosition(cameraPosition);
                mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 500);
            }
        });

        reportNewLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(new LatLng(locationComponent.getLastKnownLocation().getLatitude() , locationComponent.getLastKnownLocation().getLongitude()))
                        .build();
                mapboxMap.setCameraPosition(cameraPosition);
                Intent i=new Intent(getContext(), AddNewInformation.class);
                i.putExtra("latitude",locationComponent.getLastKnownLocation().getLatitude());
                i.putExtra("longitude",locationComponent.getLastKnownLocation().getLongitude());
                Log.d("123", "onClick: "+locationComponent.getLastKnownLocation().getLongitude());
                startActivity(i);
            }
        });
    }

    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;
        mapboxMap.setStyle(new Style.Builder().fromUri("mapbox://styles/tuantutu2912a/ckwhsylkd1lrz14mmq09m9z23"),
                style -> {
                    enableComponent(style);
                });
    }
    public void enableComponent(@NonNull Style loadedMapStyle) {
        try {
            // check if permissions are enabled and if not request
            if (PermissionsManager.areLocationPermissionsGranted(getContext())) {
                // get an instance of the component
                locationComponent = mapboxMap.getLocationComponent();

                // Activate with options
                locationComponent.activateLocationComponent(
                        LocationComponentActivationOptions.builder(getContext(), loadedMapStyle).build());
                // Enable to make component visible
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                locationComponent.setLocationComponentEnabled(true);

                // Set the component's camera mode
                locationComponent.setCameraMode(CameraMode.TRACKING);

                // Set the component's render mode
                locationComponent.setRenderMode(RenderMode.COMPASS);

            } else {
                permissionsManager = new PermissionsManager(this);
                permissionsManager.requestLocationPermissions(getActivity());

            }
        } catch (Exception e) {
            Log.e("ERR_Load_MAP", e.getMessage());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }



    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            mapboxMap.getStyle(new Style.OnStyleLoaded() {
                @Override
                public void onStyleLoaded(@NonNull Style style) {
                    enableComponent(style);

                }
            });
        } else {
            Toast.makeText(getContext(), "Permission not granted", Toast.LENGTH_LONG).show();
        }
    }
/*
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
//        try {
//        } catch (Exception e) {
//            Log.e("ERR", e.getMessage());
//        }
    }*/
}