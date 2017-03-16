package com.yzqs.androidutils.mvp.presenter.article;

import com.yzqs.androidutils.data.article.ArticleItemData;
import com.yzqs.androidutils.mvp.model.IArticleItemModel;
import com.yzqs.androidutils.mvp.model.impl.ArticleItemModleImpl;
import com.yzqs.androidutils.mvp.presenter.BasePresenter;
import com.yzqs.androidutils.mvp.view.article.ArticleItemView;
import com.yzqs.androidutils.rx.RxManager;
import com.yzqs.androidutils.rx.RxSubscriber;

/**
 * Created by lixiang on 2017/3/15.
 */

public class ArtitcleItemPresenter extends BasePresenter<ArticleItemView> {

    public IArticleItemModel mModel;

    public ArtitcleItemPresenter() {
        mModel = new ArticleItemModleImpl();
    }

    public void getArtitcleData(int dev) {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getArticleItemData(dev), new RxSubscriber<ArticleItemData>() {

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            protected void _onNext(ArticleItemData articleItemData) {
                mView.onSuccess(articleItemData);
            }

            @Override
            protected void _onError(String s) {
                mView.onError(s);
            }
        });
    }
}
