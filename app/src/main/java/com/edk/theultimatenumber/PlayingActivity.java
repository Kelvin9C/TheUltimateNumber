package com.edk.theultimatenumber;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class PlayingActivity extends AppCompatActivity {

    private int mMin = 0, mMax;
    private int mSelectedNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_page);

        final TextView minTextView = (TextView) findViewById(R.id.minNumberView);
        final TextView maxTextView = (TextView) findViewById(R.id.maxNumberView);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final TextView gameTextView = (TextView) findViewById(R.id.timerView);
        TextView ultimateView = (TextView) findViewById(R.id.nameTextView);
        final TextView selectedNumberTextView = (TextView) findViewById(R.id.selectedNumberTextView);


        //TODO : set a view to cover (disable) whole page.

        Intent mIntent = getIntent();
        mMax = mIntent.getIntExtra("maxNumber", 0);

        //set initial min & max to TextViews
        minTextView.setText(String.valueOf(mMin));
        maxTextView.setText(String.valueOf(mMax));
        selectedNumberTextView.setText(String.valueOf(mSelectedNumber));

        //set the random ultimate number
        Random random = new Random();
        final int ultimateNumber = random.nextInt(mMax + 1);

        // TEST : show ultimate number.

        ultimateView.setText(String.valueOf(ultimateNumber));

        //set initial min & max to seek bar
        seekBar.setMax(mMax - mMin);
        seekBar.setProgress(0);

        //seek bar action. setOnSeekBarChangeListener.
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                mSelectedNumber = mMin + progress;

                selectedNumberTextView.setText(String.valueOf(mSelectedNumber));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //submit button action. setOnClickListener.
        selectedNumberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if the selected number is the ultimate number.
                if (mSelectedNumber == ultimateNumber) {
                    //GAME OVER.
                    gameTextView.setText(R.string.game_over);
                    seekBar.setVisibility(View.GONE);
                    minTextView.setVisibility(View.GONE);
                    maxTextView.setVisibility(View.GONE);
                    selectedNumberTextView.setEnabled(false);
                } else if (mSelectedNumber < ultimateNumber) {
                    //SAFE, reset seek bar
                    mMin = mSelectedNumber + 1;
                    minTextView.setText(String.valueOf(mMin));
                    seekBar.setMax(mMax - mMin);
                    seekBar.setProgress(0);
                    gameTextView.setText(R.string.safe);
                } else if (mSelectedNumber > ultimateNumber) {
                    //SAFE, reset seek bar
                    mMax = mSelectedNumber - 1;
                    maxTextView.setText(String.valueOf(mMax));
                    seekBar.setMax(mMax - mMin);
                    seekBar.setProgress(mMax - mMin);
                    gameTextView.setText(R.string.safe);
                }

                if (mMax == mMin) {
                    gameTextView.setText(R.string.you_win);
                    seekBar.setVisibility(View.GONE);
                    minTextView.setVisibility(View.GONE);
                    maxTextView.setVisibility(View.GONE);
                    selectedNumberTextView.setEnabled(false);
                }
            }
        });

        //TODO : countdown 5 sec. then set the cover view gone. Game on!

    }

}
