package com.arkinfosys.salezy.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arkinfosys.salezy.domain.security.AccessInfo;

/**
 * アクセス情報インターフェイス.
 */
@Repository
public interface AccessInfoRepository extends JpaRepository<AccessInfo, Long> {


}
