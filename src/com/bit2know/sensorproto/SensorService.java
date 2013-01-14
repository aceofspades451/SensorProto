package com.bit2know.sensorproto;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class SensorService {

	Double latitude; 
	Double longitude;
	
	float speed = Float.NaN;
	
	DataService dataServ = null;
	
	private LocationManager _locationManager = null;
	
	private ISensorServiceEventsHandler _eventsHandler = null;

	
	public SensorService(Context context, ISensorServiceEventsHandler eventsHandler)
	{
		_eventsHandler = eventsHandler;
		dataServ = new DataService(context);
		_locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        _locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 0, MyListener);//request location updates from the GPS device every 500 milliseconds
	}
	
	protected void setLatitude(Double value)
	{
		latitude = value;
	}
	
	protected void setLongitude(Double value)

	{
		longitude = value;
	}
	
	protected void setSpeed(float value)
	{
		this.speed = value;
	}
	
	
//	protected Double CalculateDistance(Double latitude, Double Last_latitude, Double longitude, Double last_longitude)
//	{
//		if(last_latitude == Double.NaN || last_longitude == Double.NaN) { return -1.0; }
//		
//		Double delta_lat;
//		Double delta_lon;
//		
//		int R = 6371; //earth's radious in km
//		
//		delta_lat =  Math.toRadians(latitude - last_latitude);
//		delta_lon = Math.toRadians(longitude - last_longitude);
//		
//		Double a = Math.pow( Math.sin(delta_lat/2) , 2.0) + //sin^2(delta_lat)
//					Math.pow(  Math.sin(delta_lon/2) , 2.0) * Math.cos(latitude) * Math.cos(last_latitude);
//		Double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//		
//		return R * c;
//		
//	}
	
	
	
	LocationListener MyListener = new LocationListener()
	{
		@Override
		public void onLocationChanged(Location location) {
			setSpeed(location.getSpeed());
			setLatitude( location.getLatitude() );
			setLongitude( location.getLongitude() );
			dataServ.LogLocation(location);
			if(_eventsHandler != null)
			{
				_eventsHandler.OnLocationUpdated(SensorService.this);
			}
			
			
			
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
		
		
		
	};
}

