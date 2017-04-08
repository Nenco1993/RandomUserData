package com.example.neven.randomuserdata.dagger.modules;

import com.example.neven.randomuserdata.activities.MainActivity;
import com.example.neven.randomuserdata.dagger.components.ListComponent;
import com.example.neven.randomuserdata.dagger.scopes.ActivityScope;
import com.example.neven.randomuserdata.presenters.DownloadPresenter;
import com.example.neven.randomuserdata.presenters.DownloadPresenterImpl;
import com.example.neven.randomuserdata.views.ShowData;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Neven on 6.4.2017..
 */
@Module
public class ListModule {

    MainActivity activity;

    ShowData view;


    public ListModule(MainActivity activity, ShowData view) {
        this.activity = activity;
        this.view = view;
    }

    @Provides
    @ActivityScope
    DownloadPresenter provideDownloadPresenter(DownloadPresenterImpl presenter) {

        return presenter;

    }

    @Provides
    @ActivityScope
    ShowData provideView() {

        return view;


    }


}
