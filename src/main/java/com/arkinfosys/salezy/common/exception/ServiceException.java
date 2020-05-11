package com.arkinfosys.salezy.common.exception;

/**
 * サービス例外クラス.
 */
public class ServiceException extends RuntimeException {
    /**
     * デフォルトコンストラクタ.
     */
    public ServiceException() {
        super();
    }

    /**
     * コンストラクタ.
     * @param message メッセージ
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * コンストラクタ.
     * @param message メッセージ
     * @param cause 原因
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * コンストラクタ.
     * @param cause 原因
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
