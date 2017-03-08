package com.upversionlab.veganapp.requester;

import com.upversionlab.veganapp.model.Ping;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by rborcat on 3/7/2017.
 */
public class PingRequester extends BaseRequester<PingRequester.Service> {

    @Override
    protected Service createService(Retrofit retrofit) {
        return retrofit.create(Service.class);
    }

    public void getPing(Callback<Ping> callback) {
        Call<Ping> call = service.getPing();
        call.enqueue(callback);
    }

    interface Service {
        @GET("ping/")
        Call<Ping> getPing();
    }

}
