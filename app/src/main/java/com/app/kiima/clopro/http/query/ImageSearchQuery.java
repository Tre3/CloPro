package com.app.kiima.clopro.http.query;

import java.util.HashMap;
import java.util.Map;

/**
 * Flickr image search query
 * <p>
 * Created by Tre3 on 2016/11/27.
 */

public class ImageSearchQuery {

    public Map<String, String> getQuery(String searchWord) {
        Map<String, String> query = new HashMap<>();
        query.put("method", "flickr.photos.search");
        query.put("api_key", "4ba3dd55a1862ea55f0fa7c5a8fdb616");
        query.put("sort", "relevance");
        query.put("privacy_filter", "1");
        query.put("content_type", "1");
        query.put("per_page", "10");
        query.put("format", "json");
        query.put("nojsoncallback", "1");
        query.put("text", searchWord);

        return query;
    }
}
