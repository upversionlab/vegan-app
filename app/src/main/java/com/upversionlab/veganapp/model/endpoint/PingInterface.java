package com.upversionlab.veganapp.model.endpoint;

import com.upversionlab.veganapp.model.Ping;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rborcat on 3/2/2017.
 */

public interface PingInterface {
    @GET("ping/")
    Call<Ping> getPing();
}
