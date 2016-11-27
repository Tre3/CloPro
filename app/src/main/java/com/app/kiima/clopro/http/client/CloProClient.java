package com.app.kiima.clopro.http.client;

import com.app.kiima.clopro.http.client.interfaces.Retrofiter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * CloProのHttpClient
 * <p>
 * Created by Tre3 on 2016/11/27.
 */

public class CloProClient implements Retrofiter {
    private static final String BASE_FLICKR_API_URL = "https://api.flickr.com";

    @Override
    public Retrofit build() {
        return new Retrofit.Builder()
                .baseUrl(BASE_FLICKR_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
