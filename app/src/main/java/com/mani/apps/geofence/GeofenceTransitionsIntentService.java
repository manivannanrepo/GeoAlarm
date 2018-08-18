package com.mani.apps.geofence;

import android.app.IntentService;
import android.content.Intent;
import android.location.Location;
import android.support.annotation.Nullable;

import com.google.android.gms.location.GeofencingEvent;

public class GeofenceTransitionsIntentService extends IntentService {
    private static final String TAG = GeofenceTransitionsIntentService.class.getSimpleName();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public GeofenceTransitionsIntentService(String name) {
        super(name);
    }

    public GeofenceTransitionsIntentService() {
        super("");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        Location location = geofencingEvent.getTriggeringLocation();
        Intent broadCastIntent = new Intent("com.mani.apps.geofence.service");
        broadCastIntent.putExtra("latitude", location.getLatitude());
        broadCastIntent.putExtra("longitude", location.getLongitude());
        broadCastIntent.putExtra("done", 1);
        sendBroadcast(broadCastIntent);
    }

}
