package com.dao.util;

public interface DbProperties_Live {
	// String jdbcUrl = " jdbc:mysql://localhost:3306/weather?useSSL=false";
	String jdbcUrl_weather = " jdbc:mysql://localhost:3306/weather";
	String jdbcUrl_dmnative = " jdbc:mysql://localhost:3306/dmdatabase";
	String jdbcUrl_wfms = " jdbc:mysql://localhost:3306/wfms";

	String user = "root";
	String password = "Aicnet@123";
	String dmnative_user = "root";
	String dmnative_password = "Aicnet@123";

	String jdbc_driver = "com.mysql.jdbc.Driver";

	int MaximumPoolSize = 5;
	int wfms_MaximumPoolSize = 5;
	int dmapp_MaximumPoolSize = 30;
	int weather_MaximumPoolSize = 15;
	
	
	int MinimumIdle = 3;
	int LeakDetectionThreshold = 15000;
	int ConnectionTimeout = 10000;

}
