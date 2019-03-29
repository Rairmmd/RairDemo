package com.rair.encrpt.utils;

import android.util.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Base64Util {

    /**
     * base64加密算法 把字符转换为 - base64的字符
     *
     * @param src
     * @return
     */
    public static String encode(String src) {
        if (src == null) {
            return null;
        }
        try {
            return Base64.encodeToString(src.getBytes("utf-8"), Base64.NO_WRAP);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * base64加密算法 把字节转换为 - base64的字符
     *
     * @param src
     * @return
     */
    public static String encode(byte[] src) {
        if (src == null) {
            return null;
        }
        return Base64.encodeToString(src, Base64.NO_WRAP);
    }

    /**
     * Base64解码
     * 把编码的字符进行解码成明文
     *
     * @param dest
     */
    public static String decode(String dest) {
        if (dest == null) {
            return null;
        }
        try {
            byte[] buffer = Base64.decode(dest, Base64.NO_WRAP);
            return new String(buffer, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Base64解码
     *
     * @param dest
     */
    public static byte[] decodeToBytes(String dest) {
        if (dest == null) {
            return null;
        }
        byte[] buffer = Base64.decode(dest, Base64.NO_WRAP);
        return buffer;
    }

    /**
     * Base64解码
     * 把编码的字符进行解码成明文
     */
    public static String decode(byte[] destBytes) {
        if (destBytes == null) {
            return null;
        }
        try {
            byte[] buffer = Base64.decode(new String(destBytes, "utf-8"), Base64.NO_WRAP);
            return new String(buffer, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
