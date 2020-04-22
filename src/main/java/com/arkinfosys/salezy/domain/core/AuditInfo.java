package com.arkinfosys.salezy.domain.core;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Embeddable;

/**
 * 監査情報クラス.
 */
@Embeddable
public class AuditInfo implements Serializable {
    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** 作成日時. */
    private Timestamp creationTime;

    /** 作成ユーザID. */
    private String creationUserId;

    /** 最終更新日時. */
    private Timestamp lastUpdateTime;

    /** 最終更新ユーザID. */
    private String lastUpdateUserId;

    //---------- getter/setter -----------------------------------------------------------------------------------------

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreationUserId() {
        return creationUserId;
    }

    public void setCreationUserId(String creationUserId) {
        this.creationUserId = creationUserId;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }
}
