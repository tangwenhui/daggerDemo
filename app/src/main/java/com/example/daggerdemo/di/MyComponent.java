package com.example.daggerdemo.di;

import com.example.daggerdemo.MainActivity;

import dagger.Component;

@Component(modules = {HttpModule.class,DbModule.class})
public interface MyComponent {
    void injectMainActivity(MainActivity mainActivity);
}
