package com.charles.common.manager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.charles.common.factory.IntentFactory;

public class BridgeActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivityForResult(TakePhotoManager.bridgeIntent, TakePhotoManager.code);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String imagePath = "";
        switch (requestCode) {
            case IntentFactory.CAMERA:
                if (resultCode == RESULT_OK && data != null) {
                    Uri uri = data.getData();
                    imagePath = CompressPicUtils.getImageAbsolutePath(this,
                            uri);
                }
                break;
            case IntentFactory.ALBUM:
                if (resultCode == RESULT_OK && data != null) {
                    Uri uri = data.getData();
                    imagePath = CompressPicUtils.getImageAbsolutePath(this,
                            uri);
                }
                break;
        }
        TakePhotoManager.onResult.onResult(imagePath);
        finish();
    }
}
