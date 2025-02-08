package cn.com.hiseas.common.utils;

import javax.crypto.Cipher;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA加解密工具
 *
 * @author zhengxiang
 */
@SuppressWarnings("all")
public final class RsaUtil {

    private static final String KEY_ALGORITHM = "RSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    private RsaUtil() {
    }

    /**
     * * 初始化RSA密钥对
     * RSA 加密时，对要加密数据的大小有限制，最大不大于密钥长度。
     * * 如在使用 1024 bit 的密钥时，最大可以加密 1024/8=128 Bytes 的数据。
     * * 数据大于 128 Bytes 时，需要对数据进行分组加密（如果数据超限，加解密时会失败,UTF-8时中文1字符3bit，英文1字符1bit，采用英文字符可支持128位明文加密
     * * 两个密钥都可以用于加解密,通过私钥可以轻松计算出公钥，反之不行，故公钥发送客户端加密，私钥服务器保存解密
     */
    public static Map<String, Key> initRsaKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        Map<String, Key> keyMap = new HashMap<>(2);
        keyMap.put(PUBLIC_KEY, keyPair.getPublic());
        // 公钥
        keyMap.put(PRIVATE_KEY, keyPair.getPrivate());
        // 私钥
        return keyMap;
    }

    public static String getPublicKey(Map<String, Key> map) {
        return getKey(map.get(PUBLIC_KEY));
    }

    public static String getPrivateKey(Map<String, Key> map) {
        return getKey(map.get(PRIVATE_KEY));
    }

    public static String getKey(Key key) {
        return encodeBase64(key.getEncoded());
    }

    public static byte[] decodeBase64(String key) {
        return Base64.getDecoder().decode(key);
    }

    public static String encodeBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public static String urlEncoder(String src) throws Exception {
        return URLEncoder.encode(src, StandardCharsets.UTF_8);
    }

    public static String urlDecoder(String src) throws Exception {
        return URLDecoder.decode(src, StandardCharsets.UTF_8);
    }

    /**
     * *用公钥加密
     */
    public static String encryptByPublicKey(String data, String key) throws Exception {
        // 对公钥解密
        byte[] keyBytes = decodeBase64(key);
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return encodeBase64(result);
    }

    /**
     * *用私钥解密
     */
    public static String decryptByPrivateKey(String data, String key) throws Exception {
        // 对密钥解密
        byte[] keyBytes = decodeBase64(key);
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(decodeBase64(data));
        return new String(result, StandardCharsets.UTF_8);
    }


    public static void main(String[] args) throws Exception {
        Map<String, Key> stringKeyMap = initRsaKeyPair();
        String publicKey = RsaUtil.getPublicKey(stringKeyMap);
        String privateKey = RsaUtil.getPrivateKey(stringKeyMap);
        System.out.println("publicKey:" + publicKey);
        System.out.println("privateKey:" + privateKey);
    }


}
