package com.upversionlab.veganapp.requester;

import com.upversionlab.veganapp.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rborcat on 3/7/2017.
 */
abstract class BaseRequester<Service> {

    private static final String VEGAN_SERVER = BuildConfig.BASE_URL;

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
