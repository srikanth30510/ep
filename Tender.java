package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Data;
import Model.Logic;

/**
 * Servlet implementation class Tender
 */
@WebServlet("/Tender")
public class Tender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tender() {
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
		String uname=request.getParameter("name");
		String email=request.getParameter("email");
		String tendername=request.getParameter("tendername");
		String tendertype=request.getParameter("tendertype");
		String price=request.getParameter("price");
		 try
	        {
	        	Logic l=new Logic();
	        	d.setUsername(uname);
	        	d.setEmail(email);
	        	d.setName(tendername);
	        	d.setType(tendertype);
	        	d.setPrice(price);
//	         	l.insertProduct(d);
	        
	        	String ack=l.insertTender(d);
	        	if(ack=="Added successfully..")
	        	{
	        		response.sendRedirect("tenders.jsp");
	        	}
	        	
	        	
	        }
	        catch(Exception e)
	        {
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
