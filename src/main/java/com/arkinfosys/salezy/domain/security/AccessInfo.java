package com.arkinfosys.salezy.domain.security;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.arkinfosys.salezy.domain.core.BaseEntity;
import com.arkinfosys.salezy.domain.user.UserInfo;

/**
 * アクセス情報クラス.
 */
@Entity
public class AccessInfo extends BaseEntity implements Serializable {
    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** アクセスキー. */
    private String accessKey;

    /** ユーザ情報. */
    @OneToOne
    private UserInfo userInfo;

    //---------- getter/setter -----------------------------------------------------------------------------------------

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
