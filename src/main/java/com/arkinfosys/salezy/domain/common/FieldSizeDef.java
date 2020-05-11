package com.arkinfosys.salezy.domain.common;

/**
 * 各種フィールドサイズの定数定義インターフェイス.
 */
public interface FieldSizeDef {
    /**
     * ユーザ情報関連フィールド.
     */
    public interface UserInfo {
        /** ユーザID. */
        int userId = 16;

        /** 表示名. */
        int displayName = 128;

        /** パスワード. */
        int password = 256;
    }

    /**
     * アクセス情報関連フィールド.
     */
    public interface AccessInfo {
        /** アクセスキー. */
        int accessKey = 36;

        /** リモートアドレス. */
        int remoteAddress = 36;
    }
}
