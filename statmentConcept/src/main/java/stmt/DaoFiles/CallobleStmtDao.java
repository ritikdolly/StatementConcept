package stmt.DaoFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;

import stmt.AddStdInfo.AddStudent;

public class CallobleStmtDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/statementconcepts";
		String user_name="root";
		String pwd="Ritik@2004!kr.";
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,user_name,pwd);
	}
	
	public boolean insertSutdents(AddStudent std){
		Connection con = null;
		CallableStatement st = null;
		boolean flag= false;
		String query1="{CALL studentInfo(?, ?, ?, ?, ?)}";
		
		try {
			con=CallobleStmtDao.getConnection();
			st =(CallableStatement) con.prepareCall(query1);
			st.setString(1, std.getName());
			st.setString(2, std.getReg_no());
			st.setString(3, std.getProg());
			st.setString(4, std.getBranch());
			st.setString(5, std.getBlood_grp());
			System.out.println("In Calloble Stmt...!");
			int val= st.executeUpdate();
			if(val == 1) {
				flag=true;
			}else {
				con.rollback();
				System.out.println("in Calloble Stmt else block");
			}
			System.out.println("in Calloble Stmt try-1..");
		}catch(Exception e) {
			e.printStackTrace();
			try {
				flag=false;
				con.rollback();
				System.out.println("in Calloble Stmt try-2..");
			}catch(SQLException e1) {
				e1.printStackTrace();
				System.out.println("in Calloble Stmt catch-1..");
			}
		}finally {
			try {
				if (st != null) st.close();  // Close the Statement
                if (con != null) con.close();  // Close the Connection
				System.out.println("in Calloble Stmt try-3..");
			}catch(Exception e3) {
				e3.printStackTrace();
				System.out.println("in Calloble Stmt catch-2..");
			}
		}
		
		return flag;		
	}
}
