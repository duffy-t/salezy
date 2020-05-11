package com.arkinfosys.salezy.domain.security;

import com.arkinfosys.salezy.domain.core.BaseEntity_;
import com.arkinfosys.salezy.domain.user.UserInfo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-11T13:24:48.581+0900")
@StaticMetamodel(AccessInfo.class)
public class AccessInfo_ extends BaseEntity_ {
	public static volatile SingularAttribute<AccessInfo, String> accessKey;
	public static volatile SingularAttribute<AccessInfo, UserInfo> userInfo;
	public static volatile SingularAttribute<AccessInfo, Integer> usedCount;
	public static volatile SingularAttribute<AccessInfo, String> remoteAddress;
}
