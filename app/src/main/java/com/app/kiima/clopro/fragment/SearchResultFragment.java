package com.app.kiima.clopro.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.kiima.clopro.R;
import com.app.kiima.clopro.constants.Constants;
import com.app.kiima.clopro.http.FlickrImageSearchService;
import com.app.kiima.clopro.http.client.CloProClient;
import com.app.kiima.clopro.http.model.ImageSearch;
import com.app.kiima.clopro.http.query.ImageSearchQuery;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Tre3 on 2016/12/10.
 */

public class SearchResultFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_result, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        if ((bundle == null) || TextUtils.isEmpty(bundle.getString(Constants.BUNDLE_KEY_SEARCH_WORD))) {
            return;
        }

        String searchWord = bundle.getString(Constants.BUNDLE_KEY_SEARCH_WORD);
        searchImages(searchWord);
    }

    private void searchImages(String searchWord) {
        CloProClient cloProClient = new CloProClient();
        Retrofit retrofit = cloProClient.build();

        FlickrImageSearchService service = retrofit.create(FlickrImageSearchService.class);

        ImageSearchQuery imageSearchQuery = new ImageSearchQuery();
        Map<String, String> query = imageSearchQuery.getQuery(searchWord);

        Call<ImageSearch> response = service.search(query);

        response.enqueue(new Callback<ImageSearch>() {
            @Override
            public void onResponse(Call<ImageSearch> call, Response<ImageSearch> response) {
                Log.d("test1", "success");
                Log.d("test1", response.body().getPhotos().getPhoto().get(0).getId() + "");
            }

            @Override
            public void onFailure(Call<ImageSearch> call, Throwable t) {
                Log.d("test1", "faile");
            }
        });
    }
}
