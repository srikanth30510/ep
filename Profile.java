package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Data;
import Model.Logic;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Data d=new Data();
		d.setUsername(request.getParameter("uname"));
		d.setPassword(request.getParameter("pwd"));
		Logic l=new Logic();
		try
		{
		if(l.profile(d)==true)
		{
//			String loggedInUserId = "uname";
//			HttpSession session = request.getSession();
//			session.setAttribute("loggedInUserId", loggedInUserId);
		    RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
		    request.setAttribute("name", request.getParameter("uname"));
		    rd.forward(request, response);  
		    System.out.println("success");
//		    RequestDispatcher rd1=request.getRequestDispatcher("buy.jsp");
//		    request.setAttribute("name", request.getParameter("uname"));
//		    rd1.forward(request, response);
		    System.out.println(request.getParameter("uname"));
		}
		}
		catch(Exception e)
		
		{
			pw.print("hi");
			pw.print(e.getMessage());
		}	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
