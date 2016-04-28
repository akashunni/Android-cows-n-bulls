package com.example.akash.cowsnbulls;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity implements View.OnClickListener {

    Button res_btn;
    TextView highscore_text;
    int high;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SQLHandler sqlHandler = new SQLHandler(getApplicationContext());
        res_btn = (Button) findViewById(R.id.reset_score);
        highscore_text = (TextView) findViewById(R.id.highscore_text);
        highscore_text.setText(sqlHandler.getScore(1)+"");
        sqlHandler.close();
        res_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLHandler Sql = new SQLHandler(getApplicationContext());
                Sql.deleteScore(Sql.getScore(1));
                highscore_text.setText(Sql.getScore(1)+"");
                Sql.close();
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
}
