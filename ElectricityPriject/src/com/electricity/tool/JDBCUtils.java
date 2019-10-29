package com.electricity.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JDBCUtils {
	
	// 初始化c3p0d
		private static DataSource dataSource = null;
		static {
			// 自动加载src目录下面的c3p0的配置文件，【c3p0-config.xml】
			dataSource = new ComboPooledDataSource();
		}
		public static QueryRunner getQueryRunner() {
			// 第一步：创建QueryRunner对象，传入连接池对象
			// 在创建QueryRunner对象的时候，如果传入数据对象dataSource，
			// 那么在使用QueryRunner对象的方法时候，就不需要传入连接对象
			QueryRunner query = new QueryRunner(dataSource);
			// 第二步：会自动从数据源中获取连接(不用关闭连接)
			/*
			 * 创建QueryRunner对象，传入连接池对象 在创建QueryRunner对象的时候，如果传入了数据源对象；
			 * 那么在使用QueryRunner对象方法的时候，就不需要传入连接对象； 会自动从数据源中获取连接(不用关闭连接)
			 */
			return query;
		}
	}
