package com.zsls.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName DataSourceContentHolder
 *@Description
 *@Author zsls
 *@Date 2019/9/11 12:42
 *@Version 1.0
 */
public class DataSourceContentHolder {
	private static final Logger logger = LoggerFactory.getLogger(DataSourceContentHolder.class);

	private static int counter = 0;

	/**
	 * Maintain variable for every thread, to avoid effect other thread  使用ThreadLocal保证线程安全
	 */
	private static final ThreadLocal<String> CONTEXT_HOLDER = ThreadLocal.withInitial(DataSourceKey.MASTER::name);


	/**
	 * All DataSource List
	 */
	public static List<Object> dataSourceKeys = new ArrayList<>();

	/**
	 * The constant slaveDataSourceKeys.
	 */
	public static List<Object> slaveDataSourceKeys = new ArrayList<>();

	/**
	 * To switch DataSource
	 *
	 * @param key the key
	 */
	public static void setDataSourceKey(String key) {
		CONTEXT_HOLDER.set(key);
	}

	/**
	 * Use master data source.
	 */
	public static void useMasterDataSource() {
		CONTEXT_HOLDER.set(DataSourceKey.MASTER.name());
	}

	/**
	 * Use slave data source.
	 */
	public static void useSlaveDataSource() {
		try {
			int datasourceKeyIndex = counter % slaveDataSourceKeys.size();
			CONTEXT_HOLDER.set(String.valueOf(slaveDataSourceKeys.get(datasourceKeyIndex)));
			counter++;
		} catch (Exception e) {
			logger.info("Switch slave datasource failed, error message is : ", e);
			useMasterDataSource();
		}
	}

	/**
	 * Get current DataSource
	 *
	 * @return data source key
	 */
	public static String getDataSourceKey() {
		return CONTEXT_HOLDER.get();
	}

	/**
	 * To set DataSource as default
	 */
	public static void clearDataSourceKey() {
		CONTEXT_HOLDER.remove();
	}

	/**
	 * Check if give DataSource is in current DataSource list
	 *
	 * @param key the key
	 * @return boolean boolean
	 */
	public static boolean containDataSourceKey(String key) {
		return dataSourceKeys.contains(key);
	}

}
