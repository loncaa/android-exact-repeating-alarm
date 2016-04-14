package com.magicpot.reminder.receivers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.magicpot.reminder.Constants;
import com.magicpot.reminder.service.AlarmService;

/**
 * Created by Antonio on 8.4.2016..
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, AlarmReceiver.class);
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, Constants.ALARM_ID, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

        manager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 500, pendingIntent); //sljedeci alarm za minutu


        Intent i = new Intent(context, AlarmService.class);
        context.startService(i);
    }
}
