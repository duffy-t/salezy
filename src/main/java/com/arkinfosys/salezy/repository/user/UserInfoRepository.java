package com.arkinfosys.salezy.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arkinfosys.salezy.domain.user.UserInfo;

/**
 * ユーザ情報リポジトリ院テーフェイス.
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

}
