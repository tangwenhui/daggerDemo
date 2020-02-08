package com.example.daggerdemo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.daggerdemo.di.DaggerMyComponent;
import com.example.daggerdemo.object.DbOnbject;
import com.example.daggerdemo.object.HttpOnbject;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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

        Log.d("tangwh", httpOnbject.hashCode() + "");
        Log.d("tangwh", dbOnbject.hashCode() + "");


        Observable<List<Repo>> observable = MovieRetrofit.getInstance().getApi().listRepos("tangwenhui");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Repo>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(List<Repo> repos) {
                        for (Repo repo : repos) {
                            Log.d("tangwh","name = "+repo.getFull_name());
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


}
