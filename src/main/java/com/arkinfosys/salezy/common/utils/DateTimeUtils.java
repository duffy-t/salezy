package com.arkinfosys.salezy.common.utils;

import java.sql.Timestamp;

/**
 * 日時関連ユーティリティクラス.
 */
public class DateTimeUtils {

    /**
     * プライベートコンストラクタ.
     */
    private DateTimeUtils() {
        // Nothing to do.
    }

    /**
     * 現在日時を取得します.
     * @return 現在日時
     */
    public static Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
