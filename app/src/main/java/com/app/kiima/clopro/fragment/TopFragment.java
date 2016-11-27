package com.app.kiima.clopro.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.kiima.clopro.R;
import com.app.kiima.clopro.http.FlickrImageSearchService;
import com.app.kiima.clopro.http.model.ImageSearch;
import com.app.kiima.clopro.sample.SampleAdapter;
import com.app.kiima.clopro.sample.SampleData;
import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * トップ画面
 *
 * Created by Tre3 on 2016/03/02.
 */
public class TopFragment extends Fragment {

    private StaggeredGridView mGridView;
    private SampleAdapter mAdapter;
    private ArrayList<String> mData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mGridView = (StaggeredGridView) getView().findViewById(R.id.fragment_top_grid_view);

        if (savedInstanceState == null) {
            final LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        }

        if (mAdapter == null) {
            mAdapter = new SampleAdapter(getActivity(), R.id.txt_line1);
        }

        if (mData == null) {
            mData = SampleData.generateSampleData();
        }

        for (String data : mData) {
            mAdapter.add(data);
        }

        mGridView.setAdapter(mAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.flickr.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FlickrImageSearchService service = retrofit.create(FlickrImageSearchService.class);

        Map<String, String> query = new HashMap<>();
        query.put("method", "flickr.photos.search");
        query.put("api_key", "4ba3dd55a1862ea55f0fa7c5a8fdb616");
        query.put("sort", "relevance");
        query.put("privacy_filter", "1");
        query.put("content_type", "1");
        query.put("per_page", "1");
        query.put("format", "json");
        query.put("nojsoncallback", "1");
        query.put("text", "cat");
        Call<ImageSearch> response1 = service.search(query);

        response1.enqueue(new Callback<ImageSearch>() {
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
