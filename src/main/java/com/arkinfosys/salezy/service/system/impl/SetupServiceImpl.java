package com.arkinfosys.salezy.service.system.impl;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arkinfosys.salezy.common.exception.ServiceException;
import com.arkinfosys.salezy.domain.user.UserInfo;
import com.arkinfosys.salezy.repository.user.UserInfoRepository;
import com.arkinfosys.salezy.service.system.SetupService;

/**
 * セットアップサービスの実装.
 */
@Service
@Transactional(value=TxType.REQUIRED)
public class SetupServiceImpl implements SetupService {
    /** システムユーザID. */
    private static final String SYSTEM_USER_ID = "system";

    /** システムユーザ表示名. */
    private static final String SYSTEM_DISP_NAME = "SYSTEM";

    /** ユーザ情報リポジトリ. */
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public void execute(String passwd) {
        // 入力パラメタチェック
        if (StringUtils.isEmpty(passwd)) {
            throw new ServiceException("hogehoge");
        }

        // ユーザ情報が存在する場合は実行しない
        if (userInfoRepository.count() > 0) {
            return;
        }

        // システムユーザ登録
        try {
            UserInfo userInfo = UserInfo.newInstance(SYSTEM_USER_ID, SYSTEM_DISP_NAME, passwd);
            userInfo = userInfoRepository.save(userInfo);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }
}
