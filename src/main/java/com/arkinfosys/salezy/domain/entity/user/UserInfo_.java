package com.arkinfosys.salezy.domain.entity.user;

import com.arkinfosys.salezy.domain.entity.core.BaseEntity_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-13T16:48:36.608+0900")
@StaticMetamodel(UserInfo.class)
public class UserInfo_ extends BaseEntity_ {
	public static volatile SingularAttribute<UserInfo, String> userId;
	public static volatile SingularAttribute<UserInfo, String> displayName;
	public static volatile SingularAttribute<UserInfo, String> password;
}
