package com.example.netarch.dagger;

import com.example.netarch.MainActivity;
import com.example.netarch.presenter.GirlPresenter;

import dagger.Module;
import dagger.Provides;

// 对GirlPresenter 进行包裹
@Module
public class GirlPresenterModule {

    private MainActivity mView;

    public GirlPresenterModule(MainActivity mView) {
        this.mView = mView;
    }

    @Provides
    public GirlPresenter providerGirlPresenter() {
        return new GirlPresenter(mView);
    }
}
