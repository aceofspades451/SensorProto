package com.bit2know.sensorproto;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;

public class DataService implements LocationDataLogger{
	
	SQLiteOpenHelper _databaseHelper;
	SQLiteDatabase _database;
	CursorFactory _cf ;
	//DatabaseErrorHandler _dbErrorHandler; //requires API version 11 (honeycomb)
	
	public DataService(Context context)
	{
		
		_databaseHelper = new SQLiteOpenHelper(context, "defaultDB", _cf, 1)
		{

			@Override
			public void onCreate(SQLiteDatabase db) {
				db.execSQL("CREATE TABLE location (latitude, longitude, speed, accuracy, time UNIQUE);");				
			}

			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion,
					int newVersion) {
				// TODO Auto-generated method stub
				//NOT IMPLEMENTED YET

			}
			
		};
		
		_database = _databaseHelper.getWritableDatabase();
		
	}

	public boolean LogLocation(Location location)
	{
		ContentValues values = new ContentValues();
		values.put("latitude", location.getLatitude());
		values.put("longitude", location.getLongitude());
		values.put("speed", location.getSpeed());
		values.put("accuracy", location.getAccuracy());
		values.put("time", location.getTime());
		_database.insert("location", "NullValue", values);
		
		return true;
	}
}
