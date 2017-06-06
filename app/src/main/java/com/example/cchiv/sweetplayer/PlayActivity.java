package com.example.cchiv.sweetplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PlayActivity extends AppCompatActivity {

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                flag = true;
                return false;
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(flag) {
                    switch (position) {
                        case 0: {
                            Intent intent = new Intent(PlayActivity.this, MainActivity.class);
                            startActivity(intent);
                            flag = false;
                            break;
                        }
                        case 1: {
                            Intent intent = new Intent(PlayActivity.this, ArtistsActivity.class);
                            startActivity(intent);
                            flag = false;
                            break;
                        }
                        case 2: {
                            Intent intent = new Intent(PlayActivity.this, AlbumsActivity.class);
                            startActivity(intent);
                            flag = false;
                            break;
                        }
                        case 3: {
                            Intent intent = new Intent(PlayActivity.this, GenresActivity.class);
                            startActivity(intent);
                            flag = false;
                            break;
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
