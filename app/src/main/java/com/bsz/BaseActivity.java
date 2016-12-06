package com.bsz;

import android.os.Bundle;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * Created by sunyan on 16/11/25.
 */
public class BaseActivity extends RxAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public <T>T bind(int id){
        return (T) findViewById(id);
    }
}
