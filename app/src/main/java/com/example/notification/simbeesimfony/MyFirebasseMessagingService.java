package com.example.notification.simbeesimfony;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebasseMessagingService extends FirebaseMessagingService {
    public MyFirebasseMessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);


        sendNotification(remoteMessage.getNotification().getBody());
    }
    private void sendNotification(String messageBody)
    {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_ONE_SHOT);

        Uri defaaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilde = new NotificationCompat.Builder(this);


        notificationBuilde.setContentTitle("Appeteria Tehnologies");
        notificationBuilde.setContentTitle(messageBody);
        notificationBuilde.setAutoCancel(true);
        notificationBuilde.setSound(defaaultSoundUri);
        notificationBuilde.setContentIntent(pendingIntent);

        System.out.print(messageBody);


        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilde.build());

    }
}
