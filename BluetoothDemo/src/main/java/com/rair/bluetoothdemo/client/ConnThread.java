package com.rair.bluetoothdemo.client;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.util.UUID;

public class ConnThread extends Thread
{
  private BluetoothDevice device;
  private  UUID uuid;
  private BluetoothSocket socket;

  public ConnThread(BluetoothDevice device)
  {
    this.device = device;
    this.uuid = device.getUuids()[0].getUuid();

    try
    {
      socket =
              device.createRfcommSocketToServiceRecord(this.uuid);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void run()
  {

    try
    {
      //java.io.IOException: Service discovery failed
      // 连接蓝牙服务端
      socket.connect();

      // 发送内容
      socket.getOutputStream().write(new String("Hello").getBytes());

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        socket.close();
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    }


  }
}
