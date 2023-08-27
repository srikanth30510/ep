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

import java.math.BigDecimal;
@WebServlet("/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddItem() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Data d=new Data();
		int id=Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
        String productType = request.getParameter("type");
        String price = request.getParameter("price");
        String companyName = request.getParameter("company");
        byte[] photo = request.getParameter("photo").getBytes();
        try
        {
        	Logic l=new Logic();
        	d.setId(id);
        	d.setName(name);
        	d.setType(productType);
        	d.setPrice(price);
        	d.setCompany(companyName);
        	d.setPhoto(photo);
//         	l.insertProduct(d);
        
        	String ack=l.insertProduct(d);
        	if(ack=="Added successfully..")
        	{
        		response.sendRedirect("dashboard.jsp");
        	}
        	
        	
        }
        catch(Exception e)
        {
        	pw.print(e.getMessage());
        }
		
		
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
