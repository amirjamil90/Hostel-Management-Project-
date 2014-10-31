<html>
<body>
<%@ page import = "java.sql.*" %>

<%
	String rollno = request.getParameter("txtrno");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","1234");
	PreparedStatement st = con.prepareStatement("Select * from Student1 where rollno = ?");
	st.setString(1,rollno);
	ResultSet rs = st.executeQuery();
	if(rs.next())
	{
%>

<table border = '1'>
	<tr>
		<td>Name:</td>	<td><%=rs.getString(1)%></td>
	</tr>
	<tr>
		<td>Roll No:</td>	<td><%=rs.getString(2)%></td>
	</tr>
</table>

<%
	}
	else
		out.println("Record Not Found");
%>

<br><a href = 'index.html'>Home</a>
</body>
</html>