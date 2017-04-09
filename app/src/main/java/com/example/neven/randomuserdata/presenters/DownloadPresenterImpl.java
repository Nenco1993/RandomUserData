package com.example.neven.randomuserdata.presenters;

import android.util.Log;
import com.example.neven.randomuserdata.adapters.ChildItem;
import com.example.neven.randomuserdata.adapters.HeaderItem;
import com.example.neven.randomuserdata.adapters.Item;
import com.example.neven.randomuserdata.models.Result;
import com.example.neven.randomuserdata.models.Users;
import com.example.neven.randomuserdata.network.RestAPI;
import com.example.neven.randomuserdata.views.ShowData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neven on 6.4.2017..
 */
public class DownloadPresenterImpl implements DownloadPresenter {

    @Inject
    Retrofit retrofit;

    @Inject
    ShowData view;

    private List<Result> listResult;

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

                listResult = response.body().getResults();

                view.showData(addDataToList());


            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

                t.printStackTrace();


            }
        });


    }

    private List<Item> addDataToList() {

        List<Item> listItems = new ArrayList<Item>();

        listItems.add(new HeaderItem("MALES"));

        for (Result singleResult : listResult) {

            String gender = singleResult.getGender();

            if (gender.equalsIgnoreCase("male")) {

                listItems.add(new ChildItem(singleResult.getPicture().getLarge()));


            }


        }

        listItems.add(new HeaderItem("FEMALES"));

        for (Result singleResult : listResult) {

            String gender = singleResult.getGender();

            if (gender.equalsIgnoreCase("female")) {

                listItems.add(new ChildItem(singleResult.getPicture().getLarge()));


            }


        }


        return listItems;


    }


}
