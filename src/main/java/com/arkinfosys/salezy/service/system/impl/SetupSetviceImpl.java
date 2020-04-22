package com.arkinfosys.salezy.service.system.impl;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arkinfosys.salezy.domain.user.UserInfo;
import com.arkinfosys.salezy.repository.user.UserInfoRepository;
import com.arkinfosys.salezy.service.system.SetupService;

/**
 * セットアップサービスの実装.
 */
@Service
@Transactional(value=TxType.REQUIRED)
public class SetupSetviceImpl implements SetupService {
    /** ユーザ情報リポジトリ. */
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
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
