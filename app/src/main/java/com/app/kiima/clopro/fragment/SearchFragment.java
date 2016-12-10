package com.app.kiima.clopro.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.app.kiima.clopro.R;
import com.app.kiima.clopro.constants.Constants;

/**
 * Created by Tre3 on 2016/12/04.
 */

public class SearchFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initEditText();
    }

    private void initEditText() {
        View view = getView();
        if (view == null) {
            return;
        }

        EditText editText = (EditText) view.findViewById(R.id.search_edit_text);
        editText.setOnEditorActionListener(onEditorActionListener);
    }

    private TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch(textView.getText().toString());

                return true;
            }
            return false;
        }
    };

    private void performSearch(String string) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        SearchResultFragment searchResultFragment = new SearchResultFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.BUNDLE_KEY_SEARCH_WORD, string);
        searchResultFragment.setArguments(bundle);
        fragmentManager.beginTransaction().add(R.id.content_main_fragment_container_frame_layout, searchResultFragment).commit();
    }
}
