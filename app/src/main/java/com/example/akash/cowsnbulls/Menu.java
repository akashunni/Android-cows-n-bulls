package com.example.akash.cowsnbulls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button btn1 = (Button) findViewById(R.id.play_game_btn);
        Button btn2 = (Button) findViewById(R.id.settings_btn);
        Button btn3 = (Button) findViewById(R.id.high_score_btn);
        Button btn4 = (Button) findViewById(R.id.abt_dev_btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Settings.class);
                startActivity(i);
                //Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_SHORT).show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Developer.class);
                startActivity(i);
                //Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    @Override
    public void onClick(View v) {
        Log.d("akash", "on Click");
        switch (v.getId()){
            case R.id.play_game_btn:
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                Log.d("akash", "Splash 1");
                break;
            case R.id.settings_btn:
                Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_SHORT).show();
                Log.d("akash", "Splash 2");
                break;
            case R.id.high_score_btn:
                Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_SHORT).show();
                break;
            case R.id.abt_dev_btn:
                Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_SHORT).show();
                break;
        }
    }*/
}
