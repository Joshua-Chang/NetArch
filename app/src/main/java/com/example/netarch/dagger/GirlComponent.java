package com.example.netarch.dagger;

import com.example.netarch.MainActivity;

import dagger.Component;

@Component(modules = GirlPresenterModule.class)
public interface GirlComponent { // 注入对象 ---》 MainActivity

    void inject(MainActivity mainActivity); // 注入动作

}
