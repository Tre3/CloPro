package com.app.kiima.clopro.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.kiima.clopro.R;
import com.app.kiima.clopro.sample.SampleAdapter;
import com.app.kiima.clopro.sample.SampleData;
import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;

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
    }
}
