package database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import system.Flight;
import system.Utility;

public class SQLDemo {
	
	public SQLDemo() {

	}

	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	// schema的名字 bookingticket
	static final String DB_URL = "jdbc:mysql://localhost:3306/bookingticket?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "123456";

	Connection conn = null;
	Statement stmt = null;

	public void initDatabase() {

		// 注册 JDBC 驱动
		try {
			Class.forName(JDBC_DRIVER);
			// 打开链接
			System.out.println("连接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 执行查询
			System.out.println(" 实例化Statement对象...");
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// query model

	public void closeDatabase() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // 什么都不做
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("database close");
	}
	
	public void addFlight(Flight f) {
		
		String sql;
		PreparedStatement ps = null;
		sql = "insert into flight(flight_number,departure_city,arrival_city,departure_day,arrival_day,"
				+ "departure_time,arrival_time,plane_type,company) "
				+ "values (?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, f.getNumber());
			ps.setString(2, f.getDepartureCity());
			ps.setString(3, f.getArrivalCity());
			
			String day1=f.getDepartureDay().replace('/', '-');
			String day2=f.getArrivalDay().replace('/', '-');
			ps.setDate(4, Date.valueOf(day1));
			ps.setDate(5, Date.valueOf(day2));
			
			ps.setTime(6, Utility.strToTime(f.getDepartureTime()));
			ps.setTime(7, Utility.strToTime(f.getArrivalTime()));
			
			ps.setString(8, f.getPlaneType());
			ps.setString(9, f.getCompany());

			// ----------------------------------
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public boolean getSeatAvailableState(String position,String flightNumber) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean isAvailable=true;
		try {
			String sql = "select isbooked from seat where position = ? and flight_number = ? ;";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, position);
			ps.setString(2, flightNumber);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				int i=rs.getInt("isbooked");
				if(i==0) {
					isAvailable=false;
				}
			}
			// -----------------------------------------------------
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isAvailable;
	}
}
