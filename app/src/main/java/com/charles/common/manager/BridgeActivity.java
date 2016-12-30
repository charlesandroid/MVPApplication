package com.charles.common.manager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

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
        if (resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            imagePath = CompressPicUtils.getImageAbsolutePath(this,
                    uri);
        }
        TakePhotoManager.onResult.onResult(imagePath);
        TakePhotoManager.onResult = null;
        TakePhotoManager.bridgeIntent = null;
        finish();
    }
}
