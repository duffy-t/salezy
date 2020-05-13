package com.arkinfosys.salezy.common.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.arkinfosys.salezy.common.system.RequestContext;
import com.arkinfosys.salezy.common.utils.DateTimeUtils;
import com.arkinfosys.salezy.domain.entity.core.BaseEntity;

/**
 * ベースエンティティリスナクラス.
 */
public class BaseEntityListener {
    /**
     * エンティティ登録時のリスナメソッドです.
     * @param entity エンティティ
     */
    @PrePersist
    public void onPersist(BaseEntity entity) {
        entity.getAuditInfo().setCreationTime(DateTimeUtils.currentTimestamp());
        entity.getAuditInfo().setLastUpdateTime(DateTimeUtils.currentTimestamp());
        if (RequestContext.getUserInfo() != null) {
            entity.getAuditInfo().setCreationUserId(RequestContext.getUserInfo().getUserId());
            entity.getAuditInfo().setLastUpdateUserId(RequestContext.getUserInfo().getUserId());
        }
    }

    /**
     * エンティティ更新時のリスナメソッドです.
     * @param entity エンティティ
     */
    @PreUpdate
    public void onUpdate(BaseEntity entity) {
        entity.getAuditInfo().setLastUpdateTime(DateTimeUtils.currentTimestamp());
        if (RequestContext.getUserInfo() != null) {
            entity.getAuditInfo().setLastUpdateUserId(RequestContext.getUserInfo().getUserId());
        }
    }
}
