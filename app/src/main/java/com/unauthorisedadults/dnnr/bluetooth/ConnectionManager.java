package com.unauthorisedadults.dnnr.bluetooth;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.google.android.material.snackbar.Snackbar;

public class ConnectionManager {

    private final BluetoothManager bluetoothManager;
    private final BluetoothAdapter bluetoothAdapter;

    public ConnectionManager(Context context) {
        bluetoothManager = context.getSystemService(BluetoothManager.class);
        bluetoothAdapter = bluetoothManager.getAdapter();

        if (bluetoothAdapter == null) {
            Toast.makeText(context, "Device does NOT support bluetooth", Toast.LENGTH_LONG).show();
        }
    }

    public void Connect(Context context) {
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);

        }
    }
}
