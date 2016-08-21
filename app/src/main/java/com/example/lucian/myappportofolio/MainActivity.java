package com.example.lucian.myappportofolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Formatter;

public class MainActivity extends AppCompatActivity {

    /**
     * Inner class - handles button on touch events
     */
    class ButtonOnTouchListener implements View.OnTouchListener {
        private String appName;

        public ButtonOnTouchListener(String appName) {
            this.appName = appName;
        }
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb);
            formatter.format(getString(R.string.toast_message), appName.toLowerCase());

            Toast.makeText(getApplicationContext(), sb.toString(),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    // button ids
    private int[] buttons;
    // app name
    private String[] appNames;

    void initData() {
        buttons = new int[]{R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6};
        appNames = new String[]{getString(R.string.popular_movies),
                getString(R.string.stock_hawk),
                getString(R.string.build_it_bigger),
                getString(R.string.make_your_app_material),
                getString(R.string.go_ubiquitous),
                getString(R.string.capstone)};
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        for (int loop = 0; loop < buttons.length; ++loop) {
            Button button = (Button) findViewById(buttons[loop]);
            button.setOnTouchListener(new ButtonOnTouchListener(appNames[loop]));
        }
    }
}
