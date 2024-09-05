package stmt.CtrlFile;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import stmt.AddStdInfo.AddStudent;
import stmt.DaoFiles.CallobleStmtDao;
import stmt.DaoFiles.DataStore;

import java.io.IOException;

/**
 * Servlet implementation class StudentCtrl
 */
@WebServlet("/registor")
public class StudentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddStudent std =new AddStudent();
		std.setName(request.getParameter("name"));
		std.setReg_no(request.getParameter("regNo"));
		std.setProg(request.getParameter("prog"));
		std.setBranch(request.getParameter("branch"));
		std.setBlood_grp(request.getParameter("Bgrp"));
		System.out.println("in StudentCtrlfile....");
		String msg=null;
		//DataStore info =new DataStore();
		CallobleStmtDao  callStmt= new CallobleStmtDao();
		if(callStmt.insertSutdents(std)) {
			msg="Inserted Successfully...!";
		}else {
			msg="There is some Issue...!";
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("StudentInFO.jsp").forward(request, response);
	}

}
