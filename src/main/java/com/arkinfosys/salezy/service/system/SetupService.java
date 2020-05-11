package com.arkinfosys.salezy.service.system;

/**
 * セットアップサービスインターフェイス.
 */
public interface SetupService {
    /**
     * セットアップ処理を実行する.
     * @param passwd 管理者ユーザのパスワード（平文）
     */
    void execute(String passwd);
}
