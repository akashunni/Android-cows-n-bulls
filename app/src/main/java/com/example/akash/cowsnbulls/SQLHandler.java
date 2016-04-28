package com.example.akash.cowsnbulls;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Akash on 25-09-2015.
 */
public class SQLHandler extends SQLiteOpenHelper {

    public boolean canadd = true;
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Scores";

    // Contacts table name
    private static final String TABLE_SCORE = "HighScore";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_SCORE = "Score";


    public SQLHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_SCORES_TABLE = "CREATE TABLE " + TABLE_SCORE + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_SCORE + " INTEGER" + ")";
        sqLiteDatabase.execSQL(CREATE_SCORES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE);
        // Create tables again
        onCreate(sqLiteDatabase);
    }

    void addScore(Scores score) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SCORE, score.getScore()); //
        // Inserting Row
        db.insert(TABLE_SCORE, null, values);
        db.close(); // Closing database connection
        canadd = false;
    }
    void updateScore(Scores score){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.update(TABLE_SCORE,)
        db.execSQL("UPDATE "+TABLE_SCORE+" SET "+KEY_SCORE+" = "+score.getScore()+"");
        db.close();
    }
    int getScore(int id) {
        int scr = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_SCORE+"",null);
        cursor.moveToFirst();
        Log.d("akash",""+cursor.getCount());
        if (cursor.getCount() > 0){
            cursor = db.query(TABLE_SCORE, new String[]{KEY_ID, KEY_SCORE}, KEY_ID + "=?", new String[]{"1"/*String.valueOf(id)*/}, null, null, null, null);
            cursor.moveToFirst();
            Scores scoreObj = new Scores(cursor.getInt(1));
            scr = scoreObj.getScore();
        }
        cursor.close();
        return scr;
    }
    void deleteScore(int score){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SCORE,KEY_SCORE+" = "+score,null);
        db.close();
    }
}
