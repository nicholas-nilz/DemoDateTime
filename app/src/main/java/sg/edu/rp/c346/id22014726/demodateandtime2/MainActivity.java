package sg.edu.rp.c346.id22014726.demodateandtime2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.BreakIterator;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.Reset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int hour, minute;
                hour = tp.getCurrentHour();
                minute = tp.getCurrentMinute();
                String timeString = String.format(Locale.getDefault(), "Time is %02d:%02d", hour, minute);

                tvDisplay.setText(timeString);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day, month, year;
                day = dp.getDayOfMonth();
                month = dp.getMonth() + 1;
                year = dp.getYear();

                tvDisplay.setText("Date is " + day + "/" + month + "/" + year);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setHour(0);
                tp.setMinute(0);
                dp.updateDate(2020, 0, 1);

            }
        });
    }
}