package com.example.akash.cowsnbulls;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class optionsDialog extends Dialog implements View.OnClickListener{

    Activity curr_act;
    Button res_btn,newgame_btn,exit_btn;
    public optionsDialog(Activity a) {
        super(a);
        this.curr_act = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_dialog);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        res_btn = (Button) findViewById(R.id.res_btn);
        newgame_btn = (Button) findViewById(R.id.newgame_btn);
        exit_btn = (Button) findViewById(R.id.exit_btn);
        res_btn.setOnClickListener(this);
        newgame_btn.setOnClickListener(this);
        exit_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.res_btn:
                dismiss();
                break;
            case R.id.newgame_btn:
                curr_act.finish();
                break;
            case R.id.exit_btn:
                System.exit(1);
                break;
        }
    }
}
