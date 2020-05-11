package com.arkinfosys.salezy.domain.common;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.lang3.StringUtils;

/**
 * 暗号化クラス.
 */
public class Encryption {
    /** 暗号化アルゴリズム名. */
    private static final String ALGORITHM = "SHA-256";

    /**
     * プライベートコンストラクタ.
     */
    private Encryption() {
        // Nothing to do.
    }

    /**
     * パスワードを暗号化します.
     * @param password パスワード文字列
     * @return 暗号化した文字列
     */
    public static String encrypt(String password) {
        try {
            if (StringUtils.isEmpty(password)) {
                return null;
            }
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            md.update(password.getBytes());
            byte[] data = md.digest();
            BigInteger bigInt = new BigInteger(1, data);
            return bigInt.toString(16);
        } catch (Exception e) {
            return null;
        }
    }
}
