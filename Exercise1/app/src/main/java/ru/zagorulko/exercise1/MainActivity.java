package ru.zagorulko.exercise1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler hander = new Handler();
        hander.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000, 20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), SecondActivity.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }
        }, 300);

    }
}
