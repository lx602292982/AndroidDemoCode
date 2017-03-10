package com.yzqs.androidutils.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yzqs.androidutils.R;
import com.yzqs.androidutils.view.backactivity.BackBaseActivity;
import com.zhy.android.percent.support.PercentLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.yzqs.utilslibrary.ImageUtils.drawable2Bitmap;
import static com.yzqs.utilslibrary.ImageUtils.fastBlur;

public class MainActivity extends BackBaseActivity {

    @BindView(R.id.test_image)
    ImageView testImage;
    @BindView(R.id.activity_main)
    PercentLinearLayout activityMain;

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
        Drawable drawable =  getResources().getDrawable(R.mipmap.test);
        Bitmap bitmap = fastBlur(drawable2Bitmap(drawable), 0.1f, 25);
        testImage.setImageBitmap(bitmap);
    }

}
