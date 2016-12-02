package com.bsz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sunyan on 16/11/25.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public <T>T bind(int id){
        return (T) findViewById(id);
    }
}
