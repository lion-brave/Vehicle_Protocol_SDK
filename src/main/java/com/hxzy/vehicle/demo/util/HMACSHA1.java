package com.hxzy.vehicle.demo.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class HMACSHA1 {

    private static final String HMAC_SHA1 = "HmacSHA1";

    /**
     * Generate signature data
     *
     * @param data   Data to be encrypted
     * @param secret key used for encryption
     * @return Generates an MD5-encoded string
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    public static String getSignature(String data, String secret) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        SecretKeySpec signingKey = new SecretKeySpec(secret.getBytes("utf-8"), HMAC_SHA1);
        Mac mac = Mac.getInstance(HMAC_SHA1);
        mac.init(signingKey);
        byte[] rawHmac = mac.doFinal(data.getBytes("utf-8"));
        return Base64Utils.encode(rawHmac);
    }

}
