package com.dearjing.mall.boot.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MdUtils {
    static  public String md5(byte[] source) throws NoSuchAlgorithmException {
        MessageDigest md5Md = MessageDigest.getInstance("MD5");
        byte[] md5 = md5Md.digest(source);
        BigInteger bigInt = new BigInteger(1,md5);
        String hashtext = bigInt.toString(16);
// Now we need to zero pad it if you actually want the full 32 chars.
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }
        return hashtext;
    }

    public static String sha256(byte[] source) throws NoSuchAlgorithmException {
        MessageDigest md5Md = MessageDigest.getInstance("SHA256");
        byte[] md5 = md5Md.digest(source);
        BigInteger bigInt = new BigInteger(1,md5);
        String hashtext = bigInt.toString(16);
// Now we need to zero pad it if you actually want the full 32 chars.
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }
        return hashtext;
    }
}
