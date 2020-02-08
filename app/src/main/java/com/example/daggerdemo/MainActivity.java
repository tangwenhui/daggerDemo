package com.example.daggerdemo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.daggerdemo.di.DaggerMyComponent;
import com.example.daggerdemo.object.DbOnbject;
import com.example.daggerdemo.object.HttpOnbject;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    HttpOnbject httpOnbject;

    @Inject
    DbOnbject dbOnbject;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMyComponent.create().injectMainActivity(this);

        Log.d("tangwh",httpOnbject.hashCode()+"");
        Log.d("tangwh",dbOnbject.hashCode()+"");
    }


}
