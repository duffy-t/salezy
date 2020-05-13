package com.arkinfosys.salezy.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arkinfosys.salezy.domain.entity.user.UserInfo;

/**
 * ユーザ情報リポジトリインターフェイス.
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

}
