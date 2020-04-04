package database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import system.Flight;
import system.Passenger;
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

//------------------------FLIGHT SCHEDULE---------------------------------------------------------------
	
	public boolean alreadyAddPassenger(String passport) {
		boolean inDB = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql;
			sql = "SELECT count(*) FROM bookingticket.passenger where passport_number=? ";
	        ps = conn.prepareStatement(sql);
			ps.setString(1,passport);
			rs = ps.executeQuery();

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				int i=rs.getInt("count(*)");
				if(i>0) {
					inDB=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
		
		return inDB;
	}
	
	public void generateTicket(String ticket,String flight,String passport, String baggage,String theclass) {
		String sql;
		PreparedStatement ps = null;
		sql = "insert into ticket(ticket_number,passport_number,flight_number,baggage_allowance,class) "
				+ "values (?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ticket);
			ps.setString(2, passport);
			ps.setString(3, flight);
			ps.setString(4, baggage);
			ps.setString(5, theclass);
			
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
	
	public void passengerBookFlight(String passport,String flight) {

		String sql;
		PreparedStatement ps = null;
		sql = "insert into book(passport_number,flight_number,book_date) "
				+ "values (?,?,current_date() )";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, passport);
			ps.setString(2, flight);
			
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
	
	public void addPassenger(Passenger p) {
		
		String sql;
		PreparedStatement ps = null;
		sql = "insert into passenger(passport_number,firstname,lastname,gender,expiration_date,email,birthday) "
				+ "values (?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getPassportNumber());
			ps.setString(2, p.getFirstName());
			ps.setString(3, p.getLastName());
			ps.setInt(4, p.getGender());
			ps.setDate(5, Date.valueOf(p.getExpirationDate()));
			ps.setString(6, p.getEmail());
			ps.setDate(7, Date.valueOf(p.getBirthday()));

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
	
	// get the flight currently pick by customer
	public Flight getFlightPickByCustomer(String number) {//book flight
		Flight f=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql;
			sql = "SELECT flight_number,departure_city,arrival_city,departure_day,arrival_day,"+
					"departure_time,arrival_time,plane_type,company,isCancel" 
					+ " FROM flight "
					+ "where flight_number=?";
	        ps = conn.prepareStatement(sql);
			ps.setString(1,number);
			rs = ps.executeQuery();

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				String flightNumber = rs.getString("flight_number");
				String departure_city = rs.getString("departure_city");
				String arrival_city = rs.getString("arrival_city");
				
				Date departure_day = rs.getDate("departure_day");
				Date arrival_day = rs.getDate("arrival_day");
				Time departure_time = rs.getTime("departure_time");
				Time arrival_time = rs.getTime("arrival_time");
				
				String plane_type = rs.getString("plane_type");
				String company = rs.getString("company");
				int cancel=rs.getInt("isCancel");
				//--------------------------------------
				String departureDay=departure_day.toString();
				String arrivalDay=arrival_day.toString();
				String departureTime=departure_time.toString();
				String arrivalTime=arrival_time.toString();
				//------------------------------------------
				f=new Flight(flightNumber,departure_city,arrival_city,departureDay,
						arrivalDay,departureTime,arrivalTime,plane_type,company,cancel);
	           
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
		
		return f;
	}
	
//---------------------MANAGER PAGE-----------------------------------------------------------------
	//manager page 显示入座人数
	public int getSeatBookingNumber(String flightNumber,String classType) {
		// FIRST-CLASS BUSINESS ECONOMY
		int booked=0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(seat.passport_number) "
					+ "from seat "
					+ "where seat.flight_number= ? and class=? ";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,flightNumber);
			ps.setString(2, classType);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				booked=rs.getInt("count(seat.passport_number)");
				
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
		
		return booked;
	}
	
	//manager page 获得当前航班的乘客名单
	public ArrayList<String> getPassengerListofTheFlight(String flightNumber) {
		ArrayList<String> list=new ArrayList<>();
		
		String sql;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		sql = "select passport_number,position,class " + 
				" from seat " + 
				" where seat.passport_number in"
				+ " (select book.passport_number"
				+ " from book "
				+ "where book.flight_number= ? )";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, flightNumber);
			
			rs=ps.executeQuery();
			
			while (rs.next()) {
				String passport=rs.getString("passport_number");
				String pos=rs.getString("position");
				String theclass=rs.getString("class");
				
				String info="ID:"+passport+" POS:"+pos+" CLASS:"+theclass;
				list.add(info);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != ps) {
				try {
					ps.close();
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}
		return list;
	}
	
	//manager page 更改航班状态（1.cancel 0.available）
	public void modifiedFlightState(String flightNumber,int state) {

		String sql;
		PreparedStatement ps = null;
		sql = "update bookingticket.flight set isCancel= ? where flight_number= ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, state);
			ps.setString(2, flightNumber);
			
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
	
	//管理员增加航班
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
//----------------------------------------------------------------------------------------------
	
	//返回这个座位是否已经被预定
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
	
	//查询所有航班，并返回装有Flight对象的arraylist
	public ArrayList<Flight> getAllFlights() {
		ArrayList<Flight> flights=new ArrayList<>();
		
		try {
			String sql;
			sql = "SELECT flight_number,departure_city,arrival_city,departure_day,arrival_day,"+
					"departure_time,arrival_time,plane_type,company,isCancel" 
					+ " FROM flight";
			ResultSet rs;
			rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				String flightNumber = rs.getString("flight_number");
				String departure_city = rs.getString("departure_city");
				String arrival_city = rs.getString("arrival_city");
				
				Date departure_day = rs.getDate("departure_day");
				Date arrival_day = rs.getDate("arrival_day");
				Time departure_time = rs.getTime("departure_time");
				Time arrival_time = rs.getTime("arrival_time");
				
				String plane_type = rs.getString("plane_type");
				String company = rs.getString("company");
				int cancel=rs.getInt("isCancel");
				//--------------------------------------
				String departureDay=departure_day.toString();
				String arrivalDay=arrival_day.toString();
				String departureTime=departure_time.toString();
				String arrivalTime=arrival_time.toString();
				//------------------------------------------
				Flight f=new Flight(flightNumber,departure_city,arrival_city,departureDay,
						arrivalDay,departureTime,arrivalTime,plane_type,company,cancel);
	            flights.add(f);
			}
			// 完成后关闭
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flights;
	}
}
