package database;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Types;
import java.util.ArrayList;
import system.Flight;
import system.Passenger;
import system.Ticket;
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
	// 是否已经添加过该乘客
	public boolean alreadyAddPassenger(String passport) {
		boolean inDB = false;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql;
			sql = "SELECT count(*) FROM bookingticket.passenger where passport_number=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, passport);
			rs = ps.executeQuery();

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				int i = rs.getInt("count(*)");
				if (i > 0) {
					inDB = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	// 生成一个ticket
	public void generateTicket(String ticket, String flight, String passport, String baggage, String theclass) {
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

	// 生成一个booking
	public void passengerBookFlight(String passport, String flight) {

		String sql;
		PreparedStatement ps = null;
		sql = "insert into book(passport_number,flight_number,book_date) " + "values (?,?,current_date() )";
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

	// 增加一名乘客
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

	// get a flight by FlightNumber
	public Flight getFlightPickByCustomer(String number) {// book flight
		Flight f = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql;
			sql = "SELECT flight_number,departure_city,arrival_city,departure_day,arrival_day,"
					+ "departure_time,arrival_time,plane_type,company,isCancel,terminal1,terminal2" + " FROM flight "
					+ "where flight_number=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, number);
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
				int cancel = rs.getInt("isCancel");

				String t1 = rs.getString("terminal1");
				String t2 = rs.getString("terminal2");
				// --------------------------------------
				String departureDay = departure_day.toString();
				String arrivalDay = arrival_day.toString();
				String departureTime = departure_time.toString();
				String arrivalTime = arrival_time.toString();
				// ------------------------------------------
				f = new Flight(flightNumber, departure_city, arrival_city, departureDay, arrivalDay, departureTime,
						arrivalTime, plane_type, company, cancel);
				f.setT1(t1);
				f.setT2(t2);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	// manager page 显示入座人数
	public int getSeatBookingNumber(String flightNumber, String classType) {
		// FIRST-CLASS BUSINESS ECONOMY
		int booked = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "select count(passport_number) " + "from seat " + "where seat.flight_number= ? and class=? ";
			ps = conn.prepareStatement(sql);

			ps.setString(1, flightNumber);
			ps.setString(2, classType);

			rs = ps.executeQuery();

			while (rs.next()) {
				booked = rs.getInt("count(passport_number)");

			}
			// -----------------------------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

	// manager page 获得当前航班的乘客名单
	public ArrayList<String> getPassengerListofTheFlight(String flightNumber) {
		ArrayList<String> list = new ArrayList<>();

		String sql;
		PreparedStatement ps = null;
		ResultSet rs = null;
		sql = "select passport_number,position,class " + " from seat natural join book " + " where flight_number= ? ";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, flightNumber);

			rs = ps.executeQuery();

			while (rs.next()) {
				String passport = rs.getString("passport_number");
				String pos = rs.getString("position");
				String theclass = rs.getString("class");

				String info = "ID:" + passport + " POS:" + pos + " CLASS:" + theclass;
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

	// manager page 更改航班状态（1.cancel 0.available）
	public void modifiedFlightState(String flightNumber, int state) {

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

	// 管理员增加航班
	public void addFlight(Flight f) {

		String sql;
		PreparedStatement ps = null;
		sql = "insert into flight(flight_number,departure_city,arrival_city,departure_day,arrival_day,"
				+ "departure_time,arrival_time,plane_type,company,isCancel,terminal1,terminal2) "
				+ "value (?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, f.getNumber());
			ps.setString(2, f.getDepartureCity());
			ps.setString(3, f.getArrivalCity());

			String day1 = f.getDepartureDay().replace('/', '-');
			String day2 = f.getArrivalDay().replace('/', '-');
			ps.setDate(4, Date.valueOf(day1));
			ps.setDate(5, Date.valueOf(day2));

			ps.setTime(6, Utility.strToTime(f.getDepartureTime()));
			ps.setTime(7, Utility.strToTime(f.getArrivalTime()));

			ps.setString(8, f.getPlaneType());
			ps.setString(9, f.getCompany());
			ps.setInt(10, 0);
			ps.setString(11, randomTerminal());
			ps.setString(12, randomTerminal());

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

	private String randomTerminal() {
		int i = (int) (Math.random() * 10);
		return "T" + i;
	}
//--------------------------MY BOOKING-------------------------------------------------------------

	//乘客取消航班预定
	public void cancelBooking(String ticketNo) {//TODO
		
	}
	
	//乘客付款
	public void payBill(String billNo) {
		String sql;
		PreparedStatement ps = null;
		sql = "update bill "
				+ "set ispaid = 1 , pay_date = current_date() "
				+ "where bill_number= ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, billNo);
		
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
	
	//乘客是否已经付款
	public boolean ifpaid(String billNo) {
		boolean paid=false;
		
		CallableStatement callableStatement = null;
		try {
			callableStatement = conn.prepareCall("{?=call if_paid(?)}");
			
			callableStatement.registerOutParameter(1, Types.INTEGER);
			callableStatement.setString(2,billNo);
			callableStatement.execute();
			
			int i=callableStatement.getInt(1);
			
			if(i==1) {
				paid=true;
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				callableStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return paid;
	}
	
	//获得乘客已经选中的座位 若返回‘NO’则未选中
	public String getSeatifAlreadyChoose(String flightNo,String pass) {
		String seat=null;
		
		CallableStatement callableStatement = null;
		try {
			callableStatement = conn.prepareCall("{?=call get_seat_if_booked(?,?)}");
			
			callableStatement.registerOutParameter(1, Types.VARCHAR);
			
			callableStatement.setString(2, flightNo);
			callableStatement.setString(3, pass);
			callableStatement.execute();
			
			seat=callableStatement.getString(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				callableStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return seat;
	}
	
	//customer choose a seat
	public void chooseSeat(String pos,String flightNo,String theClass,String passport) {
		String sql;
		PreparedStatement ps = null;
		sql = "update seat "
				+ "set isbooked = 1 , passport_number = ? "
				+ "where flight_number= ? and position = ? and class= ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, passport);
			ps.setString(2, flightNo);
			ps.setString(3, pos);
			ps.setString(4, theClass);

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

	// 增加额外行李额
	public void addBaggageAllowance(String ticketNo, String baggage) {
		CallableStatement callableStatement = null;
		try {
			callableStatement = conn.prepareCall("{call change_baggage_add(?,?)}");
			callableStatement.setString(1, ticketNo);
			callableStatement.setString(2, baggage);
			callableStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				callableStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 修改行李额
	public void changeBaggageAllowance(String ticketNo, String baggage) {
		CallableStatement callableStatement = null;
		try {
			callableStatement = conn.prepareCall("{call change_baggage(?,?)}");
			callableStatement.setString(1, ticketNo);
			callableStatement.setString(2, baggage);
			callableStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				callableStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 修改class
	public void changeClass(String ticketNo, String newClass) {
		CallableStatement callableStatement = null;
		try {
			callableStatement = conn.prepareCall("{call change_class(?,?)}");
			callableStatement.setString(1, ticketNo);
			callableStatement.setString(2, newClass);
			callableStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				callableStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 修改meal
	public void changeMeal(String ticketNo, String meal) {
		CallableStatement callableStatement = null;
		try {
			callableStatement = conn.prepareCall("{call change_meal(?,?)}");
			callableStatement.setString(1, ticketNo);
			callableStatement.setString(2, meal);
			callableStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				callableStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 根据Ticket number返回一个ticket对象
	public Ticket getTicketFromTicketNo(String ticketNo) {
		Ticket t = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "select * " + " from ticket" + " where ticket_number = ? ;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ticketNo);
			rs = ps.executeQuery();

			while (rs.next()) {
				String passport = rs.getString("passport_number");
				String flight = rs.getString("flight_number");
				String baggage = rs.getString("baggage_allowance");
				String meal = rs.getString("special_meal");
				String theclass = rs.getString("class");

				t = new Ticket(ticketNo, passport, flight, baggage, meal, theclass);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return t;
	}

	// 返回这个座位是否已经被预定
	public boolean getSeatAvailableState(String position, String flightNumber,String theClass) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean isAvailable = true;
		try {
			String sql = "select isbooked "
					+ "from seat "
					+ "where position = ? and flight_number = ? and  class = ? ;";
			ps = conn.prepareStatement(sql);

			ps.setString(1, position);
			ps.setString(2, flightNumber);
			ps.setString(3, theClass);

			rs = ps.executeQuery();

			while (rs.next()) {
				int i = rs.getInt("isbooked");
				if (i == 1) {
					isAvailable = false;
					return false;
				}
			}
			// -----------------------------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

	// 调用存储过程查询订单（预定编号和护照是否匹配）
	public boolean isBookingNumberAndPassportMatch(String passNo, String bookingNo) {
		boolean match = false;

		CallableStatement callableStatement = null;
		try {
			callableStatement = conn.prepareCall("{call is_ticket_and_passport_match(?,?,?)}");
			callableStatement.setString(1, bookingNo);
			callableStatement.setString(2, passNo);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.execute();

			int i = callableStatement.getInt("@outcome");

			if (i == 1) {
				match = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				callableStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return match;
	}

	// 根据Booking number返回Flight number
	public String getFlightNoFromBookingNo(String ticketNo) {
		String flightNo = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "select flight_number" + " from ticket" + " where ticket_number = ? ;";
			ps = conn.prepareStatement(sql);

			ps.setString(1, ticketNo);

			rs = ps.executeQuery();

			while (rs.next()) {
				flightNo = rs.getString("flight_number");
			}
			// -----------------------------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

		return flightNo;
	}

//-----------------------------------------------------------------------------------------------
	// 查询所有航班，并返回装有Flight对象的arraylist
	public ArrayList<Flight> getAllFlights() {
		ArrayList<Flight> flights = new ArrayList<>();

		try {
			String sql;
			sql = "SELECT flight_number,departure_city,arrival_city,departure_day,arrival_day,"
					+ "departure_time,arrival_time,plane_type,company,isCancel" + " FROM flight";
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
				int cancel = rs.getInt("isCancel");
				// --------------------------------------
				String departureDay = departure_day.toString();
				String arrivalDay = arrival_day.toString();
				String departureTime = departure_time.toString();
				String arrivalTime = arrival_time.toString();
				// ------------------------------------------
				Flight f = new Flight(flightNumber, departure_city, arrival_city, departureDay, arrivalDay,
						departureTime, arrivalTime, plane_type, company, cancel);
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
