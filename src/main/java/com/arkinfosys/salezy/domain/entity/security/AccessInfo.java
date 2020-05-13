package com.arkinfosys.salezy.domain.entity.security;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.arkinfosys.salezy.common.utils.DateTimeUtils;
import com.arkinfosys.salezy.domain.common.FieldSizeDef;
import com.arkinfosys.salezy.domain.entity.core.BaseEntity;
import com.arkinfosys.salezy.domain.entity.user.UserInfo;

/**
 * アクセス情報クラス.
 */
@Entity
public class AccessInfo extends BaseEntity implements Serializable {
    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** アクセスキー. */
    @Column(length = FieldSizeDef.AccessInfo.accessKey)
    private String accessKey;

    /** 利用カウンタ. */
    private Integer usedCount = 0;

    /** ユーザ情報. */
    @OneToOne
    private UserInfo userInfo;

    /** リモートIPアドレス. */
    @Column(length = FieldSizeDef.AccessInfo.remoteAddress)
    private String remoteAddress;

    /** 登録日時. */
    private Timestamp registrationTime;

    //---------- getter/setter -----------------------------------------------------------------------------------------

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public Integer getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(Integer usedCount) {
        this.usedCount = usedCount;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public Timestamp getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Timestamp registrationTime) {
        this.registrationTime = registrationTime;
    }

    //---------- methods -----------------------------------------------------------------------------------------------

    /**
     * デフォルトコンストラクタ.
     */
    public AccessInfo() {
        // Nothing to do.
    }

    /**
     * 新規インスタンスを生成します.
     * @param userInfo ユーザ情報
     * @param remoteAddress リモートアドレス
     * @return 新規アクセス情報インスタンス
     */
    public static AccessInfo newInstance(UserInfo userInfo, String remoteAddress) {
        assert !Objects.isNull(userInfo);
        assert !Objects.isNull(remoteAddress);

        AccessInfo accInfo = new AccessInfo();
        accInfo.setAccessKey(UUID.randomUUID().toString());
        accInfo.setUsedCount(0);
        accInfo.setUserInfo(userInfo);
        accInfo.setRemoteAddress(remoteAddress);
        accInfo.setRegistrationTime(DateTimeUtils.currentTimestamp());

        return accInfo;
    }
}
