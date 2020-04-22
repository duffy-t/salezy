package com.arkinfosys.salezy.service.system;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arkinfosys.salezy.domain.user.UserInfo;
import com.arkinfosys.salezy.repository.user.UserInfoRepository;

/**
 * セットアップサービス.
 */
@Service
@Transactional(value=TxType.REQUIRED)
public class SetupService {
    /** ユーザ情報リポジトリ. */
    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * セットアップ処理を実行する.
     */
    public void execute() {
        // ユーザ情報が存在する場合は実行しない
        if (userInfoRepository.count() > 0) {
            return;
        }

        // システムユーザ登録
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("system");
        userInfo.setDisplayName("SYSTEM");
        userInfoRepository.save(userInfo);
    }
}
