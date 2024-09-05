package mofify;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import stmt.AddStdInfo.AddStudent;
import stmt.DaoFiles.DataStore;

import java.io.IOException;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/modify")
public class DeleteAndUpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//get which i want to do (Delete or update)....
		String operation=request.getParameter("operation");
		System.out.println(operation);
		
		//get user input 
		AddStudent AddStd =new AddStudent();
		AddStd.setReg_no(request.getParameter("reg"));		
		//creating object of  Jdbc class..
		DataStore info =new DataStore();
		
		//For delete operation...
		if ("Delete".equals(operation)) {
			
			String msg=null;
			if(info.deleteStudent(AddStd)) {
				//if its success to delete detail
				msg="Successfully deleted....!";
			}else {
				//if its fail to delete information
				msg="Oops! some things want wrong...";
			}
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("modification.jsp").forward(request, response);
		}
		
		//for display operation....
		if("Display".equals(operation)) {
			
			//fetch student information form sql
			 info.getInfoFromSQl(AddStd);				
			
			 //set attribute so that we can display it in display.jsp file
			request.setAttribute("StdDisplay", AddStd);
			//forward response to display.jsp file 
			request.getRequestDispatcher("display.jsp").forward(request, response);
		}
		if("Update".equals(operation)) {
			
		}
		
	}

}
