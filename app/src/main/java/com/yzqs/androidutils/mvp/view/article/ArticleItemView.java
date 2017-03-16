package com.yzqs.androidutils.mvp.view.article;

import com.yzqs.androidutils.data.article.ArticleItemData;
import com.yzqs.baselibrary.view.IBaseView;

/**
 * Created by lixiang on 2017/3/15.
 */

public interface ArticleItemView extends IBaseView {

    void onSuccess(ArticleItemData data);

}
