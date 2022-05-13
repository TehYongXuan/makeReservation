package sg.edu.rp.c346.id21010860.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    DatePicker dp;
    TimePicker tp;
    CheckBox cb1;

    Button bc;
    Button br;
    TextView tvDisplay;
    TextView tv2;
    EditText etPax;
    EditText etPH;
    EditText etName;
    TextView tv1;
    TextView tv;
    TextView tvDisplay2;
    TextView tvDisplay3;
    TextView tvDisplay001;
    TextView tvDisplay002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        tv1 = findViewById(R.id.textView1);
        etName = findViewById(R.id.editTextName);
        etPH = findViewById(R.id.editTextPH);
        etPax = findViewById(R.id.editTextPax);
        tv2 = findViewById(R.id.textView2);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cb1 = findViewById(R.id.checkBox1);

        bc = findViewById(R.id.buttonConfirm);
        br = findViewById(R.id.buttonReset);
        tvDisplay = findViewById(R.id.textViewDisplay);
        tvDisplay2 = findViewById(R.id.textViewDisplay2);
        tvDisplay3 = findViewById(R.id.textViewDisplay3);

        tvDisplay001 = findViewById(R.id.textViewDisplay001);
        tvDisplay002 = findViewById(R.id.textViewDisplay002);


        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int hr = tp.getCurrentHour();
                int min = tp.getCurrentMinute();
                String hour = tp.getCurrentHour().toString();
                String minutes = tp.getCurrentMinute().toString();

                int day = dp.getDayOfMonth();
                int yr = dp.getYear();
                int month = dp.getMonth()+1;


                tvDisplay2.setText("Time and date booked is "+hour +":"+minutes +" and "+day +"/"+month +"/"+yr);



                String name = String.valueOf(etName.getText());
                String ph = String.valueOf(etPH.getText());
                String pax = String.valueOf(etPax.getText());

                tvDisplay.setText("Name: "+ name);
                tvDisplay001.setText( "Phone No: "+ ph );
                tvDisplay002.setText( "Pax: "+ pax);

                if (cb1.isChecked()) {

                    tvDisplay3.setText("Prefer smoking area");
                } else
                    tvDisplay3.setText("Prefer non-smoking area");

                Toast.makeText(MainActivity.this,"Button confirm", Toast.LENGTH_LONG).show();
            }



        });
        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int year = dp.getYear();
                int month = dp.getMonth();
                int dayOfMonth = dp.getDayOfMonth();
                dp.updateDate(year = 2020, month = 6, dayOfMonth = 01);

                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);

                tvDisplay001.setText("");
                tvDisplay002.setText("");
                tvDisplay.setText("");
                tvDisplay2.setText("");
                tvDisplay3.setText("");

                Toast.makeText(MainActivity.this,"Button Reset", Toast.LENGTH_LONG).show();
            }

        });



    }
}
