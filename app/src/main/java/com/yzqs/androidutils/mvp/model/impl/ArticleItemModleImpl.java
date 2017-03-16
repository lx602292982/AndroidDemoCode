package com.yzqs.androidutils.mvp.model.impl;

import com.yzqs.androidutils.api.ArticleService;
import com.yzqs.androidutils.data.article.ArticleItemData;
import com.yzqs.androidutils.mvp.model.IArticleItemModel;
import com.yzqs.androidutils.net.NetManager;

import rx.Observable;

/**
 * Created by lixiang on 2017/3/15.
 */

public class ArticleItemModleImpl implements IArticleItemModel {
    @Override
    public Observable<ArticleItemData> getArticleItemData(int dev) {
        ArticleService service = NetManager.getInstance().create(ArticleService.class);
        return service.getArticleData(dev);
    }
}
