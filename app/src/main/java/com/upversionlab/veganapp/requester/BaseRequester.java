package com.upversionlab.veganapp.requester;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rborcat on 3/7/2017.
 */
abstract class BaseRequester<Service> {

    // Borcat's IP
    private static final String VEGAN_SERVER = "http://192.168.0.5:8080/";

    final Service service;

    BaseRequester() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(VEGAN_SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = createService(retrofit);
    }

    protected abstract Service createService(Retrofit retrofit);
}
