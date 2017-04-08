package com.example.neven.randomuserdata.dagger.components;

import com.example.neven.randomuserdata.activities.MainActivity;
import com.example.neven.randomuserdata.dagger.modules.ListModule;
import com.example.neven.randomuserdata.dagger.scopes.ActivityScope;
import dagger.Subcomponent;

/**
 * Created by Neven on 6.4.2017..
 */
@ActivityScope
@Subcomponent(modules = {ListModule.class})
public interface ListComponent {

    void inject(MainActivity activity);


}
