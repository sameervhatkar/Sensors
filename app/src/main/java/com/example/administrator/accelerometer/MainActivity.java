package com.example.administrator.accelerometer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.Semaphore;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "MainActivity";
    private SensorManager mSensorManager;
    private Sensor mAccelometer, mMagno, mGyno, light, temp, hum, pressure;
    TextView xAccelerometer, yAccelerometer, zAccelerometer, textAccelerometer, textMagnometer, textGynometer, textLight, textTemperature, textHumidity, textPressure, xMagnometer, yMagnometer, zMagnometer,xGynometer, yGynometer, zGynometer, xlight, xhum, xpressure, xtemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xAccelerometer = findViewById(R.id.xAccelerometer);
        yAccelerometer = findViewById(R.id.yAccelerometer);
        zAccelerometer = findViewById(R.id.zAccelerometer);
        textAccelerometer = findViewById ( R.id.textAccelerometer );
        textGynometer = findViewById ( R.id.textGynometer );
        textMagnometer = findViewById ( R.id.textMagnometer );
        textLight = findViewById ( R.id.textLight );
        textTemperature = findViewById ( R.id.textTemperature );
        textHumidity = findViewById ( R.id.textHumidity );
        textPressure = findViewById ( R.id.textPressure );
        xMagnometer = findViewById ( R.id.xMagnometer );
        yMagnometer = findViewById ( R.id.yMagnometer );
        zMagnometer = findViewById ( R.id.zMagnometer );
        xGynometer = findViewById ( R.id.xGynometer );
        yGynometer = findViewById ( R.id.yGynometer );
        zGynometer = findViewById ( R.id.zGynometer );
        xlight = findViewById ( R.id.xlight );
        xtemp = findViewById ( R.id.xtemp );
        xhum = findViewById ( R.id.xhum );
        xpressure = findViewById ( R.id.xpressure );

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mGyno = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        light = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        hum = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        mMagno = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        temp = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        pressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);

        if(mAccelometer != null)
        {
            mSensorManager.registerListener(MainActivity.this, mAccelometer, SensorManager.SENSOR_DELAY_NORMAL);
            textAccelerometer.setText ( "Accelerometer Supported"  );


        }
        else
        {
            textAccelerometer.setText ( "Accelerometer  Not Supported"  );
            xAccelerometer.setText ( "X Values: 0" );
            yAccelerometer.setText ( "Y Values: 0" );
            zAccelerometer.setText ( "Z Values: 0");
        }
        if(mMagno != null)
        {
            mSensorManager.registerListener(MainActivity.this, mMagno,SensorManager.SENSOR_DELAY_NORMAL);
            textMagnometer.setText ( "Magnometer Supported" );

        }
        else
        {
            textMagnometer.setText ( "Magnometer Not Supported" );
            xMagnometer.setText ( "X Values: 0");
            yMagnometer.setText ( "Y Values: 0");
            zMagnometer.setText ( "Z Values: 0" );
        }
        if(mGyno != null)
        {
            mSensorManager.registerListener(MainActivity.this, mGyno, SensorManager.SENSOR_DELAY_NORMAL);
            textGynometer.setText ( "Gynometer Supported" );

        }
        else
        {
            textGynometer.setText ( "Gynometer Not Supported" );
            xGynometer.setText ( "X Values: 0" );
            yGynometer.setText ( "Y Values: 0");
            zGynometer.setText ( "Z Values: 0" );
        }
        if(light != null)
        {
            mSensorManager.registerListener(MainActivity.this, light, SensorManager.SENSOR_DELAY_NORMAL);
            textLight.setText ( "Light Sensor Supported" );

        }
        else
        {
            textLight.setText ( "Light Sensor Not Supported" );
            xlight.setText ( "Values: 0" );
        }
        if(temp != null)
        {
            mSensorManager.registerListener(MainActivity.this, temp, SensorManager.SENSOR_DELAY_NORMAL);
            textTemperature.setText ( "Temperature Sensor Supported" );

        }
        else
        {
            textTemperature.setText ( "Temperature Sensor Not Supported" );
            xtemp.setText ( "Values: 0" );
        }
        if(hum != null)
        {
            mSensorManager.registerListener(MainActivity.this, hum, SensorManager.SENSOR_DELAY_NORMAL);
            textHumidity.setText ( "Humidity Sensor Supported" );

        }
        else
        {
            textHumidity.setText ( "Humidity Sensor Not Supported" );
            xhum.setText ( "Values: 0" );
        }
        if(pressure != null)
        {
            mSensorManager.registerListener ( MainActivity.this, pressure, SensorManager.SENSOR_DELAY_NORMAL );
            textPressure.setText ( "Pressure Sensor Supported" );
        }

        else
        {
            textPressure.setText ( "Pressure Sensor Not Supported" );
            xpressure.setText ( "Values: 0" );
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
    Sensor sensor = sensorEvent.sensor;
    if(sensor.getType () == Sensor.TYPE_ACCELEROMETER)
    {
        xAccelerometer.setText ( "X Values" + sensorEvent.values[ 0 ] );
        yAccelerometer.setText ( "Y Values" + sensorEvent.values[ 1 ] );
        zAccelerometer.setText ( "Z Values" + sensorEvent.values[ 2 ] );
    }
    else if(sensor.getType ()== Sensor.TYPE_MAGNETIC_FIELD)
    {
        xMagnometer.setText ( "X Values" + sensorEvent.values[ 0 ] );
        yMagnometer.setText ( "Y Values" + sensorEvent.values[ 1 ] );
        zMagnometer.setText ( "Z Values" + sensorEvent.values[ 2 ] );
    }
    else if(sensor.getType ()== Sensor.TYPE_GYROSCOPE)
    {
        xGynometer.setText ( "X Values" + sensorEvent.values[ 0 ] );
        yGynometer.setText ( "Y Values" + sensorEvent.values[ 1 ] );
        zGynometer.setText ( "Z Values" + sensorEvent.values[ 2 ] );
    }
    else if(sensor.getType () == Sensor.TYPE_LIGHT)
    {
        xlight.setText ( "Values"+ sensorEvent.values[0] );
    }
    else if(sensor.getType () == Sensor.TYPE_RELATIVE_HUMIDITY)
    {
        xhum.setText ( "Values"+ sensorEvent.values[0] );
    }
    else if(sensor.getType () == Sensor.TYPE_PRESSURE)
    {
        xpressure.setText ( "Values"+ sensorEvent.values[0] );
    }
    else if(sensor.getType () == Sensor.TYPE_TEMPERATURE)
    {
        xtemp.setText ( "Values"+ sensorEvent.values[0] );
    }




    }
}
