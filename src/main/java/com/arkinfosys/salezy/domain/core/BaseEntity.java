package com.arkinfosys.salezy.domain.core;

import java.io.Serializable;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.arkinfosys.salezy.common.listener.BaseEntityListener;

/**
 * ベースエンティティクラス.
 */
@MappedSuperclass
@EntityListeners({BaseEntityListener.class})
public abstract class BaseEntity implements Serializable {
    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** ID. */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    /** バージョン. */
    @Version
    private Integer version = 0;

    /** 監査情報. */
    private AuditInfo auditInfo = new AuditInfo();

    /**
     * 新規インスタンスであるか判定する.
     * @return 判定結果（新規:{@code true}/既存:{@code false}）
     */
    public boolean isNew() {
        return id == null;
    }

    //------------------- getter/setter --------------------------------------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public AuditInfo getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }
}
