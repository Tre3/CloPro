package com.app.kiima.clopro.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.app.kiima.clopro.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Tre3 on 2016/12/11.
 */

public class SearchResultAdapter <T extends String > extends ArrayAdapter<T> {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public SearchResultAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);

        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view = convertView;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.item_search_result, null);

            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.item_search_result_image_view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        String url = getItem(position);
        Glide.with(mContext)
                .load(url)
                .centerCrop()
                .placeholder(R.mipmap.now_loading)
                .crossFade()
                .into(viewHolder.imageView);

        return view;
    }

    private class ViewHolder {
        ImageView imageView;
    }
}
