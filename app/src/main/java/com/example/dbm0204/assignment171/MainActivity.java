package com.example.dbm0204.assignment171;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Creating class by extending AppCompatActivity.
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    //Creating references of elements used in the layout.
    Button startBtn,stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);    //Setting content view.

        //Setting references with their IDs.
        startBtn=(Button)findViewById(R.id.start_btn);
        stopBtn=(Button)findViewById(R.id.stop_btn);

        //Setting onClick listeners to the Buttons.
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
    }

    @Override
    //Method to handle the onClick events.
    public void onClick(View v)
    {
        //if START is pressed.
        if(v.getId()==R.id.start_btn)
        {
            //Creating Intent to switch to Service.
            Intent changeToService = new Intent(MainActivity.this,MusicService.class);
            startService(changeToService);   //Starting service.
        }
        //if STOP is clicked.
        else if(v.getId()==R.id.stop_btn)
        {
            //Creating Intent to stop the Service.
            Intent stoppingIntent = new Intent(MainActivity.this,MusicService.class);
            stopService(stoppingIntent);   //stopping Service.
        }
    }
}
