package com.charles.common.network;

import com.charles.common.factory.HttpClientFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;

/**
 * com.charles.common.network.HttpDownloadHelper
 * 下载工具
 *
 * @author Just.T
 * @since 16/12/28
 */
public class DownloadHelper {

    private DownloadHelper() {
    }

    private static class Holder {
        private static final DownloadHelper helper = new DownloadHelper();
    }

    public static DownloadHelper getInstance() {
        return Holder.helper;
    }

    /**
     * 只下载  不考虑成功失败
     *
     * @param url
     * @param filePath
     */
    public void download(String url, String filePath) {
        download(url, filePath, null);
    }

    /**
     * 下载  只关心结果成功失败  不关心下载进度
     *
     * @param url
     * @param filePath
     * @param listener
     */
    public void download(String url, String filePath, DownloadListener listener) {
        download(url, filePath, null, listener);
    }


    /**
     * 这方法可操心大了  又有下载进度  又有最终写入本地成功失败结果
     *
     * @param url
     * @param filePath
     * @param listener
     * @param downloadListener
     */
    public void download(String url, String filePath, ProgressInterceptor.ProgressListener listener, DownloadListener downloadListener) {
        OkHttpClient client = listener == null ? HttpClientFactory.defaultClient() : HttpClientFactory.downloadClient(listener);
        RetrofitUtil.getInstance().createService(client, BaseHttpService.class)
                .downloadFile(url)
                .flatMap(responseBody -> convertFile(responseBody, filePath))
                .compose(TransformUtils.defaultSchedulers())
                .subscribe(new Subscriber<File>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (downloadListener != null)
                            downloadListener.onDownload(-1);
                    }

                    @Override
                    public void onNext(File file) {
                        if (downloadListener != null && file != null)
                            downloadListener.onDownload(0);
                    }
                });

    }

    interface DownloadListener {
        void onDownload(int code);
    }

    private Observable<File> convertFile(ResponseBody body, String absFileName) {
        File file = null;
        try {
            // todo change the file location/name according to your needs
            file = new File(absFileName);
            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(file);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }
                    outputStream.write(fileReader, 0, read);
                }
                outputStream.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Observable.just(file);
    }


}
