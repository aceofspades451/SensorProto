package com.bit2know.sensorproto;

import android.location.*;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

import com.jjoe64.graphview.*;

public class SensorProtoMain extends Activity {

	android.widget.TextView _latTextView;
	android.widget.TextView _lonTextView;
	android.widget.TextView _speedTextView;
	android.widget.TextView _statTextView;
	SensorService _senService;

	ISensorServiceEventsHandler _senServEventsHandler = new ISensorServiceEventsHandler()
	{

		@Override
		public void OnLocationUpdated(SensorService sender) {
			_latTextView.setText(sender.latitude.toString());
			_lonTextView.setText(sender.longitude.toString());
			_speedTextView.setText(Float.toString(sender.speed));
		}
		
	};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_proto_main);
        
        
        
        _latTextView = (TextView) findViewById(R.id.LatTextView);
        _lonTextView = (TextView) findViewById(R.id.LogTextView);
        _speedTextView = (TextView) findViewById(R.id.SpeedTextView);
        _statTextView = (TextView) findViewById(R.id.statusTextView);
       
        
        _senService = new SensorService(this, _senServEventsHandler);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_sensor_proto_main, menu);
        return true;
    }
    
    
    
    
}
