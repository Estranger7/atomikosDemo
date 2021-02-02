package com.estranger.www.atomikos.datasource;

import com.estranger.www.atomikos.common.enumeration.DbEnum;
import com.estranger.www.atomikos.config.DbContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import java.util.Objects;

/**
 * Author：Estranger
 * Description：
 * 动态数据源决策器
 * Date：2021/1/26
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String dbType = DbContextHolder.getDbType();
        if(Objects.equals(dbType, DbEnum.master.getValue())){//主库
            return dbType;
        }else {
           return DbEnum.slave.getValue();
        }
    }
}
