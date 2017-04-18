package com.edk.theultimatenumber;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SetMaxActivity extends AppCompatActivity {

    private int mMaxNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_max);

        //spinner setting
        Spinner spinner = (Spinner) findViewById(R.id.maxNumber_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.maxNumber_array, R.layout.my_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                mMaxNumber = Integer.valueOf(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        TextView goTextView = (TextView) findViewById(R.id.goTextView);
        goTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link FamilyActivity}
                Intent playIntent = new Intent(SetMaxActivity.this, PlayingActivity.class);
                // to send value to another activity.
                playIntent.putExtra("maxNumber", mMaxNumber);
                // Start the new activity
                startActivity(playIntent);

            }
        });


    }
}
