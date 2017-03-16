package com.yzqs.androidutils.mvp.model;

import com.yzqs.androidutils.data.article.ArticleItemData;

import rx.Observable;

/**
 * Created by lixiang on 2017/3/15.
 */

public interface IArticleItemModel {

    Observable<ArticleItemData> getArticleItemData(int dev);
}
