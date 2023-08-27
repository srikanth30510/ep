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
import Model.Data1;
import Model.Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/GetItem")
public class GetItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	public void connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ep1";
        String username = "root";
        String password = "Sri@8919224273";
        
        connection = DriverManager.getConnection(url, username, password);
    }
	
	public List<Data1> getAllBlogs() throws SQLException {
        List<Data1> blogList = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM additem");

        while (resultSet.next()) {
          
            int id= resultSet.getInt("id");
            String name = resultSet.getString("name");
            String type = resultSet.getString("product_type");
            String price=resultSet.getString("price");
            String company= resultSet.getString("company_name");

            //tour blog = new tour(place,conyear,location,subject,pic);
            Data1 blog =new Data1(id,name,type,price,company);
            blogList.add(blog);
        }
        

        resultSet.close();
        statement.close();
        return blogList;
    }
   

}
