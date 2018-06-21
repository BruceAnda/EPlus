package com.bawei.eplus.net;

import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络工具类
 * 需求：
 * 1. 封装HTTPURLConnection
 * 2. AsyncTask 执行后台请求网络的任务
 * 3. 封装回调把数据传出来
 * 4. 对外部暴露一个可以调用的方法
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/6/21
 */
public class HttpUtils {

    private static final HttpUtils ourInstance = new HttpUtils();

    public static HttpUtils getInstance() {
        return ourInstance;
    }

    private HttpUtils() {
    }

    public void get(String url) {
        new LoadTask().execute(url);
    }

    class LoadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            // 使用HttpUrlConnection请求网络
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    // 响应成功
                    return inputStream2String(connection.getInputStream());
                }
            } catch (Exception e) {
                e.printStackTrace();
                callback.onError(e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s == null) {
                callback.onError("网络出错啦。。。");
            } else {
                callback.onSuccess(s);
            }
        }
    }

    /**
     * 转换InputStream到字符串
     *
     * @param inputStream
     * @return
     */
    private String inputStream2String(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int len = -1;
        byte[] b = new byte[1024];
        while ((len = inputStream.read(b)) != -1) {
            outputStream.write(b, 0, len);
        }
        return new String(outputStream.toByteArray());
    }

    private NetCallback callback;

    public void setCallback(NetCallback callback) {
        this.callback = callback;
    }

    /**
     * 处理网络响应结果的接口
     */
    public interface NetCallback {

        /**
         * 响应成功
         *
         * @param s
         */
        void onSuccess(String s);

        /**
         * 响应错误
         *
         * @param errorMsg
         */
        void onError(String errorMsg);
    }
}
