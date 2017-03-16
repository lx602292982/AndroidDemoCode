package com.yzqs.androidutils.api;


import com.yzqs.androidutils.data.article.ArticleItemData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lixiang on 2017/3/15.
 */

public interface ArticleService {

    String BASE_URL = "https://interface.meiriyiwen.com";


    /**
     * 每日一文
     * @param dev
     * @return
     */
    @GET("/article/today")
    Observable<ArticleItemData> getArticleData(@Query("dev") int dev);

}
