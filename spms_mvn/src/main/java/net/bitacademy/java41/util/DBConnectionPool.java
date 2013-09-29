package net.bitacademy.java41.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.stereotype.Component;

@Component
public class DBConnectionPool {
	String url;
	String id;
	String pwd;
	String driver;
	
	ArrayList<Connection> list = new ArrayList<Connection>();
	Hashtable<Thread, Connection> rentTable = new Hashtable<Thread, Connection>();
	
	public DBConnectionPool setUrl(String url) {
		this.url = url;
		return this;
	}
	
	public DBConnectionPool setId(String id) {
		this.id = id;
		return this;
	}
	
	public DBConnectionPool setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}
	
	public DBConnectionPool setDriver(String driver) {
		this.driver = driver;
		return this;
	}
	
	public Connection getConnection() throws Exception{
		Thread curThread = Thread.currentThread();
		
		Connection con = rentTable.get(curThread);
		if( con != null){
			return con;
		}
		if(list.size() > 0){
			con = list.remove(0);
			
			
		} else {
			Class.forName(driver);
			con =DriverManager.getConnection(url,id,pwd);
			
		}
		rentTable.put(curThread, con);
		return con;
	}
	
	public void returnConnection(Connection con){
		Thread curThread = Thread.currentThread();
		rentTable.remove(curThread);
		list.add(con);
	}
}
