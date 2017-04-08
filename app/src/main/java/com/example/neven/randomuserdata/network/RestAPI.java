package com.example.neven.randomuserdata.network;

import com.example.neven.randomuserdata.models.Users;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Neven on 6.4.2017..
 */
public interface RestAPI {

    @GET("?format=pretty&results=100&inc=gender,email,nat,picture")
    Call<Users>getUsers();


}
