package com.yzqs.androidutils.rx;

import android.widget.Toast;

import java.io.IOException;

import rx.Subscriber;

import static com.yzqs.androidutils.AppApplication.mContext;

/**
 * Author: Othershe
 * Time:  2016/8/11 17:45
 */
public abstract class RxSubscriber<T> extends Subscriber<T> {

    public RxSubscriber() {
    }

    @Override
    public void onCompleted() {
        cancelLoading();
    }

    @Override
    public void onError(Throwable e) {
        //统一处理请求异常的情况
        if (e instanceof IOException) {
            Toast.makeText(mContext, "网络链接异常...", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        _onError(e.getMessage());

        cancelLoading();
    }

    @Override
    public void onNext(T t) {
        cancelLoading();
        _onNext(t);
    }

    @Override
    public void onStart() {
        super.onStart();
        showLoading();
    }

    /**
     * 可在此处统一显示loading view
     */
    private void showLoading() {
    }

    private void cancelLoading() {
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String s);

}
