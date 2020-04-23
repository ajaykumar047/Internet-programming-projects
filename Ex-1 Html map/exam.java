import java.sql.*; 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
public class exam extends HttpServlet 
{ 
String message,Reg_no,Name,ans1,ans2,ans3,ans4,ans5; int Total=0;
Connection connect;  
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException 
{ 
	try { 
		Class.forName("com.mysql.jdbc.Driver");   
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/exam","root",""); 
		} 
catch(ClassNotFoundException cnfex) { cnfex.printStackTrace(); } 
catch(SQLException sqlex) { sqlex.printStackTrace(); } 
catch(Exception excp) { excp.printStackTrace(); } 
Reg_no=request.getParameter("Reg_no"); 
Name=request.getParameter("Name"); 
ans1=request.getParameter("group1"); 
ans2=request.getParameter("group2"); 
ans3=request.getParameter("group3"); 
ans4=request.getParameter("group4"); 
ans5=request.getParameter("group5"); 
if(ans1.equals("True")) Total+=2; 
if(ans2.equals("False")) Total+=2; 
if(ans3.equals("True")) Total+=2; 
if(ans4.equals("True")) Total+=2; 
if(ans5.equals("False")) Total+=2; 
try { 
//Statement stmt=connect.createStatement(); 
//String query="INSERT into StudentTable VALUES ("+Seat_no+",'"+Name+"',"+Total+")";
//stmt.close();
PreparedStatement ps = connect.prepareStatement("INSERT into student VALUES ("+Reg_no+","+Name+","+Total+")");
			 } 
catch(SQLException ex) {ex.printStackTrace(); } 
response.setContentType("text/html"); 
PrintWriter out=response.getWriter(); 
out.println("<html>"); 
out.println("<body bgcolor=yellow>"); 
out.println("<h1>"+message+"</h1>\n"); 
out.println("<h3>DataBase Updated"); 
out.println("<br><br>"); 
out.println("<b>"+"The Student Database is as follows"); 
out.println("<table border=5>"); 
try { 
//Statement stmt=connect.createStatement(); 
//String query="SELECT * FROM StudentTable"; 
//rs=stm.executeQuery(query); 

PreparedStatement ps = connect.prepareStatement("select * from student");
ResultSet rs;
rs = ps.executeQuery();

out.println("<th>"+"Seat_no"+"</th>"); 
out.println("<th>"+"Name"+"</th>"); 
out.println("<th>"+"Marks"+"</th>"); 
while(rs.next()) 
{ out.println("<tr>"); 
out.println("<td>"+rs.getInt(1)+"</td>"); 
out.println("<td>"+rs.getString(2)+"</td>"); 
out.println("<td>"+rs.getInt(3)+"</td>"); 
out.println("</tr>"); } 
out.println("</table>");  
 
rs.close(); 
ps.close(); 
connect.close(); 
 
 
out.println("<center>"); 
out.println("<h1>Thanks!</h1>\n"); 
out.println("</center>"); 
out.println("</body></html>"); 
}
catch(SQLException sqlex) { sqlex.printStackTrace(); }
}
}
 
