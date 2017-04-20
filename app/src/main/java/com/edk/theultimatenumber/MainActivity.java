package com.edk.theultimatenumber;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView singlePlayView = (TextView) findViewById(R.id.singlePlayerView);
        TextView multiplayView = (TextView) findViewById(R.id.multiplayerView);
        TextView howToPlayView = (TextView) findViewById(R.id.howView);
        TextView settingView = (TextView) findViewById(R.id.settingView);

        singlePlayView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link FamilyActivity}
                Intent singlePlayerIntent = new Intent(MainActivity.this, SetMaxActivity.class);

                // to send value to another activity.
                // singlePlayerIntent.putExtra("intVariableName", intValue);

                // Start the new activity
                startActivity(singlePlayerIntent);

            }
        });

        //TODO : add multiplayer click listener

        //TODO : add How to play click listener

        //TODO : add setting click listener




    }

}
