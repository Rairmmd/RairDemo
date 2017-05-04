package com.rair.bluetoothdemo;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.rair.bluetoothdemo.client.ConnThread;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.ConnectCallBack {
    private BluetoothAdapter bluetoothAdapter;
    private List<BluetoothDevice> devices = new ArrayList<>();
    private ListView listView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("蓝牙设备");
        listView = (ListView) findViewById(R.id.listView);
        myAdapter = new MyAdapter(getApplicationContext(), devices);
        myAdapter.setCallBack(this);
        listView.setAdapter(myAdapter);

        // 获取蓝牙适配器对象，支持蓝牙，则返回的对象实例不为空
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // 注册蓝牙设备被找到时广播接收器
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter);
        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(mReceiver, filter);
    }

    /**
     * 打开蓝牙设备
     *
     * @param view
     */
    public void enable_bluetooth(View view) {
        // 判断是否支持蓝牙设备
        if (bluetoothAdapter != null) {
            // 蓝牙设备是否有效
            if (!bluetoothAdapter.isEnabled()) {
                // 打开蓝牙
                bluetoothAdapter.enable();
            }

            // 获取已经配对过的蓝牙设备
            devices.addAll(bluetoothAdapter.getBondedDevices());
        }
    }

    /**
     * 搜索蓝牙设备
     *
     * @param view
     */
    public void search_bluetooth(View view) {
        // 判断是否支持蓝牙设备
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            setTitle("正在搜索蓝牙设备");

            if (bluetoothAdapter.isDiscovering()) {
                // 关闭蓝牙搜索
                bluetoothAdapter.cancelDiscovery();
            } else {
                // 发现当前范围的蓝牙设备，异步方法
                bluetoothAdapter.startDiscovery();
            }
        }
    }

    private BluetoothDevice device;

    /**
     * 广播接收器接收所有索索过程中的消息
     */
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            // 当某一个蓝牙设备被找到，则会收到此消息
            if (action.equals(BluetoothDevice.ACTION_FOUND)) {
                // 获取搜索到的蓝牙设备
                device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                // 搜索的设备在之前没有配对过，是一个新的设备
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    devices.add(device);
                }
                myAdapter.notifyDataSetChanged();
            } else if (action.equals(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)) {
                setTitle("蓝牙设备");
            }

        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }

    @Override
    public void callBack(int position) {
        //
        device = devices.get(position);
        // 连接
        ConnThread connThread = new ConnThread(device);
        connThread.start();

    }
}






















