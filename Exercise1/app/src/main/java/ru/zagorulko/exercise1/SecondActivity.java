package ru.zagorulko.exercise1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {

    private Integer[] numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ListView lvMain;

        // initialize a array
        numbers = new Integer[1000000];
        for(int i = 0; i < 1000000; i++) {
            numbers[i] = i;
        }

        // find list
        lvMain = (ListView)findViewById(R.id.lvMain);

        ImageAdapter imageAdapter = new ImageAdapter(this, R.layout.list_item, numbers);
        lvMain.setAdapter(imageAdapter);

    }


}
