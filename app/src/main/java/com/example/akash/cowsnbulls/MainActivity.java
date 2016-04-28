package com.example.akash.cowsnbulls;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity{

    public void create_rand(){
        Random random = new Random();
        for(i=0;i<4;i++){
            rand_arr[i] = random.nextInt((max - min) + 1) + min;
            Log.d("akash",rand_arr[i]+"");
            for(j=i-1;j>=0;j--){
                if(rand_arr[i] == rand_arr[j]){
                    Log.d("akash","Condition*"+rand_arr[j]);
                    temp = random.nextInt((max - min) + 1) + min;
                    Log.d("akash","Temp* = "+temp);
                    if(check(temp,i)>0)
                        j=i;
                    else
                        rand_arr[i] = temp;
                }
            }
            rand+=(rand_arr[i])*t;
            ans=rand;
            t/=10;
        }
    }

    public int check(int temp,int i){
        Random random = new Random();
        int j;
        for(j=i-1;j>=0;j--){
            if(temp == rand_arr[j]){
                temp = random.nextInt((max - min) + 1) + min;
                rand_arr[i] = temp;
                Log.d("akash","Temp* check = "+temp);
                return temp;
            }
        }
        return 0;
    }

    public ArrayList getData(){
        int x;
        ArrayList<Information> Arr_list = new ArrayList<Information>();
        for(x=0;x<k;x++){
            Information info_obj = new Information(chance_list[x],cow_list[x],bull_list[x],answer[x]);
            Arr_list.add(info_obj);
        }
        return  Arr_list;
    }

    NumberPicker n1,n2,n3,n4 = null;
    TextView usr;
    Button btn;
    ImageButton options;


   /* private SQLiteDatabase database;
    private SQLHelper helper;*/

    private Vibrator vib;
    public int min=1,max=9,rand,i=3,temp,j,k,bulls,cows,chance,t=1000,ans,score;
    int[] ans_arr = new int[4];
    int[] inp_arr = new int[4];
    int[] rand_arr = new int[4];
    int[] cow_list = new int[20];
    int[] bull_list = new int[20];
    int[] chance_list = new int[20];
    String[] answer = new String[20];
    boolean bulls_max =false;
    long[] ptrn ={0,100,100,300};
    //int[] rand_arr = {3,6,6,6};
    /////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*//////////  Database ////////////////
        SQLiteDatabase database = openOrCreateDatabase("cowsnbulls",MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE IF NOT EXISTS Highcore(Score Integer);");
        database.execSQL("INSERT INTO Highscore VALUES ("+ans+");");*/
        //database.execSQL("INSERT INTO Highscore VALUES ("+ans+");");
        //database.insert("Highscore",null,ans);
        ///////////////////////////////////////
        final MediaPlayer player = MediaPlayer.create(this,R.raw.tick);
        ////////////////////////////////////
        final ListView listview = (ListView) findViewById(R.id.listView);
        player.setVolume(100,100);
        n1 = (NumberPicker) findViewById(R.id.numPick1);
        n2 = (NumberPicker) findViewById(R.id.numPick2);
        n3 = (NumberPicker) findViewById(R.id.numPick3);
        n4 = (NumberPicker) findViewById(R.id.numPick4);
        usr = (TextView) findViewById(R.id.usr_text);
        btn = (Button) findViewById(R.id.btn);
        options = (ImageButton) findViewById(R.id.options);
        vib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        n1.setMinValue(1);
        n2.setMinValue(1);
        n3.setMinValue(1);
        n4.setMinValue(1);

        n1.setMaxValue(9);
        n2.setMaxValue(9);
        n3.setMaxValue(9);
        n4.setMaxValue(9);

        n1.setValue(1);
        n2.setValue(2);
        n3.setValue(3);
        n4.setValue(4);

        n1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        n2.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        n3.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        n4.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        listview.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);/* To Scroll and show bottom */
        listview.setStackFromBottom(true);
        usr.setText(n1.getValue() + "" + n2.getValue() + "" + n3.getValue() + n4.getValue());



        //////////////// NUMBER VALUE SET ////////////////////////////////////
        n1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                player.start();
                usr.setText(picker.getValue()+""+n2.getValue()+""+n3.getValue()+n4.getValue());
            }
        });
        n2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                usr.setText(n1.getValue()+""+picker.getValue()+""+n3.getValue()+n4.getValue());
            }
        });
        n3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                usr.setText(n1.getValue()+""+n2.getValue()+""+picker.getValue()+n4.getValue());
            }
        });
        n4.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                usr.setText(n1.getValue() + "" + n2.getValue() + "" + n3.getValue() + picker.getValue());
            }
        });
        //////////////////////////////////////////////////////////////////////

        //////////////// RANDOM NUMBERS ///////////////////////////////////////
        create_rand();
        ///////////////////////////////////////////////////////////////////////

        Toast.makeText(this, "Developer Version Answer = "+rand, Toast.LENGTH_SHORT).show();

        i=3;
        while (i>=0){
            ans_arr[i] = rand%10;
            rand/=10;
            i--;
        }
        //////////////////////////////////////////////////////////
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionsDialog op = new optionsDialog(MainActivity.this);
                op.show();
            }
        });
        /////////////// CHECKING + BUTTON CLICK ///////////////////
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = 20-k;
                SQLHandler SQLObj = new SQLHandler(getApplicationContext());
                Toast.makeText(getApplicationContext(), "Score : "+score, Toast.LENGTH_SHORT).show();
                if(k==20 && !bulls_max){
                    //Intent Pettali..!
                    Toast.makeText(getApplicationContext(), "You Lost Man..! Answer = "+ans, Toast.LENGTH_SHORT).show();
                }
                chance++;
                inp_arr[0] = n1.getValue();
                inp_arr[1] = n2.getValue();
                inp_arr[2] = n3.getValue();
                inp_arr[3] = n4.getValue();
                for(i=0;i<4;i++){
                    if(ans_arr[i] == inp_arr[i])
                        bulls++;
                    for(j=0;j<4;j++){
                        if(ans_arr[i] == inp_arr[j] && j!=i)
                            cows++;
                    }
                }
                if(bulls==4)
                    bulls_max=true;
                if(bulls_max){
                    Toast.makeText(getApplicationContext(), "Congrats, You Won..!", Toast.LENGTH_SHORT).show();
                    if(SQLObj.getScore(1)<score && SQLObj.canadd)
                        SQLObj.addScore(new Scores(score));
                    if(SQLObj.getScore(1)<score && !SQLObj.canadd)
                        SQLObj.updateScore(new Scores(score));
                    /*Intent i = new Intent(getApplicationContext(),optionsDialog.class);
                    startActivity(i);*/
                    score = 0;
                }
                else
                    vib.vibrate(ptrn,-1);
                if(k<20){
                    cow_list[k] = cows;
                    bull_list[k] = bulls;
                    chance_list[k] = chance;
                    answer[k] = inp_arr[0]+""+inp_arr[1]+""+inp_arr[2]+""+inp_arr[3];
                    k++;
                }
                ArrayList list_details = getData();
                listview.setAdapter(new List_Adapter(getApplicationContext(),list_details));
                Log.d("akash","Answer "+k+" :"+answer[k-1]);
                cows=0;
                bulls=0;
            }
        });
        /*text_cow.setText(Integer.toString(cows));
                text_bull.setText(Integer.toString(bulls));
                text_chance.setText(Integer.toString(chance));
                if(bulls!=4){
                    vib.vibrate(100);
                }*/
        /////////////////////////////////////////////////////////////
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}

