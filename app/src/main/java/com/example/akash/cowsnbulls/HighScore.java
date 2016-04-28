package com.example.akash.cowsnbulls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HighScore extends AppCompatActivity implements View.OnClickListener {

    Button res_btn,play_again_btn;
    TextView highscore_text;
    String new_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        SQLHandler sqlHandler = new SQLHandler(getApplicationContext());
        res_btn = (Button) findViewById(R.id.reset_score);
        play_again_btn = (Button) findViewById(R.id.play_again_btn);
        Intent i = getIntent();
        new_game = i.getStringExtra("new_game");
        Log.d("akash",new_game);
        if(new_game.equals("yes")){
            play_again_btn.setText("Play Now");
        }
        highscore_text = (TextView) findViewById(R.id.highscore_text);
        highscore_text.setText(sqlHandler.getScore(1)+"");
        sqlHandler.close();
        res_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLHandler Sql = new SQLHandler(getApplicationContext());
                Sql.deleteScore(Sql.getScore(1));
                highscore_text.setText(Sql.getScore(1) + "");
                Sql.close();
            }
        });
        play_again_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.transition.activity_in,R.transition.activity_out);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
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

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.transition.activity_back_in, R.transition.activity_back_out);
    }
}
