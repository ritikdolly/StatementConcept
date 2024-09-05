package stmt.DaoFiles;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import stmt.AddStdInfo.AddStudent;

public class DataStore {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/statementconcepts";
		String user_name="root";
		String pwd="Ritik@2004!kr.";
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,user_name,pwd);
	}
	
	public boolean insertSutdent(AddStudent std){
		Connection con=null;
		Statement st=null;
		boolean flag=false;
		try {
			con=DataStore.getConnection();
			System.out.println("line1");
			con.setAutoCommit(false);
			System.out.println("line2");
			st = con.createStatement();
			System.out.println("line3");
			//calling data of user input....
			String name=std.getName();
			String reg=std.getReg_no();
			String prog=std.getProg();
			String branch=std.getBranch();
			String blood=std.getBlood_grp();			
			String sqlquery = "INSERT INTO student_detail  (Name, Reg_no, Prog, Branch, Blood_grp) VALUES ('"
	                    + name + "', " + reg + ", '" + prog + "', '" + branch + "', '" + blood + "');";
			System.out.println("line4");
            int data = st.executeUpdate(sqlquery);  // Execute the SQL query
            System.out.println("line5");
			if(data > 0) {
				System.out.println("Data is successfully inserted...!");
				con.commit();
				flag=true;	
			}else {
				con.rollback();
				System.out.println("else block");
			}
			System.out.println("in try-1..");
		}catch(Exception e) {
			e.printStackTrace();
			try {
				flag=false;
				con.rollback();
				System.out.println("in try-2..");
			}catch(SQLException e1) {
				e1.printStackTrace();
				System.out.println("in catch-1..");
			}
		}finally {
			try {
				if (st != null) st.close();  // Close the Statement
                if (con != null) con.close();  // Close the Connection
				System.out.println("in try-3..");
			}catch(Exception e3) {
				e3.printStackTrace();
				System.out.println("in catch-2..");
			}
		}
		
		return flag;		
	}
	public boolean deleteStudent(AddStudent inDelete) {
		Statement st=null;
		Connection con =null;
		boolean flag = false;
		try {
			con =DataStore.getConnection();
			con.setAutoCommit(false);
			st = con.createStatement();
			String reg= inDelete.getReg_no();
			String sqlQuery= "DELETE FROM student_detail WHERE (Reg_no = '"+ reg +"');";
			int data= st.executeUpdate(sqlQuery);
			if(data >0 ) {
				flag =true;
				con.commit();
			}else {
				con.rollback();
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
				flag=false;
			}catch(SQLException e2){
				e2.printStackTrace();
			}
		}
		finally {
			try {
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		
		return flag;
	}
	public void getInfoFromSQl(AddStudent AddStd) {
		Connection con=null;
		Statement st=null;
		try {
			con= DataStore.getConnection();
			con.getAutoCommit();//call the commit method on a stmt when it's completed
			st =con.createStatement();
			String reg =AddStd.getReg_no();
			System.out.println("in try block...");
			String sqlQuery= "SELECT * FROM student_detail where Reg_no='"+reg+"';";
			ResultSet rs = st.executeQuery(sqlQuery);
			while(rs.next()) {
				System.out.println(rs.getString("Name"));
				System.out.println(rs.getString("Prog"));
				System.out.println(rs.getString("Branch"));
				System.out.println(rs.getString("Blood_grp"));
				AddStd.setName(rs.getString("Name"));
				AddStd.setProg(rs.getString("Prog"));
				AddStd.setBranch(rs.getString("Branch"));
				AddStd.setBlood_grp(rs.getString("Blood_grp"));
	           
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(st != null)
					st.close();
				if (con != null)
					con.close();
			}catch(SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	pu

}
