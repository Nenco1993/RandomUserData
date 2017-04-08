package com.example.neven.randomuserdata.dagger.components;

import com.example.neven.randomuserdata.activities.BaseActivity;
import com.example.neven.randomuserdata.dagger.modules.ListModule;
import com.example.neven.randomuserdata.dagger.modules.NetworkModule;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by Neven on 6.4.2017..
 */

@Component(modules = {NetworkModule.class})
@Singleton
public interface AppComponent {


    ListComponent injectSubComp(ListModule module);


    void inject(BaseActivity activity);


}
