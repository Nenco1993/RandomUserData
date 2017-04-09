package com.example.neven.randomuserdata.activities;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.neven.randomuserdata.MyApplication;
import com.example.neven.randomuserdata.R;
import com.example.neven.randomuserdata.adapters.Item;
import com.example.neven.randomuserdata.adapters.UsersAdapter;
import com.example.neven.randomuserdata.dagger.modules.ListModule;
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

    private UsersAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ((MyApplication) getApplication()).getAppComponent().newListSubComponent(new ListModule(this, this)).inject(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getBaseContext(), 2);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.isHeaderType(position) ? 2 : 1;
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        presenter.downloadData();


    }

    @Override
    public void showData(List<Item> listItems) {


        adapter = new UsersAdapter(listItems, getBaseContext());

        recyclerView.setAdapter(adapter);

        progressBar.setVisibility(View.INVISIBLE);


    }
}
