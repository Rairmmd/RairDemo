package com.rair.encrptdemo.utils;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * DES-Data Encryption Standard,即数据加密算法
 *
 * @author jerry
 */
public class DESUtil {
    private static final String ALGORITHM = "DES";

    /**
     * 生成Key，一般最后进行Base64编码
     *
     * @param seed
     * @return
     */
    private static String initKey(String seed) {
        SecureRandom secureRandom = null;
        if (seed != null) {
            secureRandom = new SecureRandom(seed.getBytes());
        } else {
            secureRandom = new SecureRandom();
        }
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(secureRandom);
            SecretKey key = keyGenerator.generateKey();
            byte[] keyBytes = key.getEncoded();
            return Base64.encodeToString(keyBytes, Base64.NO_WRAP);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * DES加密
     *
     * @param src
     * @return
     * @throws Exception
     */
    public static String encrypt(String src, String keyString) throws Exception {
        // Base64编码 key - 转换为SecretKey对象
        Key key = getKey(keyString);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 设置模式 - 加密
        //Cipher.ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] finalByte = cipher.doFinal(src.getBytes("utf-8"));
        return Base64.encodeToString(finalByte, Base64.NO_WRAP);
    }

    /**
     * DES解密
     *
     * @param encodeString
     * @param keyString
     * @return
     * @throws Exception
     */
    public static String decrypyt(String encodeString, String keyString) throws Exception {
        // Base64编码 key - 转换为SecretKey对象
        Key key = getKey(keyString);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 设置模式 - 解密
        //Cipher.DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] destBytes = Base64.decode(encodeString, Base64.NO_WRAP);

        byte[] finalByte = cipher.doFinal(destBytes);

        return new String(finalByte, "utf-8");

    }

    /**
     * Base64编码 key - 转换为SecretKey对象
     *
     * @param keyString
     * @return
     * @throws UnsupportedEncodingException
     * @throws Exception
     */
    public static Key getKey(String keyString) throws Exception {
        // 解码的字符
        String decodeString = new String(Base64.decode(keyString, Base64.NO_WRAP), "utf-8");
        DESKeySpec spec = new DESKeySpec(decodeString.getBytes("utf-8"));
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        return factory.generateSecret(spec);
    }

}
