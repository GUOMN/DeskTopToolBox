package com.guomn.desktopToolbox.utils;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * http工具类
 */
public class HttpClint {

    /**
     * GET方式获取字符串
     * @return  返回字符串
     * @throws Exception
     */
    public static String getGETString(String urlStr) throws Exception{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(50000);
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        if (conn.getResponseCode() == 200) {
            InputStream inputStream = conn.getInputStream();
            byte[] data = read(inputStream);
            return new String(data);
        }
        return null;
    }
    /**
     * 以GET方式发送字符串
     * @param params 要发送的数组
     * @param encoding  发送的编码
     * @return  String 结果
     * @throws Exception
     */
    public static String  sendGETString(String urlStr, HashMap<String,String> params,String encoding) throws Exception{
        StringBuilder url = new StringBuilder(urlStr);
        url.append("?");
        for (Map.Entry<String,String> entry: params.entrySet()) {
            url.append(entry.getKey()).append("=");
            url.append(URLEncoder.encode(entry.getValue(), encoding));
            url.append("&");
        }
        url.deleteCharAt(url.length()-1);
        HttpURLConnection conn = (HttpURLConnection) new URL(url.toString()).openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() == 200) {
            InputStream inputStream = conn.getInputStream();
            byte[] data = read(inputStream);
            return new String(data);
        }
        return "";
    }

    /**
     * POST方式获取字符串
     * @return  返回字符串
     * @throws Exception
     */
    public static String getPOSTString(String urlStr) throws Exception{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Proxy-Connection", "Keep-Alive");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        if (conn.getResponseCode() == 200) {
            InputStream inputStream = conn.getInputStream();
            byte[] data = read(inputStream);
            return new String(data);
        }
        return null;
    }
    /**
     * 以POST方式发送字符串
     * @param params 要发送的数组
     * @param encoding  发送的编码
     * @return  true返回成功，false返回失败
     * @throws Exception
     */
    public static boolean  sendPOSTString(String urlStr, HashMap<String,String> params,String encoding) throws Exception{
        StringBuilder data = new StringBuilder();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String,String> entry: params.entrySet()) {
                data.append(entry.getKey()).append("=");
                data.append(URLEncoder.encode(entry.getValue(), encoding));
                data.append("&");
            }
            data.deleteCharAt(data.length()-1);
        }
        byte[] entity = data.toString().getBytes();//得到实体数据
        HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);//允许对外输出数据
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(entity.length));
        OutputStream oStream = conn.getOutputStream();
        oStream.write(entity);
        if(conn.getResponseCode() == 200){//用于获得返回数据才能发送数据，不然数据一直在缓存数据中
            return true;
        }
        return false;
    }

    /**
     * 解析响应
     * @param stream
     * @return
     * @throws Exception
     */

    public static byte[] read(InputStream stream) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len=stream.read(buffer)) != -1){
            outputStream.write(buffer, 0, len);
        }
        return outputStream.toByteArray();
    }
}
