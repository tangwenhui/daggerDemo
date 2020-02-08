package com.example.daggerdemo.di;

import com.example.daggerdemo.object.HttpOnbject;

import dagger.Module;
import dagger.Provides;

/**
 * 用来提供对象
 */
@Module
public class HttpModule {
    @Provides
    public HttpOnbject providerObject(){
        return new HttpOnbject();
    }
}
