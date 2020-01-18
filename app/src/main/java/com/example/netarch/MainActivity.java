package com.example.netarch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.core.network.rx.databus.RxBus;
import com.example.netarch.adapter.GirlAdapter;
import com.example.netarch.bean.Girl;
import com.example.netarch.dagger.DaggerGirlComponent;
import com.example.netarch.dagger.GirlPresenterModule;
import com.example.netarch.presenter.GirlPresenter;
import com.example.netarch.view.IGirlView;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IGirlView {
    private ListView listView;

    @Inject
    GirlPresenter girlPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv);

        // 简写
        // DaggerGirlComponent.builder().build().inject(this);
        // DaggerGirlComponent.create().inject(this);

        DaggerGirlComponent.builder().
                girlPresenterModule(new GirlPresenterModule(this)).
                build().inject(this);

        // girlPresenter == 有值

        // 注册总线
        RxBus.getInstance().register(girlPresenter); // 目标对象 +1
    }

    @Override
    public void showGirlData(List<Girl> girls) {
        listView.setAdapter(new GirlAdapter(this, girls));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 移除总线
        RxBus.getInstance().unRegister(girlPresenter);
    }
}
