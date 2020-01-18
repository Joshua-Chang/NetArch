package com.example.netarch.presenter;

import android.util.Log;

import com.example.core.network.rx.databus.RegisterRxBus;
import com.example.netarch.bean.Girl;
import com.example.netarch.task.GirlTaskImpl;
import com.example.netarch.task.IGirlTask;
import com.example.netarch.view.IGirlView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class GirlPresenter<T extends IGirlView> { // T == IGirlView 或者 IGirlView 子类

    // View层的定义
    private WeakReference<T> mView;

    // Task层的定义
    private IGirlTask iGirlTask;

    public GirlPresenter(T mView) {
        this.mView = new WeakReference<>(mView);

        iGirlTask = new GirlTaskImpl();
        iGirlTask.loadGirlData(); // 加载数据
    }

    @RegisterRxBus
    public void showGirlDataAction(ArrayList<Girl> arrayList) {
        // 还需要做很多的事情逻辑
        // ...

        // 把结果给View
        mView.get().showGirlData(arrayList);
        Log.e(">>>","111");
    }
    @RegisterRxBus
    public void showGirlDataAction1(ArrayList<Girl> arrayList) {
        // 还需要做很多的事情逻辑
        // ...

        // 把结果给View
//        mView.get().showGirlData(arrayList);
        Log.e(">>>","222");
    }
}
