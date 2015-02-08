package com.project.daniarheri.comvogellaandroidlifecycle;

/**
 * Created by daniar heri on 2/8/2015.
 */
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SecondActivity extends TracerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
    }

}