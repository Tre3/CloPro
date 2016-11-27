package com.app.kiima.clopro.http;

import com.app.kiima.clopro.http.model.ImageSearch;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Http service for Flickr
 *
 * Created by Tre3 on 2016/11/27.
 */

public interface FlickrImageSearchService {
    @GET("/services/rest/")
    Call<ImageSearch> search(@QueryMap Map<String, String> options);
}