package com.arkinfosys.salezy.common.system;

import com.arkinfosys.salezy.domain.user.UserInfo;

/**
 * リクエストコンテキストクラス.
 */
public class RequestContext implements AutoCloseable {

    /** ユーザ情報. */
    private static ThreadLocal<UserInfo> userInfoThreadLocal = new ThreadLocal<>();

    /**
     * コンストラクタ.
     * @param userInfo ユーザ情報
     */
    public RequestContext(UserInfo userInfo) {
        userInfoThreadLocal.set(userInfo);
    }

    /**
     * コンテキストに設定されされいるユーザ情報を取得します.
     * @return ユーザ情報（未設定時はnull）
     */
    public static UserInfo getUserInfo() {
        return userInfoThreadLocal.get();
    }

    @Override
    public void close() throws Exception {
        userInfoThreadLocal.remove();
    }
}
