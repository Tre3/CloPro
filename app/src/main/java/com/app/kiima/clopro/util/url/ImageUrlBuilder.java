package com.app.kiima.clopro.util.url;

import android.net.Uri;

import com.app.kiima.clopro.http.model.Photo;
import com.app.kiima.clopro.util.url.contracts.UrlBuilderContract;

/**
 * Created by Tre3 on 2016/12/10.
 */

public class ImageUrlBuilder implements UrlBuilderContract {
    private static final String BASE_IMAGE_URL = "https://farm4.staticflickr.com/";

    @Override
    public String createImageUrl(Photo photo) {
        if (photo == null) {
            return BASE_IMAGE_URL;
        }

        Uri baseUri = Uri.parse(BASE_IMAGE_URL);
        Uri uri = Uri.withAppendedPath(baseUri, createImagePath(photo));

        return uri.toString();
    }

    private String createImagePath(Photo photo) {
        if (photo == null) {
            return "";
        }

        String server = photo.getServer();
        String id = photo.getId();
        String secret = photo.getSecret();

        return "/" + server + "/" + id + "_" + secret + ".jpg";
    }
}
