package com.example.fastmilk.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.fastmilk.R;
import com.example.fastmilk.models.DiemGiao;
import com.example.fastmilk.retrofit.IRetrofitService;
import com.example.fastmilk.retrofit.RetrofitBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdate;
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
import com.mapbox.mapboxsdk.maps.Style.OnStyleLoaded;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mapbox.mapboxsdk.maps.Style.LIGHT;

public class MapboxActivity extends AppCompatActivity implements PermissionsListener, OnMapReadyCallback {

    private MapView mapView;
    private MapboxMap mapboxMap;
    private LocationComponent locationComponent;
    private PermissionsManager permissionsManager;
    private FloatingActionButton centerLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
        setContentView(R.layout.activity_mapbox);
        centerLocation = (FloatingActionButton) findViewById(R.id.centerLocation);
        String idDiemGiao = String.valueOf(getIntent().getExtras().getInt("idDiemGiao"));
        // Initiation of the MapView
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        DiemGiao dg=new DiemGiao(Integer.parseInt(idDiemGiao));
        Log.d("check map activity", "onCreate: "+dg.getIdDiemGiao());
        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        iRetrofitService.getDiemGiao(dg).enqueue(getDiemGiaoCB);
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
    }

    Callback<List<DiemGiao>> getDiemGiaoCB = new Callback<List<DiemGiao>>() {
        @Override
        public void onResponse(Call<List<DiemGiao>> call, Response<List<DiemGiao>> response) {
            if (response.isSuccessful()){
                LatLng xy=new LatLng();
                xy.setLatitude(response.body().get(0).getLatitude());
                xy.setLongitude(response.body().get(0).getLongitude());
                Log.d("check tọa độ", "onResponse: "+xy.getLatitude()+ " "+xy.getLongitude()+"");
                mapView.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(@NonNull MapboxMap mapboxMap) {
                        MarkerOptions option = new MarkerOptions();
                        option.position(xy);
                        option.title(response.body().get(0).getTenDiemGiao());
                        mapboxMap.addMarker(option);
                        CameraPosition cam=new CameraPosition.Builder().target(xy).zoom(12).build();
                        mapboxMap.setCameraPosition(cam);
                        mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(cam), 500);
                        /*mapboxMap.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(@NonNull Marker marker) {
                                Log.d("test on map click", "onMarkerClick: "+marker.getTitle());
                                return true;
                            }
                        });*/
                    }
                });
            } else {
                Log.i("Error: ", response.message());
            }
        }

        @Override
        public void onFailure(Call<List<DiemGiao>> call, Throwable t) {
            Log.i("Error: ", call.toString());
        }
    };

    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;
        mapboxMap.setStyle(new Style.Builder().fromUri("mapbox://styles/tuantutu2912a/ckwhsylkd1lrz14mmq09m9z23"),
                style -> enableComponent(style));
    }

    public void enableComponent(@NonNull Style loadedMapStyle) {
        try {
            // check if permissions are enabled and if not reqest
            if (PermissionsManager.areLocationPermissionsGranted(this)) {
                // get an instance of the component
                locationComponent = mapboxMap.getLocationComponent();

                // Activate with options
                locationComponent.activateLocationComponent(
                        LocationComponentActivationOptions.builder(this, loadedMapStyle).build());
                // Enable to make component visible
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
                permissionsManager.requestLocationPermissions(this);

            }
        } catch (Exception e) {
            Log.e("ERR_Load_MAP", e.getMessage());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
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
            mapboxMap.getStyle(new OnStyleLoaded() {
                @Override
                public void onStyleLoaded(@NonNull Style style) {
                    enableComponent(style);
                }
            });
        } else {
            Toast.makeText(this, "Permission not granted", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}