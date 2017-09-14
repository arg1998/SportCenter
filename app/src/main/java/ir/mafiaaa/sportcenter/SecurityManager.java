package ir.mafiaaa.sportcenter;


import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.util.Formatter;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * this class provides a medium level of security
 */
public class SecurityManager
{
    public static String encrypt(String value)
    {
        try
        {
            IvParameterSpec iv = new IvParameterSpec(String.valueOf(XOR(C.Security.IV , 13)).getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(String.valueOf(XOR(C.Security.KEY , 17)).getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.encodeToString(encrypted , Base64.DEFAULT);
        }
        catch (Exception ex)
        {
            Log.i("AAAA", "encrypt: "  + ex.getMessage());
        }

        return null;
    }

    public static String decrypt(String encrypted)
    {
        if (encrypted == null || encrypted.equals("")) {return "";}

        try
        {
            IvParameterSpec iv = new IvParameterSpec(String.valueOf(XOR(C.Security.IV , 13)).getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(String.valueOf(XOR(C.Security.KEY , 17)).getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decode(encrypted , Base64.DEFAULT));

            return new String(original);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return null;
    }


    public static String hash_to_SHA1(String password)
    {
        String sha1 = "";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return sha1;
    }

    private static String byteToHex(final byte[] hash)
    {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public static char[] XOR(String s, int i)
    {
        char[] chars = s.toCharArray();

        for(int j = 0; j<chars.length; j++)
        {
            chars[j] = (char) (chars[j] ^ j*i);
        }
        return chars;
    }

    /**
     * this class hold all constant variables and string data (ARG)
     */
    public static class C // game Constants
    {
        public static class Security
        {
            public static final String IV   =   "J'~L\u0011t(x\f*Ïö³\u009F\u0084·";          // XOR with 13
            public static final String KEY  =   "+#EWr`\u0001\u0013×¹\u0099\u0088û¥ßÞ";     // XOR with 17
        }

    }
}
