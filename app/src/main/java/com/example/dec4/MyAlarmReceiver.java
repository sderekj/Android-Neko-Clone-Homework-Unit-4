package com.example.dec4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.dec4.View.MyNotificationService;

/**
 * Created by Millochka on 12/4/16.
 */

public class MyAlarmReceiver extends BroadcastReceiver {
    public static final int REQUEST_CODE = 12345;
    public static final String ACTION = "nyc.c4q.notificationdemo.alarm";



    // Triggered by the Alarm periodically (starts the notification service)
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, MyNotificationService.class);
        context.startService(i);



    }


}
