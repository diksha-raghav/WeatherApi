package com.dao.util;

public interface DbProperties {
	// String jdbcUrl = " jdbc:mysql://localhost:3306/weather?useSSL=false";
	String jdbcUrl_weather = " jdbc:mysql://localhost:3306/weather";
	String jdbcUrl_dmnative = " jdbc:mysql://localhost:3306/dmnative";
	String jdbcUrl_wfms = " jdbc:mysql://localhost:3306/wfms";

	String user = "root";
	String password = "Aicnet@123";

	String jdbc_driver = "com.mysql.jdbc.Driver";

	int MaximumPoolSize = 5;
	int MinimumIdle = 1;
	int LeakDetectionThreshold = 15000;
	int ConnectionTimeout = 10000;

}
