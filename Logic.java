package Model;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.protobuf.Message;

//import org.omg.CORBA.Request;

public class Logic {

	public boolean UserLogin(Data data)throws Exception{
		String dburl = "jdbc:mysql://localhost:3306/ep1";
		String dbun = "root";
		String dbpw = "Sri@8919224273";
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(dburl, dbun,dbpw);
		ps = con.prepareStatement("select count(*) from userlogin where username = ? and password = ?");
		String susername=data.getUsername();
		String spassword=data.getPassword();
		ps.setString(1, susername);
		ps.setString(2, spassword);
		rs = ps.executeQuery();
		if(rs.next())
		{
			if(rs.getInt(1) == 1)
			{
				Data d=new Data();
				d.setUsername(susername);
				return true;
			}
			else
			{	
				return false;
			}
		}
		return false;
		
		}
	public boolean profile(Data d)throws Exception{
		String dburl = "jdbc:mysql://localhost:3306/ep1";
		String dbun = "root";
		String dbpw = "Sri@8919224273";
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println();
		con = DriverManager.getConnection(dburl, dbun,dbpw);
		ps = con.prepareStatement("select count(*) from userlogin where username = ?");
		String susername=d.getUsername();
		System.out.println(susername);
		ps.setString(1, susername);
		System.out.println(susername);
		rs = ps.executeQuery();
		if(rs.next())
		{
			if(rs.getInt(1) == 1)
			{
				
				return true;
			}
			else
			{	
				return false;
			}
		}
		return false;
	}
	public boolean AdminLogin(Data data)throws Exception{
		String dburl = "jdbc:mysql://localhost:3306/ep1";
		String dbun = "root";
		String dbpw = "Sri@8919224273";
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(dburl, dbun,dbpw);
		ps = con.prepareStatement("select count(*) from adminlogin where username = ? and password = ?");
		String susername=data.getUsername();
		String spassword=data.getPassword();
		ps.setString(1, susername);
		ps.setString(2, spassword);
		rs = ps.executeQuery();
		if(rs.next())
		{
			if(susername=="Srikanth" && spassword=="123")
			{
				return true;
			}
			else
			{	
				return false;
			}
		}
		return false;
		
		}
	public String insertProduct(Data d)throws Exception{
		String dburl = "jdbc:mysql://localhost:3306/ep1";
		String dbun = "root";
		String dbpw = "Sri@8919224273";
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(dburl, dbun,dbpw);
		ps = con.prepareStatement("insert into additem values(?,?,?,?,?,?)");
		int sid=d.getId();
		String sname=d.getName();
		String stype=d.getType();
		String sprice=d.getPrice();
		String scompany=d.getCompany();
		byte[] sphoto=d.getPhoto();
		ps.setInt(1, sid);
		ps.setString(2, sname);
		ps.setString(3, stype);
		ps.setString(4, sprice);
		ps.setString(5, scompany);
		ps.setBytes(6, sphoto);
		ps.executeUpdate();
		System.out.println(sid+""+sphoto);
		return "Added successfully..";
		
	}
	public String insertTender(Data d)throws Exception{
		String dburl = "jdbc:mysql://localhost:3306/ep1";
		String dbun = "root";
		String dbpw = "Sri@8919224273";
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(dburl, dbun,dbpw);
		ps = con.prepareStatement("insert into tender values(?,?,?,?,?)");
		String uname=d.getUsername();
		String email=d.getEmail();
		String tendername=d.getName();
		String tendertype=d.getType();
		String price=d.getPrice();
		ps.setString(1, uname);
		ps.setString(2, email);
		ps.setString(3, tendername);
		ps.setString(4, tendertype);
		ps.setString(5, price);
		ps.executeUpdate();
		return "Added successfully..";
	}
		
		
		
		
		
		
		
		
		
	public List<Data> getall()throws Exception{
		String dburl = "jdbc:mysql://localhost:3306/ep1";
		String dbun = "root";
		String dbpw = "Sri@8919224273";
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(dburl, dbun,dbpw);
		ps=con.prepareStatement("select * from additem");
		rs = ps.executeQuery();
		List<Data> L = new ArrayList<Data>();
		while(rs.next())
		{
			
			Data d=new Data();
			d.setId(rs.getInt(1));
			d.setName(rs.getString(2));
			d.setType(rs.getString(3));
			//d.setPrice(rs.getString(4));
			d.setCompany(rs.getString(5));
			L.add(d);
			
		}
		return L;
		
	}
	public boolean insertData (Data d) throws Exception
	 {
			String dburl = "jdbc:mysql://localhost:3306/ep1";
			String dbun = "root";
			String dbpw = "Sri@8919224273";
			Connection con =null;
			PreparedStatement ps = null;
			ResultSet rs = null;
	    try {
	    con = DriverManager.getConnection(dburl, dbun,dbpw);
	    ps=con.prepareStatement("insert into userlogin values(?,?,?)");
	    String sid=d.getUsername();
	    String sname=d.getName();
	    String spwd=d.getPassword();
	    ps.setString(1, sid);
	    ps.setString(2, sname);
		ps.setString(3, spwd);
	    ps.executeUpdate();
	    return true;
	    }
	    catch(Exception e)
	    {
	      return false;
	    }
	  }
	
	
//	private static final String EMAIL_FROM = "srikanth891922@gmail.com"; // Change this to your email address
//    private static final String EMAIL_PASSWORD = "Strawberry@2025";
//    public static void sendVerificationLink(String recipientEmail, String verificationLink) {
//        Properties properties = System.getProperties();
//        properties.setProperty("mail.smtp.host", "smtp.example.com"); // Change this to your SMTP host
//        properties.setProperty("mail.smtp.port", "587"); // Change this to your SMTP port
//        properties.setProperty("mail.smtp.auth", "true");
//        Session session = Session.getInstance(properties, new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(EMAIL_FROM, EMAIL_PASSWORD);
//            }
//        });
//        
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(EMAIL_FROM));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
//            message.setSubject("Email Verification");
//            message.setText("Click the following link to verify your email: " + verificationLink);
//
//            Transport.send(message);
//            System.out.println("Verification link sent successfully!");
//        } catch (MessagingException ex) {
//            ex.printStackTrace();
//        }
//    }
	}

