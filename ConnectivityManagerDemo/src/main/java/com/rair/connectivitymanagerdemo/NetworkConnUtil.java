package com.rair.connectivitymanagerdemo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.DecimalFormat;
import java.util.Enumeration;


/**
 * 网络连接帮助类
 */
public class NetworkConnUtil {

    private static final String TAG = "NetworkConnUtil";

    /**
     * 网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetWorkEnable(Context context) {
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity == null) {
                Toast.makeText(context, "无法连接网络", Toast.LENGTH_SHORT).show();
                return false;
            }

            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 判断当前网络是否已经连接
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(context, "无法连接网络", Toast.LENGTH_SHORT).show();
        return false;
    }

    /**
     * 网络是否能够连接，能够寻找到网络
     *
     * @param context
     * @return
     */
    public static boolean isNetWorkAvilable(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            Log.e(TAG, "couldn't get connectivity manager");
        } else {
            NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();
            if (networkInfos != null) {
                for (int i = 0, count = networkInfos.length; i < count; i++) {
                    if (networkInfos[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 获取本地IP地址
     *
     * @return
     */
    public static String getLocalIpAddress() {
        try {
            for (Enumeration en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = (NetworkInterface) en.nextElement();

                for (Enumeration enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = (InetAddress) enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }

            }
        } catch (SocketException ex) {
            Log.e("getLocalIpAddress", ex.toString());
        }
        return null;
    }

    /**
     * 获取Mac地址
     *
     * @param context
     * @return
     */
    public static String getLocalMacAddress(Context context) {
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        return info.getMacAddress();
    }

    /**
     * WiFi是否有效
     *
     * @param context
     * @return
     */
    public static boolean isWiFiActive(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            //NetworkInfo infos = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getTypeName().equalsIgnoreCase("WIFI") && info[i].isConnected()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 是否超过一个连接
     *
     * @param context
     * @return
     */
    public static boolean hasMoreThanOneConnection(Context context) {
        ConnectivityManager manager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager == null) {
            return false;
        } else {
            NetworkInfo[] info = manager.getAllNetworkInfo();
            int counter = 0;
            for (int i = 0; i < info.length; i++) {
                if (info[i].isConnected()) {
                    counter++;
                }
            }
            if (counter > 1) {
                return true;
            }
        }

        return false;
    }

    /**
     * 连接方式是否是快连接
     *
     * @param context
     * @return
     */
    public static boolean isConnectedFast(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo info = cm.getActiveNetworkInfo();

        return (info != null && info.isConnected()
                && isConnectionFast(info.getType(), info.getSubtype()));
    }

    /**
     * 判断手机当前网络类型是否是快速网络类型
     *
     * @param type
     * @param subType
     * @return
     */
    public static boolean isConnectionFast(int type, int subType) {
        if (type == ConnectivityManager.TYPE_WIFI) {
            System.out.println("CONNECTED VIA WIFI");
            return true;
        } else if (type == ConnectivityManager.TYPE_MOBILE) {
            switch (subType) {
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                    return false; // ~ 50-100 kbps
                case TelephonyManager.NETWORK_TYPE_CDMA:
                    return false; // ~ 14-64 kbps
                case TelephonyManager.NETWORK_TYPE_EDGE:
                    return false; // ~ 50-100 kbps
                case TelephonyManager.NETWORK_TYPE_GPRS:
                    return false; // ~ 100 kbps
                case TelephonyManager.NETWORK_TYPE_IDEN:
                    return false; // ~25 kbps

                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    return true; // ~ 400-1000 kbps
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    return true; // ~ 600-1400 kbps
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                    return true; // ~ 2-14 Mbps
                case TelephonyManager.NETWORK_TYPE_HSPA:
                    return true; // ~ 700-1700 kbps
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                    return true; // ~ 1-23 Mbps
                case TelephonyManager.NETWORK_TYPE_UMTS:
                    return true; // ~ 400-7000 kbps
                // NOT AVAILABLE YET IN API LEVEL 7
                case TelephonyManager.NETWORK_TYPE_EHRPD:
                    return true; // ~ 1-2 Mbps
                case TelephonyManager.NETWORK_TYPE_EVDO_B:
                    return true; // ~ 5 Mbps
                case TelephonyManager.NETWORK_TYPE_HSPAP:
                    return true; // ~ 10-20 Mbps
                case TelephonyManager.NETWORK_TYPE_LTE:
                    return true; // ~ 10+ Mbps

                // Unknown
                case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                    return false;
                default:
                    return false;
            }
        } else {
            return false;
        }
    }


    public static long ip2int(String ip) {
        String[] items = ip.split("\\.");
        return Long.valueOf(items[0]) << 24
                | Long.valueOf(items[1]) << 16
                | Long.valueOf(items[2]) << 8 | Long.valueOf(items[3]);
    }

    public static String int2ip(long ipInt) {
        StringBuilder sb = new StringBuilder();
        sb.append(ipInt & 0xFF).append(".");
        sb.append((ipInt >> 8) & 0xFF).append(".");
        sb.append((ipInt >> 16) & 0xFF).append(".");
        sb.append((ipInt >> 24) & 0xFF);
        return sb.toString();
    }

    /**
     * 获取MAC地址
     *
     * @param context
     * @return
     */
    public static String getMacAddress(Context context) {
        if (context == null) {
            return "";
        }

        String localMac = null;
        if (isWiFiActive(context)) {
            localMac = getWifiMacAddress(context);
        }

        if (localMac != null && localMac.length() > 0) {
            localMac = localMac.replace(":", "-").toLowerCase();
            return localMac;
        }

        localMac = getMacFromCallCmd();
        if (localMac != null) {
            localMac = localMac.replace(":", "-").toLowerCase();
        }

        return localMac;
    }

    /**
     * 获取WiFi的地址
     *
     * @param context
     * @return
     */
    private static String getWifiMacAddress(Context context) {
        String localMac;
        try {
            WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = wifi.getConnectionInfo();
            if (wifi.isWifiEnabled()) {
                localMac = info.getMacAddress();
                if (localMac != null) {
                    localMac = localMac.replace(":", "-").toLowerCase();
                    return localMac;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 通过callCmd("busybox ifconfig","HWaddr")获取mac地址
     *
     * @return Mac Address
     */
    private static String getMacFromCallCmd() {
        String result = "";
        result = callCmd("busybox ifconfig", "HWaddr");

        if (result == null || result.length() <= 0) {
            return null;
        }

        Log.d("tag", "cmd result : " + result);

        // 对该行数据进行解析
        // 例如：eth0 Link encap:Ethernet HWaddr 00:16:E8:3E:DF:67
        if (result.length() > 0 && result.contains("HWaddr") == true) {
            String Mac = result.substring(result.indexOf("HWaddr") + 6,
                    result.length() - 1);
            if (Mac.length() > 1) {
                result = Mac.replaceAll(" ", "");
            }
        }

        return result;
    }

    public static String callCmd(String cmd, String filter) {
        String result = "";
        String line = "";
        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            InputStreamReader is = new InputStreamReader(proc.getInputStream());
            BufferedReader br = new BufferedReader(is);

            // 执行命令cmd，只取结果中含有filter的这一行
            while ((line = br.readLine()) != null
                    && line.contains(filter) == false) {
            }

            result = line;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    private static final int NETWORK_TYPE_UNAVAILABLE = -1;
    // private static final int NETWORK_TYPE_MOBILE = -100;
    private static final int NETWORK_TYPE_WIFI = -101;

    private static final int NETWORK_CLASS_WIFI = -101;
    private static final int NETWORK_CLASS_UNAVAILABLE = -1;
    /**
     * Unknown network class.
     */
    private static final int NETWORK_CLASS_UNKNOWN = 0;
    /**
     * Class of broadly defined "2G" networks.
     */
    private static final int NETWORK_CLASS_2_G = 1;
    /**
     * Class of broadly defined "3G" networks.
     */
    private static final int NETWORK_CLASS_3_G = 2;
    /**
     * Class of broadly defined "4G" networks.
     */
    private static final int NETWORK_CLASS_4_G = 3;

    private static DecimalFormat df = new DecimalFormat("#.##");

    /**
     * 格式化大小
     *
     * @param size
     * @return
     */
    public static String formatSize(long size) {
        String unit = "B";
        float len = size;
        if (len > 900) {
            len /= 1024f;
            unit = "KB";
        }
        if (len > 900) {
            len /= 1024f;
            unit = "MB";
        }
        if (len > 900) {
            len /= 1024f;
            unit = "GB";
        }
        if (len > 900) {
            len /= 1024f;
            unit = "TB";
        }
        return df.format(len) + unit;
    }

    public static String formatSizeBySecond(long size) {
        String unit = "B";
        float len = size;
        if (len > 900) {
            len /= 1024f;
            unit = "KB";
        }
        if (len > 900) {
            len /= 1024f;
            unit = "MB";
        }
        if (len > 900) {
            len /= 1024f;
            unit = "GB";
        }
        if (len > 900) {
            len /= 1024f;
            unit = "TB";
        }
        return df.format(len) + unit + "/s";
    }

    public static String format(long size) {
        String unit = "B";
        float len = size;
        if (len > 1000) {
            len /= 1024f;
            unit = "KB";
            if (len > 1000) {
                len /= 1024f;
                unit = "MB";
                if (len > 1000) {
                    len /= 1024f;
                    unit = "GB";
                }
            }
        }
        return df.format(len) + "\n" + unit + "/s";
    }

    /**
     * 获取运营商
     *
     * @return
     */
    public static String getProvider(Context context) {
        String provider = "未知";
        try {
            TelephonyManager telephonyManager =
                    (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            String IMSI = telephonyManager.getSubscriberId();
            Log.v("tag", "getProvider.IMSI:" + IMSI);
            if (IMSI == null) {
                if (TelephonyManager.SIM_STATE_READY == telephonyManager.getSimState()) {
                    String operator = telephonyManager.getSimOperator();
                    Log.v("tag", "getProvider.operator:" + operator);
                    if (operator != null) {
                        if (operator.equals("46000")
                                || operator.equals("46002")
                                || operator.equals("46007")) {
                            provider = "中国移动";
                        } else if (operator.equals("46001")) {
                            provider = "中国联通";
                        } else if (operator.equals("46003")) {
                            provider = "中国电信";
                        }
                    }
                }
            } else {
                if (IMSI.startsWith("46000") || IMSI.startsWith("46002")
                        || IMSI.startsWith("46007")) {
                    provider = "中国移动";
                } else if (IMSI.startsWith("46001")) {
                    provider = "中国联通";
                } else if (IMSI.startsWith("46003")) {
                    provider = "中国电信";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return provider;
    }

    // 此处从Android源码中（TelephonyManager）截取过来
    /**
     * Network type is unknown
     */
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    /**
     * Current network is GPRS
     */
    public static final int NETWORK_TYPE_GPRS = 1;
    /**
     * Current network is EDGE
     */
    public static final int NETWORK_TYPE_EDGE = 2;
    /**
     * Current network is UMTS
     */
    public static final int NETWORK_TYPE_UMTS = 3;
    /**
     * Current network is CDMA: Either IS95A or IS95B
     */
    public static final int NETWORK_TYPE_CDMA = 4;
    /**
     * Current network is EVDO revision 0
     */
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    /**
     * Current network is EVDO revision A
     */
    public static final int NETWORK_TYPE_EVDO_A = 6;
    /**
     * Current network is 1xRTT
     */
    public static final int NETWORK_TYPE_1xRTT = 7;
    /**
     * Current network is HSDPA
     */
    public static final int NETWORK_TYPE_HSDPA = 8;
    /**
     * Current network is HSUPA
     */
    public static final int NETWORK_TYPE_HSUPA = 9;
    /**
     * Current network is HSPA
     */
    public static final int NETWORK_TYPE_HSPA = 10;
    /**
     * Current network is iDen
     */
    public static final int NETWORK_TYPE_IDEN = 11;
    /**
     * Current network is EVDO revision B
     */
    public static final int NETWORK_TYPE_EVDO_B = 12;
    /**
     * Current network is LTE
     */
    public static final int NETWORK_TYPE_LTE = 13;
    /**
     * Current network is eHRPD
     */
    public static final int NETWORK_TYPE_EHRPD = 14;
    /**
     * Current network is HSPA+
     */
    public static final int NETWORK_TYPE_HSPAP = 15;

    /**
     * 获取网络类型
     *
     * @return
     */
    public static String getCurrentNetworkType(Context context) {
        int networkClass = getNetworkClass(context);
        String type = "未知";
        switch (networkClass) {
            case NETWORK_CLASS_UNAVAILABLE:
                type = "无";
                break;
            case NETWORK_CLASS_WIFI:
                type = "Wi-Fi";
                break;
            case NETWORK_CLASS_2_G:
                type = "2G";
                break;
            case NETWORK_CLASS_3_G:
                type = "3G";
                break;
            case NETWORK_CLASS_4_G:
                type = "4G";
                break;
            case NETWORK_CLASS_UNKNOWN:
                type = "未知";
                break;
        }
        return type;
    }

    private static int getNetworkClass(Context context) {
        int networkType = NETWORK_TYPE_UNKNOWN;
        try {
            final NetworkInfo network =
                    ((ConnectivityManager) context
                            .getSystemService(Context.CONNECTIVITY_SERVICE))
                            .getActiveNetworkInfo();
            if (network != null && network.isAvailable()
                    && network.isConnected()) {
                int type = network.getType();
                if (type == ConnectivityManager.TYPE_WIFI) {
                    networkType = NETWORK_TYPE_WIFI;
                } else if (type == ConnectivityManager.TYPE_MOBILE) {
                    TelephonyManager telephonyManager =
                            (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                    networkType = telephonyManager.getNetworkType();
                }
            } else {
                networkType = NETWORK_TYPE_UNAVAILABLE;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return getNetworkClassByType(networkType);

    }

    private static int getNetworkClassByType(int networkType) {
        switch (networkType) {
            case NETWORK_TYPE_UNAVAILABLE:
                return NETWORK_CLASS_UNAVAILABLE;
            case NETWORK_TYPE_WIFI:
                return NETWORK_CLASS_WIFI;
            case NETWORK_TYPE_GPRS:
            case NETWORK_TYPE_EDGE:
            case NETWORK_TYPE_CDMA:
            case NETWORK_TYPE_1xRTT:
            case NETWORK_TYPE_IDEN:
                return NETWORK_CLASS_2_G;
            case NETWORK_TYPE_UMTS:
            case NETWORK_TYPE_EVDO_0:
            case NETWORK_TYPE_EVDO_A:
            case NETWORK_TYPE_HSDPA:
            case NETWORK_TYPE_HSUPA:
            case NETWORK_TYPE_HSPA:
            case NETWORK_TYPE_EVDO_B:
            case NETWORK_TYPE_EHRPD:
            case NETWORK_TYPE_HSPAP:
                return NETWORK_CLASS_3_G;
            case NETWORK_TYPE_LTE:
                return NETWORK_CLASS_4_G;
            default:
                return NETWORK_CLASS_UNKNOWN;
        }
    }

    /**
     * 获取Wifi的Rssi
     *
     * @param context
     * @return
     */
    public static String getWifiRssi(Context context) {
        int asu = 85;
        try {
            final NetworkInfo network = ((ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE))
                    .getActiveNetworkInfo();
            if (network != null && network.isAvailable()
                    && network.isConnected()) {
                int type = network.getType();
                if (type == ConnectivityManager.TYPE_WIFI) {
                    WifiManager wifiManager = (WifiManager) context
                            .getSystemService(Context.WIFI_SERVICE);

                    WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                    if (wifiInfo != null) {
                        asu = wifiInfo.getRssi();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return asu + "dBm";
    }

    /**
     * 获取Wifi的Ssid
     *
     * @param context
     * @return
     */
    public static String getWifiSsid(Context context) {
        String ssid = "";
        try {
            final NetworkInfo network = ((ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE))
                    .getActiveNetworkInfo();
            if (network != null && network.isAvailable()
                    && network.isConnected()) {
                int type = network.getType();
                if (type == ConnectivityManager.TYPE_WIFI) {
                    WifiManager wifiManager = (WifiManager) context
                            .getSystemService(Context.WIFI_SERVICE);

                    WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                    if (wifiInfo != null) {
                        ssid = wifiInfo.getSSID();
                        if (ssid == null) {
                            ssid = "";
                        }
                        ssid = ssid.replaceAll("\"", "");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ssid;
    }

    /**
     * 检查sim卡状态
     *
     * @return
     */
    public static boolean checkSimState(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (tm.getSimState() == TelephonyManager.SIM_STATE_ABSENT
                || tm.getSimState() == TelephonyManager.SIM_STATE_UNKNOWN) {
            return false;
        }

        return true;
    }

    /**
     * 获取imei
     */
    public static String getImei(Context context) {
        TelephonyManager mTelephonyMgr =
                (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = mTelephonyMgr.getDeviceId();
        if (imei == null) {
            imei = "000000000000000";
        }
        return imei;
    }

    public static String getPhoneImsi(Context context) {
        TelephonyManager mTelephonyMgr =
                (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return mTelephonyMgr.getNetworkOperator();
    }


}