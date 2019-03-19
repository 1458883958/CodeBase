package com.cardplus.mobile.cardplus.utils;

import android.text.TextUtils;

import com.cardplus.mobile.cardplus.common.Common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class StringTextUtils {

    /**
     * 手机号码框控制
     *
     * @param text
     * @return
     */
    public static String mobilePhoneFormatter(String text) {
        if (text == null || text.length() < 4) {
            return text;
        }

        StringBuilder sb = new StringBuilder(text.replaceAll(" ", ""));
        if (text.length() > 3 && text.length() < 8) {
            sb.insert(3, " ");
        } else {
            sb.insert(3, " ");
            sb.insert(8, " ");
        }
        return sb.toString();
    }


    /**
     * 判断字符串是否符合手机号码格式
     * 移动号段: 134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188
     * 联通号段: 130,131,132,145,155,156,170,171,175,176,185,186
     * 电信号段: 133,149,153,170,173,177,180,181,189
     *
     * @param mobile
     * @return 待检测的字符串
     */
    public static boolean isMobile(String mobile) {
        String str = mobile.replace(" ", "");
        String telRegex = "^((13[0-9])|(14[5|,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
        // "[1]"代表下一位为数字可以是几，"[0-9]"代表可以为0-9中的一个，"[5,7,9]"表示可以是5,7,9中的任意一位,[^4]表示除4以外的任何一个,\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(str))
            return false;
        else
            return str.matches(telRegex);
    }


    /**
     * MD5_KEY
     *
     * @param string
     * @return
     */
    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * AES加密
     *
     * @param content str
     * @param key     key
     * @return
     */
    public static String encryptAES(String content, String key) {
        try {
            byte[] byteContent = content.getBytes("UTF-8");
            // 注意，为了能与 iOS 统一
            // 这里的 key 不可以使用 KeyGenerator、SecureRandom、SecretKey 生成
            byte[] enCodeFormat = key.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
            byte[] initParam = Common.OFF_SET.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            // 指定加密的算法、工作模式和填充方式
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encryptedBytes = cipher.doFinal(byteContent);
            return parseByte2HexStr(encryptedBytes);

        } catch (Exception e) {
            // TODO: handle exception
            LogUtil.e("AES 加密异常");
        }
        return null;
    }

    private static String parseByte2HexStr(byte buf[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }


    /**
     * 每4位添加一个空格
     *
     * @param content
     * @return
     */
    public static String addSpaceByCredit(String content) {
        if (TextUtils.isEmpty(content)) {
            return "";
        }
        content = content.replaceAll(" ", "");
        if (TextUtils.isEmpty(content)) {
            return "";
        }
        StringBuilder newString = new StringBuilder();
        for (int i = 1; i <= content.length(); i++) {
            if (i % 4 == 0 && i != content.length()) {
                newString.append(content.charAt(i - 1)).append(" ");
            } else {
                newString.append(content.charAt(i - 1));
            }
        }
        return newString.toString();
    }


    /**
     * 格式化银行卡号
     *
     * @param bankno 银行卡号
     * @return String
     */
    public static String bankNoFormatter(String bankno) {
        if (TextUtils.isEmpty(bankno)) {
            return null;
        }

        if (bankno.length() < 4) {
            return null;
        }

        String formatter = bankno.substring(bankno.length() - 4);
        return "*" + formatter;
    }

    /**
     * MD5
     *
     * @param str str
     * @return
     */
    public static String encryption(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return md5(md5(str + Common.MD5_KEY));

    }


}
