import java.sql.*; 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class search extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try{  
			Class.forName("com.mysql.jdbc.Driver");   
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/student","root","ssn");  
 			
 			PreparedStatement ps = con.prepareStatement("select * from details where id = ?");
			ps.setString(1,request.getParameter("dbsearch"));
			ResultSet rs;
			rs = ps.executeQuery();
			if(rs.next()){
				out.println("<html>");
				out.println("<head><title>Display</title></head>");
				out.println("<body>");
				
				out.println("<br><label>Name:</label>" + rs.getString(2));
				out.println("<br><label>Roll No:</label>" + rs.getString(3));
				out.println("<br><label>branch:</label>" + rs.getString(4));
				out.println("<br><label>year:</label>" + rs.getInt(5));
				out.println("<br><label>sem:</label>" + rs.getString(6));
				out.println("<br><label>dob:</label>" + rs.getString(7));
				out.println("<br><label>address:</label>" + rs.getString(8));

				out.println("</body>");
				out.println("</html>");
			}
			
						// ps.setString(4,request.getParameter("branch"));
			// ps.setInt(5,Integer.parseInt(request.getParameter("year")));
			// ps.setString(6,request.getParameter("semester"));
			// SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			// Date dob = dateformat.parse(request.getParameter("dob"));
			// ps.setDate(7,new java.sql.Date(dob.getTime()));
			// ps.setString(8,request.getParameter("address"));
			// // DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			// // Date myDate = formatter.parse(date);
			// ps.execute();
			
			con.close();

		}

		catch(Exception e)
		{out.println("<h1>" + e + "</h1>");} 
	    	         
        
	}
} 