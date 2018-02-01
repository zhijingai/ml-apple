package com.lovlos.apple.mapper;

import com.lovlos.mybatis.readwrite.DataSource;
import com.lovlos.mybatis.readwrite.config.DataSourceConfig;

public interface UserMapper {

	Integer select();
	
	@DataSource(dataSourceConfig=DataSourceConfig.SLAVE, dbName={"readDataSourceTwo"})
	Integer selectTwo();
}
