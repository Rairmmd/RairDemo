package com.rair.bluetooth.server;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.util.UUID;

public class AcceptThread extends Thread {

    private String uuid;
    private BluetoothServerSocket serverSocket;
    private BluetoothAdapter bluetoothAdapter;
    private boolean isRunning = true;

    public AcceptThread(String uuid, BluetoothAdapter bluetoothAdapter) {
        this.uuid = uuid;
        this.bluetoothAdapter = bluetoothAdapter;

        try {
            // 开启服务端蓝牙通道
            serverSocket = bluetoothAdapter.listenUsingRfcommWithServiceRecord("blue_service", UUID.randomUUID());
        } catch (IOException e) {

        }

    }

    @Override
    public void run() {

        BluetoothSocket socket = null;

        while (isRunning) {
            try {
                // 阻塞线程
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 处理客户端socket

            if (socket != null) {
                // 处理逻辑

                // socket是服务端和客户端的通道

                // 获取客户端
                //socket.getInputStream()

                // 输出到客户端
                //socket.getOutputStream().write();
            }
        }

        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancle() {
        isRunning = false;
    }
}
