package com.rair.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jerry.Zou
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<ScanResult> datas;
    private WifiManager wifiManager;
    private WiFiUtil wiFiUtil;

    public MyAdapter(Context context, List<ScanResult> datas, WifiManager wifiManager) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.datas = datas;
        this.wifiManager = wifiManager;
        wiFiUtil = WiFiUtil.getInstance(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public ScanResult getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
        }
        TextView mName = (TextView) convertView.findViewById(R.id.name);
        mName.setText(datas.get(position).SSID);

        TextView mAddress = (TextView) convertView.findViewById(R.id.address);
        mAddress.setText(datas.get(position).BSSID);

        Button connBtn = (Button) convertView.findViewById(R.id.connBtn);

        connBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScanResult item = getItem(position);

                if (item.capabilities.contains("WPA2") || item.capabilities.contains("WPA-PSK")) {
                    wiFiUtil.addWiFiNetwork(item.SSID, "Rair", WiFiUtil.Data.WIFI_CIPHER_WPA2);
                } else if (item.capabilities.contains("WPA")) {
                    wiFiUtil.addWiFiNetwork(item.SSID, "Rair", WiFiUtil.Data.WIFI_CIPHER_WPA);
                } else if (item.capabilities.contains("WEP")) {
                    /* WIFICIPHER_WEP 加密 */
                    wiFiUtil.addWiFiNetwork(item.SSID, "Rair", WiFiUtil.Data.WIFI_CIPHER_WEP);
                } else {
                    /* WIFICIPHER_OPEN NOPASSWORD 开放无加密 */
                    wiFiUtil.addWiFiNetwork(item.SSID, "", WiFiUtil.Data.WIFI_CIPHER_NOPASS);
                }

            }
        });

        return convertView;
    }
}
