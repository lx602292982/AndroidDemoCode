package com.yzqs.androidutils.ui;

import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;
import android.widget.Toast;

import com.yzqs.androidutils.R;
import com.yzqs.androidutils.data.article.ArticleItemData;
import com.yzqs.androidutils.mvp.BaseMvpActivity;
import com.yzqs.androidutils.mvp.presenter.article.ArtitcleItemPresenter;
import com.yzqs.androidutils.mvp.view.article.ArticleItemView;
import com.yzqs.androidutils.view.weiget.LoadingDialog;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseMvpActivity<ArticleItemView, ArtitcleItemPresenter> implements ArticleItemView {

    LoadingDialog dialog;
    @BindView(R.id.test)
    TextView test;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.author)
    TextView author;

    @Override
    public void setToolBar(Toolbar bar) {
        setCenterTextView(R.string.app_name);
    }

    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        ButterKnife.bind(mContext);
        dialog = new LoadingDialog(mContext);
    }

    @Override
    protected ArtitcleItemPresenter initPresenter() {
        return new ArtitcleItemPresenter();
    }

    @Override
    protected void fetchData() {
        mPresenter.getArtitcleData(1);
        dialog.show();
    }

    @Override
    public void onSuccess(ArticleItemData data) {
        dialog.dismiss();
        title.setText(data.getData().getTitle());
        author.setText(data.getData().getAuthor()+"\n");
        test.setText(Html.fromHtml(data.getData().getContent()));
    }

    @Override
    public void onError(String error) {
        dialog.dismiss();
        Toast.makeText(mContext, "error"+error, Toast.LENGTH_SHORT).show();
    }
}
