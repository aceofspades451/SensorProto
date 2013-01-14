package com.bit2know.sensorproto;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class MyLocationListener implements LocationListener
{
	@Override
	public void onLocationChanged(Location location) {
		Double lat = location.getLatitude();
		Double lon = location.getLongitude();
		//_latTextView.setText(lat.toString());
		//_lonTextView.setText(lon.toString());
		
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	
	
}

