package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int clickCounter = 0;
    private int record = 0;
    private boolean running = false;

    private Button startButton;
    private TextView counterTV;
    private TextView recordTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        counterTV = findViewById(R.id.counterTV);
        recordTV = findViewById(R.id.recordTV);
    }

    public void onStartButtonClick(View v) {
        if (!running) {
            startButton.setEnabled(false);
            clickCounter = 0;
            running = true;
            counterTV.setText(Integer.toString(clickCounter));

            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    onFinish();
                }
            }, 3000);
        }
    }

    public void onScreenClick(View v) {
        if (running) {
            clickCounter++;
            counterTV.setText(Integer.toString(clickCounter));
        }
    }

    private void onFinish() {
        Toast.makeText(this, "Finish! You clicked " + clickCounter + " times", Toast.LENGTH_SHORT).show();
        if (record < clickCounter) {
            record = clickCounter;
            recordTV.setText(Integer.toString(record));
        }
        startButton.setEnabled(true);
        running = false;
    }
}
