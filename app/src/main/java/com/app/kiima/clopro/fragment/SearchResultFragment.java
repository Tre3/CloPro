package com.app.kiima.clopro.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.kiima.clopro.R;
import com.app.kiima.clopro.constants.Constants;

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

    }
}
