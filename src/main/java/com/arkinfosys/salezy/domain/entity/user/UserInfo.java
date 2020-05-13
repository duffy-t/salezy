package com.arkinfosys.salezy.domain.entity.user;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.apache.commons.lang3.StringUtils;

import com.arkinfosys.salezy.domain.common.Encryption;
import com.arkinfosys.salezy.domain.common.FieldSizeDef;
import com.arkinfosys.salezy.domain.entity.core.BaseEntity;

/**
 * ユーザ情報クラス.
 */
@Entity
public class UserInfo extends BaseEntity implements Serializable {
    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** ユーザID. */
    @Column(length = FieldSizeDef.UserInfo.userId, unique = true)
    private String userId;

    /** 表示名. */
    @Column(length = FieldSizeDef.UserInfo.displayName)
    private String displayName;

    /** ログインパスワード（暗号化済み）. */
    @Column(length = FieldSizeDef.UserInfo.password)
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //---------- methods ---------------------------------------------------------------------------------------------

    /**
     * デフォルトコンストラクタ.
     */
    public UserInfo() {
        // Nothing to do.
    }

    /**
     * 新規ユーザ情報を生成します.
     * @param userId ユーザID
     * @param dispName 表示名
     * @param passwd パスワード（平文）
     * @return ユーザ情報
     */
    public static UserInfo newInstance(String userId, String dispName, String passwd) {
        assert !StringUtils.isEmpty(userId);
        assert !StringUtils.isEmpty(dispName);
        assert !StringUtils.isEmpty(passwd);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setDisplayName(dispName);
        changePassword(userInfo, passwd);
        return userInfo;
    }

    /**
     * 指定ユーザ情報のパスワードを変更します.
     * @param userInfo ユーザ情報
     * @param plainPassword 平文パスワード
     * @return 処理結果（true:正常終了/false:エラー）
     */
    public static boolean changePassword(UserInfo userInfo, String plainPassword) {
        assert !Objects.isNull(userInfo);
        assert !StringUtils.isEmpty(plainPassword);

        String password = Encryption.encrypt(plainPassword);
        if (StringUtils.equals(userInfo.password, password)) {
            return false;
        }

        userInfo.setPassword(password);

        return true;
    }
}
