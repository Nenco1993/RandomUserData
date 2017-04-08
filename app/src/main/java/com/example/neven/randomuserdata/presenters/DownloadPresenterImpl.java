package com.example.neven.randomuserdata.presenters;

import android.util.Log;
import com.example.neven.randomuserdata.models.Result;
import com.example.neven.randomuserdata.models.Users;
import com.example.neven.randomuserdata.network.RestAPI;
import com.example.neven.randomuserdata.views.ShowData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Neven on 6.4.2017..
 */
public class DownloadPresenterImpl implements DownloadPresenter {

    @Inject
    Retrofit retrofit;

    @Inject
    ShowData view;

    @Inject
    public DownloadPresenterImpl(Retrofit retrofit, ShowData view) {
        this.retrofit = retrofit;
        this.view = view;
    }

    @Override
    public void downloadData() {

        RestAPI api = retrofit.create(RestAPI.class);
        Call<Users> call = api.getUsers();
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {

                List<Result> list = response.body().getResults();
                view.showData(list);


            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

                t.printStackTrace();


            }
        });


    }


}
