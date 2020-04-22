package com.arkinfosys.salezy.domain.user;

import java.io.Serializable;

import javax.persistence.Entity;

import com.arkinfosys.salezy.domain.core.BaseEntity;

/**
 * ユーザ情報クラス.
 */
@Entity
public class UserInfo extends BaseEntity implements Serializable {
    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** ユーザID. */
    private String userId;

    /** 表示名. */
    private String displayName;

    //---------- getter/setter -----------------------------------------------------------------------------------------

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
