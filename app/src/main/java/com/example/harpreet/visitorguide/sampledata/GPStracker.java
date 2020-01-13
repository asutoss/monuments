package com.example.harpreet.visitorguide.sampledata;


import android.Manifest;

import android.content.Context;

import android.content.pm.PackageManager;

import android.location.Location;

import android.location.LocationListener;

import android.location.LocationManager;

import android.os.Bundle;

import android.support.v4.app.ActivityCompat;
import android.widget.Toast;


public class GPStracker implements LocationListener{

    Context context;
    LocationManager lm;
    public GPStracker(Context c){

        context = c;
    }

    public Location getLocation(){

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(context, "Permission denied!", Toast.LENGTH_SHORT).show();
            return null;
        }

        lm=(LocationManager)context.getSystemService(Context.LOCATION_SERVICE);

        if(isGPSenable())

        {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,5,this);

            Location l=lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            return l;

        }
        else
        {

            Toast.makeText(context,"Please enable GPS", Toast.LENGTH_SHORT).show();

        }

        return null;

    }

    public boolean isGPSenable()
    {

        return lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }
    @Override

    public void onProviderDisabled(String provider) {

    }

    @Override

    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override

    public void onLocationChanged(Location location) {

    }

    @Override

    public void onProviderEnabled(String provider) {

    }

}