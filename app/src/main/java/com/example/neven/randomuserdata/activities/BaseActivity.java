package com.example.neven.randomuserdata.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.neven.randomuserdata.MyApplication;
import com.example.neven.randomuserdata.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        ((MyApplication)getApplication()).getAppComponent().inject(this);



    }
}