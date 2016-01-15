package com.tonyruns.triviaalarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Tony on 2016-01-14.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        long id = intent.getLongExtra("id", 0);
        String msg = intent.getStringExtra("msg");

        Notification n = new Notification.Builder(context)
                .setSmallIcon(R.drawable.ic_alarm_black_18dp)
                .setContentTitle("dog")
                .setContentText("doggy").build();
        //R.drawable.ic_alarm_add_black_18dp, msg,
          //      System.currentTimeMillis());
        PendingIntent pi = PendingIntent.getActivity(context, 0, new Intent(), 0);

        n = new Notification.Builder(context)
                .setSmallIcon(R.drawable.ic_alarm_black_18dp)
                .setContentTitle("Trivia Alarm")
                .setContentText(msg)
                .setContentIntent(pi).build();
       // n.setLatestEventInfo(context, "Remind Me", msg, pi);
        // TODO check user preferences
        n.defaults |= Notification.DEFAULT_VIBRATE;
        n.sound = Uri.parse(TriviaAlarm.getRingtone());
//      n.defaults |= Notification.DEFAULT_SOUND;
        n.flags |= Notification.FLAG_AUTO_CANCEL;

        NotificationManager nm = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify((int)id, n);
    }

}
