package com.example.neven.randomuserdata.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.neven.randomuserdata.MyApplication;
import com.example.neven.randomuserdata.R;
import com.example.neven.randomuserdata.adapters.UsersAdapter;
import com.example.neven.randomuserdata.dagger.components.AppComponent;
import com.example.neven.randomuserdata.dagger.components.ListComponent;
import com.example.neven.randomuserdata.dagger.modules.ListModule;
import com.example.neven.randomuserdata.models.Result;
import com.example.neven.randomuserdata.presenters.DownloadPresenter;
import com.example.neven.randomuserdata.views.ShowData;

import javax.inject.Inject;
import java.util.List;

public class MainActivity extends BaseActivity implements ShowData {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    @Inject
    DownloadPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ((MyApplication) getApplication()).getAppComponent().injectSubComp(new ListModule(this, this)).inject(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        presenter.downloadData();

        progressBar.setVisibility(View.INVISIBLE);


    }

    @Override
    public void showData(List<Result> listResult) {

        UsersAdapter adapter = new UsersAdapter(listResult, getBaseContext());

        recyclerView.setAdapter(adapter);


    }
}
