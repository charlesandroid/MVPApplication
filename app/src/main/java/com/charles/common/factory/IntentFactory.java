package com.charles.common.factory;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;

/**
 * com.charles.common.factory.IntentFactory
 *
 * @author Just.T
 * @since 16/12/27
 */
public class IntentFactory {


    public static final int CAMERA = 0;
    public static final int ALBUM = 1;
    public static final int PHONE = 2;
    public static final int INSTALL = 3;

    /**
     * 图库
     *
     * @return
     */
    public static Intent requestAlbum() {
        return new Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }

    /**
     * 摄像头
     *
     * @return
     */
    public static Intent requestCamera() {
        return new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    }

    /**
     * 打电话
     *
     * @return
     */
    public static Intent requestPhone() {
        return new Intent(Intent.ACTION_CALL);
    }


    /**
     * 安装
     *
     * @param appPath
     * @return
     */
    public static Intent requestInstall(String appPath) {
        return new Intent().setDataAndType(Uri.fromFile(new File(appPath)),
                "application/vnd.android.package-archive");
    }
}
