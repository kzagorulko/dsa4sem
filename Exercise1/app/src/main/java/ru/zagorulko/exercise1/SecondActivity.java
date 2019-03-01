package ru.zagorulko.exercise1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private Integer[] numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // find list
        ListView lvMain;// = (ListView)findViewById(R.id.lvMain);

        numbers = new Integer[1000000];

        for(int i = 0; i < 1000000; i++) {
            numbers[i] = i;
        }

        lvMain = (ListView)findViewById(R.id.lvMain);

        ImageAdapter imageAdapter = new ImageAdapter(this, R.layout.list_item, numbers);
        lvMain.setAdapter(imageAdapter);
        /*AdapterView.OnItemLongClickListener itemListener = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Integer selectedInteger = (Integer)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт: " + selectedInteger, Toast.LENGTH_SHORT).show();
                return false;
            }
        };
        lvMain.setOnItemClickListener((AdapterView.OnItemClickListener) itemListener);*/



        // create adapter
        //ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, numbers);


        //lvMain.setAdapter(adapter);
    }


}
