package com.example.daggerdemo.di;

import com.example.daggerdemo.object.DbOnbject;
import com.example.daggerdemo.object.HttpOnbject;

import dagger.Module;
import dagger.Provides;

/**
 * 用来提供对象
 */
@Module
public class DbModule {
    @Provides
    public DbOnbject providerObject(){
        return new DbOnbject();
    }
}
