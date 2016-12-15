package com.example.dec4.View;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.dec4.Model.AnimalDatabaseHelper;
import com.example.dec4.Model.Bunny;
import com.example.dec4.Model.Icons;
import com.example.dec4.SecondActivity;

import java.util.Calendar;
import java.util.Random;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by Millochka on 12/4/16.
 */

public class MyNotificationService extends IntentService {

    private static final String SERVICE_NAME = "notification-service";
    Random mRandomNumber;
    public static SQLiteDatabase db;
    public static AnimalDatabaseHelper dbHelper;
    public static Icons mIcons;


    // Must create a default constructor
    public MyNotificationService() {
        super(SERVICE_NAME);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mRandomNumber = new Random();
        dbHelper = AnimalDatabaseHelper.getInstance(this);
        db = dbHelper.getWritableDatabase();


        // if you override onCreate(), make sure to call super().
        // If a Context object is needed, call getApplicationContext() here.
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        /* Mila's previous code for code below

        int NOTIFICATION_ID = 555; // Setting a notification ID allows you to update the notification later on.

        intent = new Intent(this, SecondActivity.class);
        int requestID = (int) System.currentTimeMillis(); // Unique requestID to differentiate between various notification with same notification ID
        int flags = PendingIntent.FLAG_CANCEL_CURRENT; // Cancel old intent and create new one
        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestID, intent, flags);

        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_favorite_black_24dp)
                .setContentTitle("A bunny is here!")
                .setContentText("Hello World!")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true) // Hides the notification after its been selected
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NOTIFICATION_ID, notification);


        int tempNumber = mRandomNumber.nextInt(9) + 1; // fixed outofbounds exception
        mIcons = new Icons();
        String catName = "Bunny" + tempNumber;
        Long lastFed = Calendar.getInstance().getTimeInMillis();
        addBunny(new Bunny(catName, lastFed, mIcons.getmIcons().get(tempNumber)));
        Toast.makeText(this, "Added Bunny", Toast.LENGTH_SHORT).show();

         */

        int NOTIFICATION_ID = 555; // Setting a notification ID allows you to update the notification later on.

        intent = new Intent(this, SecondActivity.class);
        int requestID = (int) System.currentTimeMillis(); // Unique requestID to differentiate between various notification with same notification ID
        int flags = PendingIntent.FLAG_CANCEL_CURRENT; // Cancel old intent and create new one
        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestID, intent, flags);

        int tempNumber = mRandomNumber.nextInt(9) + 1; // fixed outofbounds exception
        String bunnyName = "Bunny " + tempNumber;
        mIcons = new Icons();
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(mIcons.getmNotifIcons().get(tempNumber-1))
                .setContentTitle("A bunny is here!")
                .setContentText(bunnyName)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true) // Hides the notification after its been selected
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NOTIFICATION_ID, notification);




        Long lastFed = Calendar.getInstance().getTimeInMillis();
        addBunny(new Bunny(bunnyName, lastFed, mIcons.getmIcons().get(tempNumber - 1)));
        Toast.makeText(this, "Added Bunny", Toast.LENGTH_SHORT).show();

    }

    private void addBunny(Bunny bunny) {
        cupboard().withDatabase(db).put(bunny);
    }


}
