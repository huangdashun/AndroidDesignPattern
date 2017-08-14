package huangshun.it.com.androiddesignpattern.googlemap;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import huangshun.it.com.androiddesignpattern.R;

public class GoogleActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = "GoogleActivity";
    @BindView(R.id.rl_content)
    RelativeLayout mLlContent;
    @BindView(R.id.iv_location)
    ImageView mIvLocation;
    @BindView(R.id.map_view_pan)
    LinearLayout mMapViewPan;

    private MapView mMapView;
    private GoogleMap mGoogleMap;
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private float zoomLevel = 18f;
    protected Handler mHandler = new Handler(Looper.getMainLooper());

    private int mPathColor;
    private int mLocationColor;
    private int mLocationStrokeColor;

    private SensorEventHelper mSensorHelper;


    private LocationRequest mLocationRequest;
    private GoogleApiClient mGoogleApiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);
        ButterKnife.bind(this);

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }


        mPathColor = getResources().getColor(R.color.green_1);
        mLocationColor = getResources().getColor(R.color.green_2_15);
        mLocationStrokeColor = getResources().getColor(R.color.green_2);
        mSensorHelper = new SensorEventHelper(this);

        mMapView = new MapView(this);
        mMapViewPan.addView(mMapView);
        mMapView.onCreate(mapViewBundle);

        mMapView.getMapAsync(this);
    }

    protected synchronized void buildGoogleApiClient() {
        Toast.makeText(this, "buildGoogleApiClient", Toast.LENGTH_SHORT).show();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }


    private void initSetting() {
        mGoogleMap.setMyLocationEnabled(false);//显示自己位置

        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mGoogleMap.getUiSettings().setAllGesturesEnabled(false);
        mGoogleMap.getUiSettings().setMyLocationButtonEnabled(false);//隐藏提供的定位图标
        mGoogleMap.getUiSettings().setScrollGesturesEnabled(true);//左右滑动
        mGoogleMap.getUiSettings().setZoomGesturesEnabled(true);//缩放
        mGoogleMap.getUiSettings().setCompassEnabled(false);//隐藏指南针方向
        mGoogleMap.getUiSettings().setMapToolbarEnabled(false);
        mGoogleMap.setMinZoomPreference(5);
    }

    /**
     * 开始定位
     */
    private void startLocation() {
        if (mGoogleMap != null) {
            Location myLocation = mGoogleMap.getMyLocation();
            if (myLocation != null) {
                LatLng myLatLng = new LatLng(myLocation.getLatitude(),
                        myLocation.getLongitude());
                CameraPosition myPosition = new CameraPosition.Builder()
                        .target(myLatLng).zoom(zoomLevel).bearing(0).tilt(0).build();
                mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(myPosition));
            } else {
                Log.i(TAG, "myLocation为null");
            }
        } else {
            Log.i(TAG, "mGoogleMap为null");
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

//        initListener();
        //当地图加载完毕回调
//        mGoogleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
//            @Override
//            public void onMapLoaded() {
//                startLocation();//开始定位一次
//                // 最后一次定位
//                mHandler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.i(TAG, "run: isMapLoaded ");
//                        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//                        Location lastKnownLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//
//                        if (lastKnownLocation == null) {
//                            Log.i(TAG, "lastKnownLocation为null");
//                            return;
//                        }
//                        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()), zoomLevel));
//                    }
//                }, 500);
//            }
//        });
//        mGoogleMap.setMyLocationEnabled(true);
        mGoogleMap = googleMap;

        initSetting();//初始化设置
        buildGoogleApiClient();
        mGoogleApiClient.connect();
    }

    private void initListener() {
        mGoogleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                Log.d(TAG, "onMyLocationChange() called with " + "location = [" + location + "]");
//                Toast.makeText(getApplicationContext(), location.toString(), Toast.LENGTH_SHORT).show();

                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

                mGoogleMap.clear();
                mLocMarker = mGoogleMap.addMarker(getCurrentMarkerOption().position(latLng));
                mSensorHelper.setCurrentMarker(mLocMarker);
                mGoogleMap.addCircle(getCircleOption().center(latLng).radius(getCircleRadius(location.getAccuracy())));//绘制以自己为中心点的circle

                mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

//                if (mGoogleMap.getCameraPosition().zoom < zoomLevel) {
//                    mGoogleMap.moveCamera(CameraUpdateFactory.zoomTo(zoomLevel));
//                }
            }
        });

    }

    private float getCircleRadius(float accuracy) {
        if (accuracy < 30)
            accuracy = 30;
        return accuracy;
    }

    private MarkerOptions startMarkerOp;
    private MarkerOptions currentMarkerOp;
    private CircleOptions currentCircleOp;
    private Marker mLocMarker;

    private CircleOptions getCircleOption() {
        if (currentCircleOp == null) {
            currentCircleOp = new CircleOptions();
            currentCircleOp.strokeWidth(1f);
            currentCircleOp.fillColor(mLocationColor);
            currentCircleOp.strokeColor(mLocationStrokeColor);
            currentCircleOp.zIndex(1000);
        }
        return currentCircleOp;
    }

    private MarkerOptions getStartMarkerOption() {
        if (startMarkerOp == null) {
            startMarkerOp = new MarkerOptions();

            startMarkerOp.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sport_start_run)));
            startMarkerOp.anchor(0.5f, 0.5f);
            startMarkerOp.zIndex(2);
        }
        return startMarkerOp;
    }

    private MarkerOptions getCurrentMarkerOption() {
        if (currentMarkerOp == null) {
            currentMarkerOp = new MarkerOptions();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 3;
            currentMarkerOp.icon(BitmapDescriptorFactory.fromResource(R.drawable.sport_current));
            currentMarkerOp.anchor(0.5f, 0.5f);
            currentMarkerOp.zIndex(2);
        }
        return currentMarkerOp;
    }


    @OnClick({R.id.iv_location})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_location:
                startLocation();
                break;

            default:
                break;
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }

        mMapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();

        mSensorHelper.registerSensorListener();
        mSensorHelper.setCurrentMarker(mLocMarker);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMapView.onStop();
    }


    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
        if (mSensorHelper != null) {
            mSensorHelper.unRegisterSensorListener();
            mSensorHelper.setCurrentMarker(null);
        }
        //Unregister for location callbacks:
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, new LocationCallback() {
                @Override
                public void onLocationResult(LocationResult locationResult) {
                    super.onLocationResult(locationResult);
                }
            });
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        if (mSensorHelper != null) {
            mSensorHelper.unRegisterSensorListener();
            mSensorHelper.setCurrentMarker(null);
            mSensorHelper = null;
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    private Marker mCurrLocation;
    LatLng latLng;

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Toast.makeText(this, "onConnected", Toast.LENGTH_SHORT).show();
        Location mLastLocation = null;
        try {
            Log.i("位置", LocationServices.FusedLocationApi.getLocationAvailability(mGoogleApiClient) + "");
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        } catch (SecurityException e) {
            e.printStackTrace();
        }


        if (mLastLocation != null) {
            //place marker at current position
            mGoogleMap.clear();
            latLng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f);
            markerOptions.position(latLng);
            markerOptions.title("Current Position");
            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()), zoomLevel));
            // 添加marker，但是这里我们特意把marker弄成透明的
            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.sport_current));

            mCurrLocation = mGoogleMap.addMarker(markerOptions);

            Log.i("位置", mLastLocation + "1111111");
            Log.i("位置", "最新的位置 getProvider " + mLastLocation.getProvider());
            Log.i("位置", "最新的位置 getAccuracy " + mLastLocation.getAccuracy());
            Log.i("位置", "最新的位置 getAltitude " + mLastLocation.getAltitude());
            Log.i("位置", "最新的位置 Bearing() " + mLastLocation.getBearing());
            Log.i("位置", "最新的位置 Extras() " + mLastLocation.getExtras());
            Log.i("位置", "最新的位置 Latitude() " + mLastLocation.getLatitude());
            Log.i("位置", "最新的位置 Longitude()() " + mLastLocation.getLongitude());
            Log.i("位置", " =============  ");
//            TextView mTvAddress = (TextView) findViewById(R.id.mTvAddress);
            String address = getAddress(this, mLastLocation.getLatitude(), mLastLocation.getLongitude());
//            mTvAddress.setText(address);
        }
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(5000); //5 seconds
        mLocationRequest.setFastestInterval(3000); //3 seconds
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        //mLocationRequest.setSmallestDisplacement(0.1F); //1/10 meter

        //LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
            }
        });
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, new com.google.android.gms.location.LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

            }
        });

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    /**
     * 逆地理编码 得到地址
     *
     * @param context
     * @param latitude
     * @param longitude
     * @return
     */
    public static String getAddress(Context context, double latitude, double longitude) {
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> address = geocoder.getFromLocation(latitude, longitude, 1);
            Log.i("位置", "得到位置当前" + address + "'\n"
                    + "经度：" + String.valueOf(address.get(0).getLongitude()) + "\n"
                    + "纬度：" + String.valueOf(address.get(0).getLatitude()) + "\n"
                    + "纬度：" + "国家：" + address.get(0).getCountryName() + "\n"
                    + "城市：" + address.get(0).getLocality() + "\n"
                    + "名称：" + address.get(0).getAddressLine(1) + "\n"
                    + "街道：" + address.get(0).getAddressLine(0)
            );
            return address.get(0).getAddressLine(0) + "  " + address.get(0).getLocality() + " " + address.get(0).getCountryName();
        } catch (Exception e) {
            e.printStackTrace();
            return "未知";
        }
    }

}
