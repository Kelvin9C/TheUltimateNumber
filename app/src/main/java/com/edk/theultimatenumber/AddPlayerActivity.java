package com.edk.theultimatenumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddPlayerActivity extends AppCompatActivity {

    private ArrayList<String> mNameArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        ImageView addNameImg = (ImageView) findViewById(R.id.addPlayerImg);
        final EditText nameText = (EditText) findViewById(R.id.nameText);
        ListView listView = (ListView) findViewById(R.id.playerListView);

        final ArrayAdapter listAdapter = new ArrayAdapter<>(this, R.layout.list_view, mNameArray);

        listView.setAdapter(listAdapter);

        addNameImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameText.getText().toString();

                if (name == null || name.equals("")) {
                    Toast.makeText(AddPlayerActivity.this, "Please enter a name.", Toast.LENGTH_SHORT).show();
                } else {
                    listAdapter.add(name);
                }

            }
        });
    }
}
