package com.charles.common.manager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateFormat;

import com.charles.common.factory.IntentFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

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
        if (requestCode == IntentFactory.CAMERA) {
            if (resultCode == RESULT_OK && data != null) {
                Bundle bundle = data.getExtras();
                if (!data.hasExtra("data")) return;
                Bitmap bitmap = (Bitmap) bundle.get("data");
                String name = DateFormat.format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
                FileOutputStream b = null;
                imagePath = getFilesDir().getPath() + File.separator + "photo_cache" + File.separator + name;
                File file = null;
                try {
                    file = new File(imagePath);
                    if (!file.getParentFile().exists()) file.getParentFile().mkdir();
                    b = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
                } catch (IOException e) {
                    e.printStackTrace();
                    imagePath = "";
                } finally {
                    try {
                        b.flush();
                        b.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (requestCode == IntentFactory.ALBUM) {
            if (resultCode == RESULT_OK && data != null) {
                Uri uri = data.getData();
                imagePath = CompressPicUtils.getImageAbsolutePath(this,
                        uri);
            }
        }
        TakePhotoManager.onResult.onResult(imagePath);
        TakePhotoManager.onResult = null;
        TakePhotoManager.bridgeIntent = null;
        finish();
    }
}
