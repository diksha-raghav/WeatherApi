package com.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBUtil_local {
	private static Connection conn = null;
	private static final HikariDataSource ds_dmdatabase = new HikariDataSource();
	private static final HikariDataSource ds_wfms = new HikariDataSource();
	private static final HikariDataSource ds_weather = new HikariDataSource();

	final static Logger logger = Logger.getLogger(DBUtil_local.class);

	private static HikariDataSource ds;
	static {
		// datasource for dmnativeCREATE A SEPARATE FILE FOR PRODUCTION
		ds_dmdatabase.setDriverClassName(DbProperties.jdbc_driver);
		ds_dmdatabase.setJdbcUrl(DbProperties.jdbcUrl_dmnative);
		ds_dmdatabase.setUsername(DbProperties.jdbcUrl_dmnative);
		ds_dmdatabase.setPassword(DbProperties.password);
		ds_dmdatabase.setMaximumPoolSize(DbProperties.MaximumPoolSize);
		ds_dmdatabase.setMinimumIdle(DbProperties.MinimumIdle);
		ds_dmdatabase.setLeakDetectionThreshold(DbProperties.LeakDetectionThreshold);
		ds_dmdatabase.setConnectionTestQuery("SELECT 1");
		ds_dmdatabase.setConnectionTimeout(DbProperties.ConnectionTimeout);

		// datasource for WFMS
		ds_wfms.setDriverClassName(DbProperties.jdbc_driver);
		ds_wfms.setJdbcUrl(DbProperties.jdbcUrl_wfms);
		ds_wfms.setUsername(DbProperties.user);
		ds_wfms.setPassword(DbProperties.password);
		ds_wfms.setMaximumPoolSize(DbProperties.MaximumPoolSize);
		ds_wfms.setMinimumIdle(DbProperties.MinimumIdle);
		ds_wfms.setLeakDetectionThreshold(DbProperties.LeakDetectionThreshold);
		ds_wfms.setConnectionTestQuery("SELECT 1");
		ds_wfms.setConnectionTimeout(DbProperties.ConnectionTimeout);

		// datasource for Weather
		ds_weather.setDriverClassName(DbProperties.jdbc_driver);
		ds_weather.setJdbcUrl(DbProperties.jdbcUrl_weather);
		ds_weather.setUsername(DbProperties.user);
		ds_weather.setPassword(DbProperties.password);
		ds_weather.setMaximumPoolSize(DbProperties.MaximumPoolSize);
		ds_weather.setMinimumIdle(DbProperties.MinimumIdle);
		ds_weather.setLeakDetectionThreshold(DbProperties.LeakDetectionThreshold);
		ds_weather.setConnectionTestQuery("SELECT 1");
		ds_weather.setConnectionTimeout(DbProperties.ConnectionTimeout);
	}

	public static Connection getConn() throws SQLException {
		/*
		 * try { String hostname =
		 * "aic-poc-rdsdb.cujzl6rksqcn.ap-south-1.rds.amazonaws.com";
		 * Class.forName("com.mysql.jdbc.Driver"); conn =
		 * DriverManager.getConnection("jdbc:mysql://" + hostname + ":3306/dmdatabase",
		 * "aic-rdsuser", "MngHrtU*$R5hTyr!K4G1");
		 * 
		 * } catch (Exception e) { String message = ""; for (StackTraceElement
		 * stackTraceElement : Thread.currentThread().getStackTrace()) { message =
		 * message + System.lineSeparator() + stackTraceElement.toString(); }
		 * logger.error(e + System.lineSeparator() + message);
		 * 
		 * }
		 */

//		return getHikariConnection("dmdatabase", "aic-poc-rdsdb.cujzl6rksqcn.ap-south-1.rds.amazonaws.com",
//				"MngHrtU*$R5hTyr!K4G1");
//		return getHikariConnection("dmnative", "root", "Aicnet@123");
		return getHikariConnection("dmnative");

	}

	public static Connection getConnection() throws SQLException {
		/*
		 * try { Class.forName("com.mysql.jdbc.Driver"); conn =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/weather", "root",
		 * "Aicnet@5001"); // ?useSSL=false&allowPublicKeyRetrieval=true } catch
		 * (Exception e) { String message = ""; for (StackTraceElement stackTraceElement
		 * : Thread.currentThread().getStackTrace()) { message = message +
		 * System.lineSeparator() + stackTraceElement.toString(); } logger.error(e +
		 * System.lineSeparator() + message); logger.error(e); } return conn;
		 */
//		return getHikariConnection("weather", "root", "Aicnet@123");
		return getHikariConnection("weather");

	}

	public static Connection getConnection_wfms() throws SQLException {
		/*
		 * try { Class.forName("com.mysql.jdbc.Driver"); conn =
		 * DriverManager.getConnection(
		 * "jdbc:mysql://localhost:3306/wfms?useSSL=false&allowPublicKeyRetrieval=true",
		 * "root", "Aicnet@5001"); } catch (SQLException | ClassNotFoundException e) {
		 * logger.error(e); } return conn;
		 */
//		return getHikariConnection("wfms", "root", "Aicnet@123");
		return getHikariConnection("wfms");

	}

	public static Connection getHikariConnection(String schema) throws SQLException {
		////System.out.println("dmdatabase" + ds_dmdatabase);
		////System.out.println("weather" + ds_weather);
		////System.out.println("Wfms" + ds_wfms);
		////System.out.println(schema);

		if ("wfms".equals(schema)) {
			logger.info(
					" the config values are " + ds_wfms.getJdbcUrl() + ds_wfms.getUsername() + ds_wfms.getPassword());
			return ds_wfms.getConnection();

		} else if ("weather".equals(schema)) {
			logger.info(" the config values are " + ds_weather.getJdbcUrl() + ds_weather.getUsername()
					+ ds_weather.getPassword());
			return ds_weather.getConnection();
		} else if ("dmnative".equals(schema)) {
			////System.out.println("dmnative Connection");
			////System.out.println(ds_dmdatabase.getJdbcUrl());
			////System.out.println(ds_dmdatabase.getUsername());
			////System.out.println(ds_dmdatabase.getPassword());
			logger.info(" the config values are " + ds_dmdatabase.getJdbcUrl() + ds_dmdatabase.getUsername()
					+ ds_dmdatabase.getPassword());
			return ds_dmdatabase.getConnection();
		} else
			return null;
	}

	/*
	 * public static Connection getHikariConnection(String schema, String username,
	 * String password) throws SQLException { String host = "localhost";
	 * 
	 * HikariConfig config = new HikariConfig(); HikariDataSource ds;
	 * config.setDriverClassName("com.mysql.jdbc.Driver");
	 * 
	 * // Code without configuration for dev and production
	 * 
	 * config.setJdbcUrl(DbProperties.jdbcUrl);
	 * config.setUsername(DbProperties.user);
	 * config.setPassword(DbProperties.password);
	 * 
	 * 
	 * config.setJdbcUrl("jdbc:mysql://" + host + "/" + schema +
	 * "?useLocalSessionState=true"); config.setUsername(username);
	 * config.setPassword(password);
	 * 
	 * config.addDataSourceProperty("cachePrepStmts", "true");
	 * config.addDataSourceProperty("prepStmtCacheSize", "250");
	 * config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
	 * 
	 * // ////System.out.println("the config values are " + config.getJdbcUrl() + //
	 * config.getUsername() + config.getPassword());
	 * logger.info(" the config values are " + config.getJdbcUrl() +
	 * config.getUsername() + config.getPassword()); // ds = new
	 * HikariDataSource(config); ds.setConnectionTimeout(1000);
	 * ds.setMaximumPoolSize(10); ds.setMinimumIdle(5); return ds.getConnection(); }
	 */
}