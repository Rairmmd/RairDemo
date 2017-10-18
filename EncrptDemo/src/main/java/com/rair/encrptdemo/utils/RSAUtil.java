package com.rair.encrptdemo.utils;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

/**
 * RSA安全编码组件
 *
 * @author Jerry
 * @version 1.0
 * @since 1.0
 */
public class RSAUtil {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data       加密数据
     * @param privateKey 私钥
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        // 解密由base64编码的私钥
        byte[] keyBytes = Base64Util.decodeToBytes(privateKey);

        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // 取私钥匙对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 私钥
        signature.initSign(priKey);
        // 加密的数据的字节数组
        signature.update(data);

        return Base64Util.encode(signature.sign());
    }

    /**
     * 校验数字签名
     *
     * @param data      加密数据
     * @param publicKey 公钥
     * @param sign      数字签名
     * @return 校验成功返回true 失败返回false
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign)
            throws Exception {
        // 获取签名的字节数组
        byte[] decodeSignBytes = Base64Util.decodeToBytes(sign);

        // 解密由base64编码的公钥
        byte[] keyBytes = Base64Util.decodeToBytes(publicKey);

        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // 取公钥匙对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);

        // 获取签名对象
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 设置公钥
        signature.initVerify(pubKey);
        // 通过数据更新签名
        signature.update(data);

        // 验证签名是否正常
        return signature.verify(decodeSignBytes);
    }

    /**
     * 加密<br>
     * 用公钥加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String key)
            throws Exception {
        // 对公钥解密
        byte[] keyBytes = Base64Util.decodeToBytes(key);

        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return cipher.doFinal(data);
    }

    /**
     * 解密<br>
     * 用公钥解密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, String key)
            throws Exception {
        // 对密钥解码
        byte[] keyBytes = Base64Util.decodeToBytes(key);

        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // 获取公钥
        Key publicKey = keyFactory.generatePublic(x509KeySpec);

        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());

        // 设置加密类型，设置公钥
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return cipher.doFinal(data);
    }

    /**
     * 加密<br>
     * 用私钥加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String key)
            throws Exception {
        // 对密钥解码
        byte[] keyBytes = Base64Util.decodeToBytes(key);

        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());

        // 设置加密类型，设置私钥
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(data);
    }

    /**
     * 解密<br>
     * 用私钥解密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, String key)
            throws Exception {
        // 对密钥解密
        byte[] keyBytes = Base64Util.decodeToBytes(key);

        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        return cipher.doFinal(data);
    }

    /**
     * 取得私钥
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Object> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);

        return Base64Util.encode(key.getEncoded());
    }

    /**
     * 取得公钥
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Object> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);

        return Base64Util.encode(key.getEncoded());
    }

    /**
     * 初始化密钥
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> initKey() throws Exception {
        // 通过算法类型获得对应的密钥生成器
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        // 指定密钥对的长度
        keyPairGen.initialize(1024);

        // 获取密钥对
        KeyPair keyPair = keyPairGen.generateKeyPair();

        // 公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        // 私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        Map<String, Object> keyMap = new HashMap<String, Object>(2);

        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);

        return keyMap;
    }

    public static void main(String[] args) throws Exception {
        // 构建密钥对，私钥和公钥
        Map<String, Object> keyMap = RSAUtil.initKey();

        // 获取公钥,公布出去
        String publicKey = RSAUtil.getPublicKey(keyMap);

        // 获取私钥，Base64编码
        String privateKey = RSAUtil.getPrivateKey(keyMap);

        System.err.println("公钥: \n\r" + publicKey);
        System.err.println("私钥： \n\r" + privateKey);

        // 1##############################
        System.err.println("\n私钥加密——公钥解密");

        String inputStr1 = "前锋深圳anroid1509 1507";

        byte[] data1 = inputStr1.getBytes();

        // 私钥加密 encodedData1 - 私钥加密
        // 甲方获得私钥，进行加密
        byte[] encodedData1 = RSAUtil.encryptByPrivateKey(data1, privateKey);

        // 甲方
        // Base64Util.encode(encodedData1)
        // 这个内容，就是加密之后通过Base64编码的内容，需要在网络上传输
        String encodeString = Base64Util.encode(encodedData1);
        System.err.println("加密内容: " + encodeString);

        // translate ....

        // 乙方
        // 公钥解密 decodedData1 - 公钥解密的数据

        // 先解码
        byte[] destBytes = Base64Util.decodeToBytes(encodeString);

        // 明文所对应的字节数组
        byte[] decodedData1 = RSAUtil.decryptByPublicKey(destBytes, publicKey);

        String outputStr1 = new String(decodedData1);

        System.err.println("加密前: " + inputStr1 + "\r" + "解密后: " + outputStr1);


        // 2##############################
        System.err.println("\n公钥加密——私钥解密");
        String inputStr = "abc";
        byte[] data = inputStr.getBytes();

        // 乙方 - 公钥加密
        byte[] encodedData = RSAUtil.encryptByPublicKey(data, publicKey);
        // 公钥加密后，使用Base64编码
        String endcodeStr = Base64Util.encode(encodedData);

        System.err.println("加密内容: " + endcodeStr);

        // translate...

        // 甲方 - 私钥解密
        // 解码
        byte[] decodeBytes = Base64Util.decodeToBytes(endcodeStr);

        // 解密，解密的字节数组就是明文字节数组
        byte[] decodedData = RSAUtil.decryptByPrivateKey(decodeBytes, privateKey);

        String outputStr = new String(decodedData);

        System.err.println("加密前: " + inputStr + "\r" + "解密后: " + outputStr);


        // 3##############################
        System.err.println("\n私钥签名——公钥验证签名");

        // 甲方

        //byte[] encodedData1 = RSAUtil.encryptByPrivateKey(data1, privateKey);

        // 使用私钥产生签名
        // 数据应该是使用加密，使用公钥或者私钥加密

        String sign = RSAUtil.sign(encodedData1, privateKey);
        System.err.println("签名:\r" + sign);

        // translate...（签名数据，加密的数据）

        // 网络传输中可能篡改
        encodedData1[encodedData1.length - 1] = 10;

        // 乙方
        // 通过公钥验证签名
        boolean status = RSAUtil.verify(encodedData1, publicKey, sign);
        System.err.println("状态:\r" + status);
    }
}
