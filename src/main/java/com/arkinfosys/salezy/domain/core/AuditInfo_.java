package com.arkinfosys.salezy.domain.core;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-04-14T13:44:26.962+0900")
@StaticMetamodel(AuditInfo.class)
public class AuditInfo_ {
	public static volatile SingularAttribute<AuditInfo, Timestamp> creationTime;
	public static volatile SingularAttribute<AuditInfo, String> creationUserId;
	public static volatile SingularAttribute<AuditInfo, Timestamp> lastUpdateTime;
	public static volatile SingularAttribute<AuditInfo, String> lastUpdateUserId;
}
