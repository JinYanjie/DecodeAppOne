package com.example.myapplication2;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * author :shengsheng
 * date :2019/9/17
 * i despised my soul when i committed a wrong,and comforted myself that others also commit wrong.
 */
public class Md5Util {

    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 处理加密结果
     *
     * @param bytes
     * @return
     */
    public static String b(byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(a[(b >> 4) & 15]);
            hex.append(a[b & 15]);
        }
        return hex.toString();
    }

    /**
     * 将处理好的字符串进行加密，返回对 加密结果的处理
     * @param string
     * @return
     */
    public static String a(String string) {
        try {
            return b(MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException neverHappened) {
            throw new RuntimeException(neverHappened);
        } catch (UnsupportedEncodingException neverHappened2) {
            throw new RuntimeException(neverHappened2);
        }
    }
}
