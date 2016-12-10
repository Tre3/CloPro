package com.app.kiima.clopro.util.url.contracts;

import com.app.kiima.clopro.http.model.Photo;

/**
 * Created by Tre3 on 2016/12/10.
 */

public interface UrlBuilderContract {

    String createImageUrl(Photo photo);
}
