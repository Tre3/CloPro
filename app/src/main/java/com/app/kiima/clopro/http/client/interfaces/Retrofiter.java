package com.app.kiima.clopro.http.client.interfaces;

import retrofit2.Retrofit;

/**
 * Http通信で使用するclientが実装するインターフェース
 * <p>
 * Created by Tre3 on 2016/11/27.
 */

public interface Retrofiter {

    Retrofit build();
}
