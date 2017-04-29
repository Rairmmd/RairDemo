package com.rair.connectivitymanagerdemo;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取连接管理器对象
        ConnectivityManager manager =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);


        // 1，获取可用的网络信息
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        // 有网络存在
        if (networkInfo != null) {
            // 获取该网络详细状态
            NetworkInfo.DetailedState state = networkInfo.getDetailedState();
            Log.i("network", "state=" + state);
            Log.i("network", "当前网络可用");
        } else {
            Toast.makeText(MainActivity.this, "当前网络不可用", Toast.LENGTH_SHORT).show();
        }

        if (networkInfo != null &&
                networkInfo.isAvailable() && networkInfo.isConnected()) {
            Log.i("network", "当前网络有效");
        }

        // isAvailable()：判断该网络是否可用,是否可以寻找到网络
//    if (networkInfo != null
//        && networkInfo.isAvailable()
//        && (NetworkInfo.State.CONNECTED == networkInfo.getState()
//              || NetworkInfo.State.CONNECTING == networkInfo.getState()))
        if (networkInfo != null && networkInfo.isAvailable()
                && networkInfo.isConnectedOrConnecting()) {
            Log.i("network", "当前网络有效");
            // type = 1 (WiFi) extraInfo = null
            Log.i("network", "type=" + networkInfo.getType());
            Log.i("network", "typeName=" + networkInfo.getTypeName()); // mobile wifi bluebooth
            Log.i("network", "extraInfo=" + networkInfo.getExtraInfo());
            // networkInfo.getSubtype()值来自TelephonyManager
            // TelephonyManager.NETWORK_TYPE_LTE
            Log.i("network", "subType=" + networkInfo.getSubtype());
            //TelephonyManager.NETWORK_TYPE_LTE
            Log.i("network", "subTypeName=" + networkInfo.getSubtypeName());

        } else {
            // 无网络处理，让用户选择网络
            Intent intent;

            // 3.0以后
            if (Build.VERSION.SDK_INT > 10) {
                intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
            }
            // 3.0以前
            else {
                intent = new Intent();
                ComponentName component = new ComponentName("com.android.settings", "com.android.settings.WirelessSettings");
                intent.setComponent(component);
                //intent.setAction("android.intent.action.VIEW");
                intent.setAction(Intent.ACTION_VIEW);
            }
            startActivity(intent);
        }

        //networkInfo.isConnectedOrConnecting()

        // 2, 获取WiFi网络信息
        networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            Log.i("network", "当前WiFi网络有效");
        }

        //获取手机网络信息
        networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            Log.i("network", "当前手机网络有效");
        }

        getTelehonyMessage();
        // 注册网络连接改变广播接收器
        IntentFilter intentFilter = new IntentFilter();
        // ConnectivityManager.CONNECTIVITY_ACTION - 广播频道名称
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mReceiver, intentFilter);
    }

    /**
     * 主要用于实时获取网络状态的场景
     */
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean isNotConnected = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if (isNotConnected) {
                Log.i("mReceiver", "当前网络异常");
                return;
            }
            NetworkInfo networkInfo = (NetworkInfo) intent.getExtras().get(ConnectivityManager.EXTRA_NETWORK_INFO);
            if (networkInfo != null) {
                Log.i("mReceiver", "当前网络有效");
                // type = 1 (WiFi) extraInfo = null
                Log.i("mReceiver", "type=" + networkInfo.getType());
                Log.i("mReceiver", "typeName=" + networkInfo.getTypeName());
                Log.i("mReceiver", "extraInfo=" + networkInfo.getExtraInfo());
                // networkInfo.getSubtype()值来自TelephonyManager
                // TelephonyManager.NETWORK_TYPE_LTE
                Log.i("mReceiver", "subType=" + networkInfo.getSubtype());
                //TelephonyManager.NETWORK_TYPE_LTE
                Log.i("mReceiver", "subTypeName=" + networkInfo.getSubtypeName());
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
//    unregisterReceiver(mReceiver);
//    mReceiver = null;
    }

    /**
     * 获取手机的信息
     */
    public void getTelehonyMessage() {
        // 获取手机管理器对象
        TelephonyManager manager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        Log.i("telephony", "data activity=" + manager.getDataActivity());
        Log.i("telephony", "version=" + manager.getDeviceSoftwareVersion());
        Log.i("telephony", "line number=" + manager.getLine1Number());
        Log.i("telephony", "iso=" + manager.getNetworkCountryIso());
        Log.i("telephony", "deviceId=" + manager.getDeviceId());
        Log.i("telephony", "operator=" + manager.getNetworkOperator());
        Log.i("telephony", "operatorName=" + manager.getNetworkOperatorName());

//    public static final int NETWORK_TYPE_UNKNOWN = 0;
//    public static final int NETWORK_TYPE_GPRS = 1;
//    public static final int NETWORK_TYPE_EDGE = 2;
//    public static final int NETWORK_TYPE_UMTS = 3;
//    public static final int NETWORK_TYPE_CDMA = 4;
//    public static final int NETWORK_TYPE_EVDO_0 = 5;
//    public static final int NETWORK_TYPE_EVDO_A = 6;
//    public static final int NETWORK_TYPE_1xRTT = 7;
//    public static final int NETWORK_TYPE_HSDPA = 8;
//    public static final int NETWORK_TYPE_HSUPA = 9;
//    public static final int NETWORK_TYPE_HSPA = 10;
//    public static final int NETWORK_TYPE_IDEN = 11;
//    public static final int NETWORK_TYPE_EVDO_B = 12;
//    public static final int NETWORK_TYPE_LTE = 13;
//    public static final int NETWORK_TYPE_EHRPD = 14;
//    public static final int NETWORK_TYPE_HSPAP = 15;
//    public static final int NETWORK_TYPE_GSM = 16;
//    public static final int NETWORK_TYPE_TD_SCDMA = 17;
//    public static final int NETWORK_TYPE_IWLAN = 18;

//    SIM卡连接的网络类型
        Log.i("telephony", "networkType=" + manager.getNetworkType());
//    public static final int PHONE_TYPE_GSM = PhoneConstants.PHONE_TYPE_GSM;
//    public static final int PHONE_TYPE_CDMA = PhoneConstants.PHONE_TYPE_CDMA;
//    public static final int PHONE_TYPE_SIP = PhoneConstants.PHONE_TYPE_SIP;
        // 手机制式类型
        Log.i("telephony", "phoneType=" + manager.getPhoneType());
        // SIM卡的序列号
        Log.i("telephony", "SimSerialNumber=" + manager.getSimSerialNumber());
    }
}

