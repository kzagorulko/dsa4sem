package ru.zagorulko.exercise0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.setTitle("Clicker");

        count = 0;
        final Button button = (Button) findViewById(R.id.button);
        button.setText("You clicked " + count + " times");
    }

    public void onMyButtonClick(View view) {

        // change button text with inc. counter
        final Button button = (Button) findViewById(R.id.button);
        button.setText("You clicked " + ++count + " times");
    }
}
