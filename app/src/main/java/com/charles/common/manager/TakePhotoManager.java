package com.charles.common.manager;

import android.app.Activity;
import android.content.Intent;

import com.charles.common.factory.IntentFactory;

import java.io.Serializable;

/**
 * com.charles.common.manager.TakePhotoManager
 *
 * @author Just.T
 * @since 16/12/30
 */
public class TakePhotoManager {

    private Intent intent;
    public static OnResult onResult;
    public static Intent bridgeIntent;
    public static int code;

    private static class Holder {
        private static TakePhotoManager instance = new TakePhotoManager();
    }

    public static TakePhotoManager getInstance() {
        return Holder.instance;
    }

    private TakePhotoManager() {
    }

    public void openCamera(Activity activity, OnResult onResult) {
        code = IntentFactory.CAMERA;
        bridgeIntent = IntentFactory.requestCamera();
        TakePhotoManager.onResult = onResult;
        intent = new Intent(activity, BridgeActivity.class);
        activity.startActivity(intent);
    }

    public void openAlbum(Activity activity, OnResult onResult) {
        code = IntentFactory.ALBUM;
        bridgeIntent = IntentFactory.requestAlbum();
        TakePhotoManager.onResult = onResult;
        intent = new Intent(activity, BridgeActivity.class);
        activity.startActivity(intent);
    }


    public interface OnResult extends Serializable {
        void onResult(String path);
    }


}