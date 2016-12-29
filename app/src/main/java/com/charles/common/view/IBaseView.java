package com.charles.common.view;

import android.app.Dialog;

/**
 * com.charles.common.view.IBaseView
 *
 * @author Just.T
 * @since 16/12/27
 */
public interface IBaseView {
    void showDialog(Dialog dialog);

    void showToast(String str);

    void hideDialog(Dialog dialog);

}
