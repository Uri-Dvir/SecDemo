package com.example.secdemo;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SecurityHelper {


    private static String secret = BuildConfig.SharedKey;
    private static SecretKey key =  new SecretKeySpec(secret.getBytes(), "AES");

    public static String Encrypt(String plain) {
        try {
            Cipher cipher = null;
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = cipher.doFinal(plain.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e){
            return "";
        }

    }

    public static String Decrypt(String encrypted) {
        try {
            byte[] decodedValue = Base64.getDecoder().decode(encrypted);
            Cipher cipher = null;
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            String decryptString = new String(cipher.doFinal(decodedValue), "UTF-8");
            return decryptString;
        } catch (Exception e){
            return "";
        }
    }


}



