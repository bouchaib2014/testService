package com.example.ennbou.testservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static long time;
    private static long count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        (findViewById(R.id.btn_start_service)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!MyService.isRunning()){
                    startService(new Intent(MainActivity.this, MyService.class));
                    time = System.currentTimeMillis();
                    count = 1;
                }else{
                    Toast.makeText(getApplicationContext(), "service is already starting ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        (findViewById(R.id.btn_stop_service)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MyService.isRunning()){
                    stopService(new Intent(MainActivity.this, MyService.class));
                    count = System.currentTimeMillis() - time;
                    Log.d("stop count", count+"");
                    count = 0;
                }else{
                    Toast.makeText(getApplicationContext(), "service isn't starting yet", Toast.LENGTH_SHORT).show();
                }
            }
        });

        (findViewById(R.id.btn_get_count)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count > 0){
                    count = System.currentTimeMillis() - time;
                    TextView countView = findViewById(R.id.count);
                    countView.setText(count+"");
                    Log.d("get count", count+"");
                }else{
                    Toast.makeText(getApplicationContext(), "service is died", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
