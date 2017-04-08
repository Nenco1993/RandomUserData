package com.example.neven.randomuserdata.dagger.modules;

import android.content.Context;
import com.example.neven.randomuserdata.MyApplication;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

/**
 * Created by Neven on 6.4.2017..
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit;


    }


}
