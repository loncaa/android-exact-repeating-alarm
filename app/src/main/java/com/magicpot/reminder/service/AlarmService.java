package com.magicpot.reminder.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.magicpot.reminder.Constants;
import com.magicpot.reminder.NotificationActivity;
import com.magicpot.reminder.R;

/**
 * Triggers notification
 */
public class AlarmService extends IntentService {
    public AlarmService() {
        super("ALARM THREAD");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Intent resultIntent = new Intent(this, NotificationActivity.class);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, Constants.MAINACTIVITY_ID, resultIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("New Notification")
                .setContentText("You have to take a pill!")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setDefaults(-1)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);


        Notification notification = builder.build();

        NotificationManager manager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(Constants.NOTIFICATION_ID, notification);
    }
}
