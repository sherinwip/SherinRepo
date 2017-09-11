package com.rest.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(path="/greeting")
	public Greet greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greet(counter.incrementAndGet(),
				String.format(template, name));
	}


	public static void main(String[] args) {

		GreetController controller = new GreetController();
		controller.addUser(2,"Bincy");

	}
	@RequestMapping(path="/createTable")
	public void createTable(){
		createTable();
	}

	@RequestMapping(path="/users",method=RequestMethod.POST)
	public User addUser(@RequestParam int id,@RequestParam String username) {
		System.out.println("value are "+id+"and"+username);
		Connection conn =null;
		ArrayList<Statement> statements = new ArrayList<Statement>();
		PreparedStatement psInsert;
		PreparedStatement psUpdate;
		Statement s;
		ResultSet rs=null;
		User user=new User();

		try {
			//DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
			conn = createDerbyConnection();
			s = conn.createStatement();
			//s.execute("drop table users");
			//createUserTable(statements, s);
			addUserToDb(conn, statements,id,username);
			rs = s.executeQuery("select userid,username from users");
			System.out.println("resultset "+rs);
			while(rs.next()){
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				System.out.println("Value ="+rs.getInt(1));
				System.out.println("Value ="+rs.getString(2));
			}
			
			
			System.out.println("Dropped table location");
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


	private void addUserToDb(Connection conn, ArrayList<Statement> statements,int id,String username) throws SQLException {
		PreparedStatement psInsert;
		psInsert=conn.prepareStatement("insert into users values (?,?)");
		statements.add(psInsert);
		psInsert.setInt(1, id);
		psInsert.setString(2,username);
		int rowsupdated =psInsert.executeUpdate();
		System.out.println("No of rows inserted"+rowsupdated);
		System.out.println("user added successfully");
	}


	private void createUserTable(ArrayList<Statement> statements, Statement s) throws SQLException {
		statements.add(s);
		s.execute("create table users(userid int,username varchar(40))");
		System.out.println("User table created successfuly");
	}


	private Connection createDerbyConnection() throws SQLException {
		Connection conn;
		conn = DriverManager.getConnection("jdbc:derby:TestAppDB;create=true");

		System.out.println("Connection value is "+conn);
		conn.setAutoCommit(true);
		return conn;
	}

}	
