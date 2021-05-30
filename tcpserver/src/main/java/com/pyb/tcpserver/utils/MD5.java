package com.pyb.tcpserver.utils;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @author pyb
 * @date 2021年05月22日 17:46
 * 加密方式为32位小写
 */
public class MD5 {
    public static String encrypt(String string) {
        String md5 = "";
        try {
            // 初始化MD5对象
            MessageDigest instance = MessageDigest.getInstance("MD5");
            // 将字符串变成byte数组
            byte[] bs = string.getBytes();
            // 得到128位字节数组
            byte[] digest = instance.digest(bs);
            // 转换成16进制
            md5 = bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {

        }
        return md5;
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        int dig = 0;
        for (byte b : bytes) {
            dig = b;
            if (dig < 0) {
                dig += 256;
            }
            if (dig < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(dig));
        }
        return sb.toString().toLowerCase();
    }

}
