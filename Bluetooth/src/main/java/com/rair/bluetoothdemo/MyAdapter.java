package com.rair.bluetoothdemo;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<BluetoothDevice> datas;
    private ConnectCallBack callBack;

    public MyAdapter(Context context, List<BluetoothDevice> datas) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.datas = datas;
    }

    public void setCallBack(ConnectCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
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
        mName.setText(datas.get(position).getName());

        TextView mAddress = (TextView) convertView.findViewById(R.id.address);
        mAddress.setText(datas.get(position).getAddress());


        Button connBluetooth = (Button) convertView.findViewById(R.id.connBluetooth);

        connBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.callBack(position);
            }
        });

        return convertView;
    }

    public interface ConnectCallBack {
         void callBack(int position);
    }
}
