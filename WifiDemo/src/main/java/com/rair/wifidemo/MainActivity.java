package com.rair.wifidemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private WifiManager mWiFiManager;
    private ListView listView;
    private WifiManager.WifiLock wifiLock;

    @SuppressLint("WifiManagerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取WiFi管理者对象
        mWiFiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        if (mWiFiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {
            Toast.makeText(this, "WiFi可用", Toast.LENGTH_SHORT).show();
        }

        listView = (ListView) findViewById(R.id.listView);
        myAdapter = new MyAdapter(this, list, mWiFiManager);
        listView.setAdapter(myAdapter);

        // 创建wifi锁
        wifiLock = mWiFiManager.createWifiLock("wifiLock");

        if (wifiLock != null) {
            // 使wifi锁有效
            wifiLock.acquire();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //判断wifi是否被lock锁持用
        if (wifiLock.isHeld()) {
            // 释放锁
            wifiLock.release();
        }
    }

    /**
     * 开启WiFi
     *
     * @param view
     */
    public void openWiFi(View view) {
        // 判断是否已经打开WiFi
        if (!mWiFiManager.isWifiEnabled()) {
            // 打开Wifi连接
            mWiFiManager.setWifiEnabled(true);
        }
    }

    /**
     * 开启WiFi
     *
     * @param view
     */
    public void closeWiFi(View view) {
        if (mWiFiManager.isWifiEnabled()) {
            // 关闭Wifi连接
            mWiFiManager.setWifiEnabled(false);
        }
    }

    /**
     * 获取当前连接的Wifi的信息
     *
     * @param view
     */
    public void getWiFiInfo(View view) {
        WifiInfo wifiInfo = mWiFiManager.getConnectionInfo();
        Log.i("wifi", "ssid: " + wifiInfo.getSSID());
        Log.i("wifi", "bssid: " + wifiInfo.getBSSID());
        Log.i("wifi", "mac address: " + wifiInfo.getMacAddress());
        Log.i("wifi", "speed: " + wifiInfo.getLinkSpeed());
        Log.i("wifi", "ip address: " + wifiInfo.getIpAddress());
        Log.i("wifi", "netwok id: " + wifiInfo.getNetworkId());
    }

    private List<ScanResult> list = new ArrayList<ScanResult>();
    private MyAdapter myAdapter;
    private List<WifiConfiguration> wifiConfigs;

    /**
     * 搜索WiFi
     *
     * @param view
     */
    public void searchWiFi(View view) {
        if (mWiFiManager.getWifiState() != WifiManager.WIFI_STATE_ENABLED) {
            return;
        }
        // 开始扫描
        mWiFiManager.startScan();

        // mWiFiManager.getScanResults()获取搜索的WiFi内容
        // 返回结果是当前设备所在区域能搜索出来的WiFi列表
        List<ScanResult> results = mWiFiManager.getScanResults();
        list.addAll(results);

        // 获取扫描已经保存的wifi列表配置集合
        wifiConfigs = mWiFiManager.getConfiguredNetworks();

//    for (WifiConfiguration configuration:wifiConfigs)
//    {
//      //configuration.SSID - wifi网络名称
//      //configuration.BSSID - wifi网络mac地址
//    }
        myAdapter.notifyDataSetChanged();
    }

    private int networkid = -1;

    /**
     * 连接到某一个Wifi网络
     */
    public void connCustomNetWork(View view) {
        // 添加一个WiFi网络,如果网络不再当前方位内，就没有办法连接
        //networkid = mWiFiManager.addNetwork(wifiConfigs.get(0));
        //mWiFiManager.enableNetwork(networkid,true);

        // 连接到一个有效网络 - 1900

        WifiConfiguration configuration =
                createWifiConfig("mac’s MacBook Pro", "", Data.WIFI_CIPHER_NOPASS);

//    WifiConfiguration configuration = createWifiConfig("360免费1",null,Data.WIFI_CIPHER_NOPASS);

        // 添加到Wifi网络
        networkid = mWiFiManager.addNetwork(configuration);

        // 使这个网络有效
        mWiFiManager.enableNetwork(networkid, true);
    }

    /**
     * 断开某一个WiFi网络
     *
     * @param view
     */
    public void disconnectNetWork(View view) {
        mWiFiManager.disableNetwork(networkid);
        mWiFiManager.disconnect();
    }

    /**
     * 创建WifiConfiguration
     * 三个安全性的排序为：WEP < WPA < WPA2。
     * WEP是Wired Equivalent Privacy的简称，有线等效保密（WEP）协议是对在两台设备间无线传输的数据进行加密的方式，
     * 用以防止非法用户窃听或侵入无线网络
     * WPA全名为Wi-Fi Protected Access，有WPA和WPA2两个标准，是一种保护无线电脑网络（Wi-Fi）安全的系统，
     * 它是应研究者在前一代的系统有线等效加密（WEP）中找到的几个严重的弱点而产生的
     * WPA是用来替代WEP的。WPA继承了WEP的基本原理而又弥补了WEP的缺点：WPA加强了生成加密密钥的算法，
     * 因此即便收集到分组信息并对其进行解析，也几乎无法计算出通用密钥；WPA中还增加了防止数据中途被篡改的功能和认证功能
     * WPA2是WPA的增强型版本，与WPA相比，WPA2新增了支持AES的加密方式
     *
     * @param SSID
     * @param password
     * @param type
     * @return
     **/
    private WifiConfiguration createWifiConfig(String SSID, String password, Data type) {
        WifiConfiguration config = new WifiConfiguration();

        config.allowedAuthAlgorithms.clear();
        config.allowedGroupCiphers.clear();
        config.allowedKeyManagement.clear();
        config.allowedPairwiseCiphers.clear();
        config.allowedProtocols.clear();

        config.SSID = "\"" + SSID + "\"";

        if (type == Data.WIFI_CIPHER_NOPASS) {
            config.wepKeys[0] = "";
            config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
            config.wepTxKeyIndex = 0;
        } else if (type == Data.WIFI_CIPHER_WEP) {
            config.hiddenSSID = true;
            config.wepKeys[0] = "\"" + password + "\"";
            config.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.SHARED);
            config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
            config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
            config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
            config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP104);
            config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
            config.wepTxKeyIndex = 0;
        } else if (type == Data.WIFI_CIPHER_WPA) {
            config.preSharedKey = "\"" + password + "\"";
            config.hiddenSSID = true;
            config.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);
            config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
            config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
            config.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
            config.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
            config.status = WifiConfiguration.Status.ENABLED;
        } else if (type == Data.WIFI_CIPHER_WPA2) {
            config.preSharedKey = "\"" + password + "\"";
            config.hiddenSSID = true;
            config.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);
            config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
            config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
            config.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
            config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
            config.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
            config.status = WifiConfiguration.Status.ENABLED;
        }

        return config;
    }

    /**
     * 密码加密类型
     */
    public enum Data {
        WIFI_CIPHER_NOPASS(0), WIFI_CIPHER_WEP(1), WIFI_CIPHER_WPA(2), WIFI_CIPHER_WPA2(3);

        private final int value;

        //构造器默认也只能是private, 从而保证构造函数只能在内部使用
        Data(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


}
