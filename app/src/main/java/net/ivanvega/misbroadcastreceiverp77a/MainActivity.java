package net.ivanvega.misbroadcastreceiverp77a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    MyReceiverDeManifest receiverDeManifest
            = new MyReceiverDeManifest();

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter =
                new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
        filter.addAction("com.example.broadcast.MY_NOTIFICATION");

        registerReceiver(receiverDeManifest, filter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSend_click(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.broadcast.MY_NOTIFICATION");
        intent.putExtra("data","Notice me senpai!");
        sendBroadcast(intent);
    }
}
