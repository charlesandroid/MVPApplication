package com.charles.common.presenter;

/**
 * com.charles.common.presenter.BasePresenter
 *
 * @author Just.T
 * @since 16/12/27
 */
public interface BasePresenter {
    boolean checkActivityState();

    boolean isMainThread();

    void sendMessage(Object event);
}
